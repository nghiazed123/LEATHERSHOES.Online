/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Nguyen Vinh Thang
 */
public class KichThuoc1 {
    private int ID_KichThuoc;
    private String TenKichThuoc;
    private boolean TrangThaiKichThuoc;

    public KichThuoc1() {
    }

    public KichThuoc1(int ID_KichThuoc, String TenKichThuoc, boolean TrangThaiKichThuoc) {
        this.ID_KichThuoc = ID_KichThuoc;
        this.TenKichThuoc = TenKichThuoc;
        this.TrangThaiKichThuoc = TrangThaiKichThuoc;
    }

    public int getID_KichThuoc() {
        return ID_KichThuoc;
    }

    public void setID_KichThuoc(int ID_KichThuoc) {
        this.ID_KichThuoc = ID_KichThuoc;
    }

    public String getTenKichThuoc() {
        return TenKichThuoc;
    }

    public void setTenKichThuoc(String TenKichThuoc) {
        this.TenKichThuoc = TenKichThuoc;
    }

    public boolean isTrangThaiKichThuoc() {
        return TrangThaiKichThuoc;
    }

    public void setTrangThaiKichThuoc(boolean TrangThaiKichThuoc) {
        this.TrangThaiKichThuoc = TrangThaiKichThuoc;
    }

    
    
    @Override
    public String toString() {
        return TenKichThuoc;
    }
}
