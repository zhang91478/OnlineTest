function checkRadios(formId) {
    var form = document.getElementById(formId);
    var str = form.stem.value;
    if(str.length===0){
        alert("请输入题干");
        return false;
    }
    str = form.score.value;
    if(!(str<parseInt('20')&&str>parseInt('0'))){
        alert("请输入正确的分数，分数范围在1-20");
        return false;
    }
    str = form.one.value;
    if(str.length===0){
        alert("请输入正确答案");
        return false;
    }
    str = form.two.value;
    if(str.length===0){
        alert("请补全错误选项答案");
        return false;
    }
    str = form.three.value;
    if(str.length===0){
        alert("请补全错误选项答案");
        return false;
    }
    str = form.four.value;
    if(str.length===0){
        alert("请补全错误选项答案");
        return false;
    }
    str = form.course.value;
    if(str.length===0){
        alert("请选择所属课程");
        return false;
    }
    alert("确认提交");

    return true;

}