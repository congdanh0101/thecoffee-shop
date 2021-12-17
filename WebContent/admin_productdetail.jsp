<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script data-require="jquery@3.1.1" data-semver="3.1.1"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/shop.css">
<link rel="stylesheet" href="css/product_detail.css">
<script src="js/script.js"></script>
<script src="https://kit.fontawesome.com/4666aa241a.js"
	crossorigin="anonymous"></script>

<title>The Coffee Shop</title>
<link rel="icon"
	href="https://cdn-icons-png.flaticon.com/512/2120/2120197.png"
	type="image/x-icon">
</head>
<body>
	<jsp:include page="navbar_admin.jsp"></jsp:include>
	<div class="container" style="margin-top: 150px;">
		<form action="${pageContext.request.contextPath}/UpdateProduct"
			method="post">
			<div class="row">

				<div class="col">
					<img src="${product.image }" alt="" " style="width: 100%;">
				</div>

				<div class="col">
					<h2 style="color: black; font-size: 2rem; text-align: left;">
						<input type="text" value="${product.name }" name="name" style="width: 100%;" />
					</h2>
					<div class="clearfix"></div>
					<h3 style="font-weight: bold; font-size: 2rem; color: red;" >
						<input type="text" value="${product.getPriceCurrencyFormat() }"
							name="price" style="width: 100%;"/>
					</h3>
					<div class="clearfix"></div>
					<div class="product-description">
						<h3>description</h3>
						<textarea name="description" id="" cols="55" rows="5"
							style="font-size: 1.25rem;">${product.description }</textarea>
					</div>
					
					<div class="clearfix"></div>
					<div class="category">
						<h3>Category</h3>
						<select name="category" id=""
							style="font-size: 1.25rem; width: 50%;">
							<option value="${product.category.id }">${product.category.name }</option>
							<c:forEach var="items" items="${listCategory }">
								<c:choose>
									<c:when test="${product.category.id != items.id }">
										<option value="${items.id }">${items.name }</option>
									</c:when>
								</c:choose>
							</c:forEach>
						</select>
					</div>
					<input type="hidden" name="productId" value="${product.id}">
					<input type="submit" value="Update" name="addtocart"
						class="btn btn-primary btn-lg"
						style="margin-top: 2.25rem; width: 55%; font-size: 1.5rem;">
				</div>

			</div>
		</form>

	</div>
</body>

</html>