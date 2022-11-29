<%--
  Created by IntelliJ IDEA.
  User: luatnq
  Date: 08/11/2022
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.3.1.js"
            integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous">
    </script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dsNl.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
          integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
          crossorigin="anonymous" referrerpolicy="no-referrer"
    />

    <title>Danh sách sản phẩm</title>
</head>
<body>
<div style="padding-bottom: 20px;">
    <span class="screen-darken"></span>
    <header class="section-header py-2 ">
        <div style="display: flex;justify-content: space-between; margin: 10px 40px; align-items: center;">
            <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
                <ol class="breadcrumb mb-0">
                    <li class="breadcrumb-item"><a href="../Home/home.html">Trang chủ</a></li>
                    <li class="breadcrumb-item"><a href="../QuanLyNguyenLieu/index.html">Quản lý nguyên liệu</a></li>
                    <li class="breadcrumb-item"><a href="../DanhSachNCC/index.html">Danh sách nhà cung cấp</a></li>
                    <li class="breadcrumb-item active"><a href="#">Danh sách nguyên liệu</a></li>
                </ol>
            </nav>
            <button type="button" class="btn" style="padding: 0px;">
                <img src="../../../images/avatarDefault.png" width="50px" height="50px"/>
                <span style="text-align: center;">Hiệp đẹp trai</span>
            </button>
        </div>
    </header>
    </nav>
    <hr class="my-0"/>
</div>
<div class="d-flex px-5 justify-content-around mb-4 mt-4" style="color: #2563EB;">
    <h4 class="px-5" style="">
        Danh sách nguyên liệu - Đại lý A
    </h4>
    <h4 style="">
        Danh sách nguyên liệu đã nhập
    </h4>
</div>
<div class="d-flex px-5">
    <div class=" px-5" style="width: 50%; border-right: 1px solid #ccc">
        <div class="col-12 header-search">
            <div style="display: flex ;padding: 10px 10px; justify-content: space-between; flex: 1; height: 55px;">
                <input type="search" required="required" class="header_search_input h-100" id="header_search_input"
                       placeholder="Nhập tên nguyên liệu để tìm kiếm"/>
                <button style="width: 130px" type="button" data-bs-dismiss="modal"
                        class="btn btn-primary d-flex align-items-center" data-bs-toggle="modal"
                        data-bs-target="#exampleModal1">
                    <img src="../../images/search.png" class="me-1" alt="">
                    Tìm kiếm
                </button>
            </div>
        </div>
    </div>
    <div style="width: 50%;">

    </div>
</div>

<%--danh sách nguyên liệu có sẵn--%>
<div class="d-flex px-5">
    <div class="px-5" style="width: 50%; border-right: 1px solid #ccc">
        <div style="display: flex; justify-content:end; padding: 40px 0 20px 0; flex: 1;">
            <button type="button" data-bs-dismiss="modal" class="btn btn-primary" data-bs-toggle="modal"
                    data-bs-target="#addProducts">
                + Thêm mới
            </button>
        </div>

        <table class="table table-striped">
            <thead class="header-table">
            <tr>
                <th scope="col" class="text-center">STT</th>
                <th scope="col" class="text-left">Tên nguyên liệu</th>
                <th scope="col" class="text-end">Số lượng</th>

            </tr>
            </thead>
            <tbody class="table-content">
            <tr data-bs-toggle="modal" data-bs-target="#enterProducts">
                <th class="text-center">1</th>
                <td style="text-align: left;">Nguyên liệu A</td>
                <td style="text-align: end;">100</td>
            </tr>
            <tr>
                <th class="text-center">2</th>
                <td style="text-align: left;">Nguyên liệu A</td>
                <td style="text-align: end;">100</td>
            </tr>
            <tr>
                <th class="text-center">3</th>
                <td style="text-align: left;">Nguyên liệu A</td>
                <td style="text-align: end;">100</td>
            </tr>
            <tr>
                <th class="text-center">4</th>
                <td style="text-align: left;">Nguyên liệu A</td>
                <td style="text-align: end;">100</td>
            </tr>
            <tr>
                <th class="text-center">5</th>
                <td style="text-align: left;">Nguyên liệu A</td>
                <td style="text-align: end;">100</td>
            </tr>
            <tr>
                <th class="text-center">6</th>
                <td style="text-align: left;">Nguyên liệu A</td>
                <td style="text-align: end;">100</td>
            </tr>
            <tr>
                <th class="text-center">7</th>
                <td style="text-align: left;">Nguyên liệu A</td>
                <td style="text-align: end;">100</td>
            </tr>
            <tr>
                <th class="text-center">8</th>
                <td style="text-align: left;">Nguyên liệu A</td>
                <td style="text-align: end;">100</td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="px-5" style="width: 50%">
        <div style="display: flex; justify-content:end; padding: 40px 0 20px 0;">
            <button type="button" data-bs-dismiss="modal" class="btn btn-primary" data-bs-toggle="modal"
                    data-bs-target="#printBuild">
                Xác nhận
            </button>
        </div>

        <table class="table table-striped">
            <thead class="header-table">
            <tr>
                <th scope="col" class="text-center">STT</th>
                <th scope="col" class="text-left">Tên nguyên liệu</th>
                <th scope="col" class="text-end">Số lượng</th>
                <th scope="col" class="text-end">Đơn giá(VND)</th>
                <th scope="col" class="text-end">Tổng tiền(VND)</th>

            </tr>
            </thead>
            <tbody class="table-content">
            <tr>
                <th class="text-center">1</th>
                <td style="text-align: left;">Nguyên liệu A</td>
                <td style="text-align: end;">10</td>
                <td style="text-align: end;">10.000</td>
                <td style="text-align: end;">100.000</td>
            </tr>
            <tr>
                <th class="text-center">2</th>
                <td style="text-align: left;">Nguyên liệu A</td>
                <td style="text-align: end;">10</td>
                <td style="text-align: end;">10.000</td>
                <td style="text-align: end;">100.000</td>
            </tr>
            <tr>
                <th class="text-center">3</th>
                <td style="text-align: left;">Nguyên liệu A</td>
                <td style="text-align: end;">10</td>
                <td style="text-align: end;">10.000</td>
                <td style="text-align: end;">100.000</td>
            </tr>
            <tr>
                <th class="text-center">4</th>
                <td style="text-align: left;">Nguyên liệu A</td>
                <td style="text-align: end;">10</td>
                <td style="text-align: end;">10.000</td>
                <td style="text-align: end;">100.000</td>
            </tr>
            <tr>
                <th class="text-center">5</th>
                <td style="text-align: left;">Nguyên liệu A</td>
                <td style="text-align: end;">10</td>
                <td style="text-align: end;">10.000</td>
                <td style="text-align: end;">100.000</td>
            </tr>
            <tr>
                <th class="text-center">6</th>
                <td style="text-align: left;">Nguyên liệu A</td>
                <td style="text-align: end;">10</td>
                <td style="text-align: end;">10.000</td>
                <td style="text-align: end;">100.000</td>
            </tr>
            <tr>
                <th class="text-center">7</th>
                <td style="text-align: left;">Nguyên liệu A</td>
                <td style="text-align: end;">10</td>
                <td style="text-align: end;">10.000</td>
                <td style="text-align: end;">100.000</td>
            </tr>
            <tr>
                <th class="text-center">8</th>
                <td style="text-align: left;">Nguyên liệu A</td>
                <td style="text-align: end;">10</td>
                <td style="text-align: end;">10.000</td>
                <td style="text-align: end;">100.000</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<!-- Modal nhập nguyên liệu-->
