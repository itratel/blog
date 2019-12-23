<%@ page import="static com.yinhao.constant.Constants.USERNAME" %>
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
    <script>

        function deletePost(id) {
            if (confirm("你确定删除该评论？")) {
                $.ajax({
                    type: "POST",
                    async: true,
                    dataType: "text",
                    url: "<%=context %>/servlet/message",
                    data: {
                        "action": "delete",
                        "id": id
                    },
                    success: function (data) {
                        if (data === 'success'){
                            alert("删除成功！");
                        }
                        window.location.reload();
                    },
                    error: function () {
                        alert("请求失败");
                    }
                });
            }
        }

        $(function () {
            $("#News-Pagination").pagination(${result.total}, {
                items_per_page:${result.pageSize}, // 每页显示多少条记录
                current_page: ${result.curPage} -1, // 当前显示第几页数据
                num_display_entries: 3, // 分页显示的条目数
                next_text: "下一页",
                prev_text: "上一页",
                num_edge_entries: 2, // 连接分页主体，显示的条目数
                callback: function (new_page_index) {
                    $("#postForm").attr("action", "<%=context %>/servlet/message?action=admin_page&pageNum=" + (new_page_index + 1));
                    $("#postForm").submit();
                    return false;
                }
            });
        });
    </script>
</head>

<body>
<%
    if (session.getAttribute(USERNAME) == null) {
%>
<script type="text/javascript" language="javascript">
    alert("您还没有登录，请先登录");
    top.location.href = "../login.jsp";
</script>
<%
    }
%>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="../admin-navigation.jsp"/>
        <form id="postForm" method="POST">
            <div id="list" class="col-md-10 col-xs-12">
                <h3>管理</h3>
                <hr/>
                <!-- 后台返回结果为空 -->
                <c:if test="${fn:length(result.dataList) eq 0 }">
                    <span>查询的结果不存在</span>
                </c:if>
                <!-- 后台返回结果不为空 -->
                <c:if test="${fn:length(result.dataList) gt 0 }">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>文章标题</th>
                            <th>评论内容</th>
                            <th>评论人</th>
                            <th>评论时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${result.dataList }" var="message" varStatus="loop">
                        <tr>
                            <td><c:out value="${result.pageSize * (result.curPage - 1) + loop.count}"/></td>
                            <td><c:out value="${message.title }"/></td>
                            <td><c:out value="${message.content }"/></td>
                            <td><c:out value="${message.critics }"/></td>
                            <td><c:out value="${fn:substring(message.date,0,19)}"/></td>
                            <td>
                                <button type="button" class="btn btn-danger" onclick="deletePost(${message.id })">删除</button>
                            </td>
                        </tr>
                        </c:forEach>
                    </table>
                    <br>
                    <div id="News-Pagination" style="float: right"></div>
                </c:if>
            </div>
        </form>
    </div>
</div>
</body>

</html>