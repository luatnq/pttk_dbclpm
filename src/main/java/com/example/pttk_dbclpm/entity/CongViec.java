package com.example.pttk_dbclpm.entity;

import java.util.Date;

public class CongViec {
  private Integer id;
  private Integer hoaHong;
  private DichVu dichVu;
  private NhanVien nhanVien;
  private Date ngayTao;
  private String moTa;

  public CongViec() {
  }

  public CongViec(
        Integer id,
        Integer hoaHong,
        DichVu dichVu,
        NhanVien nhanVien,
        Date ngayTao,
        String moTa
  ) {
    this.id = id;
    this.hoaHong = hoaHong;
    this.dichVu = dichVu;
    this.nhanVien = nhanVien;
    this.ngayTao = ngayTao;
    this.moTa = moTa;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getHoaHong() {
    return hoaHong;
  }

  public void setHoaHong(Integer hoaHong) {
    this.hoaHong = hoaHong;
  }

  public DichVu getDichVu() {
    return dichVu;
  }

  public void setDichVu(DichVu dichVu) {
    this.dichVu = dichVu;
  }

  public NhanVien getNhanVien() {
    return nhanVien;
  }

  public void setNhanVien(NhanVien nhanVien) {
    this.nhanVien = nhanVien;
  }

  public Date getNgayTao() {
    return ngayTao;
  }

  public void setNgayTao(Date ngayTao) {
    this.ngayTao = ngayTao;
  }

  public String getMoTa() {
    return moTa;
  }

  public void setMoTa(String moTa) {
    this.moTa = moTa;
  }
}
