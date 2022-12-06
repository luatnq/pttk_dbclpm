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
    <script src="https://code.jquery.com/jquery-3.3.1.js"
            integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous">
    </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dsNl.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/toastr.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
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
                    <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/home">Trang chủ</a></li>
                    <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/home">Nhập nguyên liệu</a></li>
                    <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/nccs">Danh sách nhà cung cấp</a>
                    </li>
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
        <div class="border-table">
            <div class="custom-scroll-bar" style="height: 300px !important; overflow-y: scroll;">


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
                    <tbody class="table-content" id="nguyenLieuDaNhap">
                    <%
                        int j = 1;
                        int totalMoney = 0;
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
                                totalMoney+=nguyenLieu.getTongTien();
                            }
                        }
                    %>
                    </tbody>
                </table>
            </div>
            <div class="fw-bold text-end py-2 px-3">
                <span class="d-inline-block me-4">Tổng:</span>
                <span class="d-inline-block ms-4"><%=totalMoney%></span>
            </div>
        </div>
    </div>
    <%--    message noti--%>
    <%
        String message = (String) session.getAttribute(MESSAGE);
        String typeMessage = (String) session.getAttribute(TYPE_MESSAGE);
        if (Objects.nonNull(message) && Objects.nonNull(typeMessage)) {
    %>
    <div id="message" class="alert alert-<%=typeMessage%>"
         style="position: absolute; top: 90px; right: -1px; width: 500px;">
        <%=message%>
    </div>
    <script>
        console.log("<%=typeMessage%>")
        $("#message").hide()
        $("#message").show()
        setTimeout(() => {
            $("#message").hide()
        }, 2000)
    </script>
    <%
            session.removeAttribute(MESSAGE);
            session.removeAttribute(TYPE_MESSAGE);
        }%>

</div>
<!-- Modal nhập nguyên liệu-->
<jsp:include page="GdNhapNguyenLieu.jsp"/>
<jsp:include page="GdThemMoiNL.jsp"/>
<jsp:include page="GdHoaDonNguyenLieu.jsp"/>

</body>
<script src="${pageContext.request.contextPath}/js/toastr.js"></script>
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
                let totalMoney = 0;
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
                    totalMoney += item.tongTien;
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
                $("#totalMoney").text(totalMoney)
                $("#printBill").modal("show")

            }
        })
    }

</script>
</html>
