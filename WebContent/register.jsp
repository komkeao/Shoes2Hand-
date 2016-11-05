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
    <!-- แถบซ้าย --> <jsp:include page="jsp/leftbar.jsp" />
    <!-- จบแถบซ้าย -->
    <!-- แถบขวา -->
      <div class=" col-md-8"><br>
      <div class="panel panel-default">
          <div class="panel-body">
          <!-- ============================================================================fromlogin============================================================================= -->
                 <form class="form-inline" action="account" method="post">
                 <div align="center"><h2>สมัครสมาชิก</h2></div><br>
                <input type="hidden" name="action" value="register" /> 
                <div class="form-group">
                    <label for="exampleInputName2">ชื่อผู้ใช้ : </label>
                    <input type="text" name="username" class="form-control" id="exampleInputName2" placeholder="ชื่อผู้ใช้">
                </div><br><br>

                <div class="form-group">
                    <label for="exampleInputEmail2">รหัสผ่าน : </label>
                    <input type="password" name="password" class="form-control" id="exampleInputEmail2" placeholder="รหัสผ่าน" size="15">
                </div>&nbsp&nbsp&nbsp&nbsp&nbsp

                <div class="form-group">
                    <label for="exampleInputEmail2">ยืนยันรหัสผ่าน : </label>
                    <input type="password" name="cpassword" class="form-control" id="exampleInputEmail2" placeholder="ยืนยันรหัสผ่าน" size="15">
                </div><br><br>
				 <div class="form-group">
                    <label for="exampleInputEmail2">SSN : </label>
                    <input type="text" name="ssn" class="form-control" id="exampleInputEmail2" placeholder="อีเมลล์" >
                </div><br><br>
                <div class="form-group">
                    <label for="exampleInputEmail2">อีเมลล์ : </label>
                    <input type="email" name="email" class="form-control" id="exampleInputEmail2" placeholder="อีเมลล์" >
                </div><br><br>

                <div class="form-group">
                    <label for="exampleInputEmail2">ที่อยู่ : </label>
                    
                <textarea class="form-control" rows="3" cols="60" name="address" ></textarea>
                </div><br><br>
                <div align="center"><input type="submit" class="btn btn-primary" value="ยืนยันสมัครมาชิก"></div><br>

                </form>
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
</html>