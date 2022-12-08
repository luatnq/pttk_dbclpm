package com.example.pttk_dbclpm.entity.edit;

import com.example.pttk_dbclpm.entity.NhaCungCap;
import com.example.pttk_dbclpm.entity.NhanVien;

import java.util.List;

public class HoaDon {
  private Integer id;
  private NhanVien nhanVien;
  private Integer tongTien;
  private String moTa;
  private NhaCungCap nhaCungCap;

  private List<HoaDonChiTiet> hoaDonChiTiets;

  public HoaDon() {
  }

  public HoaDon(Integer nhanVienId, String tenNhanVien, Integer tongTien, String moTa) {
    this.nhanVien = new NhanVien(nhanVienId, tenNhanVien);
    this.tongTien = tongTien;
    this.moTa = moTa;
  }

  public HoaDon(Integer idHoaDon, Integer nhanVienId, String tenNhanVien, Integer tongTien, String moTa) {
    this.id = idHoaDon;
    this.nhanVien = new NhanVien(nhanVienId, tenNhanVien);
    this.tongTien = tongTien;
    this.moTa = moTa;
  }

  public HoaDon(
        Integer id,
        NhanVien nhanVien,
        String moTa
  ) {
    this.id = id;
    this.nhanVien = nhanVien;
    this.moTa = moTa;
  }

  public Integer getId() {
    return id;
  }

  public Integer getTongTien() {
    return tongTien;
  }

  public void setTongTien(Integer tongTien) {
    this.tongTien = tongTien;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public NhanVien getNhanVien() {
    return nhanVien;
  }

  public void setNhanVien(NhanVien nhanVien) {
    this.nhanVien = nhanVien;
  }

  public String getMoTa() {
    return moTa;
  }

  public void setMoTa(String moTa) {
    this.moTa = moTa;
  }

  public NhaCungCap getNhaCungCap() {
    return nhaCungCap;
  }

  public void setNhaCungCap(NhaCungCap nhaCungCap) {
    this.nhaCungCap = nhaCungCap;
  }

  public List<HoaDonChiTiet> getHoaDonChiTiets() {
    return hoaDonChiTiets;
  }

  public void setHoaDonChiTiets(List<HoaDonChiTiet> hoaDonChiTiets) {
    this.hoaDonChiTiets = hoaDonChiTiets;
  }
}
