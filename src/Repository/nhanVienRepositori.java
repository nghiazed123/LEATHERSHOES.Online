/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.nhanVien;
import Reponse.nhanVienReponse;
import dangnhap.DBConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class nhanVienRepositori {

    public ArrayList<nhanVien> getAll() {
        ArrayList<nhanVien> list = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery("select * from NhanVien");
            while (r.next()) {
                nhanVien nv = new nhanVien();
                nv.setIdNhanVien(r.getInt(1));
                nv.setTenNhanVien(r.getString(2));
                nv.setDiaChi(r.getString(3));
                nv.setEmail(r.getString(4));
                nv.setSdt(r.getString(5));
                nv.setTenDangNhap(r.getString(6));
                nv.setMatKhau(r.getString(7));
                nv.setChucVu(r.getBoolean(8));
                nv.setNgayTao(r.getString(9));
                nv.setNgaySua(r.getString(10));
                nv.setTrangThai(r.getBoolean(11));
                list.add(nv);
            }
            return list;
        } catch (Exception e) {

        }
        return null;
    }

    public boolean add(nhanVien nv) {
        PreparedStatement ps = null;
        Connection c = null;
        try {
            c = DBConnect.getConnection();
            ps = c.prepareStatement("INSERT INTO NhanVien (TenNV,Diachi,Email,SDT,TenDangNhap,MatKhau,ChucVu,Ngaytao,Ngaysua,Trangthai) VALUES (?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, nv.getTenNhanVien());
            ps.setString(2, nv.getDiaChi());
            ps.setString(3, nv.getEmail());
            ps.setString(4, nv.getSdt());
            ps.setString(5, nv.getTenDangNhap());
            ps.setString(6, nv.getMatKhau());
            ps.setBoolean(7, nv.isChucVu());
            ps.setString(8, nv.getNgayTao());
            ps.setString(9, nv.getNgaySua());
            ps.setBoolean(10, nv.isTrangThai());
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

    public int Delete(nhanVien nv) {
        try {
            Connection c = DBConnect.getConnection();
            PreparedStatement p = c.prepareStatement("DELETE FROM NhanVien WHERE ID_Nhanvien=?");
            p.setInt(1, nv.getIdNhanVien());
            return p.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void Edit(nhanVien a) {
        try {
            Connection c = DBConnect.getConnection();
            PreparedStatement ps = c.prepareCall("UPDATE NhanVien SET TenNV=?,Diachi=?,Email=?,SDT=?,TenDangNhap=?,MatKhau=?,ChucVu=?,Ngaytao=?,Ngaysua=?,Trangthai=? WHERE ID_Nhanvien =?");
            ps.setString(1, a.getTenNhanVien()); // Sửa thông tin Tên khách hàng
            ps.setString(2, a.getDiaChi()); // Sửa thông tin Ngày sinh
            ps.setString(3, a.getEmail()); // Sửa thông tin Giới tính
            ps.setString(4, a.getSdt()); // Sửa thông tin Số điện thoại
            ps.setString(5, a.getTenDangNhap()); // Sửa thông tin Địa chỉ
            ps.setString(6, a.getMatKhau()); // Sửa thông tin Địa chỉ
            ps.setBoolean(7, a.isChucVu());
            ps.setString(8, a.getNgayTao()); // Sửa thông tin Mã khách hàng
            ps.setString(9, a.getNgaySua()); // Sửa thông tin Mã khách hàng
            ps.setBoolean(10, a.isTrangThai()); // Sửa thông tin Mã khách hàng
            ps.setInt(11, a.getIdNhanVien());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
