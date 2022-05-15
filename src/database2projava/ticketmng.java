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
public class ticketmng extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    public ticketmng() {
        super("main");
        initComponents();
        DisplayFlight();
        DisplayTickets();
    }

    Connection con;
    Statement st;
    PreparedStatement ps;
    CallableStatement cs;
    ResultSet rs1,rs2;
   
    private void clear(){
       tid.setText("");
       passid.setText("");
       flightid.setText("");
       seattxt.setText("");
       canceltxt.setText("");
   }
    int ticketid = 0; 
    private void CountTickets(){
       
        try {
            st = con.createStatement();
            rs1 = st.executeQuery("select max(p_id) from passenger");
            rs1.next();
            ticketid = rs1.getInt(1)+1;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ticketmng.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
 
    }
    private void DisplayTickets(){
         try{
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "bexact", "bexact");
            st = con.createStatement();
            rs1 = st.executeQuery("SELECT * FROM BEXACT.TICKET order by t_id asc");
            
            while(rs1.next()){
                String fid = rs1.getString("t_id");
                String source = rs1.getString("ticket_id");
                String dest = rs1.getString("passport_id");
                String fcode = rs1.getString("flight_id");
                String ltime = rs1.getString("seat_class");
                String arr = rs1.getString("cancelation");
                String tbData[] = {fid,source,dest,fcode, ltime, arr,};
                DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
                tblModel.addRow(tbData);
                
            }
            
        }catch(Exception e){
             JOptionPane.showMessageDialog(this, e);
        }
    }
    private void DisplayFlight(){
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "bexact", "bexact");
            st = con.createStatement();
            rs1 = st.executeQuery("SELECT * FROM BEXACT.FLIGHT order by f_id asc");
            
            while(rs1.next()){
                String fid = rs1.getString("f_id");
                String fcode = rs1.getString("flight_id");
                String source = rs1.getString("source_id");
                String dest = rs1.getString("destination_id");
                String ltime = rs1.getString("take_of_date");
                String arr = rs1.getString("arrival");
                String depart = rs1.getString("departure");
                String nstop = rs1.getString("num_of_seats");
                String airid = rs1.getString("airline_id");
                String tbData[] = {fid,fcode,source,dest,ltime, arr,depart,nstop,airid};
                DefaultTableModel tblModel = (DefaultTableModel) flighttle.getModel();
                tblModel.addRow(tbData);
                
            }
            
        }catch(Exception e){
             JOptionPane.showMessageDialog(this, e);
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
        backbtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        seattxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tid = new javax.swing.JTextField();
        flightid = new javax.swing.JTextField();
        passid = new javax.swing.JTextField();
        canceltxt = new javax.swing.JTextField();
        dltbtn1 = new javax.swing.JButton();
        bookbtn2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        flighttle = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
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

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database2projava/images/rename-box.png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(85, 65, 118));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setText("Ticket list");
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
                .addGap(4, 4, 4)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(0, 13, Short.MAX_VALUE))
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidepane.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 240, 50));

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

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database2projava/images/qrcode.png"))); // NOI18N

        jButton2.setBackground(new java.awt.Color(85, 65, 118));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 204, 204));
        jButton2.setText("Ticket booking");
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
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        sidepane.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 240, 60));

        backbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        backbtn.setForeground(new java.awt.Color(255, 0, 255));
        backbtn.setText("Back");
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });
        sidepane.add(backbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 90, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database2projava/images/airport.png"))); // NOI18N
        sidepane.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, 40));

        bg.add(sidepane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 520));

        jPanel1.setBackground(new java.awt.Color(153, 0, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 255));
        jLabel2.setText("Ticket id");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        seattxt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        seattxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seattxtActionPerformed(evt);
            }
        });
        jPanel1.add(seattxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 70, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 255));
        jLabel9.setText("Seat class");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 255));
        jLabel11.setText("Cancelation");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 255));
        jLabel13.setText("Passport id");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 255));
        jLabel16.setText("Flight id");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, -1));

        tid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tidActionPerformed(evt);
            }
        });
        jPanel1.add(tid, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 70, -1));

        flightid.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        flightid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flightidActionPerformed(evt);
            }
        });
        jPanel1.add(flightid, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 70, -1));

        passid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passidActionPerformed(evt);
            }
        });
        jPanel1.add(passid, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 70, -1));

        canceltxt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        canceltxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canceltxtActionPerformed(evt);
            }
        });
        jPanel1.add(canceltxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 70, -1));

        dltbtn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dltbtn1.setForeground(new java.awt.Color(255, 0, 255));
        dltbtn1.setText("Reset");
        dltbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dltbtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(dltbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 80, 30));

        bookbtn2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bookbtn2.setForeground(new java.awt.Color(255, 0, 255));
        bookbtn2.setText("Book");
        bookbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookbtn2ActionPerformed(evt);
            }
        });
        jPanel1.add(bookbtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 80, 30));

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 850, 130));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 255));
        jLabel10.setText("Takeof date");
        bg.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 255));
        jLabel17.setText("Ticket booking");
        bg.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 255));
        jLabel1.setText("Tickets");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, -1, -1));

        flighttle.setAutoCreateRowSorter(true);
        flighttle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Flight code", "Source", "Destination", "Takeof date", "Arrival(time)", "Departure", "Number of seats", "Airline id"
            }
        ));
        flighttle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                flighttleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(flighttle);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 800, 130));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 255));
        jLabel3.setText("Information Flights");
        bg.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Ticket id", "Passport id", "Flight id", "Seat class", "Cancelation"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        bg.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, 800, 130));

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

    private void seattxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seattxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seattxtActionPerformed

    private void tidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tidActionPerformed

    private void flightidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flightidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_flightidActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        new main().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backbtnActionPerformed

    private void passidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passidActionPerformed

    private void canceltxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canceltxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_canceltxtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        ticketlist pl = new ticketlist();
        pl.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bookbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookbtn2ActionPerformed
        // TODO add your handling code here:
         if(tid.getText().isEmpty() || flightid.getText().isEmpty() || seattxt.getText().isEmpty()  || canceltxt.getText().isEmpty()|| flightid.getText().isEmpty()|| passid.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Missing Information");
        }else{
            try{
                CountTickets();
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "bexact", "bexact");
                String sql = "insert into ticket(t_id,ticket_id, passport_id, flight_id, seat_class, cancelation) values(?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setInt(1, ticketid);
                ps.setString(2,(String)tid.getText());
                ps.setString(3,(String)passid.getText());
                ps.setString(4,(String)flightid.getText());
                ps.setString(5,(String)seattxt.getText());
                ps.setString(6,(String)canceltxt.getText());

                ps.execute();
                JOptionPane.showMessageDialog(this, "Ticket Added");
                clear();

            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, ex);
            }
         }
    }//GEN-LAST:event_bookbtn2ActionPerformed
    int key = 0;
    private void flighttleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_flighttleMouseClicked
        DefaultTableModel model = (DefaultTableModel)flighttle.getModel();
        int myindex = flighttle.getSelectedRow();
        key = Integer.valueOf(model.getValueAt(myindex, 0).toString());
        flightid.setText(model.getValueAt(myindex, 1).toString());

    }//GEN-LAST:event_flighttleMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int myindex = jTable1.getSelectedRow();
        key = Integer.valueOf(model.getValueAt(myindex, 0).toString());
        tid.setText(model.getValueAt(myindex, 1).toString());
        passid.setText(model.getValueAt(myindex, 2).toString());
        flightid.setText(model.getValueAt(myindex, 3).toString());
        seattxt.setText(model.getValueAt(myindex, 4).toString());
        canceltxt.setText(model.getValueAt(myindex, 5).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void dltbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dltbtn1ActionPerformed
        tid.setText("");
        passid.setText("");
        flightid.setText("");
        seattxt.setText("");
        canceltxt.setText("");

    }//GEN-LAST:event_dltbtn1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
    }//GEN-LAST:event_jButton2ActionPerformed


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
            java.util.logging.Logger.getLogger(ticketmng.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ticketmng.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ticketmng.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ticketmng.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ticketmng().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbtn;
    private javax.swing.JPanel bg;
    private javax.swing.JButton bookbtn2;
    private javax.swing.JTextField canceltxt;
    private javax.swing.JButton dltbtn1;
    private javax.swing.JTextField flightid;
    private javax.swing.JTable flighttle;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField passid;
    private javax.swing.JTextField seattxt;
    private javax.swing.JPanel sidepane;
    private javax.swing.JTextField tid;
    // End of variables declaration//GEN-END:variables
}
