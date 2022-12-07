package com.example.pttk_dbclpm.entity;

public class NguyenLieu {

  private Integer id;
  private String ten;

  private Integer soLuong;

  public NguyenLieu() {
  }

  public NguyenLieu(String ten) {
    this.ten = ten;
  }

  public NguyenLieu(Integer id, String ten) {
    this.id = id;
    this.ten = ten;
  }

  public NguyenLieu(String ten, Integer soLuong) {
    this.ten = ten;
    this.soLuong = soLuong;
  }

  public NguyenLieu(Integer id, String ten, Integer soLuong) {
    this.id = id;
    this.ten = ten;
    this.soLuong = soLuong;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTen() {
    return ten;
  }

  public void setTen(String ten) {
    this.ten = ten;
  }

  public Integer getSoLuong() {
    return soLuong;
  }

  public void setSoLuong(Integer soLuong) {
    this.soLuong = soLuong;
  }
}
