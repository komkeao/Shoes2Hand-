<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.ProductType"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>
<%@ page import="model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Shose2hands</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-color: #eee;">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2 col-xs-0"></div>
			<!-- bar -->
			<div class="col-md-8 col-xs-12">
				<img style="width: 100%" src="img/banner.png">
				<jsp:include page="jsp/adminBar.jsp" />

				<!-- end bar -->
				<div class="row">
					<!-- แถบขวา -->
					<div class=" col-md-12">
						<div class="panel panel-default">
							<div class="panel-body">
								<!-- =============================================================================main============================================================================= -->
								<div class="row">


									<table class="table table-striped">

										<tr>
											<th class="col-md-1">เลขบิล</th>
											<th class="col-md-1">เวลาชำระเงิน</th>
											<th class="col-md-2">ที่อยู่การจัดส่ง</th>
											<th class="col-md-2">ชื่อ-นามสกุล</th>
											<th class="col-md-3">รูปยืนยัน</th>
								
										</tr>

										<c:forEach items="${list}" var="item">
											<tr>
												<td>${item.bid}</td>
												<td>${item.bookingTime}</td>
												<td>${item.sendAddress}</td>
												<td>${item.username}</td>
												<td><img src="${item.photo}" style="max-width: 200px;max-height: 50px;"></img></td>
							
											</tr>
										</c:forEach>


									</table>

								</div>
								<!-- ================================================================================= ============================================================================= -->
							</div>
						</div>
					</div>
					<!-- จบแถบขวา -->
				</div>
			</div>
		</div>
	</div>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>