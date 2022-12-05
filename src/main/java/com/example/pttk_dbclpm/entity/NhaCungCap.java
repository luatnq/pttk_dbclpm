package com.example.pttk_dbclpm.entity;

public class NhaCungCap {
  private Integer id;
  private String ten;
  private String diaChi;
  private String sdt;

  public NhaCungCap() {
  }

  public NhaCungCap(Integer id) {
    this.id = id;
  }

  public NhaCungCap(Integer id, String ten) {
    this.id = id;
    this.ten = ten;
  }

  public NhaCungCap(Integer id, String ten, String diaChi, String sdt) {
    this.id = id;
    this.ten = ten;
    this.diaChi = diaChi;
    this.sdt = sdt;
  }

  public NhaCungCap(String ten, String diaChi, String sdt) {
    this.ten = ten;
    this.diaChi = diaChi;
    this.sdt = sdt;
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

  public String getDiaChi() {
    return diaChi;
  }

  public void setDiaChi(String diaChi) {
    this.diaChi = diaChi;
  }

  public String getSdt() {
    return sdt;
  }

  public void setSdt(String sdt) {
    this.sdt = sdt;
  }
}
