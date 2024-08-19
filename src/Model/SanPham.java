package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nguyen Vinh Thang
 */
public class SanPham {
    private int ID_SanPham;
    private String TenSP;
    private int Gia;
    private String ID_LoaiSP;
    private boolean TrangThai;

    public SanPham() {
    }

    public SanPham(int ID_SanPham, String TenSP, int Gia, String ID_LoaiSP, boolean TrangThai) {
        this.ID_SanPham = ID_SanPham;
        this.TenSP = TenSP;
        this.Gia = Gia;
        this.ID_LoaiSP = ID_LoaiSP;
        this.TrangThai = TrangThai;
    }

    public int getID_SanPham() {
        return ID_SanPham;
    }

    public void setID_SanPham(int ID_SanPham) {
        this.ID_SanPham = ID_SanPham;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }

    public String getID_LoaiSP() {
        return ID_LoaiSP;
    }

    public void setID_LoaiSP(String ID_LoaiSP) {
        this.ID_LoaiSP = ID_LoaiSP;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    
}
