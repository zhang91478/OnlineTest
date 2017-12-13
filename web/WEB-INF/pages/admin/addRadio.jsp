<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/checkRadios.js"></script>
<form action="${pageContext.request.contextPath}/app/addRadio" id="addRadios" method="post" onsubmit="return  checkRadios('addRadios')">
    <span>题&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;干</span>
    <input type="text" name="stem" title="题干"><br/>

    <span>分&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数</span>
    <input type="text" name="score" title="分数"><br/>

    <span>正确&nbsp;&nbsp;&nbsp;选项</span>
    <input type="text" name="one" title="正确选项"><br/>

    <span>错误选项一</span>
    <input type="text" name="two" title="错误选项一"><br/>

    <span>错误选项二</span>
    <input type="text" name="three" title="错误选项二"><br/>

    <span>错误选项三</span>
    <input type="text" name="four" title="错误选项三"><br/>

    <span>所属&nbsp;&nbsp;课程</span>
    <select name="course" title="所属课程">
        <option value="">请选择所属课程</option>
        <option value="语文">语文</option>
        <option value="数学">数学</option>
        <option value="英语">英语</option>
        <option value="地理">地理</option>
        <option value="物理">物理</option>
        <option value="生物">生物</option>
        <option value="化学">化学</option>
    </select>
    <input type="submit" value="确认添加">
</form>

