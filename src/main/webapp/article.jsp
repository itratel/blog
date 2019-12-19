<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>殷豪的博客</title>
    <%
        String context = request.getContextPath();
    %>
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"
          name="viewport">
    <link rel="shortcut icon" href="<%=context %>/img/favicon.ico"/>
    <link rel="stylesheet" href="<%=context %>/css/blog.css"/>
    <link rel="stylesheet" href="<%=context %>/css/page.css">
    <link rel="stylesheet" href="<%=context %>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=context %>/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=context %>/css/prism.css">
    <script src="<%=context %>/js/jquery.min.js"></script>
    <script src="<%=context %>/js/blog.js"></script>
    <script src="<%=context %>/js/bootstrap.min.js"></script>
    <script src="<%=context %>/js/prism.js"></script>
    <script>
        $(function () {
            $("#News-Pagination").pagination(${result.total}, {
                items_per_page:${result.pageSize}, // 每页显示多少条记录
                current_page: ${result.curPage} -1, // 当前显示第几页数据
                num_display_entries: 3, // 分页显示的条目数
                next_text: "下一页",
                prev_text: "上一页",
                num_edge_entries: 2, // 连接分页主体，显示的条目数
                callback: function (new_page_index) {
                    $("#postForm").attr("action", "<%=context %>/servlet/dispatcher?role=0&pageNum=" + (new_page_index + 1));
                    $("#postForm").submit();
                    return false;
                }
            });
        })
    </script>
</head>
<body>
<div id="bar" class="scrollbar"></div>
<div id="gotop"></div>
<div id="switch">
    <div id="iconfixed">
        <div class="icon"></div>
    </div>
</div>
<div id="left-nav">
    <jsp:include page="navigation.jsp"/>
</div>
<div id="wrap">
    <div id="main">
        <div class="container main-inner">
            <div class="row">
                <c:forEach items="${result.dataList }" var="article">
                    <div class="col-md-8 col-md-offset-2 col-xs-12">
                        <div class="single-title"><h2>${article.title }</h2></div>
                        <div class="single-info">
                            发表于${fn:substring(article.date,0,10)}</div>
                        <div class="single-content">${article.htmlContent }</div>
                        <br>
                    </div>
                </c:forEach>
                <div id="News-Pagination"></div>
            </div>
        </div>
    </div>
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>