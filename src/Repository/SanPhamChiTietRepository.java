/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.ChatLieu1;
import Model.KichThuoc1;
import Model.LoaiSanPham;
import Model.MauSac1;
import Model.SanPhamChiTiet11;
import Model.ThuongHieu1;
import dangnhap.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Vinh Thang
 */
public class SanPhamChiTietRepository {

    private Connection conn;

    public SanPhamChiTietRepository() {
        conn = DBConnect.getConnection();
    }

    public ArrayList<SanPhamChiTiet11> getData() throws SQLException {
        ArrayList<SanPhamChiTiet11> arrSPCT = new ArrayList<>();
        String query = "SELECT * FROM SanPhamChiTiet";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(query);

        while (rs.next()) {
            SanPhamChiTiet11 spct = new SanPhamChiTiet11();
            spct.setID_SPCT(rs.getInt("ID_SanPhamChiTiet"));
            spct.setID_SanPham(rs.getString("ID_SanPham"));
            spct.setID_MauSac(rs.getString("ID_MauSac"));
            spct.setID_ChatLieu(rs.getString("ID_ChatLieu"));
            spct.setID_KichThuoc(rs.getString("ID_KichThuoc"));
            spct.setID_ThuongHieu(rs.getString("ID_ThuongHieu"));
            spct.setSoLuong(rs.getInt("SoLuong"));
            spct.setGia(rs.getInt("Gia"));
            spct.setTrangThai(rs.getBoolean("Trangthai"));
            spct.setGhiChu(rs.getString("GhiChu"));

            arrSPCT.add(spct);
        }
        return arrSPCT;
    }

    public void themSPCT(SanPhamChiTiet11 spct) throws SQLException {
        String sql = "INSERT INTO SanPhamChiTiet (ID_SanPham, ID_MauSac, ID_ChatLieu, ID_KichThuoc, ID_ThuongHieu, Gia, SoLuong, TrangThai, GhiChu) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, spct.getID_SanPham());
            stmt.setInt(2, Integer.valueOf(spct.getID_MauSac()));
            stmt.setInt(3, Integer.valueOf(spct.getID_ChatLieu()));
            stmt.setInt(4, Integer.valueOf(spct.getID_KichThuoc()));
            stmt.setInt(5, Integer.valueOf(spct.getID_ThuongHieu()));
            stmt.setInt(6, spct.getGia());
            stmt.setInt(7, spct.getSoLuong());
            stmt.setBoolean(8, spct.isTrangThai());
            stmt.setString(9, spct.getGhiChu());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public ArrayList<MauSac1> getMauSac() throws SQLException {
        ArrayList<MauSac1> arrMauSac = new ArrayList<>();
        String query = "SELECT * FROM MauSac";

        try (Connection conn = DBConnect.getConnection(); PreparedStatement stm = conn.prepareStatement(query); ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                MauSac1 mausac = new MauSac1();
                mausac.setID_MauSac(rs.getInt("ID_MauSac"));
                mausac.setTenMauSac(rs.getString("TenMauSac"));
                arrMauSac.add(mausac);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return arrMauSac;
    }

    public ArrayList<ChatLieu1> getChatLieu() throws SQLException {
        ArrayList<ChatLieu1> arrChatLieu = new ArrayList<>();
        String query = "SELECT * FROM ChatLieu";
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            ChatLieu1 chatlieu = new ChatLieu1();
            chatlieu.setID_ChatLieu(rs.getInt("ID_ChatLieu"));
            chatlieu.setTenChatLieu(rs.getString("TenChatLieu"));
            arrChatLieu.add(chatlieu);
        }
        return arrChatLieu;

    }

    public ArrayList<KichThuoc1> getKichThuoc() throws SQLException {
        ArrayList<KichThuoc1> arrKichThuoc = new ArrayList<>();
        String query = "SELECT * FROM KichThuoc";
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            KichThuoc1 kichthuoc = new KichThuoc1();
            kichthuoc.setID_KichThuoc(rs.getInt("ID_KichThuoc"));
            kichthuoc.setTenKichThuoc(rs.getString("TenKichThuoc"));
            arrKichThuoc.add(kichthuoc);
        }
        return arrKichThuoc;

    }

    public ArrayList<ThuongHieu1> getThuongHieu() throws SQLException {
        ArrayList<ThuongHieu1> arrThuongHieu = new ArrayList<>();
        String query = "SELECT * FROM ThuongHieu";
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            ThuongHieu1 thuongHieu = new ThuongHieu1();
            thuongHieu.setID_ThuongHieu(rs.getInt("ID_ThuongHieu"));
            thuongHieu.setTenThuongHieu(rs.getString("TenThuongHieu"));
            arrThuongHieu.add(thuongHieu);
        }
        return arrThuongHieu;

    }

    public void suaSPCT(SanPhamChiTiet11 spct) throws SQLException {
        String sql = "UPDATE SanPhamChiTiet SET ID_SanPham = ?, ID_MauSac = ?, ID_ChatLieu = ?, ID_KichThuoc = ?, ID_ThuongHieu = ?, Gia = ?, SoLuong = ?, TrangThai = ?, GhiChu = ? WHERE ID_SanPhamChiTiet = ?";

        try (Connection conn = DBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, spct.getID_SanPham());
            stmt.setInt(2, Integer.valueOf(spct.getID_MauSac()));
            stmt.setInt(3, Integer.valueOf(spct.getID_ChatLieu()));
            stmt.setInt(4, Integer.valueOf(spct.getID_KichThuoc()));
            stmt.setInt(5, Integer.valueOf(spct.getID_ThuongHieu()));
            stmt.setInt(6, spct.getGia());
            stmt.setInt(7, spct.getSoLuong());
            stmt.setBoolean(8, spct.isTrangThai());
            stmt.setString(9, spct.getGhiChu());
            stmt.setInt(10, spct.getID_SPCT());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void xoaSPCT(int idSPCT) throws SQLException {
        String sql = "DELETE FROM SanPhamChiTiet WHERE ID_SanPhamChiTiet = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idSPCT);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
