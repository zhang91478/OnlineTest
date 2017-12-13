
function ckeckLogin(formId) {
    var form = document.getElementById(formId);
    var str1 = form.account.value;
    if(!str1.match(/^[0-9]{3,}$/)){
        alert("请输入正确的账号，账号由数字和英文字母组成");
        return false;
    }
    str1 = form.password.value;
    if(!str1.match(/^(\w){6,20}$/)){
        alert("密码格式错误请重新输入");
        return false;
    }
    return true;
}