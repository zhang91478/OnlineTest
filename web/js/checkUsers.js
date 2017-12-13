function checkUsers(formId) {
    var form = document.getElementById(formId);
    var str = form.account.value;
    if(!str.match(/^[0-9]{3,}$/)){
        alert("请输入正确的账号");
        return false;
    }
    str = form.password.value;
    var str1 = form.checkPassword.value;
    if(!str.match(/^(\w){6,20}$/)){
        alert("密码格式不正确");
        return false;
    }
    if(str!==str1){
        alert("两次密码输入不一致");
        return false;
    }
    str = form.name.value;
    if(str.length===0||str===""){
        alert("请输入姓名");
        return false;
    }
    str = form.age.value;
    if(str>parseInt('100')||str<parseInt('5')){
        alert("请输入正确的年龄");
        return false;
    }
    str = form.sex.value;
    if(str.length===""){
        alert("请选择你的性别");
        return false;
    }
}