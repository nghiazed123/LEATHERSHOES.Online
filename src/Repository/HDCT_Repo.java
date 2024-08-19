/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import dangnhap.DBConnect;
import Model.HoaDon;
import Model.HoaDonChiTiet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Reponse.HoaDonChiTiet_RePones;
/**
 *
 * @author ASUS
 */
public class HDCT_Repo {
     public boolean addHoaDonCT(HoaDonChiTiet newHD){
        String sql = """
                    INSERT INTO [dbo].[HoaDonChiTiet]
                               ([ID_HoaDon]
                               ,[ID_SanPhamChiTiet]
                               ,[Soluong]
                               ,[Gia]
                              )
                         VALUES
                               (?,?,?,?)
                     """;
        int check = 0 ;
        try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1,newHD.getIdHoaDon());
            ps.setObject(2, newHD.getIdSanPhamChiTiet());
            ps.setInt(3, newHD.getSoLuong());
            ps.setInt(4, newHD.getDonGia());
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0 ;
    }
     public ArrayList<HoaDonChiTiet_RePones> getGioHang( int idHoaDon){
        ArrayList<HoaDonChiTiet_RePones> newlist = new ArrayList<>();
        String sql = """
                     select SanPhamChiTiet.ID_SanPhamChiTiet, TenSP, HoaDonChiTiet.Soluong,HoaDonChiTiet.Gia from HoaDonChiTiet
                     	join HoaDon on HoaDonChiTiet.ID_HoaDon = HoaDon.ID_HoaDon	
                     	join SanPhamChiTiet on HoaDonChiTiet.ID_SanPhamChiTiet = SanPhamChiTiet.ID_SanPhamChiTiet
                     	join SanPham on SanPhamChiTiet.ID_SanPham = SanPham.ID_Sanpham
                        where HoaDon.ID_HoaDon like ?
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setObject(1, idHoaDon);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                int IDsanPhamChiTiet = rs.getInt(1);
                String tenSP = rs.getString(2);
                int soLuong = rs.getInt(3);
                int donGia = rs.getInt(4);
                HoaDonChiTiet_RePones newHDCT = new HoaDonChiTiet_RePones(IDsanPhamChiTiet, tenSP, donGia, soLuong);
                newlist.add(newHDCT);
            }
        } catch (Exception e) {
        }
        return newlist;
    }
     public boolean soLuongTonGioHang(int IDHoaDon,int IDSPCT , int soLuong){
        String sql = """
                     UPDATE [dbo].[HoaDonChiTiet]
                        SET 
                           [Soluong] = ?
                      WHERE ID_HoaDon like ? and ID_SanPhamChiTiet like ?
                     """;
        int check = 0 ;
         try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1,soLuong );
            ps.setObject(2,IDHoaDon);
            ps.setObject(3,IDSPCT);
          check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }
     public ArrayList<HoaDonChiTiet_RePones> get1GioHang( int idHoaDon, int IDSPCT){
        ArrayList<HoaDonChiTiet_RePones> newlist = new ArrayList<>();
        String sql = """
                     select SanPhamChiTiet.ID_SanPhamChiTiet, TenSP, HoaDonChiTiet.Soluong,HoaDonChiTiet.Gia from HoaDonChiTiet
                     	join HoaDon on HoaDonChiTiet.ID_HoaDon = HoaDon.ID_HoaDon	
                     	join SanPhamChiTiet on HoaDonChiTiet.ID_SanPhamChiTiet = SanPhamChiTiet.ID_SanPhamChiTiet
                     	join SanPham on SanPhamChiTiet.ID_SanPham = SanPham.ID_Sanpham
                        where HoaDon.ID_HoaDon like ? and SanPhamChiTiet.ID_SanPhamChiTiet like ?
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setObject(1, idHoaDon);
            ps.setObject(2, IDSPCT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                int IDsanPhamChiTiet = rs.getInt(1);
                String tenSP = rs.getString(2);
                int soLuong = rs.getInt(3);
                int donGia = rs.getInt(4);
                HoaDonChiTiet_RePones newHDCT = new HoaDonChiTiet_RePones(IDsanPhamChiTiet, tenSP, donGia, soLuong);
                newlist.add(newHDCT);
            }
        } catch (Exception e) {
        }
        return newlist;
    }
     public ArrayList<HoaDonChiTiet> getHoaDonChiTiet(int idSPCT,int idHoaDon){
         ArrayList<HoaDonChiTiet> list = new ArrayList<>();
         String sql = """
                     SELECT  [ID_HoaDon]
                            ,[ID_SanPhamChiTiet]
                            ,[Soluong]
                            ,[Gia]
                            ,[Trangthai]
                        FROM [dbo].[HoaDonChiTiet]
                        where ID_HoaDon like ? and ID_SanPhamChiTiet like ?
                      """;
         try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
             ps.setInt(1,idHoaDon);
             ps.setInt(2,idSPCT);
             ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                 int IDHoaDon = rs.getInt(1);
                 int IDsanPhamChiTiet = rs.getInt(2);
                 int soLuong = rs.getInt(3);
                 int donGia = rs.getInt(4);
                 int giamGia = 0;
                 HoaDonChiTiet newHDCT = new HoaDonChiTiet(IDHoaDon, IDsanPhamChiTiet, soLuong, donGia, giamGia);
                 list.add(newHDCT);
             }
         } catch (Exception e) {
             return null;
         }
         return list;
    }
     public boolean traHang(int IDHoaDon,int IDSPCT ){
        String sql = """
                    delete from [dbo].[HoaDonChiTiet]
                      WHERE ID_HoaDon like ? and ID_SanPhamChiTiet like ?
                     """;
        int check = 0 ;
         try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1,IDHoaDon);
            ps.setObject(2,IDSPCT);
          check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }
}
