package com.zachary.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zachary.demo.Dao.OrderDetailRepository;
import com.zachary.demo.Dao.MyOrderRepository;
import com.zachary.demo.Dao.ProductRepository;
import com.zachary.demo.Entity.MyOrder;
import com.zachary.demo.Entity.OrderDetail;
import com.zachary.demo.Entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MyOrderController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    MyOrderRepository myOrderRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @PostMapping("/buy")
    public String buy(@RequestParam Map<String, String> allParams, RedirectAttributes attr) {

        String username = allParams.remove("name");
        Boolean state = true;
        int total = 0;
        List<Product> productList = new ArrayList<>();
        List<Integer> amountList = new ArrayList<>();

        for(Map.Entry<String, String> entry : allParams.entrySet()) {
            Long productId = Long.parseLong(entry.getKey());
            int amount = Integer.parseInt(entry.getValue());
            Product product = productRepository.findById(productId).orElse(null);
            int inventory = product.getInventory();
            int price = product.getPrice();

            if(amount > inventory) {
                state = false;
                total = 0;
                myOrderRepository.save(new MyOrder(username, state, total));
                attr.addFlashAttribute("type", "negative");
                attr.addFlashAttribute("message", "庫存不足");
                return "redirect:/";
            }

            total += price * amount;
            productList.add(product);
            amountList.add(amount);
        }

        MyOrder newMyOrder = myOrderRepository.save(new MyOrder(username, state, total));
        myOrderRepository.flush();

        // 記得扣掉庫存
        for(int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            int amount = amountList.get(i);

            orderDetailRepository.save(new OrderDetail(newMyOrder, product, amount));
            product.setInventory(product.getInventory() - amount);
            productRepository.save(product);
        }

        attr.addFlashAttribute("type", "positive");
        attr.addFlashAttribute("message", "購買成功");

        return "redirect:/";
    }
    
}
