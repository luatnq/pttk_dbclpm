package com.example.pttk_dbclpm.dao;

import com.example.pttk_dbclpm.entity.NguyenLieu;
import com.example.pttk_dbclpm.entity.NguyenLieuNhaCungCap;

import java.sql.SQLException;
import java.util.List;

public interface NguyenLieuDAO {
  List<NguyenLieu> list(NguyenLieuNhaCungCap nguyenLieuNhaCungCap);

  NguyenLieuNhaCungCap luuNguyenLieu(String tenNguyenLieu, Integer nccId) throws SQLException;

  Integer getIdNguyenLieu(String tenNguyenLieu);
}
