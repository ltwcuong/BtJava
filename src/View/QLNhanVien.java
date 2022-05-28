/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import KetNoiSQL.JDBCConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class QLNhanVien extends javax.swing.JFrame {

    Statement st119 = null;
    ResultSet rs119 = null;
    public QLNhanVien() {
        initComponents();
    }
     public void showDL119() {
        try {
            DanhSachNV.removeAll();
            String[] arr119 = {"Mã nhân viên", "Tên nhân viên","Ngày sinh","Chức vụ","Số điện thoại", "Gmail","Giới tính",  "Ghi chú"};
            DefaultTableModel model = new DefaultTableModel(arr119, 0);
            String sql119 = "select * from nhanvien";
            Connection con = JDBCConnection.getJDBCConnection();
            PreparedStatement ps119 = con.prepareStatement(sql119);
            rs119 = ps119.executeQuery();

            while (rs119.next()) {
                Vector vtor = new Vector();
               vtor.add(rs119.getString("manv"));
                vtor.add(rs119.getString("tennv"));
                vtor.add(rs119.getString("ngaysinh"));
                vtor.add(rs119.getString("chucvu"));
                vtor.add(rs119.getString("SDT"));
                vtor.add(rs119.getString("Gmail"));
                vtor.add(rs119.getString("gt"));
                vtor.add(rs119.getString("gc"));
                model.addRow(vtor);
            }
            DanhSachNV.setModel(model);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
       public void LoadItem119() {
      try {
            DanhSachNV.removeAll();
            String[] arr = {"Mã nhân viên", "Tên nhân viên","Ngày sinh","Chức vụ","Số điện thoại", "Gmail","Giới tính",  "Ghi chú"};
            DefaultTableModel model = new DefaultTableModel(arr, 0);
            String sql = "Select *from nhanvien where manv=N'" + search.getText().toString() + "'";
            Connection con = JDBCConnection.getJDBCConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            rs119 = ps.executeQuery();

            while (rs119.next()) {
                Vector vtor= new Vector();
                vtor.add(rs119.getString("manv"));
                vtor.add(rs119.getString("tennv"));
                vtor.add(rs119.getString("ngaysinh"));
                vtor.add(rs119.getString("chucvu"));
                vtor.add(rs119.getString("SDT"));
                vtor.add(rs119.getString("Gmail"));
                vtor.add(rs119.getString("gt"));
                vtor.add(rs119.getString("gc"));
           
                model.addRow(vtor);
            }
            DanhSachNV.setModel(model);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
       }

            

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btndx04 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        mnv = new javax.swing.JTextField();
        tennv = new javax.swing.JTextField();
        sdtnv = new javax.swing.JTextField();
        nsnv = new javax.swing.JTextField();
        search = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        gmailnv = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dcnv = new javax.swing.JTextField();
        gtnv = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        chucvu = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        xoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        DanhSachNV = new javax.swing.JTable();
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
        Lammoi = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("Quản lý tài Nhân viên");

        btndx04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/signup.png"))); // NOI18N
        btndx04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndx04ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel4.setToolTipText("");

        jLabel2.setText("Mã nhân viên:");

        jLabel3.setText("Tên nhân viên:");

        jLabel5.setText("Số điện thoại:");

        jLabel6.setText("Ngày sinh:");

        jButton7.setText("Tìm kiếm");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel7.setText("Gmail:");

        jLabel11.setText("Giới tính:");

        jLabel12.setText("Địa chỉ:");

        gtnv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        jLabel8.setText("Chức vụ");

        chucvu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lí", "Nhân viên" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tennv, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(mnv)
                            .addComponent(nsnv)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(sdtnv)
                        .addComponent(gmailnv, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                        .addComponent(dcnv))
                    .addComponent(gtnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(mnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(sdtnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tennv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(gmailnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(nsnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(gtnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(dcnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jButton5.setText("Thêm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Cập nhật");

        xoa.setText("Xoá");
        xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaActionPerformed(evt);
            }
        });

        DanhSachNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        DanhSachNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DanhSachNVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DanhSachNV);

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
                .addGap(0, 15, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(372, Short.MAX_VALUE)))
        );

        Lammoi.setText("Làm mới");
        Lammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LammoiActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setText("Danh sách nhân viên");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(138, 138, 138)
                            .addComponent(btndx04, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(301, 301, 301)
                                    .addComponent(jLabel4))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(124, 124, 124)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(40, 40, 40)
                                    .addComponent(jButton6)
                                    .addGap(48, 48, 48)
                                    .addComponent(xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(38, 38, 38)
                                    .addComponent(Lammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btndx04, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btndx04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndx04ActionPerformed
        // TODO add your handling code here:
        Trangchu tc119 = new Trangchu();
        tc119.setVisible(true);
        dispose();
    }//GEN-LAST:event_btndx04ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        QLTaiKhoan tk119 = new QLTaiKhoan();
        tk119.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        QLNhanVien nv119 = new QLNhanVien();
        nv119.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        QLNCC ncc119 = new QLNCC();
        ncc119.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        QLKH kh119 = new QLKH();
        kh119.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        ThongKeDoanhThu tk119 = new ThongKeDoanhThu();
        tk119.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        BanHang bh119 = new BanHang();
        bh119.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       if (mnv.getText().equals("") ) {
            JOptionPane.showMessageDialog(this, "Không được để trống!");
        } else {

            try {
                Connection con119 = JDBCConnection.getJDBCConnection();
                PreparedStatement ps119 = con119.prepareStatement("insert into nhanvien values (?,?,?,?,?,?,?,?)");
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
               
                ps119.setString(1, mnv.getText());
                ps119.setString(2, tennv.getText());
                ps119.setString(3,nsnv.getText());
                ps119.setString(4, chucvu.getSelectedItem().toString());
                ps119.setString(5, sdtnv.getText());
                ps119.setString(6, gmailnv.getText());
                ps119.setString(7, gtnv.getSelectedItem().toString());
                ps119.setString(8, dcnv.getText());
                ps119.executeUpdate();
                showDL119();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaActionPerformed
         if (mnv.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chon  để xóa");
        } else {
            try {
                Connection con = JDBCConnection.getJDBCConnection();
                PreparedStatement ps = con.prepareStatement("delete from nhanvien where manv=?");
                ps.setString(1, mnv.getText());
                ps.executeUpdate();
                showDL119();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_xoaActionPerformed

    private void LammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LammoiActionPerformed
        mnv.setText("");
        tennv.setText("");
        nsnv.setText("");
        sdtnv.setText("");
        gmailnv.setText("");
        dcnv.setText("");
        showDL119();
    }//GEN-LAST:event_LammoiActionPerformed

    private void DanhSachNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DanhSachNVMouseClicked
        DefaultTableModel model = (DefaultTableModel) DanhSachNV.getModel();
        int Myindex = DanhSachNV.getSelectedRow();
        mnv.setText(model.getValueAt(Myindex, 0).toString());
        tennv.setText(model.getValueAt(Myindex, 1).toString());
        nsnv.setText(model.getValueAt(Myindex, 2).toString());
        gmailnv.setText(model.getValueAt(Myindex, 3).toString());
        dcnv.setText(model.getValueAt(Myindex, 4).toString());
    }//GEN-LAST:event_DanhSachNVMouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        showDL119();
    }//GEN-LAST:event_formComponentShown

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        LoadItem119();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
      QLSP sp119 = new QLSP();
      sp119.setVisible(true);
      dispose();
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        QLDM dm119 = new QLDM();
        dm119.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        QLHD hd119 = new QLHD();
        hd119.setVisible(true);
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
            java.util.logging.Logger.getLogger(QLNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DanhSachNV;
    private javax.swing.JButton Lammoi;
    private javax.swing.JButton btndx04;
    private javax.swing.JComboBox<String> chucvu;
    private javax.swing.JTextField dcnv;
    private javax.swing.JTextField gmailnv;
    private javax.swing.JComboBox<String> gtnv;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mnv;
    private javax.swing.JTextField nsnv;
    private javax.swing.JTextField sdtnv;
    private javax.swing.JTextField search;
    private javax.swing.JTextField tennv;
    private javax.swing.JButton xoa;
    // End of variables declaration//GEN-END:variables
}
