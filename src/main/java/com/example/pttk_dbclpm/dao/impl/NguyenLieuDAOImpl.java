package com.example.pttk_dbclpm.dao.impl;

import com.example.pttk_dbclpm.dao.DAO;
import com.example.pttk_dbclpm.dao.NguyenLieuDAO;
import com.example.pttk_dbclpm.entity.NguyenLieu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;


public class NguyenLieuDAOImpl extends DAO implements NguyenLieuDAO {
  Logger log = Logger.getLogger(NguyenLieuDAOImpl.class.getName());
  private String SELECT_NGUYEN_LIEU = "SELECT tnl.id FROM tblNguyenLieu tnl WHERE tnl.ten = ? ";

  public NguyenLieuDAOImpl() {
    super();
  }


  public Integer getIdNguyenLieu(NguyenLieu nguyenLieu) {
    Connection conn = null;
    try {
      conn = super.connection;

      PreparedStatement selectNguyenLieu = conn.prepareStatement(SELECT_NGUYEN_LIEU);
      selectNguyenLieu.setString(1, nguyenLieu.getTen());

      ResultSet rs = selectNguyenLieu.executeQuery();
      if (rs.next()) return rs.getInt("id");

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return null;
  }
}
