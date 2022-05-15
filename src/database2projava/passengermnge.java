/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package database2projava;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Home
 */
public class passengermnge extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    public passengermnge() {
         super("main");
        initComponents();
       DisplayPassenger();
        
    }

    Connection con;
    Statement st;
    PreparedStatement ps;
    CallableStatement cs;
    ResultSet rs1,rs2;
   
    private void clear(){
       passidtxt.setText("");
       fnametxt.setText("");
       lnametxt.setText("");
       cidtxt.setText("");
       agetxt.setText("");
       gendertxt.setText("");
       phonetxt.setText("");
       
       
   }
    int pid = 0; 
    private void CountPassengers(){
       
        try {
            st = con.createStatement();
            rs1 = st.executeQuery("select max(p_id) from passenger");
            rs1.next();
            pid = rs1.getInt(1)+1;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(passengermnge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
 
    }
    private void DisplayPassenger(){        
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "bexact", "bexact");
            st = con.createStatement();
            rs1 = st.executeQuery("SELECT * FROM BEXACT.Passenger order by p_id asc");
            while(rs1.next()){
                String id = rs1.getString("p_id"); 
                String pcode = rs1.getString("passport_id");
                String fname = rs1.getString("first_name");
                String lname = rs1.getString("last_name");
                String cid = rs1.getString("country_id");
                String age = rs1.getString("age");
                String gender = rs1.getString("gender");
                String phone = rs1.getString("phone");
                
                String tbData[] = {id,pcode,fname,lname,cid,age, gender, phone};
                DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
                tblModel.addRow(tbData);
                
            }
            
        }catch(Exception e){
             JOptionPane.showMessageDialog(this, e);
        }
        
    }
    
    private void updateTable(){
        String sql = "select * from passengers";
        try {
            ps = con.prepareStatement(sql);
            rs2 = ps.executeQuery();
             while(rs2.next()){
                String id = rs2.getString("p_id"); 
                String pcode = rs2.getString("passport_id");
                String fname = rs2.getString("first_name");
                String lname = rs2.getString("last_name");
                String cid = rs2.getString("country_id");
                String age = rs2.getString("age");
                String gender = rs2.getString("gender");
                String phone = rs2.getString("phone");
                
                String tbData[] = {id,pcode,fname,lname,cid,age, gender, phone};
                DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
                tblModel.addRow(tbData);
                
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(passengermnge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        sidepane = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        backbtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cidtxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        phonetxt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        passidtxt = new javax.swing.JTextField();
        lnametxt = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        gendertxt = new javax.swing.JTextField();
        fnametxt = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        agetxt = new javax.swing.JTextField();
        dltbtn1 = new javax.swing.JButton();
        insertbtn2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(204, 51, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidepane.setBackground(new java.awt.Color(58, 33, 89));
        sidepane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(85, 65, 118));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database2projava/images/tie.png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(85, 65, 118));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setText("Passenger list");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        sidepane.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 250, 50));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("AIRPORT ");
        sidepane.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 120, 50));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Management System");
        sidepane.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 30));

        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));
        sidepane.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 200, -1));

        jPanel5.setBackground(new java.awt.Color(85, 65, 118));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database2projava/images/account-tie.png"))); // NOI18N

        jButton2.setBackground(new java.awt.Color(85, 65, 118));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 204, 204));
        jButton2.setText("Passenger manage");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        sidepane.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 250, 60));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database2projava/images/airport.png"))); // NOI18N
        sidepane.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, 40));

        backbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        backbtn.setForeground(new java.awt.Color(255, 0, 255));
        backbtn.setText("Back");
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });
        sidepane.add(backbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, 90, 30));

        bg.add(sidepane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 520));

        jPanel1.setBackground(new java.awt.Color(153, 0, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 255));
        jLabel2.setText("Passport_id");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        cidtxt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cidtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidtxtActionPerformed(evt);
            }
        });
        jPanel1.add(cidtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 70, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 255));
        jLabel9.setText("Coutry id");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 255));
        jLabel11.setText("Age");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));

        phonetxt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        phonetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phonetxtActionPerformed(evt);
            }
        });
        jPanel1.add(phonetxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 70, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 255));
        jLabel13.setText("First name");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 255));
        jLabel16.setText("Last name");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        passidtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passidtxtActionPerformed(evt);
            }
        });
        jPanel1.add(passidtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 70, -1));

        lnametxt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lnametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnametxtActionPerformed(evt);
            }
        });
        jPanel1.add(lnametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 70, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 255));
        jLabel18.setText("Phone");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, -1, -1));

        gendertxt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        gendertxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gendertxtActionPerformed(evt);
            }
        });
        jPanel1.add(gendertxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 70, -1));

        fnametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnametxtActionPerformed(evt);
            }
        });
        jPanel1.add(fnametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 70, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 255));
        jLabel19.setText("Gender");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, -1, -1));

        agetxt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        agetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agetxtActionPerformed(evt);
            }
        });
        jPanel1.add(agetxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 70, -1));

        dltbtn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dltbtn1.setForeground(new java.awt.Color(255, 0, 255));
        dltbtn1.setText("Delete");
        dltbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dltbtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(dltbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 80, 30));

        insertbtn2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        insertbtn2.setForeground(new java.awt.Color(255, 0, 255));
        insertbtn2.setText("Insert");
        insertbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbtn2ActionPerformed(evt);
            }
        });
        jPanel1.add(insertbtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 80, 30));

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 850, 130));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 255));
        jLabel10.setText("Takeof date");
        bg.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 255));
        jLabel17.setText("MANAGE PASSENGERS");
        bg.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 255));
        jLabel1.setText("New Passengers");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, -1, -1));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Passport id", "First name", "Last name", "Country id", "Age", "Gender", "Phone"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        bg.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 830, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cidtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cidtxtActionPerformed

    private void phonetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phonetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phonetxtActionPerformed

    private void passidtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passidtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passidtxtActionPerformed

    private void lnametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnametxtActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        new main().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backbtnActionPerformed

    private void gendertxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gendertxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gendertxtActionPerformed

    private void fnametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnametxtActionPerformed

    private void agetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agetxtActionPerformed

    private void dltbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dltbtn1ActionPerformed
        int row = jTable1.getSelectedRow();
        String cell = jTable1.getModel().getValueAt(row, 0).toString(); 
