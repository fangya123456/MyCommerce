/**
 * Created by ya.fang on 2017/1/17.
 */



/*<dl>
<dt>
<a href="#">蔬菜</a>
    </dt>
    <dd><a href="#">无公害蔬菜</a></dd>
    <dd><a href="#">特菜类</a></dd>
    <dd><a href="#">有机蔬菜</a></dd>
    <dd><a href="#">蔬菜套餐</a></dd>
    </dl>*/
$(function () {
    $.get("/product/queryAllCategoryInfo",function (res) {
        if (res.data != null){
            var categoryInfo = res.data;
            var showInfo = ''
            $.each(categoryInfo,function(key, item){
                var caInfo = "<dl><dt><a href='#'>" + key + "</a></dt>";
                var caseInfo = '';
                $.each(item, function (idx, val) {
                    caseInfo += "<dd><a href='#'>" + val.csname + "</a></dd>";
                });
                showInfo += caInfo + caseInfo + "</dl>";
            });

            $(".hotProductCategory").append(showInfo);
        }
    });

});