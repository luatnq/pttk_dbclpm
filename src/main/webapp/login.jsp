<%--
  Created by IntelliJ IDEA.
  User: luatnq
  Date: 08/11/2022
  Time: 08:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"/>
    <script src="https://code.jquery.com/jquery-3.3.1.js"
            integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/toastr.css"/>
    <!--  -->
    <title>Đăng nhập</title>
</head>
<body>
<div class="container">
    <div class="container_1">
        <img src="${pageContext.request.contextPath}/images/login_user.png" alt="" class="customImg"
             style="margin: -50px"/>
    </div>
    <div class="container_2">
        <%--        <form action="<%=request.getContextPath()%>/check_login" method="post">--%>
        <form>
            <div class="form-group" style="margin-top: 100px;">
                    <span class="has-float-label">
                        <input type="text" name="username" value="" class="form-control" id="username"
                               placeholder="Tên đăng nhập" required>
                    </span>
            </div>
            <div class="form-group">
                    <span class="has-float-label">
                        <input type="password" name="password" value="" class="form-control" id="password"
                               placeholder="Mật khẩu" required>
                    </span>
            </div>
            <div class="col-login">
                <%--                <input type="submit" value="Đăng nhập" style="padding: 8px 55px; border-radius: 10px; width: 100%"--%>
                <%--                       data-bs-toggle="modal" data-bs-target="#exampleModal" class="btn btn-primary">--%>
                <button type="button" onclick="login()" style="padding: 8px 55px; border-radius: 10px; width: 100%"
                        data-bs-toggle="modal" data-bs-target="#exampleModal" class="btn btn-primary">
                    Đăng nhập
                </button>
            </div>
        </form>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/toastr.js"></script>
<script type="text/javascript">
    const login = () => {
        let username = $('#username').val();
        let password = $('#password').val();
        $.ajax({
            url: "/pttk_dbclpm_war_exploded/check_login",
            data: {username: username, password: password},
            type: 'POST',
            success: (res) => {
                if (res.id != null) {
                    window.location.replace("http://localhost:8080/pttk_dbclpm_war_exploded/home");
                } else {
                    toastr.error("Tài khoản hoặc mật khẩu không chính xác");
                }
            }
        })
    }
</script>
</body>
</html>
