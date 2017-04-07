/**
 * Created by ya.fang on 2017/1/9.
 */

function createCode() {
    $.ajax({
        type: "GET",
        url: "/login/createCode",
        async: true,
        success: function (res) {
            alert(res.data);
            $("#checkCode").val(res.data);
        }
    });
}

 $(function () {
    //createCode();
     $("#updateCode")
     //支持Enter键登录
     $(".login_btn").click(function () {
         $.ajax({
             cache: true,
             type: "POST",
             url: "/login/userLogin",
             data: $("#loginForm").serialize(),// 你的formid
             async: false,
             success: function (res) {
                 if (res.data == 1) {
                     $.get("/index");
                     self.location = "/index";
                 } else {
                     alert(res.message);
                     self.location="/login";
                 }
             }
         });
     });

 });