<div class="modal fade" id="enterProducts" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content custum-modal">
            <div class="modal-body">
                <div style="text-align: right">
                    <button style="background-color: #d6d5d5;border-radius: 50%;font-size: 12px;
                            " type="button" class="btn-close p-2" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="title-modal-body">Nhập thông tin nguyên liệu</div>
                <form action="GET">
                    <div style="padding: 20px 0;">
                        <b-row class="mb-5">
                            <div>
                                <label for="exampleFormControlInput1" class="form-label">Tên nguyên liệu</label>
                                <input type="text" required class="form-control" id="productName"
                                       placeholder="Name...">
                            </div>
                        </b-row>
                        <b-row style="display: flex; justify-content: space-between; margin:24px 0;">
                            <div style="width: 48%;">
                                <label for="exampleFormControlInput1" class="form-label">Số lượng</label>
                                <input type="text" required class="form-control" id="productNumber"
                                       placeholder="Number...">
                            </div>
                            <div style="width: 48%;">
                                <label for="exampleFormControlInput1" class="form-label">Đơn giá
                                    (VNĐ)</label>
                                <input type="text" required class="form-control" id="exampleFormControlInput3"
                                       placeholder="Price...">
                            </div>
                        </b-row>
                    </div>

                    <div class="control-button" style="text-align: center;">
                        <button type="button" data-bs-dismiss="modal"
                                style="padding: 8px 20px; border-radius: 10px; width: 150px; margin-right: 20px;"
                                class="btn btn-outline-secondary">
                            Hủy bỏ
                        </button>
                        <button type="submit" data-bs-dismiss="modal"
                                style="padding: 8px 20px; border-radius: 10px; width: 150px" class="btn btn-primary">
                            Lưu
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Modal them moi nguyên liệu-->
<div class="modal fade" id="addProducts" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content custum-modal">
            <div class="modal-body">
                <div style="text-align: right">
                    <button style="background-color: #d6d5d5;border-radius: 50%;font-size: 12px;
                            " type="button" class="btn-close p-2" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="title-modal-body">Nhập thông tin nguyên liệu</div>
                <form action="GET">
                    <div style="padding: 20px 0;">
                        <b-row class="mb-5">
                            <div>
                                <label for="exampleFormControlInput1" class="form-label">Tên nguyên
                                    liệu</label>
                                <input type="text" required class="form-control" id="productName"
                                       placeholder="Tên nguyên liệu...">
                            </div>
                        </b-row>

                    </div>

                    <div class="control-button" style="text-align: center;">
                        <button type="button" data-bs-dismiss="modal"
                                style="padding: 8px 20px; border-radius: 10px; width: 150px; margin-right: 20px;"
                                class="btn btn-outline-secondary">
                            Hủy bỏ
                        </button>
                        <button type="submit" data-bs-dismiss="modal"
                                style="padding: 8px 20px; border-radius: 10px; width: 150px" class="btn btn-primary">
                            Lưu
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Modal in hóa đơn thành công -->
<div class="modal fade" id="printBuild" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content custum-modal">
            <div class="modal-body">
                <div style="text-align: right">
                    <button style="
                                            background-color: #d6d5d5;
                                                border-radius: 50%;
                                            font-size: 12px;
                            " type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="title-modal-success">
                    <img src="../../images/iconSuccess.png" alt="" width="50px" height="50px"
                         style="margin-bottom: 20px;">
                    <br/>
                    In hóa đơn thành công!
                </div>
                <div class="control-button" style="text-align: center;">
                    <button type="button" data-bs-dismiss="modal"
                            style="padding: 8px 20px; border-radius: 10px; width: 30%;" class="btn btn-outline-dark">
                        Hủy bỏ
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script>
    $(function () {
        $("#header").load("../../header.html");
    });
</script>