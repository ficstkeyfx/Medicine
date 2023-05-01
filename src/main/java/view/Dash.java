package view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.MedicineModel;
import model.StatisticsModel;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import java.time.LocalDate;
import org.apache.commons.validator.GenericValidator;

/**
 *
 * @author PV
 */
public class Dash extends javax.swing.JFrame implements ActionListener{

    static boolean maximized = true;
    int xMouse;
    int yMouse;
    
    private String[] columns = new String [] {
                "ID", "Tên thuốc", "NSX", "HSD", "Số lô", "Số hàng", "Nguồn nhập"
            };
    private Object data = new Object [][] {};
    
    
    public Dash() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        pnlHeader = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        btnMaximize = new javax.swing.JButton();
        btnMinimize = new javax.swing.JButton();
        pnlMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnTimeline = new javax.swing.JButton();
        lblTimeline = new javax.swing.JLabel();
        btnNews = new javax.swing.JButton();
        lblNews = new javax.swing.JLabel();
        btnTrending = new javax.swing.JButton();
        lblTrending = new javax.swing.JLabel();
        btnQA = new javax.swing.JButton();
        lblQA = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        pnlBody = new javax.swing.JPanel();
        jspTimeline = new javax.swing.JScrollPane();
        pnlTimeline = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        pnlNews = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        
        
        idLabel = new JLabel("ID");
        nameLabel= new JLabel("Tên");
        productionSourceLabel = new JLabel("Nguồn nhập");
        NSXLabel = new JLabel("NSX");
        HSDLabel = new JLabel("HSD");
        idBillLabel = new JLabel("Số lô");
        idProductionLabel = new JLabel("Số hàng");
        
        idField = new JTextField(6); 
        idField.setEditable(false);
        nameField= new JTextField(15); 
        productionSourceField = new JTextField(15); 
        NSXField = new JTextField(10); 
        HSDField = new JTextField(10); 
        idBillField = new JTextField(15); 
        idProductionField = new JTextField(15); 
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cube UI");
        setUndecorated(true);
        setSize(new java.awt.Dimension(1200, 600));

        pnlHeader.setBackground(new java.awt.Color(255, 255, 255));
        pnlHeader.setForeground(new java.awt.Color(255, 255, 255));
        pnlHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlHeaderMouseDragged(evt);
            }
        });
        pnlHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlHeaderMousePressed(evt);
            }
        });

        btnExit.setIcon(new javax.swing.ImageIcon("src/main/java/Gambar/Exit.png")); // NOI18N
        btnExit.setContentAreaFilled(false);
        btnExit.setFocusable(false);
        btnExit.setOpaque(true);
        btnExit.setRolloverIcon(new javax.swing.ImageIcon("src/main/java/gambar/Exit (2).png")); // NOI18N
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnMaximize.setIcon(new javax.swing.ImageIcon("src/main/java/Gambar/Maximize.png")); // NOI18N
        btnMaximize.setContentAreaFilled(false);
        btnMaximize.setFocusable(false);
        btnMaximize.setOpaque(true);
        btnMaximize.setRolloverIcon(new javax.swing.ImageIcon("src/main/java/Gambar/Maximize (2).png")); // NOI18N
        btnMaximize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMaximizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMaximizeMouseExited(evt);
            }
        });
        btnMaximize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaximizeActionPerformed(evt);
            }
        });

        btnMinimize.setIcon(new javax.swing.ImageIcon("src/main/java/gambar/Minimize.png")); // NOI18N
        btnMinimize.setContentAreaFilled(false);
        btnMinimize.setFocusable(false);
        btnMinimize.setOpaque(true);
        btnMinimize.setRolloverIcon(new javax.swing.ImageIcon("src/main/java/gambar/Minimize (2).png")); // NOI18N
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseExited(evt);
            }
        });
        btnMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMaximize, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnMaximize, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        pnlMenu.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon("src/main/java/Gambar/User.png")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(44, 62, 80));
        jLabel2.setText("PHAN HAI DANG");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(127, 140, 141));
        jLabel3.setText("Admin");

//        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
//        jLabel5.setForeground(new java.awt.Color(52, 152, 219));
//        jLabel5.setText("Learn More");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

