<%--
  Created by IntelliJ IDEA.
  User: 22948
  Date: 2017/11/30
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员！你好</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/manage.css" >
    <script type="text/javascript">
        function open(id){
            var obj = document.getElementById(id);
            obj.setAttribute("class","showAddDiv");

        }
        function close(id){
            var obj = document.getElementById(id);
            obj.setAttribute("class","hiddenAddDiv");
        }


    </script>
</head>
<body background="${pageContext.request.contextPath}/img/bg.jpg">
<div class="hiddenAddDiv" id="addUser" >
    <jsp:include page="/WEB-INF/pages/admin/addUser.jsp"/>
    <a href="javascript:close('addUser');">退出</a>
</div>

<div class="hiddenAddDiv" id="addRadio" >
    <jsp:include page="/WEB-INF/pages/admin/addRadio.jsp"/>
    <a href="javascript:close('addRadio');">退出</a>
</div>

<div class="topDiv">
    <a href="javascript:open('addUser')">添加用户</a>
    <a href="javascript:open('addRadio')">添加题目</a>
    <a href="${pageContext.request.contextPath}/adminLogin.html">退出</a>
</div>

<!--搜题-->
<div class="rightDiv">
    <form action="${pageContext.request.contextPath}/OnlineTest/showRadio" method="post">
        <input type="search" name="searchRadio" title="请输入查询内容">
        <input type="submit" value="查询题目">
    </form>
    <jsp:include page="${pageContext.request.contextPath}/OnlineTest/showRadio"/>
</div>
<div class="lefeDiv">
    <jsp:include page="${pageContext.request.contextPath}/OnlineTest/showUser"/>
</div>

</body>
</html>
