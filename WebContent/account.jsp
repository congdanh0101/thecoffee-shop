<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/shop.css">
<link rel="stylesheet" href="css/product_detail.css">
<link rel="stylesheet" href="css/cart.css">
<script src="https://kit.fontawesome.com/4666aa241a.js"
	crossorigin="anonymous"></script>
<title>The Coffee Shop</title>
<link rel="icon"
	href="https://cdn-icons-png.flaticon.com/512/2120/2120197.png"
	type="image/x-icon">
<script type="text/javascript" src="js/api.js"></script>
</head>
<body>
<body>
	<jsp:include page="navbar_shop.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<!-- panel preview -->

			<h2>Your information:</h2>
			<div class="panel-default">
				<div class="panel-body form-horizontal payment-form">
					<form action="account" method="post" name="info">
						<div class="form-group">
							<label for="concept" class="col-sm-4 control-label">Họ và
								Tên</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="fullName"
									name="fullName" required placeholder="Nguyễn Văn A"
									value="${customer.name }">
							</div>
						</div>
						<div class="form-group">
							<label for="description" class="col-sm-4 control-label">Email</label>
							<div class="col-sm-5">
								<input type="email" class="form-control" id="email" name="email"
									required placeholder="abc@gmail.com" readonly="readonly"
									value="${customer.email }">
							</div>
						</div>
						<div class="form-group">
							<label for="amount" class="col-sm-4 control-label">Số
								điện thoại</label>
							<div class="col-sm-5">
								<input type="number" class="form-control" id="phoneNumber"
									name="phoneNumber" required min="100000000" max="9999999999"
									placeholder="0123456789" value="${customer.phone }">
							</div>
						</div>
						<div class="form-group">
							<label for="status" class="col-sm-4 control-label">Địa
								chỉ</label>
							<div class="col-sm-5"
								style="display: inline-flex; justify-content: space-between;">
								<!-- <input type="text" class="form-control" id="address" name="address" required> -->
								<select name="city" id="" class="form-control" required
									style="width: 0%; display: none;">
									<option value="TPHCM">TPHCM</option>
									<!-- <option value="">3</option> -->
								</select> <select name="district" id="district" class="form-control"
									required style="width: 45%;" onchange="myFunction()">
									<option value="${customer.district}" selected>${customer.district }</option>
								</select> <select name="ward" id="ward" class="form-control" required
									style="width: 45%;">
									<option value="" selected>${customer.ward }</option>
								</select>

							</div>

						</div>
						<div class="form-group">
							<label for="status" class="col-sm-4 control-label"></label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="address"
									name="address" required placeholder="1 Quang Trung"
									value="${customer.address }">
							</div>
						</div>



						<div class="form-group">
							<div class="col-sm-9 text-right">


								<button type="submit"
											class="btn btn-default preview-add-button"
											onclick="noti()">
											<!-- <span class="fas fa-cart-plus"></span>  -->
											Update
										</button>

								<!-- <button type="submit" class=" btn btn-primary btn-block "
                                        style="width: 150px; padding: 5px 0; font-size: 1.5rem;">Submit
                                        all</button> -->
							</div>

						</div>



						<input type="hidden" name="cid" value="${customer.id }" />
						<script>
							function success() {
								alert("Cập nhật thành công!");
							}
							function failed() {
								alert("Vui lòng điền đủ thông tin!");
							}
							function noti(){
								var name = document.forms["info"]["fullName"].value;
								var phoneNumber = document.forms["info"]["phoneNumber"].value;
								var district= document.forms["info"]["district"].value;
								var ward =document.forms["info"]["ward"].value;
								var address= document.forms["info"]["address"].value;
								if(name =="" || phoneNumber==""||district==""||ward==""||address==""){
									alert("Vui lòng điền đủ thông tin!");
								}else{
									alert("Cập nhật thành công!");
								}
							}
						</script>
					</form>

				</div>
			</div>
		</div>

	</div>
	</div>
</body>
</body>

</html>

