/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controllers.StudentController;
import utils.DBConnection;
import javax.swing.table.DefaultTableModel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableRowSorter;
import models.Student;

/**
 *
 * @author trinh
 */
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class ManageStudents extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    private StudentController studentController;

    private DefaultTableModel model;

    public ManageStudents() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        studentController = new StudentController(this);
        setStudentDetailsToTable(studentController.getAllStudents());
        setMajorsToComboBox();
    }

    // to set the student details into table
    public void setStudentDetailsToTable(List<Student> students) {
        clearTable();
        for (Student student : students) {
            String studentID = student.getId();
            String studentName = student.getName();
            String gender = student.getGender();
            LocalDate birthday = student.getBirthday();
            String studentEmail = student.getEmail();
            String major = student.getMajor();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String formattedBirthday = formatter.format(birthday);

            Object[] obj = {studentID, studentName, gender, formattedBirthday, studentEmail, major};
            model = (DefaultTableModel) tbl_studentDetails.getModel();
            model.addRow(obj);
        }
    }

    public void setMajorsToComboBox() {
        for (String major : studentController.getAllMajors()) {
            comboBoxMajor.addItem(major);
        }
    }
    
    public Student getUserInput() {
        String studentID = txtStudentID.getText();
        String studentName = txtStudentName.getText();
        String gender = txtGender.getText();
        String birthday = txtBirthday.getText();
        String studentEmail = txtStudentEmail.getText();
        String major = comboMajor.getSelectedItem().toString();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate formattedBirthday = LocalDate.parse(birthday, formatter);
        return new Student(studentID, studentName, gender, formattedBirthday, studentEmail, major);
    }

    public void refreshTable() {
        clearFormInput();
        clearTable();
        setStudentDetailsToTable(studentController.getAllStudents());
    }

    public boolean validateUserInput() {
        Student student = getUserInput();

        if (student.getId().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sinh viên");
            return false;
        }

        if (student.getName().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sinh viên");
            return false;
        }

        if (student.getGender().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giới tính");
            return false;
        }
        if (student.getBirthday().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày sinh");
            return false;
        }
        if (student.getEmail().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập email");
            return false;
        }
        if (student.getMajor().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập chuyên ngành");
            return false;
        }

        return true;
    }

    public void displayStudentDetails(Student student) {
        txtStudentID.setText(student.getId());
        txtStudentName.setText(student.getName());
        txtGender.setText(student.getGender());
        txtBirthday.setText(student.getBirthday().toString());
        txtStudentEmail.setText(student.getEmail());
        comboMajor.setSelectedItem(String.valueOf(student.getMajor()));
    }
    
    
    // method to clear table
    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_studentDetails.getModel();
        model.setRowCount(0);
    }

    public void clearFormInput() {
        txtStudentID.setText("");
        txtStudentName.setText("");
        txtGender.setText("");
        txtBirthday.setText("");
        txtStudentEmail.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtStudentID = new app.bolivia.swing.JCTextField();
        txtStudentName = new app.bolivia.swing.JCTextField();
        txtGender = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        backButton = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblQLSV = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtBirthday = new app.bolivia.swing.JCTextField();
        txtStudentEmail = new app.bolivia.swing.JCTextField();
        comboMajor = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojeru_san.complementos.RSTableMetro();
        jPanel2 = new javax.swing.JPanel();
        lblThongTinSV = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFindID = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        btnSua = new rojeru_san.complementos.RSButtonHover();
        btnXoa = new rojeru_san.complementos.RSButtonHover();
        btnThem = new rojeru_san.complementos.RSButtonHover();
        comboBoxMajor = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(100, 136, 234));
        jPanel4.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("MSSV");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        txtStudentID.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtStudentID.setPlaceholder("Nhập mã số sinh viên");
        txtStudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentIDActionPerformed(evt);
            }
        });
        jPanel4.add(txtStudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 280, 40));

        txtStudentName.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtStudentName.setPlaceholder("Nhập họ và tên sinh viên");
        txtStudentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentNameActionPerformed(evt);
            }
        });
        jPanel4.add(txtStudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 280, 40));

        txtGender.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtGender.setPlaceholder("Nhập giới tính");
        txtGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGenderActionPerformed(evt);
            }
        });
        jPanel4.add(txtGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 280, 40));

        jLabel11.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Giới tính");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, -1));

        jLabel2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Chuyên ngành");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 640, -1, -1));

        jLabel7.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Họ và tên");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/51516_arrow_back_left_icon.png"))); // NOI18N
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });
        jPanel5.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 50));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 50));

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblQLSV.setBackground(new java.awt.Color(153, 153, 255));
        lblQLSV.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        lblQLSV.setForeground(new java.awt.Color(102, 102, 102));
        lblQLSV.setText("Quản lý sinh viên");
        jPanel6.add(lblQLSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 340, 50));

        jLabel4.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ngày sinh");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, -1, -1));

        jLabel5.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Địa chỉ email");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 550, -1, -1));

        txtBirthday.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtBirthday.setPlaceholder("NN-TT-NNNN");
        txtBirthday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBirthdayActionPerformed(evt);
            }
        });
        jPanel4.add(txtBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 280, 40));

        txtStudentEmail.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtStudentEmail.setPlaceholder("Nhập email");
        txtStudentEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentEmailActionPerformed(evt);
            }
        });
        jPanel4.add(txtStudentEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 580, 280, 40));

        comboMajor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        comboMajor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CNTT", "HTTT", "KHMT", " " }));
        comboMajor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMajorActionPerformed(evt);
            }
        });
        jPanel4.add(comboMajor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 670, 280, 40));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/male_user_50px.png"))); // NOI18N
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 50, 60));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 830));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MSSV", "Họ và tên", "Giới tính", "Ngày sinh", "Địa chỉ email", "Chuyên ngành"
            }
        ));
        tbl_studentDetails.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.setRowHeight(30);
        tbl_studentDetails.setShowGrid(false);
        tbl_studentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_studentDetails);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 990, 380));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblThongTinSV.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        lblThongTinSV.setText("Thông tin sinh viên");
        jPanel2.add(lblThongTinSV);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 990, 80));

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel1.setText("Tìm kiếm theo mã sinh viên");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 250, 40));

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel3.setText("Lọc theo chuyên ngành");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 250, 40));

        txtFindID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtFindID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindIDActionPerformed(evt);
            }
        });
        jPanel1.add(txtFindID, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 310, 40));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 190, -1, 40));

        searchButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        searchButton.setForeground(new java.awt.Color(0, 153, 255));
        searchButton.setText("Tìm kiếm");
        searchButton.setBorder(null);
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        jPanel1.add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 160, 110, 40));

        btnSua.setText("Sửa");
        btnSua.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel1.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 690, 150, 50));

        btnXoa.setText("Xóa");
        btnXoa.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel1.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 690, 150, 50));

        btnThem.setText("Thêm");
        btnThem.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel1.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 690, 160, 50));

        comboBoxMajor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        comboBoxMajor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        comboBoxMajor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxMajorItemStateChanged(evt);
            }
        });
        comboBoxMajor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxMajorActionPerformed(evt);
            }
        });
        jPanel1.add(comboBoxMajor, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 280, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 1030, 830));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboMajorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMajorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboMajorActionPerformed

    private void comboBoxMajorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxMajorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxMajorActionPerformed

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        HomePage homePage = new HomePage();
        homePage.setVisible(true);
        dispose();
    }//GEN-LAST:event_backButtonMouseClicked

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        Student student = studentController.getStudentById(txtFindID.getText());
        if (student != null) {
            displayStudentDetails(student);
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sinh viên");
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void comboBoxMajorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxMajorItemStateChanged
         List<Student> students = studentController.getAllByMajor(comboBoxMajor.getSelectedItem().toString());

        if (comboBoxMajor.getSelectedItem().equals("Tất cả")) {
            refreshTable();
        } else {
            setStudentDetailsToTable(students);
        }
    }//GEN-LAST:event_comboBoxMajorItemStateChanged

    private void txtStudentIDActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtStudentIDActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtStudentIDActionPerformed

    private void txtStudentNameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtStudentNameActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtStudentNameActionPerformed

    private void txtGenderActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtGenderActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtGenderActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXoaActionPerformed
         if (studentController.deleteStudent(txtStudentID.getText())) {
            JOptionPane.showMessageDialog(this, "Xóa sinh viên thành công");
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(this, "Xóa sinh viên không thành công");
        }
    }// GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemActionPerformed
        if (validateUserInput()) {
            if (studentController.addNewStudent(getUserInput())) {
                JOptionPane.showMessageDialog(this, "Thêm sinh viên thành công");
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm sinh viên không thành công");
            }
        }
    }// GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSuaActionPerformed
        if (validateUserInput()) {
            Student student = getUserInput();

            if (studentController.updateStudent(student)) {
                JOptionPane.showMessageDialog(this, "Cập nhật sinh viên thành công");
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật sinh viên không thành công");
            }
        }
    }// GEN-LAST:event_btnSuaActionPerformed

    private void tbl_studentDetailsMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbl_studentDetailsMouseClicked
        int rowNo = tbl_studentDetails.getSelectedRow();
        TableModel model = tbl_studentDetails.getModel();

        txtStudentID.setText(model.getValueAt(rowNo, 0).toString());
        txtStudentName.setText(model.getValueAt(rowNo, 1).toString());
        txtGender.setText(model.getValueAt(rowNo, 2).toString());
        txtBirthday.setText(model.getValueAt(rowNo, 3).toString());
        txtStudentEmail.setText(model.getValueAt(rowNo, 4).toString());
        comboMajor.setSelectedItem(model.getValueAt(rowNo, 5).toString());

    }// GEN-LAST:event_tbl_studentDetailsMouseClicked

    private void txtBirthdayActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtBirthdayActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtBirthdayActionPerformed

    private void txtStudentEmailActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtStudentEmailActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtStudentEmailActionPerformed

    private void txtFindIDActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtFindIDActionPerformed
        
    }// GEN-LAST:event_txtFindIDActionPerformed

    private void txtFindMajorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtFindMajorActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtFindMajorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed

    }// GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backButton;
    private rojeru_san.complementos.RSButtonHover btnSua;
    private rojeru_san.complementos.RSButtonHover btnThem;
    private rojeru_san.complementos.RSButtonHover btnXoa;
    private javax.swing.JComboBox<String> comboBoxMajor;
    private javax.swing.JComboBox<String> comboMajor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblQLSV;
    private javax.swing.JLabel lblThongTinSV;
    private javax.swing.JButton searchButton;
    private rojeru_san.complementos.RSTableMetro tbl_studentDetails;
    private app.bolivia.swing.JCTextField txtBirthday;
    private javax.swing.JTextField txtFindID;
    private app.bolivia.swing.JCTextField txtGender;
    private app.bolivia.swing.JCTextField txtStudentEmail;
    private app.bolivia.swing.JCTextField txtStudentID;
    private app.bolivia.swing.JCTextField txtStudentName;
    // End of variables declaration//GEN-END:variables
}
