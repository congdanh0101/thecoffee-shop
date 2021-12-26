<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="css/all.min.css"/>
    <link rel="stylesheet" href="css/login.css"/>

    <!-- Logo -->
    <title>The Coffee Shop</title>
    <link rel="icon" href="https://cdn-icons-png.flaticon.com/512/2120/2120197.png" type="image/x-icon">
</head>
<body>
<!-- partial:index.partial.html -->
<div class="container" id="container">
    <div class="form-container sign-up-container">
        <form id="singup" method="post" action="login">
            <input type="hidden" name="action" value="add">
            <h1>Đăng Ký</h1>
            <input type="email" name="email" placeholder="Email"/>
            <input type="password" name="password" placeholder="Mật Khẩu"/>
            <input type="password" name="confirmpassword" placeholder="Xác Nhận Mật Khẩu"/>
            <button type="submit" class=" btn1 btn-submit">Đăng Ký</button>
        </form>
    </div>
    <div class="form-container sign-in-container">
        <form method="post" action="login">
            <input type="hidden" name="action" value="signin">
            <h1>Đăng Nhập</h1>
            <input type="email" name="email" placeholder="Email"/>
            <input type="password" name="password" placeholder="Mật khẩu"/>
            <!-- <a href="reset_password">Quên mật khẩu ?</a> -->
            <button type="submit" id="btn2" class="btn2 btn-submit">Đăng Nhập</button>
            <c:if test="${not empty message}">
                <script>
                    window.addEventListener("load", function () {
                        alert("${message}");
                    })
                </script>
            </c:if>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>Xin chào !</h1>
                <p>Đăng nhập để nhận ưu đãi mỗi ngày</p>
                <button class="ghost" id="signIn">Đăng Nhập</button>
            </div>
            <div class="overlay-panel overlay-right">
                <h1>Đặt đồ uống tại The Coffee Shop</h1>
                <p>Siêu ưu đãi mỗi ngày</p>
                <button class="ghost" id="signUp">Đăng Ký Ngay</button>
            </div>
        </div>
    </div>
</div>

<!-- partial -->
<script src="js/login.js"></script>
</body>
</html>