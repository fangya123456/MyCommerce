/**
 * Created by ya.fang on 2017/1/17.
 */

$(function () {
    /*var num =Number($("input.startPage").val());
    var totalPage = Number($("input.totalPage").val());
    var pageNum = 5;
    //商品页数显示
    var showNumPage = '';
    for (var i=0; i<pageNum; i++){
        showNumPage += "<a href='/product?page="+ num +"'>"+"<span class='num'>"+ num +"</span></a>";
        if (num == totalPage) break;
        num++;
    }
    $("a.nextPage").before(showNumPage);*/
    $.get("/product/queryAllCategoryInfo",function (res) {
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
});