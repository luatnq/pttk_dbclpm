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
    <script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous">
    </script>
    <link rel="stylesheet" href="index.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer"
    />

    <title>Danh sách sản phẩm</title>
</head>
<body>
<header id="header"></header>
<div class="container1">
    <div class="row" style="justify-content: center;">
        <div class="col-md-12 order-md-2 col-lg-9">
            <!-- <div class="container-fluid"> -->
            <div class="row two-table">
                <div class="col-6 col-md-6 col-lg-6 mb-6">
                    <div class="row " style="display: flex; justify-content:space-between; padding: 20px 0;">
                        <div class="col-12">
                            <div class="dropdown text-md-left text-center float-md-left mb-3 mt-3 mt-md-0 mb-md-0">
                                <div class="header_search_form_container">
                                    <form action="#" class="header_search_form clearfix">
                                        <input type="search" required="required" class="header_search_input" id="header_search_input" placeholder="Nhập tên nhà cung cấp để tìm kiếm" />
                                        <div style="display: none"></div>
                                        <button type="submit" class="header_search_button trans_300" value="Submit">
                                            <img src="../../images/search.png" alt="">
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div style="display: flex; justify-content:space-between; padding: 20px 0;">
                        <p style="font-size: 18px;font-weight: bold;">Nhập nguyên liệu</p>
                        <button type="button" data-bs-dismiss="modal" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                            + Thêm mới
                        </button>
                    </div>

                    <div id="search-value" class="card h-100 border-0 border-table">
                        <div class="border-table-content" style="overflow-x: scroll;">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th scope="col" class="text-center">STT</th>
                                    <th scope="col" class="text-left">Tên nguyên liệu</th>
                                    <th scope="col" class="text-left">Số lượng</th>

                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <th>1</th>
                                    <td style="text-align: left;">Đại lý A</td>
                                    <td style="text-align: left;">0987654321</td>
                                </tr>
                                <tr>
                                    <th>2</th>
                                    <td style="text-align: left;">Đại lý A</td>
                                    <td style="text-align: left;">0987654321</td>
                                </tr>
                                <tr>
                                    <th>3</th>
                                    <td style="text-align: left;">Đại lý A</td>
                                    <td style="text-align: left;">0987654321</td>
                                </tr>
                                <tr>
                                    <th>4</th>
                                    <td style="text-align: left;">Đại lý A</td>
                                    <td style="text-align: left;">0987654321</td>
                                </tr>
                                <tr>
                                    <th>5</th>
                                    <td style="text-align: left;">Đại lý A</td>
                                    <td style="text-align: left;">0987654321</td>
                                </tr>
                                <tr>
                                    <th>6</th>
                                    <td style="text-align: left;">Đại lý A</td>
                                    <td style="text-align: left;">0987654321</td>
                                </tr>
                                <tr>
                                    <th>7</th>
                                    <td style="text-align: left;">Đại lý A</td>
                                    <td style="text-align: left;">0987654321</td>
                                </tr>
                                <tr>
                                    <th>8</th>
                                    <td style="text-align: left;">Đại lý A</td>
                                    <td style="text-align: left;">0987654321</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>
                <!-- <div class="col-2 col-md-2 col-lg-2 mb-2">áđá</div> -->
                <div class="col-6 col-md-6 col-lg-6 mb-6" style="
                    padding-top: 80px;">
                    <div style="display: flex; justify-content:space-between; padding: 20px 0;">
                        <p style="font-size: 18px; font-weight: bold;">Danh sách nguyên liệu</p>
                        <button type="button" data-bs-dismiss="modal" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                            Xác nhận
                        </button>
                    </div>

                    <div id="search-value" class="card h-100 border-0 border-table">
                        <div class="border-table-content" style="overflow-x: scroll;">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th scope="col" class="text-center">STT</th>
                                    <th scope="col" class="text-left">Tên nguyên liệu</th>
                                    <th scope="col" class="text-left">Số lượng</th>

                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <th>1</th>
                                    <td style="text-align: left;">Đại lý A</td>
                                    <td style="text-align: left;">0987654321</td>
                                </tr>
                                <tr>
                                    <th>2</th>
                                    <td style="text-align: left;">Đại lý A</td>
                                    <td style="text-align: left;">0987654321</td>
                                </tr>
                                <tr>
                                    <th>3</th>
                                    <td style="text-align: left;">Đại lý A</td>
                                    <td style="text-align: left;">0987654321</td>
                                </tr>
                                <tr>
                                    <th>4</th>
                                    <td style="text-align: left;">Đại lý A</td>
                                    <td style="text-align: left;">0987654321</td>
                                </tr>
                                <tr>
                                    <th>5</th>
                                    <td style="text-align: left;">Đại lý A</td>
                                    <td style="text-align: left;">0987654321</td>
                                </tr>
                                <tr>
                                    <th>6</th>
                                    <td style="text-align: left;">Đại lý A</td>
                                    <td style="text-align: left;">0987654321</td>
                                </tr>
                                <tr>
                                    <th>7</th>
                                    <td style="text-align: left;">Đại lý A</td>
                                    <td style="text-align: left;">0987654321</td>
                                </tr>
                                <tr>
                                    <th>8</th>
                                    <td style="text-align: left;">Đại lý A</td>
                                    <td style="text-align: left;">0987654321</td>
                                </tr>
                                <tr>
                                    <th></th>
                                    <td style="text-align: left;">Tổng</td>
                                    <td style="text-align: left;">0987654321</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            ...
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>
</body>
</html>
