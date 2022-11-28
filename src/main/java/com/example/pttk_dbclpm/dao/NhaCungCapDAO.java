package com.example.pttk_dbclpm.dao;

import com.example.pttk_dbclpm.entity.NhaCungCap;

import java.util.List;

public interface NhaCungCapDAO {
  List<NhaCungCap> list(String name);
}
