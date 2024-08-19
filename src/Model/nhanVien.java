/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor  // contructor full tham so 
@NoArgsConstructor // contructor k tham so 
@Getter
@Setter
@ToString
@Builder
public class nhanVien {

    private Integer idNhanVien;
    private String tenNhanVien;
    private String diaChi;
    private String email;
    private String sdt;
    private String tenDangNhap;
    private String matKhau;
    private boolean chucVu;
    private String ngayTao;
    private String ngaySua;
    private boolean trangThai;

  
}
