import com.example.pttk_dbclpm.dao.HoaDonNguyenLieuDAO;
import com.example.pttk_dbclpm.dao.NguyenLieuDAO;
import com.example.pttk_dbclpm.dao.NhaCungCapDAO;
import com.example.pttk_dbclpm.dao.NhanVienDAO;
import com.example.pttk_dbclpm.dao.impl.HoaDonNguyenLieuDAOImpl;
import com.example.pttk_dbclpm.dao.impl.NguyenLieuDAOImpl;
import com.example.pttk_dbclpm.dao.impl.NhaCungCapDAOImpl;
import com.example.pttk_dbclpm.dao.impl.NhanVienDAOImpl;
import com.example.pttk_dbclpm.entity.*;
import dao.NguyenLieuDAOTest;
import dao.impl.HoaDonNguyenLieuDAOImplTest;
import dao.impl.NguyenLieuDAOImplTest;
import dao.impl.NhaCungCapDAOImplTest;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

public class AppTest {

  private NguyenLieuDAO nguyenLieuDAO = new NguyenLieuDAOImpl();
  private dao.NguyenLieuDAOTest nguyenLieuDAOTest = new NguyenLieuDAOImplTest();
  private HoaDonNguyenLieuDAO hoaDonNguyenLieuDAO = new HoaDonNguyenLieuDAOImpl();
  private dao.HoaDonNguyenLieuDAOTest hoaDonNguyenLieuDAOTest = new HoaDonNguyenLieuDAOImplTest();
  private NhanVienDAO nhanVienDAO = new NhanVienDAOImpl();
  private NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAOImpl();
  private dao.NhaCungCapDAOTest nhaCungCapDAOTest = new NhaCungCapDAOImplTest();


  /**
   * login success
   */
  @Test
  public void loginTest1() {
    NhanVien nhanVien = nhanVienDAO.login("luatnq", "123");
    assertEquals("luatnq", nhanVien.getTaiKhoan());
  }

  /**
   * login fail with password invalid
   */
  @Test
  public void loginTest2() {
    NhanVien nhanVien = nhanVienDAO.login("luatnq", "1233");
    assertNull(nhanVien);
  }

  /**
   * login fail with username invalid
   */
  @Test
  public void loginTest3() {
    NhanVien nhanVien = nhanVienDAO.login("luatnq12", "123");
    assertNull(nhanVien);
  }

  /**
   * Tìm kiếm nhà cung cấp có tên "Long hải" đã tồn tại trong database
   */
  @Test
  public void searchTestCase1() {
    String tenNhaCungCap = "Long hải";
    List<NhaCungCap> nhaCungCapList = nhaCungCapDAO.list(tenNhaCungCap);
    assertEquals(tenNhaCungCap, nhaCungCapList.get(0).getTen());
  }

  /**
   * Tìm kiếm nhà cung cấp có tên "Long hải dương" không tồn tại trong database
   */
  @Test
  public void searchTestCase2() {
    String tenNhaCungCap = "Long hải dương";
    List<NhaCungCap> nhaCungCapList = nhaCungCapDAO.list(tenNhaCungCap);
    assertEquals(0, nhaCungCapList.size());
  }

  /**
   * Lấy danh sách nhà cung cấp với trường hợp tồn tại thông tin nhà cung cấp lưu trong database
   */
  @Test
  public void searchTestCase3() {
    List<NhaCungCap> nhaCungCapList = nhaCungCapDAO.list(null);
    assertNotEquals(0, nhaCungCapList.size());
  }

