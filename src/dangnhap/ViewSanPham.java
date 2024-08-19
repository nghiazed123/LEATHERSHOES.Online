/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package dangnhap;

import Model.ChatLieu1;
import Model.KichThuoc1;
import Model.LoaiSanPham;
import Model.MauSac1;
import Model.SanPham;
import Model.SanPhamChiTiet11;
import Model.ThuongHieu1;
import Repository.SanPhamChiTietRepository;
import Repository.SanPhamRepository;
import java.awt.HeadlessException;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
/**
 *
 * @author Nguyen Vinh Thang
 */
public class ViewSanPham extends javax.swing.JPanel {

     //Biến cục bộ (global)
    private SanPhamRepository spRepo;
    private SanPhamChiTietRepository spctRepo;
    private ArrayList<SanPham> arrSP = new ArrayList<>();
    private ArrayList<SanPhamChiTiet11> arrSPCT = new ArrayList<>();

    private ArrayList<LoaiSanPham> arrLoaiSP;
    private ArrayList<MauSac1> arrMauSac;
    private ArrayList<ChatLieu1> arrChatLieu;
    private ArrayList<KichThuoc1> arrKichThuoc;
    private ArrayList<ThuongHieu1> arrThuongHieu;
    
    public ViewSanPham() throws SQLException {
        initComponents();
        //Code
        this.getDataSanPham(); //lấy dữ liệu Sản Phẩm
        this.loadLoaiSanPham();
        this.loadChatLieu();
        this.loadKichThuoc();
        this.loadMauSac();
        this.loadThuongHieu();
        this.filltoTableSP();  //load bảng Sản Phẩm
        this.getDataSPCT();    //lấy dữ liệu Sản Phẩm Chi Tiết
        this.loadLoaiSPtoComboBox();
        this.loadMauSactoComboBox();
        this.loadChatLieutoComboBox();
        this.loadKichThuoctoComboBox();
        this.loadThuongHieutoCombobox();
        this.filltoTableSPCT();//load bảng Sản Phẩm Chi Tiết
    }

    //Lấy dữ liệu Sản Phẩm
    public void getDataSanPham() throws SQLException {
        spRepo = new SanPhamRepository();
        arrSP = spRepo.getData();
    }

    private String getTenLoaiByID(String idLoaiSP) {
        for (LoaiSanPham loaiSP : arrLoaiSP) {
            if (loaiSP.getID_LoaiSP().equals(idLoaiSP)) {
                return loaiSP.getTenLoai();
            }
        }
        return null; // Trường hợp không tìm thấy loại sản phẩm
    }

    private String getMauSacByID(String idMauSac) {
        int idms = Integer.parseInt(idMauSac);
        for (MauSac1 mauSac : arrMauSac) {
            if (mauSac.getID_MauSac() == idms) {
                return mauSac.getTenMauSac();
            }
        }
        return null;
    }

    private String getChatLieuByID(String idChatLieu) {
        int idcl = Integer.parseInt(idChatLieu);
        for (ChatLieu1 chatLieu : arrChatLieu) {
            if (chatLieu.getID_ChatLieu() == idcl) {
                return chatLieu.getTenChatLieu();
            }
        }
        return null;
    }

    private String getKichThuocByID(String idKichThuoc) {
        int idkt = Integer.parseInt(idKichThuoc);
        for (KichThuoc1 kichThuoc : arrKichThuoc) {
            if (kichThuoc.getID_KichThuoc() == idkt) {
                return kichThuoc.getTenKichThuoc();
            }
        }
        return null;
    }

    private String getThuongHieuByID(String idThuongHieu) {
        int idth = Integer.parseInt(idThuongHieu);
        for (ThuongHieu1 thuongHieu : arrThuongHieu) {
            if (thuongHieu.getID_ThuongHieu() == idth) {
                return thuongHieu.getTenThuongHieu();
            }
        }
        return null;
    }

    //Load dữ liệu lên bảng Sản Phẩm
    public void filltoTableSP() {
        DefaultTableModel model = (DefaultTableModel) tblTableSP.getModel();
        model.setNumRows(0);
        for (SanPham sp : arrSP) {
            String tenLoaiSP = getTenLoaiByID(sp.getID_LoaiSP());  //Lấy TenLoai từ ID_LoaiSP
            Object[] row = {sp.getID_SanPham(), sp.getTenSP(), sp.getGia(),
                tenLoaiSP, sp.isTrangThai() ? "Còn Hàng" : "Hết Hàng"};
            model.addRow(row);
        }
    }

    //THêm dữ liệu vào ComboBox Loai San Pham
    public void loadLoaiSPtoComboBox() throws SQLException {
        SanPhamRepository spRepo = new SanPhamRepository();
        arrLoaiSP = spRepo.getLoaiSanPham();
        cbbLoaiSp.removeAllItems(); //luu y
        cbbLoaiSp.addItem("Chọn loại sản phẩm");
        for (LoaiSanPham loaiSp : arrLoaiSP) {
            cbbLoaiSp.addItem(loaiSp.getTenLoai());
        }
    }

    private void loadLoaiSanPham() throws SQLException {
        spRepo = new SanPhamRepository();
        arrLoaiSP = spRepo.getLoaiSanPham();
    }

    private void loadMauSac() throws SQLException {
        spctRepo = new SanPhamChiTietRepository();
        arrMauSac = spctRepo.getMauSac();
    }

    private void loadChatLieu() throws SQLException {
        spctRepo = new SanPhamChiTietRepository();
        arrChatLieu = spctRepo.getChatLieu();
    }

