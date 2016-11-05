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
                  <th class="col-md-1">เวลาสั่งซื้อ</th>
                  <th class="col-md-1">เวลาชำระเงิน</th>
                  <th class="col-md-2">ที่อยู่การจัดส่ง</th>
                  <th class="col-md-2">ชื่อ-นามสกุล</th>
                  <th class="col-md-3">รูปยืนยัน</th>
                  <th class="col-md-2">สถานะ</th>
                </tr>


                <tr>
                  <td>001</td>
                  <td>02/02/2559 18:02:55</td>
                  <td>02/02/2559 19:15:13</td>
                  <td>379/9 หมู่ 3 ตำบลซับสมอทอด</td>
                  <td>นาย สุขพัฒน์ เทพารส</td>
                  <td></td>
                  <td><button class="btn btn-primary">ยืนยันชำระเงิน</button></td>
                </tr>


                 <tr>
                  <td>001</td>
                  <td>02/02/2559 18:02:55</td>
                  <td>02/02/2559 19:15:13</td>
                  <td>379/9 หมู่ 3 ตำบลซับสมอทอด</td>
                  <td>นาย สุขพัฒน์ เทพารส</td>
                  <td></td>
                  <td><button class="btn btn-primary">ยืนยันชำระเงิน</button></td>
                </tr>
  

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


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>