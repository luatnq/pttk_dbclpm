package com.example.pttk_dbclpm.dao.impl;

import com.example.pttk_dbclpm.dao.DAO;
import com.example.pttk_dbclpm.dao.HoaDonNguyenLieuDAO;
import com.example.pttk_dbclpm.entity.HoaDonNguyenLieu;
import com.example.pttk_dbclpm.entity.NguyenLieuNhaCungCap;
import com.example.pttk_dbclpm.entity.edit.HoaDon;
import com.example.pttk_dbclpm.entity.edit.HoaDonChiTiet;

import java.sql.*;
import java.util.List;

public class HoaDonNguyenLieuDAOImpl extends DAO implements HoaDonNguyenLieuDAO {
  private String INSERT_HOA_DON = "INSERT INTO pttk.tblHoaDon(idTblNhanVien, ngayXuat) VALUES(?, ?)";
  private String INSERT_HOA_DON_NL = "INSERT INTO pttk.tblHoaDonNguyenLieu (idTblHoaDon) VALUES(?)";

  private String INSERT_NGUYEN_LIEU_NCC = "INSERT INTO pttk.tblNguyenLieuNhaCungCap\n " +
        "(soLuong, donGia, idTblNhaCungCap, idTblNguyenLieu, idTblHoaDonNguyenLieu)\n " +
        "VALUES(?, ?, ?, ?, ?) ";


  private String INSERT_HOA_DON_v2 = "INSERT INTO pttk.tblHoaDon(idTblNhanVien, idTblNhaCungCap) VALUES(?, ?) ";

  /**
   * INSERT INTO pttk.tblHoaDon
   * (id, idTblNhanVien, moTa, ngayXuat, idTblNhaCungCap)
   * VALUES(14, 1, NULL, '2022-12-04', NULL);
   */
  private String INSERT_HOA_DON_CHI_TIET = "INSERT INTO pttk.tblHoaDonChiTiet " +
        "(idTblHoaDon, idTblNguyenLieu, soLuong, donGia) " +
        "VALUES( ?, ?, ?, ?)";

  public HoaDonNguyenLieuDAOImpl() {
    super();
  }

  public HoaDonNguyenLieu luuHoaDon(HoaDonNguyenLieu hoaDonNguyenLieu) throws SQLException {
    Connection conn = null;
    try {
      conn = super.connection;
      conn.setAutoCommit(false);
      PreparedStatement insert = conn.prepareStatement(INSERT_HOA_DON, Statement.RETURN_GENERATED_KEYS);
      long millis = System.currentTimeMillis();
      Date date = new Date(millis);

      insert.setInt(1, hoaDonNguyenLieu.getNhanVien().getId());
      insert.setDate(2, date);

      int result = insert.executeUpdate();
      if (result == 0) throw new SQLException();

      try (ResultSet generatedKey = insert.getGeneratedKeys()) {
        if (generatedKey.next()) {
          Integer idHoaDon = generatedKey.getInt(1);

          PreparedStatement insertHoaDonNguyenLieu = conn.prepareStatement(INSERT_HOA_DON_NL);
          insertHoaDonNguyenLieu.setInt(1, idHoaDon);
          int resultInsert = insertHoaDonNguyenLieu.executeUpdate();
          if (resultInsert == 0) throw new SQLException();

          List<NguyenLieuNhaCungCap> nguyenLieuNhaCungCaps = hoaDonNguyenLieu.getNguyenLieuNhaCungCaps();
          PreparedStatement preparedStatement = conn.prepareStatement(INSERT_NGUYEN_LIEU_NCC);
          for (NguyenLieuNhaCungCap nguyenLieuNhaCungCap : nguyenLieuNhaCungCaps) {
            preparedStatement.setInt(1, nguyenLieuNhaCungCap.getSoLuong());
            preparedStatement.setInt(2, nguyenLieuNhaCungCap.getDonGia());
            preparedStatement.setInt(3, nguyenLieuNhaCungCap.getNhaCungCap().getId());
            preparedStatement.setInt(4, nguyenLieuNhaCungCap.getNguyenLieu().getId());
            preparedStatement.setInt(5, idHoaDon);
            preparedStatement.addBatch();
          }
          int[] rows = preparedStatement.executeBatch();

          if (rows.length == 0) throw new SQLException();
          conn.commit();

          return new HoaDonNguyenLieu(
                idHoaDon,
                hoaDonNguyenLieu.getNhanVien().getId(),
                hoaDonNguyenLieu.getTongTien(),
                nguyenLieuNhaCungCaps
          );

        } else throw new SQLException();
      }
    } catch (SQLException e) {
      conn.rollback();
      throw new RuntimeException(e);
    } finally {
      conn.setAutoCommit(true);
    }
  }


  public HoaDon luuHoaDon(HoaDon hoaDon) throws SQLException {

    Connection conn = null;
    try {
      conn = super.connection;
      conn.setAutoCommit(false);
      PreparedStatement insert = conn.prepareStatement(INSERT_HOA_DON_v2, Statement.RETURN_GENERATED_KEYS);
      long millis = System.currentTimeMillis();
      insert.setInt(1, hoaDon.getNhanVien().getId());
      insert.setInt(2, hoaDon.getNhaCungCap().getId());

      int result = insert.executeUpdate();
      if (result == 0) throw new SQLException();

      try (ResultSet generatedKey = insert.getGeneratedKeys()) {
        if (generatedKey.next()) {
          Integer idHoaDon = generatedKey.getInt(1);

          PreparedStatement insertHoaDonChiTiet = conn.prepareStatement(INSERT_HOA_DON_CHI_TIET);
          for (HoaDonChiTiet hoaDonChiTiet : hoaDon.getHoaDonChiTiets()) {
            insertHoaDonChiTiet.setInt(1, idHoaDon);
            insertHoaDonChiTiet.setInt(2, hoaDonChiTiet.getNguyenLieu().getId());
            insertHoaDonChiTiet.setInt(3, hoaDonChiTiet.getSoLuong());
            insertHoaDonChiTiet.setInt(4, hoaDonChiTiet.getDonGia());
            insertHoaDonChiTiet.addBatch();
          }

          int[] rows = insertHoaDonChiTiet.executeBatch();

          if (rows.length == 0) throw new SQLException();
          conn.commit();

          hoaDon.setId(idHoaDon);

          return hoaDon;


        } else throw new SQLException();
      }
    } catch (SQLException e) {
      conn.rollback();
      throw new RuntimeException(e);
    } finally {
      conn.setAutoCommit(true);
    }
  }
}