    private void loadKichThuoc() throws SQLException {
        spctRepo = new SanPhamChiTietRepository();
        arrKichThuoc = spctRepo.getKichThuoc();
    }

    private void loadThuongHieu() throws SQLException {
        spctRepo = new SanPhamChiTietRepository();
        arrThuongHieu = spctRepo.getThuongHieu();
    }

    public void loadMauSactoComboBox() throws SQLException {
        SanPhamChiTietRepository spctRepo = new SanPhamChiTietRepository();
        ArrayList<MauSac1> arrMauSac = spctRepo.getMauSac();
        cbbMauSac.removeAllItems();
        cbbMauSac.addItem("Chọn màu sắc");
        for (MauSac1 mausac : arrMauSac) {
            cbbMauSac.addItem(mausac.getTenMauSac());
        }
    }

    public void loadKichThuoctoComboBox() throws SQLException {
        SanPhamChiTietRepository spctRepo = new SanPhamChiTietRepository();
        ArrayList<KichThuoc1> arrKichThuoc = spctRepo.getKichThuoc();
        cbbKichThuoc.removeAllItems();
        cbbKichThuoc.addItem("Chọn kích thước");
        for (KichThuoc1 kichThuoc : arrKichThuoc) {
            cbbKichThuoc.addItem(kichThuoc.getTenKichThuoc());
        }
    }

    public void loadChatLieutoComboBox() throws SQLException {
        SanPhamChiTietRepository spctRepo = new SanPhamChiTietRepository();
        ArrayList<ChatLieu1> arrChatLieu = spctRepo.getChatLieu();
        cbbChatLieu.removeAllItems();
        cbbChatLieu.addItem("Chọn chất liệu");
        for (ChatLieu1 chatLieu : arrChatLieu) {
            cbbChatLieu.addItem(chatLieu.getTenChatLieu());
        }
    }

    public void loadThuongHieutoCombobox() throws SQLException {
        SanPhamChiTietRepository spctRepo = new SanPhamChiTietRepository();
        ArrayList<ThuongHieu1> arrThuongHieu = spctRepo.getThuongHieu();
        cbbThuongHieu.removeAllItems();
        cbbThuongHieu.addItem("Chọn thương hiệu");
        for (ThuongHieu1 thuongHieu : arrThuongHieu) {
            cbbThuongHieu.addItem(thuongHieu.getTenThuongHieu());
        }
    }

    //Click CHuột table Sản Phẩm
    public void clickchuotSP(int index) {
        // Kiểm tra index có nằm trong phạm vi hợp lệ không
        if (index >= 0 && index < arrSP.size()) {
            SanPham sp = arrSP.get(index);

            // Tìm loaiSP tương ứng với ID trong sp
            LoaiSanPham loaiSP = arrLoaiSP.stream()
                    .filter(l -> l.getID_LoaiSP().equals(sp.getID_LoaiSP()))
                    .findFirst()
                    .orElse(null);

            if (loaiSP != null) {
                txtIDSanPham.setText(Integer.toString(sp.getID_SanPham()));
                txtTenSP.setText(sp.getTenSP().trim());
                txtGiaSP.setText(Integer.toString(sp.getGia()).trim());
                cbbLoaiSp.setSelectedItem(loaiSP.getTenLoai());

                if (sp.isTrangThai()) {
                    rdoConHang.setSelected(true);
                    rdoHetHang.setSelected(false);
                } else {
                    rdoConHang.setSelected(false);
                    rdoHetHang.setSelected(true);
                }
            }
        }
    }

    //check trùng ID Sản Phẩm
    public boolean checkIDSP(String str) {
        for (SanPham sp : arrSP) {
            if (str.equalsIgnoreCase(Integer.toString(sp.getID_SanPham()))) {
                JOptionPane.showMessageDialog(this, "ID Sản Phẩm này đã tồn tại");
                return false;
            }
        }
        return true;
    }

    // Button Thêm của Sản Phẩm
    public void themSP() throws SQLException {
        try {
            // Tạo đối tượng SanPham mới
            SanPham sp = new SanPham();

            // Kiểm tra các trường có trống không
            if (txtIDSanPham.getText().trim().equals("")
                    || txtTenSP.getText().trim().equals("")
                    || txtGiaSP.getText().trim().equals("")
                    || cbbLoaiSp.getSelectedIndex() == 0 // Kiểm tra loại sản phẩm được chọn
                    || buttonGroup1.getSelection() == null) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
            } else {
                // Kiểm tra ID sản phẩm có hợp lệ không
                if (checkIDSP(txtIDSanPham.getText())) {
                    // Thiết lập giá trị cho đối tượng SanPham

                    sp.setTenSP(txtTenSP.getText().trim());

                    try {
                        // Kiểm tra giá trị giá sản phẩm
                        int gia = Integer.parseInt(txtGiaSP.getText().trim());
                        if (gia < 0) {
                            JOptionPane.showMessageDialog(this, "Giá bán không hợp lệ");
                            return;
                        }
                        sp.setGia(gia);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Giá sản phẩm phải là số nguyên dương");
                        return;
                    }

                    // Lấy ID_LoaiSP từ ComboBox
                    String loaiSP = (String) cbbLoaiSp.getSelectedItem();
                    String idLoaiSP = getIDLoaiSPByTen(loaiSP); // Phương thức để lấy ID_LoaiSP từ tên loại
                    if (idLoaiSP != null) {
                        sp.setID_LoaiSP(idLoaiSP);
                    } else {
                        JOptionPane.showMessageDialog(this, "Loại sản phẩm không hợp lệ");
                        return;
                    }

                    // Thiết lập trạng thái sản phẩm từ RadioButton
                    boolean trangThai = rdoConHang.isSelected();
                    sp.setTrangThai(trangThai);

                    // Thêm sản phẩm vào cơ sở dữ liệu
                    SanPhamRepository repo = new SanPhamRepository();
                    repo.themSP(sp);
                    JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");

                    // Xóa dữ liệu text field sau khi thêm sản phẩm
                    this.arrSP.clear();
                    this.getDataSanPham();
                    this.filltoTableSP();

                    // Xóa dữ liệu trong các trường nhập liệu
                    txtIDSanPham.setText("");
                    txtTenSP.setText("");
                    txtGiaSP.setText("");
                    cbbLoaiSp.setSelectedIndex(0);
                    buttonGroup1.clearSelection();

                }
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Nhập sai kiểu dữ liệu hoặc lỗi cơ sở dữ liệu!");
            e.printStackTrace();
        }
    }

