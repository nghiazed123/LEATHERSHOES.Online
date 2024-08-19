/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponse;

/**
 *
 * @author ASUS
 */
public class HoaDon_Repones {
    private int idHoaDon;
 
    private  String ngayTao;

    public HoaDon_Repones() {
    }

    public HoaDon_Repones(int idHoaDon, String ngayTao) {
        this.idHoaDon = idHoaDon;
        this.ngayTao = ngayTao;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }
        

}
