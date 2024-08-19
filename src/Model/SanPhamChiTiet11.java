/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Nguyen Vinh Thang
 */
public class SanPhamChiTiet11 {
    private int ID_SPCT;
    private String ID_SanPham;
    private String ID_MauSac;
    private String ID_ChatLieu;
    private String ID_KichThuoc;
    private String ID_ThuongHieu;
    private int SoLuong;
    private int Gia;
    private boolean TrangThai;
    private String GhiChu;

    public SanPhamChiTiet11() {
    }

    public SanPhamChiTiet11(int ID_SPCT, String ID_SanPham, String ID_MauSac, String ID_ChatLieu, String ID_KichThuoc, String ID_ThuongHieu, int SoLuong, int Gia, boolean TrangThai, String GhiChu) {
        this.ID_SPCT = ID_SPCT;
        this.ID_SanPham = ID_SanPham;
        this.ID_MauSac = ID_MauSac;
        this.ID_ChatLieu = ID_ChatLieu;
        this.ID_KichThuoc = ID_KichThuoc;
        this.ID_ThuongHieu = ID_ThuongHieu;
        this.SoLuong = SoLuong;
        this.Gia = Gia;
        this.TrangThai = TrangThai;
        this.GhiChu = GhiChu;
    }

    public int getID_SPCT() {
        return ID_SPCT;
    }

    public void setID_SPCT(int ID_SPCT) {
        this.ID_SPCT = ID_SPCT;
    }

    public String getID_SanPham() {
        return ID_SanPham;
    }

    public void setID_SanPham(String ID_SanPham) {
        this.ID_SanPham = ID_SanPham;
    }

    public String getID_MauSac() {
        return ID_MauSac;
    }

    public void setID_MauSac(String ID_MauSac) {
        this.ID_MauSac = ID_MauSac;
    }

    public String getID_ChatLieu() {
        return ID_ChatLieu;
    }

    public void setID_ChatLieu(String ID_ChatLieu) {
        this.ID_ChatLieu = ID_ChatLieu;
    }

    public String getID_KichThuoc() {
        return ID_KichThuoc;
    }

    public void setID_KichThuoc(String ID_KichThuoc) {
        this.ID_KichThuoc = ID_KichThuoc;
    }

    public String getID_ThuongHieu() {
        return ID_ThuongHieu;
    }

    public void setID_ThuongHieu(String ID_ThuongHieu) {
        this.ID_ThuongHieu = ID_ThuongHieu;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    
    
}
