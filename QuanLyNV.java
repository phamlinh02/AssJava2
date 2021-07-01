package assignment;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QuanLyNV extends javax.swing.JFrame {

    DefaultTableModel model;
    ArrayList<Employee> lst = new ArrayList<>();
    int index;

    public QuanLyNV() {
        initComponents();
        setLocationRelativeTo(null);
//        lst.add(new Employee("ma01", "Nguyễn Văn A", "nguyenvanA@gmail.com", 17, 10000000.0));
//        lst.add(new Employee("ma02", "Nguyễn Văn B", "nguyenvanB@gmail.com", 23, 20000000.0));
//        lst.add(new Employee("ma03", "Nguyễn Văn C", "nguyenvanC@gmail.com", 54, 14000000.0));
//        lst.add(new Employee("ma04", "Nguyễn Văn D", "nguyenvanD@gmail.com", 32, 15000000.0));

        model = (DefaultTableModel) tblNV.getModel();
        toFillTable();
        if(!lst.isEmpty()){
            index=0;
            showDetail();
        }
        new Thread(){
            @Override
            public void run() {
                while(true){
                    Date now = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa");
                    String time = sdf.format(now);
                    lblTime.setText(time);
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        break;
                    }
                }
            }
            
        }.start();
    }

    public void toFillTable() {
        model.setRowCount(0);
        for (Employee x : lst) {
            model.addRow(new Object[]{x.getMaNV(), x.getHoNV(), x.getTuoi(), x.getEmail(), x.getLuong()});
        }
    }

    public void setNullText() {
        txtMa.setText("");
        txtHoTen.setText("");
        txtTuoi.setText("");
        txtEmail.setText("");
        txtLuong.setText("");
        lblStatus.setText("....");
        index=-1;
    }

    public void showDetail() {
        Employee emp = lst.get(index);
        txtHoTen.setText(emp.getHoNV());
        txtEmail.setText(emp.getEmail());
        txtLuong.setText(String.valueOf(emp.getLuong()));
        txtMa.setText(emp.getMaNV());
        txtTuoi.setText(String.valueOf(emp.getTuoi()));
        lblStatus.setText("Record: " + (index + 1) + " of " + lst.size());
        tblNV.setRowSelectionInterval(index, index);
    }

    public void updateEmployee() {
        
        index = tblNV.getSelectedRow();
        check();
        Employee x = lst.get(index);
        x.setMaNV(txtMa.getText());
        x.setHoNV(txtHoTen.getText());
        x.setTuoi(Integer.parseInt(txtTuoi.getText()));
        x.setEmail(txtEmail.getText());
        x.setLuong(Double.valueOf(txtLuong.getText()));
        toFillTable();
        tblNV.setRowSelectionInterval(index, index);
    }

    public void removeEmp() {
        int count = tblNV.getSelectedRow();
        lst.remove(count);

    }
    public void check(){
        if (Hepler.checkRong(txtMa, "Mời nhập mã nhân viên")) {
            txtMa.requestFocus();
            return;
        }
        for (Employee x : lst) {
            if (txtMa.getText().equals(x.getMaNV())) {
                JOptionPane.showMessageDialog(this, "Đã có mã nhân viên đó, mời nhập mã nhân viên khác");
                txtMa.requestFocus();
                return;
            }
        }
        if (Hepler.checkRong(txtHoTen, "Mời nhập tên nhân viên")) {
            txtHoTen.requestFocus();
            return;
        }
//        while (Hepler.checkTen(txtHoTen, "Họ tên chỉ được chứ ký tự")) {
//            txtHoTen.requestFocus();
//            return;
//        }
        if (Hepler.checkRong(txtTuoi, "Mời nhập tuổi nhân viên")) {
            txtTuoi.requestFocus();
            return;
        }
        if (Hepler.checkSo(txtTuoi, "Vui lòng nhập tuổi là số")) {
            txtTuoi.requestFocus();
            return;
        }
        if (Hepler.checkTuoi(txtTuoi, "Số tuổi không nằm trong khoảng 16-55")) {
            txtTuoi.requestFocus();
            return;
        }
        if (Hepler.checkRong(txtEmail, "Mời nhập email nhân viên")) {
            txtEmail.requestFocus();
            return;
        }
        if (Hepler.checkMail(txtEmail, "Vui lòng nhập mail đúng định dạng")) {
            txtEmail.requestFocus();
            return;
        }
        if (Hepler.checkRong(txtLuong, "Mời nhập lương nhân viên")) {
            txtLuong.requestFocus();
            return;
        }

        if (Hepler.checkSo(txtLuong, "Vui lòng nhập tuổi là số")) {
            txtLuong.requestFocus();
            return;
        }

        if (Hepler.checkLuong(txtLuong, "Lương phải trên 5 triệu")) {
            txtLuong.requestFocus();
            return;
        }
    }
    public void addEmployee() throws Exception {
        
        check();
        JOptionPane.showMessageDialog(this, "Đã thêm thành công");
        lst.add(new Employee(txtMa.getText(), txtHoTen.getText(), txtEmail.getText(), Integer.valueOf(txtTuoi.getText()), Double.valueOf(txtLuong.getText())));
        model.addRow(new Object[]{txtMa.getText(), txtHoTen.getText(), txtTuoi.getText(), txtEmail.getText(), txtLuong.getText()});
        index = lst.size() - 1;
        tblNV.setRowSelectionInterval(index, index);
        setNullText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNV = new javax.swing.JTable();
        btnDau = new javax.swing.JButton();
        btnPre = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnCuoi = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        txtLuong = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTuoi = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtMa = new javax.swing.JTextField();
        lblTime = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnOpen = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        jLabel7.setText("MÃ NHÂN VIÊN");

        jLabel4.setText("HỌ VÀ TÊN");

        jLabel5.setText("TUỔI");

        jLabel6.setText("EMAIL");

        jLabel8.setText("LƯƠNG");

        tblNV.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ", "HỌ VÀ TÊN", "TUỔI", "EMAIL", "LƯƠNG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNV.setRowHeight(25);
        tblNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNVMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblNV);

        btnDau.setText("|<");
        btnDau.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDauActionPerformed(evt);
            }
        });

        btnPre.setText("<<");
        btnPre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });

        btnNext.setText(">>");
        btnNext.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnCuoi.setText(">|");
        btnCuoi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuoiActionPerformed(evt);
            }
        });

        lblStatus.setForeground(new java.awt.Color(255, 0, 0));
        lblStatus.setText("Record: 1 of ...");

        txtLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLuongActionPerformed(evt);
            }
        });

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        txtTuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTuoiActionPerformed(evt);
            }
        });

        txtMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaActionPerformed(evt);
            }
        });

        lblTime.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 0, 0));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnNew.setText("New");
        btnNew.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnOpen.setText("Open");
        btnOpen.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        btnFind.setText("Find");
        btnFind.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNew, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnExit, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnOpen, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnFind, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDelete, btnExit, btnFind, btnNew, btnOpen, btnSave});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFind)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOpen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMa, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtHoTen)
                                .addComponent(txtEmail)
                                .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDau, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnPre)
                        .addGap(34, 34, 34)
                        .addComponent(btnNext)
                        .addGap(29, 29, 29)
                        .addComponent(btnCuoi)
                        .addGap(18, 18, 18)
                        .addComponent(lblStatus)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCuoi, btnDau, btnNext, btnPre});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(27, 27, 27)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDau)
                    .addComponent(btnPre)
                    .addComponent(btnNext)
                    .addComponent(btnCuoi)
                    .addComponent(lblStatus))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNVMouseClicked
        // TODO add your handling code here:
        try {
            index = tblNV.getSelectedRow();
            showDetail();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi click Table");

        }
    }//GEN-LAST:event_tblNVMouseClicked

    private void btnCuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuoiActionPerformed
        // TODO add your handling code here:
        index=lst.size()-1;
        showDetail();
    }//GEN-LAST:event_btnCuoiActionPerformed

    private void txtLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLuongActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtTuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTuoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTuoiActionPerformed

    private void txtMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        try {
            setNullText();
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi làm mới form");
        }
    }//GEN-LAST:event_btnNewActionPerformed
    
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        try {
            
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ass.txt"));
             if (index == -1) {
                addEmployee();

            } else {
                updateEmployee();
                JOptionPane.showMessageDialog(this, "Thanh cong");
            }
             oos.writeObject(lst);
             oos.flush();
             oos.close();
                            
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi lưu dữ liệu");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        try {
            if (lst.size() == 0) {
                JOptionPane.showMessageDialog(this, "Không còn dữ liệu để xóa");
                return;
            }
            //hỏi xóa
            int hoi = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa thật không?");
            if (hoi != JOptionPane.YES_OPTION) {
                return;
            }

            //thực hiện xóa trong list
            lst.remove(index);
//xóa trong model (table) <=> fillToTable();
            model.removeRow(index);
            //xử lý sau khi xóa
            if (lst.size() == 0) {
                setNullText();
            } else {
                if (lst.size() == index) {
                    index--;
                }
                showDetail();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "lỗi xóa dữ liệu");
        }


    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed

        
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ass.txt"));
            lst = (ArrayList<Employee>) ois.readObject();
            if (!lst.isEmpty()) {
                toFillTable();
                index = 0;
                showDetail();
            } else {
                index = -1;
                setNullText();
            }ois.close();
            JOptionPane.showMessageDialog(this, "sucessfull");
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Lỗi doc file");
            
        }

    }//GEN-LAST:event_btnOpenActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
        try {
            setNullText();
            String maTK = JOptionPane.showInputDialog(this, "Mời nhập mã cần tìm");
            boolean kt = false;
            for (int i=0;i<lst.size();i++) {
                Employee x = lst.get(i);
                if (maTK.equalsIgnoreCase(x.getMaNV())) {
                    index=i;
                    showDetail();
                    kt = true;
                    break;
                }

            }
            if (kt == false) {
                JOptionPane.showMessageDialog(this, "Không có nhân viên nào có mã như thế");
                setNullText();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi tìm kiếm");
        }


    }//GEN-LAST:event_btnFindActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.txt"));
        oos.writeObject(lst);
                oos.flush();
                oos.close();
                JOptionPane.showMessageDialog(this, "Sucessfull");
                System.exit(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error");
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDauActionPerformed
        // TODO add your handling code here:
        index=0;
        showDetail();
    }//GEN-LAST:event_btnDauActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        // TODO add your handling code here:
        try {
            index--;
            showDetail();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Đây đã là vị trí đầu tiên");
        }
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        try {
            index++;
            showDetail();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Đây đã là vị trí cuối cùng");
        }
    }//GEN-LAST:event_btnNextActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyNV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCuoi;
    private javax.swing.JButton btnDau;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnPre;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTime;
    private javax.swing.JTable tblNV;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables
}
