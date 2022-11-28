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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css"/>
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans:wght@400;700&display=swap" rel="stylesheet"/>
    <!--  -->
    <title>Đăng nhập</title>
</head>
<body>
<div class="container">
    <div class="container_1">
        <img src="${pageContext.request.contextPath}/images/login_user.png" alt="" class="customImg" style="margin: -50px"/>
    </div>
    <div class="container_2">
        <form action="<%=request.getContextPath()%>/check_login">
            <div class="form-group" style="margin-top: 100px;">
                    <span class="has-float-label">
                        <input type="text" name="username" value="" class="form-control" id="username"
                               placeholder="Tên đăng nhập"/>
                    </span>
            </div>
            <div class="form-group">
                    <span class="has-float-label">
                        <input type="text" name="password" value="" class="form-control" id="password"
                               placeholder="Mật khẩu"/>
                    </span>
            </div>
            <div class="col-login">
                <input type="submit" value="Đăng nhập" style="padding: 8px 55px; border-radius: 10px; width: 100%"
                       data-bs-toggle="modal" data-bs-target="#exampleModal" class="btn btn-primary">
            </div>
        </form>
    </div>
</div>
</body>
</html>
