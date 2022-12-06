<%@ page import="static com.example.pttk_dbclpm.constant.Constant.Web.TEN_NHA_CUNG_CAP" %>
<%@ page import="static com.example.pttk_dbclpm.constant.Constant.Web.NHA_CUNG_CAP_ID" %><%--
  Created by IntelliJ IDEA.
  User: luatnq
  Date: 07/12/2022
  Time: 01:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dsNl.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/toastr.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
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
                            <p id="createdDate"></p>
                        </div>
                    </div>
                    <div class="border-table">
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
                                </tbody>
                            </table>
                        </div>
                        <div class="fw-bold text-end py-2 px-3">
                            <span class="d-inline-block me-4">Tổng:</span>
                            <span class="d-inline-block ms-4" id="totalMoney"></span>
                        </div>
                    </div>

                    <%--                    <div class="custom-scroll-bar" style="height: 260px !important; overflow-y: scroll;">--%>
                    <%--                        --%>
                    <%--                    </div>--%>
                </div>
                <div class="control-button mt-3" style="text-align: center;">
                    <button type="button" data-bs-dismiss="modal" onclick="removeTable()"
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
<script>
    const removeTable = () => {
        $("#nguyenLieuDaNhap").children().remove();
        window.location = '<%=request.getContextPath()%>/nls?ncc_id=<%=session.getAttribute(NHA_CUNG_CAP_ID)%>&ncc_name=<%=session.getAttribute(TEN_NHA_CUNG_CAP)%>'
    }
</script>
</html>
