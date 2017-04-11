/**
 * Created by ya.fang on 2017/1/17.
 */

$(function () {

    var page = 1;
    var pageSize = 20;
    $.get("/product/queryAllProductInfo?page="+page+ "&pageSize=" + pageSize,function (res) {
        if (res.data != null){
            var categoryInfo = res.data;
            var showInfo = ''
            $.each(categoryInfo,function(key, item){
                var caInfo = "<dl><dt><a href='#'>" + key + "</a></dt>";
                var caseInfo = '';
                $.each(item, function (idx, val) {
                    caseInfo += "<dd><a href='#'>" + val.categorySecondName + "</a></dd>";
                });
                showInfo += caInfo + caseInfo + "</dl>";
            });
            $(".hotProductCategory").append(showInfo);
        }
    });




   /* $.get("/product/queryAllProductInfo?page="+page+ "&pageSize=" + pageSize,function (res) {
        if (res.data != null){
            var productList = res.data;
            var showInfo = ''
            $.each(productList,function(key, productInfo){
                var hrefElement = "<li><a href='"+"/product/detail?id="+ productInfo.id +">";
                var imgElement = "<img src='"+productInfo.image+"' width='170' height='170' style='display: inline-block;'/>";
                var spanElement_productName = "<span style='color:green'>"+productInfo.productName+"</span>";
                var spanElement_productShopPrice = "<span style='color:green'>"+productInfo.shopPrice+"</span>";
                showInfo += hrefElement+imgElement+spanElement_productName + spanElement_productShopPrice + "</li></a>";
            });
            $("div#result ul").append(showInfo);
        }
    });*/

});