<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>后台登陆页面</title>
    <%
        String context = request.getContextPath();
    %>
    <link rel="shortcut icon" href="img/favicon.ico"/>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/login.css" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
</head>

<body>
<div id="main">
    <div class="container wrap">
        <div class="row col-md-4 col-md-offset-4">
            <form action="<%=context%>/servlet/login" method="post">
                <h2>控制台</h2>
                <input type="text" id="username" class="form-control" placeholder="用户名" name="username" required>
                <input type="password" id="password" class="form-control" placeholder="密码" name="password" required>
                <div class="img-wrap" >
                    <input type="text" id="verifyCode" class="form-control" placeholder="验证码" name="verifyCode"
                           required>
                    <img onclick="reloadCode()" src="<%=context%>/servlet/img" id="img"/>
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="submit" id="submit">登录</button>
            </form>
            <script>
                function reloadCode() {
                    $("#img").src = "/servlet/img?" + Math.random();
                }
            </script>
        </div>
    </div>
</div>
</body>

</html>