package com.example.pttk_dbclpm.dao;

import com.example.pttk_dbclpm.entity.NhaCungCap;

import java.sql.SQLException;
import java.util.List;

public interface NhaCungCapDAO {
  List<NhaCungCap> list(String name);

  void luuNcc(NhaCungCap nhaCungCap) throws SQLException;
}
