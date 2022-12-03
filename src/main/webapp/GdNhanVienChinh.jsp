<%--
  Created by IntelliJ IDEA.
  User: luatnq
  Date: 08/11/2022
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css"/>
    <title>Trang chủ</title>
</head>
<body>
<div class="container ">
    <h1 style="text-align: center;">HỆ THỐNG QUẢN LÝ CỬA HÀNG CHĂM SÓC SẮC ĐẸP</h1>
    <div class="body">
        <div class="row row-cols-2 row-cols-lg-2 g-2 g-lg-2">
            <div class="col-1">
                <button type="button" class="btn btn-primary funciton">
                    QUẢN LÝ DỊCH VỤ LÀM ĐẸP
                    <img src="./images/right.png" alt="" width="16px" style="float: right; margin: 5px 0 5px 0">
                </button>
            </div>
            <div class="col-1">
                <button type="button" class="btn btn-primary funciton">
                    QUẢN LÝ ĐẶT LỊCH
                    <img src="./images/right.png" alt="" width="16px" style="float: right; margin: 5px 0 5px 0">
                </button>
            </div>
            <div class="col-1">
                <button type="button" class="btn btn-primary funciton" onclick="window.location='<%=request.getContextPath()%>/nccs'">
                    QUẢN LÝ NGUYÊN LIỆU
                    <img src="./images/right.png" alt="" width="16px" style="float: right; margin: 5px 0 5px 0">
                </button>
            </div>
            <div class="col-1">
                <button type="button" class="btn btn-primary funciton">
                    QUẢN LÝ HOÁ ĐƠN
                    <img src="./images/right.png" alt="" width="16px" style="float: right; margin: 5px 0 5px 0">
                </button>
            </div>
            <div class="col-1">
                <button type="button" class="btn btn-primary funciton">
                    QUẢN LÝ CÔNG VIỆC
                    <img src="./images/right.png" alt="" width="16px" style="float: right; margin: 5px 0 5px 0">
                </button>
            </div>
            <div class="col-1">
                <button type="button" class="btn btn-primary funciton">
                    QUẢN LÝ NGƯỜI DÙNG
                    <img src="./images/right.png" alt="" width="16px" style="float: right; margin: 5px 0 5px 0">
                </button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
