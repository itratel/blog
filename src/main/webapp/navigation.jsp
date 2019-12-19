<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<head>
    <title>success</title>
    <%
        String context = request.getContextPath();
    %>
</head>
<body>
<div class="author-nav">
    <img src="<%=context %>/img/avatar.jpg" alt="个人头像">
</div>
<div class="main-nav">
    <ul>
        <a href="<%=context %>/servlet/article?action=top3">
            <li>博客首页</li>
        </a>
        <a href="<%=context %>/list.jsp">
            <li>博客列表</li>
        </a>
        <a href="<%=context %>/servlet/user">
            <li>个人档案</li>
        </a>
        <a href="<%=context %>/message.jsp">
            <li>留言</li>
        </a>
        <a href="<%=context %>/servlet/article?action=page">
            <li>后台登陆</li>
        </a>
    </ul>
</div>
</body>
</html>
