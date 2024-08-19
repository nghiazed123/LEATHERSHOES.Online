/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.vouCher1;
import dangnhap.DBConnect;
import java.sql.Statement;
import java.util.ArrayList;

import dangnhap.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class vouCherRepositori {
      public ArrayList<vouCher1> getAll() {
        ArrayList<vouCher1> list = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery("select * from Vocher");
            while (r.next()) {
                vouCher1 nv = new vouCher1();
                nv.setIdVoucher(r.getInt(1));
                nv.setTen(r.getString(2));
                nv.setPhanTramGiam(r.getInt(3));
                nv.setNgayBatDau(r.getString(4));
                nv.setNgayKetThuc(r.getString(5));
                nv.setTrangThai(r.getBoolean(6));
                list.add(nv);
            }
            return list;
        } catch (Exception e) {

        }
        return null;
    }

    public boolean add(vouCher1 kh) {
        PreparedStatement ps = null;
        Connection c = null;
        try {
            c = DBConnect.getConnection();
            ps = c.prepareStatement("INSERT INTO Vocher (TenVocher,PhanTramGiam,Ngaybd,ngaykt,Trangthai) VALUES (?,?,?,?,?)");
            ps.setString(1, kh.getTen());
            ps.setInt(2, kh.getPhanTramGiam());
            ps.setString(3, kh.getNgayBatDau());
            ps.setString(4, kh.getNgayKetThuc());
            ps.setBoolean(5, kh.isTrangThai());
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

    public int Delete(vouCher1 kh) {
        try {
            Connection c = DBConnect.getConnection();
            PreparedStatement p = c.prepareStatement("DELETE FROM Vocher WHERE Id_Vocher=?");
            p.setInt(1, kh.getIdVoucher());
            return p.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void Edit(vouCher1 a) {
        try {
            Connection c = DBConnect.getConnection();
            PreparedStatement ps = c.prepareCall("UPDATE Vocher SET TenVocher=?,PhanTramGiam=?,Ngaybd=?,ngaykt=?,Trangthai=? WHERE Id_Vocher =?");
            ps.setString(1, a.getTen()); // Sửa thông tin Tên khách hàng
            ps.setInt(2, a.getPhanTramGiam()); // Sửa thông tin Ngày sinh
            ps.setString(3, a.getNgayBatDau()); // Sửa thông tin Giới tính
            ps.setString(4, a.getNgayKetThuc()); // Sửa thông tin Giới tính
            ps.setBoolean(5, a.isTrangThai()); // Sửa thông tin Mã khách hàng
            ps.setInt(6, a.getIdVoucher());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
