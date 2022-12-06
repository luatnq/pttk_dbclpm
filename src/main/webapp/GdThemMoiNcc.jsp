<%--
  Created by IntelliJ IDEA.
  User: luatnq
  Date: 07/12/2022
  Time: 01:40
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
</head>
<body>
<div class="modal fade" id="addProducts" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content custum-modal">
            <div class="modal-body">
                <div style="text-align: right">
                    <button style="background-color: #d6d5d5; border-radius: 50%; font-size: 12px; padding: 7px;
                                " type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form action="<%=request.getContextPath()%>/nccs_add" name="addProduct" method="get"
                      onsubmit="return validateForm()">
                    <div class="title-modal-body">Thêm mới nhà cung cấp</div>
                    <div style="padding: 20px 0;">
                        <b-row style="display: flex; justify-content: space-between;" class="mb-3">
                            <div style="width: 48%;">
                                <label for="producerName" class="form-label">Tên nhà cung cấp <span
                                        style="color: red;">*</span>
                                </label>
                                <input type="text" name="producerName" class="form-control" id="producerName"
                                       placeholder="Tên nhà cung cấp...">
                                <p class="mb-0" id="err-name" style="color: red;"></p>
                            </div>
                            <div style="width: 48%;">
                                <label for="producerPhone" class="form-label">Số điện thoại <span
                                        style="color: red;">*</span>
                                </label>
                                <input type="text" name="producerPhone" class="form-control" id="producerPhone"
                                       placeholder="Số điện thoại...">
                                <p class="mb-0" id="err-number" style="color: red;"></p>
                            </div>
                        </b-row>
                        <b-row>
                            <div class="mb-6">
                                <label for="producerAddress" class="form-label">Địa chỉ <span
                                        style="color: red;">*</span>
                                </label>
                                <input type="text" name="producerAddress" class="form-control" id="producerAddress"
                                       placeholder="Địa chỉ...">
                                <p class="mb-0" id="err-address" style="color: red;"></p>
                            </div>
                        </b-row>
                    </div>

                    <div class="control-button" style="text-align: center;">
                        <button type="button" data-bs-dismiss="modal"
                                style="padding: 8px 20px; border-radius: 10px; width: 30%; margin-right: 20px;"
                                class="btn btn-outline-secondary">
                            Hủy bỏ
                        </button>
                        <input type="submit" value="Ok"
                               style="padding: 8px 20px; border-radius: 10px; width: 30%"
                               class="btn btn-primary">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>

<script type="text/javascript">
    $(function () {
        $("#header").load("header.jsp");
        // $("#footer").load("../../footer.html");
        // document.getElementById('search-null').style.display = 'none';
    });

    function validateForm() {
        let producerName = document.forms["addProduct"]["producerName"].value;
        let producerNumber = document.forms["addProduct"]["producerPhone"].value;
        let producerAddress = document.forms["addProduct"]["producerAddress"].value;
        if (producerName == "") {
            document.querySelector("#err-name").innerHTML = "Tên nguyên liệu không được để trống";
            $("#addProducts").modal("show");
            return false;
        }
        if (producerNumber == "") {
            document.querySelector("#err-number").innerHTML = "Số điện thoại không được để trống";
            return false;
        }
        if (producerAddress == "") {
            document.querySelector("#err-address").innerHTML = "Địa chỉ không được để trống";
            return false;
        }
    }

</script>
</html>
