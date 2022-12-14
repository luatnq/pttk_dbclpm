package com.example.pttk_dbclpm.constant;

public class Constant {
  public static class DAOConstant {
    public static String URI = "jdbc:mysql://localhost:33061/pttk";
    public static String USER = "root";
    public static String PASSWORD = "root";
    public static String DRIVER = "com.mysql.jdbc.Driver";
  }


  public static class Web {
    public static String NHA_CUNG_CAP_LIST = "nccList";
    public static String NGUYEN_LIEU_LIST = "nlList";
    public static String NHA_CUNG_CAP_ID = "ncc_id";
//    public static String NHA_CUNG_CAP_NAME ="ncc_name";
    public static String NGUYEN_LIEU_DA_CHON = "nguyenLieuDaChon";
    public static String TEN_NHA_CUNG_CAP = "ncc_name";
    public static String NHAN_VIEN_LOGIN = "nhan_vien";
    public static String HOA_DON_NGUYEN_LIEU = "hoa_don";
    public static String HOA_DON_THANH_CONG = "hoa_don_success";
    public static String TYPE_MESSAGE = "type_message";
    public static String MESSAGE = "message";
  }

  public static class Message {
    public static String SUCCESS = "success";
    public static String FAIL = "danger";
    public static String SUCCESS_CONTENT = "Thêm mới thành công";
    public static String SUCESS_CONTENT_BASIC = "Thành công";
    public static String FAIL_CONTENT = "Thêm mới thất bại";

    public static String ENTER_SUCCESS = "Nhập nguyên liêu thành công";
  }
}
