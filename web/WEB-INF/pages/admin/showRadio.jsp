<%@ page import="cn.xu419.domain.Radio" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.xu419.dao.DaoFactory" %><%--
  Created by IntelliJ IDEA.
  User: 22948
  Date: 2017/12/6
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>

    <title>在线答题系统</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/radio.css">
    <script type="text/javascript">

    </script>
</head>
<body>
<%
    String option = request.getParameter("searchRadio");
    if(option==null){
        option="";
    }
    List<Radio> list = DaoFactory.createRadioDao().findAllRadioBySomething(option);
    for (int i = 0; i < list.size(); i++) {
%>
<jsp:useBean id="radio" class="cn.xu419.domain.Radio" />
<jsp:setProperty
        name="radio" property="num" value="<%=list.get(i).getNum()%>"/>
<jsp:setProperty
        name="radio" property="stem" value="<%=list.get(i).getStem()%>"/>
<jsp:setProperty
        name="radio" property="score" value="<%=list.get(i).getScore()%>"/>
<jsp:setProperty
        name="radio" property="optionOne" value="<%=list.get(i).getOptionOne()%>"/>
<jsp:setProperty
        name="radio" property="optionTwo" value="<%=list.get(i).getOptionTwo()%>"/>
<jsp:setProperty
        name="radio" property="optionThree" value="<%=list.get(i).getOptionThree()%>"/>
<jsp:setProperty
        name="radio" property="optionFour" value="<%=list.get(i).getOptionFour()%>"/>
<jsp:setProperty
        name="radio" property="course" value="<%=list.get(i).getCourse()%>"/>
<div>
    <p class="stem">
        <%=i+1%>.<%=radio.getStem()%>(分值:<%=radio.getScore()%> 题型:<%=radio.getCourse()%>)
    </p>
    <p class="other">
        <span>题目编号</span><%=radio.getNum()%>
    </p>
    <p class="other">
        <span>正确选项：</span><%=radio.getOptionOne()%>
    </p>
    <p class="other">
        <span>错误选项一：</span><%=radio.getOptionTwo()%>
    </p>
    <p class="other">
        <span>错误选项二：</span><%=radio.getOptionThree()%>
    </p>
    <p class="other">
        <span>错误选项三：</span><%=radio.getOptionFour()%>
    </p>
    <a href="${pageContext.request.contextPath}/OnlineTest/updateRadio?num=<%=radio.getNum()%>">修改</a>
    <a href="${pageContext.request.contextPath}/app/delRadio?num=<%=radio.getNum()%>">删除</a>
</div>
<%
    }
%>
</body>
</html>