    public void themSPCT() {
        try {
            SanPhamChiTiet11 spct = new SanPhamChiTiet11();

            // Kiểm tra các trường nhập liệu
            if (cbbMauSac.getSelectedIndex() == 0
                    || cbbChatLieu.getSelectedIndex() == 0
                    || cbbKichThuoc.getSelectedIndex() == 0
                    || cbbThuongHieu.getSelectedIndex() == 0
                    || txtGiaSPCT.getText().trim().equals("")
                    || buttonGroup2.getSelection() == null
                    || txtSoLuong.getText().trim().equals("")
                    || txtGhiChuSPCT.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
                return;
            }

            // Lấy giá trị từ các trường nhập liệu
            spct.setID_SanPham(txtIDSP.getText().trim());
            String selectedMauSac = (String) cbbMauSac.getSelectedItem();
            int idMauSac = mapMauSacID(selectedMauSac); // Hàm này ánh xạ tên màu thành ID         
            spct.setID_MauSac(String.valueOf(idMauSac));
            String selectedChatLieu = (String) cbbChatLieu.getSelectedItem();
            int idChatLieu = mapChatLieuID(selectedChatLieu);
            spct.setID_ChatLieu(String.valueOf(idChatLieu));
            String selectedKichThuoc = (String) cbbKichThuoc.getSelectedItem();
            int idKichThuoc = mapKichThuocID(selectedKichThuoc);
            spct.setID_KichThuoc(String.valueOf(idKichThuoc));
            String selectedThuongHieu = (String) cbbThuongHieu.getSelectedItem();
            int idThuongHieu = mapThuongHieuID(selectedThuongHieu);
            spct.setID_ThuongHieu(String.valueOf(idThuongHieu));

            // Kiểm tra giá trị giá sản phẩm và số lượng
            try {
                int gia = Integer.parseInt(txtGiaSPCT.getText().trim());
                int soLuong = Integer.parseInt(txtSoLuong.getText().trim());
                if (gia < 0) {
                    JOptionPane.showMessageDialog(this, "Giá bán không hợp lệ");
                    return;
                }
                if (soLuong < 0) {
                    JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ");
                    return;
                }
                spct.setGia(gia);
                spct.setSoLuong(soLuong);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Giá sản phẩm và số lượng phải là số nguyên dương");
                return;
            }

            // Thiết lập trạng thái sản phẩm từ RadioButton
            boolean trangThai = rdoConHang1.isSelected();
            spct.setTrangThai(trangThai);
            spct.setGhiChu(txtGhiChuSPCT.getText().trim());

            // Thêm sản phẩm chi tiết
            SanPhamChiTietRepository repo = new SanPhamChiTietRepository();
            repo.themSPCT(spct);
            JOptionPane.showMessageDialog(this, "Thêm sản phẩm chi tiết thành công");

            // Cập nhật lại danh sách sản phẩm chi tiết
            this.arrSPCT.clear();
            this.getDataSPCT();
            this.filltoTableSPCT();

            // Xóa dữ liệu trong các trường nhập liệu
            txtIDSPCT.setText("");
            txtIDSP.setText("");
            txtSoLuong.setText("");
            txtGiaSPCT.setText("");
            cbbMauSac.setSelectedIndex(0);
            cbbChatLieu.setSelectedIndex(0);
            cbbKichThuoc.setSelectedIndex(0);
            cbbThuongHieu.setSelectedIndex(0);
            buttonGroup2.clearSelection();
            updateComboBoxes();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nhập sai kiểu dữ liệu hoặc lỗi cơ sở dữ liệu!");
            e.printStackTrace();
        }
    }

    private int mapMauSacID(String colorName) {
        switch (colorName) {
            case "Black":
                return 1;
            case "Blued":
                return 2;
            case "Grey":
                return 3;
            case "Whilte":
                return 4;
            case "Smoke Gray":
                return 5;
            default:
                throw new IllegalArgumentException("Unknown color: " + colorName);
        }
    }

    private int mapChatLieuID(String chatlieu) {
        switch (chatlieu) {
            case "Grain Leather":
                return 1;
            case "Patent Leather":
                return 2;
            case "Paten Leather":
                return 3;
            case "Nubuck Leather":
                return 4;
            case "Cordovan Leather":
                return 5;
            default:
                throw new IllegalArgumentException("Unknown leather: " + chatlieu);
        }
    }

