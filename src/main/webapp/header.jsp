<%--
  Created by IntelliJ IDEA.
  User: luatnq
  Date: 24/11/2022
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="keywords" content="htmlcss bootstrap menu, navbar, offcanvas, sidebar nav menu CSS examples" />
  <meta name="description" content="Bootstrap 5 navbar make offcanvas on responsive mobile" />
  <title>Cộng tác viên </title>
  <script src="https://code.jquery.com/jquery-3.3.1.js"
          integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
        crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
          crossorigin="anonymous"></script>
  <script src="http://127.0.0.1:5500/js/js/header.js"></script>
</head>

<body>
<div style="padding-bottom: 20px;">
  <span class="screen-darken"></span>
  <header class="section-header py-4 ">
    <div style="display: flex;justify-content: space-between; margin: 10px 40px; align-items: center;">
      <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="#">Home</a></li>
          <li class="breadcrumb-item active" aria-current="page">Library</li>
        </ol>
      </nav>
      <button type="button" class="btn" style="padding: 0px;">
        <img src="${pageContext.request.contextPath}/images/avatarDefault.png" width="50px" height="50px" />
        <span style="text-align: center;">Hiệp đẹp trai</span>
      </button>
    </div>
  </header>
  </nav>
  <hr class="my-0" />
</div>

</body>

</html>