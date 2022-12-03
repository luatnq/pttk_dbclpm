<%@ page import="com.example.pttk_dbclpm.entity.NguyenLieu" %>
<%@ page import="static com.example.pttk_dbclpm.constant.Constant.Web.NGUYEN_LIEU_LIST" %>
<%@ page import="java.util.List" %>
<%@ page import="static com.example.pttk_dbclpm.constant.Constant.Web.TEN_NHA_CUNG_CAP" %>
<%@ page import="com.example.pttk_dbclpm.entity.NguyenLieuNhaCungCap" %>
<%@ page import="static com.example.pttk_dbclpm.constant.Constant.Web.*" %>
<%@ page import="java.util.Objects" %>
<%@ page import="com.example.pttk_dbclpm.entity.NhanVien" %><%--
  Created by IntelliJ IDEA.
  User: luatnq
  Date: 08/11/2022
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dsNl.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css">


    <title>Danh sách nguyên liệu</title>
</head>
<%
    NhanVien nhanVien = (NhanVien) session.getAttribute(NHAN_VIEN_LOGIN);
%>
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
                <img src="${pageContext.request.contextPath}/images/avatarDefault.png" width="50px" height="50px"/>
                <span style="text-align: center;"><%=nhanVien.getTen()%></span>
            </button>
        </div>
    </header>
    </nav>
    <hr class="my-0"/>
</div>
<div class="d-flex px-5 justify-content-around mb-4 mt-4" style="color: #2563EB;">
    <h4 class="px-5" style="">
        <%= "Danh sách nguyên liệu đã nhập tại nhà cung cấp " + session.getAttribute(TEN_NHA_CUNG_CAP)%>
    </h4>
    <h4 style="">
        Danh sách nguyên liệu đã nhập
    </h4>
</div>
<div class="d-flex px-5">
    <div class=" px-5" style="width: 50%; border-right: 1px solid #ccc">
        <form action="<%=request.getContextPath()%>/nls_search" method="post">
            <div class="col-12 header-search">
                <div style="display: flex ;padding: 10px 10px; justify-content: space-between; flex: 1; height: 55px;">
                    <input type="search" required="required" class="header_search_input h-100" id="name" name="name"
                           placeholder="Nhập tên nguyên liệu để tìm kiếm"/>
                    <input type="submit" value="Tìm kiếm" style="width: 130px" data-bs-dismiss="modal"
                           class="btn btn-primary d-flex align-items-center" data-bs-toggle="modal"
                           data-bs-target="#exampleModal1">
                    <img src="${pageContext.request.contextPath}/images/search.png" class="me-1" alt="">
                </div>
            </div>
        </form>
    </div>
    <div style="width: 50%;">

    </div>
</div>

<%
    List<NguyenLieu> nguyenLieuList = (List<NguyenLieu>) session.getAttribute(NGUYEN_LIEU_LIST);
    session.removeAttribute(NGUYEN_LIEU_LIST);
    List<NguyenLieuNhaCungCap> nguyenLieuNhaCungCaps = (List<NguyenLieuNhaCungCap>) session.getAttribute(NGUYEN_LIEU_DA_CHON);