//        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        jLabel4.setForeground(new java.awt.Color(127, 140, 141));
//        jLabel4.setText("871k followers");

        btnTimeline.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 16)); // NOI18N
        btnTimeline.setForeground(new java.awt.Color(44, 62, 80));
        btnTimeline.setText("DASHBOARD");
        btnTimeline.setContentAreaFilled(false);
        btnTimeline.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimeline.setFocusable(false);
        btnTimeline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimelineActionPerformed(evt);
            }
        });

        lblTimeline.setBackground(new java.awt.Color(0, 204, 106));
        lblTimeline.setOpaque(true);

        btnNews.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 16)); // NOI18N
        btnNews.setForeground(new java.awt.Color(44, 62, 80));
        btnNews.setText("HOME");
        btnNews.setContentAreaFilled(false);
        btnNews.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNews.setFocusable(false);
        btnNews.setPreferredSize(new java.awt.Dimension(100, 27));
        btnNews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneralActionPerformed(evt);
            }
        });

        lblNews.setBackground(new java.awt.Color(255, 255, 255));
        lblNews.setOpaque(true);

        btnTrending.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 16)); // NOI18N
        btnTrending.setForeground(new java.awt.Color(44, 62, 80));
        btnTrending.setText("MANAGE");
        btnTrending.setContentAreaFilled(false);
        btnTrending.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTrending.setFocusable(false);
        btnTrending.setPreferredSize(new java.awt.Dimension(100, 27));
        btnTrending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageActionPerformed(evt);
            }
        });

        lblTrending.setBackground(new java.awt.Color(255, 255, 255));
        lblTrending.setOpaque(true);
        lblTrending.setPreferredSize(new java.awt.Dimension(100, 0));

        btnQA.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 16)); // NOI18N
        btnQA.setForeground(new java.awt.Color(44, 62, 80));
        btnQA.setText("STATISTIC");
        btnQA.setContentAreaFilled(false);
        btnQA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQA.setFocusable(false);
        btnQA.setPreferredSize(new java.awt.Dimension(100, 27));
        btnQA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatisticActionPerformed(evt);
            }
        });

        lblQA.setBackground(new java.awt.Color(255, 255, 255));
        lblQA.setOpaque(true);
        lblQA.setPreferredSize(new java.awt.Dimension(100, 0));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(127, 140, 141));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("You are login as Admin, ");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(52, 152, 219));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Logout ?");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTimeline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTimeline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(60, 60, 60)
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNews, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNews, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTrending, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(lblTrending, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(60, 60, 60)
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnQA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblQA, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMenuLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16))
                            .addComponent(jLabel4)
                            .addGroup(pnlMenuLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)))
                        .addGap(0, 0, 0)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18))))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2)
                        .addGap(5, 5, 5)
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4))
                    .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(jLabel17)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimeline)
                    .addComponent(btnNews, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTimeline, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNews, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                        .addComponent(btnTrending, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lblTrending, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                        .addComponent(btnQA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lblQA, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pnlBody.setLayout(new BorderLayout());

        jspTimeline.setBorder(null);
        jspTimeline.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlTimeline.setBackground(new java.awt.Color(245, 245, 245));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel6.setBackground(new java.awt.Color(0, 204, 106));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Home");
        jLabel6.setOpaque(true);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon("src/main/java/Gambar/file-viewer.png")); // NOI18N

        jLabel6.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    btnGeneralActionPerformed(e);
                }
        });
        jLabel11.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    btnGeneralActionPerformed(e);
                }
        });
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel7.setBackground(new java.awt.Color(52, 152, 219));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Manage");
        jLabel7.setOpaque(true);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon("src/main/java/Gambar/note.png")); // NOI18N
        jLabel7.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    btnManageActionPerformed(e);
                }
        });
        jLabel12.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    btnManageActionPerformed(e);
                }
        });
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel8.setBackground(new java.awt.Color(243, 156, 18));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Statistic");
        jLabel8.setOpaque(true);

        jLabel8.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    btnStatisticActionPerformed(e);
                }
        });
                
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon("src/main/java/Gambar/bar-chart.png")); // NOI18N

        jLabel13.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    btnStatisticActionPerformed(e);
                }
        });
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addContainerGap())
        );

//        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
//        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

//        jLabel9.setBackground(new java.awt.Color(149, 165, 166));
//        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
//        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//        jLabel9.setText("Visitors");
//        jLabel9.setOpaque(true);