  /**
   * Thêm mới nhà cung cấp với thông tin hợp lệ
   *
   * @throws SQLException
   */
  @Test
  public void createNccTest1() throws SQLException {
    NhaCungCap nhaCungCapInput = new NhaCungCap("Đại lý A", "Tam đảo", "0987654123");
    NhaCungCap nhaCungCapRes = nhaCungCapDAO.luuNcc(nhaCungCapInput);
    assertNotNull(nhaCungCapInput.getId());
    assertEquals(nhaCungCapInput.getTen(), nhaCungCapRes.getTen());
    assertEquals(nhaCungCapInput.getDiaChi(), nhaCungCapRes.getDiaChi());
    assertEquals(nhaCungCapInput.getSdt(), nhaCungCapRes.getSdt());
    assertEquals(true, nhaCungCapDAOTest.deleteById(nhaCungCapRes.getId()));
  }

  /**
   * Thêm mới nhà cung cấp với thông tin số điện thoại đã tồn tại trong database
   *
   * @throws SQLException
   */
  @Test
  public void createNccTest2() throws SQLException {
    NhaCungCap nhaCungCapInput = new NhaCungCap("Đại lý A", "Tam đảo", "0967821721");
    NhaCungCap nhaCungCapRes = nhaCungCapDAO.luuNcc(nhaCungCapInput);
    assertNull(nhaCungCapRes);
  }

  /**
   * Lấy danh sách nguyên liệu của 1 nhà cung cấp với ID nhà cung cấp bằng 1
   */
  @Test
  public void listTest1() {
    List<NguyenLieu> nguyenLieus = nguyenLieuDAO.list(null, 1);
    assertNotEquals(0, nguyenLieus.size());
  }

  /**
   * Lấy danh sách nguyên liệu của 1 nhà cung cấp với ID nhà cung cấp bằng 1 và tên nguyên liệu là "Sơn móng tay" có tồn tại
   * trong database
   */
  @Test
  public void listTest2() {
    String tenNguyenLieu = "Sơn móng tay";
    List<NguyenLieu> nguyenLieus = nguyenLieuDAO.list(tenNguyenLieu, 1);
    assertEquals(tenNguyenLieu, nguyenLieus.get(0).getTen());
  }

  /**
   * Lấy danh sách nguyên liệu của 1 nhà cung cấp với ID nhà cung cấp bằng 1 và tên nguyên liệu là "Sơn móng tay"
   * không tồn tại trong database
   */
  @Test
  public void listTest3() {
    String tenNguyenLieu = "Sơn móng tay 3";
    List<NguyenLieu> nguyenLieus = nguyenLieuDAO.list(tenNguyenLieu, 1);
    assertEquals(0, nguyenLieus.size());
  }

  /**
   * Lấy id nguyên liệu với tên nguyên liệu là "Sơn móng tay" có tồn tại trong database
   */
  @Test
  public void getIdNguyenLieuTest1() {
    String tenNguyenLieu = "Sơn móng tay";
    Integer idNguyenLieu = nguyenLieuDAO.getIdNguyenLieu(tenNguyenLieu);
    assertNotNull(idNguyenLieu);
  }

  /**
   * Lấy id nguyên liệu với tên nguyên liệu là "Sơn móng tay" không tồn tại trong database
   */
  @Test
  public void getIdNguyenLieuTest2() {
    String tenNguyenLieu = "Sơn móng tay 3";
    Integer idNguyenLieu = nguyenLieuDAO.getIdNguyenLieu(tenNguyenLieu);
    assertNull(idNguyenLieu);
  }

  /**
   * Thêm mới nguyên liệu của nhà cung cấp đã tồn tại trong database
   */
  @Test
  public void createNguyenLieuTest1() throws SQLException {
    NguyenLieuNhaCungCap nguyenLieuNhaCungCap = nguyenLieuDAO.luuNguyenLieu("Sơn móng tay", 1);
    assertNull(nguyenLieuNhaCungCap);
  }

