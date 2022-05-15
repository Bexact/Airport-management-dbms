/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package database2projava;

import java.sql.DriverManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Home
 */
public class flightmanage extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    public flightmanage() {
        super("main");
        initComponents();
        DisplayFlight();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    Connection con;
    Statement st;
    PreparedStatement ps;
    CallableStatement cs;
    ResultSet rs1,rs2;
    int fid = 0; 
    private void CountFlights(){
        try {
            st = con.createStatement();
            rs1 = st.executeQuery("select max(f_id) from flight");
            rs1.next();
            fid = rs1.getInt(1)+1;
            
        } catch (SQLException ex) {
            Logger.getLogger(flightmanage.class.getName()).log(Level.SEVERE, null, ex);
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
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        backbtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDeparture = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldairlineid = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        takeofdatetxt = new javax.swing.JTextField();
        jTextFieldArrival = new javax.swing.JTextField();
        insertbtn = new javax.swing.JButton();
        dltbtn1 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jTextFieldNumseats1 = new javax.swing.JTextField();
        fcodetxtField1 = new javax.swing.JTextField();
        sourcetxt1 = new javax.swing.JTextField();
        desttxt1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        flighttle = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(204, 51, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidepane.setBackground(new java.awt.Color(58, 33, 89));
        sidepane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(85, 65, 118));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database2projava/images/clock-outline.png"))); // NOI18N

        jButton2.setBackground(new java.awt.Color(85, 65, 118));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("Flight list");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(0, 13, Short.MAX_VALUE))
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidepane.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 220, 50));

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

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database2projava/images/airplane.png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(85, 65, 118));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Flight manage");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        sidepane.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 220, 50));

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
        sidepane.add(backbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 90, 30));

        bg.add(sidepane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 520));

        jPanel1.setBackground(new java.awt.Color(153, 0, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 255));
        jLabel2.setText("Flight code");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jTextFieldDeparture.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextFieldDeparture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDepartureActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldDeparture, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 42, 70, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 255));
        jLabel3.setText("Source");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 255));
        jLabel4.setText(" Destination");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 70, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 255));
        jLabel11.setText("Airline id");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, -1, -1));

        jTextFieldairlineid.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextFieldairlineid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldairlineidActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldairlineid, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, 50, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 255));
        jLabel12.setText("Takeof date");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 255));
        jLabel13.setText("Arrival(time)");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 255));
        jLabel16.setText("Departure(time)");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, -1, -1));

        takeofdatetxt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        takeofdatetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takeofdatetxtActionPerformed(evt);
            }
        });
        jPanel1.add(takeofdatetxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 70, -1));

        jTextFieldArrival.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextFieldArrival.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldArrivalActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldArrival, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 70, -1));

        insertbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        insertbtn.setForeground(new java.awt.Color(255, 0, 255));
        insertbtn.setText("Insert");
        insertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbtnActionPerformed(evt);
            }
        });
        jPanel1.add(insertbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 80, 30));

        dltbtn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dltbtn1.setForeground(new java.awt.Color(255, 0, 255));
        dltbtn1.setText("Delete");
        dltbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dltbtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(dltbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 90, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 255));
        jLabel18.setText("Num of seats");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, -1, -1));

        jTextFieldNumseats1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextFieldNumseats1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumseats1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldNumseats1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, 70, -1));

        fcodetxtField1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        fcodetxtField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fcodetxtField1ActionPerformed(evt);
            }
        });
        jPanel1.add(fcodetxtField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 70, -1));

        sourcetxt1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sourcetxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sourcetxt1ActionPerformed(evt);
            }
        });
        jPanel1.add(sourcetxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 70, -1));

        desttxt1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        desttxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desttxt1ActionPerformed(evt);
            }
        });
        jPanel1.add(desttxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 70, -1));

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 800, 140));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 255));
        jLabel1.setText("NEW FLIGHTS");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 255));
        jLabel10.setText("Takeof date");
        bg.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 255));
        jLabel17.setText("MANAGE FLIGHTS");
        bg.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, -1, -1));

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

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 780, 310));

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

    private void jTextFieldDepartureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDepartureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDepartureActionPerformed

    private void jTextFieldairlineidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldairlineidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldairlineidActionPerformed

    private void takeofdatetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takeofdatetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_takeofdatetxtActionPerformed

    private void jTextFieldArrivalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldArrivalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldArrivalActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        new main().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backbtnActionPerformed

    private void insertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbtnActionPerformed
        if(takeofdatetxt.getText().isEmpty() || jTextFieldArrival.getText().isEmpty() || jTextFieldDeparture.getText().isEmpty() || jTextFieldDeparture.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Missing Information");
        }else{
            try{
                CountFlights();
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "bexact", "bexact");
                String sql = "insert into flight(f_id,flight_id,airline_id,num_of_seats,source_id,destination_id,departure,arrival,take_of_date) values(?,?,?,?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setInt(1, fid);
                ps.setString(2,(String)fcodetxtField1.getText());
                ps.setString(3,(String)jTextFieldairlineid.getText());
                ps.setString(4,(String)jTextFieldNumseats1.getText());
                ps.setString(5,(String)sourcetxt1.getText());
                ps.setString(6,(String)desttxt1.getText());
                ps.setString(7,(String)jTextFieldDeparture.getText());
                ps.setString(8,(String)jTextFieldArrival.getText());
                ps.setString(9,(String)takeofdatetxt.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Flight Added");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, ex);
            }
        }
        
        
    }//GEN-LAST:event_insertbtnActionPerformed

    private void dltbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dltbtn1ActionPerformed
        int row = flighttle.getSelectedRow();
        String cell = flighttle.getModel().getValueAt(row, 0).toString(); 

        try{
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "bexact", "bexact");
            cs = con.prepareCall("{call deleteflight(?) }");
            cs.setString(1, cell);
            cs.execute();
            JOptionPane.showMessageDialog(this, "Flight Deleted");
            DisplayFlight();
        }catch(Exception ex){
                JOptionPane.showMessageDialog(this,ex);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_dltbtn1ActionPerformed

    private void jTextFieldNumseats1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumseats1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumseats1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
        flightlist fl = new flightlist();
        fl.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void fcodetxtField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fcodetxtField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fcodetxtField1ActionPerformed

    private void sourcetxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sourcetxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sourcetxt1ActionPerformed

    private void desttxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desttxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_desttxt1ActionPerformed
    int key = 0;
    private void flighttleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_flighttleMouseClicked
        DefaultTableModel model = (DefaultTableModel)flighttle.getModel();
        int myindex = flighttle.getSelectedRow();
        key = Integer.valueOf(model.getValueAt(myindex, 0).toString());
        fcodetxtField1.setText(model.getValueAt(myindex, 1).toString());
        sourcetxt1.setText(model.getValueAt(myindex, 2).toString());
        desttxt1.setText(model.getValueAt(myindex, 3).toString());
        takeofdatetxt.setText(model.getValueAt(myindex, 4).toString());
        jTextFieldArrival.setText(model.getValueAt(myindex, 5).toString());
        jTextFieldDeparture.setText(model.getValueAt(myindex, 6).toString());
        jTextFieldNumseats1.setText(model.getValueAt(myindex, 7).toString());
        jTextFieldairlineid.setText(model.getValueAt(myindex, 8).toString());
    }//GEN-LAST:event_flighttleMouseClicked

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
            java.util.logging.Logger.getLogger(flightmanage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(flightmanage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(flightmanage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(flightmanage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new flightmanage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbtn;
    private javax.swing.JPanel bg;
    private javax.swing.JTextField desttxt1;
    private javax.swing.JButton dltbtn1;
    private javax.swing.JTextField fcodetxtField1;
    private javax.swing.JTable flighttle;
    private javax.swing.JButton insertbtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldArrival;
    private javax.swing.JTextField jTextFieldDeparture;
    private javax.swing.JTextField jTextFieldNumseats1;
    private javax.swing.JTextField jTextFieldairlineid;
    private javax.swing.JPanel sidepane;
    private javax.swing.JTextField sourcetxt1;
    private javax.swing.JTextField takeofdatetxt;
    // End of variables declaration//GEN-END:variables
}
