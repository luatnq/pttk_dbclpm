package com.example.pttk_dbclpm.entity;

public class HoaDon {
  private Integer id;
  private NhanVien nhanVien;
  private Integer tongTien;
  private String moTa;

  public HoaDon() {
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
}
