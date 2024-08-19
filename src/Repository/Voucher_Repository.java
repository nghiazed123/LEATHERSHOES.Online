/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.Voucher;
import dangnhap.DBConnect;
import Repository.Voucher_Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Voucher_Repository {

    public ArrayList<Voucher> getlist() {
        ArrayList<Voucher> list = new ArrayList<>();
        String sql = """
                    select Id_Vocher , TenVocher  , PhanTramGiam , Ngaybd, ngaykt from Vocher 
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idVoucher = rs.getInt(1);
                String tenVoucher = rs.getString(2);
                int phanTramGiam = rs.getInt(3);
                String ngayBD = rs.getString(4);
                String ngayKT = rs.getString(5);
                Voucher newVC = new Voucher(idVoucher, tenVoucher, phanTramGiam, ngayBD, ngayKT);
                list.add(newVC);
            }
        } catch (Exception e) {
            return null;
        }
        return list;
    }

    public ArrayList<Voucher> getVoucherByName(String tenVouCher) {
         ArrayList<Voucher> list = new ArrayList<>();
        String sql = """
                    select Id_Vocher , TenVocher  , PhanTramGiam , Ngaybd, ngaykt from Vocher where TenVocher like ?
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, tenVouCher);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idVoucher = rs.getInt(1);
                String tenVoucher = rs.getString(2);
                int phanTramGiam = rs.getInt(3);
                String ngayBD = rs.getString(4);
                String ngayKT = rs.getString(5);
                Voucher newVC = new Voucher(idVoucher, tenVoucher, phanTramGiam, ngayBD, ngayKT);
                list.add(newVC);
                
            }
        } catch (Exception e) {
            return null;
        }
        return list;
    }
    public  ArrayList<Voucher> getVoucherbyid(int idVoucher){
       ArrayList<Voucher> list = new ArrayList<>();
        String sql ="""
                    select Id_Vocher , TenVocher,PhanTramGiam,Ngaybd,ngaykt from Vocher where Id_Vocher  = ?
                    """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            Voucher newVC = new Voucher();
            ps.setObject(1, idVoucher);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
            newVC.setIdVoucher(rs.getInt(1));
            newVC.setTen(rs.getString(2));
            newVC.setPhanTramGiam(rs.getInt(3));
            newVC.setNgayBatDau(rs.getString(4));
            newVC.setNgayKetThuc(rs.getString(5));
            list.add(newVC);
            return list;
            }
        } catch (Exception e) {
        }
        return null;
    }
}
