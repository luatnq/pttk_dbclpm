package com.example.pttk_dbclpm.entity;

import java.util.Date;
import java.util.List;

public class Slot {
  private Integer id;
  private Date thoiGianBatDau;
  private KhachHang khachHang;
  private CongViec congViec;
  private List<NguyenLieuSuDung> nguyenLieuSuDungs;

  public Slot(Integer id, Date thoiGianBatDau, KhachHang khachHang, CongViec congViec, List<NguyenLieuSuDung> nguyenLieuSuDungs) {
    this.id = id;
    this.thoiGianBatDau = thoiGianBatDau;
    this.khachHang = khachHang;
    this.congViec = congViec;
    this.nguyenLieuSuDungs = nguyenLieuSuDungs;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getThoiGianBatDau() {
    return thoiGianBatDau;
  }

  public void setThoiGianBatDau(Date thoiGianBatDau) {
    this.thoiGianBatDau = thoiGianBatDau;
  }

  public KhachHang getKhachHang() {
    return khachHang;
  }

  public void setKhachHang(KhachHang khachHang) {
    this.khachHang = khachHang;
  }

  public CongViec getCongViec() {
    return congViec;
  }

  public void setCongViec(CongViec congViec) {
    this.congViec = congViec;
  }

  public List<NguyenLieuSuDung> getNguyenLieuSuDungs() {
    return nguyenLieuSuDungs;
  }

  public void setNguyenLieuSuDungs(List<NguyenLieuSuDung> nguyenLieuSuDungs) {
    this.nguyenLieuSuDungs = nguyenLieuSuDungs;
  }
}
