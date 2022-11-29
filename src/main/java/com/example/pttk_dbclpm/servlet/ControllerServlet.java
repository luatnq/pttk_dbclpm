package com.example.pttk_dbclpm.servlet;

import com.example.pttk_dbclpm.dao.NhaCungCapDAO;
import com.example.pttk_dbclpm.dao.NhanVienDAO;
import com.example.pttk_dbclpm.dao.impl.NhaCungCapDAOImpl;
import com.example.pttk_dbclpm.dao.impl.NhanVienDAOImpl;
import com.example.pttk_dbclpm.entity.NhaCungCap;
import com.example.pttk_dbclpm.entity.NhanVien;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import static com.example.pttk_dbclpm.constant.Constant.Web.NHA_CUNG_CAP_LIST;

public class ControllerServlet extends HttpServlet {

  private NhanVienDAO nhanVienDAO = new NhanVienDAOImpl();
  private NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAOImpl();

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    doGet(request, response);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String action = request.getServletPath();
//    action.
//    try {
    switch (action) {
      case "/login":
        showFormLogin(request, response);
        break;
      case "/check_login":
        login(request, response);
        break;
      case "/home":
        showHome(request, response);
        break;
      case "/nccs":
        showNhaCungCapList(request, response);
        break;
      case "/nccs-search":
        showNhaCungCapList(request, response);
        break;
      case "/nccs-add":
        try {
          luuNcc(request, response);
        } catch (SQLException e) {
          throw new RuntimeException(e);
        }
        break;
      case "/nls":
        showNguyenLieuList(request, response);
        break;

    }
  }


  private void showFormLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
    dispatcher.forward(request, response);
  }

  private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    NhanVien nhanVien = nhanVienDAO.login(username, password);
    if (Objects.nonNull(nhanVien)) {
      request.getRequestDispatcher("GdNhanVienChinh.jsp").forward(request, response);
    } else {
      request.getRequestDispatcher("login.jsp").forward(request, response);
    }
//    int i = 0;
  }

  private void showHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("GdNhanVienChinh.jsp").forward(request, response);

  }

  private void showNhaCungCapList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String nameSearch = request.getParameter("name");
    List<NhaCungCap> nhaCungCaps = nhaCungCapDAO.list(nameSearch);
    request.setAttribute(NHA_CUNG_CAP_LIST, nhaCungCaps);
    HttpSession session = request.getSession();
    session.setAttribute(NHA_CUNG_CAP_LIST, nhaCungCaps);
    request.getRequestDispatcher("GdDanhSachNCC.jsp").forward(request, response);
  }

  private void luuNcc(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
    String ten = request.getParameter("producerName");
    String diaChi = request.getParameter("producerAddress");
    String sdt = request.getParameter("producerPhone");

    NhaCungCap nhaCungCap = new NhaCungCap(ten, diaChi, sdt);
    nhaCungCapDAO.luuNcc(nhaCungCap);
    showNhaCungCapList(request, response);
  }

  private void showNguyenLieuList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("GdDanhSachNL.jsp").forward(request, response);
  }
}
