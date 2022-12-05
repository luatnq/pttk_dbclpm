package dao.impl;

import com.example.pttk_dbclpm.dao.DAO;
import dao.NguyenLieuDAOTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NguyenLieuDAOImplTest extends DAO implements NguyenLieuDAOTest {
  public NguyenLieuDAOImplTest() {
    super();
  }

  String DELETE_BY_ID = "DELETE FROM tblNguyenLieuNhaCungCap nlncc WHERE nlncc.id = ?";
  String DELETE_NGUYEN_LIEU_BY_ID = "DELETE FROM tblNguyenLieu nl WHERE nl.id = ?";

  public boolean deleteById(Integer id) throws SQLException {
    Connection conn = null;
    try {
      conn = super.connection;
      conn.setAutoCommit(false);

      PreparedStatement preparedStatement = conn.prepareStatement(DELETE_BY_ID);
      preparedStatement.setInt(1, id);

      int row = preparedStatement.executeUpdate();
      if (row == 0) throw new SQLException();
      conn.commit();
      return true;
    } catch (SQLException e) {
      conn.rollback();
      throw new RuntimeException(e);
    } finally {
      conn.setAutoCommit(true);
    }
  }

  public boolean deleteNguyenLieuById(Integer id) throws SQLException {
    Connection conn = null;
    try {
      conn = super.connection;
      conn.setAutoCommit(false);

      PreparedStatement preparedStatement = conn.prepareStatement(DELETE_NGUYEN_LIEU_BY_ID);
      preparedStatement.setInt(1, id);

      int row = preparedStatement.executeUpdate();
      if (row == 0) throw new SQLException();
      conn.commit();
      return true;
    } catch (SQLException e) {
      conn.rollback();
      throw new RuntimeException(e);
    } finally {
      conn.setAutoCommit(true);
    }
  }
}
