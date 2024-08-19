/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package dangnhap;

import Model.nhanVien;
import Repository.nhanVienRepositori;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Admin 
 */
public class viewNhanVien extends javax.swing.JPanel {
  private DefaultTableModel dtm;
    private nhanVienRepositori nvRepo = new nhanVienRepositori();
    ArrayList<nhanVien> v = new ArrayList<>();
    nhanVien n = new nhanVien();
    /**
     * Creates new form viewNhanVien
     */
    public viewNhanVien() {
        initComponents();
        loadData();
    }
     public void loadData() {
        dtm = (DefaultTableModel) tbNhanVien.getModel();
        dtm.setRowCount(0);
        v = nvRepo.getAll(); // Cập nhật danh sách nhân viên từ cơ sở dữ liệu
        for (nhanVien a : v) {
            Object[] n = new Object[11];
            n[0] = a.getIdNhanVien();
            n[1] = a.getTenNhanVien();
            n[2] = a.getDiaChi();
            n[3] = a.getEmail();
            n[4] = a.getSdt();
            n[5] = a.getTenDangNhap();
            n[6] = a.getMatKhau();
            n[7] = a.isChucVu();
            n[8] = a.getNgayTao();
            n[9] = a.getNgaySua();
            n[10] = a.isTrangThai();
            dtm.addRow(n);
        }
        updateMaNhanVienField();
    }
 private void detailNhanVien(int index) {
        nhanVien nv = nvRepo.getAll().get(index);
        txtIDNV.setText(String.valueOf(nv.getIdNhanVien()));
        txtDiaChi.setText(nv.getDiaChi());
        txtName.setText(nv.getTenNhanVien());
        txtSDT.setText(nv.getSdt());
        txtEmail.setText(nv.getEmail());
        txtTenDangNhap.setText(nv.getTenDangNhap());
        txtMatKhau.setText(nv.getMatKhau());
        txtNgayTao.setText(nv.getNgayTao());
        txtNgaySua.setText(nv.getNgaySua());
        boolean chucVu = nv.isChucVu();
        if (chucVu == true) {
            rdoNhanVien.setSelected(true);
        } else {
            rdoThuNgan.setSelected(true);
        }
        boolean trangThai = nv.isTrangThai();
        if (trangThai == true) {
            rdoDangLam.setSelected(true);
        } else {
            rdoDanghiLam.setSelected(true);
        }
    }

//    public nhanVien getFormData() {
//        nhanVien nv = new nhanVien();
//        String ten, diaChi, email, sdt, taiKhoan, matKhau, ngayTao, ngaySua;
//        ten = txtName.getText();
//        diaChi = txtDiaChi.getText();
//        email = txtEmail.getText();
//        sdt = txtSDT.getText();
//        taiKhoan = txtTenDangNhap.getText();
//        matKhau = txtMatKhau.getText();
//        boolean chucVu = rdoNhanVien.isSelected();
//        boolean trangThai = rdoDangLam.isSelected();
//        return nv;
//    }
    public nhanVien getFormData() {
        try {
            nhanVien nv = new nhanVien();
            nv.setIdNhanVien(Integer.parseInt(txtIDNV.getText()));
            nv.setTenNhanVien(txtName.getText());
            nv.setDiaChi(txtDiaChi.getText());
            nv.setEmail(txtEmail.getText());
            nv.setSdt(txtSDT.getText());
            nv.setTenDangNhap(txtTenDangNhap.getText());
            nv.setMatKhau(txtMatKhau.getText());
            String chucVu = "";
            if (rdoNhanVien.isSelected()) {
                chucVu = "Nhân Viên";
            } else if (rdoDanghiLam.isSelected()) {
                chucVu = "Đã Nghỉ Làm";
            }
            nv.setNgayTao(txtNgayTao.getText());
            nv.setNgaySua(txtNgaySua.getText());
            // Đặt giá trị trạng thái dưới dạng boolean
//        boolean trangThai = false;
//        if (txtTrangThai.getText().equalsIgnoreCase("1")) {
//            trangThai = true;
//        }
//        nv.setTrangthai(trangThai);
            return nv;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean checkDuLieu() {
        if (txtName.getText().trim().length() > 255) {
            JOptionPane.showMessageDialog(null, "Tên Nhân Viên không được vượt quá 255 ký tự.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        // Check if the phone number has 10 or 11 digits, starts with 0, and contains only digits
        return (phoneNumber.length() == 10 || phoneNumber.length() == 11) && phoneNumber.startsWith("0") && phoneNumber.matches("\\d+");
    }

    private void updateMaNhanVienField() {
        if (v.size() > 0) {
            int maxMaNV = v.get(v.size() - 1).getIdNhanVien();
            txtIDNV.setText(String.valueOf(maxMaNV + 1));
        } else {
            txtIDNV.setText("1");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtIDNV = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtTenDangNhap = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        txtNgaySua = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        rdoThuNgan = new javax.swing.JRadioButton();
        rdoNhanVien = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        rdoDangLam = new javax.swing.JRadioButton();
        rdoDanghiLam = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNhanVien = new javax.swing.JTable();
        btnReset = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        jLabel1.setText("Quản Lý Nhân Viên");

        jLabel2.setText("Mã Nhân Viên");

        jLabel3.setText("Tên Nhân Viên");

        jLabel4.setText("Tên Đăng Nhập");

        jLabel5.setText("Mật Khẩu");

        jLabel6.setText("Ngày Tạo ");

        jLabel7.setText("Ngày Sửa");

        jLabel8.setText("Địa Chỉ");

        jLabel9.setText("Chức Vụ");

        buttonGroup1.add(rdoThuNgan);
        rdoThuNgan.setText("Thu Ngân");

        buttonGroup1.add(rdoNhanVien);
        rdoNhanVien.setText("Nhân Viên");

        jLabel10.setText("Email");

        jLabel11.setText("Số Điện Thoại");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel12.setText("Trạng Thái");

        buttonGroup2.add(rdoDangLam);
        rdoDangLam.setText("Đang Làm");
        rdoDangLam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDangLamActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoDanghiLam);
        rdoDanghiLam.setText("Đã Nghỉ Làm");

        jLabel13.setText("Tìm Kiếm");

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        tbNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Nhân Viên", "Tên Nhân Viên", "Địa Chỉ", "Email", "Số Điện Thoại", "Tài Khoản", "Mật Khẩu", "Chức Vụ", "Ngày Tạo", "Ngày Sửa", "Trạng Thái"
            }
        ));
        tbNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbNhanVien);

        btnReset.setText("Làm Mới");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtIDNV))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel10))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(txtSDT))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addComponent(btnAdd)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel9)
                                    .addComponent(btnUpdate))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rdoThuNgan)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(txtTenDangNhap)
                            .addComponent(rdoDangLam))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                .addComponent(txtNgaySua))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                    .addComponent(txtTimKiem))))
                        .addContainerGap(253, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(490, 490, 490)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdoDanghiLam)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnXoa)
                                        .addGap(88, 88, 88)
                                        .addComponent(btnReset))
                                    .addComponent(rdoNhanVien)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(303, 303, 303)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(200, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(rdoThuNgan)
                        .addComponent(rdoNhanVien)
                        .addComponent(jLabel8)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(txtIDNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgaySua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(rdoDangLam)
                    .addComponent(rdoDanghiLam)
                    .addComponent(jLabel13)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnXoa)
                    .addComponent(btnReset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void rdoDangLamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDangLamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoDangLamActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
        TableRowSorter<DefaultTableModel> ab = new TableRowSorter<>(dtm);
        tbNhanVien.setRowSorter(ab);
        ab.setRowFilter(RowFilter.regexFilter(txtTimKiem.getText()));
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void tbNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNhanVienMouseClicked
        // TODO add your handling code here:
         int index = tbNhanVien.getSelectedRow();
        this.detailNhanVien(index);
    }//GEN-LAST:event_tbNhanVienMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
         try {
            if (txtName.getText().isEmpty() || txtSDT.getText().isEmpty() || txtDiaChi.getText().isEmpty() || txtNgayTao.getText() == null) {
                JOptionPane.showMessageDialog(this, "Không được bỏ trống dữ liệu");
                return;
            }
            if (!checkDuLieu()) {
                return;
            }
            if (!isValidPhoneNumber(txtSDT.getText())) {
                JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ! "
                        + "\n Vui lòng nhập số điện thoại có độ dài 10 hoặc 11 chữ số "
                        + "\n Số điện thoại phải bắt đầu bằng 0.");
                return; // Exit the method if the phone number is invalid
            }

            if (tbNhanVien.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Chọn nhân viên cần sửa");
                return;
            }
            nhanVien nv = getFormData();
            nvRepo.Edit(nv);
            loadData();
            JOptionPane.showMessageDialog(this, "Sửa dữ liệu thành công");
            updateMaNhanVienField();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
          try {
            int row = tbNhanVien.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Chọn nhân viên cần xóa");
                return;
            }
            int manv = v.get(row).getIdNhanVien();
            nhanVien nv = new nhanVien();
            nv.setIdNhanVien(manv);
            if (nvRepo.Delete(nv) > 0) {
                loadData();
                JOptionPane.showMessageDialog(this, "Xóa dữ liệu thành công");

            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
                try {
            if (txtName.getText().isEmpty() || txtSDT.getText().isEmpty() || txtDiaChi.getText().isEmpty() || txtNgayTao.getText() == null) {
                JOptionPane.showMessageDialog(this, "Không được bỏ trống dữ liệu");
                return;
            }
            if (!checkDuLieu()) {
                return;
            }
            if (!isValidPhoneNumber(txtSDT.getText())) {
                JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ! "
                        + "\n Vui lòng nhập số điện thoại có độ dài 10 hoặc 11 chữ số "
                        + "\n Số điện thoại phải bắt đầu bằng 0.");
                return; // Exit the method if the phone number is invalid
            }

            nhanVien nv = getFormData();
            if (nvRepo.add(nv)) {
                loadData();
                JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công");
                updateMaNhanVienField();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
           txtName.setText("");
        txtIDNV.setText("");
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtSDT.setText("");
        txtTenDangNhap.setText("");
        txtMatKhau.setText("");
        txtNgayTao.setText("");
        txtNgaySua.setText("");
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        JOptionPane.showMessageDialog(this, "Reset thành công");
    }//GEN-LAST:event_btnResetActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoDangLam;
    private javax.swing.JRadioButton rdoDanghiLam;
    private javax.swing.JRadioButton rdoNhanVien;
    private javax.swing.JRadioButton rdoThuNgan;
    private javax.swing.JTable tbNhanVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIDNV;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNgaySua;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenDangNhap;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