    private int mapKichThuocID(String kichthuoc) {
        switch (kichthuoc) {
            case "SIZE 39":
                return 1;
            case "SIZE 41":
                return 2;
            case "SIZE 38":
                return 3;
            case "SIZE 37":
                return 4;
            case "SIZE 43":
                return 5;
            default:
                throw new IllegalArgumentException("Unknown lenght: " + kichthuoc);
        }
    }

    private int mapThuongHieuID(String thuonghieu) {
        switch (thuonghieu) {
            case "BITIS":
                return 1;
            case "Laforces":
                return 2;
            case "Tâm An":
                return 3;
            case "Gucci":
                return 4;
            case "Adidas":
                return 5;
            default:
                throw new IllegalArgumentException("Unknown brand: " + thuonghieu);
        }
    }

    private void updateComboBoxes() {
        // Ví dụ về cách thêm các giá trị mới vào JComboBo
        cbbMauSac.addItem("Màu mới");
        cbbChatLieu.addItem("Chất liệu mới");
        cbbKichThuoc.addItem("Kích thước mới");
        cbbThuongHieu.addItem("Thương hiệu mới");

        // Thiết lập lại giá trị mặc định (nếu cần)
        cbbMauSac.setSelectedIndex(0);
        cbbChatLieu.setSelectedIndex(0);
        cbbKichThuoc.setSelectedIndex(0);
        cbbThuongHieu.setSelectedIndex(0);
    }