//        String sql = "Delete from Passenger where p_id ="+cell;
        try{
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "bexact", "bexact");
            cs = con.prepareCall("{call deletepassenger(?)}");
            cs.setString(1, cell);
            cs.execute();
            JOptionPane.showMessageDialog(this, "Pessenger Deleted");
            DisplayPassenger();
        }catch(Exception ex){
                JOptionPane.showMessageDialog(this,ex);
        }
        
    }//GEN-LAST:event_dltbtn1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        passengerlist pl = new passengerlist();
        pl.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void insertbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbtn2ActionPerformed
        // TODO add your handling code here:
         if(passidtxt.getText().isEmpty() || lnametxt.getText().isEmpty() || cidtxt.getText().isEmpty() || phonetxt.getText().isEmpty()||  gendertxt.getText().isEmpty() || agetxt.getText().isEmpty()|| lnametxt.getText().isEmpty()|| fnametxt.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Missing Information");
        }else{
            try{
                CountPassengers();
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "bexact", "bexact");
                String sql = "insert into passenger(p_id,passport_id, first_name, last_name, country_id, age, gender, phone)   values(?,?,?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setInt(1, pid);
                ps.setString(2,(String) passidtxt.getText());
                ps.setString(3,(String)fnametxt.getText());
                ps.setString(4,(String)lnametxt.getText());
                ps.setString(5,(String)cidtxt.getText());
                ps.setString(6,(String)agetxt.getText());
                ps.setString(7,(String)gendertxt.getText());
                ps.setString(8,(String)phonetxt.getText());
                ps.execute();
                JOptionPane.showMessageDialog(this, "Passenger Added");
                clear();
                DisplayPassenger();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, ex);
            }
         }
    }//GEN-LAST:event_insertbtn2ActionPerformed
    int key = 0;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int myindex = jTable1.getSelectedRow();
        key = Integer.valueOf(model.getValueAt(myindex, 0).toString());
        passidtxt.setText(model.getValueAt(myindex, 1).toString());
        fnametxt.setText(model.getValueAt(myindex, 2).toString());
        lnametxt.setText(model.getValueAt(myindex, 3).toString());
        cidtxt.setText(model.getValueAt(myindex, 4).toString());
        agetxt.setText(model.getValueAt(myindex, 5).toString());
        gendertxt.setText(model.getValueAt(myindex, 6).toString());
        phonetxt.setText(model.getValueAt(myindex, 7).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(passengermnge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(passengermnge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(passengermnge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(passengermnge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new passengermnge().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField agetxt;
    private javax.swing.JButton backbtn;
    private javax.swing.JPanel bg;
    private javax.swing.JTextField cidtxt;
    private javax.swing.JButton dltbtn1;
    private javax.swing.JTextField fnametxt;
    private javax.swing.JTextField gendertxt;
    private javax.swing.JButton insertbtn2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField lnametxt;
    private javax.swing.JTextField passidtxt;
    private javax.swing.JTextField phonetxt;
    private javax.swing.JPanel sidepane;
    // End of variables declaration//GEN-END:variables
}
