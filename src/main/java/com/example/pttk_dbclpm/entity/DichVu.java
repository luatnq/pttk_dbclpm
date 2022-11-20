package com.example.pttk_dbclpm.entity;

import java.io.Serializable;

public class DichVu implements Serializable {
  private Integer id;
  private String ten;
  private Integer donGia;
  private String moTa;
  private String theLoai;


  public DichVu() {
  }

  public DichVu(
        Integer id,
        String ten,
        Integer donGia,
        String moTa,
        String theLoai
  ) {
    this.id = id;
    this.ten = ten;
    this.donGia = donGia;
    this.moTa = moTa;
    this.theLoai = theLoai;
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

  public Integer getDonGia() {
    return donGia;
  }

  public void setDonGia(Integer donGia) {
    this.donGia = donGia;
  }

  public String getMoTa() {
    return moTa;
  }

  public void setMoTa(String moTa) {
    this.moTa = moTa;
  }

  public String getTheLoai() {
    return theLoai;
  }

  public void setTheLoai(String theLoai) {
    this.theLoai = theLoai;
  }
}
