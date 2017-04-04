/**
 * Created by ya.fang on 2017/1/9.
 */

 $(function () {
     //支持Enter键登录
     /* $.post('/login/userLogin', $("#loginForm").serialize(),function (res) {
      alert(res.location);
      });*/
     $(".login_btn").click(function () {
         $.ajax({
             cache: true,
             type: "POST",
             url: "/login/userLogin",
             data: $("#loginForm").serialize(),// 你的formid
             async: false,
             success: function (res) {
                 alert(res.data);
                 if (res.data.toString() == "OK") {
                     alert("111111");
                     self.location="/index";
                 } else {
                     alert(res.data);
                     self.location="/login";
                 }
             }
         });
     });

 });

