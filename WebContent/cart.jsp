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
      <div class=" col-md-8">
      <div class="panel panel-default">
          <div class="panel-body">
          <!-- =============================================================================main============================================================================= -->
          <h2>ตะกร้าสินค้า</h2><br>


          

          <div class="row">
                <div class="col-sm-12 col-md-12">
                    <div class="thumbnail">
                    <div class="row">
                      <div class="col-md-6">
                          <div class="thumbnail">
                            <img src="img/picshoes/ad1.jpg" class="img-rounded" alt="Responsive image">
                          </div>
                      </div>
                      <div class="caption">
                              <h4>Adidas</h4>
                              <p>------</p>
                          <p><a href="#" class="btn btn-danger" role="button">ลบ</a>&nbsp&nbsp
                          <input type="button" class="btn" value="ราคา : 500 THB" disabled>
                      </p>
                    </div>
                            
                      </div>
                    </div>
                </div>
          </div>




 
  <div class="navbar-right">
      <form class="form-inline" >
        <div class="form-group">
            <label class="sr-only" for="exampleInputAmount">Amount (in dollars)</label>
            <div class="input-group">
              <div class="input-group-addon">จำนวนเงินทั้งหมด</div>
                <input type="text" class="form-control" id="exampleInputAmount" value="500" disabled>
              <div class="input-group-addon">บาท</div>
            </div>
      </div><br><br><input type="file" class="form-control" name="exampleInputFile">
  <button type="submit" class="btn btn-primary">ชำระเงิน</button>&nbsp&nbsp
</form><br>
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