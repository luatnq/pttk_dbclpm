<%@ page import="static com.example.pttk_dbclpm.constant.Constant.Web.NHA_CUNG_CAP_ID" %>
<%@ page import="static com.example.pttk_dbclpm.constant.Constant.Web.TEN_NHA_CUNG_CAP" %><%--
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
<div class="modal fade" id="enterProducts" tabindex="-1" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
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
                                <label for="productNameEnter" class="form-label">Tên nguyên liệu<span style="color: red;">*</span></label>
                                <input type="text" required class="form-control" id="productNameEnter"
                                       name="productNameEnter" placeholder="Name...">
                            </div>
                        </b-row>
                        <b-row style="display: flex; justify-content: space-between; margin:24px 0;">
                            <div style="width: 48%;">
                                <label for="productNumber" class="form-label">Số lượng<span style="color: red;">*</span></label>
                                <input type="text" required class="form-control" id="productNumber"
                                       name="productNumber" placeholder="Number...">
                            </div>
                            <div style="width: 48%;">
                                <label for="productPrice" class="form-label">Đơn giá(VNĐ)<span style="color: red;">*</span></label>
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
                               onclick="removeTable()"
                               style="padding: 8px 20px; border-radius: 10px; width: 150px"
                               class="btn btn-primary">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    const removeTable = () => {
        window.location='<%=request.getContextPath()%>/nls?ncc_id=<%=session.getAttribute(NHA_CUNG_CAP_ID)%>&ncc_name=<%=session.getAttribute(TEN_NHA_CUNG_CAP)%>'
    }

    function validateForm() {
        let productName = document.forms["form-product"]["product-name"].value;
        let productNumber = document.forms["form-product"]["product-number"].value;
        let productPrice = document.forms["form-product"]["product-price"].value;
        if (productName == "") {
            document.querySelector("#err-name").innerHTML = "Tên nguyên liệu không được để trống";
            return false;
        }
        if (productNumber == "") {
            document.querySelector("#err-number").innerHTML = "Số lượng không được để trống";
            return false;
        }
        if (productNumber < 0) {
            document.querySelector("#err-number").innerHTML = "Số lượng không thể âm";
            return false;
        }
        if (productPrice == "") {
            document.querySelector("#err-price").innerHTML = "Giá không được để trống";
            return false;
        }
        if (productPrice < 0) {
            document.querySelector("#err-number").innerHTML = "Giá không thể âm";
            return false;
        }
    }
</script>
</html>
