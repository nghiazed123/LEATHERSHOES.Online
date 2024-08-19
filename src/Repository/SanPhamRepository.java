/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.LoaiSanPham;
import dangnhap.DBConnect;
import Model.SanPham;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Vinh Thang
 */
public class SanPhamRepository {

    private Connection conn;

    public SanPhamRepository() {
        conn = DBConnect.getConnection();
    }

    public ArrayList<SanPham> getData() throws SQLException {
        ArrayList<SanPham> arrSP = new ArrayList<>();

        String query = "SELECT * FROM SanPham";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(query);

        while (rs.next()) {
            SanPham sp = new SanPham();
            sp.setID_SanPham(rs.getInt("ID_SanPham"));
            sp.setTenSP(rs.getString("TenSP"));
            sp.setGia(rs.getInt("Gia"));
            sp.setID_LoaiSP(rs.getString("ID_LoaiSP"));
            sp.setTrangThai(rs.getBoolean("Trangthai"));

            arrSP.add(sp);
        }
        return arrSP;
    }

    public ArrayList<LoaiSanPham> getLoaiSanPham() throws SQLException {
        ArrayList<LoaiSanPham> arrLoaiSP = new ArrayList<>();
        String query = "SELECT * FROM LoaiSanPham";
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            LoaiSanPham loaiSp = new LoaiSanPham();
            loaiSp.setID_LoaiSP(rs.getString("ID_LoaiSP"));
            loaiSp.setTenLoai(rs.getString("TenLoai"));
            arrLoaiSP.add(loaiSp);
        }
        return arrLoaiSP;
    }

    public void themSP(SanPham sp) throws SQLException {
        String query = "INSERT INTO SanPham (TenSP, Gia, ID_LoaiSP, Trangthai) VALUES (?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        
        ps.setString(1, sp.getTenSP());
        ps.setInt(2, sp.getGia());
        ps.setString(3, sp.getID_LoaiSP());
        ps.setBoolean(4, sp.isTrangThai());

        ps.executeUpdate();
    }

    public void suaSP(SanPham sp) throws SQLException {
        String query = "UPDATE SanPham SET TenSP = ?, Gia = ?, ID_LoaiSP = ?, Trangthai = ? WHERE ID_SanPham = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, sp.getTenSP());
        ps.setInt(2, sp.getGia());
        ps.setString(3, sp.getID_LoaiSP());
        ps.setBoolean(4, sp.isTrangThai());
        ps.setInt(5, sp.getID_SanPham());

        ps.execute();
    }

    public void xoaSP(String idSanPham) throws SQLException {
    String xoaHoaDonChiTietQuery = "DELETE FROM HoaDonChiTiet WHERE ID_SanPhamChiTiet = ?";
    String xoaSPChiTietQuery = "DELETE FROM SanPhamChiTiet WHERE ID_SanPham = ?";
    String xoaSanPhamQuery = "DELETE FROM SanPham WHERE ID_SanPham = ?";

    try (PreparedStatement xoaHoaDonChiTietPS = conn.prepareStatement(xoaHoaDonChiTietQuery);
         PreparedStatement xoaSPChiTietPS = conn.prepareStatement(xoaSPChiTietQuery);
         PreparedStatement xoaSanPhamPS = conn.prepareStatement(xoaSanPhamQuery)) {

        // Xóa các bản ghi liên quan trong bảng HoaDonChiTiet
        xoaHoaDonChiTietPS.setString(1, idSanPham);
        xoaHoaDonChiTietPS.executeUpdate();

        // Xóa các bản ghi liên quan trong bảng SanPhamChiTiet
        xoaSPChiTietPS.setString(1, idSanPham);
        xoaSPChiTietPS.executeUpdate();

        // Xóa bản ghi chính trong bảng SanPham
        xoaSanPhamPS.setString(1, idSanPham);
        xoaSanPhamPS.executeUpdate();
        
    } catch (SQLException e) {
        // Xử lý lỗi
        System.err.println("Lỗi khi xóa sản phẩm: " + e.getMessage());
        throw e; // Ném lỗi để xử lý ở tầng gọi
    }
}
}
