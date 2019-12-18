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
    <script>
        // 点击分页按钮以后触发的动作
        function handlePaginationClick(new_page_index, pagination_container) {
            $("#postForm").attr("action", "<%=context %>/servlet/dispatcher?role=0&pageNum=" + (new_page_index + 1));
            $("#postForm").submit();
            return false;
        }

        $(function () {
            $("#News-Pagination").pagination(${result.total}, {
                items_per_page:${result.pageSize}, // 每页显示多少条记录
                current_page: ${result.curPage} -1, // 当前显示第几页数据
                num_display_entries: 3, // 分页显示的条目数
                next_text: "下一页",
                prev_text: "上一页",
                num_edge_entries: 2, // 连接分页主体，显示的条目数
                callback: handlePaginationClick
            });
        })
    </script>
</head>

<body style="background: #e2e2e2 url(<%=context %>/img/home.jpg) no-repeat fixed center;
        background-size: cover;">
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
    <div id="top">
        <div class="info">
            <div class="bg-title">
                殷豪 Blog
            </div>
            <div class="md-title">
                DEBUG THE WORLD
            </div>
        </div>
    </div>
    <div id="main">
        <form id="postForm" method="POST">
            <div class="container main-inner">
                <div class="row">
                    <div class="article-wrap col-md-10 col-md-offset-1 col-xs-12">
                        <c:forEach items="${result.dataList }" var="article">
                            <article class="index-article">
                                <div class="post-info">
                                    <h2>
                                        <a href="<%=context %>/servlet/dispatcher?role=2&id=${article.id}">${article.title }</a>
                                    </h2>
                                    <div class="post-detial">
                                        <span>${article.title}</span>
                                        <span>${fn:substring(article.date,0,10)}</span>
                                    </div>
                                </div>
                                <p>${article.subtitle }</p>
                                <center>
                                    <button class="more"><a
                                            href="<%=context %>/servlet/dispatcher?role=2&id=${article.id}"
                                            style="color: #000;">Read More</a></button>
                                </center>
                            </article>
                        </c:forEach>
                        <div id="News-Pagination"></div>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <jsp:include page="footer.jsp"/>
</div>
</body>

</html>