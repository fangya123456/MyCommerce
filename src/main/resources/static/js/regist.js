//jQuery 注册验证
$(function(){

    $(":input.text").blur(function(){
        //判断一下鼠标离开谁了
        if($(this).is("#username")){
            $(".formtip").remove();
            //按照用户名的规则去验证
            if(this.value==""||this.value.length<3){
                var errMsg = "<span class='formtip'>用户名至少是3个字母</span>";
                $(this).parent().append(errMsg);
                $(".formtip").css({"color":"red", "font-size":"14px"});
            }else {
                $.get('/regist/validateUsername?username='+ $("#username").val(), function (res) {
                   if(res.data==0){
                       var errMsg = "<span class='formtip'>用户名已注册！</span>";
                       $("#username").parent().append(errMsg);
                       $(".formtip").css({"color":"red", "font-size":"14px"});
                   }
                });
            }
        }

        if($(this).is("#password")){
            $(".passtip").remove();
            //按照密码的规则去验证
            if($(this).val() == "" || $(this).val()==null){
                var errMsg = "<span class='passtip'>密码需包含字母及数字</span>";
                $(this).parent().append(errMsg);
                $(".passtip").css({"color":"red", "font-size":"14px"});
            }
        }

        if($(this).is("#rePassword")){

            $(".repasstip").remove();
            if(this.value != $("#password").val()){
                var errMsg = "<span class='repasstip'>两次密码不一致</span>";
                $(this).parent().append(errMsg);
                $(".repasstip").css({"color":"red", "font-size":"14px"});
            }
        }

        //判断一下如果是email的话,应该按照email的规则去验证
        if($(this).is("#email")){
            $(".emailtip").remove();
            //按照email的规则去验证
            var reg = /^\w{1,}@\w+\.\w+$/;
            var $email = $("#email").val();
            if(!reg.test($email)){
                var errMsg = "<span class='emailtip'>邮箱不合法</span>";
                $(this).parent().append(errMsg);
                $(".emailtip").css({"color":"red", "font-size":"14px"});
            }else{
                $.get("/regist/validateEmail?email="+$("#email").val(),function (msg) {
                    if(msg.data==0){
                        var errMsg = "<span class='emailtip'>邮箱已注册！</span>";
                        $("#email").parent().append(errMsg);
                        $(".emailtip").css({"color":"red", "font-size":"14px"});
                    }
                });
            }
        }
    });


    $(".btn_submit").click(function () {

        $.ajax({
            cache: true,
            type: "POST",
            url: "/regist/insertUserInfo",
            data: $("#registerForm").serialize(),// 你的formid
            async: false,
            success: function (res) {
                if (res.data != null && res.data == 1) {
                    alert("请等待激活！");
                    self.location="/login";
                } else {
                    alert("注册失败！");
                    self.location="/regist";
                }
            }
        });
    });
});