/**
 * Created by ya.fang on 2017/1/9.
 */

 $(function () {
     //支持Enter键登录
     /* $.post('/login/userLogin', $("#loginForm").serialize(),function (res) {
      alert(res.location);
      });*/
     $("#userLogin").click(function () {
         $.ajax({
             cache: true,
             type: "POST",
             url: "/loginPage/userLogin",
             data: $("#loginForm").serialize(),// 你的formid
             async: false,
             success: function (res) {
                if (res.data.equals("OK")){
                    alert(res.data);
                }else {
                    alert(res.data);
                }
             }
         });
     });

 });

