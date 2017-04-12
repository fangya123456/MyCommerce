/**
 * Created by dell-pc on 2017/4/12.
 */
$(document).ready(function(){
    //获取content对象里面，数据的数量
    var total_pages = parseInt($("input.totalPage").val());
    //计算页面显示的数量
    var number_of_pages = 5;

    //隐藏域默认值
    var navigation_html = '<a class="previous_page" href="javascript:previous();">上一页</a>';
    var current_page =parseInt($('#current_page').val());
    var start_page_num = 1;
    if (current_page > 4){
        start_page_num = start_page_num*number_of_pages;
    }
    for (var current_link=0; current_link<number_of_pages; current_link++){
        var show_page_num =  start_page_num+ current_link;
        navigation_html += "<a id='page_link' href='javascript:go_to_page("+ show_page_num +")'>"+"<span class='current_page_"+ show_page_num+ "'>"+ show_page_num +"</span></a>";
        if ( show_page_num == total_pages) break;
    }

    navigation_html += '<a class="next_page" href="javascript:next();">下一页</a>';

    $('.page_navigation').html(navigation_html);

    var _current_page_num = ".current_page_"+current_page;
    $(_current_page_num).css({"color":"red"});

});

//上一页
function previous(){
    var new_page = parseInt($('#current_page').val()) - 1;
    //if there is an item before the current active link run the function
    if(new_page > 0){
        go_to_page(new_page);
    }else {
        go_to_page(new_page+1)
    }

}
//下一页
function next(){
    var new_page = parseInt($('#current_page').val()) + 1;
    //if there is an item after the current active link run the function
    if(new_page<parseInt($("input.totalPage").val())+1){
        go_to_page(new_page);
    }else{
        go_to_page(new_page-1)
    }

}
//跳转某一页
function go_to_page(page_num){
    //跳转到某页
    window.open("/product?page="+page_num,"_self");
}