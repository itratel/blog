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
        <img src="../img/avatar.jpg" alt="个人头像">
    </div>
    <div class="main-nav">
        <ul>
            <a href="<%=context %>/servlet/article?action=page">
                <li>所有文章</li>
            </a>
            <a href="<%=context %>/admin/add.jsp">
                <li class="current">写文章</li>
            </a>
            <a href="<%=context %>/servlet/message?action=admin_page">
                <li>查看所有评论</li>
            </a>
            <a href="<%=context %>/servlet/article?action=top3">
                <li>返回首页</li>
            </a>
        </ul>
    </div>
</div>
</body>
</html>
