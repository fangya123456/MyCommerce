/**
 * Created by ya.fang on 2017/1/17.
 */

$(function () {
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