package com.example.pttk_dbclpm.dao.impl;

import com.example.pttk_dbclpm.dao.DAO;
import com.example.pttk_dbclpm.dao.NguyenLieuDAO;
import com.example.pttk_dbclpm.entity.NguyenLieu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;


public class NguyenLieuDAOImpl extends DAO implements NguyenLieuDAO {
  Logger log = Logger.getLogger(NguyenLieuDAOImpl.class.getName());
  private String SELECT_SEARCH = "SELECT tnl.ten, SUM(tnlncc.soLuong) as totalSoLuong  FROM tblNguyenLieu tnl \n" +
        "join tblNguyenLieuNhaCungCap tnlncc on tnl.id = tnlncc.idTblNguyenLieu \n" +
        "where tnlncc.idTblNhaCungCap = ? and tnl.ten like ? \n" +
        "GROUP BY tnl.ten ";
  private String SELECT_ALL = "SELECT tnl.ten, SUM(tnlncc.soLuong) as totalSoLuong  FROM tblNguyenLieu tnl \n" +
        "join tblNguyenLieuNhaCungCap tnlncc on tnl.id = tnlncc.idTblNguyenLieu \n" +
        "where tnlncc.idTblNhaCungCap = ? \n" +
        "GROUP BY tnl.ten ";

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

}
