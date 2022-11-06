<!DOCTYPE html>
<html>
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>BUYSELL!</h1>
<h4>Товары со всей России</h4>
<form action="/" method="get">
    Поиск по названию лбьявления: <input type="text" name="title"><br>
    <input type="submit" value="Поиск">
</form>
<#list products as product>
    <div>
        <p>
            <b>   ${product.title} </b> ${product.price} | <a href="/product/${product.id}">Подробнее</a>
        </p>
    </div>
</#list>
<hr>
<h3>Создать новый продукт</h3>
<form action="/product/create" method="post" enctype="multipart/form-data">
    Названия обьявления: <input type="text" name="title"/><br><br>
    Описани обьявления: <input type="text" name="description"/><br><br>
    Цена обьявления: <input type="text" name="price"/><br><br>
    Город обьявления: <input type="text" name="city"/><br><br>
    Имя обьявления: <input type="text" name="author"/><br><br>
    Первая фотография: <input type="file" name="file1"/><br><br>
    Вторая фотография: <input type="file" name="file2"/><br><br>
    Третья фотография: <input type="file" name="file3"/><br><br>
    <input type="submit" value="Добавить товар">
</form>
</body>
</html>