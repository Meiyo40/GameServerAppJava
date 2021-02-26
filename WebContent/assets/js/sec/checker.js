const pwd = document.getElementById("password");
const pwd2 = document.getElementById("passwordCheck");
const info = document.getElementById("info");

pwd.addEventListener("change", checkPwd());
pwd2.addEventListener("change", checkPwd());

function checkPwd() {
    if (pwd.value != pwd2.value) {
        info.innerHTML = "Password didnt match";
    }
}