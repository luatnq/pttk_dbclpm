package dao.impl;

import com.example.pttk_dbclpm.dao.DAO;
import dao.NhaCungCapDAOTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NhaCungCapDAOImplTest extends DAO implements NhaCungCapDAOTest {
  String DELETE_BY_ID = "DELETE FROM tblNhaCungCap ncc WHERE ncc.id = ?";

  public NhaCungCapDAOImplTest() {
    super();
  }

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
}
