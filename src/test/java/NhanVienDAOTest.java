import com.example.pttk_dbclpm.dao.NhanVienDAO;
import com.example.pttk_dbclpm.dao.impl.NhanVienDAOImpl;
import com.example.pttk_dbclpm.entity.NhanVien;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class NhanVienDAOTest {
  private NhanVienDAO nhanVienDAO = new NhanVienDAOImpl();

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
}
