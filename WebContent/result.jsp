<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
    <!-- แถบซ้าย -->
     <jsp:include page="jsp/leftbar.jsp" />
    <!-- จบแถบซ้าย -->
    <!-- แถบขวา -->
      <div class=" col-md-8"><br><br>
      <div class="panel panel-default">
          <div class="panel-body">
          <!-- ============================================================================fromlogin============================================================================= -->
      ${text} <br/>  <br/>                   
                           ชื่อผู้ใช้ :    ${username}<br/>  
		อีเมลล์ :   ${email} <br/>  
		ที่อยู่ :   ${address}<br/>  
                <!-- ================================================================================================================================================================== -->
          </div>
        </div>
      </div>
    <!-- จบแถบขวา -->
    </div>
    </div>
  </div>
</div>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</body>
