/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Nguyen Vinh Thang
 */
public class ThuongHieu1 {
    private int ID_ThuongHieu;
    private String TenThuongHieu;
    private boolean TrangThaiThuongHieu;

    public ThuongHieu1() {
    }

    public ThuongHieu1(int ID_ThuongHieu, String TenThuongHieu, boolean TrangThaiThuongHieu) {
        this.ID_ThuongHieu = ID_ThuongHieu;
        this.TenThuongHieu = TenThuongHieu;
        this.TrangThaiThuongHieu = TrangThaiThuongHieu;
    }

    public int getID_ThuongHieu() {
        return ID_ThuongHieu;
    }

    public void setID_ThuongHieu(int ID_ThuongHieu) {
        this.ID_ThuongHieu = ID_ThuongHieu;
    }

    public String getTenThuongHieu() {
        return TenThuongHieu;
    }

    public void setTenThuongHieu(String TenThuongHieu) {
        this.TenThuongHieu = TenThuongHieu;
    }

    public boolean isTrangThaiThuongHieu() {
        return TrangThaiThuongHieu;
    }

    public void setTrangThaiThuongHieu(boolean TrangThaiThuongHieu) {
        this.TrangThaiThuongHieu = TrangThaiThuongHieu;
    }

    
    
    @Override
    public String toString() {
        return TenThuongHieu;
    }
}
