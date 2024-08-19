/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.khachHang;
import Model.nhanVien;
import dangnhap.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class khachHangRepositori {

    public ArrayList<khachHang> getAll() {
        ArrayList<khachHang> list = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery("select * from KhachHang");
            while (r.next()) {
                khachHang nv = new khachHang();
                nv.setIdKhachHang(r.getInt(1));
                nv.setTenKhachHang(r.getString(2));
                nv.setSdt(r.getString(3));
                nv.setDiaChi(r.getString(4));
                nv.setTrangThai(r.getBoolean(5));
                list.add(nv);
            }
            return list;
        } catch (Exception e) {

        }
        return null;
    }

    public boolean add(khachHang kh) {
        PreparedStatement ps = null;
        Connection c = null;
        try {
            c = DBConnect.getConnection();
            ps = c.prepareStatement("INSERT INTO KhachHang (TenKhachHang,SDT,Diachi,Trangthai) VALUES (?,?,?,?)");
            ps.setString(1, kh.getTenKhachHang());
            ps.setString(2, kh.getSdt());
            ps.setString(3, kh.getDiaChi());
            ps.setBoolean(4, kh.isTrangThai());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0; // Trả về true nếu có ít nhất một hàng được tác động
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đảm bảo đóng kết nối và tài nguyên khi không cần thiết
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public int Delete(khachHang kh) {
        try {
            Connection c = DBConnect.getConnection();
            PreparedStatement p = c.prepareStatement("DELETE FROM KhachHang WHERE ID_KhachHang=?");
            p.setInt(1, kh.getIdKhachHang());
            return p.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void Edit(khachHang a) {
        try {
            Connection c = DBConnect.getConnection();
            PreparedStatement ps = c.prepareCall("UPDATE KhachHang SET TenKhachHang=?,SDT=?,Diachi=?,Trangthai=? WHERE ID_KhachHang =?");
            ps.setString(1, a.getTenKhachHang()); // Sửa thông tin Tên khách hàng
            ps.setString(2, a.getDiaChi()); // Sửa thông tin Ngày sinh
            ps.setString(3, a.getSdt()); // Sửa thông tin Giới tính
            ps.setBoolean(4, a.isTrangThai()); // Sửa thông tin Mã khách hàng
            ps.setInt(5, a.getIdKhachHang());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
