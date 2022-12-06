package com.example.pttk_dbclpm.servlet;

import com.example.pttk_dbclpm.dao.HoaDonNguyenLieuDAO;
import com.example.pttk_dbclpm.dao.NguyenLieuDAO;
import com.example.pttk_dbclpm.dao.NhaCungCapDAO;
import com.example.pttk_dbclpm.dao.NhanVienDAO;
import com.example.pttk_dbclpm.dao.impl.HoaDonNguyenLieuDAOImpl;
import com.example.pttk_dbclpm.dao.impl.NguyenLieuDAOImpl;
import com.example.pttk_dbclpm.dao.impl.NhaCungCapDAOImpl;
import com.example.pttk_dbclpm.dao.impl.NhanVienDAOImpl;
import com.example.pttk_dbclpm.entity.*;
import com.example.pttk_dbclpm.utils.JsonHelper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.pttk_dbclpm.constant.Constant.Message.*;
import static com.example.pttk_dbclpm.constant.Constant.Web.*;

public class ControllerServlet extends HttpServlet {

  private NhanVienDAO nhanVienDAO = new NhanVienDAOImpl();
  private NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAOImpl();
  private NguyenLieuDAO nguyenLieuDAO = new NguyenLieuDAOImpl();
  private HoaDonNguyenLieuDAO hoaDonNguyenLieuDAO = new HoaDonNguyenLieuDAOImpl();

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    doGet(request, response);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String action = request.getServletPath();
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
      case "/add_bill":
        luuHoaDon(request, response);
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
    NhanVien nhanVienLogin = new NhanVien(username, password);
    NhanVien nhanVien = nhanVienDAO.login(username, password);
    if (Objects.nonNull(nhanVien)) {
      HttpSession session = request.getSession();
      session.setAttribute(NHAN_VIEN_LOGIN, nhanVien);
      JsonHelper.convert(nhanVien, response);
    } else {
      request.getRequestDispatcher("login.jsp").forward(request, response);
    }
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

  private void luuNcc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      String ten = request.getParameter("producerName");
      String diaChi = request.getParameter("producerAddress");
      String sdt = request.getParameter("producerPhone");

