// js/index.js

// 當網頁載入完畢關閉讀取指示器條
$(document).ready(function () {
    // $('#loading').hide()
});

// index user tag
ts('.ts.dropdown:not(.basic)').dropdown();

// index logout
ts('#msg').message();
function showDimmer_logout() {
    ts('#closableModal_logout').modal("show")
}

// close message
ts('#msg').message()

ts('.ts.sortable.table').tablesort();

// $("#btn").on("click", function(e) {
//     e.preventDefault();

//     var result = "";
//     var my_name = $("#myName").val()
//     var values = {};
//     var total = 0;

//     $.each($("#productForm").serializeArray(), function(i, field) {
//         values[field.name] = field.value;
//     });

//     console.log(values)

//     result += my_name + "您好，您總共購買"

//     for(const [key, value] of Object.entries(values)) {
//         var product_name = $("#" + key + "_name").text();
//         var product_price = $("#" + key + "_price").text();
//         result += product_name + value + "顆、"
//         num = value * product_price
//         total += num
//     }
//     result += "總計" + total + "元。"

//     alert(result);
// });
