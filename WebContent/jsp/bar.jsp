<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">Shose2hands</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="index.jsp">หน้าหลัก</a></li>
				<c:if test="${sessionScope.name!=null}">
				
					<li><a href="account?action=logout">ออกจากระบบ</a></li>
					
				</c:if>
				
				<c:if test="${sessionScope.name==null}">
				
					<li><a href="login.jsp">เข้าสู่ระบบ</a></li>
					<li><a href="register.jsp">สมัครสามาชิก</a></li>
				
				</c:if>
				

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">ยี่ห้อ<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Adidas</a></li>
							<li><a href="#">Nike</a></li>
							<li><a href="#">Puma</a></li>
							<li><a href="#">Converse</a></li>
							<li><a href="#">Onitsuka Tiger</a></li>
							<li><a href="#">Asics</a></li>
						</ul></li>
			</ul>
			<form class="navbar-form navbar-right">
				<button type="submit" class="btn btn-default">
					<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
				</button>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					ค้นหา
				</button>
			</form>

		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>