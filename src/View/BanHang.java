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
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thanh Cuong
 */
public final class BanHang extends javax.swing.JFrame {

    Statement st204 = null;
    ResultSet rs204 = null;
    int i204 = 1;
    double Thanhtien204 = 0;
    double thanhtien204;
    int slhientai204; //sl hien tai trong bang San Pham
    int slsauban204;   // sl con lai sau khi them san pham vao bang mua hang
    int slmua204;  // sl mua trong bang mua hang
    int idspmua204; //idsp mua
    int slconsauxoasp204; //so luong con lai sau khi xoa san pham, cap nhap o bang san pham
    int slconlai204; //so luong con lai sau khi them vao bang mua hang
    double thanhtiensp204; //thanhtien 1 sp khi chon
    int MyindexBMH;
    DecimalFormat formatter204 = new DecimalFormat("###,###,###");

    public BanHang() {
        initComponents();
        showDuLieu();
        showDM();
    }

    @SuppressWarnings("unchecked")

    public void showDuLieu() {
        try {
            tblSanpham.removeAll();
            String[] arr204 = {"Tên sản phẩm", "Số lượng", "Đơn vị tính", "Giá bán", "Thành tiền", "Ghi chú"};
            DefaultTableModel model204 = new DefaultTableModel(arr204, 0);
            String sql204 = "select * from ChitietHD";
            Connection connection204 = JDBCConnection.getJDBCConnection();
            PreparedStatement ps204 = connection204.prepareStatement(sql204);
            rs204 = ps204.executeQuery();

            while (rs204.next()) {
                Vector vt204 = new Vector();
                vt204.add(rs204.getString("MaSP"));
                vt204.add(rs204.getString("TenSP"));
                vt204.add(rs204.getString("SoLuong"));
                vt204.add(rs204.getString("DonViTinh"));
                vt204.add(rs204.getInt("GiaBan"));
                vt204.add(rs204.getInt("ThanhTien"));
                vt204.add(rs204.getString("GhiChu"));
                model204.addRow(vt204);
            }
            tblSanpham.setModel(model204);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void showDuLieu1() {
        try {
            BangMuaHang.removeAll();
            String[] arr204 = {"Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn vị tính", "Giá bán", "Thành tiền", "Ghi chú"};

            DefaultTableModel model204 = new DefaultTableModel(arr204, 0);
            String sql204 = "select * from ChitietHD";
            Connection connection204 = JDBCConnection.getJDBCConnection();
            PreparedStatement ps204 = connection204.prepareStatement(sql204);
            rs204 = ps204.executeQuery();

            while (rs204.next()) {
                Vector vt204 = new Vector();
                vt204.add(rs204.getString("MaSP"));
                vt204.add(rs204.getString("TenSP"));
                vt204.add(rs204.getString("SoLuong"));
                vt204.add(rs204.getString("DonViTinh"));
                vt204.add(rs204.getInt("GiaBan"));
                vt204.add(rs204.getInt("ThanhTien"));
                vt204.add(rs204.getString("GhiChu"));
                model204.addRow(vt204);
            }
            BangMuaHang.setModel(model204);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void showDM() {
        try {
            String sql204 = "select * from DanhMucSP";
            Connection connection204 = JDBCConnection.getJDBCConnection();
            PreparedStatement ps204 = connection204.prepareStatement(sql204);
            rs204 = ps204.executeQuery();
            while (rs204.next()) {
                String ten204 = rs204.getString("MaDM");
                DMSP.addItem(ten204);
            }
            LoadItem();
            showDuLieu();
            showDuLieu1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearTable() {
        DefaultTableModel dm204 = (DefaultTableModel) tblSanpham.getModel();
        while (dm204.getRowCount() > 0) {
            dm204.removeRow(0);
        }
    }

    public void clearTable1() {
        DefaultTableModel dm204 = (DefaultTableModel) BangMuaHang.getModel();
        while (dm204.getRowCount() > 0) {
            dm204.removeRow(0);
        }
    }

    public void updatemua() {
        slsauban204 = Integer.parseInt(slht.getText()) - Integer.parseInt(txtSL04.getText());
        try {

            String sql204 = "Update SanPham set SoLuong='" + slsauban204 + "'" + " where MaSP=" + txtMasp.getText();
            Connection connection204 = JDBCConnection.getJDBCConnection();
            Statement add04 = connection204.createStatement();
            add04.executeUpdate(sql204);
            showDuLieu();
            JOptionPane.showMessageDialog(this, "Cập nhật thành công số lượng sản phẩm sau khi bán!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void LoadItem() {
        try {
            BangMuaHang.removeAll();
            tblSanpham.removeAll();
            Connection connection204 = JDBCConnection.getJDBCConnection();
            String sql204 = "Select *from SanPham where MaSP=N'" + txtMasp.getText().toString() + "'";
            PreparedStatement ps04 = connection204.prepareStatement(sql204);
            rs204 = ps04.executeQuery();
            if (rs204.next()) {
                txtMasp.setText(rs204.getString("MaSP"));
                txtTensp04.setText(rs204.getString("TenSP"));
                slht.setText(rs204.getString("SoLuong"));
                txtDVT04.setText(rs204.getString("DonViTinh"));
                txtGB04.setText(rs204.getString("GiaGoc"));
                txtTT204.setText(rs204.getString("GiaBan"));
                txtGC04.setText(rs204.getString("GhiChu"));
            } else {
                txtMasp.setText("");
                txtTensp04.setText("");
                txtSL04.setText("");
                txtDVT04.setText("");
                txtGB04.setText("");
                txtTT204.setText("");
                txtGC04.setText("");
            }
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
        jLabel15 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        DMSP = new javax.swing.JComboBox<>();
        btnLoc04 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanpham = new javax.swing.JTable();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        txtCK04 = new javax.swing.JTextField();
        BtnHuyHD04 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtbs04 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txttthu04 = new javax.swing.JTextField();
        txttra04 = new javax.swing.JTextField();
        BtnHuyHD5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btndx5 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        tenkhachhang1 = new javax.swing.JTextField();
        tenkhachhang = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        khachhang = new javax.swing.JLabel();
        mahoa = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        diachi = new javax.swing.JLabel();
        ngayban = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        BangMuaHang = new javax.swing.JTable();
        tt = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        slht1 = new javax.swing.JLabel();
        slht = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMasp = new javax.swing.JTextField();
        txtTensp04 = new javax.swing.JTextField();
        txtSL04 = new javax.swing.JTextField();
        txtDVT04 = new javax.swing.JTextField();
        txtGB04 = new javax.swing.JTextField();
        txtTT204 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtGC04 = new javax.swing.JTextField();
        btnThem204 = new javax.swing.JButton();
        btnXoa204 = new javax.swing.JButton();
        btnlammoi204 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        txtMaHD204 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
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
                .addGap(3, 3, 3)
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
        jLabel7.setText("BÁN HÀNG");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 153, 0));
        jLabel15.setText("DANH SÁCH SẢN PHẨM");

        jLabel10.setText("Lọc theo");

        DMSP.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                DMSPPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        DMSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DMSPActionPerformed(evt);
            }
        });

        btnLoc04.setText("Lọc");
        btnLoc04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoc04ActionPerformed(evt);
            }
        });

        tblSanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn vị tính", "Giá gốc", "Giá bán", "Ghi chú"
            }
        ));
        tblSanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanphamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanpham);

        jCheckBox1.setText("Không in hóa đơn");

        jLabel9.setText("Chiết khấu");

        txtCK04.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtCK04MouseEntered(evt);
            }
        });

        BtnHuyHD04.setBackground(new java.awt.Color(255, 0, 0));
        BtnHuyHD04.setText("Hủy  đơn");
        BtnHuyHD04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHuyHD04ActionPerformed(evt);
            }
        });

        jLabel11.setText("Bằng chữ");

        jLabel12.setText("Bằng số");

        txtbs04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbs04ActionPerformed(evt);
            }
        });

        jLabel14.setText("Tiền trả");

        jLabel13.setText("Tiền thu");

        txttthu04.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txttthu04MouseEntered(evt);
            }
        });
        txttthu04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttthu04ActionPerformed(evt);
            }
        });

        txttra04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttra04ActionPerformed(evt);
            }
        });

        BtnHuyHD5.setBackground(new java.awt.Color(255, 255, 0));
        BtnHuyHD5.setText("Xem trước");
        BtnHuyHD5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHuyHD5ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 255, 51));
        jButton2.setText("Thanh toán");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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

        jLabel22.setText("Tên Khách Hàng");

        jLabel23.setText("Địa chỉ");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa Đơn"));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 153, 0));
        jLabel16.setText("HÓA ĐƠN THANH TOÁN");

        jLabel21.setText("Mã hóa đơn :");

        jLabel24.setText("Tên khách hàng :");

        khachhang.setText("jLabel4");

        mahoa.setText("jLabel4");

        jLabel25.setText("Ngày bán hàng:");

        jLabel26.setText("Địa chỉ :");

        diachi.setText("jLabel4");

        ngayban.setText("jLabel10");

        BangMuaHang.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(BangMuaHang);

        tt.setText("Thành tiền");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(209, 209, 209)
                                .addComponent(jLabel16))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addGap(18, 18, 18)
                                        .addComponent(khachhang))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addGap(38, 38, 38)
                                        .addComponent(mahoa)))
                                .addGap(172, 172, 172)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addGap(60, 60, 60)
                                        .addComponent(diachi))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel25)
                                        .addGap(18, 18, 18)
                                        .addComponent(ngayban)))))
                        .addGap(0, 56, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tt)
                .addGap(85, 85, 85))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel25)
                    .addComponent(mahoa)
                    .addComponent(ngayban))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel26)
                    .addComponent(khachhang)
                    .addComponent(diachi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(tt)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Mã sản phẩm :");

        jLabel2.setText("Tên sản phẩm :");

        jLabel3.setText("Số lượng          :");

        slht1.setText("Số lượng hiện tại");

        slht.setText("sl");

        jLabel4.setText("Thành tiền :");

        jLabel5.setText("Giá bán :");

        jLabel6.setText("Đơn vị tính");

        jLabel8.setText("Ghi chú :");

        btnThem204.setText("Thêm");
        btnThem204.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThem204MouseClicked(evt);
            }
        });
        btnThem204.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem204ActionPerformed(evt);
            }
        });

        btnXoa204.setText("Xóa");
        btnXoa204.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa204ActionPerformed(evt);
            }
        });

        btnlammoi204.setText("Làm mới");
        btnlammoi204.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlammoi204ActionPerformed(evt);
            }
        });

        jButton5.setText("Tìm kiếm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel27.setText("Mã hóa đơn :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSL04, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTensp04, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMasp, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMaHD204, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(slht1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(slht))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDVT04, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtGB04, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtTT204, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGC04, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnThem204, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnlammoi204, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnXoa204, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDVT04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtGC04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(txtMaHD204, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMasp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTensp04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtSL04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGB04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem204)
                            .addComponent(btnXoa204)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTT204, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnlammoi204)
                            .addComponent(jButton5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(slht)
                            .addComponent(slht1))))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel7)
                                        .addGap(146, 146, 146)))
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btndx5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel22)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tenkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel23)
                                                .addGap(63, 63, 63)
                                                .addComponent(tenkhachhang1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(26, 26, 26))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BtnHuyHD04, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCK04, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtbs04, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel14))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txttra04, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                            .addComponent(txttthu04))
                                        .addGap(38, 38, 38)
                                        .addComponent(BtnHuyHD5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(51, 51, 51)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(DMSP, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(43, 43, 43)
                                        .addComponent(btnLoc04))
                                    .addComponent(jLabel15))
                                .addGap(63, 63, 63))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(btndx5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tenkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(tenkhachhang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(7, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DMSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLoc04)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnHuyHD04, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(txtCK04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(txtbs04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(txttthu04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(txttra04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BtnHuyHD5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 624, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        QLNhanVien nv204 = new QLNhanVien();
        nv204.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        QLNCC ncc204 = new QLNCC();
        ncc204.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        QLKH kh204 = new QLKH();
        kh204.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton32ActionPerformed

    private void tblSanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanphamMouseClicked
        DefaultTableModel model204 = (DefaultTableModel) tblSanpham.getModel();
        int Myindex = tblSanpham.getSelectedRow();
        txtMasp.setText(model204.getValueAt(Myindex, 0).toString());
        txtTensp04.setText(model204.getValueAt(Myindex, 1).toString());
        txtSL04.setText(model204.getValueAt(Myindex, 2).toString());
        txtDVT04.setText(model204.getValueAt(Myindex, 3).toString());
        txtGB04.setText(model204.getValueAt(Myindex, 4).toString());
        txtTT204.setText(model204.getValueAt(Myindex, 5).toString());
        txtGC04.setText(model204.getValueAt(Myindex, 6).toString());
    }//GEN-LAST:event_tblSanphamMouseClicked

    private void BtnHuyHD5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHuyHD5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnHuyHD5ActionPerformed

    private void btndx5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndx5MouseClicked
        Login lg204 = new Login();
        lg204.setVisible(true);
        dispose();
    }//GEN-LAST:event_btndx5MouseClicked

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        QLTaiKhoan tk204 = new QLTaiKhoan();
        tk204.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton29ActionPerformed

    private void btndx5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndx5ActionPerformed
        Trangchu lg204 = new Trangchu();
        lg204.setVisible(true);
        dispose();
    }//GEN-LAST:event_btndx5ActionPerformed

    private void btnLoc04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoc04ActionPerformed

    }//GEN-LAST:event_btnLoc04ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        showDuLieu();
        LoadItem();
        updatemua();
    }//GEN-LAST:event_formComponentShown

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        BanHang bh204 = new BanHang();
        bh204.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        ThongKeDoanhThu tk04 = new ThongKeDoanhThu();
        tk04.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton36ActionPerformed

    private void DMSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DMSPActionPerformed

    }//GEN-LAST:event_DMSPActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DateFormat dateFormat204 = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date204 = new java.util.Date();
        try {
            Connection connection204 = JDBCConnection.getJDBCConnection();
            PreparedStatement add204 = connection204.prepareStatement("Set dateformat dmy insert into HoaDon values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            add204.setString(1, mahoa.getText());
            add204.setString(2, khachhang.getText());
            add204.setString(3, dateFormat204.format(date204));
            add204.setString(4, diachi.getText());
            int row204 = add204.executeUpdate();
            JOptionPane.showMessageDialog(this, "Thêm hóa đơn thành công!");
            //Tự động lấy maHD vừa thêm
            ResultSet rs204 = add204.getGeneratedKeys();
            while (rs204.next()) {
                int id = rs204.getInt(i204);
                txtMaHD204.setText(String.valueOf(id));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        mahoa.setText(txtMaHD204.getText());
        khachhang.setText(tenkhachhang.getText());
        ngayban.setText(dateFormat204.format(date204));
        diachi.setText(tenkhachhang1.getText());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void BtnHuyHD04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHuyHD04ActionPerformed
        String sql204 = "select count(MaHD) from ChiTietHD  where MaHD='" + Integer.parseInt(txtMaHD204.getText()) + "'";
        try {
            Connection connection204 = JDBCConnection.getJDBCConnection();
            PreparedStatement preparedStatement204 = connection204.prepareStatement(sql204);
            ResultSet rs204 = preparedStatement204.executeQuery();
            while (rs204.next()) {
                if (rs204.getInt(1) == 0) {
                    try {
                        String mahd204 = txtMaHD204.getText();
                        String sql1204 = "Delete from HoaDon where MaHD=" + mahd204;
                        Statement Add = connection204.createStatement();
                        Add.executeUpdate(sql1204);
                        JOptionPane.showMessageDialog(this, "Xóa Thành Công Hóa Đơn!");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Vui lòng xóa dữ liệu ở bảng mua hàng trước!");
                }

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_BtnHuyHD04ActionPerformed

    private void DMSPPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_DMSPPopupMenuWillBecomeInvisible

    }//GEN-LAST:event_DMSPPopupMenuWillBecomeInvisible

    private void txttthu04MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txttthu04MouseEntered


    }//GEN-LAST:event_txttthu04MouseEntered

    private void txttthu04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttthu04ActionPerformed
        double ttra204, tthu204, ck204;
        int sl204;
        sl204 = Integer.parseInt(txtSL04.getText());
        double giasp204, thanhtien204;
        giasp204 = Double.parseDouble(txtTT204.getText());
        thanhtien204 = sl204 * giasp204;
        tthu204 = Double.parseDouble(txttthu04.getText());
        ck204 = Double.parseDouble(txtCK04.getText());

        if (ck204 == 0) {
            ttra204 = tthu204 - Thanhtien204;
            txttra04.setText(String.valueOf(formatter204.format(ttra204) + " VNĐ"));
        } else {
            ttra204 = tthu204 - Thanhtien204 * ck204;
            txttra04.setText(String.valueOf(formatter204.format(ttra204) + " VNĐ"));
        }


    }//GEN-LAST:event_txttthu04ActionPerformed

    private void txtbs04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbs04ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbs04ActionPerformed

    private void btnThem204ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem204ActionPerformed
        int sl204;
        sl204 = Integer.parseInt(txtSL04.getText());
        double giasp204, thanhtien204;
        giasp204 = Double.parseDouble(txtTT204.getText());
        thanhtien204 = sl204 * giasp204;
        slhientai204 = Integer.parseInt(slht.getText());
        if (txtMasp.getText().equals("") || txtTensp04.getText().equals("") || txtSL04.getText().equals("") || txtGB04.getText().equals("") || txtTT204.getText().equals("") || txtDVT04.getText().equals("") || txtGC04.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống! Mời bạn chọn sản phẩm lại!");
        } else if (slhientai204 < sl204) {
            JOptionPane.showMessageDialog(this, "Không đủ sản phẩm để mua");
        } else {

            try {
                Connection connection204 = JDBCConnection.getJDBCConnection();
                PreparedStatement ps204 = connection204.prepareStatement("insert into ChitietHD values (?,?,?,?,?,?,?,?)");
                ps204.setString(1, txtMaHD204.getText());
                ps204.setString(2, txtMasp.getText());
                ps204.setString(3, txtTensp04.getText());
                ps204.setString(4, txtSL04.getText());
                ps204.setString(5, txtDVT04.getText());
                ps204.setString(6, txtGB04.getText());
                ps204.setString(7, txtTT204.getText());
                ps204.setString(8, txtGC04.getText());
                ps204.executeUpdate();
                clearTable();
                clearTable1();
                showDuLieu();
                showDuLieu1();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            Thanhtien204 = Thanhtien204 + thanhtien204;
            txtbs04.setText(String.valueOf(formatter204.format(Thanhtien204) + " VNĐ"));
            txtTT204.setText(String.valueOf(formatter204.format(Thanhtien204) + " VNĐ"));
            tt.setText(String.valueOf(formatter204.format(Thanhtien204) + " VNĐ"));
            updatemua();

        }


    }//GEN-LAST:event_btnThem204ActionPerformed

    private void btnXoa204ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa204ActionPerformed
        if (txtMasp.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chon  để xóa");
        } else {
            try {
                Connection connection204 = JDBCConnection.getJDBCConnection();
                PreparedStatement ps204 = connection204.prepareStatement("delete from ChitietHD where MaSP=?");
                ps204.setString(1, txtMasp.getText());
                ps204.executeUpdate();
                showDuLieu();
                showDuLieu1();
            } catch (Exception e) {
                e.printStackTrace();
            }
              DefaultTableModel model = (DefaultTableModel) tblSanpham.getModel();
            model.removeRow(MyindexBMH);
            //Thiet lap lai tong tien sau khi xoa
           Thanhtien204 = Thanhtien204 - thanhtien204;
            tt.setText(String.valueOf(formatter204.format(Thanhtien204) + " VNĐ"));

            //Lấy số lượng trong bảng sản phẩm hiện tại
            String sql = "select * from SanPham where MaSP=" + idspmua204;
            try {
                Connection connection204 = JDBCConnection.getJDBCConnection();
                PreparedStatement preparedStatement = connection204.prepareStatement(sql);
                ResultSet rs204 = preparedStatement.executeQuery();
                while (rs204.next()) {
                    slconlai204 = rs204.getInt("SoLuong");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            slconsauxoasp204 = slconlai204 + slmua204;
            //Update soluong sau khi xóa
            try {
                Connection connection204 = JDBCConnection.getJDBCConnection();
                String sql2204 = "Update SanPham set SoLuongCon='" + slconsauxoasp204 + "'" + " where MaSanPham=" + idspmua204;
                Statement Add = connection204.createStatement();
                Add.executeUpdate(sql2204);
                showDuLieu();
                JOptionPane.showMessageDialog(this, "Cập nhật thành công số lượng sản phẩm sau khi bán!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            idspmua204 = 0;

        }
    }//GEN-LAST:event_btnXoa204ActionPerformed

    private void btnlammoi204ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlammoi204ActionPerformed
        txtMaHD204.setText("");
        txtMasp.setText("");
        txtTensp04.setText("");
        txtSL04.setText("");
        txtDVT04.setText("");
        txtGB04.setText("");
        txtTT204.setText("");
        txtGC04.setText("");   
        Thanhtien204 = 0;
        txtbs04.setText(String.valueOf(formatter204.format(Thanhtien204) + " VNĐ")); 
        tt.setText(String.valueOf(formatter204.format(Thanhtien204) + " VNĐ"));
        clearTable();
        clearTable1();
    }//GEN-LAST:event_btnlammoi204ActionPerformed

    private void btnThem204MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThem204MouseClicked
        showDuLieu();
        DefaultTableModel model04 = (DefaultTableModel) tblSanpham.getModel();
        int Myindex = tblSanpham.getSelectedRow();
        String masp04, dv04;
        masp04 = model04.getValueAt(Myindex, 0).toString();
        dv04 = model04.getValueAt(Myindex, 3).toString();
        //Tinh thành tiền
        int sl;
        sl = Integer.parseInt(txtSL04.getText());
        double giasp04, thanhtien04;
        giasp04 = Double.parseDouble(txtTT204.getText());
        thanhtien04 = sl * giasp04;

    }//GEN-LAST:event_btnThem204MouseClicked

    private void txttra04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttra04ActionPerformed
        double ttra204, tthu204, ck204;
        int sl204;
        sl204 = Integer.parseInt(txtSL04.getText());
        double giasp204, thanhtien204;
        giasp204 = Double.parseDouble(txtTT204.getText());
        thanhtien204 = sl204 * giasp204;
        tthu204 = Double.parseDouble(txttthu04.getText());
        ck204 = Double.parseDouble(txtCK04.getText());

        if (ck204 == 0) {
            ttra204 = tthu204 - Thanhtien204;
            txttra04.setText(String.valueOf(formatter204.format(ttra204) + " VNĐ"));
        } else {
            ttra204 = tthu204 - Thanhtien204 * ck204;
            txttra04.setText(String.valueOf(formatter204.format(ttra204) + " VNĐ"));
        }

    }//GEN-LAST:event_txttra04ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        LoadItem();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtCK04MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCK04MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCK04MouseEntered

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        QLSP sp204 = new QLSP();
        sp204.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        QLDM dm204 = new QLDM();
        dm204.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        QLHD hd204= new QLHD();
        hd204.setVisible(true);
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
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BanHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BangMuaHang;
    private javax.swing.JButton BtnHuyHD04;
    private javax.swing.JButton BtnHuyHD5;
    private javax.swing.JComboBox<String> DMSP;
    private javax.swing.JButton btnLoc04;
    private javax.swing.JButton btnThem204;
    private javax.swing.JButton btnXoa204;
    private javax.swing.JButton btndx5;
    private javax.swing.JButton btnlammoi204;
    private javax.swing.JLabel diachi;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel khachhang;
    private javax.swing.JLabel mahoa;
    private javax.swing.JLabel ngayban;
    private javax.swing.JLabel slht;
    private javax.swing.JLabel slht1;
    private javax.swing.JTable tblSanpham;
    private javax.swing.JTextField tenkhachhang;
    private javax.swing.JTextField tenkhachhang1;
    private javax.swing.JLabel tt;
    private javax.swing.JTextField txtCK04;
    private javax.swing.JTextField txtDVT04;
    private javax.swing.JTextField txtGB04;
    private javax.swing.JTextField txtGC04;
    private javax.swing.JTextField txtMaHD204;
    private javax.swing.JTextField txtMasp;
    private javax.swing.JTextField txtSL04;
    private javax.swing.JTextField txtTT204;
    private javax.swing.JTextField txtTensp04;
    private javax.swing.JTextField txtbs04;
    private javax.swing.JTextField txttra04;
    private javax.swing.JTextField txttthu04;
    // End of variables declaration//GEN-END:variables
}
