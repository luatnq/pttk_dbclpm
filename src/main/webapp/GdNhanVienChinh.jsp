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
                    <img src="${pageContext.request.contextPath}/images/right.png" alt="" width="16px" style="float: right; margin: 5px 0 5px 0">
                </button>
            </div>
            <div class="col-1">
                <button type="button" class="btn btn-primary funciton">
                    QUẢN LÝ ĐẶT LỊCH
                    <img src="${pageContext.request.contextPath}/images/right.png" alt="" width="16px" style="float: right; margin: 5px 0 5px 0">
                </button>
            </div>

            <div class="col-1">
                <button type="button" class="btn btn-primary funciton">
                    QUẢN LÝ HOÁ ĐƠN
                    <img src="${pageContext.request.contextPath}/images/right.png" alt="" width="16px" style="float: right; margin: 5px 0 5px 0">
                </button>
            </div>
            <div class="col-1">
                <button type="button" class="btn btn-primary funciton">
                    QUẢN LÝ CÔNG VIỆC
                    <img src="${pageContext.request.contextPath}/images/right.png" alt="" width="16px" style="float: right; margin: 5px 0 5px 0">
                </button>
            </div>
            <div class="col-1 position-relative parent-btn">
                <button type="button" class="btn btn-primary funciton" data-bs-container="body"
                        data-bs-toggle="popover" data-bs-placement="bottom" data-bs-content="Bottom popover">
                    QUẢN LÝ NGUYÊN LIỆU
                    <img src="${pageContext.request.contextPath}/images/right.png" alt="" width="16px" style="float: right; margin: 5px 0 5px 0">
                </button>

                <div class="position-absolute sub-select-btn" style="top: 75px; right: 10px; padding-top:20px;">
                    <div class="justify-content-start" style="width: 280px">
                        <%--                        <a href="../DanhSachNCC/index.html">--%>
                        <button type="button"
                                onclick="window.location='<%=request.getContextPath()%>/nccs'"
                                class="btn btn btn-primary funciton my-2"
                                data-bs-container="body"
                                data-bs-toggle="popover" data-bs-placement="bottom"
                                data-bs-content="Bottom popover">
                            <img src="${pageContext.request.contextPath}/images/right.png" alt="" width="16px"
                                 style="float: right; margin: 5px 0 5px 0">
                            NHẬP NGUYÊN LIỆU
                        </button>
                        <button type="button" class="btn btn-primary funciton my-2">
                            DANH SÁCH NGUYÊN LIỆU
                            <img src="${pageContext.request.contextPath}/images/right.png" alt="" width="16px"
                                 style="float: right; margin: 5px 0 5px 0">
                        </button>
                    </div>
                </div>
            </div>

            <div class="col-1">
                <button type="button" class="btn btn-primary funciton">
                    QUẢN LÝ NGƯỜI DÙNG
                    <img src="${pageContext.request.contextPath}/images/right.png" alt="" width="16px" style="float: right; margin: 5px 0 5px 0">
                </button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
