package com.example.pttk_dbclpm.dao;

import com.example.pttk_dbclpm.entity.HoaDonNguyenLieu;
import com.example.pttk_dbclpm.entity.edit.HoaDon;

import java.sql.SQLException;

public interface HoaDonNguyenLieuDAO {
  HoaDonNguyenLieu luuHoaDon(HoaDonNguyenLieu hoaDonNguyenLieu) throws SQLException;

  HoaDon luuHoaDon(HoaDon hoaDon) throws SQLException;
}
