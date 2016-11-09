<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.ProductType"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>
<%@ page import="model.*"%>
<form action="search">
	<div class=" col-md-4">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">ราคา</h3>
			</div>
			<div class="panel-body">
				<div class="col-md-12">
					<!-- ======================================================================================================================================= -->

					<input type="range" name="price" style="" min="1" max="1000"
						value="1000" onchange="range.value=value">
					<h4>
						ราคาน้อยกว่า
						<output id="range">1000</output>
					</h4>


					<!-- ======================================================================================================================================= -->
				</div>
			</div>
		</div>

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">ยี่ห้อ</h3>
			</div>
			<div class="panel-body">

				<c:forEach items="${productType}" var="item">
					<input type="checkbox" name="type" value="${item.typeID}">${item.typeName}<br>
				</c:forEach>
				<input type="hidden" name="action" value="search">

				<div align="center">
					<input class="btn btn-warning" type="submit" value="ค้นหา">
				</div>
			</div>
		</div>

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">ตืดต่อ</h3>
			</div>
			<div class="panel-body">
				Facebook : Shoes2hands<br> โทร : 0839536380
			</div>
		</div>

	</div>
</form>