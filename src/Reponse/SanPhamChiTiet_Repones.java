/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponse;

/**
 *
 * @author ASUS
 */
public class SanPhamChiTiet_Repones {
    private int idSanPhamChitiet;
    private String ten;
    private String mauSac;
    private String chatLieu;
    private String kichThuoc;
    private String thuongHieu;
    private int soLuongConLai;
    private int giaTien;

    public SanPhamChiTiet_Repones() {
    }

    public SanPhamChiTiet_Repones(int idSanPhamChitiet, String ten, String mauSac, String chatLieu, String kichThuoc, String thuongHieu, int soLuongConLai, int giaTien) {
        this.idSanPhamChitiet = idSanPhamChitiet;
        this.ten = ten;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
        this.kichThuoc = kichThuoc;
        this.thuongHieu = thuongHieu;
        this.soLuongConLai = soLuongConLai;
        this.giaTien = giaTien;
    }

    public int getIdSanPhamChitiet() {
        return idSanPhamChitiet;
    }

    public void setIdSanPhamChitiet(int idSanPhamChitiet) {
        this.idSanPhamChitiet = idSanPhamChitiet;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public int getSoLuongConLai() {
        return soLuongConLai;
    }

    public void setSoLuongConLai(int soLuongConLai) {
        this.soLuongConLai = soLuongConLai;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }
    
}
