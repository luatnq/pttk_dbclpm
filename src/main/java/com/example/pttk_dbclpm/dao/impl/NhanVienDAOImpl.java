package com.example.pttk_dbclpm.dao.impl;

import com.example.pttk_dbclpm.dao.DAO;
import com.example.pttk_dbclpm.dao.NhanVienDAO;
import com.example.pttk_dbclpm.entity.NhanVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NhanVienDAOImpl extends DAO implements NhanVienDAO {
  private String SELECT_NHANVIEN = "SELECT ttv.taiKhoan, ttv.id, ttv.ten FROM tblNhanVien tnv INNER JOIN tblThanhVien ttv ON tnv.idTblThanhVien = ttv.id " +
        "WHERE ttv.taiKhoan = ? AND ttv.matKhau = ? ";


  public NhanVienDAOImpl() {
    super();
  }

  public NhanVien login(String username, String password) {
    Connection conn = null;
    try {
      conn = super.connection;
      PreparedStatement preparedStatement = conn.prepareStatement(SELECT_NHANVIEN);
      preparedStatement.setString(1, username);
      preparedStatement.setString(2, password);
      ResultSet rs = preparedStatement.executeQuery();
      if (rs.next()) {
        NhanVien nhanVien = new NhanVien(
              rs.getInt("id"),
              rs.getString("taiKhoan"),
              rs.getString("ten")
        );
        return nhanVien;
      }
      return null;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public NhanVien login(NhanVien nhanVienLogin) {
    Connection conn = null;
    try {
      conn = super.connection;
      PreparedStatement preparedStatement = conn.prepareStatement(SELECT_NHANVIEN);
      preparedStatement.setString(1, nhanVienLogin.getTaiKhoan());
      preparedStatement.setString(2, nhanVienLogin.getMatKhau());
      ResultSet rs = preparedStatement.executeQuery();
      if (rs.next()) {
        NhanVien nhanVien = new NhanVien(
              rs.getInt("id"),
              rs.getString("taiKhoan"),
              rs.getString("ten")
        );
        return nhanVien;
      }
      return null;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