      NhaCungCap nhaCungCapInput = new NhaCungCap(ten, diaChi, sdt);
      NhaCungCap nhaCungCap = nhaCungCapDAO.luuNcc(nhaCungCapInput);
      if (Objects.isNull(nhaCungCap)) pushMessage(FAIL, FAIL_CONTENT, request);
      else pushMessage(SUCCESS, SUCCESS_CONTENT, request);
      showNhaCungCapList(request, response);
    } catch (SQLException e) {
      pushMessage(FAIL, FAIL_CONTENT, request);
      showNguyenLieuList(request, response);
    }
  }

  private void showNguyenLieuList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String nccIdStr = request.getParameter("ncc_id");
    String nccName = request.getParameter("ncc_name");
    HttpSession session = request.getSession();
    Integer nccId = Objects.nonNull(nccIdStr) ? Integer.parseInt(request.getParameter("ncc_id")) :
          (Integer) session.getAttribute(NHA_CUNG_CAP_ID);
    if (Objects.nonNull(nccName)) {
      session.setAttribute(TEN_NHA_CUNG_CAP, nccName);
    }
    session.removeAttribute(NHA_CUNG_CAP_ID);

    List<NguyenLieu> nguyenLieus = nguyenLieuDAO.list(new NguyenLieuNhaCungCap(request.getParameter("name"), nccId));
    request.setAttribute(NGUYEN_LIEU_LIST, nguyenLieus);
    session.setAttribute(NGUYEN_LIEU_LIST, nguyenLieus);
    session.setAttribute(NHA_CUNG_CAP_ID, nccId);
    request.getRequestDispatcher("GdDanhSachNL.jsp").forward(request, response);
  }


  private void pushNguyenLieuDaChon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    List<NguyenLieuNhaCungCap> nguyenLieus = (List<NguyenLieuNhaCungCap>) session.getAttribute(NGUYEN_LIEU_DA_CHON);
    session.removeAttribute(NGUYEN_LIEU_DA_CHON);
    String tenNguyenLieu = request.getParameter("productNameEnter");
    Integer soLuongNguyenLieu = Integer.valueOf(request.getParameter("productNumber").trim());
    Integer donGiaNguyenLieu = Integer.valueOf(request.getParameter("productPrice").trim());
    Integer idNguyenLieu = nguyenLieuDAO.getIdNguyenLieu(tenNguyenLieu.trim());
    Integer nccId = (Integer) session.getAttribute(NHA_CUNG_CAP_ID);
    String tenNcc = (String) session.getAttribute(TEN_NHA_CUNG_CAP);
    nguyenLieus.add(new NguyenLieuNhaCungCap(
          soLuongNguyenLieu,
          donGiaNguyenLieu,
          nccId,
          tenNcc,
          idNguyenLieu,
          tenNguyenLieu)
    );
    session.setAttribute(NGUYEN_LIEU_DA_CHON, nguyenLieus);
    session.setAttribute(TYPE_MESSAGE, SUCCESS);
    session.setAttribute(MESSAGE, ENTER_SUCCESS);
    showNguyenLieuList(request, response);

  }


  private void addNguyenLieu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      HttpSession session = request.getSession();
      Integer nccId = (Integer) session.getAttribute(NHA_CUNG_CAP_ID);
      String productName = request.getParameter("productNewName").trim();
      NguyenLieuNhaCungCap nguyenLieu = nguyenLieuDAO.luuNguyenLieu(productName, nccId);
      if (Objects.isNull(nguyenLieu)) pushMessage(FAIL, FAIL_CONTENT, request);
      else pushMessage(SUCCESS, SUCCESS_CONTENT, request);
      showNguyenLieuList(request, response);
    } catch (SQLException e) {
      pushMessage(FAIL, FAIL_CONTENT, request);
      showNguyenLieuList(request, response);
    }
  }

  private void luuHoaDon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      HttpSession session = request.getSession();
      NhanVien nhanVien = (NhanVien) session.getAttribute(NHAN_VIEN_LOGIN);
      List<NguyenLieuNhaCungCap> nguyenLieus = (List<NguyenLieuNhaCungCap>) session.getAttribute(NGUYEN_LIEU_DA_CHON);

      if (nguyenLieus.size() == 0){
        pushMessage(FAIL, "Lưu hóa đơn không thành công", request);
        showNguyenLieuList(request, response);
      }else{
        HoaDonNguyenLieu hoaDonNguyenLieu = new HoaDonNguyenLieu(
              nhanVien.getId(),
              nhanVien.getTen(),
              calTotalMoney(nguyenLieus),
              null,
              nguyenLieus
        );
        session.setAttribute(HOA_DON_NGUYEN_LIEU, hoaDonNguyenLieu);
        nguyenLieus = new ArrayList<>();
        session.removeAttribute(NGUYEN_LIEU_DA_CHON);
        session.setAttribute(NGUYEN_LIEU_DA_CHON, nguyenLieus);
        hoaDonNguyenLieuDAO.luuHoaDon(hoaDonNguyenLieu);
        session.setAttribute(HOA_DON_THANH_CONG, hoaDonNguyenLieu);
        JsonHelper.convert(hoaDonNguyenLieu, response);
      }


    } catch (SQLException e) {
      pushMessage(FAIL, FAIL_CONTENT, request);
      showNguyenLieuList(request, response);
    }
  }

  private Integer calTotalMoney(List<NguyenLieuNhaCungCap> nguyenLieus) {
    Integer totalMoney = 0;

    for (NguyenLieuNhaCungCap nguyenLieuNhaCungCap : nguyenLieus) {
      totalMoney += nguyenLieuNhaCungCap.getDonGia() * nguyenLieuNhaCungCap.getDonGia();
    }
    return totalMoney;
  }

  private void pushMessage(String type, String message, HttpServletRequest request) {
    HttpSession session = request.getSession();
    session.setAttribute(TYPE_MESSAGE, type);
    session.setAttribute(MESSAGE, message);
  }

}
