/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import app.bolivia.swing.JCTextField;
import controllers.BookController;
import controllers.IssueController;
import controllers.StudentController;
import java.awt.Color;
import utils.DBConnection;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import javax.swing.JFrame;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import models.Book.Book;
import models.Student.Student;

/**
 *
 * @author trinh
 */
public class IssueBook extends javax.swing.JFrame {

    private StudentController studentController;
    private BookController bookController;
    private IssueController issueController;

    /**
     * Creates new form IsssueBook
     */
    public IssueBook() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        studentController = new StudentController(this);
        bookController = new BookController(this);
        issueController = new IssueController(this);
        setMajorsToComboBox();
        setIssueDate();
    }

    public void clearUserInput() {
        txt_bookId.setText("");
        txt_studentId.setText("");
        txt_issueDays.setText("");
        txt_dueDate.setText("");
        lbl_bookName.setText("");
        lbl_category.setText("");
        lbl_publisher.setText("");
        lbl_quantity.setText("");
        lbl_author.setText("");
        lbl_studentName.setText("");
        lbl_email.setText("");
        txt_issueDays.setText("");
    }

    public void setMajorsToComboBox() {
        for (String major : studentController.getAllMajors()) {
            comboBoxMajor.addItem(major);
        }
    }

    public void setIssueDate() {
        Date issueDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        String formattedIssueDate = formatter.format(issueDate);

        txt_issueDate.setText(formattedIssueDate);
    }

    public void setDueDate() {
        Date issueDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        Calendar cal = Calendar.getInstance();

        cal.setTime(issueDate);

        try {
            int days = Integer.parseInt(txt_issueDays.getText());
            cal.add(Calendar.DAY_OF_MONTH, days);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số ngày mượn không hợp lệ");
        }
        String sIssueDate = formatter.format(cal.getTime());
        txt_dueDate.setText(sIssueDate);
    }

    public boolean validateUserInput() {
        if (txt_studentId.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sinh viên");
            return false;
        }

        try {
            int id = Integer.parseInt(txt_studentId.getText());
            Student student = studentController.getStudentById(id);
            if (student != null) {
                lbl_studentName.setText(student.getName());
                lbl_email.setText(student.getEmail());
                comboBoxMajor.setSelectedItem(student.getMajor());
            } else {
                JOptionPane.showMessageDialog(this, "Sinh viên không tồn tại");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Mã sinh viên không hợp lệ");
            return false;
        }

        if (txt_bookId.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sách");
            return false;
        }

        Book book = bookController.getBookById(txt_bookId.getText());
        if (book != null) {
            lbl_bookName.setText(book.getTitle());
            lbl_author.setText(book.getAuthor());
            lbl_category.setText(book.getGenre());
            lbl_publisher.setText(book.getPublisher());
            lbl_quantity.setText(String.valueOf(book.getQuantity()));
        } else {
            JOptionPane.showMessageDialog(this, "Sách không tồn tại");
        }

        if (isAlreadyIssued()) {
            JOptionPane.showMessageDialog(this, "Bạn đã mượn quyển sách này");
            return false;
        }

        if (Integer.parseInt(lbl_quantity.getText()) == 0) {
            JOptionPane.showMessageDialog(this, "Sách này tạm thời hết");
            return false;
        }
        return true;
    }

//    Check if a book is already issued by a student
    public boolean isAlreadyIssued() {
        String bookId = txt_bookId.getText();
        int studentId = Integer.parseInt(txt_studentId.getText());

        if (issueController.getByBookIdAndStudentId(bookId, studentId) != null) {
            return true;
        }

        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSDateChooserBeanInfo1 = new rojeru_san.componentes.RSDateChooserBeanInfo();
        panel_main = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lbl_studentName = new app.bolivia.swing.JCTextField();
        jLabel6 = new javax.swing.JLabel();
        lbl_email = new app.bolivia.swing.JCTextField();
        jLabel8 = new javax.swing.JLabel();
        comboBoxMajor = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_dueDate = new app.bolivia.swing.JCTextField();
        txt_studentId = new app.bolivia.swing.JCTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        submitButton = new rojerusan.RSMaterialButtonRectangle();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_bookName = new app.bolivia.swing.JCTextField();
        jLabel22 = new javax.swing.JLabel();
        lbl_author = new app.bolivia.swing.JCTextField();
        lbl_publisher = new app.bolivia.swing.JCTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lbl_category = new app.bolivia.swing.JCTextField();
        jLabel25 = new javax.swing.JLabel();
        lbl_quantity = new app.bolivia.swing.JCTextField();
        checkButton = new rojerusan.RSMaterialButtonRectangle();
        txt_bookId = new app.bolivia.swing.JCTextField();
        txt_issueDays = new app.bolivia.swing.JCTextField();
        txt_issueDate = new app.bolivia.swing.JCTextField();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Họ và tên");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 150, -1));

        lbl_studentName.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lbl_studentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_studentNameActionPerformed(evt);
            }
        });
        jPanel1.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 340, 40));

        jLabel6.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Email");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 190, -1));

        lbl_email.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lbl_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_emailActionPerformed(evt);
            }
        });
        jPanel1.add(lbl_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 340, 40));

        jLabel8.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Thông tin sinh viên");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        comboBoxMajor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        comboBoxMajor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxMajorActionPerformed(evt);
            }
        });
        jPanel1.add(comboBoxMajor, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 340, 40));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/51516_arrow_back_left_icon.png"))); // NOI18N
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel11);

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 40));

        jLabel2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Khoa");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 200, -1));

        panel_main.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 800));

        jLabel15.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 204));
        jLabel15.setText("Mã sách");
        panel_main.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 280, 80, -1));

        txt_dueDate.setEditable(false);
        txt_dueDate.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 112, 192), null));
        txt_dueDate.setForeground(new java.awt.Color(102, 102, 102));
        txt_dueDate.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txt_dueDate.setPhColor(new java.awt.Color(102, 102, 102));
        panel_main.add(txt_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 450, 240, 40));

        txt_studentId.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 112, 192), null));
        txt_studentId.setForeground(new java.awt.Color(102, 102, 102));
        txt_studentId.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txt_studentId.setPhColor(new java.awt.Color(102, 102, 102));
        txt_studentId.setPlaceholder("Nhập mã sinh viên");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        panel_main.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 210, 240, 40));

        jLabel16.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 204));
        jLabel16.setText("Ngày trả");
        panel_main.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 460, 90, -1));

        jLabel17.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 153, 204));
        jLabel17.setText("Mã sinh viên");
        panel_main.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 220, 120, -1));

        jLabel18.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 153, 204));
        jLabel18.setText("Số ngày mượn");
        panel_main.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 340, 150, -1));

        submitButton.setBackground(new java.awt.Color(100, 136, 234));
        submitButton.setText("Cho mượn");
        submitButton.setEnabled(false);
        submitButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        panel_main.add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 640, 210, -1));

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mượn sách");
        jPanel2.add(jLabel3);

        panel_main.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 120, 350, 50));

        jPanel3.setBackground(new java.awt.Color(100, 136, 234));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Thông tin sách");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jLabel21.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Tên sách");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 150, -1));

        lbl_bookName.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        lbl_bookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_bookNameActionPerformed(evt);
            }
        });
        jPanel3.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 360, 40));

        jLabel22.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Tác giả");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 140, -1));

        lbl_author.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lbl_author.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_authorActionPerformed(evt);
            }
        });
        jPanel3.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 360, 40));

        lbl_publisher.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lbl_publisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_publisherActionPerformed(evt);
            }
        });
        jPanel3.add(lbl_publisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 360, 40));

        jLabel23.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Nhà xuất bản");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 150, -1));

        jLabel24.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Thể loại");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 150, -1));

        lbl_category.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lbl_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_categoryActionPerformed(evt);
            }
        });
        jPanel3.add(lbl_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 360, 40));

        jLabel25.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Số lượng");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, 150, -1));

        lbl_quantity.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lbl_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_quantityActionPerformed(evt);
            }
        });
        jPanel3.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 360, 40));

        panel_main.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 440, 800));

        checkButton.setBackground(new java.awt.Color(100, 136, 234));
        checkButton.setText("Kiểm tra");
        checkButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        checkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkButtonActionPerformed(evt);
            }
        });
        panel_main.add(checkButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 540, 210, -1));

        txt_bookId.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 112, 192), null));
        txt_bookId.setForeground(new java.awt.Color(102, 102, 102));
        txt_bookId.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txt_bookId.setPhColor(new java.awt.Color(102, 102, 102));
        txt_bookId.setPlaceholder("Nhập mã sách");
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIdActionPerformed(evt);
            }
        });
        panel_main.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 270, 240, 40));

        txt_issueDays.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 112, 192), null));
        txt_issueDays.setForeground(new java.awt.Color(102, 102, 102));
        txt_issueDays.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txt_issueDays.setPhColor(new java.awt.Color(102, 102, 102));
        txt_issueDays.setPlaceholder("Nhập số ngày mượn");
        panel_main.add(txt_issueDays, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 330, 240, 40));

        txt_issueDate.setEditable(false);
        txt_issueDate.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 112, 192), null));
        txt_issueDate.setForeground(new java.awt.Color(102, 102, 102));
        txt_issueDate.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txt_issueDate.setPhColor(new java.awt.Color(102, 102, 102));
        panel_main.add(txt_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 390, 240, 40));

        jLabel19.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 153, 204));
        jLabel19.setText("Ngày mượn");
        panel_main.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 400, 120, -1));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 800));

        setSize(new java.awt.Dimension(1425, 810));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_studentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_studentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_studentNameActionPerformed

    private void lbl_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_emailActionPerformed

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost

    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost

    }//GEN-LAST:event_txt_studentIdFocusLost

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        HomePage homePage = new HomePage();
        homePage.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void lbl_bookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_bookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_bookNameActionPerformed

    private void lbl_authorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_authorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_authorActionPerformed

    private void lbl_publisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_publisherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_publisherActionPerformed

    private void lbl_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_categoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_categoryActionPerformed

    private void comboBoxMajorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxMajorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxMajorActionPerformed

    private void lbl_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_quantityActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        Book book = bookController.getBookById(txt_bookId.getText());

        Student student = new Student(Integer.parseInt(txt_studentId.getText()), lbl_studentName.getText());

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            // Parse the string into a Date object
            Date issueDate = dateFormat.parse(txt_issueDate.getText());
            Date dueDate = dateFormat.parse(txt_dueDate.getText());
            
            if (issueController.issueBook(book, student, issueDate, dueDate)) {
                JOptionPane.showMessageDialog(this, "Mượn sách thành công");
                
                book.setQuantity(book.getQuantity() - 1);
                bookController.updateBook(book);
                clearUserInput();
            } else {
                JOptionPane.showMessageDialog(this, "Mượn sách không thành công");
            }
        } catch (ParseException e) {
            // Handle the exception if the date string is not in the expected format
            e.printStackTrace();
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void checkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkButtonActionPerformed
        setDueDate();
        if (validateUserInput()) {
            submitButton.setEnabled(true);
        }
    }//GEN-LAST:event_checkButtonActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonRectangle checkButton;
    private javax.swing.JComboBox<String> comboBoxMajor;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private app.bolivia.swing.JCTextField lbl_author;
    private app.bolivia.swing.JCTextField lbl_bookName;
    private app.bolivia.swing.JCTextField lbl_category;
    private app.bolivia.swing.JCTextField lbl_email;
    private app.bolivia.swing.JCTextField lbl_publisher;
    private app.bolivia.swing.JCTextField lbl_quantity;
    private app.bolivia.swing.JCTextField lbl_studentName;
    private javax.swing.JPanel panel_main;
    private rojeru_san.componentes.RSDateChooserBeanInfo rSDateChooserBeanInfo1;
    private rojerusan.RSMaterialButtonRectangle submitButton;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_dueDate;
    private app.bolivia.swing.JCTextField txt_issueDate;
    private app.bolivia.swing.JCTextField txt_issueDays;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
