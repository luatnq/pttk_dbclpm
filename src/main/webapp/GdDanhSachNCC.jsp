<%@ page import="com.example.pttk_dbclpm.entity.NhaCungCap" %>
<%@ page import="java.util.List" %>
<%@ page import="static com.example.pttk_dbclpm.constant.Constant.Web.NHA_CUNG_CAP_LIST" %>
<%@ page import="com.example.pttk_dbclpm.entity.NhanVien" %>
<%@ page import="static com.example.pttk_dbclpm.constant.Constant.Web.NHAN_VIEN_LOGIN" %>
<%@ page import="static com.example.pttk_dbclpm.constant.Constant.Web.*" %>
<%@ page import="java.util.Objects" %>
<%@ page import="static com.example.pttk_dbclpm.constant.Constant.Message.SUCCESS" %><%--
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  Created by IntelliJ IDEA.
  User: luatnq
  Date: 24/11/2022
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <script src="https://code.jquery.com/jquery-3.3.1.js"
            integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous">
    </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dsNcc.css">

    <link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
          integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <title>Danh sách nhà cung cấp</title>
</head>

<body>

<%
    NhanVien nhanVien = (NhanVien) session.getAttribute(NHAN_VIEN_LOGIN);
%>
<!-- <header id="header"></header> -->
<div style="padding-bottom: 20px;">
    <span class="screen-darken"></span>
    <header class="section-header py-2 ">
        <div style="display: flex;justify-content: space-between; margin: 10px 40px; align-items: center;">
            <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
                <ol class="breadcrumb mb-0">
                    <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/home">Trang chủ</a></li>
                    <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/home">Nhập nguyên liệu</a>
                    </li>
                    <li class="breadcrumb-item active"><a href="#">Danh sách nhà cung cấp</a></li>
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

<%
    List<NhaCungCap> nhaCungCaps = (List<NhaCungCap>) session.getAttribute(NHA_CUNG_CAP_LIST);
    session.removeAttribute(NHA_CUNG_CAP_LIST);
%>

<div class="container1 pb-5">
    <div class="row" style="justify-content: center; width: 100vw;">
        <div class="col-md-12 order-md-2 col-lg-9">
            <div class="d-flex">
                <h2 class="title-header">Danh sách nhà cung cấp</h2>
            </div> <!-- <div class="container-fluid"> -->
            <div class="row two-table justify-content-center">
                <div class="row ">

                    <form action="<%=request.getContextPath()%>/nccs_search">
                        <div class="col-12 header-search">
                            <div style="display: flex;padding: 10px 10px; justify-content: space-between; flex: 1; height: 65px;">
                                <input type="search" required="required" class="header_search_input h-100" name="name"
                                       id="name" placeholder="Nhập tên nhà cung cấp để tìm kiếm"/>
                                <input type="submit" value="Tìm kiếm" data-bs-dismiss="modal"
                                       class="btn btn-primary d-flex align-items-center" data-bs-toggle="modal"
                                       data-bs-target="#exampleModal1"><img
                                    src="${pageContext.request.contextPath}/images/search.png" class="me-1"
                                    alt="">
                            </div>
                        </div>
                    </form>

                </div>
            </div>
            <div>
                <div style="display: flex; justify-content:end; padding: 40px 0 20px 0;">
                    <button type="button" data-bs-dismiss="modal" class="btn btn-primary" data-bs-toggle="modal"
                            data-bs-target="#addProducts">
                        + Thêm mới
                    </button>
                </div>

                <table class="table table-striped">
                    <thead class="header-table">
                    <tr>
                        <th scope="col" class="text-center">STT</th>
                        <th scope="col" class="text-left">Tên Nhà cung cấp</th>
                        <th scope="col" class="text-left">Số điện thoại</th>
                        <th scope="col" class="text-end">Địa chỉ</th>
                        <th scope="col" class="text-end"></th>
                    </tr>
                    </thead>

                    <tbody class="table-content">
                    <%
                        int i = 1;
                        for (NhaCungCap nhaCungCap : nhaCungCaps) {
                    %>
                    <tr onclick="window.location='<%=request.getContextPath()%>/nls?ncc_id=<%=nhaCungCap.getId()%>&ncc_name=<%=nhaCungCap.getTen()%>'">
                        <th class="text-center"><%=i++%>
                        </th>
                        <td class="text-left"><%=nhaCungCap.getTen()%>
                        </td>
                        <td class="text-left"><%=nhaCungCap.getSdt()%>
                        </td>
                        <td class="text-end"><%=nhaCungCap.getDiaChi()%>
                        </td>
                        <th scope="col" class="text-end"></th>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
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
<jsp:include page="GdThemMoiNcc.jsp"/>

</body>
</html>

<script type="text/javascript">
    $(function () {
        $("#header").load("header.jsp");
    });

</script>