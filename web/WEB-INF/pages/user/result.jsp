<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.xu419.domain.Answer" %><%--
  Created by IntelliJ IDEA.
  User: 22948
  Date: 2017/11/29
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>答案</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/question.css" type="text/css">
</head>
<body background="${pageContext.request.contextPath}/img/bg.jpg">
<div class="formDiv">
    <%
        ArrayList list =  (ArrayList) request.getAttribute("list");
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            Object aList = list.get(i);
            Answer answer = (Answer) aList;
    %>
        <span class="stemDiv">  第<%=i+1%>题：<%=answer.getStem()%><br/></span>
        <div class="optionDiv">
            你的选择：<%=answer.getAnswer()%><br/>
            正确答案：<%=answer.getRightAnswer()%><br/>
            得分：<%=answer.getScore()%><br/>
        </div>

    <%
            result += answer.getScore();
        }
        out.print("总分"+result);
    %>
    <a href="${pageContext.request.contextPath}/index.html">退出</a>
</div>
</body>
</html>
