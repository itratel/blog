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
    <script type="application/javascript">

        /***
         * dom结构后加载评论
         **/
        $(function () {
            var aId = $('#articleId').val() || ${article.id};
            loadComments(aId);
        });

        function loadComments(aId) {
            $.ajax({
                type: "POST",
                async: true,
                url: "<%=context %>/servlet/message",
                dataType: "json",
                data: {
                    "action": "page",
                    "aId": aId
                },
                success: function (data) {
                    var content = data.dataList;
                    console.log(content);
                    if (content) {
                        renderMsg(content);
                    }
                },
                error: function () {
                    alert("请求失败");
                }
            });
        }

        function renderMsg(data) {
            var html = '';
            html +='<ul>';
            for (var i = 0; i < data.length; i++) {
                html +='<li>'+data[i].content+'</li>';
            }
            html +='</ul>';
            $('#show-comments').html(html);
        }

        /***
         * 增加评论
         */
        function addMsg() {
            var aId = $('#articleId').val();
            var content = $('#comment').val();
            $.ajax({
                type: "POST",
                async: true,
                url: "<%=context %>/servlet/message",
                dataType: "text",
                data: {
                    "action": "add",
                    "aId": aId,
                    "content": content
                },
                success: function (data) {
                    alert(data);
                    window.location.reload();
                },
                error: function () {
                    alert("请求失败");
                }
            });
        }
    </script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="navigation.jsp"/>
        <div id="wrap">
            <div id="main">
                <div class="container main-inner">
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2 col-xs-12">
                            <input id="articleId" type="hidden" value="${article.id}">
                            <div class="single-title"><h2>${article.title}</h2></div>
                            <div class="single-info">
                                殷豪发表于${fn:substring(article.date,0,10)}</div>
                            <div class="single-content">${article.htmlContent}</div>
                            <br>
                            <form>
                                <div id="show-comments" class="form-group" style="border: #0a001f">

                                </div>
                                <div class="form-group">
                                    <label for="comment">评论这篇文章:</label>
                                    <textarea class="form-control" rows="5" id="comment"></textarea>
                                    <input id="addComment" type="button" class="btn btn-sm btn-primary" style="float: right;" value="提交" onclick="addMsg()"/>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <jsp:include page="footer.jsp"/>
        </div>
    </div>
</div>
</body>
</html>