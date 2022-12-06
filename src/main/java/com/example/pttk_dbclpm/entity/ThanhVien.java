package com.example.pttk_dbclpm.entity;

import java.io.Serializable;

public class ThanhVien implements Serializable {
  private Integer id;
  private String taiKhoan;
  private String matKhau;
  private String ten;

  public ThanhVien() {
  }

  public ThanhVien(String taiKhoan, String matKhau) {
    this.taiKhoan = taiKhoan;
    this.matKhau = matKhau;
  }

  public ThanhVien(Integer id, String ten) {
    this.id = id;
    this.ten = ten;
  }

  public ThanhVien(Integer id, String taiKhoan, String ten) {
    this.id = id;
    this.taiKhoan = taiKhoan;
    this.ten = ten;
  }

  public ThanhVien(Integer id, String taiKhoan, String matKhau, String ten) {
    this.id = id;
    this.taiKhoan = taiKhoan;
    this.matKhau = matKhau;
    this.ten = ten;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTaiKhoan() {
    return taiKhoan;
  }

  public void setTaiKhoan(String taiKhoan) {
    this.taiKhoan = taiKhoan;
  }

  public String getMatKhau() {
    return matKhau;
  }

  public void setMatKhau(String matKhau) {
    this.matKhau = matKhau;
  }

  public String getTen() {
    return ten;
  }

  public void setTen(String ten) {
    this.ten = ten;
  }
}
