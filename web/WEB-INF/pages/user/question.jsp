<%--
  Created by IntelliJ IDEA.
  User: 22948
  Date: 2017/11/29
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="cn.xu419.dao.DaoFactory" %>
<%@ page import="cn.xu419.domain.Radio" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.xu419.util.XMLtransverter" %>
<%--
  Created by IntelliJ IDEA.
  User: 22948
  Date: 2017/10/15
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线答题系统</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/question.css">
</head>
<body background="${pageContext.request.contextPath}/img/bg.jpg">
<div >
    <form action="${pageContext.request.contextPath}/app/checkResult" method="post" class="formDiv">
        <%
            List<Radio> list = DaoFactory.createRadioDao().getAllRadio();
            for (int i = 0; i < list.size(); i++) {
        %>
        <input type="hidden" name="amount" value="<%=list.size()%>">
        <jsp:useBean id="question" class="cn.xu419.domain.Radio" scope="page"/>
        <jsp:setProperty
                name="question" property="num" value="<%=list.get(i).getNum()%>"/>
        <jsp:setProperty
                name="question" property="stem" value="<%=list.get(i).getStem()%>"/>
        <jsp:setProperty
                name="question" property="score" value="<%=list.get(i).getScore()%>"/>
        <jsp:setProperty
                name="question" property="optionOne" value="<%=list.get(i).getOptionOne()%>"/>
        <jsp:setProperty
                name="question" property="optionTwo" value="<%=list.get(i).getOptionTwo()%>"/>
        <jsp:setProperty
                name="question" property="optionThree" value="<%=list.get(i).getOptionThree()%>"/>
        <jsp:setProperty
                name="question" property="optionFour" value="<%=list.get(i).getOptionFour()%>"/>
        <jsp:setProperty
                name="question" property="course" value="<%=list.get(i).getCourse()%>"/>
        <div class="stemDiv">
            <p>
                <%=i+1%>.<%=question.getStem()%>(分值:<%=question.getScore()%> 题型:<%=question.getCourse()%>)
            </p>

            <input type="hidden" name="<%="num"+i%>" value="<%=question.getNum()%>">
        </div>
        <div class="optionDiv">
            <input type="radio" name="<%="question"+i%>" id="one" value="<%=question.getOptionOne()%>"/>
            <label for="one">A.<%=question.getOptionOne()%></label><br/>
            <input type="radio" name="<%="question"+i%>" id="two" value="<%=question.getOptionTwo()%>"/>
            <label for="two">B.<%=question.getOptionTwo()%></label><br/>
            <input type="radio" name="<%="question"+i%>" id="three" value="<%=question.getOptionThree()%>"/>
            <label for="three">C.<%=question.getOptionThree()%></label><br/>
            <input type="radio" name="<%="question"+i%>" id="four" value="<%=question.getOptionFour()%>"/>
            <label for="four">D.<%=question.getOptionFour()%></label><br/>
        </div>
        <%
            }
        %>
        <input type="submit" value="提交答案">
    </form>
</div>
</body>
</html>
