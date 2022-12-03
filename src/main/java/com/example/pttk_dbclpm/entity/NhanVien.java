package com.example.pttk_dbclpm.entity;

import java.io.Serializable;

public class NhanVien extends ThanhVien implements Serializable {
  private Integer luong;
  private String sdt;

  public NhanVien(Integer id, String taiKhoan, String ten) {
    super(id, taiKhoan, ten);
  }

  public NhanVien(Integer id, String ten) {
    super(id, ten);
  }

  public Integer getLuong() {
    return luong;
  }

  public void setLuong(Integer luong) {
    this.luong = luong;
  }

  public String getSdt() {
    return sdt;
  }

  public void setSdt(String sdt) {
    this.sdt = sdt;
  }
}
