package com.example.pttk_dbclpm.entity;

import java.io.Serializable;

public class KhachHang implements Serializable {
  private Integer id;
  private String sdt;
  private String ten;
  private Integer diem;

  public KhachHang() {
  }

  public KhachHang(Integer id, String sdt, String ten, Integer diem) {
    this.id = id;
    this.sdt = sdt;
    this.ten = ten;
    this.diem = diem;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getSdt() {
    return sdt;
  }

  public void setSdt(String sdt) {
    this.sdt = sdt;
  }

  public String getTen() {
    return ten;
  }

  public void setTen(String ten) {
    this.ten = ten;
  }

  public Integer getDiem() {
    return diem;
  }

  public void setDiem(Integer diem) {
    this.diem = diem;
  }
}
