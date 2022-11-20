package com.example.pttk_dbclpm.entity;

public class NguyenLieuSuDung {
  private Integer id;
  private Integer soLuong;
  private NguyenLieuNhaCungCap nguyenLieuNhaCungCap;

  public NguyenLieuSuDung() {
  }

  public NguyenLieuSuDung(Integer id, Integer soLuong, NguyenLieuNhaCungCap nguyenLieuNhaCungCap) {
    this.id = id;
    this.soLuong = soLuong;
    this.nguyenLieuNhaCungCap = nguyenLieuNhaCungCap;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getSoLuong() {
    return soLuong;
  }

  public void setSoLuong(Integer soLuong) {
    this.soLuong = soLuong;
  }

  public NguyenLieuNhaCungCap getNguyenLieuNhaCungCap() {
    return nguyenLieuNhaCungCap;
  }

  public void setNguyenLieuNhaCungCap(NguyenLieuNhaCungCap nguyenLieuNhaCungCap) {
    this.nguyenLieuNhaCungCap = nguyenLieuNhaCungCap;
  }
}
