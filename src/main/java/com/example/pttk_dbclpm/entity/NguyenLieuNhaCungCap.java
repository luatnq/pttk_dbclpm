package com.example.pttk_dbclpm.entity;

public class NguyenLieuNhaCungCap {
  private Integer id;
  private Integer soLuong;
  private Integer donGia;
  private NhaCungCap nhaCungCap;
  private NguyenLieu nguyenLieu;

  private Integer tongTien;

  public NguyenLieuNhaCungCap() {
  }

  public NguyenLieuNhaCungCap(Integer soLuong, String tenNguyenLieu){
    this.nguyenLieu = new NguyenLieu();
    this.nguyenLieu.setTen(tenNguyenLieu);
    this.soLuong= soLuong;
  }

  public NguyenLieuNhaCungCap(String tenNguyenLieu, Integer nccId ){
    this.nguyenLieu = new NguyenLieu();
    this.nguyenLieu.setTen(tenNguyenLieu);
    this.nhaCungCap = new NhaCungCap();
    this.nhaCungCap.setId(nccId);
  }

  public NguyenLieuNhaCungCap(Integer id, Integer soLuong, Integer donGia, NhaCungCap nhaCungCap, NguyenLieu nguyenLieu) {
    this.id = id;
    this.soLuong = soLuong;
    this.donGia = donGia;
    this.nhaCungCap = nhaCungCap;
    this.nguyenLieu = nguyenLieu;
  }

  public NguyenLieuNhaCungCap(Integer id, Integer nhaCungCapId, String tenNguyenLieu, Integer idNguyenLieu) {
    this.id = id;
    this.soLuong = 0;
    this.donGia = 0;
    this.nhaCungCap = new NhaCungCap(nhaCungCapId);
    this.nguyenLieu = new NguyenLieu(idNguyenLieu, tenNguyenLieu);
  }

  public NguyenLieuNhaCungCap(Integer soLuong, Integer donGia, Integer nhaCungCapId, String tenNhaCungCap, Integer nguyenLieuId, String tenNguyenLieu) {
    this.soLuong = soLuong;
    this.donGia = donGia;
    this.nhaCungCap = new NhaCungCap(nhaCungCapId, tenNhaCungCap);
    this.nguyenLieu = new NguyenLieu(nguyenLieuId, tenNguyenLieu);
    this.tongTien = soLuong * donGia;
  }

  public Integer getTongTien() {
    return tongTien;
  }

  public void setTongTien(Integer tongTien) {
    this.tongTien = tongTien;
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
