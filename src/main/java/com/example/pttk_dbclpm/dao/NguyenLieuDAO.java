package com.example.pttk_dbclpm.dao;

import com.example.pttk_dbclpm.entity.NguyenLieu;

import java.sql.SQLException;
import java.util.List;

public interface NguyenLieuDAO {
  List<NguyenLieu> list(String name, Integer nccId);

  void luuNguyenLieu(String tenNguyenLieu, Integer nccId) throws SQLException;
}