<%@ page import="cn.xu419.domain.Radio" %>
<%@ page import="cn.xu419.dao.DaoFactory" %><%--
  Created by IntelliJ IDEA.
  User: 22948
  Date: 2017/12/7
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员你好</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/checkRadios.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/manage.css">
</head>
<body background="${pageContext.request.contextPath}/img/bg.jpg">
<%
    Radio radio = DaoFactory.createRadioDao().findRadioByNum(request.getParameter("num"));
%>

<div>
    <form action="${pageContext.request.contextPath}/app/updateRadio" method="post" class="showAddDiv" id="upradio" onsubmit="return checkRadios('upradio')">
        <span>题&nbsp;目&nbsp;编&nbsp;号</span>
        <input type="text" name="num" title="题干" readonly="readonly" value="<%=radio.getNum()%>" class="optionInput"><br/>
        <span>题&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;干</span>
        <input type="text" name="stem" title="题干" value="<%=radio.getStem()%>" class="optionInput"><br/>
        <span>分&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数</span>
        <input type="text" name="score" title="分数" value="<%=radio.getScore()%>"  class="optionInput" ><br/>
        <span>正&nbsp;确&nbsp;选&nbsp;项</span>
        <input type="text" name="one" title="正确选项" value="<%=radio.getOptionOne()%>" class="optionInput"><br/>
        <span>错误选项一</span>
        <input type="text" name="two" title="错误选项一" value="<%=radio.getOptionTwo()%>" class="optionInput"><br/>
        <span>错误选项二</span>
        <input type="text" name="three" title="错误选项二" value="<%=radio.getOptionThree()%>"  class="optionInput"><br/>
        <span>错误选项三</span>
        <input type="text" name="four" title="错误选项三" value="<%=radio.getOptionFour()%>"  class="optionInput"><br/>
        <span>所&nbsp;属&nbsp;课&nbsp;程</span>
        <select name="course" title="所属课程" >
            <option value="<%=radio.getCourse()%>">默认</option>
            <option value="语文">语文</option>
            <option value="数学">数学</option>
            <option value="英语">英语</option>
            <option value="地理">地理</option>
            <option value="物理">物理</option>
            <option value="生物">生物</option>
            <option value="化学">化学</option>
        </select>
        <input type="submit" value="确认修改">

    </form>
</div>

</body>
</html>
