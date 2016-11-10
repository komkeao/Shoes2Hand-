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
				<c:if test="${sessionScope.userType==1}">
					<jsp:include page="jsp/adminBar.jsp" />
				</c:if>
				<c:if test="${sessionScope.userType!=1}">
					<jsp:include page="jsp/bar.jsp" />
				</c:if>


				<!-- end bar -->
				<div class="row">
					<!-- à¹à¸à¸à¸à¹à¸²à¸¢ -->
					<jsp:include page="jsp/leftbar.jsp" />

					<!-- à¸à¸à¹à¸à¸à¸à¹à¸²à¸¢ -->
					<!-- แถบขวา -->
					<div class=" col-md-8">
						<div class="panel panel-default">
							<div class="panel-body">
								<!-- =============================================================================main============================================================================= -->

								<div class="row">
									<c:forEach items="${list}" var="item">


										<div class="col-sm-12 col-md-6">
											<div class="thumbnail">
												<img src="${item.photo}" class="img-rounded"
													alt="Responsive image">
												<div class="caption">
													<h4>${item.pName}</h4>
													<p>${item.description}</p>
													<p>
														<c:if test="${sessionScope.userType!=1}">
															<a href="product?action=addToBucket&pid=${item.pid}"
															class="btn btn-warning" role="button">ใส่ตะกร้า</a>
														</c:if>
														<c:if test="${sessionScope.userType==1}">
															<a href="product?action=edit&pid=${item.pid}"
															class="btn btn-warning" role="button">แก้ไข</a>
															<a href="product?action=delete&pid=${item.pid}"
															class="btn btn-danger" role="button">ลบ</a>
														</c:if>
														

														&nbsp&nbsp <input type="button" class="btn"
															value="${item.price} THB" disabled><br>
														<br>
														<!--  <a href="product?action=viewDetails&pid=${item.pid}" class="btn btn-primary" role="button">รายละเอียด</a>
                       -->
													</p>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
								<!-- =============================================================================main============================================================================= -->


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