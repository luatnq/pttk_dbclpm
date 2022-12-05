package dao;

import java.sql.SQLException;

public interface HoaDonNguyenLieuDAOTest {
  boolean deleteHoaDonNguyenLieuById(Integer id) throws SQLException;

  boolean deleteHoaDonById(Integer id) throws SQLException;
}
