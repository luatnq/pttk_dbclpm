import com.example.pttk_dbclpm.dao.HoaDonNguyenLieuDAO;
import com.example.pttk_dbclpm.dao.NguyenLieuDAO;
import com.example.pttk_dbclpm.dao.impl.HoaDonNguyenLieuDAOImpl;
import com.example.pttk_dbclpm.dao.impl.NguyenLieuDAOImpl;
import com.example.pttk_dbclpm.entity.HoaDonNguyenLieu;
import com.example.pttk_dbclpm.entity.NguyenLieu;
import com.example.pttk_dbclpm.entity.NguyenLieuNhaCungCap;
import dao.NguyenLieuDAOTest;
import dao.impl.HoaDonNguyenLieuDAOImplTest;
import dao.impl.NguyenLieuDAOImplTest;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class HoaDonNguyenLieuDAOTest {

  private HoaDonNguyenLieuDAO hoaDonNguyenLieuDAO = new HoaDonNguyenLieuDAOImpl();
  private NguyenLieuDAO nguyenLieuDAO = new NguyenLieuDAOImpl();
  private NguyenLieuDAOTest nguyenLieuDAOTest = new NguyenLieuDAOImplTest();
  private dao.HoaDonNguyenLieuDAOTest hoaDonNguyenLieuDAOTest = new HoaDonNguyenLieuDAOImplTest();

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
