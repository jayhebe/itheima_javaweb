var usernameFlag = false;
var passwordFlag = false;
var mobileFlag = false;

var objUsername = document.getElementById("username");
var regUsername = /^\w{6,12}$/;
var regPassword = /^\w{8,16}$/;
var regMobile = /^1\d{10}$/;

objUsername.onblur = function() {
    var username = objUsername.value.trim();

    if (!regUsername.test(username)) {
        console.log("用户名长度：" + username.length);

        document.getElementById("msg_username").innerHTML = "用户名不太受欢迎";
        usernameFlag = false;
    } else {
        document.getElementById("msg_username").innerHTML = "";
        usernameFlag = true;
    }
}

var objPassword = document.getElementById("password");
objPassword.onblur = function() {
    var password = objPassword.value.trim();

    if (!regPassword.test(password)) {
        console.log("密码长度：" + password.length);

        document.getElementById("msg_password").innerHTML = "密码不符合要求";
        passwordFlag = false;
    } else {
        document.getElementById("msg_password").innerHTML = "";
        passwordFlag = true;
    }
}

var objMobile = document.getElementById("mobile");
objMobile.onblur = function() {
    var mobile = objMobile.value.trim();

    if (!regMobile.test(mobile)) {
        console.log("手机号长度：" + mobile.length);
        console.log("手机号类型：" + (typeof mobile));

        document.getElementById("msg_mobile").innerHTML = "手机号不符合要求";
        mobileFlag = false;
    } else {
        document.getElementById("msg_mobile").innerHTML = "";
        mobileFlag = true;
    }
}

document.getElementById("register").onsubmit = function() {
    if (usernameFlag && passwordFlag && mobileFlag) {
        return true;
    } else {
        return false;
    }
}