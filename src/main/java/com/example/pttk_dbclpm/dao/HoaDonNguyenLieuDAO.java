package com.example.pttk_dbclpm.dao;

import com.example.pttk_dbclpm.entity.HoaDonNguyenLieu;

import java.sql.SQLException;

public interface HoaDonNguyenLieuDAO {
  HoaDonNguyenLieu luuHoaDon(HoaDonNguyenLieu hoaDonNguyenLieu) throws SQLException;
}
