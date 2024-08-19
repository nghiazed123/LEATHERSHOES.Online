/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Nguyen Vinh Thang
 */
public class ChatLieu1 {
    private int ID_ChatLieu;
    private String TenChatLieu;
    private boolean TrangThaiChatLieu;

    public ChatLieu1() {
    }

    public ChatLieu1(int ID_ChatLieu, String TenChatLieu, boolean TrangThaiChatLieu) {
        this.ID_ChatLieu = ID_ChatLieu;
        this.TenChatLieu = TenChatLieu;
        this.TrangThaiChatLieu = TrangThaiChatLieu;
    }

    public int getID_ChatLieu() {
        return ID_ChatLieu;
    }

    public void setID_ChatLieu(int ID_ChatLieu) {
        this.ID_ChatLieu = ID_ChatLieu;
    }

    public String getTenChatLieu() {
        return TenChatLieu;
    }

    public void setTenChatLieu(String TenChatLieu) {
        this.TenChatLieu = TenChatLieu;
    }

    public boolean isTrangThaiChatLieu() {
        return TrangThaiChatLieu;
    }

    public void setTrangThaiChatLieu(boolean TrangThaiChatLieu) {
        this.TrangThaiChatLieu = TrangThaiChatLieu;
    }

    
    
    @Override
    public String toString() {
        return TenChatLieu;
    }
}
