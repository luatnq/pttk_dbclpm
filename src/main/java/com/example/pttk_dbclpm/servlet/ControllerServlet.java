package com.example.pttk_dbclpm.servlet;

import com.example.pttk_dbclpm.dao.NguyenLieuDAO;
import com.example.pttk_dbclpm.dao.NhaCungCapDAO;
import com.example.pttk_dbclpm.dao.NhanVienDAO;
import com.example.pttk_dbclpm.dao.impl.NguyenLieuDAOImpl;
import com.example.pttk_dbclpm.dao.impl.NhaCungCapDAOImpl;
import com.example.pttk_dbclpm.dao.impl.NhanVienDAOImpl;
import com.example.pttk_dbclpm.entity.NguyenLieu;
import com.example.pttk_dbclpm.entity.NguyenLieuNhaCungCap;
import com.example.pttk_dbclpm.entity.NhaCungCap;
import com.example.pttk_dbclpm.entity.NhanVien;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.pttk_dbclpm.constant.Constant.Web.*;

public class ControllerServlet extends HttpServlet {

  private NhanVienDAO nhanVienDAO = new NhanVienDAOImpl();
  private NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAOImpl();
  private NguyenLieuDAO nguyenLieuDAO = new NguyenLieuDAOImpl();

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    doGet(request, response);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    try {
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
        case "/nccs_search":
          showNhaCungCapList(request, response);
          break;
        case "/nccs_add":
          luuNcc(request, response);
          break;
        case "/nls":
          showNguyenLieuList(request, response);
          break;
        case "/nls_add":
          addNguyenLieu(request, response);
          break;
        case "/nls_search":
          showNguyenLieuList(request, response);
          break;
        case "/nls_pick":
          pushNguyenLieuDaChon(request, response);
          break;
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
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
    List<NguyenLieuNhaCungCap> nguyenLieus = new ArrayList<>();
    request.setAttribute(NHA_CUNG_CAP_LIST, nhaCungCaps);
    HttpSession session = request.getSession();
    session.setAttribute(NHA_CUNG_CAP_LIST, nhaCungCaps);
    session.setAttribute(NGUYEN_LIEU_DA_CHON, nguyenLieus);
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
    String nccIdStr = request.getParameter("ncc_id");
    HttpSession session = request.getSession();
    Integer nccId = Objects.nonNull(nccIdStr) ? Integer.parseInt(request.getParameter("ncc_id")) :
          (Integer) session.getAttribute(NHA_CUNG_CAP_ID);
    if (Objects.nonNull(request.getParameter("ncc_name"))) {
      session.setAttribute(TEN_NHA_CUNG_CAP, request.getParameter("ncc_name"));
    }
    session.removeAttribute(NHA_CUNG_CAP_ID);
    List<NguyenLieu> nguyenLieus = nguyenLieuDAO.list(request.getParameter("name"), nccId);
    request.setAttribute(NGUYEN_LIEU_LIST, nguyenLieus);
    session.setAttribute(NGUYEN_LIEU_LIST, nguyenLieus);
    session.setAttribute(NHA_CUNG_CAP_ID, nccId);
//    PrintWriter out1= response.getWriter();
//    out1.println("<script type=\"text/javascript\">");
//    out1.println("alert('Pop-up alert...');");
//    out1.println("location='index.jsp';");
//    out1.println("</script>");
    request.getRequestDispatcher("GdDanhSachNL.jsp").forward(request, response);

  }


  private void pushNguyenLieuDaChon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    List<NguyenLieuNhaCungCap> nguyenLieus = (List<NguyenLieuNhaCungCap>) session.getAttribute(NGUYEN_LIEU_DA_CHON);
    session.removeAttribute(NGUYEN_LIEU_DA_CHON);
    String tenNguyenLieu = request.getParameter("productNameEnter");
    Integer soLuongNguyenLieu = Integer.valueOf(request.getParameter("productNumber"));
    Integer donGiaNguyenLieu = Integer.valueOf(request.getParameter("productPrice"));
    Integer idNguyenLieu = nguyenLieuDAO.getIdNguyenLieu(tenNguyenLieu);
    Integer nccId = (Integer) session.getAttribute(NHA_CUNG_CAP_ID);
    nguyenLieus.add(new NguyenLieuNhaCungCap(
          soLuongNguyenLieu,
          donGiaNguyenLieu,
          nccId,
          idNguyenLieu,
          tenNguyenLieu)
    );
    session.setAttribute(NGUYEN_LIEU_DA_CHON, nguyenLieus);
    showNguyenLieuList(request, response);

  }


  private void addNguyenLieu(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
    HttpSession session = request.getSession();
    Integer nccId = (Integer) session.getAttribute(NHA_CUNG_CAP_ID);
    String productName = request.getParameter("productNewName");
    nguyenLieuDAO.luuNguyenLieu(productName, nccId);
    showNguyenLieuList(request, response);
  }

  private void luuHoaDon(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
    HttpSession session = request.getSession();

    List<NguyenLieuNhaCungCap> nguyenLieus = (List<NguyenLieuNhaCungCap>) session.getAttribute(NGUYEN_LIEU_DA_CHON);
  }

}
