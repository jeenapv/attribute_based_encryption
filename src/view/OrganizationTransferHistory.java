/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Db.Dbcon;
import General.Configuration;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jithinpv
 */
public class OrganizationTransferHistory extends javax.swing.JFrame {

    /**
     * Creates new form OrganizationTransferHistory
     */
    public OrganizationTransferHistory() {
        initComponents();
        this.setLocationRelativeTo(null);
        intraOrganisationHistory();
        Configuration.setIconOnLabel("addMemHome.jpg", bg);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        sen_org = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        rec_org = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        file_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        file_size = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        file_type = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        priorityy = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane4MouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "SENDER", "RECEIVER", "DATE", "STATUS", "FILE", "enc_id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(6).setMinWidth(0);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("IntraOrganization", jPanel1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "SENDER", "RECEIVER", "FILE", "DATE", "STATUS", "enc_id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
            jTable2.getColumnModel().getColumn(5).setResizable(false);
            jTable2.getColumnModel().getColumn(6).setMinWidth(0);
            jTable2.getColumnModel().getColumn(6).setPreferredWidth(0);
            jTable2.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        jLabel1.setText("Sender Organization");

        jLabel2.setText("Receiver Organization");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rec_org, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sen_org, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(sen_org, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rec_org, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("InterOrganization", jPanel2);

        getContentPane().add(jTabbedPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 26, -1, 223));

        jLabel3.setText("File Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 263, 111, -1));
        getContentPane().add(file_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 260, 162, -1));

        jLabel4.setText("File Size");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 301, 111, -1));
        getContentPane().add(file_size, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 298, 162, -1));

        jLabel5.setText("File Type");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 347, 111, -1));
        getContentPane().add(file_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 344, 162, -1));

        jLabel6.setText("Priority");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 385, 111, -1));
        getContentPane().add(priorityy, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 382, 162, -1));

        jButton1.setText("HOME");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 420, 162, -1));

        bg.setText("jLabel7");
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -6, 550, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        OrganizationHome organizationHome = new OrganizationHome();
        organizationHome.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

     private void clearTable() throws Exception {
        DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
        int rowCount = dm.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
            file_name.setText(null);
            file_size.setText(null);
            file_type.setText(null);
            priorityy.setText(null);
        }
    }
      private void clearTable2() throws Exception {
        DefaultTableModel dm = (DefaultTableModel) jTable2.getModel();
        int rowCount = dm.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
            file_name.setText(null);
            file_size.setText(null);
            file_type.setText(null);
            priorityy.setText(null);
        }
    }
     
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        Dbcon dbcon = new Dbcon();
        String id = jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString();
        String reqid = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
        ResultSet r = dbcon.select("select request_priority from tbl_file_request where request_id='" + reqid + "'");
        try {
            if (r.next()) {
                String priority = r.getString("request_priority");
                if (priority.equals("1")) {
                    priority = "low";
                } else if (priority.equals("2")) {
                    priority = "medium";
                } else {
                    priority = "high";
                }
                priorityy.setText(priority);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        ResultSet rs = dbcon.select("select * from tbl_file_encryption_logs where encryption_id='" + id + "'");
        try {
            while (rs.next()) {
                String filename = rs.getString("attr_1");
                String size = rs.getString("attr_2");
                String type = rs.getString("attr_3");

                file_name.setText(filename);
                file_size.setText(size);
                file_type.setText(type);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }//GEN-LAST:event_jTable1MouseClicked

    private void jTabbedPane4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane4MouseClicked
        // TODO add your handling code here:
        interOrganisationHistory();
    }//GEN-LAST:event_jTabbedPane4MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        Dbcon dbcon = new Dbcon();

        String reqid = jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString();
        String qry = "SELECT  filereq.request_id,filereq.request_priority, filereq.requested_data_member ,datam.name AS dataMemName, org.name AS org_name, encrptlog.attr_1 ,encrptlog.attr_2,encrptlog.attr_3,datam2.name AS dataOwnerName, org2.name AS dataOwnweOrg FROM   tbl_file_request AS filereq ,tbl_data_member AS datam ,  tbl_organisation AS org,  tbl_data_member AS datam2 ,  tbl_organisation AS org2,  tbl_file_encryption_logs AS encrptlog WHERE   filereq.requested_data_member = datam.data_member_id  and org.organisation_id = datam.organization_id AND  encrptlog.encryption_id = filereq.encryption_id AND  datam2.data_member_id = filereq.file_owner_data_member AND org2.organisation_id = datam2.organization_id and filereq.request_id='" + reqid + "'";
        ResultSet r = dbcon.select(qry);
        try {
            if (r.next()) {
                String fileName = r.getString("attr_1");
                String fileSize = r.getString("attr_2");
                String fileType = r.getString("attr_3");
                String senderOrg = r.getString("dataOwnweOrg");
                String receiverOrg = r.getString("org_name");
                String priority = r.getString("request_priority");
                if (priority.equals("1")) {
                    priority = "low";
                } else if (priority.equals("2")) {
                    priority = "medium";
                } else {
                    priority = "high";
                }
                priorityy.setText(priority);
                file_name.setText(fileName);
                file_size.setText(fileSize);
                file_type.setText(fileType);
                sen_org.setText(senderOrg);
                rec_org.setText(receiverOrg);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_jTable2MouseClicked
    private String getFormatedDate(String dateString, String format) {

        try {
            long dateMilli = Long.parseLong(dateString);
            Date date = new Date(dateMilli);
            SimpleDateFormat formatter = new SimpleDateFormat(format);

            String formatted = formatter.format(date);

            System.out.println("formatted " + formatted);
            return formatted;
        } catch (Exception e) {
            return "date not found";
        }

    }

    private void intraOrganisationHistory() {
        try {
            clearTable();
      
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Dbcon dbcon = new Dbcon();
        String query = "SELECT filereq.request_id,filereq.encryption_id,filereq.requested_date, filereq.request_priority, filereq.requested_data_member ,filereq.status,datam.name AS dataMemName,  encrptlog.attr_1 ,encrptlog.attr_2,encrptlog.attr_3,datam2.name AS dataOwnerName FROM   tbl_file_request AS filereq ,tbl_data_member AS datam ,  tbl_organisation AS org,  tbl_data_member AS datam2 ,  tbl_organisation AS org2,  tbl_file_encryption_logs AS encrptlog WHERE   filereq.requested_data_member = datam.data_member_id  and org.organisation_id = datam.organization_id AND  encrptlog.encryption_id = filereq.encryption_id AND  datam2.data_member_id = filereq.file_owner_data_member AND org2.organisation_id = datam2.organization_id and filereq.is_inter_company_file_request=0 AND datam.organization_id='" + OrganizationLogin.logged_in_org_id + "' and datam2.organization_id='" + OrganizationLogin.logged_in_org_id + "'";
        ResultSet rs = dbcon.select(query);
       
            String arr[] = new String[7];
            while (rs.next()) {
                String encId = rs.getString("encryption_id");
                String reqName = rs.getString("dataMemName");
                String owner = rs.getString("dataOwnerName");
                String requestId = rs.getString("request_id");
                String status = rs.getString("status");
                String date = rs.getString("requested_date");
                String priority = rs.getString("request_priority");
                String file_name = rs.getString("attr_1");
                String size = rs.getString("attr_2");
                String type = rs.getString("attr_3");
                if (status.equals("0")) {
                    status = "rejected";
                } else if (status.equals("1")) {
                    status = "approved";
                } else {
                    status = "pending";
                }
                arr[0] = requestId;
                arr[1] = reqName;
                arr[2] = owner;
                arr[3] = getFormatedDate(date, "dd MM yyyy");
                arr[4] = status;
                arr[5] = file_name;
                arr[6] = encId;
                model.addRow(arr);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        } catch (Exception ex) {
            Logger.getLogger(OrganizationTransferHistory.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    private void interOrganisationHistory() {
       try {
           clearTable2();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        Dbcon dbcon = new Dbcon();

        String query = "SELECT filereq.request_id,filereq.encryption_id,filereq.requested_date, filereq.request_priority, filereq.requested_data_member ,filereq.status,datam.name AS dataMemName, org.name AS org_name, encrptlog.attr_1 ,encrptlog.attr_2,encrptlog.attr_3,datam2.name AS dataOwnerName, org2.name AS dataOwnweOrg FROM   tbl_file_request AS filereq ,tbl_data_member AS datam ,  tbl_organisation AS org,  tbl_data_member AS datam2 ,  tbl_organisation AS org2,  tbl_file_encryption_logs AS encrptlog WHERE   filereq.requested_data_member = datam.data_member_id  and org.organisation_id = datam.organization_id AND  encrptlog.encryption_id = filereq.encryption_id AND  datam2.data_member_id = filereq.file_owner_data_member AND org2.organisation_id = datam2.organization_id and filereq.is_inter_company_file_request=1 AND (datam.organization_id='" + OrganizationLogin.logged_in_org_id + "' or datam2.organization_id='" + OrganizationLogin.logged_in_org_id + "')";
        System.out.println(query);
        ResultSet rs = dbcon.select(query);
        
            String arr[] = new String[7];
            while (rs.next()) {
                String encId = rs.getString("encryption_id");
                String reqName = rs.getString("dataMemName");
                String owner = rs.getString("dataOwnerName");
                String requestId = rs.getString("request_id");
                String status = rs.getString("status");
                String date = rs.getString("requested_date");
                String priority = rs.getString("request_priority");
                String file_name = rs.getString("attr_1");
                String size = rs.getString("attr_2");
                String type = rs.getString("attr_3");
                if (status.equals("0")) {
                    status = "rejected";
                } else if (status.equals("1")) {
                    status = "approved";
                } else {
                    status = "pending";
                }
                arr[0] = requestId;
                arr[1] = reqName;
                arr[2] = owner;
                arr[4] = getFormatedDate(date, "dd MM yyyy");
                arr[5] = status;
                arr[3] = file_name;
                arr[6] = encId;
                model.addRow(arr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
            java.util.logging.Logger.getLogger(OrganizationTransferHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrganizationTransferHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrganizationTransferHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrganizationTransferHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrganizationTransferHistory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JTextField file_name;
    private javax.swing.JTextField file_size;
    private javax.swing.JTextField file_type;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField priorityy;
    private javax.swing.JTextField rec_org;
    private javax.swing.JTextField sen_org;
    // End of variables declaration//GEN-END:variables
}
