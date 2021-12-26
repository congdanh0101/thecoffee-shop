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
	<jsp:include page="navbar_admin.jsp"></jsp:include>
	<div class="container">
		<div class="row"></div>
		<table class="table table-hover table-bordered table-responsive ">
			<h2>list of bill</h2>
			<form action="changeStatusFilter" method="post" name="statusForm">
				<div style="font-size: 1.5rem;">Filter</div>
				<select name="changeStatus" id="changeStatus"
					onchange="return setValue()">
					<c:choose>
						<c:when test="${requestScope.get('StatusFilter') ==null }">
							<option value=""></option>
							<c:forEach var="item" items="${listStatus }">
								<option value="${item.id }">${item.name }</option>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<option value="${StatusFilter.id }">${StatusFilter.name }</option>
							<c:forEach var="item" items="${listStatus }">
								<c:choose>
									<c:when test="${item.id != StatusFilter.id }">
										<option value="${item.id }">${item.name }</option>
									</c:when>
								</c:choose>


							</c:forEach>
						</c:otherwise>
					</c:choose>

				</select> <input type="hidden" name="dropdown" id="dropdown" />
				<!-- <input type="submit" value="click" name="btn_dropdown" /> -->
			</form>
			<script type="text/javascript">
				function setValue() {
					document.getElementById("dropdown").value = document
							.getElementById("changeStatus").value;
					document.statusForm.submit();
					return true;
				}
			</script>
			<br />
			<br />

			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Date</th>
					<th scope="col">Time</th>
					<th scope="col">Customer</th>
					<th scope="col">Current status</th>
					<th scope="col">Next status</th>
					<th scope="col">Detail</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${listBill }">

					<input type="hidden" value="${item.getId() }" name="bid" />
					<tr>
						<th scope="row">${item.getId() }</th>
						<td>${item.getDate() }</td>
						<td>${item.getTime() }</td>
						<td><a
							href="AdminCustomer?cid=${item.getCustomer().getId() }">${item.getCustomer().getName() }</a></td>
						<td><select name="currentstatus" id=""
							style="width: 65%; float: left;" disabled="disabled">
								<option value="${item.status.id }">${item.status.name }</option>
						</select></td>
						<td>
							<form action="changeStatus" method="post" name="updateStatusBill">
								<select name="nextstatus" id="nextstatus"
									style="width: 65%; float: left;" onchange="return nextStatus()">
									<c:choose>
										<c:when
											test="${item.status.id == 1 || item.status.id == 2 || item.status.id == 3}">
											<c:forEach var="itemStatus" items="${listStatus }"
												begin="${item.status.id - 1 }" end="4">
												<option value="${itemStatus.id }">${itemStatus.name }</option>
											</c:forEach>
										</c:when>
										<%-- <c:when test="${item.status.id == 2}">
											<c:forEach var="itemStatus" items="${listStatus }" begin="${item.status.id - 1 }" end="4">
												<option value="${itemStatus.getId() }">${itemStatus.getName() }</option>
											</c:forEach>
										</c:when>
										<c:when test="${item.status.id == 3}">
											<c:forEach var="itemStatus" items="${listStatus }" begin="${item.status.id - 1 }" end="4">
												<option value="${itemStatus.getId() }">${itemStatus.getName() }</option>
											</c:forEach>
										</c:when> --%>
										<c:when test="${item.status.id == 4}">
											<c:forEach var="itemStatus" items="${listStatus }"
												begin="${item.status.id - 1 }" end="3">
												<option value="${itemStatus.id }" disabled="disabled">${itemStatus.name }</option>
											</c:forEach>
										</c:when>
										<c:when test="${item.status.id == 5}">
											<c:forEach var="itemStatus" items="${listStatus }"
												begin="${item.status.id - 1 }" end="4">
												<option value="${itemStatus.id }" disabled="disabled">${itemStatus.name }</option>
											</c:forEach>
										</c:when>
									</c:choose>
								</select> <input type="hidden" value="${item.id }" name="bid" />
								<c:choose>
									<c:when
										test="${item.status.id == 1 || item.status.id == 2 || item.status.id == 3}">
										<input type="submit"
											style="font-size: 100%; width: 30%; height: 100%; display: inline-block; float: right; margin: auto;" />
									</c:when>
									
								</c:choose>
								<input type="hidden" name="dropdown" id="dropdown" />
							</form> <script type="text/javascript">
								function nextStatus() {
									document.getElementById("dropdown").value = document
											.getElementById("nextstatus").value;
									document.updateStatusBill.submit();
									return true;
								}
							</script>
						</td>
						<td><a href="bill?bid=${item.getId() }">Detail</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


</body>
</html>