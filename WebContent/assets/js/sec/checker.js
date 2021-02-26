const pwd = document.getElementById("password");
const pwd2 = document.getElementById("passwordCheck");
const info = document.getElementById("info");
const submit = document.getElementById("submit");

pwd.addEventListener("change", checkPwd());
pwd2.addEventListener("change", checkPwd());
submit.addEventListener("click", (e) => {
    if (!checkPwd()) {
        e.preventDefault();
    }
})

function checkPwd() {
    if (pwd.value != pwd2.value) {
        info.innerHTML = "Password didnt match";
        return false;
    } else {
        info.innerHTML = "";
        return true;
    }
}