%>
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
            <%
                int i = 1;
                for (NguyenLieu nguyenLieu : nguyenLieuList) {
            %>
            <tr onclick="showModalEnter(this)" id="<%=nguyenLieu.getTen()%>">
                <th class="text-center"><%=i++%>
                </th>
                <td class="nr" style="text-align: left;"><%=nguyenLieu.getTen()%>
                </td>
                <td style="text-align: end;"><%=nguyenLieu.getSoLuong()%>
                </td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
    <div class="px-5" style="width: 50%">
        <div style="display: flex; justify-content:end; padding: 40px 0 20px 0;">
            <button type="button" onclick="luuHoaDon()"
                    data-bs-dismiss="modal" class="btn btn-primary" data-bs-toggle="modal"
                    data-bs-target="#printBill" data-backdrop="static" and data-keyboard="false">
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
            <%
                int j = 1;
                if (Objects.nonNull(nguyenLieuNhaCungCaps) && nguyenLieuNhaCungCaps.size() > 0) {
                    for (NguyenLieuNhaCungCap nguyenLieu : nguyenLieuNhaCungCaps) {
            %>
            <tr>
                <th class="text-center"><%=j++%>
                </th>
                <td style="text-align: left;"><%=nguyenLieu.getNguyenLieu().getTen()%>
                </td>
                <td style="text-align: end;"><%=nguyenLieu.getSoLuong()%>
                </td>
                <td style="text-align: end;"><%=nguyenLieu.getDonGia()%>
                </td>
                <td style="text-align: end;"><%=nguyenLieu.getTongTien()%>
                </td>
            </tr>

            <%
                    }
                }
            %>
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
                <form action="<%=request.getContextPath()%>/nls_pick" method="post">
                    <div style="padding: 20px 0;">
                        <b-row class="mb-5">
                            <div>
                                <label for="productNameEnter" class="form-label">Tên nguyên liệu</label>
                                <input type="text" required class="form-control" id="productNameEnter"
                                       name="productNameEnter" placeholder="Name...">
                            </div>
                        </b-row>
                        <b-row style="display: flex; justify-content: space-between; margin:24px 0;">
                            <div style="width: 48%;">
                                <label for="productNumber" class="form-label">Số lượng</label>
                                <input type="text" required class="form-control" id="productNumber"
                                       name="productNumber" placeholder="Number...">
                            </div>
                            <div style="width: 48%;">
                                <label for="productPrice" class="form-label">Đơn giá(VNĐ)</label>
                                <input type="text" required class="form-control" id="productPrice"
                                       name="productPrice" placeholder="Price...">
                            </div>
                        </b-row>
                    </div>

                    <div class="control-button" style="text-align: center;">
                        <button type="button" data-bs-dismiss="modal"
                                style="padding: 8px 20px; border-radius: 10px; width: 150px; margin-right: 20px;"
                                class="btn btn-outline-secondary">Hủy bỏ
                        </button>
                        <input type="submit" value="OK" data-bs-dismiss="modal"
                               style="padding: 8px 20px; border-radius: 10px; width: 150px" class="btn btn-primary">
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
                <div class="title-modal-body">Thêm mới nguyên liệu</div>
                <form action="<%=request.getContextPath()%>/nls_add" method="post">
                    <div style="padding: 20px 0;">
                        <b-row class="mb-5">
                            <div>
                                <label for="productNewName" class="form-label">Tên nguyên liệu</label>
                                <input type="text" required class="form-control" id="productNewName"
                                       name="productNewName"
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
                        <input type="submit" value="OK" data-bs-dismiss="modal"
                               style="padding: 8px 20px; border-radius: 10px; width: 150px" class="btn btn-primary">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Modal in hóa đơn thành công -->
<div class="modal fade" id="printBill" tabindex="-1" hidePrevented="true" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content custum-modal">
            <div class="modal-body">
                <div style="text-align: right">
                    <button style="
                                            background-color: #d6d5d5;
                                                border-radius: 50%;
                                            font-size: 12px;
                            " type="button" class="btn-close p-2" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="title-modal-success mb-2">
                    <img src="${pageContext.request.contextPath}/images/iconSuccess.png" alt="" width="30px"
                         height="30px"
                         style="margin-bottom: 6px;">
                    <br/>
                    In hóa đơn thành công!
                </div>
                <div class="box-detail py-3 px-4">
                    <p class="text-center box-detai-title">Hoá Đơn Nhập Nguyên Liệu</p>
                    <div class="d-flex justify-content-around">
                        <div>
                            <p id="nameDaiLy"></p>
                            <p id="nhanVien"></p>
                        </div>
                        <div>
                            <p>Số điện thoại đại lý: 0987654321</p>
                            <p id="createdDate"></p>
                        </div>
                    </div>

                    <div class="custom-scroll-bar" style="height: 260px !important; overflow-y: scroll;">
                        <table class="table table-striped mb-0">
                            <thead class="header-table">
                            <tr>
                                <th scope="col" class="text-center">STT</th>
                                <th scope="col" class="text-left">Tên nguyên liệu</th>
                                <th scope="col" class="text-end">Số lượng</th>
                                <th scope="col" class="text-end">Đơn giá(VND)</th>
                                <th scope="col" class="text-end">Tổng tiền(VND)</th>

                            </tr>
                            </thead>
                            <tbody class="table-content" id="hoaDonList">
                            <%--                            --%>
                            <%--                            <tr>--%>
                            <%--                                <th></th>--%>
                            <%--                                <th></th>--%>
                            <%--                                <th></th>--%>
                            <%--                                <th class="text-end">Tổng</th>--%>
                            <%--                                <th class="text-end">1.000.000</th>--%>
                            <%--                            </tr>--%>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="control-button mt-3" style="text-align: center;">
                    <button type="button" data-bs-dismiss="modal"
                            style="padding: 8px 20px; border-radius: 10px; width: 30%;"
                            class="btn btn-outline-secondary">
                        Đóng
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    const showModalEnter = (row) => {
        var $text = $(row).find(".nr").text();
        $('#productNameEnter').val($text)
        $('#enterProducts').modal('show');
    }

    const luuHoaDon = () => {
        $.ajax({
            url: "/pttk_dbclpm_war_exploded/add_bill",
            type: "POST",
            success: (res) => {
                console.log(res);
                let i = 1;
                res.nguyenLieuNhaCungCaps.forEach((item, index) => {
                    console.log(item);
                    let row =
                        '<tr>' +
                        '<th class="text-center">' + i + '</th>' +
                        '<td style="text-align: left;">' + item.nguyenLieu.ten + '</td>' +
                        '<td style="text-align: end;">' + item.soLuong + '</td>' +
                        '<td style="text-align: end;">' + item.donGia + '</td>' +
                        '<td style="text-align: end;">' + item.tongTien + '</td>' +
                        '</tr>'
                    console.log(row);
                    $('#hoaDonList').append(row);
                    i++;
                });
                const today = new Date();
                const yyyy = today.getFullYear();
                let mm = today.getMonth() + 1; // Months start at 0!
                let dd = today.getDate();

                if (dd < 10) dd = '0' + dd;
                if (mm < 10) mm = '0' + mm;

                const formattedToday = dd + '/' + mm + '/' + yyyy;

                $("#nhanVien").text("Người nhập: " + res.nhanVien.ten)
                $("#nameDaiLy").text("Tên đại lý: " + res.nguyenLieuNhaCungCaps[0].nhaCungCap.ten)
                $("#createdDate").text("Ngày xuất: " + formattedToday)
                $("#printBill").modal("show")

            }
        })
    }

</script>
</html>
