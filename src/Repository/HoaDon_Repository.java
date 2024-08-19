/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import dangnhap.DBConnect;
import Model.HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import Reponse.HoaDon_Repones;
import java.sql.ResultSet;

/**
 *
 * @author ASUS
 */
public class HoaDon_Repository {
    public boolean addHoaDon() {
        String sql = """
                    INSERT INTO [dbo].[HoaDon](
                               [ID_KhachHang]
                               ,[Id_Vocher]
                               ,[Thanhtien]
                               ,[Giamgia]
                               ,[Tongtien])
                         VALUES
                               (1,1,0,0,0)
                     """;
        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }
    public ArrayList<HoaDon_Repones> getHDchuaThanhToan(){
        ArrayList<HoaDon_Repones> list = new ArrayList<>();
        String sql = """
                     select HoaDon.ID_HoaDon,HoaDon.Ngaytao from HoaDon
                     where HoaDon.Trangthai = 1;
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
           ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                int IdHoaDon = rs.getInt(1);
                String ngayTao =rs.getString(2);
                HoaDon_Repones newH = new HoaDon_Repones(IdHoaDon, ngayTao );
                list.add(newH);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<HoaDon> getHDbyID (int id){
       ArrayList<HoaDon> list = new ArrayList<>();
       String sql ="""
                   SELECT [ID_HoaDon]
                         ,[ID_Nhanvien]
                         ,[ID_KhachHang]
                         ,[Id_Vocher]
                         ,[Ngaytao]
                         ,[Trangthai]
                         ,[Thanhtien]
                         ,[Giamgia]
                         ,[Tongtien]
                     FROM [dbo].[HoaDon]
                   where ID_HoaDon like ?
                   """;
        try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1,id);
            ResultSet rs = ps .executeQuery();
            while (rs.next()) {                
                
            }
        } catch (Exception e) {
        }
        return list;
    }
    public boolean thanhtoan(int thanhTien,int tongtien,int tienDuocGiam, int IDHoaDon){
        String sql = """
                      UPDATE [dbo].[HoaDon]
                         SET [Trangthai] = 0
                                   ,[Thanhtien] = ?
                                   ,[Giamgia] = ?
                                   ,[Tongtien] = ?
                          WHERE ID_HoaDon = ?
                     """;
        int check = 0 ;
        try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, thanhTien);
            ps.setInt(2, tienDuocGiam);
            ps.setInt(3, tongtien);
            ps.setInt(4, IDHoaDon);
          check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }
    public boolean taoHoaDonCho(int thanhTien,int tongtien,int tienDuocGiam, int IDHoaDon){
        String sql = """
                      UPDATE [dbo].[HoaDon]
                         SET 
                                   [Thanhtien] = ?
                                   ,[Giamgia] = ?
                                   ,[Tongtien] = ?
                          WHERE ID_HoaDon = ?
                     """;
        int check = 0 ;
        try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, thanhTien);
            ps.setInt(2, tienDuocGiam);
            ps.setInt(3, tongtien);
            ps.setInt(4, IDHoaDon);
          check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }
    public boolean traHang(int IDHoaDon){
        String sql = """
                    delete from [dbo].[HoaDon]
                      WHERE ID_HoaDon like ?
                     """;
        int check = 0 ;
         try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1,IDHoaDon);
          check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }
}
