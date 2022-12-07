import com.example.pttk_dbclpm.dao.NhaCungCapDAO;
import com.example.pttk_dbclpm.dao.impl.NhaCungCapDAOImpl;
import com.example.pttk_dbclpm.entity.NhaCungCap;
import dao.impl.NhaCungCapDAOImplTest;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class NhaCungCapDAOTest {
  private NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAOImpl();
  private dao.NhaCungCapDAOTest nhaCungCapDAOTest = new NhaCungCapDAOImplTest();

  /**
   * Tìm kiếm nhà cung cấp có tên "Long hải" đã tồn tại trong database
   */
  @Test
  public void searchTestCase1() {
    String tenNhaCungCap = "Long hải";
    List<NhaCungCap> nhaCungCapList = nhaCungCapDAO.list(new NhaCungCap(tenNhaCungCap));
    assertEquals(tenNhaCungCap, nhaCungCapList.get(0).getTen());
  }

  /**
   * Tìm kiếm nhà cung cấp có tên "Long hải dương" không tồn tại trong database
   */
  @Test
  public void searchTestCase2() {
    String tenNhaCungCap = "Long hải dương";
    List<NhaCungCap> nhaCungCapList = nhaCungCapDAO.list(new NhaCungCap(tenNhaCungCap));
    assertEquals(0, nhaCungCapList.size());
  }

  /**
   * Lấy danh sách nhà cung cấp với trường hợp tồn tại thông tin nhà cung cấp lưu trong database
   */
  @Test
  public void searchTestCase3() {
    List<NhaCungCap> nhaCungCapList = nhaCungCapDAO.list(new NhaCungCap());
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

}
