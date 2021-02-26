let interval = setInterval(intervalAdapt, 1000);
let screenSize = 0;

function intervalAdapt() {
    let actualSize = getWidth();
    if (screenSize == 0 || actualSize != screenSize) {
        const navbar = document.getElementById('navbar');
        const mainContainer = document.getElementById('main-container');
        if (navbar.offsetWidth > mainContainer.offsetWidth) {
            mainContainer.style.width = navbar.offsetWidth + 5;
        }
    }
    screenSize = actualSize;
}

function getWidth() {
    return Math.max(
        document.body.scrollWidth,
        document.documentElement.scrollWidth,
        document.body.offsetWidth,
        document.documentElement.offsetWidth,
        document.documentElement.clientWidth
    );
}