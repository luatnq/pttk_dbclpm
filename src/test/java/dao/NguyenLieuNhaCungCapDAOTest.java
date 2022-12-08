package dao;

import java.sql.SQLException;

public interface NguyenLieuNhaCungCapDAOTest {

  boolean deleteById(Integer id) throws SQLException;

  boolean deleteNguyenLieuById(Integer id) throws SQLException;

  boolean deleteNguyenLieuNccByHoaDonId(Integer hoaHonId) throws SQLException;
}
