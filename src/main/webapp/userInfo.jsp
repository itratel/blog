<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8"/>
    <title>BLOG</title>
    <%
        String context = request.getContextPath();
    %>
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"
          name="viewport">
    <meta name="description" content="殷豪的个人主页"/>
    <link rel="shortcut icon" href="<%=context %>/img/favicon.ico"/>
    <link rel="stylesheet" href="<%=context %>/css/blog.css"/>
    <link rel="stylesheet" href="<%=context %>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=context %>/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=context %>/css/pagination.css">
    <script src="<%=context %>/js/jquery.min.js"></script>
    <script src="<%=context %>/js/blog.js"></script>
    <script src="<%=context %>/js/bootstrap.min.js"></script>
    <script src="<%=context %>/js/jquery.pagination.js"></script>
    <style type="text/css">
        a:link {
            text-decoration: none;
        }

        a:visited {
            text-decoration: none;
        }

        a:hover {
            text-decoration: none;
        }

        a:active {
            text-decoration: none;
        }
    </style>
</head>

<body>
<div id="switch">
    <div id="iconfixed">
        <div class="icon"></div>
    </div>
</div>
<div id="left-nav">
    <jsp:include page="navigation.jsp"/>
</div>
<div id="wrap">
    <div class="container main-inner">
        <form id="postForm" class="form-horizontal" role="form">
            <div class="form-group">
                <label for="img" class="control-label col-sm-1">个人头像</label>
                <img id="img" class="col-sm-4" src="<%=context%>${user.imgUrl}"
                     alt="用户头像" width="320px" height="320px">
            </div>
            <div class="form-group">
                <label for="name" class="control-label">用户名</label>
                <input type="text" class="form-control" id="name" value="${user.username}"
                            disabled="disabled">
            </div>
            <div class="form-group">
                <label for="sex" class="control-label">性别</label>
                <input type="text" class="form-control" id="sex" value="${user.sex}"
                           disabled="disabled">
            </div>
            <div class="form-group">
                <label for="email" class="control-label">邮箱</label>
                <input type="text" class="form-control" id="email" value="${user.email}"
                           disabled="disabled">
            </div>
            <div class="form-group">
                <label for="hobby" class="control-label">爱好</label>
                <input type="text" class="form-control" id="hobby" value="${user.hobby}"
                       disabled="disabled">
            </div>
        </form>
    </div>
    <jsp:include page="footer.jsp"/>
</div>
</body>

</html>