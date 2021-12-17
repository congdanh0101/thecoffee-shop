<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar-shop">
	<a href="index.html"> <img src="resource/img/2120197.png" alt="photo"
		class="logo" style="width: 75px; margin-top: 5px;">
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
				<li><a href="login.jsp">Đăng ký</a></li>
			</c:when>
			<c:when test="${sessionScope.get('customer') !=null }">
				<li>
					<div class="cart-icon" id="cart-icon">
						<a href="cart.jsp">Giỏ hàng <!-- <i class="fas fa-cart-plus"></i> -->
					</div> </a>
				</li>
				<li>
					<a href="account.jsp">Tài khoản</a>
				</li>
				<li>
					<a href="logout">Đăng xuất</a>
				</li>
			</c:when>
		</c:choose>

	</ul>
</nav>