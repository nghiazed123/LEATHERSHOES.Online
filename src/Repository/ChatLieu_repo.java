/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.ChatLieu;
import dangnhap.DBConnect;
import dangnhap.DBConnect;
import Model.ChatLieu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Reponse.HoaDonChiTiet_RePones;

/**
 *
 * @author ASUS
 */
public class ChatLieu_repo {
    public ArrayList<ChatLieu> getChatLieu(){
        ArrayList<ChatLieu> newlist = new ArrayList<>();
        String sql = """
                    SELECT [ID_ChatLieu]
                              ,[TenChatLieu]
                          FROM [dbo].[ChatLieu]
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                int IDchatLieu = rs.getInt(1);
                String tenChatLieu = rs.getString(2);
                ChatLieu newCL = new ChatLieu(IDchatLieu, tenChatLieu);
                newlist.add(newCL);
            }
        } catch (Exception e) {
        }
        return newlist;
    }
    public ArrayList<ChatLieu> getChatLieubiID(String tenChatLieucantim){
        ArrayList<ChatLieu> newlist = new ArrayList<>();
        String sql = """
                    SELECT [ID_ChatLieu]
                              ,[TenChatLieu]
                          FROM [dbo].[ChatLieu]
                     where TenChatLieu like ?
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setObject(1, tenChatLieucantim);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                int IDchatLieu = rs.getInt(1);
                String tenChatLieu = rs.getString(2);
                ChatLieu newCL = new ChatLieu(IDchatLieu, tenChatLieu);
                newlist.add(newCL);
            }
        } catch (Exception e) {
        }
        return newlist;
    }
}
