package com.example.pttk_dbclpm.dao.impl;

import com.example.pttk_dbclpm.dao.DAO;
import com.example.pttk_dbclpm.dao.NguyenLieuDAO;
import com.example.pttk_dbclpm.entity.NguyenLieu;
import com.example.pttk_dbclpm.entity.NguyenLieuNhaCungCap;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;


public class NguyenLieuDAOImpl extends DAO implements NguyenLieuDAO {
  Logger log = Logger.getLogger(NguyenLieuDAOImpl.class.getName());
  private String SELECT_SEARCH = "SELECT tnl.ten, SUM(tnlncc.soLuong) as totalSoLuong  FROM tblNguyenLieu tnl \n" +
        "join tblNguyenLieuNhaCungCap tnlncc on tnl.id = tnlncc.idTblNguyenLieu \n" +
        "where tnlncc.idTblNhaCungCap = ? and tnl.ten like ? \n" +
        "GROUP BY tnl.ten, tnlncc.idTblNhaCungCap ";
  private String SELECT_ALL = "SELECT tnl.ten, SUM(tnlncc.soLuong) as totalSoLuong  FROM tblNguyenLieu tnl \n" +
        "join tblNguyenLieuNhaCungCap tnlncc on tnl.id = tnlncc.idTblNguyenLieu \n" +
        "where tnlncc.idTblNhaCungCap = ? \n" +
        "GROUP BY tnl.ten, tnlncc.idTblNhaCungCap ";

  private String CHECK_EXIST = "SELECT * FROM tblNguyenLieu tnl \n" +
        "JOIN tblNguyenLieuNhaCungCap tnlncc ON tnl.id = tnlncc.idTblNguyenLieu \n" +
        "WHERE tnlncc.idTblNhaCungCap = ? \n" +
        "AND tnl.ten = ? ";

  private String INSERT_NGUYEN_LIEU = "INSERT INTO pttk.tblNguyenLieu (ten) \n" +
        "VALUES(?) ";

  private String INSERT_NGUYEN_LIEU_NHA_CUNG_CAP = "INSERT INTO pttk.tblNguyenLieuNhaCungCap (soLuong, donGia, idTblNhaCungCap, idTblNguyenLieu) \n" +
        "VALUES(0, 0, ?, ?) ";

  private String SELECT_NGUYEN_LIEU = "SELECT tnl.id FROM tblNguyenLieu tnl WHERE tnl.ten = ? ";

  public NguyenLieuDAOImpl() {
    super();
  }

  public List<NguyenLieu> list(String name, Integer nccId) {
    Connection conn = null;
    List<NguyenLieu> nguyenLieus = new ArrayList<>();
    try {
      conn = super.connection;
      PreparedStatement preparedStatement = conn.prepareStatement(Objects.nonNull(name) ? SELECT_SEARCH : SELECT_ALL);
      preparedStatement.setInt(1, nccId);
      if (Objects.nonNull(name)) preparedStatement.setString(2, "%" + name + "%");
      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        NguyenLieu nguyenLieu = new NguyenLieu(
              rs.getString("ten"),
              rs.getInt("totalSoLuong")
        );
        nguyenLieus.add(nguyenLieu);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return nguyenLieus;
  }


  public NguyenLieuNhaCungCap luuNguyenLieu(String tenNguyenLieu, Integer nccId) throws SQLException {
    Connection conn = null;
    try {
      conn = super.connection;
      conn.setAutoCommit(false);
      PreparedStatement selectCheckExist = conn.prepareStatement(CHECK_EXIST);
      selectCheckExist.setInt(1, nccId);
      selectCheckExist.setString(2, tenNguyenLieu);
      ResultSet rs = selectCheckExist.executeQuery();
      if (!rs.next()) {
        PreparedStatement selectNguyenLieu = conn.prepareStatement(SELECT_NGUYEN_LIEU);
        selectNguyenLieu.setString(1, tenNguyenLieu);
        Integer nguyenLieuId = null;
        ResultSet resultSet = selectNguyenLieu.executeQuery();

        if (resultSet.next()) {
          nguyenLieuId = resultSet.getInt("id");
        } else {

          PreparedStatement insertNguyenLieu = conn.prepareStatement(INSERT_NGUYEN_LIEU, Statement.RETURN_GENERATED_KEYS);
          insertNguyenLieu.setString(1, tenNguyenLieu);
          int result = insertNguyenLieu.executeUpdate();
          if (result == 0) throw new SQLException();
          try (ResultSet generatedKey = insertNguyenLieu.getGeneratedKeys()) {
            if (generatedKey.next()) {
              nguyenLieuId = generatedKey.getInt(1);
            } else throw new SQLException();
          }
        }

        PreparedStatement insertNguyenLieuNhaCungCap = conn.prepareStatement(
              INSERT_NGUYEN_LIEU_NHA_CUNG_CAP,
              Statement.RETURN_GENERATED_KEYS
        );
        insertNguyenLieuNhaCungCap.setInt(1, nccId);
        insertNguyenLieuNhaCungCap.setInt(2, nguyenLieuId);
        int resultInsert = insertNguyenLieuNhaCungCap.executeUpdate();
        if (resultInsert == 0) throw new SQLException();
        Integer idNguyenLieuNhaCungCap = null;
        try (ResultSet generatedKey = insertNguyenLieuNhaCungCap.getGeneratedKeys()) {
          if (generatedKey.next()) {
            idNguyenLieuNhaCungCap = generatedKey.getInt(1);
          } else throw new SQLException();
        }

        return new NguyenLieuNhaCungCap(idNguyenLieuNhaCungCap, nccId, tenNguyenLieu, nguyenLieuId);
      }
      conn.commit();

    } catch (SQLException e) {
      conn.rollback();
      throw new RuntimeException(e);
    } finally {
      conn.setAutoCommit(true);
    }

    return null;
  }


  public Integer getIdNguyenLieu(String tenNguyenLieu) {
    Connection conn = null;
    try {
      conn = super.connection;

      PreparedStatement selectNguyenLieu = conn.prepareStatement(SELECT_NGUYEN_LIEU);
      selectNguyenLieu.setString(1, tenNguyenLieu);

      ResultSet rs = selectNguyenLieu.executeQuery();
      if (rs.next()) return rs.getInt("id");

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return null;
  }
}
