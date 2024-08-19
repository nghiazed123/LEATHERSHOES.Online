/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import dangnhap.DBConnect;
import Model.SanPhamChiTiet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Reponse.SanPhamChiTiet_Repones;

/**
 *
 * @author ASUS
 */
public class SanPhamChiTiet_Repo {
    
    public ArrayList<SanPhamChiTiet_Repones> getSanPham() {
        ArrayList<SanPhamChiTiet_Repones> list = new ArrayList<>();
        String sql = """
                    select ID_SanPhamChiTiet,TenSP,TenMauSac,TenChatLieu,TenKichThuoc,TenThuongHieu,Soluong,SanPhamChiTiet.Gia from SanPhamChiTiet
                                         join SanPham on SanPhamChiTiet.ID_SanPham = SanPham.ID_Sanpham
                                         join MauSac on SanPhamChiTiet.ID_MauSac = MauSac.ID_MauSac
                                         join ChatLieu on SanPhamChiTiet.ID_ChatLieu = ChatLieu.ID_ChatLieu
                                         join KichThuoc on SanPhamChiTiet.ID_KichThuoc = KichThuoc.ID_KichThuoc
                                         join ThuongHieu on SanPhamChiTiet.ID_ThuongHieu = ThuongHieu.ID_ThuongHieu
                    """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idSanPham = rs.getInt(1);
                String ten = rs.getString(2);
                String mauSac = rs.getString(3);
                String chatLieu = rs.getString(4);
                String kichThuoc = rs.getString(5);
                String thuongHieu = rs.getString(6);
                int soLuong = rs.getInt(7);
                int donGia = rs.getInt(8);
                SanPhamChiTiet_Repones neSPCT = new SanPhamChiTiet_Repones(idSanPham, ten, mauSac, chatLieu, kichThuoc, thuongHieu, soLuong, donGia);
                list.add(neSPCT);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public ArrayList<SanPhamChiTiet_Repones> getSanPhamtbyKhoangGia(int gialon, int giabe) {
        ArrayList<SanPhamChiTiet_Repones> list = new ArrayList<>();
        String sql = """
                   	select ID_SanPhamChiTiet,TenSP,TenMauSac,TenChatLieu,TenKichThuoc,TenThuongHieu,Soluong,SanPhamChiTiet.Gia from SanPhamChiTiet
                                                            join SanPham on SanPhamChiTiet.ID_SanPham = SanPham.ID_Sanpham
                                                            join MauSac on SanPhamChiTiet.ID_MauSac = MauSac.ID_MauSac
                                                            join ChatLieu on SanPhamChiTiet.ID_ChatLieu = ChatLieu.ID_ChatLieu
                                                            join KichThuoc on SanPhamChiTiet.ID_KichThuoc = KichThuoc.ID_KichThuoc
                                                            join ThuongHieu on SanPhamChiTiet.ID_ThuongHieu = ThuongHieu.ID_ThuongHieu
                   					    where SanPhamChiTiet.Gia between ? and ?
                    """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, giabe);
            ps.setInt(2, gialon);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idSanPham = rs.getInt(1);
                String ten = rs.getString(2);
                String mauSac = rs.getString(3);
                String chatLieu = rs.getString(4);
                String kichThuoc = rs.getString(5);
                String thuongHieu = rs.getString(6);
                int soLuong = rs.getInt(7);
                int donGia = rs.getInt(8);
                SanPhamChiTiet_Repones neSPCT = new SanPhamChiTiet_Repones(idSanPham, ten, mauSac, chatLieu, kichThuoc, thuongHieu, soLuong, donGia);
                list.add(neSPCT);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public boolean soLuongTon(int IDSPCT, int soLuong) {
        String sql = """
                     UPDATE [dbo].[SanPhamChiTiet]
                        SET [Soluong] = ?
                     WHERE ID_SanPhamChiTiet like ?
                     """;
        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, soLuong);
            ps.setObject(2, IDSPCT);
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    public ArrayList<SanPhamChiTiet_Repones> getSanPhambyID(int idSPCT) {
        ArrayList<SanPhamChiTiet_Repones> list = new ArrayList<>();
        String sql = """
                    select ID_SanPhamChiTiet,TenSP,TenMauSac,TenChatLieu,TenKichThuoc,TenThuongHieu,Soluong,SanPhamChiTiet.Gia from SanPhamChiTiet
                                         join SanPham on SanPhamChiTiet.ID_SanPham = SanPham.ID_Sanpham
                                         join MauSac on SanPhamChiTiet.ID_MauSac = MauSac.ID_MauSac
                                         join ChatLieu on SanPhamChiTiet.ID_ChatLieu = ChatLieu.ID_ChatLieu
                                         join KichThuoc on SanPhamChiTiet.ID_KichThuoc = KichThuoc.ID_KichThuoc
                                         join ThuongHieu on SanPhamChiTiet.ID_ThuongHieu = ThuongHieu.ID_ThuongHieu
                     where ID_SanPhamChiTiet like ?
                    """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idSPCT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idSanPham = rs.getInt(1);
                String ten = rs.getString(2);
                String mauSac = rs.getString(3);
                String chatLieu = rs.getString(4);
                String kichThuoc = rs.getString(5);
                String thuongHieu = rs.getString(6);
                int soLuong = rs.getInt(7);
                int donGia = rs.getInt(8);
                SanPhamChiTiet_Repones neSPCT = new SanPhamChiTiet_Repones(idSanPham, ten, mauSac, chatLieu, kichThuoc, thuongHieu, soLuong, donGia);
                list.add(neSPCT);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<SanPhamChiTiet_Repones> getSanPhambyIDChatLieu(int idChatLieu) {
        ArrayList<SanPhamChiTiet_Repones> list = new ArrayList<>();
        String sql = """
                    select ID_SanPhamChiTiet,TenSP,TenMauSac,TenChatLieu,TenKichThuoc,TenThuongHieu,Soluong,SanPhamChiTiet.Gia from SanPhamChiTiet
                                         join SanPham on SanPhamChiTiet.ID_SanPham = SanPham.ID_Sanpham
                                         join MauSac on SanPhamChiTiet.ID_MauSac = MauSac.ID_MauSac
                                         join ChatLieu on SanPhamChiTiet.ID_ChatLieu = ChatLieu.ID_ChatLieu
                                         join KichThuoc on SanPhamChiTiet.ID_KichThuoc = KichThuoc.ID_KichThuoc
                                         join ThuongHieu on SanPhamChiTiet.ID_ThuongHieu = ThuongHieu.ID_ThuongHieu
                     where ChatLieu.ID_ChatLieu like ?
                    """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idChatLieu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idSanPham = rs.getInt(1);
                String ten = rs.getString(2);
                String mauSac = rs.getString(3);
                String chatLieu = rs.getString(4);
                String kichThuoc = rs.getString(5);
                String thuongHieu = rs.getString(6);
                int soLuong = rs.getInt(7);
                int donGia = rs.getInt(8);
                SanPhamChiTiet_Repones neSPCT = new SanPhamChiTiet_Repones(idSanPham, ten, mauSac, chatLieu, kichThuoc, thuongHieu, soLuong, donGia);
                list.add(neSPCT);
            }
        } catch (Exception e) {
        }
        return list;
    }
}
