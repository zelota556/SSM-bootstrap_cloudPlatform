<!DOCTYPE html>
<html  lang="en">
<head>
    <meta charset="utf-8">
    <base href="${pageContext.request.contextPath}/">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>User Login</title>
    <!--bootstrap.min.css-->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!--style.css-->
    <link rel="stylesheet" href="css/style.css">
    <!--jquery.js-->
    <script src="js/jquery-3.4.1.js"></script>
    <!--bootstrap.min.js-->
    <script src="js/bootstrap.min.js"></script>
    <!--bootstrap-show-password.min.js-->
    <script src="js/bootstrap-show-password.min.js"></script>
</head>

<body>
<!-- 登录 -->
<div class="container-fluid">
    <div class="row">
        <!-- 左 -->
        <div class="col-sm-6">
            <!-- 左侧图片 -->
            <div class="sign-bgleft">

            </div>
        </div>
        <!-- 右 -->
        <div class="col-sm-6">
            <div class="sign-content">
                <h2>Login</h2>
                <!-- 登录表单 -->
                <div class="signin-form">
                    <form id="userLoginInfo">
                    <div class="form-group">
                        <label>UserName</label>
                        <input type="text" name="userName" class="form-control" placeholder="Enter your username......">
                    </div>
                    <div class="form-group">
                        <label>Password</label>
                        <input type="password" name="password" id="password" class="form-control" placeholder="Enter your password......">
                    </div>
                    </form>
                </div>

                <!-- 记住密码 -->
                <div class="signin-password">
                    <div class="checkbox-list">
                        <ul class="list">
                            <li>
                                <input class="password-checkbox" type="checkbox">
                                <label for="label-checkbox">remember me!</label>
                            </li>
                            <li>
                                <a href="#">Forget?</a>
                            </li>

                        </ul>
                    </div>
                </div>

                <!-- 登录按钮 -->
                <div class="signin-footer">
                    <button type="button" class="btn signin_btn" onclick="login()">Login!</button>
                    <p>
                        Don't have an account? enroll one!
                        <a href="signup.html">Enroll</a>
                    </p>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
<script>
    $("#password").password({
    });
    $('#password').password('show');
    $('#password').password('hide');
</script>
<script type="text/javascript">
    function login() {
        $.ajax({
            url:'user/login',
            type:'post',
            async:false,     //设置同步才可保存、操作数据
            data:new FormData($("#userLoginInfo")[0]),
            cache:false,
            processData: false,   // jQuery不去处理发送的数据
            contentType : false,  //jQuery不去处理表头
            success: function (result) {
                if(result !=null && result.success){
                    alert("Login success!");
                    window.location = "${pageContext.request.contextPath}/"+"main";
                }
            else{
                    alert("tips:  "+result.message);
                }
            }
        })
    }
</script>

</html>