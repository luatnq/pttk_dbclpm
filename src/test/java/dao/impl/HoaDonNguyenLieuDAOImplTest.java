package dao.impl;

import com.example.pttk_dbclpm.dao.DAO;
import com.example.pttk_dbclpm.entity.HoaDonNguyenLieu;
import com.example.pttk_dbclpm.entity.NguyenLieuNhaCungCap;
import dao.HoaDonNguyenLieuDAOTest;
import dao.NguyenLieuDAOTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static com.example.pttk_dbclpm.constant.Constant.Web.NGUYEN_LIEU_DA_CHON;

public class HoaDonNguyenLieuDAOImplTest extends DAO implements HoaDonNguyenLieuDAOTest {
  String DELETE_BY_ID = "DELETE FROM tblHoaDonNguyenLieu hoaDon WHERE hoaDon.idTblHoaDon = ?";
  String DELETE_BY_HOA_DON_ID = "DELETE FROM tblHoaDon hoaDon WHERE hoaDon.id = ?";

  public boolean deleteHoaDonNguyenLieuById(Integer id) throws SQLException {
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

  public boolean deleteHoaDonById(Integer id) throws SQLException {
    Connection conn = null;
    try {
      conn = super.connection;
      conn.setAutoCommit(false);

      PreparedStatement preparedStatement = conn.prepareStatement(DELETE_BY_HOA_DON_ID);
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
