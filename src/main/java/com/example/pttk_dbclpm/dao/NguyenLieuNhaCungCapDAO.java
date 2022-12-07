package com.example.pttk_dbclpm.dao;

import com.example.pttk_dbclpm.entity.NguyenLieu;
import com.example.pttk_dbclpm.entity.NguyenLieuNhaCungCap;

import java.sql.SQLException;
import java.util.List;

public interface NguyenLieuNhaCungCapDAO {
  List<NguyenLieuNhaCungCap> list(NguyenLieuNhaCungCap nguyenLieuNhaCungCapInput) ;

  NguyenLieuNhaCungCap luuNguyenLieu(NguyenLieuNhaCungCap nguyenLieuNhaCungCap) throws SQLException;
}
