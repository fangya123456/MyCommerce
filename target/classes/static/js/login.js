/**
 * Created by ya.fang on 2017/1/9.
 */

    //支持Enter键登录
    function login_submit(){
       /* $.post('/login/userLogin', $("#loginForm").serialize(),function (res) {
            alert(res.location);
        });*/

    $.ajax({
        cache: true,
        type: "POST",
        url: "/login/userLogin",
        data: $("#loginForm").serialize(),// 你的formid
        async: false,
        dataType: "html",
        success: function (res) {
            alert(res);
        }
    });

}

