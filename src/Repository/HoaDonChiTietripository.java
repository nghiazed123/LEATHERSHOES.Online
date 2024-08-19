/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Reponse.HoaDonChiTietrepose;
import dangnhap.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author nguyensyan
 */
public class HoaDonChiTietripository {

     public ArrayList<HoaDonChiTietrepose> getALL(int hoaDonID){
        String sql = """
                  SELECT sp.ID_Sanpham, sp.TenSP, hdct.Soluong, hdct.Gia, hdct.Soluong * hdct.Gia AS Thanhtien, 
                                         spct.GhiChu, kt.TenKichThuoc, cl.TenChatLieu, th.TenThuongHieu, ms.TenMauSac
                                  FROM HoaDonChiTiet hdct
                                  JOIN SanPhamChiTiet spct ON hdct.ID_SanPhamChiTiet = spct.ID_SanPhamChiTiet
                                  JOIN KichThuoc kt ON spct.ID_KichThuoc = kt.ID_KichThuoc
                                  JOIN ChatLieu cl ON spct.ID_ChatLieu = cl.ID_ChatLieu
                                  JOIN ThuongHieu th ON spct.ID_ThuongHieu = th.ID_ThuongHieu
                                  JOIN MauSac ms ON spct.ID_MauSac = ms.ID_MauSac
                                  JOIN SanPham sp ON spct.ID_SanPham = sp.ID_SanPham
                                  WHERE hdct.ID_HoaDonChiTiet = ?
                     """;
        ArrayList<HoaDonChiTietrepose> listst = new ArrayList<>();
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, hoaDonID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HoaDonChiTietrepose reponse = HoaDonChiTietrepose.builder()
                        .ID_SanPham(rs.getInt("ID_SanPham"))
                        .TenSP(rs.getString("TenSP"))
                        .Soluong(rs.getInt("Soluong"))
                        .Gia(rs.getInt("Gia"))
                        .Thanhtien(rs.getInt("Thanhtien"))
                        .TenKichThuoc(rs.getString("TenKichThuoc"))
                        .TenChatLieu(rs.getString("TenChatLieu"))
                        .TenThuongHieu(rs.getString("TenThuongHieu"))
                        .TenMauSac(rs.getString("TenMauSac"))
                        .build();
                listst.add(reponse);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listst;
        }

}