    //Button Sửa của Sản Phẩm
    public void suaSP() {
        int index = tblTableSP.getSelectedRow();
        if (index != -1) {
            SanPham sp = arrSP.get(index);
            //Ktra trống
            if (txtIDSanPham.getText().trim().equals("")
                    || txtTenSP.getText().trim().equals("")
                    || txtGiaSP.getText().trim().equals("")
                    || cbbLoaiSp.getSelectedIndex() == 0
                    || buttonGroup1.getSelection() == null) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
            } else {
                sp.setID_SanPham(Integer.parseInt(txtIDSanPham.getText().trim()));
                sp.setTenSP(txtTenSP.getText().trim());
                try {
                    int gia = Integer.parseInt(txtGiaSP.getText().trim());
                    if (gia <= 0) {
                        JOptionPane.showMessageDialog(this, "Giá bán không hợp lệ");
                        return;
                    }
                    sp.setGia(gia);
                } catch (HeadlessException | NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Giá bán phải là số nguyên dương");
                    return;
                }
                String loaiSP = (String) cbbLoaiSp.getSelectedItem();
                String idLoaiSP = getIDLoaiSPByTen(loaiSP);
                if (idLoaiSP != null) {
                    sp.setID_LoaiSP(idLoaiSP);
                } else {
                    JOptionPane.showMessageDialog(this, "Loại Sản Phẩm không hợp lệ");
                    return;
                }
                boolean tt = rdoConHang.isSelected();
                sp.setTrangThai(tt);
                try {
                    SanPhamRepository spRepo = new SanPhamRepository();
                    spRepo.suaSP(sp);
                    JOptionPane.showMessageDialog(this, "Sửa sản phẩm thành công");
                    //Xoá dữ liệu sau khi cập nhập và up lại lên table 
                    this.arrSP.clear();
                    this.getDataSanPham();
                    this.filltoTableSP();
                    txtIDSanPham.setText("");
                    txtTenSP.setText("");
                    txtGiaSP.setText("");
                    cbbLoaiSp.setSelectedIndex(0);
                    buttonGroup1.clearSelection();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Lỗi cơ sở dữ liệu");
                    e.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần sửa");
        }
    }

    public void suaSPCT() {
        try {
            SanPhamChiTiet11 spct = new SanPhamChiTiet11();

            // Kiểm tra các trường nhập liệu
            if (txtIDSPCT.getText().trim().equals("")
                    || cbbMauSac.getSelectedIndex() == 0
                    || cbbChatLieu.getSelectedIndex() == 0
                    || cbbKichThuoc.getSelectedIndex() == 0
                    || cbbThuongHieu.getSelectedIndex() == 0
                    || txtGiaSPCT.getText().trim().equals("")
                    || buttonGroup2.getSelection() == null
                    || txtSoLuong.getText().trim().equals("")
                    || txtGhiChuSPCT.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
                return;
            }

            // Lấy giá trị từ các trường nhập liệu
            int idSPCT;
            try {
                idSPCT = Integer.parseInt(txtIDSPCT.getText().trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "ID Sản phẩm chi tiết không hợp lệ");
                return;
            }
            spct.setID_SPCT(idSPCT);

            spct.setID_SanPham(txtIDSP.getText().trim());
            String selectedMauSac = (String) cbbMauSac.getSelectedItem();
            int idMauSac = mapMauSacID(selectedMauSac);
            spct.setID_MauSac(String.valueOf(idMauSac));
            String selectedChatLieu = (String) cbbChatLieu.getSelectedItem();
            int idChatLieu = mapChatLieuID(selectedChatLieu);
            spct.setID_ChatLieu(String.valueOf(idChatLieu));
            String selectedKichThuoc = (String) cbbKichThuoc.getSelectedItem();
            int idKichThuoc = mapKichThuocID(selectedKichThuoc);
            spct.setID_KichThuoc(String.valueOf(idKichThuoc));
            String selectedThuongHieu = (String) cbbThuongHieu.getSelectedItem();
            int idThuongHieu = mapThuongHieuID(selectedThuongHieu);
            spct.setID_ThuongHieu(String.valueOf(idThuongHieu));

            // Kiểm tra giá trị giá sản phẩm và số lượng
            try {
                int gia = Integer.parseInt(txtGiaSPCT.getText().trim());
                int soLuong = Integer.parseInt(txtSoLuong.getText().trim());
                if (gia < 0) {
                    JOptionPane.showMessageDialog(this, "Giá bán không hợp lệ");
                    return;
                }
                if (soLuong < 0) {
                    JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ");
                    return;
                }
                spct.setGia(gia);
                spct.setSoLuong(soLuong);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Giá sản phẩm và số lượng phải là số nguyên dương");
                return;
            }

            // Thiết lập trạng thái sản phẩm từ RadioButton
            boolean trangThai = rdoConHang1.isSelected();
            spct.setTrangThai(trangThai);
            spct.setGhiChu(txtGhiChuSPCT.getText().trim());

            // Cập nhật sản phẩm chi tiết
            SanPhamChiTietRepository repo = new SanPhamChiTietRepository();
            repo.suaSPCT(spct);
            JOptionPane.showMessageDialog(this, "Cập nhật sản phẩm chi tiết thành công");

            // Cập nhật lại danh sách sản phẩm chi tiết
            this.arrSPCT.clear();
            this.getDataSPCT();
            this.filltoTableSPCT();

            // Xóa dữ liệu trong các trường nhập liệu
            txtIDSPCT.setText("");
            txtIDSP.setText("");
            txtSoLuong.setText("");
            txtGiaSPCT.setText("");
            cbbMauSac.setSelectedIndex(0);
            cbbChatLieu.setSelectedIndex(0);
            cbbKichThuoc.setSelectedIndex(0);
            cbbThuongHieu.setSelectedIndex(0);
            buttonGroup2.clearSelection();
            updateComboBoxes();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nhập sai kiểu dữ liệu hoặc lỗi cơ sở dữ liệu!");
            e.printStackTrace();
        }
    }

    //Button Xoá Sản Phẩm
    public void xoaSP() throws SQLException {
        SanPhamRepository spRepo = new SanPhamRepository();
        int index = tblTableSP.getSelectedRow();
        if (index != -1) {
            String idSanPham = tblTableSP.getValueAt(index, 0).toString(); //giá trị cột 0 chứa id
            spRepo.xoaSP(idSanPham);
            //Xoá dữ liệu cũ và up mới lên table
            arrSP.clear();
            this.getDataSanPham();
            this.filltoTableSP();
            JOptionPane.showMessageDialog(this, "Xoá sản phẩm thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần xoá");
        }
    }
    public void xoaSPCT() {
    try {
        // Kiểm tra ID của sản phẩm chi tiết cần xóa
        String idSPCTText = txtIDSPCT.getText().trim();
        if (idSPCTText.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ID Sản phẩm chi tiết để xóa");
            return;
        }

        int idSPCT;
        try {
            idSPCT = Integer.parseInt(idSPCTText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID Sản phẩm chi tiết không hợp lệ");
            return;
        }

        // Xóa sản phẩm chi tiết từ cơ sở dữ liệu
        SanPhamChiTietRepository repo = new SanPhamChiTietRepository();
        repo.xoaSPCT(idSPCT);
        JOptionPane.showMessageDialog(this, "Xóa sản phẩm chi tiết thành công");

        // Cập nhật lại danh sách sản phẩm chi tiết
        this.arrSPCT.clear();
        this.getDataSPCT();
        this.filltoTableSPCT();

        // Xóa dữ liệu trong các trường nhập liệu
        txtIDSPCT.setText("");
        txtIDSP.setText("");
        txtSoLuong.setText("");
        txtGiaSPCT.setText("");
        cbbMauSac.setSelectedIndex(0);
        cbbChatLieu.setSelectedIndex(0);
        cbbKichThuoc.setSelectedIndex(0);
        cbbThuongHieu.setSelectedIndex(0);
        buttonGroup2.clearSelection();
        updateComboBoxes();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Lỗi khi xóa sản phẩm chi tiết!");
        e.printStackTrace();
    }
}

    // Phương thức để lấy ID_LoaiSP từ tên loại
    private String getIDLoaiSPByTen(String tenLoaiSP) {
        for (LoaiSanPham loaiSP : arrLoaiSP) {
            if (loaiSP.getTenLoai().equals(tenLoaiSP)) {
                return loaiSP.getID_LoaiSP();
            }
        }
        return null;
    }

    //Lấy dữ liệu Sản Phẩm Chi Tiết
    public void getDataSPCT() throws SQLException {
        SanPhamChiTietRepository spctRepo = new SanPhamChiTietRepository();
        arrSPCT = spctRepo.getData();
    }

    //Load dữ liệu lên bảng Sản Phẩm Chi Tiết
    public void filltoTableSPCT() {
        DefaultTableModel model = (DefaultTableModel) tbtTableSPCT.getModel();
        model.setNumRows(0);
        for (SanPhamChiTiet11 spct : arrSPCT) {
            String mauSac = getMauSacByID(spct.getID_MauSac());
            String thuongHieu = getThuongHieuByID(spct.getID_ThuongHieu());
            String chatLieu = getChatLieuByID(spct.getID_ChatLieu());
            String kichThuoc = getKichThuocByID(spct.getID_KichThuoc());
            Object[] row = {spct.getID_SPCT(), spct.getID_SanPham(), mauSac,
                chatLieu, kichThuoc, thuongHieu,
                spct.getSoLuong(), spct.getGia(), spct.isTrangThai() ? "Còn Hàng" : "Hết Hàng", spct.getGhiChu()};
            model.addRow(row);
        }
    }

    private void setSelectedComboBoxByID(JComboBox<String> comboBox, int id, List<?> list) {
        for (Object obj : list) {
            if (obj instanceof MauSac1 && ((MauSac1) obj).getID_MauSac() == id) {
                comboBox.setSelectedItem(((MauSac1) obj).getTenMauSac());
                break;
            } else if (obj instanceof ChatLieu1 && ((ChatLieu1) obj).getID_ChatLieu() == id) {
                comboBox.setSelectedItem(((ChatLieu1) obj).getTenChatLieu());
                break;
            } else if (obj instanceof KichThuoc1 && ((KichThuoc1) obj).getID_KichThuoc() == id) {
                comboBox.setSelectedItem(((KichThuoc1) obj).getTenKichThuoc());
                break;
            } else if (obj instanceof ThuongHieu1 && ((ThuongHieu1) obj).getID_ThuongHieu() == id) {
                comboBox.setSelectedItem(((ThuongHieu1) obj).getTenThuongHieu());
                break;
            }
        }
    }

    // Click chuột table Sản Phẩm Chi Tiết
    public void clickchuotSPCT(int index) {
        int selectedRow = tbtTableSPCT.getSelectedRow();
        if (selectedRow >= 0) {
            // Lấy dữ liệu từ bảng
            String idSPCT = tbtTableSPCT.getValueAt(selectedRow, 0).toString();
            String idSP = tbtTableSPCT.getValueAt(selectedRow, 1).toString();
            String mauSac = tbtTableSPCT.getValueAt(selectedRow, 2).toString();
            String chatLieu = tbtTableSPCT.getValueAt(selectedRow, 3).toString();
            String kichThuoc = tbtTableSPCT.getValueAt(selectedRow, 4).toString();
            String thuongHieu = tbtTableSPCT.getValueAt(selectedRow, 5).toString();
            String soLuong = tbtTableSPCT.getValueAt(selectedRow, 6).toString();
            String gia = tbtTableSPCT.getValueAt(selectedRow, 7).toString();
            String trangThai = tbtTableSPCT.getValueAt(selectedRow, 8).toString();
            String ghiChu = tbtTableSPCT.getValueAt(selectedRow, 9).toString();

            // Đặt giá trị cho các thành phần giao diện
            txtIDSPCT.setText(idSPCT);
            txtIDSP.setText(idSP);
            cbbMauSac.setSelectedItem(mauSac);
            cbbChatLieu.setSelectedItem(chatLieu);
            cbbKichThuoc.setSelectedItem(kichThuoc);
            cbbThuongHieu.setSelectedItem(thuongHieu);
            txtSoLuong.setText(soLuong);
            txtGiaSPCT.setText(gia);
            txtGhiChuSPCT.setText(ghiChu);

            // Cập nhật trạng thái của JRadioButton
            if (trangThai.equals("Còn Hàng")) {
                rdoConHang1.setSelected(true);
                rdoHetHang1.setSelected(false);
            } else {
                rdoConHang1.setSelected(false);
                rdoHetHang1.setSelected(true);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        tabSanPham = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIDSanPham = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtGiaSP = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        rdoConHang = new javax.swing.JRadioButton();
        rdoHetHang = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTableSP = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        cbbLoaiSp = new javax.swing.JComboBox<>();
        btnSearchSP = new javax.swing.JButton();
        txtSearchSP = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtTableSPCT = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        txtIDSPCT = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtGiaSPCT = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtGhiChuSPCT = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        rdoConHang1 = new javax.swing.JRadioButton();
        rdoHetHang1 = new javax.swing.JRadioButton();
        btnThem1 = new javax.swing.JButton();
        btnXoa1 = new javax.swing.JButton();
        btnSua1 = new javax.swing.JButton();
        btnReset1 = new javax.swing.JButton();
        txtSoLuong = new javax.swing.JTextField();
        cbbThuongHieu = new javax.swing.JComboBox<>();
        cbbKichThuoc = new javax.swing.JComboBox<>();
        cbbChatLieu = new javax.swing.JComboBox<>();
        cbbMauSac = new javax.swing.JComboBox<>();
        txtIDSP = new javax.swing.JTextField();
        btnSearchSPCT = new javax.swing.JButton();
        txtSearchSPCT = new javax.swing.JTextField();

        tabSanPham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("ID Sản Phẩm :");

        txtIDSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDSanPhamActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Tên Sản Phẩm :");

        txtGiaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaSPActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Giá Sản Phẩm :");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("Loại Sản Phẩm :");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Trạng Thái :");

        rdoConHang.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoConHang);
        rdoConHang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoConHang.setText("Còn Hàng");
        rdoConHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoConHangActionPerformed(evt);
            }
        });

