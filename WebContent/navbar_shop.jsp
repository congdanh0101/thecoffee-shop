<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
	
.cart-icon i {
    font-size: 25px;
    color: white;
}

.cart-icon::after {
    content: attr(data-totalitems);
    font-size: 24px;
    font-weight: 600;
    /* position: absolute; */
    top: 10px;
    right: 70px;
    background: #2bd156;
    line-height: 24px;
    padding: 0 5px;
    height: 24px;
    min-width: 24px;
    color: white;
    text-align: center;
    border-radius: 24px;
}

.cart-icon.shake {
    -webkit-animation: shakeCart .4s ease-in-out forwards;
    animation: shakeCart .4s ease-in-out forwards;
}

@-webkit-keyframes shakeCart {
    25% {
        -webkit-transform: translateX(10px);
        transform: translateX(10px);
    }
    50% {
        -webkit-transform: translateX(-4px);
        transform: translateX(-4px);
    }
    75% {
        -webkit-transform: translateX(2px);
        transform: translateX(2px);
    }
    100% {
        -webkit-transform: translateX(0);
        transform: translateX(0);
    }
}

@keyframes shakeCart {
    25% {
        -webkit-transform: translateX(10px);
        transform: translateX(10px);
    }
    50% {
        -webkit-transform: translateX(-4px);
        transform: translateX(-4px);
    }
    75% {
        -webkit-transform: translateX(2px);
        transform: translateX(2px);
    }
    100% {
        -webkit-transform: translateX(0);
        transform: translateX(0);
    }
}

</style>

<nav class="navbar-shop">
	<a href="index.html"> <img src="resource/img/2120197.png"
		alt="photo" class="logo" style="width: 75px; margin-top: 5px;">
	</a>
	<ul class="main_nav">
		<li><a href="${pageContext.request.contextPath}/home">Trang
				chủ</a></li>
		<!-- <li><a href="index.html#testimonial">Đánh giá</a></li>
		<li><a href="index.html#about">Về chúng tôi</a></li>
		<li><a href="index.html#contact">Liên hệ</a></li> -->
		<c:choose>
			<c:when test="${sessionScope.get('customer') == null }">
				<li><a href="login.jsp">Đăng nhập</a></li>
				<!-- <li><a href="login.jsp">Đăng ký</a></li> -->
			</c:when>
			<c:when test="${sessionScope.get('customer') !=null }">
				<li><c:choose>
						<c:when test="${sessionScope.get('size') != null }">
							<div class="cart-icon" id="cart-icon" data-totalitems="${size }">
								<a href="cart.jsp">Giỏ hàng <!-- <i class="fas fa-cart-plus"></i> -->
								</a>
							</div>
						</c:when>
						<c:otherwise>
							<div class="cart-icon" id="cart-icon" data-totalitems="0">
								<a href="cart.jsp">Giỏ hàng <!-- <i class="fas fa-cart-plus"></i> -->
								</a>
							</div>
						</c:otherwise>
					</c:choose></li>
				<li><a href="account.jsp">Tài khoản</a></li>
				<li><a href="logout">Đăng xuất</a></li>
			</c:when>
		</c:choose>

	</ul>
</nav>