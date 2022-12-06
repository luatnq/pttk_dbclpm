<%--
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
<div class="modal fade" id="addProducts" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content custum-modal">
            <div class="modal-body">
                <div style="text-align: right">
                    <button style="background-color: #d6d5d5;border-radius: 50%;font-size: 12px;
                            " type="button" class="btn-close p-2" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="title-modal-body">Thêm mới nguyên liệu</div>
                <form action="<%=request.getContextPath()%>/nls_add" method="get" name="addNguyenLieu"
                      onsubmit="return validateForm()">
                    <div style="padding: 20px 0;">
                        <b-row class="mb-5">
                            <div>
                                <label for="productNewName" class="form-label">Tên nguyên liệu<span style="color: red;">*</span></label>
                                <input type="text" required class="form-control" id="productNewName"
                                       name="productNewName"
                                       placeholder="Tên nguyên liệu...">
                                <p class="mb-0" id="err-name" style="color: red;"></p>
                            </div>
                        </b-row>

                    </div>

                    <div class="control-button" style="text-align: center;">
                        <button type="button" data-bs-dismiss="modal"
                                style="padding: 8px 20px; border-radius: 10px; width: 150px; margin-right: 20px;"
                                class="btn btn-outline-secondary">
                            Hủy bỏ
                        </button>
                        <input type="submit" value="OK"
                               style="padding: 8px 20px; border-radius: 10px; width: 150px"
                               class="btn btn-primary">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>

<script type="text/javascript">
    function validateForm() {
        let productName = document.forms["addNguyenLieu"]["productNewName"].value;
        console.log(productName);
        if (productName == "") {
            document.querySelector("#err-name").innerHTML = "Tên nguyên liệu không được để trống";
            return false;
        }
    }
</script>
</html>
