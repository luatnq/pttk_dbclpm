package dao;

import java.sql.SQLException;

public interface NguyenLieuDAOTest {

  boolean deleteById(Integer id) throws SQLException;

  boolean deleteNguyenLieuById(Integer id) throws SQLException;

  boolean deleteNguyenLieuNccByHoaDonId(Integer hoaHonId) throws SQLException;
}
