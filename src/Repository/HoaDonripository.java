package Repository;



import Reponse.HoaDonrepose;
import dangnhap.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;




/**
 *
 * @author nguyensyan
 */
public class HoaDonripository {
    public ArrayList<HoaDonrepose> getALL(){
        String sql = """
                 select hd.ID_HoaDon,hd.ID_KhachHang, hd.ID_Nhanvien,hd.Id_Vocher,hd.Trangthai, kh.TenKhachHang, nv.TenNV, hd.Thanhtien, hd.Ngaytao
                 	from HoaDon hd, KhachHang kh, NhanVien nv
                 	where hd.ID_KhachHang = kh.ID_KhachHang and
                 	hd.ID_Nhanvien = nv.ID_Nhanvien
                     """;
        ArrayList<HoaDonrepose> lists = new ArrayList<>();
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HoaDonrepose reponse;
                reponse = HoaDonrepose.builder()
                        .ID_HoaDon(rs.getInt("ID_HoaDon"))
                        .ID_KhachHang(rs.getString("ID_KhachHang"))
                        .ID_NhanVien(rs.getString("ID_Nhanvien"))
                        .ID_Vocher(rs.getInt("Id_Vocher")) // ID_Vocher corrected to ID_Voucher
                        .Trangthai(rs.getBoolean("Trangthai"))
                        .tenKhachHang(rs.getString("tenKhachHang"))
                        .TenNV(rs.getString("TenNV"))
                        .Thanhtien(rs.getInt("Thanhtien"))
                        .Ngaytao(rs.getDate("Ngaytao")) // assuming there's a `Ngaytao` field
                        .build();
                lists.add(reponse);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return lists;
        }
    
    
    public ArrayList<HoaDonrepose> search(String keyword, boolean TrangThai){
        String sql = """
                     select hd.ID_HoaDon, hd.ID_KhachHang, hd.ID_Nhanvien, hd.Trangthai, hd.Tongtien,
                                    kh.ID_KhachHang, kh.TenKhachHang, kh.SDT,
                                    nv.ID_Nhanvien, nv.TenNV
                             from HoaDon hd, NhanVien nv, KhachHang kh
                             where hd.ID_KhachHang = kh.ID_KhachHang
                             and hd.ID_Nhanvien = nv.ID_Nhanvien
                             and hd.Trangthai = ?
                     """;
        if(keyword != null && !keyword.isEmpty()){
            sql +="""
                  and
                  				( nv.TenNV LIKE ?
                  				  or
                  				  kh.TenKhachHang LIKE ?
                  				  or
                  				  kh.SDT like ?
                  				)
                  """;
        }
        ArrayList<HoaDonrepose> lists = new ArrayList<>();
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            int index = 1;
            ps.setBoolean(index++, TrangThai);
            if(keyword != null && !keyword.isEmpty()){
                String value = "%" + keyword + "%";
                ps.setObject(index++, value);
                ps.setObject(index++, value);
                ps.setObject(index++, value);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                HoaDonrepose response = HoaDonrepose.builder()
                        .ID_HoaDon(rs.getInt("ID_HoaDon"))
                        .ID_KhachHang(rs.getString("ID_KhachHang"))
                        .ID_NhanVien(rs.getString("ID_Nhanvien"))
                        .ID_Vocher(rs.getInt("Id_Vocher")) // ID_Vocher corrected to ID_Voucher
                        .Trangthai(rs.getBoolean("Trangthai"))
                        .tenKhachHang(rs.getString("tenKhachHang"))
                        .TenNV(rs.getString("TenNV"))
                        .Thanhtien(rs.getInt("Thanhtien"))
                        .Ngaytao(rs.getDate("Ngaytao")) // assuming there's a `Ngaytao` field
                        .build();
                lists.add(response);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return lists;
    }
   
    }
     

