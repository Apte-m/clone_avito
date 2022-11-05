<!DOCTYPE html>
<html>
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>Hello, BUYSELL!</h1>
<#list products as product>
    <div>
        <p>
            <b>   ${product.title} </b> ${product.price} | <a href="/product/${product.id}">Подробнее</a>
        </p>
    </div>
</#list>
<hr>
<h3>Создать новый продукт</h3>
<form action="/product/create" method="post">
    Названия обьявления: <input type="text" name="title"/><br><br>
    Описани обьявления: <input type="text" name="description"/><br><br>
    Цена обьявления: <input type="text" name="price"/><br><br>
    Город обьявления: <input type="text" name="city"/><br><br>
    Имя обьявления: <input type="text" name="author"/><br><br>
    <input type="submit" value="Добавить товар">
</form>
</body>
</html>