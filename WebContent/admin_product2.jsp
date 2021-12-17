<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script data-require="jquery@3.1.1" data-semver="3.1.1"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/shop.css">
<link rel="stylesheet" href="css/add.css">
<title>TCS Administrator</title>
<link rel="icon"
	href="https://cdn-icons-png.flaticon.com/512/2120/2120197.png"
	type="image/x-icon">
</head>
<body>
	<style>
.col-md, .col-md-2, .col-md-3 {
	border: 1.5px solid black;
}

.row:hover {
	background: #f4f1de;
}
</style>
	<jsp:include page="navbar_admin.jsp"></jsp:include>
	<div class="container">
		<h2>list of product</h2>
		<div class="row">
			<div class="col-md" style="font-weight: bold;">#</div>
			<div class="col-md-2" style="font-weight: bold;">Name</div>
			<div class="col-md-2" style="font-weight: bold;">Price</div>
			<div class="col-md-3" style="font-weight: bold;">Description</div>
			<div class="col-md-2" style="font-weight: bold;">Category</div>
			<div class="col-md" style="font-weight: bold;">Update</div>
			<div class="col-md" style="font-weight: bold;">Remove</div>
		</div>
		<c:forEach var="item" items="${listProduct }">
			<form action="${pageContext.request.contextPath}/UpdateProduct">
				<div class="row">
					<div class="col-md">${item.id }</div>
					<div class="col-md-2">
						<input type="text" value="${item.getName() }"
							name="editName${item.id }" style="border: none; width: 100%" />
					</div>
					<div class="col-md-2">
						<input type="text" value="${item.getPriceCurrencyFormat() }"
							name="editPrice${item.id }" style="border: none;" form="my_form" />
					</div>
					<div class="col-md-3">
						<input type="text" value="${item.getDescription() }"
							name="editDescription${item.id }"
							style="border: none; width: 100%" />
					</div>
					<div class="col-md-2">
						<select name="editCategory${item.id }" id="" style="width: 100%">
							<option value="${item.category.id }">${item.category.name }</option>
							<c:forEach var="items" items="${listCategory }">
								<c:choose>
									<c:when test="${item.category.id != items.id }">
										<option value="${items.id }">${items.name }</option>
									</c:when>
								</c:choose>
							</c:forEach>
						</select>
					</div>
					<div class="col-md">
						<a href="UpdateProduct?pid=${item.id }">Update</a>
					</div>
					<div class="col-md">
						<a href="AdminProduct?pid=${item.id }">Remove</a>
					</div>
				</div>
			</form>
		</c:forEach>

	</div>
</body>
</html>