//        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//        jLabel14.setIcon(new javax.swing.ImageIcon("src/main/java/Gambar/browser.png")); // NOI18N
//
//        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
//        jPanel4.setLayout(jPanel4Layout);
//        jPanel4Layout.setHorizontalGroup(
//            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
//            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
//                .addContainerGap()
//                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
//                .addContainerGap())
//        );
//        jPanel4Layout.setVerticalGroup(
//            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(jPanel4Layout.createSequentialGroup()
//                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
//                .addContainerGap())
//        );
//
//        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
//        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//
//        jLabel10.setBackground(new java.awt.Color(149, 165, 166));
//        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
//        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//        jLabel10.setText("Traffic");
//        jLabel10.setOpaque(true);
//
//        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//        jLabel15.setIcon(new javax.swing.ImageIcon("src/main/java/Gambar/bar-chart.png")); // NOI18N
//
//        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
//        jPanel5.setLayout(jPanel5Layout);
//        jPanel5Layout.setHorizontalGroup(
//            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
//            .addGroup(jPanel5Layout.createSequentialGroup()
//                .addContainerGap()
//                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
//                .addContainerGap())
//        );
//        jPanel5Layout.setVerticalGroup(
//            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(jPanel5Layout.createSequentialGroup()
//                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
//                .addContainerGap())
//        );

        javax.swing.GroupLayout pnlTimelineLayout = new javax.swing.GroupLayout(pnlTimeline);
        pnlTimeline.setLayout(pnlTimelineLayout);
        pnlTimelineLayout.setHorizontalGroup(
            pnlTimelineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimelineLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(pnlTimelineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(pnlTimelineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTimelineLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlTimelineLayout.setVerticalGroup(
            pnlTimelineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimelineLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(pnlTimelineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(pnlTimelineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jspTimeline.setViewportView(pnlTimeline);

        pnlBody.add(jspTimeline);

//        pnlNews.setBackground(new java.awt.Color(245, 245, 245));

        jLabel18.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(44, 62, 80));
        jLabel18.setText("NEWS");
        
        // Table
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        
        
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            (Object[][]) data,
            columns
        ));
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        jTable1.getTableHeader().setOpaque(true);
        jTable1.getTableHeader().setBackground(new Color(32, 136, 203));
        jTable1.getTableHeader().setForeground(new Color(255,255,255));
        jTable1.setRowHeight(25);
        jTable1.setFocusable(false);
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(232, 57, 95));
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        
        searchField = new JTextField(80);
//        searchField.setOpaque(false);
//        searchField.setFont(new Font("Calibri", 3, 18));
//        searchField.setBorder(null);
//        searchField.setSize(5,5);
//        jScrollPane1.add(searchField);

//        searchField.setBounds(0, 0, 200, 25);
        String[] optionsToChoose = {"ID", "Tên", "NSX", "HSD", "Số lô", "Số hàng", "Nguồn nhập"};
        typeSearch = new JComboBox<String>(optionsToChoose);
        pnlSearch = new JPanel();
        pnlSearch.setLayout(new BorderLayout());
        pnlSearch.add(searchField, BorderLayout.WEST);
        pnlSearch.add(typeSearch, BorderLayout.CENTER);
        searchButton = new JButton("Search");
        pnlSearch.add(searchButton, BorderLayout.EAST);

        // Manage
        pnlManage = new JPanel();
        pnlManage.setLayout(new BorderLayout());
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        editButton = new JButton("Edit");
        
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        
        pnlManage.add(buttonPanel, BorderLayout.SOUTH);
        
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);
        
        //
        pnlSort = new JPanel();
        pnlSort.setLayout(new BorderLayout());
        sortButton = new JButton("Sort");
        typeSort = new JComboBox<String>(optionsToChoose);
        JPanel sortPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        sortPanel.add(typeSort);
        sortPanel.add(sortButton);
        pnlSort.add(sortPanel,BorderLayout.SOUTH);
        
        
        
        
        //
        managePanel = new JPanel();
//        managePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        managePanel.setSize(50,50);
        SpringLayout manageLayout = new SpringLayout();
        managePanel.setLayout(manageLayout);
        
        managePanel.add(idLabel);
        managePanel.add(nameLabel);
        managePanel.add(NSXLabel);
        managePanel.add(HSDLabel);
        managePanel.add(idBillLabel);
        managePanel.add(idProductionLabel);
        managePanel.add(productionSourceLabel);
        managePanel.add(idField);
        managePanel.add(nameField);
        managePanel.add(NSXField);
        managePanel.add(HSDField);
        managePanel.add(idBillField);
        managePanel.add(idProductionField);
        managePanel.add(productionSourceField);
        
        
        manageLayout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, managePanel);
        manageLayout.putConstraint(SpringLayout.NORTH, idLabel, 10, SpringLayout.NORTH, managePanel);
        manageLayout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, managePanel);
        manageLayout.putConstraint(SpringLayout.NORTH, nameLabel, 40, SpringLayout.NORTH, managePanel);
        manageLayout.putConstraint(SpringLayout.WEST, NSXLabel, 10, SpringLayout.WEST, managePanel);
        manageLayout.putConstraint(SpringLayout.NORTH, NSXLabel, 70, SpringLayout.NORTH, managePanel);
        manageLayout.putConstraint(SpringLayout.WEST, HSDLabel, 10, SpringLayout.WEST, managePanel);
        manageLayout.putConstraint(SpringLayout.NORTH, HSDLabel, 100, SpringLayout.NORTH, managePanel);
        manageLayout.putConstraint(SpringLayout.WEST, idBillLabel, 10, SpringLayout.WEST, managePanel);
        manageLayout.putConstraint(SpringLayout.NORTH, idBillLabel, 130, SpringLayout.NORTH, managePanel);
        manageLayout.putConstraint(SpringLayout.WEST, idProductionLabel, 10, SpringLayout.WEST, managePanel);
        manageLayout.putConstraint(SpringLayout.NORTH, idProductionLabel, 160, SpringLayout.NORTH, managePanel);
        manageLayout.putConstraint(SpringLayout.WEST, productionSourceLabel, 10, SpringLayout.WEST, managePanel);
        manageLayout.putConstraint(SpringLayout.NORTH, productionSourceLabel, 190, SpringLayout.NORTH, managePanel);
        
        manageLayout.putConstraint(SpringLayout.WEST, idField, 100, SpringLayout.WEST, managePanel);
        manageLayout.putConstraint(SpringLayout.NORTH, idField, 10, SpringLayout.NORTH, managePanel);
        manageLayout.putConstraint(SpringLayout.WEST, nameField, 100, SpringLayout.WEST, managePanel);
        manageLayout.putConstraint(SpringLayout.NORTH, nameField, 40, SpringLayout.NORTH, managePanel);
        manageLayout.putConstraint(SpringLayout.WEST, NSXField, 100, SpringLayout.WEST, managePanel);
        manageLayout.putConstraint(SpringLayout.NORTH, NSXField, 70, SpringLayout.NORTH, managePanel);
        manageLayout.putConstraint(SpringLayout.WEST, HSDField, 100, SpringLayout.WEST, managePanel);
        manageLayout.putConstraint(SpringLayout.NORTH, HSDField, 100, SpringLayout.NORTH, managePanel);
        manageLayout.putConstraint(SpringLayout.WEST, idBillField, 100, SpringLayout.WEST, managePanel);
        manageLayout.putConstraint(SpringLayout.NORTH, idBillField, 130, SpringLayout.NORTH, managePanel);
        manageLayout.putConstraint(SpringLayout.WEST, idProductionField, 100, SpringLayout.WEST, managePanel);
        manageLayout.putConstraint(SpringLayout.NORTH, idProductionField, 160, SpringLayout.NORTH, managePanel);
        manageLayout.putConstraint(SpringLayout.WEST, productionSourceField, 100, SpringLayout.WEST, managePanel);
        manageLayout.putConstraint(SpringLayout.NORTH, productionSourceField, 190, SpringLayout.NORTH, managePanel);
        
        manageCenterPanel = new JPanel();
        manageCenterPanel.setLayout(new GridLayout(1, 2));
        manageCenterPanel.add(jScrollPane1);
        manageCenterPanel.add(managePanel);
