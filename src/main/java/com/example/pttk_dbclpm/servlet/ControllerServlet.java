package com.example.pttk_dbclpm.servlet;

import com.example.pttk_dbclpm.dao.*;
import com.example.pttk_dbclpm.dao.impl.*;
import com.example.pttk_dbclpm.entity.*;
import com.example.pttk_dbclpm.entity.edit.HoaDon;
import com.example.pttk_dbclpm.entity.edit.HoaDonChiTiet;
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
  private NguyenLieuNhaCungCapDAO nguyenLieuNhaCungCapDAO = new NguyenLieuNhaCungCapDAOImpl();

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
    String username = request.getParameter("username").trim();
    String password = request.getParameter("password").trim();
    NhanVien nhanVien = nhanVienDAO.login(new NhanVien(username, password));
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
    List<NhaCungCap> nhaCungCaps = nhaCungCapDAO.list(new NhaCungCap(Objects.nonNull(nameSearch) ? nameSearch.trim() : nameSearch));
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

      NhaCungCap nhaCungCapInput = new NhaCungCap(
            Objects.nonNull(ten) ? ten.trim() : ten,
            Objects.nonNull(diaChi) ? diaChi.trim() : diaChi,
            Objects.nonNull(sdt) ? sdt.trim() : sdt);
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

    List<NguyenLieuNhaCungCap> nguyenLieuNhaCungCaps = nguyenLieuNhaCungCapDAO.list(new NguyenLieuNhaCungCap(request.getParameter("name"), nccId));
    request.setAttribute(NGUYEN_LIEU_LIST, nguyenLieuNhaCungCaps);
    session.setAttribute(NGUYEN_LIEU_LIST, nguyenLieuNhaCungCaps);
    session.setAttribute(NHA_CUNG_CAP_ID, nccId);
    request.getRequestDispatcher("GdDanhSachNL.jsp").forward(request, response);
  }


  private void pushNguyenLieuDaChon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    List<NguyenLieuNhaCungCap> nguyenLieus = (List<NguyenLieuNhaCungCap>) session.getAttribute(NGUYEN_LIEU_DA_CHON);
    session.removeAttribute(NGUYEN_LIEU_DA_CHON);
    String tenNguyenLieu = request.getParameter("productNameEnter");
    Integer soLuongNguyenLieu = Integer.valueOf(request.getParameter("productNumber"));
    Integer donGiaNguyenLieu = Integer.valueOf(request.getParameter("productPrice"));
    Integer idNguyenLieu = nguyenLieuDAO.getIdNguyenLieu(new NguyenLieu(Objects.nonNull(tenNguyenLieu) ? tenNguyenLieu.trim() : tenNguyenLieu));
    Integer nccId = (Integer) session.getAttribute(NHA_CUNG_CAP_ID);
    String tenNcc = (String) session.getAttribute(TEN_NHA_CUNG_CAP);
//    List<HoaDonChiTiet> hoaDonChiTiets = new ArrayList<>();
//    hoaDonChiTiets.add(new HoaDonChiTiet())
    nguyenLieus.add(new NguyenLieuNhaCungCap(
          soLuongNguyenLieu,
          donGiaNguyenLieu,
          nccId,
          tenNcc,
          idNguyenLieu,
          tenNguyenLieu.trim())
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
      String productName = request.getParameter("productNewName");
      NguyenLieuNhaCungCap nguyenLieu = nguyenLieuNhaCungCapDAO.luuNguyenLieu(new NguyenLieuNhaCungCap(productName, nccId));
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

      if (nguyenLieus.size() == 0) {
        pushMessage(FAIL, "Lưu hóa đơn không thành công", request);
        showNguyenLieuList(request, response);
      } else {
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
//        hoaDonNguyenLieuDAO.luuHoaDon(hoaDonNguyenLieu);
        HoaDon hoaDon = buildHoaDon(hoaDonNguyenLieu);
        hoaDonNguyenLieuDAO.luuHoaDon(hoaDon);
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


  private com.example.pttk_dbclpm.entity.edit.HoaDon buildHoaDon(HoaDonNguyenLieu hoaDonNguyenLieu) {
    com.example.pttk_dbclpm.entity.edit.HoaDon hoaDon = new com.example.pttk_dbclpm.entity.edit.HoaDon();
    hoaDon.setNhanVien(hoaDonNguyenLieu.getNhanVien());
    hoaDon.setNhaCungCap(hoaDonNguyenLieu.getNguyenLieuNhaCungCaps().get(0).getNhaCungCap());
    List<HoaDonChiTiet> hoaDonChiTiets = new ArrayList<>();
    for (NguyenLieuNhaCungCap nguyenLieuNhaCungCap : hoaDonNguyenLieu.getNguyenLieuNhaCungCaps()){
      HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
      hoaDonChiTiet.setDonGia(nguyenLieuNhaCungCap.getDonGia());
      hoaDonChiTiet.setSoLuong(nguyenLieuNhaCungCap.getSoLuong());
      hoaDonChiTiet.setNguyenLieu(nguyenLieuNhaCungCap.getNguyenLieu());
      hoaDonChiTiets.add(hoaDonChiTiet);
    }
    hoaDon.setHoaDonChiTiets(hoaDonChiTiets);
    return hoaDon;
  }
}
