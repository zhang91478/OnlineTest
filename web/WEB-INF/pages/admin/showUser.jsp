<%@ page import="cn.xu419.domain.User" %>
<%@ page import="cn.xu419.dao.DaoFactory" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 22948
  Date: 2017/12/6
  Time: 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/user.css">
<%
    List<User> list =DaoFactory.createUserDao().getAllUser();
    for (int i = 0; i < list.size(); i++) {
        %>
<div>
    <p class="account">账户：<%=list.get(i).getAccount()%></p>
    <p class="other">昵称：<%=list.get(i).getName()%></p>
    <p class="other">年龄：<%=list.get(i).getAge()%></p>
    <p class="other">性别：<%=list.get(i).getSex()%></p>
    <p class="other">邮箱：<%=list.get(i).getEmail()%></p>
    <a href="${pageContext.request.contextPath}/OnlineTest/updateUser?account=<%=list.get(i).getAccount()%>&name=<%=list.get(i).getName()%>&age=<%=list.get(i).getAge()%>&sex=<%=list.get(i).getSex()%>&email=<%=list.get(i).getEmail()%>">修改</a>
    <a href="${pageContext.request.contextPath}/app/delUser?account=<%=list.get(i).getAccount()%>">删除</a>
</div>
        <%
    }

%>
