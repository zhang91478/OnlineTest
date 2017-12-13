<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/checkUsers.js"></script>
<form method="post" action="${pageContext.request.contextPath}/app/addUser" id="addUsers" onsubmit="return checkUsers('addUsers')">
    <span>添加一个新用户</span><br/>
    <span>账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</span>
    <input name="account" title="请输入一个新的账号"><br/>
    <span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</span>
    <input name="name" title="请输入一个姓名"><br/>
    <span>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄</span>
    <input name="age" title="请数你年龄"><br/>
    <span>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</span>
    <select name="sex" title="请选择性别">
        <option value="">请选择性别</option>
        <option value="m">男生</option>
        <option value="w">女生</option>
    </select><br/>
    <span>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱</span>
    <input type="email" name="email" title="请输入邮箱"><br/>
    <span>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</span>
    <input type="password" name="password" title="请输入密码"><br/>
    <span>确认密码</span>
    <input type="password" name="checkPassword" title="请再次密码"><br/>
    <input type="submit" value="确认添加">
</form>