//        pnlBody.add(pnlSearch);
//        
//        pnlBody.add(jScrollPane1);
//        javax.swing.GroupLayout pnlNewsLayout = new javax.swing.GroupLayout(pnlNews);
//        pnlNews.setLayout(pnlNewsLayout);
//        pnlNewsLayout.setHorizontalGroup(
//            pnlNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(pnlNewsLayout.createSequentialGroup()
//                .addGap(70, 70, 70)
//                .addGroup(pnlNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addComponent(jLabel18)
//                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addContainerGap(60, Short.MAX_VALUE))
//        );
//        pnlNewsLayout.setVerticalGroup(
//            pnlNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(pnlNewsLayout.createSequentialGroup()
//                .addGap(50, 50, 50)
//                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addGap(0, 0, 0)
//                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addContainerGap(300, Short.MAX_VALUE))
//        );

//        pnlBody.add(pnlNews, "card4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlBody, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlBody, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1000, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {                                     
        btnExit.setBackground(new Color(232,17,35));
    }                                    

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {                                    
        btnExit.setBackground(new Color(255,255,255));
    }                                   

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {                                        
        System.exit(0);
    }                                       

    private void btnMaximizeMouseEntered(java.awt.event.MouseEvent evt) {                                         
        btnMaximize.setBackground(new Color(229,229,229));
    }                                        

    private void btnMaximizeMouseExited(java.awt.event.MouseEvent evt) {                                        
        btnMaximize.setBackground(new Color(255,255,255));
    }                                       

    private void btnMaximizeActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if(maximized){
            //handle fullscreen - taskbar
            Dash.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
            Dash.this.setMaximizedBounds(env.getMaximumWindowBounds());
            maximized = false;
        }else{
            setExtendedState(JFrame.NORMAL);
            maximized = true;
        }
    }                                           

    private void btnMinimizeMouseEntered(java.awt.event.MouseEvent evt) {                                         
        btnMinimize.setBackground(new Color(229,229,229));
    }                                        

    private void btnMinimizeMouseExited(java.awt.event.MouseEvent evt) {                                        
        btnMinimize.setBackground(new Color(255,255,255));
    }                                       

    private void btnMinimizeActionPerformed(java.awt.event.ActionEvent evt) {                                            
        this.setState(Frame.ICONIFIED);
    }                                           

    private void pnlHeaderMousePressed(java.awt.event.MouseEvent evt) {                                       
        xMouse = evt.getX();
        yMouse = evt.getY();
    }                                      

    private void pnlHeaderMouseDragged(java.awt.event.MouseEvent evt) {                                       
        if(maximized){
            int x = evt.getXOnScreen();
            int y = evt.getYOnScreen();
            this.setLocation(x - xMouse, y - yMouse);
        }
    }                     
    
    public void addGeneralListener(ActionListener listener) {
        btnNews.addActionListener(listener);
        btnTrending.addActionListener(listener);
    }
    
    public void addGeneralListener(MouseListener listener) {
        jLabel6.addMouseListener(listener);
        jLabel7.addMouseListener(listener);
        jLabel11.addMouseListener(listener);
        jLabel12.addMouseListener(listener);
    }

    public void btnGeneralActionPerformed(java.awt.event.ActionEvent evt) {                                        
        lblNews.setBackground(new Color(0,204,106));
        
        lblTimeline.setBackground(new Color(255,255,255));
        lblTrending.setBackground(new Color(255,255,255));
        lblQA.setBackground(new Color(255,255,255));
        pnlBody.setLayout(new BorderLayout());
        
        pnlBody.removeAll();
        pnlBody.repaint();
        pnlBody.revalidate();
        pnlBody.add(pnlSearch, BorderLayout.NORTH);
        pnlBody.add(jScrollPane1, BorderLayout.CENTER);
        pnlBody.add(pnlSort, BorderLayout.SOUTH);
        pnlBody.repaint();
        pnlBody.revalidate();
    }        
    private void btnGeneralActionPerformed(MouseEvent e) {                                        
        lblNews.setBackground(new Color(0,204,106));
        
        lblTimeline.setBackground(new Color(255,255,255));
        lblTrending.setBackground(new Color(255,255,255));
        lblQA.setBackground(new Color(255,255,255));
        
        
        pnlBody.removeAll();
        pnlBody.repaint();
        pnlBody.revalidate();
        pnlBody.setLayout(new BorderLayout());
        pnlBody.add(pnlSearch, BorderLayout.NORTH);
        pnlBody.add(jScrollPane1, BorderLayout.CENTER);
        pnlBody.add(pnlSort, BorderLayout.SOUTH);
        pnlBody.repaint();
        pnlBody.revalidate();
    }  

    private void btnManageActionPerformed(java.awt.event.ActionEvent evt) {                                            
        lblTrending.setBackground(new Color(0,204,106));
        
        lblTimeline.setBackground(new Color(255,255,255));
        lblNews.setBackground(new Color(255,255,255));
        lblQA.setBackground(new Color(255,255,255));
        
        pnlBody.removeAll();
        pnlBody.repaint();
        pnlBody.revalidate();
        pnlBody.setLayout(new BorderLayout());
        pnlBody.add(pnlSearch, BorderLayout.NORTH);
//        pnlBody.add(manageCenterPanel, BorderLayout.CENTER);
        pnlBody.add(jScrollPane1,BorderLayout.CENTER);
        pnlBody.add(pnlManage, BorderLayout.SOUTH);
        pnlBody.repaint();
        pnlBody.revalidate();
    }        
    private void btnManageActionPerformed(MouseEvent e) {
        lblTrending.setBackground(new Color(0,204,106));
        
        lblTimeline.setBackground(new Color(255,255,255));
        lblNews.setBackground(new Color(255,255,255));
        lblQA.setBackground(new Color(255,255,255));
        
        pnlBody.removeAll();
        pnlBody.repaint();
        pnlBody.revalidate();
        pnlBody.setLayout(new BorderLayout());
        pnlBody.add(pnlSearch, BorderLayout.NORTH);
        pnlBody.add(jScrollPane1,BorderLayout.CENTER);
//        pnlBody.add(managePanel,BorderLayout.CENTER);
        pnlBody.add(pnlManage,BorderLayout.SOUTH);
        pnlBody.repaint();
        pnlBody.revalidate();
    }

      

    private void btnTimelineActionPerformed(java.awt.event.ActionEvent evt) {                                            
        lblTimeline.setBackground(new Color(0,204,106));
        
        lblQA.setBackground(new Color(255,255,255));
        lblNews.setBackground(new Color(255,255,255));
        lblTrending.setBackground(new Color(255,255,255));
        pnlBody.setLayout(new BorderLayout());
        pnlBody.removeAll();
        pnlBody.repaint();
        pnlBody.revalidate();
        pnlBody.add(jspTimeline);
        pnlBody.repaint();
        pnlBody.revalidate();
    }                   
    
    public void addsearchButtonListener(ActionListener listener) {
        searchButton.addActionListener(listener);
    }
    
    public void addAddButtonListener(ActionListener listener){
        addButton.addActionListener(listener);
    }
    
    public void addEditButtonListener(ActionListener listener){
        editButton.addActionListener(listener);
    }
    
    public void addDeleteButtonListener(ActionListener listener){
        deleteButton.addActionListener(listener);
    }

   public void showListmMedicines(List<MedicineModel> list) {
        int size = list.size();
        Object [][] medicines = new Object[size][7];
        for (int i = 0; i < size; i++) {
            medicines[i][0] = list.get(i).getId();
            medicines[i][1] = list.get(i).getName();
            medicines[i][2] = list.get(i).getNSX();
            medicines[i][3] = list.get(i).getHSD();
            medicines[i][4] = list.get(i).getIdBill();
            medicines[i][5] = list.get(i).getIdProduction();
            medicines[i][6] = list.get(i).getProductionSource();
        }
        jTable1.setModel(new DefaultTableModel(medicines, columns));
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Dash().setVisible(true);
        });
    }
    
    public void fillMedicinetFromSelectedRow() {
        // lấy chỉ số của hàng được chọn 
        int row = jTable1.getSelectedRow();
        if (row >= 0) {
            idField.setText(jTable1.getModel().getValueAt(row, 0).toString());
            nameField.setText(jTable1.getModel().getValueAt(row, 1).toString());
            NSXField.setText(jTable1.getModel().getValueAt(row, 2).toString());
            HSDField.setText(jTable1.getModel().getValueAt(row, 3).toString());
            idBillField.setText(jTable1.getModel().getValueAt(row, 4).toString());            
            idProductionField.setText(jTable1.getModel().getValueAt(row, 5).toString());
            productionSourceField.setText(jTable1.getModel().getValueAt(row, 6).toString());
            // enable Edit and Delete buttons
            editButton.setEnabled(true);
            deleteButton.setEnabled(true);
            // disable Add button
            addButton.setEnabled(true);
        }
    }
    
    public void showMedicine(MedicineModel student) {
        idField.setText("" + student.getId());
        nameField.setText(student.getName());
        NSXField.setText("" + student.getNSX());
        HSDField.setText(student.getHSD());
        idBillField.setText("" + student.getIdBill());
        idProductionField.setText("" + student.getIdProduction());
        productionSourceField.setText("" + student.getProductionSource());
        // enable Edit and Delete buttons
        editButton.setEnabled(true);
        deleteButton.setEnabled(true);
        // disable Add button
        addButton.setEnabled(false);
    }
    
    private void manageButtonListener(){
        pnlBody.removeAll();
        pnlBody.repaint();
        pnlBody.revalidate();
        pnlBody.add(pnlSearch, BorderLayout.NORTH);
        manageCenterPanel = new JPanel();
        manageCenterPanel.setLayout(new GridLayout(1, 2));
        manageCenterPanel.add(jScrollPane1);
        manageCenterPanel.add(managePanel);
        
        pnlBody.add(manageCenterPanel,BorderLayout.CENTER);
//        pnlBody.add(managePanel,BorderLayout.CENTER);
        pnlBody.add(pnlManage,BorderLayout.SOUTH);
        pnlBody.repaint();
        pnlBody.revalidate();
    }
    
    public MedicineModel getMedicineInfo() {
        // validate student
        if (!validateName() || !validateNSX() || !validateHSD() || !validateIdBill() || !validateIdProduction() || !validateProductionSource()) {
            return null;
        }
        try {
            MedicineModel medicine = new MedicineModel();
            if (idField.getText() != null && !"".equals(idField.getText())) {
                medicine.setId(Integer.parseInt(idField.getText()));
            }
            medicine.setName(nameField.getText().trim());
            medicine.setNSX(NSXField.getText().trim());
            medicine.setHSD(HSDField.getText().trim());
            medicine.setIdBill(idBillField.getText().trim());
            medicine.setIdProduction(idProductionField.getText().trim());
            medicine.setProductionSource(productionSourceField.getText().trim());
            return medicine;
        } catch (Exception e) {
            //showMessage(e.getMessage());
        }
        return null;
    }
    
    public void addListMedicineSelectionListener(ListSelectionListener listener) {
        jTable1.getSelectionModel().addListSelectionListener(listener);
    }
    
    public void addAddMedicineListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }
    
    public void removeAddMedicineListener(ActionListener listener){
        addButton.removeActionListener(listener);
    }
    
    public void addEdiMedicineListener(ActionListener listener) {
        editButton.addActionListener(listener);
    }
    
    public void removeEditMedicineListener(ActionListener listener){
        editButton.removeActionListener(listener);
    }
    
    public void addDeleteMedicineListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }
    
    public void addSortButtonListener(ActionListener listener){
        sortButton.addActionListener(listener);
    }
    
    public String getTypeSort(){
        return (String) typeSort.getSelectedItem();
    }
    
    public void removeAllMedicineListener(){
        for(ActionListener listener:addButton.getActionListeners()){
            addButton.removeActionListener(listener);
        }
        for(ActionListener listener:editButton.getActionListeners()){
            editButton.removeActionListener(listener);
        }
        addButton.addActionListener((ActionEvent e) -> {
            manageButtonListener();
        });
        editButton.addActionListener((ActionEvent e) -> {
            manageButtonListener();
        });
    }

    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnMaximize;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnNews;
    private javax.swing.JButton btnQA;
    private javax.swing.JButton btnTimeline;
    private javax.swing.JButton btnTrending;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JScrollPane jspTimeline;
    private javax.swing.JLabel lblNews;
    private javax.swing.JLabel lblQA;
    private javax.swing.JLabel lblTimeline;
    private javax.swing.JLabel lblTrending;
    private javax.swing.JPanel pnlBody;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlNews;
    private javax.swing.JPanel pnlTimeline;
    
    // table 
    private javax.swing.JLabel jLabelTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    
    // search
    private JTextField searchField;
    private JPanel pnlSearch;
    private JButton searchButton;
    JComboBox<String> typeSearch;
    
    // Sort
    JComboBox<String> typeSort;
    private JPanel pnlSort;
    private JButton sortButton;
    
    // Manage
    private JPanel pnlManage;
    private JButton editButton;
    private JButton deleteButton;
    private JButton addButton;
    private JPanel buttonPanel;
    private JPanel managePanel;
    private JPanel manageCenterPanel;
    
    private JLabel idLabel, nameLabel,productionSourceLabel, NSXLabel, HSDLabel,idBillLabel,idProductionLabel;
    private JTextField idField, nameField,productionSourceField, NSXField, HSDField,idBillField,idProductionField;
    
    public String getTypeSearch() {
        return (String) typeSearch.getSelectedItem();
    }    
    
    public String getSearchField(){
        return searchField.getText();
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    private boolean validateName() {
        String name = nameField.getText();
        if (name == null || "".equals(name.trim())) {
            nameField.requestFocus();
            showMessage("Tên không được trống.");
            return false;
        }
        return true;
    }

    private boolean validateNSX() {
        String nsx = NSXField.getText();
        if (nsx == null || "".equals(nsx.trim())) {
            NSXField.requestFocus();
            showMessage("NSX không được trống.");
            return false;
        }
        if(!GenericValidator.isDate(nsx, "dd/MM/yyyy", true))
        {
            NSXField.requestFocus();
            showMessage("Nhập sai ngày, định dạng ngày/tháng/năm");
            return false;
        }
        return true;    
    }

    private boolean validateHSD() {
        String hsd = HSDField.getText();
        if (hsd == null || "".equals(hsd.trim())) {
            HSDField.requestFocus();
            showMessage("HSD không được trống.");
            return false;
        }
        if(!GenericValidator.isDate(hsd, "dd/MM/yyyy", true))
        {
            NSXField.requestFocus();
            showMessage("Nhập sai ngày, định dạng ngày/tháng/năm");
            return false;
        }
        return true;   
    }

    private boolean validateIdBill() {
        String idBill = idBillField.getText();
        if (idBill == null || "".equals(idBill.trim())) {
            idBillField.requestFocus();
            showMessage("Số lô không được trống.");
            return false;
        }
        return true;   
    }

    private boolean validateIdProduction() {
        String idProduction = idProductionField.getText();
        if (idProduction == null || "".equals(idProduction.trim())) {
            idProductionField.requestFocus();
            showMessage("Số hàng không được trống.");
            return false;
        }
        return true;     
    }

    private boolean validateProductionSource() {
        String productionSource = productionSourceField.getText();
        if (productionSource == null || "".equals(productionSource.trim())) {
            productionSourceField.requestFocus();
            showMessage("Nguồn nhập không được trống.");
            return false;
        }
        return true; 
    }
    
    public void clearMedicinetInfo() {
        idField.setText("");
        nameField.setText("");
        NSXField.setText("");
        HSDField.setText("");
        idBillField.setText("");
        idProductionField.setText("");
        productionSourceField.setText("");
        // disable Edit and Delete buttons
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);
        // enable Add button
        addButton.setEnabled(true);
    }
    
    JFreeChart chart;
    ChartPanel chartPanel;
    
    
    public void showLineChart(List<StatisticsModel> lsStatisticsModels){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        LocalDate localDate = LocalDate.now();
        String x = String.valueOf(localDate.getMonth());
        
        for(StatisticsModel statisticsModel:lsStatisticsModels){
            
            dataset.addValue(statisticsModel.getValue(), "Month", statisticsModel.getMonth());
            if(x.equals(statisticsModel.getMonth())) break;
        }
        
        chart = ChartFactory.createLineChart(
            "THEO THÁNG",
            "Tháng",
            "Sản phẩm",
            dataset,
            PlotOrientation.VERTICAL,
            false,
            true,
            false
        );
        chart.setBackgroundPaint(new GradientPaint(0, 0, Color.white, 0, getHeight(), new Color(220, 220, 220)));
        chart.getTitle().setPaint(new Color(72, 72, 72));
        chart.getTitle().setFont(new Font("Calibri", Font.BOLD, 18));
        chart.getCategoryPlot().getRangeAxis().setTickLabelFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 12));
        chart.getCategoryPlot().getDomainAxis().setTickLabelFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 12));
        chart.getCategoryPlot().setOutlineVisible(false);
        chart.getCategoryPlot().setBackgroundPaint(Color.white);
        chart.getCategoryPlot().setRangeGridlinePaint(new Color(220, 220, 220));
        chart.getCategoryPlot().setDomainGridlinePaint(new Color(220, 220, 220));
        chart.getCategoryPlot().getRenderer().setSeriesStroke(0, new BasicStroke(2.0f));
        chart.getCategoryPlot().getRenderer().setSeriesPaint(0, new Color(79, 129, 189));
    }
    
    private JFreeChart barChart;
    private ChartPanel barChartPanel;
    
    public void showPieChart(List<StatisticsModel> lsStatisticsModels){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        LocalDate localDate = LocalDate.now();
        String x = String.valueOf(localDate.getMonth());
        
        for(StatisticsModel statisticsModel:lsStatisticsModels){
            
            dataset.addValue(statisticsModel.getValue(), "Month", statisticsModel.getMonth());
            if(x.equals(statisticsModel.getMonth())) break;
        }
        
        barChart = ChartFactory.createBarChart(
            "THEO THÁNG",
            "Tháng",
            "Sản phẩm",
            dataset,
            PlotOrientation.VERTICAL,
            false,
            true,
            false
        );
        barChart.setBackgroundPaint(new GradientPaint(0, 0, Color.white, 0, getHeight(), new Color(220, 220, 220)));
        barChart.getTitle().setPaint(new Color(72, 72, 72));
        barChart.getTitle().setFont(new Font("Calibri", Font.BOLD, 18));
        barChart.getCategoryPlot().getRangeAxis().setTickLabelFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 12));
        barChart.getCategoryPlot().getDomainAxis().setTickLabelFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 12));
        barChart.getCategoryPlot().setOutlineVisible(false);
        barChart.getCategoryPlot().setBackgroundPaint(Color.white);
        barChart.getCategoryPlot().setRangeGridlinePaint(new Color(220, 220, 220));
        barChart.getCategoryPlot().setDomainGridlinePaint(new Color(220, 220, 220));
        barChart.getCategoryPlot().getRenderer().setSeriesStroke(0, new BasicStroke(2.0f));
        barChart.getCategoryPlot().getRenderer().setSeriesPaint(0, new Color(79, 129, 189));
    }
    
    
    private void btnStatisticActionPerformed(java.awt.event.ActionEvent evt) {                                      
        lblQA.setBackground(new Color(0,204,106));
        
        lblTimeline.setBackground(new Color(255,255,255));
        lblNews.setBackground(new Color(255,255,255));
        lblTrending.setBackground(new Color(255,255,255));
        pnlBody.removeAll();
        pnlBody.repaint();
        pnlBody.revalidate();

        chartPanel = new ChartPanel(chart);
        chartPanel.setBackground(new Color(255,255,255));
        barChartPanel = new ChartPanel(barChart);
        barChartPanel.setBackground(new Color(255,255,255));
        pnlBody.setLayout(new GridLayout(1,2));
        pnlBody.add(chartPanel, BorderLayout.WEST);
        pnlBody.add(barChartPanel, BorderLayout.EAST);
    }        
    private void btnStatisticActionPerformed(MouseEvent e) {                                      
        lblQA.setBackground(new Color(0,204,106));
        
        lblTimeline.setBackground(new Color(255,255,255));
        lblNews.setBackground(new Color(255,255,255));
        lblTrending.setBackground(new Color(255,255,255));
        pnlBody.removeAll();
        pnlBody.repaint();
        pnlBody.revalidate();

        chartPanel = new ChartPanel(chart);
        chartPanel.setBackground(new Color(255,255,255));
        barChartPanel = new ChartPanel(barChart);
        barChartPanel.setBackground(new Color(255,255,255));
        pnlBody.setLayout(new GridLayout(1,2));
        pnlBody.add(chartPanel, BorderLayout.WEST);
        pnlBody.add(barChartPanel, BorderLayout.EAST);
    }  
    
    public void addStatListener(ActionListener listener) {
        btnQA.addActionListener(listener);
    }
    
    public void addStatListener(MouseListener listener) {
        jLabel8.addMouseListener(listener);
        jLabel13.addMouseListener(listener);
    }
    public void addLogout(MouseListener listener){
        jLabel17.addMouseListener(listener);
    }

}