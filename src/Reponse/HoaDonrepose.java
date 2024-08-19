/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponse;
import java.util.Date;
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
public class HoaDonrepose {
   private Integer ID_HoaDon;
   
    private String ID_NhanVien;
    
    private String ID_KhachHang;
    
    private Integer ID_Vocher;
    
    private String TenNV;
    
    private String tenKhachHang;   
    
    private Date Ngaytao;
    
    private boolean Trangthai;
    
    private Integer Thanhtien;
}
