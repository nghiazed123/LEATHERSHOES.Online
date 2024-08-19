/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponse;

/**
 *
 * @author ASUS
 */
public class HoaDonChiTiet_RePones {
    private int IDSanPhamChiTiet;
    private String tensp;
    private int donGia;
    private int soLuong;

    public HoaDonChiTiet_RePones() {
    }

    public HoaDonChiTiet_RePones(int IDSanPhamChiTiet, String tensp, int donGia, int soLuong) {
        this.IDSanPhamChiTiet = IDSanPhamChiTiet;
        this.tensp = tensp;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public int getIDSanPhamChiTiet() {
        return IDSanPhamChiTiet;
    }

    public void setIDSanPhamChiTiet(int IDSanPhamChiTiet) {
        this.IDSanPhamChiTiet = IDSanPhamChiTiet;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
}
