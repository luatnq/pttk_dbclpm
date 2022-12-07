package com.example.pttk_dbclpm.dao;

import com.example.pttk_dbclpm.entity.NhanVien;

public interface NhanVienDAO {
  NhanVien login(String username, String password);

  NhanVien login(NhanVien nhanVienLogin);
}
