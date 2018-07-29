document.getElementById('par').innerHTML = 'Введите число от 1 до 99';
document.getElementById('par').style.fontSize = '24px';

function myFunction() {
    var number, result;

    number = document.getElementById('number').value;

    if (isNaN(number) || number < 1 || number > 99) {
        result = 'Wrong number';
    } else result = 'Gooood';

    document.getElementById('result').innerHTML = result;
}

function changeImage() {
    var image = document.getElementById('image');

    const s = "d:/Me/Wallpapers.jpg/Other/Коммунистические плакаты/81.jpg";
    const s2 = "d:/Me/Wallpapers.jpg/Other/Коммунистические плакаты/80.jpg";
    image.src = image.src.match("80") ? s : s2;
}