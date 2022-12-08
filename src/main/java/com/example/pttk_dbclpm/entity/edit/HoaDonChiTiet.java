package com.example.pttk_dbclpm.entity.edit;

import com.example.pttk_dbclpm.entity.NguyenLieu;

import java.util.List;

public class HoaDonChiTiet {

  private Integer Id;
  private HoaDon hoaDon;
  private NguyenLieu nguyenLieu;

  private Integer soLuong;

  private Integer donGia;

  public HoaDonChiTiet(String tenNguyenLieu, Integer soLuong, Integer donGia) {
    this.nguyenLieu = new NguyenLieu();
    this.nguyenLieu.setTen(tenNguyenLieu);
    this.soLuong = soLuong;
    this.donGia = donGia;
  }

  public HoaDon getHoaDon() {
    return hoaDon;
  }

  public void setHoaDon(HoaDon hoaDon) {
    this.hoaDon = hoaDon;
  }

  public NguyenLieu getNguyenLieu() {
    return nguyenLieu;
  }

  public void setNguyenLieu(NguyenLieu nguyenLieu) {
    this.nguyenLieu = nguyenLieu;
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

  public Integer getId() {
    return Id;
  }

  public void setId(Integer id) {
    Id = id;
  }

  public HoaDonChiTiet() {
  }

  public HoaDonChiTiet(Integer id, HoaDon hoaDon, NguyenLieu nguyenLieu, Integer soLuong, Integer donGia) {
    Id = id;
    this.hoaDon = hoaDon;
    this.nguyenLieu = nguyenLieu;
    this.soLuong = soLuong;
    this.donGia = donGia;
  }
}