        rdoHetHang.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoHetHang);
        rdoHetHang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoHetHang.setText("Hết Hàng");
        rdoHetHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoHetHangActionPerformed(evt);
            }
        });

        tblTableSP.setBackground(new java.awt.Color(204, 255, 255));
        tblTableSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Sản Phẩm", "Tên Sản Phẩm", "Giá Sản Phẩm", "Loại Sản Phẩm", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTableSP.setGridColor(new java.awt.Color(255, 255, 0));
        tblTableSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTableSPMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTableSP);

        btnThem.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Notes.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Comments.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        cbbLoaiSp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbLoaiSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLoaiSpActionPerformed(evt);
            }
        });

        btnSearchSP.setBackground(new java.awt.Color(204, 255, 255));
        btnSearchSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search.png"))); // NOI18N
        btnSearchSP.setText("Tìm Kiếm");
        btnSearchSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnReset)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cbbLoaiSp, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtGiaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtIDSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(27, 27, 27)
                                        .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(112, 112, 112)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnSearchSP)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtSearchSP, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addGap(18, 18, 18)
                                                .addComponent(rdoConHang)
                                                .addGap(18, 18, 18)
                                                .addComponent(rdoHetHang)))
                                        .addGap(83, 83, 83)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnThem)
                                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(488, 488, 488)
                                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnSearchSP)
                                    .addComponent(txtSearchSP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(rdoConHang, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rdoHetHang, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtIDSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtGiaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cbbLoaiSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(2, 2, 2)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tabSanPham.addTab("Sản Phẩm", jPanel1);

        tbtTableSPCT.setBackground(new java.awt.Color(204, 255, 255));
        tbtTableSPCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Sản Phẩm Chi Tiết", "ID Sản Phẩm", "Màu Sắc", "Chất Liệu", "Kích Thước", "Thương Hiệu", "Số Lượng", "Giá Sản Phẩm", "Trạng Thái", "Ghi Chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbtTableSPCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbtTableSPCTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbtTableSPCT);

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setText("ID Sản Phẩm Chi Tiết :");

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setText("Thương Hiệu :");

        jLabel20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel20.setText("Số Lượng :");

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setText("Giá Sản Phẩm :");

        jLabel22.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel22.setText("Trạng Thái :");

        jLabel23.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel23.setText("ID Sản Phẩm :");

        txtGhiChuSPCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGhiChuSPCTActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel24.setText("Ghi Chú :");

        jLabel25.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel25.setText("Kích Thước :");

        jLabel26.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel26.setText(" Màu Sắc :");

        jLabel27.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel27.setText(" Chất Liệu :");

        buttonGroup2.add(rdoConHang1);
        rdoConHang1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoConHang1.setText("Còn Hàng");

        buttonGroup2.add(rdoHetHang1);
        rdoHetHang1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoHetHang1.setText("Hết Hàng");

        btnThem1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnThem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnThem1.setText("Thêm");
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        btnXoa1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnXoa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btnXoa1.setText("Xoá");
        btnXoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa1ActionPerformed(evt);
            }
        });

        btnSua1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSua1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Notes.png"))); // NOI18N
        btnSua1.setText("Sửa");
        btnSua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua1ActionPerformed(evt);
            }
        });

        btnReset1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnReset1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Comments.png"))); // NOI18N
        btnReset1.setText("Reset");
        btnReset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset1ActionPerformed(evt);
            }
        });

        cbbThuongHieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbKichThuoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSearchSPCT.setBackground(new java.awt.Color(204, 255, 255));
        btnSearchSPCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search.png"))); // NOI18N
        btnSearchSPCT.setText("Tìm Kiếm");
        btnSearchSPCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchSPCTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIDSP, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(29, 29, 29)
                        .addComponent(txtIDSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbThuongHieu, 0, 167, Short.MAX_VALUE)
                            .addComponent(cbbKichThuoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(btnSearchSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearchSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel24))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGiaSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGhiChuSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(rdoConHang1)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoHetHang1)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnThem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSua1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnReset1))
                .addGap(248, 248, 248))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtIDSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearchSPCT)
                            .addComponent(txtSearchSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtIDSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(cbbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(txtGiaSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(cbbKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addComponent(rdoConHang1)
                            .addComponent(rdoHetHang1))
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnThem1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnSua1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnXoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cbbThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(txtGhiChuSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        tabSanPham.addTab("Sản Phẩm Chi Tiết", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabSanPham)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabSanPham)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDSanPhamActionPerformed

    private void txtGiaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaSPActionPerformed

    private void rdoConHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoConHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoConHangActionPerformed

    private void rdoHetHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoHetHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoHetHangActionPerformed

    private void tblTableSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTableSPMouseClicked
        int index = tblTableSP.getSelectedRow();
        this.clickchuotSP(index);
    }//GEN-LAST:event_tblTableSPMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            this.themSP();
        } catch (SQLException ex) {
            Logger.getLogger(ViewSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            this.xoaSP();
        } catch (SQLException ex) {
            Logger.getLogger(ViewSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        this.suaSP();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtIDSanPham.setText("");
        cbbLoaiSp.setSelectedItem("Chọn loại sản phẩm");
        txtGiaSP.setText("");
        txtTenSP.setText("");
        txtSearchSP.setText("");
        buttonGroup1.clearSelection();
        JOptionPane.showMessageDialog(this, "Reset thành công !");
    }//GEN-LAST:event_btnResetActionPerformed

    private void cbbLoaiSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLoaiSpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbLoaiSpActionPerformed

    private void btnSearchSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchSPActionPerformed
        String keyword = txtSearchSP.getText().trim().toLowerCase();

        DefaultTableModel model = (DefaultTableModel) tblTableSP.getModel();
        model.setNumRows(0); // Xóa dữ liệu cũ

        for (SanPham sp : arrSP) {
            String tenLoaiSP = getTenLoaiByID(sp.getID_LoaiSP());

            // Kiểm tra nếu từ khóa xuất hiện trong bất kỳ thuộc tính nào của sản phẩm
            if (Integer.toString(sp.getID_SanPham()).toLowerCase().contains(keyword)
                || sp.getTenSP().toLowerCase().contains(keyword)
                || tenLoaiSP.toLowerCase().contains(keyword)
                || Integer.toString(sp.getGia()).contains(keyword)
                || (sp.isTrangThai() ? "Còn Hàng" : "Hết Hàng").toLowerCase().contains(keyword)) {

                // Nếu từ khóa phù hợp, thêm hàng vào bảng
                Object[] row = {sp.getID_SanPham(), sp.getTenSP(), sp.getGia(),
                    tenLoaiSP, sp.isTrangThai() ? "Còn Hàng" : "Hết Hàng"};
                model.addRow(row);
            }
        }
    }//GEN-LAST:event_btnSearchSPActionPerformed

    private void tbtTableSPCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtTableSPCTMouseClicked
        int index = tbtTableSPCT.getSelectedRow();
        this.clickchuotSPCT(index);
    }//GEN-LAST:event_tbtTableSPCTMouseClicked

    private void txtGhiChuSPCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGhiChuSPCTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGhiChuSPCTActionPerformed

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        this.themSPCT();
    }//GEN-LAST:event_btnThem1ActionPerformed

    private void btnXoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa1ActionPerformed
        this.xoaSPCT();
    }//GEN-LAST:event_btnXoa1ActionPerformed

    private void btnSua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua1ActionPerformed
        this.suaSPCT();
    }//GEN-LAST:event_btnSua1ActionPerformed

    private void btnReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset1ActionPerformed
        txtIDSPCT.setText("");
        txtIDSP.setText("");
        cbbChatLieu.setSelectedItem("Chọn chất liệu");
        cbbMauSac.setSelectedItem("Chọn màu sắc");
        cbbKichThuoc.setSelectedItem("Chọn kích thước");
        cbbThuongHieu.setSelectedItem("Chọn thương hiệu");
        txtSoLuong.setText("");
        txtGiaSPCT.setText("");
        txtGhiChuSPCT.setText("");
        txtSearchSPCT.setText("");
        buttonGroup2.clearSelection();
        JOptionPane.showMessageDialog(this, "Reset thành công");
    }//GEN-LAST:event_btnReset1ActionPerformed

    private void btnSearchSPCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchSPCTActionPerformed

        String keyword = txtSearchSPCT.getText().trim().toLowerCase();

        DefaultTableModel model = (DefaultTableModel) tbtTableSPCT.getModel();
        model.setNumRows(0); // Xóa dữ liệu cũ

        for (SanPhamChiTiet11 spct : arrSPCT) {
            // Kiểm tra nếu từ khóa xuất hiện trong bất kỳ thuộc tính nào của sản phẩm chi tiết
            if (Integer.toString(spct.getID_SPCT()).contains(keyword)
                || spct.getID_SanPham().toLowerCase().contains(keyword)
                || getMauSacByID(spct.getID_MauSac()).toLowerCase().contains(keyword)
                || getChatLieuByID(spct.getID_ChatLieu()).toLowerCase().contains(keyword)
                || getKichThuocByID(spct.getID_KichThuoc()).toLowerCase().contains(keyword)
                || getThuongHieuByID(spct.getID_ThuongHieu()).toLowerCase().contains(keyword)
                || Integer.toString(spct.getSoLuong()).contains(keyword)
                || Integer.toString(spct.getGia()).contains(keyword)
                || spct.getGhiChu().toLowerCase().contains(keyword)) {

                // Nếu từ khóa phù hợp, thêm hàng vào bảng
                String mauSac = getMauSacByID(spct.getID_MauSac());
                String thuongHieu = getThuongHieuByID(spct.getID_ThuongHieu());
                String chatLieu = getChatLieuByID(spct.getID_ChatLieu());
                String kichThuoc = getKichThuocByID(spct.getID_KichThuoc());

                Object[] row = {spct.getID_SPCT(), spct.getID_SanPham(), mauSac,
                    chatLieu, kichThuoc, thuongHieu,
                    spct.getSoLuong(), spct.getGia(), spct.isTrangThai() ? "Còn Hàng" : "Hết Hàng", spct.getGhiChu()};
                model.addRow(row);
            }
        }
    }//GEN-LAST:event_btnSearchSPCTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnReset1;
    private javax.swing.JButton btnSearchSP;
    private javax.swing.JButton btnSearchSPCT;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSua1;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThem1;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoa1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbChatLieu;
    private javax.swing.JComboBox<String> cbbKichThuoc;
    private javax.swing.JComboBox<String> cbbLoaiSp;
    private javax.swing.JComboBox<String> cbbMauSac;
    private javax.swing.JComboBox<String> cbbThuongHieu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdoConHang;
    private javax.swing.JRadioButton rdoConHang1;
    private javax.swing.JRadioButton rdoHetHang;
    private javax.swing.JRadioButton rdoHetHang1;
    private javax.swing.JTabbedPane tabSanPham;
    private javax.swing.JTable tblTableSP;
    private javax.swing.JTable tbtTableSPCT;
    private javax.swing.JTextField txtGhiChuSPCT;
    private javax.swing.JTextField txtGiaSP;
    private javax.swing.JTextField txtGiaSPCT;
    private javax.swing.JTextField txtIDSP;
    private javax.swing.JTextField txtIDSPCT;
    private javax.swing.JTextField txtIDSanPham;
    private javax.swing.JTextField txtSearchSP;
    private javax.swing.JTextField txtSearchSPCT;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables
}
