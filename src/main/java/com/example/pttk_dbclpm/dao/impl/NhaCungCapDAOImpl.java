package com.example.pttk_dbclpm.dao.impl;

import com.example.pttk_dbclpm.dao.DAO;
import com.example.pttk_dbclpm.dao.NhaCungCapDAO;
import com.example.pttk_dbclpm.entity.NhaCungCap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class NhaCungCapDAOImpl extends DAO implements NhaCungCapDAO {

  String SELECT_LIST = "SELECT * FROM tblNhaCungCap tncc WHERE tncc.ten LIKE ? order by tncc.id DESC";
  String SELECT_ALL = "SELECT * FROM tblNhaCungCap tncc order by tncc.id DESC ";

  String INSERT_NHA_CUNG_CAP = "INSERT INTO tblNhaCungCap(ten, diaChi, sdt) VALUES ( ?, ?, ?)";

  public NhaCungCapDAOImpl() {
    super();
  }

  public List<NhaCungCap> list(String name) {
    Connection conn = null;
    List<NhaCungCap> nhaCungCaps = new ArrayList<>();
    try {
      conn = super.connection;
      conn.setAutoCommit(false);

      PreparedStatement preparedStatement = conn.prepareStatement(Objects.nonNull(name) ? SELECT_LIST : SELECT_ALL);
      if (Objects.nonNull(name)) preparedStatement.setString(1, "%" + name + "%");
      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        NhaCungCap nhaCungCap = new NhaCungCap(
              rs.getInt("id"),
              rs.getString("ten"),
              rs.getString("diaChi"),
              rs.getString("sdt")
        );
        nhaCungCaps.add(nhaCungCap);
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return nhaCungCaps;
  }


  public void luuNcc(NhaCungCap nhaCungCap) throws SQLException {
    Connection conn = null;
    try {
      conn = super.connection;
      conn.setAutoCommit(false);

      PreparedStatement preparedStatement = conn.prepareStatement(INSERT_NHA_CUNG_CAP);
      preparedStatement.setString(1, nhaCungCap.getTen());
      preparedStatement.setString(2, nhaCungCap.getDiaChi());
      preparedStatement.setString(3, nhaCungCap.getSdt());

      int row = preparedStatement.executeUpdate();

      conn.commit();
    } catch (SQLException e) {
      conn.rollback();
      throw new RuntimeException(e);
    }finally {
//      if (Objects.nonNull(conn)) conn.close();
    }
  }
}
