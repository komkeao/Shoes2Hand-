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


                <div class="col-sm-12 col-md-4">
                    <div class="thumbnail">
                         <img src="img/picshoes/ad1.jpg" class="img-rounded" alt="Responsive image">
                            <div class="caption">
                              <h4>Adidas</h4>
                              <p>อาดิดาส เป็นยี่ห้อสินค้ากีฬาจากเยอรมนี คำขวัญของอาดิดาสคือ "Impossible is Nothing" ซึ่งใช้มาตั้งแต่ปี ค.ศ. 2004</p>
                      <p><a href="#" class="btn btn-danger" role="button">ลบ</a>&nbsp&nbsp
                          <input type="button" class="btn btn-warning" value="ขายแล้ว" disabled><br><br>
                      </p>
                      </div>
                    </div>
                </div>

                <div class="col-sm-12 col-md-4">
                    <div class="thumbnail">
                         <img src="img/picshoes/ad3.jpg" class="img-rounded" alt="Responsive image">
                            <div class="caption">
                              <h4>Adidas</h4>
                              <p>อาดิดาส เป็นยี่ห้อสินค้ากีฬาจากเยอรมนี คำขวัญของอาดิดาสคือ "Impossible is Nothing" ซึ่งใช้มาตั้งแต่ปี ค.ศ. 2004</p>
                      <p><a href="#" class="btn btn-danger" role="button">ลบ</a>&nbsp&nbsp
                          <input type="button" class="btn btn-warning" value="ยังขายไม่ได้" disabled><br><br>
                      </p>
                      </div>
                    </div>
                </div>


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