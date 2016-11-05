<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<form action="index.php">
<div class=" col-md-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">ราคา</h3>
            </div>
          <div class="panel-body">
          <div class="col-md-12">
               <!-- ======================================================================================================================================= -->

            <input type="range" name="myrange" style="width='100px'; "min="1" max="1000" value="1000" onchange="range.value=value">
            <h4>ราคาน้อยกว่า <output id="range">1000</output></h4>


               <!-- ======================================================================================================================================= -->
        </div>
          </div>
        </div>

        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">ยี่ห้อ</h3>
            </div>
          <div class="panel-body">
              <input type="checkbox" name="brand" value="Adidas"> Adidas<br>
              <input type="checkbox" name="brand" value="Nike" > Nike<br>
              <input type="checkbox" name="brand" value="Puma"> Puma<br>
              <input type="checkbox" name="brand" value="Converse" > Converse<br>
              <input type="checkbox" name="brand" value="Onitsuka"> Onitsuka Tiger<br>
              <input type="checkbox" name="brand" value="Asics"> Asics<br><br>
              <div align="center"><input class="btn btn-warning" type="submit" value="ค้นหา"></div>
          </div>
        </div>

        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">ตืดต่อ</h3>
            </div>
          <div class="panel-body">
                 Facebook : Shoes2hands<br>
                 โทร : 0839536380
          </div>
        </div>

      </div>
</form>