  /**
   * Thêm mới nguyên liệu của nhà cung cấp với tên nguyên liệu đã tồn tại trong tblNguyenLieu
   * Và chưa từng được cung cấp bởi nhà cung cấp
   */
  @Test
  public void createNguyenLieuTest2() throws SQLException {
    NguyenLieuNhaCungCap nguyenLieuNhaCungCap = nguyenLieuDAO.luuNguyenLieu("Dầu thơm", 1);
    assertEquals("Dầu thơm", nguyenLieuNhaCungCap.getNguyenLieu().getTen());
    assertEquals(Integer.valueOf(1), nguyenLieuNhaCungCap.getNhaCungCap().getId());
    assertEquals(true, nguyenLieuDAOTest.deleteById(nguyenLieuNhaCungCap.getId()));
  }

  /**
   * Thêm mới nguyên liệu của nhà cung cấp với tên nguyên liệu chưa tồn tại trong tblNguyenLieu
   */
  @Test
  public void createNguyenLieuTest3() throws SQLException {
    NguyenLieuNhaCungCap nguyenLieuNhaCungCap = nguyenLieuDAO.luuNguyenLieu("Dầu thơm bưởi Việt Nam", 1);
    assertEquals("Dầu thơm bưởi Việt Nam", nguyenLieuNhaCungCap.getNguyenLieu().getTen());
    assertEquals(Integer.valueOf(1), nguyenLieuNhaCungCap.getNhaCungCap().getId());
    assertEquals(true, nguyenLieuDAOTest.deleteById(nguyenLieuNhaCungCap.getId()));
    assertEquals(true, nguyenLieuDAOTest.deleteNguyenLieuById(nguyenLieuNhaCungCap.getNguyenLieu().getId()));
  }

  /**
   * Lưu hóa đơn với những thông tin nguyên liệu đã nhập
   */
  @Test
  public void luuHoaDonNguyenLieu() throws SQLException {
    NguyenLieuNhaCungCap nguyenLieuNhaCungCap = new NguyenLieuNhaCungCap
          (
                2,
                120000,
                1,
                "Long hải",
                1,
                "Sơn móng tay"
          );

    List<NguyenLieuNhaCungCap> nguyenLieus = Arrays.asList(nguyenLieuNhaCungCap);

    Integer tongTien = calTotalMoney(nguyenLieus);
    HoaDonNguyenLieu hoaDonNguyenLieuInput = new HoaDonNguyenLieu(
          1,
          "luatnq",
          tongTien,
          null,
          nguyenLieus
    );

    List<NguyenLieu> nguyenLieuListExist = nguyenLieuDAO.list("Sơn móng tay", 1);

    HoaDonNguyenLieu hoaDonNguyenLieu = hoaDonNguyenLieuDAO.luuHoaDon(hoaDonNguyenLieuInput);
    assertNotNull(hoaDonNguyenLieu.getId());
    assertEquals(tongTien, hoaDonNguyenLieu.getTongTien());

    List<NguyenLieu> nguyenLieuListFetch = nguyenLieuDAO.list("Sơn móng tay", 1);

    Integer soLuongFetch = nguyenLieuListExist.get(0).getSoLuong() + nguyenLieuNhaCungCap.getSoLuong();
    assertEquals(soLuongFetch, nguyenLieuListFetch.get(0).getSoLuong());

    assertEquals(true, nguyenLieuDAOTest.deleteNguyenLieuNccByHoaDonId(hoaDonNguyenLieu.getId()));
    assertEquals(true, hoaDonNguyenLieuDAOTest.deleteHoaDonNguyenLieuById(hoaDonNguyenLieu.getId()));
    assertEquals(true, hoaDonNguyenLieuDAOTest.deleteHoaDonById(hoaDonNguyenLieu.getId()));

  }

  private Integer calTotalMoney(List<NguyenLieuNhaCungCap> nguyenLieus) {
    Integer totalMoney = 0;

    for (NguyenLieuNhaCungCap nguyenLieuNhaCungCap : nguyenLieus) {
      totalMoney += nguyenLieuNhaCungCap.getDonGia() * nguyenLieuNhaCungCap.getDonGia();
    }
    return totalMoney;
  }

}
