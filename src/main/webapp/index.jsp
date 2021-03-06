﻿<%@ page contentType="text/html;charset=UTF-8" %>
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

<body style="background: #e2e2e2 url(<%=context %>/img/home.jpg) no-repeat fixed center;
        background-size: cover;">
<div class="container-fluid" >
    <div class="row">
        <jsp:include page="navigation.jsp"/>
        <div id="wrap">
            <div class="bg-title">
                201817020015 殷豪的博客
            </div>

            <div id="main">
                <form id="postForm" method="POST">
                    <div class="container main-inner">
                        <div class="row">
                            <div class="article-wrap col-md-10 col-md-offset-1 col-xs-12">
                                <c:forEach items="${list}" var="article" varStatus="status">
                                    <article class="index-article">
                                        <div class="post-info">
                                            <h2>
                                                <a href="<%=context %>/servlet/article?action=getOne&type=article_detail&id=${article.id}">${status.index + 1}.${article.title }</a>
                                            </h2>
                                            <div class="post-detial">
                                                <span>${article.title}</span>
                                                <span>殷豪发表于${fn:substring(article.date,0,19)}</span>
                                            </div>
                                        </div>
                                    </article>
                                </c:forEach>
                                <center>
                                    <button class="more"><a
                                            href="<%=context %>/servlet/article?action=page&type=custom"
                                            style="color: #000000;">Read More</a></button>
                                </center>
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