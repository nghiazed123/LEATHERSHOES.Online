/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import dangnhap.DBConnect;
import Model.KhachHang1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author ASUS
 */
public class KhachHang_Reposetory {
    public ArrayList<KhachHang1> getKhachHang̣̣(String SDT){
        ArrayList<KhachHang1> list = new ArrayList<>();
        String sql = """
                     select ID_KhachHang , TenKhachHang , SDT , Diachi from KhachHang where  SDT like ?
                     """;
        try (Connection con = DBConnect.getConnection();PreparedStatement ps = con.prepareStatement(sql)){
            ps.setObject(1, SDT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                int id = rs.getInt(1);
                String ten = rs.getString(2);
                String sdt = rs.getString(3);
                String diaChi = rs.getString(4);
                KhachHang1 newKH = new KhachHang1(id,ten, sdt, diaChi);
                list.add(newKH);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public boolean addKhachHang(String sdt,String tenKH){
        String sql ="""
                    INSERT INTO [dbo].[KhachHang]
                               ([TenKhachHang]
                               ,[SDT]
                               ,[Trangthai])
                         VALUES
                               (?,?,1)
                    """;
          int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, tenKH);
            ps.setObject(2,sdt);
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }
}
