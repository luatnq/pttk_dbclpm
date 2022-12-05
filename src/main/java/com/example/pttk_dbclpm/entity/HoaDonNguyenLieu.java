package com.example.pttk_dbclpm.entity;

import java.io.Serializable;
import java.util.List;

public class HoaDonNguyenLieu extends HoaDon implements Serializable {

  List<NguyenLieuNhaCungCap> nguyenLieuNhaCungCaps;

  public HoaDonNguyenLieu(Integer idHoaDon, Integer nhanVienId, Integer tongTien, List<NguyenLieuNhaCungCap> nguyenLieuNhaCungCaps) {
    super(idHoaDon, nhanVienId, null, tongTien, null);
    this.nguyenLieuNhaCungCaps = nguyenLieuNhaCungCaps;
  }


  public HoaDonNguyenLieu(List<NguyenLieuNhaCungCap> nguyenLieuNhaCungCaps) {
    this.nguyenLieuNhaCungCaps = nguyenLieuNhaCungCaps;
  }

  public HoaDonNguyenLieu(Integer nhanVienId, String tenNhanVien, Integer tongTien, String moTa, List<NguyenLieuNhaCungCap> nguyenLieuNhaCungCaps) {
    super(nhanVienId, tenNhanVien, tongTien, moTa);
    this.nguyenLieuNhaCungCaps = nguyenLieuNhaCungCaps;
  }

  public List<NguyenLieuNhaCungCap> getNguyenLieuNhaCungCaps() {
    return nguyenLieuNhaCungCaps;
  }

  public void setNguyenLieuNhaCungCaps(List<NguyenLieuNhaCungCap> nguyenLieuNhaCungCaps) {
    this.nguyenLieuNhaCungCaps = nguyenLieuNhaCungCaps;
  }
}
