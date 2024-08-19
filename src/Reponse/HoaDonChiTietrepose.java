/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author nguyensyan
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter 
@Setter 
@ToString
@Builder
public class HoaDonChiTietrepose {
    
    private Integer ID_HoaDonChiTiet;
    private Integer ID_SanPham;
    private String TenSP;
    private Integer Soluong;
    private Integer Gia;
    private Integer Thanhtien;
    private String TenKichThuoc;
    private String TenChatLieu;
    private String TenThuongHieu;
    private String TenMauSac;
    private Integer hoaDonID;
    private Integer ctspID;
}
