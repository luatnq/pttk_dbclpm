package com.example.pttk_dbclpm.entity;


import java.util.List;

public class HoaDonDichVu extends HoaDon {
  private List<Slot> slots;
  private KhachHang khachHang;

  public HoaDonDichVu() {
  }

  public HoaDonDichVu(Integer id, NhanVien nhanVien, String moTa, List<Slot> slots, KhachHang khachHang) {
    super(id, nhanVien, moTa);
    this.slots = slots;
    this.khachHang = khachHang;
  }

  public List<Slot> getSlots() {
    return slots;
  }

  public void setSlots(List<Slot> slots) {
    this.slots = slots;
  }

  public KhachHang getKhachHang() {
    return khachHang;
  }

  public void setKhachHang(KhachHang khachHang) {
    this.khachHang = khachHang;
  }
}
