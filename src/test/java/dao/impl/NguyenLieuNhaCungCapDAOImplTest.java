package dao.impl;

import com.example.pttk_dbclpm.dao.DAO;
import dao.NguyenLieuNhaCungCapDAOTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NguyenLieuNhaCungCapDAOImplTest extends DAO implements NguyenLieuNhaCungCapDAOTest {
  public NguyenLieuNhaCungCapDAOImplTest() {
    super();
  }

  String DELETE_BY_ID = "DELETE FROM tblNguyenLieuNhaCungCap nlncc WHERE nlncc.id = ?";
  String DELETE_NGUYEN_LIEU_BY_ID = "DELETE FROM tblNguyenLieu nl WHERE nl.id = ?";
  String DELETE_BY_ID_HOA_DON = "DELETE FROM tblNguyenLieuNhaCungCap nlncc WHERE nlncc.idTblHoaDonNguyenLieu = ?";

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

  public boolean deleteNguyenLieuNccByHoaDonId(Integer hoaHonId) throws SQLException {
    Connection conn = null;
    try {
      conn = super.connection;
      conn.setAutoCommit(false);

      PreparedStatement preparedStatement = conn.prepareStatement(DELETE_BY_ID_HOA_DON);
      preparedStatement.setInt(1, hoaHonId);

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
