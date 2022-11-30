package com.example.pttk_dbclpm.dao;

import com.example.pttk_dbclpm.entity.NguyenLieu;

import java.util.List;

public interface NguyenLieuDAO {
  List<NguyenLieu> list(String name, Integer nccId);
}
