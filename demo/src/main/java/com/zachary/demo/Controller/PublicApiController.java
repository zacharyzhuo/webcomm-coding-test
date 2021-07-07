package com.zachary.demo.Controller;

import java.io.IOException;
import java.util.Map;

import com.google.gson.Gson;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicApiController {

    @GetMapping("/public-api")
    public String callApi(Model model) throws IOException{

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            final String url = "https://gorest.co.in/public-api/users";
            final HttpGet get = new HttpGet(url);
            
            try (final CloseableHttpResponse response = httpClient.execute(get)) {
                if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                    
                }
                String jsonResponse = EntityUtils.toString(response.getEntity());

                final Gson gson = new Gson();
                final Map<String, Object> json = gson.fromJson(jsonResponse, Map.class);

                System.out.print(json.get("data"));
                model.addAttribute("results", json.get("data"));
            }
        }

        return "publicApi";
    }

}
