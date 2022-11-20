package com.example.pttk_dbclpm.entity;

public class NguyenLieuNhaCungCap {
  private Integer id;
  private Integer soLuong;
  private Integer donGia;
  private NhaCungCap nhaCungCap;
  private NguyenLieu nguyenLieu;

  public NguyenLieuNhaCungCap() {
  }

  public NguyenLieuNhaCungCap(Integer id, Integer soLuong, Integer donGia, NhaCungCap nhaCungCap, NguyenLieu nguyenLieu) {
    this.id = id;
    this.soLuong = soLuong;
    this.donGia = donGia;
    this.nhaCungCap = nhaCungCap;
    this.nguyenLieu = nguyenLieu;
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

  public Integer getDonGia() {
    return donGia;
  }

  public void setDonGia(Integer donGia) {
    this.donGia = donGia;
  }

  public NhaCungCap getNhaCungCap() {
    return nhaCungCap;
  }

  public void setNhaCungCap(NhaCungCap nhaCungCap) {
    this.nhaCungCap = nhaCungCap;
  }

  public NguyenLieu getNguyenLieu() {
    return nguyenLieu;
  }

  public void setNguyenLieu(NguyenLieu nguyenLieu) {
    this.nguyenLieu = nguyenLieu;
  }
}
