/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.LoaiSanPham;
import dangnhap.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Vinh Thang
 */
public class LoaiSanPhamRepository {
    private Connection conn;
    
    public LoaiSanPhamRepository(){
        conn = DBConnect.getConnection();
    }
    
    
}
