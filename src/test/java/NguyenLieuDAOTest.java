import com.example.pttk_dbclpm.dao.NguyenLieuDAO;
import com.example.pttk_dbclpm.dao.NguyenLieuNhaCungCapDAO;
import com.example.pttk_dbclpm.dao.impl.NguyenLieuDAOImpl;
import com.example.pttk_dbclpm.dao.impl.NguyenLieuNhaCungCapDAOImpl;
import com.example.pttk_dbclpm.entity.NguyenLieu;
import com.example.pttk_dbclpm.entity.NguyenLieuNhaCungCap;
import dao.impl.NguyenLieuDAOImplTest;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class NguyenLieuDAOTest {

  private NguyenLieuNhaCungCapDAO nguyenLieuNhaCungCapDAO = new NguyenLieuNhaCungCapDAOImpl();
  private NguyenLieuDAO nguyenLieuDAO = new NguyenLieuDAOImpl();
  private dao.NguyenLieuDAOTest nguyenLieuDAOTest = new NguyenLieuDAOImplTest();

  /**
   * Lấy danh sách nguyên liệu của 1 nhà cung cấp với ID nhà cung cấp bằng 1
   */
  @Test
  public void listTest1() {
    List<NguyenLieuNhaCungCap> nguyenLieus = nguyenLieuNhaCungCapDAO.list(new NguyenLieuNhaCungCap(null, 1));
    assertNotEquals(0, nguyenLieus.size());
  }

  /**
   * Lấy danh sách nguyên liệu của 1 nhà cung cấp với ID nhà cung cấp bằng 1 và tên nguyên liệu là "Sơn móng tay" có tồn tại
   * trong database
   */
  @Test
  public void listTest2() {
    String tenNguyenLieu = "Sơn móng tay";
    List<NguyenLieuNhaCungCap> nguyenLieus = nguyenLieuNhaCungCapDAO.list(new NguyenLieuNhaCungCap(tenNguyenLieu, 1));
    assertEquals(tenNguyenLieu, nguyenLieus.get(0).getNguyenLieu().getTen());
  }

  /**
   * Lấy danh sách nguyên liệu của 1 nhà cung cấp với ID nhà cung cấp bằng 1 và tên nguyên liệu là "Sơn móng tay"
   * không tồn tại trong database
   */
  @Test
  public void listTest3() {
    String tenNguyenLieu = "Sơn móng tay 3";
    List<NguyenLieuNhaCungCap> nguyenLieus = nguyenLieuNhaCungCapDAO.list(new NguyenLieuNhaCungCap(tenNguyenLieu, 1));
    assertEquals(0, nguyenLieus.size());
  }

  /**
   * Lấy id nguyên liệu với tên nguyên liệu là "Sơn móng tay" có tồn tại trong database
   */
  @Test
  public void getIdNguyenLieuTest1() {
    String tenNguyenLieu = "Sơn móng tay";
    Integer idNguyenLieu = nguyenLieuDAO.getIdNguyenLieu(new NguyenLieu(tenNguyenLieu));
    assertNotNull(idNguyenLieu);
  }

  /**
   * Lấy id nguyên liệu với tên nguyên liệu là "Sơn móng tay" không tồn tại trong database
   */
  @Test
  public void getIdNguyenLieuTest2() {
    String tenNguyenLieu = "Sơn móng tay 3";
    Integer idNguyenLieu = nguyenLieuDAO.getIdNguyenLieu(new NguyenLieu(tenNguyenLieu));
    assertNull(idNguyenLieu);
  }

  /**
   * Thêm mới nguyên liệu của nhà cung cấp đã tồn tại trong database
   */
  @Test
  public void createNguyenLieuTest1() throws SQLException {
    NguyenLieuNhaCungCap nguyenLieuNhaCungCap = nguyenLieuNhaCungCapDAO.luuNguyenLieu(new NguyenLieuNhaCungCap("Sơn móng tay", 1));
    assertNull(nguyenLieuNhaCungCap);
  }

  /**
   * Thêm mới nguyên liệu của nhà cung cấp với tên nguyên liệu đã tồn tại trong tblNguyenLieu
   * Và chưa từng được cung cấp bởi nhà cung cấp
   */
  @Test
  public void createNguyenLieuTest2() throws SQLException {
//    NguyenLieuNhaCungCap nguyenLieuNhaCungCap = nguyenLieuDAO.luuNguyenLieu("Dầu thơm", 1);
    NguyenLieuNhaCungCap nguyenLieuNhaCungCap = nguyenLieuNhaCungCapDAO.luuNguyenLieu(new NguyenLieuNhaCungCap("Dầu thơm", 1));
    assertEquals("Dầu thơm", nguyenLieuNhaCungCap.getNguyenLieu().getTen());
    assertEquals(Integer.valueOf(1), nguyenLieuNhaCungCap.getNhaCungCap().getId());
    assertEquals(true, nguyenLieuDAOTest.deleteById(nguyenLieuNhaCungCap.getId()));
  }

  /**
   * Thêm mới nguyên liệu của nhà cung cấp với tên nguyên liệu chưa tồn tại trong tblNguyenLieu
   */
  @Test
  public void createNguyenLieuTest3() throws SQLException {
    NguyenLieuNhaCungCap nguyenLieuNhaCungCap = nguyenLieuNhaCungCapDAO.luuNguyenLieu(new NguyenLieuNhaCungCap("Dầu thơm bưởi Việt Nam", 1));
    assertEquals("Dầu thơm bưởi Việt Nam", nguyenLieuNhaCungCap.getNguyenLieu().getTen());
    assertEquals(Integer.valueOf(1), nguyenLieuNhaCungCap.getNhaCungCap().getId());
    assertEquals(true, nguyenLieuDAOTest.deleteById(nguyenLieuNhaCungCap.getId()));
    assertEquals(true, nguyenLieuDAOTest.deleteNguyenLieuById(nguyenLieuNhaCungCap.getNguyenLieu().getId()));
  }
}
