package com.example.pttk_dbclpm.entity;

import java.io.Serializable;
import java.util.List;

public class HoaDonNguyenLieu extends HoaDon implements Serializable {

  List<NguyenLieuNhaCungCap> nguyenLieuNhaCungCaps;

  public HoaDonNguyenLieu() {
  }

  public HoaDonNguyenLieu(List<NguyenLieuNhaCungCap> nguyenLieuNhaCungCaps) {
    this.nguyenLieuNhaCungCaps = nguyenLieuNhaCungCaps;
  }

  public List<NguyenLieuNhaCungCap> getNguyenLieuNhaCungCaps() {
    return nguyenLieuNhaCungCaps;
  }

  public void setNguyenLieuNhaCungCaps(List<NguyenLieuNhaCungCap> nguyenLieuNhaCungCaps) {
    this.nguyenLieuNhaCungCaps = nguyenLieuNhaCungCaps;
  }
}
