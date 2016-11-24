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
				<jsp:include page="jsp/bar.jsp" />

				<!-- end bar -->
				<div class="row">

					<!-- จบแถบซ้าย -->
					<!-- แถบขวา -->
					<div class=" col-md-12">
						<div class="panel panel-default">
							<div class="panel-body">
								<!-- =============================================================================main============================================================================= -->
								<h2>ตะกร้าสินค้า</h2>
								<br>

								<c:if test="${flag==1}">
									<br />
									<div class="alert alert-success">ชำระเงินเรียบร้อย</div>
								</c:if>

								<c:set var="total" scope="session" value="0" />
								<c:forEach items="${list}" var="item">


									<div class="col-sm-12 col-md-6">
										<div class="thumbnail">
											<img src="${item.photo}" class="img-rounded"
												alt="Responsive image">
											<div class="caption">
												<h4>${item.pName}</h4>
												<p>${item.description}</p>
												<p>


													<a href="cart?action=delete&pid=${item.pid}"
														class="btn btn-danger" role="button">ลบ</a> &nbsp&nbsp <input
														type="button" class="btn" value="${item.price} THB"
														disabled><br> <br>
													<!--  <a href="product?action=viewDetails&pid=${item.pid}" class="btn btn-primary" role="button">รายละเอียด</a>
                       -->
													<c:set var="total" scope="session"
														value="${total+item.price }" />
												</p>
											</div>
										</div>
									</div>
								</c:forEach>





								<div class="navbar-right">
									<div class="row">
										<br>
										<form method="post" action="cart"
											enctype="multipart/form-data" class="form-horizontal">
											<div class="col-md-1"></div>
											<div class="col-md-5">
												<div class="form-group">
													<div class="input-group">
														<div class="input-group-addon">จำนวนเงินทั้งหมด</div>
														<input type="text" class="form-control"
															id="exampleInputAmount" value="${total }" disabled>
														<div class="input-group-addon">บาท</div>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<input type="file" class="form-control" name=" photo"
													required="required">
												<div class="form-group"></div>
												<div class="row">
													<label for="exampleInputEmail2"
														class="col-md-2 control-label">ที่อยู่ : </label>
													<div class="col-md-10">
														<textarea class="form-control" rows="3" cols="60"
															name="address" required="required"></textarea>
													</div>
												</div>
												<div class="col-md-1"></div>
											</div>
									</div>
									<br> <br>
									<div class="col-md-1"></div>
									<input type="submit" class="btn btn-primary col-md-2"
										value="ชำระเงิน"> <input type="hidden" name="action"
										value="pay">
									</form>

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