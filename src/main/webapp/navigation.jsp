<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<head>
    <%
        String context = request.getContextPath();
    %>
</head>
<body>
<div id="left-nav" class="col-md-2">
    <div class="author-nav">
        <img src="<%=context %>/img/avatar.jpg" alt="个人头像">
    </div>
    <div class="main-nav">
        <ul>
            <a href="<%=context %>/servlet/article?action=top3">
                <li>博客首页</li>
            </a>
            <a href="<%=context %>/servlet/article?action=page&type=custom">
                <li>博客列表</li>
            </a>
            <a href="<%=context %>/servlet/user">
                <li>个人档案</li>
            </a>
            <a href="<%=context %>/servlet/article?action=page">
                <li>后台登陆</li>
            </a>
        </ul>
    </div>
</div>
</body>
</html>
