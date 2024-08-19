/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Nguyen Vinh Thang
 */
public class MauSac1 {
    private int ID_MauSac;
    private String TenMauSac;
    private boolean TrangThaiMauSac;

    public MauSac1() {
    }

    public MauSac1(int ID_MauSac, String TenMauSac, boolean TrangThaiMauSac) {
        this.ID_MauSac = ID_MauSac;
        this.TenMauSac = TenMauSac;
        this.TrangThaiMauSac = TrangThaiMauSac;
    }

    public int getID_MauSac() {
        return ID_MauSac;
    }

    public void setID_MauSac(int ID_MauSac) {
        this.ID_MauSac = ID_MauSac;
    }

    public String getTenMauSac() {
        return TenMauSac;
    }

    public void setTenMauSac(String TenMauSac) {
        this.TenMauSac = TenMauSac;
    }

    public boolean isTrangThaiMauSac() {
        return TrangThaiMauSac;
    }

    public void setTrangThaiMauSac(boolean TrangThaiMauSac) {
        this.TrangThaiMauSac = TrangThaiMauSac;
    }

    
    
    @Override
    public String toString() {
        return TenMauSac;
    }
}
