/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;


import KetNoiSQL.JDBCConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public final class QLHD extends javax.swing.JFrame {
    
    Statement st = null;
    ResultSet rs = null;
    DecimalFormat formatter = new DecimalFormat("###,###,###");

    public QLHD() {
        initComponents();
        showDuLieu();
     
    }
    @SuppressWarnings("unchecked")
     public void showDuLieu() {
        try {
            DSHOADON.removeAll();
            String[] arr = {"Mã sản phẩm", "Khách hàng","Ngày Bán","Địa chỉ"};
            DefaultTableModel model = new DefaultTableModel(arr, 0);
            String sql = "select * from HoaDon";
            Connection connection = JDBCConnection.getJDBCConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Vector vt = new Vector();
                vt.add(rs.getString("MaHD"));
                vt.add(rs.getString("TenKhachHang"));
                vt.add(rs.getString("NgayBan"));
                vt.add(rs.getString("DiaChi"));
                model.addRow(vt);
            }
           DSHOADON.setModel(model);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
 
  
    public void clearTable() {
        DefaultTableModel dm04 = (DefaultTableModel) DSHOADON.getModel();
        while (dm04.getRowCount() > 0) {
            dm04.removeRow(0);
        }
    }
     public void LoadItem() {
        try {
            Connection connection = JDBCConnection.getJDBCConnection();
            String sql = "Select *from HoaDon where MaHD=N'" + Tkmahd.getText().toString() + "'";
            PreparedStatement ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                Tkmahd.setText(rs.getString("MaHD"));    
            } else {
                Tkmahd.setText("");
            }
            showDuLieu();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton36 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jButton37 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DSHOADON = new javax.swing.JTable();
        btndx5 = new javax.swing.JButton();
        mahoa = new javax.swing.JLabel();
        Tkmahd = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(255, 204, 153));

        jButton29.setBackground(new java.awt.Color(255, 204, 0));
        jButton29.setText("Quản lý tài khoản");
        jButton29.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jButton30.setBackground(new java.awt.Color(255, 204, 0));
        jButton30.setText("Quản lý nhân viên");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jButton31.setBackground(new java.awt.Color(255, 204, 0));
        jButton31.setText("Quản lý nhà cung cấp");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jButton32.setBackground(new java.awt.Color(255, 204, 0));
        jButton32.setText("Quản lý khách hàng");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jButton33.setBackground(new java.awt.Color(255, 204, 0));
        jButton33.setText("Quản lý sản phẩm");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        jButton35.setBackground(new java.awt.Color(255, 204, 0));
        jButton35.setText("Quản lý danh mục ");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        jButton36.setBackground(new java.awt.Color(255, 204, 0));
        jButton36.setText("Thống kê dữ liệu");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1.png"))); // NOI18N

        jButton37.setBackground(new java.awt.Color(255, 204, 0));
        jButton37.setText("Quản lý hóa đơn");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        jButton34.setBackground(new java.awt.Color(255, 204, 0));
        jButton34.setText("Quản lý bán hàng");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton31, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jButton32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(jLabel18)
                    .addContainerGap(159, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel20))
                        .addGap(6, 6, 6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(372, Short.MAX_VALUE)))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("QUẢN LÍ HÓA ĐƠN");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tìm kiếm theo mã hóa đơn :");

        DSHOADON.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã hóa đơn", "Tên sản phẩm", "Số lượng", "Đơn giá", "Ghi chú"
            }
        ));
        DSHOADON.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DSHOADONMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DSHOADON);

        btndx5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/signup.png"))); // NOI18N
        btndx5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btndx5MouseClicked(evt);
            }
        });
        btndx5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndx5ActionPerformed(evt);
            }
        });

        mahoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mahoa.setForeground(new java.awt.Color(255, 204, 0));
        mahoa.setText("DANH SÁCH HÓA ĐƠN");

        jButton1.setText("Tìm kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Thời gian :");

        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));

        jButton2.setText("Lọc");

        jButton3.setText("Reset ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(241, 241, 241)
                                        .addComponent(btndx5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(65, 65, 65))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jButton2)
                                                        .addGap(68, 68, 68)
                                                        .addComponent(jButton3)))
                                                .addGap(70, 70, 70)))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGap(19, 19, 19))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(mahoa)
                                .addGap(181, 181, 181))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(Tkmahd, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(btndx5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Tkmahd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addGap(447, 447, 447))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(mahoa)
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        QLNhanVien nv204 = new QLNhanVien();
        nv204.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        QLNCC ncc04 = new QLNCC();
        ncc04.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
           QLKH kh04 = new QLKH();
           kh04.setVisible(true);
           dispose();
    }//GEN-LAST:event_jButton32ActionPerformed

    private void DSHOADONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DSHOADONMouseClicked
       
    }//GEN-LAST:event_DSHOADONMouseClicked

    private void btndx5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndx5MouseClicked
        Login lg04 = new Login();
        lg04.setVisible(true);
        dispose();
    }//GEN-LAST:event_btndx5MouseClicked

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        QLTaiKhoan tk04 = new QLTaiKhoan();
        tk04.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton29ActionPerformed

    private void btndx5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndx5ActionPerformed
        Trangchu lg04 = new Trangchu();
        lg04.setVisible(true);
        dispose();
    }//GEN-LAST:event_btndx5ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
       
        
    }//GEN-LAST:event_formComponentShown

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        BanHang bh = new BanHang();
        bh.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        ThongKeDoanhThu tk04 = new ThongKeDoanhThu();
        tk04.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton36ActionPerformed

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentHidden

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LoadItem();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        QLSP sp = new QLSP();
        sp.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        QLDM dm= new QLDM();
        dm.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        QLHD hd = new QLHD();
        hd.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton37ActionPerformed

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
            java.util.logging.Logger.getLogger(QLHD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLHD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLHD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLHD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLHD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DSHOADON;
    private javax.swing.JTextField Tkmahd;
    private javax.swing.JButton btndx5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel mahoa;
    // End of variables declaration//GEN-END:variables
}
