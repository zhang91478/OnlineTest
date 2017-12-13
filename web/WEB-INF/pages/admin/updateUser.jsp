<%--
  Created by IntelliJ IDEA.
  User: 22948
  Date: 2017/12/7
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/checkUsers.js"></script>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/app/updateUser" id="upuser" onsubmit="return checkUsers('upuser')">
    <span>添加一个新用户</span><br/>
    <span>账  号</span>
    <input name="account" title="请输入一个新的账号" value="<%=request.getParameter("account")%>"><br/>
    <span>姓  名</span>
    <input name="name" title="请输入一个姓名" value="<%=request.getParameter("name")%>"><br/>
    <span>年  龄</span>
    <input name="age" title="请数你年龄" value="<%=request.getParameter("age")%>"><br/>
    <span>性  别</span>
    <select name="sex" title="请选择性别" >
        <option value="<%=request.getParameter("sex")%>">默认</option>
        <option value="m">男生</option>
        <option value="w">女生</option>
    </select><br/>
    <span>邮  箱</span>
    <input type="email" name="email" title="请输入邮箱" value="<%=request.getParameter("email")%>"><br/>
    <input type="submit" value="确认提交"/>
</form>
</body>
</html>
