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
    <link rel="icon" href="https://cdn-icons-png.flaticon.com/512/2120/2120197.png" type="image/x-icon">
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
                    <form action="account" method="post">
                        <div class="form-group">
                            <label for="concept" class="col-sm-4 control-label">Họ và Tên</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" id="fullName" name="fullName" required placeholder="Nguyễn Văn A" value="${customer.name }">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="description" class="col-sm-4 control-label">Email</label>
                            <div class="col-sm-5">
                                <input type="email" class="form-control" id="email" name="email" required placeholder="abc@gmail.com" readonly="readonly" value="${customer.email }">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="amount" class="col-sm-4 control-label">Số điện thoại</label>
                            <div class="col-sm-5">
                                <input type="number" class="form-control" id="phoneNumber" name="phoneNumber" required min="100000000" max="9999999999" placeholder="0123456789"
                                value="${customer.phone }">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="status" class="col-sm-4 control-label">Địa chỉ</label>
                            <div class="col-sm-5" style="display: inline-flex; justify-content: space-between;">
                                <!-- <input type="text" class="form-control" id="address" name="address" required> -->
                                <select name="city" id="" class="form-control" required style="width: 33%;">
                                    <option value="">Tỉnh/Thành</option>
                                    <option value="${customer.city }" autofocus="autofocus">${customer.city }</option>
                                    <option value="Hồ Chí Minh">Hồ Chí Minh</option>
                                    <!-- <option value="">3</option> -->
                                </select>
                                <select name="district" id="" class="form-control" required style="width: 33%;">
                                    <option value="">Quận/Huyện</option>
                                    <option value="Quận 1">Quận 1</option>
                                    <option value="">Quận 2</option>
                                    <option value="">Quận 3</option>
                                    <option value="">Quận 4</option>
                                    <option value="">Quận 5</option>
                                    <option value="">Quận 6</option>
                                    <option value="">Quận 7</option>
                                    <option value="">Quận 8</option>
                                    <option value="">Quận 9</option>
                                    <option value="">Quận 10</option>
                                    <option value="">Quận 11</option>
                                    <option value="">Quận 12</option>
                                    <option value="">Quận Gò Vấp</option>
                                    <option value="">Quận Phú Nhuận</option>
                                    <option value="">Quận Bình Thạnh</option>
                                    <option value="">Quận Bình Tân</option>
                                    <option value="">Quận Tân Bình</option>
                                    <option value="">Quận Tân Phú</option>
                                    <option value="">Quận Thủ Đức</option>
                                    <option value="">Huyện Bình Chánh</option>
                                    <option value="">Huyện Cần Giờ</option>
                                    <option value="">Huyện Củ Chi</option>
                                    <option value="">Huyện Hóc Môn</option>
                                    <option value="">Huyện Nhà Bè</option>
                                    
                                </select>
                                <select name="ward" id="" class="form-control" required style="width: 33%;">
                                    <option value="">Phường/Xã</option>
                                    <option value="Phường 1">Phường 1</option>
                                    <option value="">Phường 2</option>
                                    <option value="">Phường 3</option>
                                    <option value="">Phường 4</option>
                                    <option value="">Phường 5</option>
                                    <option value="">Phường 6</option>
                                    <option value="">Phường 7</option>
                                    <option value="">Phường 8</option>
                                    <option value="">Phường 9</option>
                                    <option value="">Phường 10</option>
                                    <option value="">Phường 11</option>
                                    <option value="">Phường 12</option>
                                    <option value="">Phường 13</option>
                                    <option value="">Phường 14</option>
                                    <option value="">Phường 15</option>
                                    <option value="">Phường 16</option>
                                    <option value="">Phường 17</option>
                                    <option value="">Phường 18</option>
                                    <option value="">Phường 19</option>
                                    <option value="">Phường 21</option>
                                    <option value="">Phường 22</option>
                                    <option value="">Phường 24</option>
                                    <option value="">Phường 25</option>
                                    <option value="">Phường 26</option>
                                    <option value="">Phường 27</option>
                                    <option value="">Phường 28</option>
                                    <option value="">Phường Bến Nghé</option>
                                    <option value="">Phường Bến Thành</option>
                                    <option value="">Phường Cô Giang</option>
                                    <option value="">Phường Cầu Ông Lãnh</option>
                                    <option value="">Phường Cầu Kho</option>
                                    <option value="">Phường Đa Kao</option>
                                    <option value="">Phường Nguyễn Thái Bình</option>
                                    <option value="">Phường Nguyễn Cư Trinh</option>
                                    <option value="">Phường Phạm Ngũ Lão</option>
                                    <option value="">Phường Tân Định</option>
                                    <option value="">Phường Bình Thuận</option>
                                    <option value="">Phường Phú Mỹ</option>
                                    <option value="">Phường Phú Thuận</option>
                                    <option value="">Phường Tân Hưng</option>
                                    <option value="">Phường Tân Phong</option>
                                    <option value="">Phường Tân Phú</option>
                                    <option value="">Phường Tân Kiểng</option>
                                    <option value="">Phường Tân Quy</option>
                                    <option value="">Phường Tân Thuận Đông</option>
                                    <option value="">Phường Tân Thuận Tây</option>
                                    <option value="">Phường Hiệp Phú</option>
                                    <option value="">Phường Long Bình</option>
                                    <option value="">Phường Long Phước</option>
                                    <option value="">Phường Long Trường</option>
                                    <option value="">Phường Long Thạnh Mỹ</option>
                                    <option value="">Phường Phú Hữu</option>
                                    <option value="">Phường Phước Bình</option>
                                    <option value="">Phường Phước Long A</option>
                                    <option value="">Phường Phước Long B</option>
                                    <option value="">Phường Tăng Nhơn Phú A</option>
                                    <option value="">Phường Tăng Nhơn Phú B</option>
                                    <option value="">Phường Trường Thạnh</option>
                                    <option value="">Phường Hòa Thạnh</option>
                                    <option value="">Phường Hiệp Tân</option>
                                    <option value="">Phường Phú Thạnh</option>
                                    <option value="">Phường Phú Thọ Hòa</option>
                                    <option value="">Phường Phú Trung</option>
                                    <option value="">Phường Sơn Kỳ</option>
                                    <option value="">Phường Tân Thành</option>
                                    <option value="">Phường Tân Thới Hòa</option>
                                    <option value="">Phường Tân Sơn Nhì</option>
                                    <option value="">Phường Tây Thạnh</option>
                                    <option value="">Phường </option>
                                    <option value="">Phường </option>
                                    <option value="">Phường </option>
                                    <option value="">Phường </option>
                                    <option value="">Phường </option>
                                    <option value="">Phường </option>
                                    <option value="">Phường </option>
                                    <option value="">Phường </option>
                                    <option value="">Phường </option>
                                    <option value="">Phường </option>
                                    <option value="">Phường </option>
                                    <option value="">Phường </option>
                                    <option value="">Phường </option>
                                    <option value="">Phường </option>
                                    <option value="">Phường </option>
                                    <option value="">Phường </option>
                                    <option value="">Phường </option>
                                    <option value="">Phường </option>
                                    <option value="">Phường </option>
                                    <option value="">Phường </option>
                                    <option value="">Phường </option>
                                    <option value="">2</option>
                                </select>

                            </div>

                        </div>
                        <div class="form-group">
									<label for="status" class="col-sm-4 control-label"></label>
									<div class="col-sm-5">
										<input type="text" class="form-control" id="address"
											name="address" required placeholder="1 Quang Trung" value="${customer.address }">
									</div>
								</div>

                        <div class="form-group">
                            <div class="col-sm-9 text-right">

                                <button type="submit" class="btn btn-default preview-add-button" onclick="success()">
                                        <!-- <span class="fas fa-cart-plus"></span>  -->
                                        Update
                                    </button>

                                <!-- <button type="submit" class=" btn btn-primary btn-block "
                                        style="width: 150px; padding: 5px 0; font-size: 1.5rem;">Submit
                                        all</button> -->
                            </div>

                        </div>
                        
                        <input type="hidden" name="cid" value="${customer.id }"/>
                        <script>
                            function success() {
                                /* document.getElementById('fullName').value = '';
                                document.getElementById('email').value = '';
                                document.getElementById('phoneNumber').value = '';
                                document.getElementById('address').value = ''; */
                                // document.getElementById('fullName').value='';
                                
                                alert("Cập nhật thành công!");
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

