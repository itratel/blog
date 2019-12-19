<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>殷豪的博客</title>
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"
          name="viewport">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <link rel="shortcut icon" href="../img/favicon.ico"/>
    <link rel="stylesheet" href="../css/manage.css"/>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/pagination.css">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/blog.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/jquery.pagination.js"></script>
    <%
        String context = request.getContextPath();
    %>
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
        $(function () {
            $("#News-Pagination").pagination(${result.total}, {
                items_per_page:${result.pageSize}, // 每页显示多少条记录
                current_page: ${result.curPage} -1, // 当前显示第几页数据
                num_display_entries: 3, // 分页显示的条目数
                next_text: "下一页",
                prev_text: "上一页",
                num_edge_entries: 2, // 连接分页主体，显示的条目数
                callback: function (new_page_index) {
                    $("#postForm").attr("action", "<%=context %>/servlet/article?action=page&type=custom&pageNum=" + (new_page_index + 1));
                    $("#postForm").submit();
                    return false;
                }
            });
        })
    </script>
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="navigation.jsp"/>
        <div id="wrap">
            <div id="main">
                <form id="postForm" method="POST">
                    <div class="container main-inner">
                        <div class="jumbotron">
                            <h1>欢迎访问殷豪的个人博客</h1>
                            <p>这是一个博主本人自己的一些平时学习经验和大家交流的地方，欢迎大家参与评论！</p>
<%--                            <p><a class="btn btn-primary btn-lg" role="button">--%>
<%--                                学习更多</a>--%>
<%--                            </p>--%>
                        </div>
                        <div class="row">
                            <div class="article-wrap col-md-10 col-md-offset-1 col-xs-12">
                                <c:forEach items="${result.dataList}" var="article" varStatus="loop">
                                    <article class="index-article">
                                        <div class="post-info">
                                            <h2>
                                                <a href="<%=context %>/servlet/article?action=getOne&type=guest&id=${article.id}">${result.pageSize * (result.curPage - 1) + loop.count}.${article.title }</a>
                                            </h2>
                                            <div class="post-detial">
                                                <span>${article.title}</span>
                                                <span>殷豪发表于${fn:substring(article.date,0,19)}</span>
                                            </div>
                                        </div>
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
    </div>
</div>
</body>

</html>