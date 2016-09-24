/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Db.Dbcon;
import General.Configuration;
import General.Nimbus;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jithinpv
 */
public class DataMemberHome extends javax.swing.JFrame {

    private static String title = "";

    /**
     * Creates new form DataMemberHome
     */
    public DataMemberHome() {
        Nimbus.loadLoogAndFeel();
        initComponents();
        this.setLocationRelativeTo(null);
        loadFileRequests();
        setTitle(title);
        loadIcons();
         Configuration.setIconOnLabel("dataMemberHome.jpg", bg1);
         
    }

    public DataMemberHome(String userName) {
        Nimbus.loadLoogAndFeel();
        initComponents();
        this.setLocationRelativeTo(null);
        loadFileRequests();
        title = userName + " - Home";
        setTitle(title);
        loadIcons();
         Configuration.setIconOnLabel("dataMemberHome.jpg", bg1);
          
    }

    private void loadIcons() {
        Configuration.setIconOnLabel("refresh.png", refresh_label);
       
    }

    private void clearTable() throws Exception {
        DefaultTableModel dm = (DefaultTableModel) request_table.getModel();
        int rowCount = dm.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
    }

    private void loadFileRequests() {
        try {
            clearTable();
            approve_button.setEnabled(false);
            reject_button.setEnabled(false);

            Dbcon dbcon = new Dbcon();
            DefaultTableModel model = (DefaultTableModel) request_table.getModel();
            String str = "SELECT filereq.request_id,filereq.data_owner_approved,filereq.admin_approved,filereq.requested_date, filereq.request_priority, filereq.requested_data_member ,filereq.status,filereq.is_inter_company_file_request, "
                    + " datam.name as dataMemName,"
                    + " org.name as org_name,"
                    + " encrptlog.attr_1"
                    + " FROM "
                    + " tbl_file_request AS filereq , "
                    + " tbl_data_member AS datam ,"
                    + " tbl_organisation AS org,"
                    + " tbl_file_encryption_logs AS encrptlog"
                    + " WHERE "
                    + " filereq.requested_data_member = datam.data_member_id AND"
                    + " org.organisation_id = datam.organization_id AND"
                    + " encrptlog.encryption_id = filereq.encryption_id AND status!=1 and"
                    + " filereq.file_owner_data_member =" + DataMemberLogin.logged_in_user_id;
            ResultSet rs = dbcon.select(str);
            System.out.println(str);
            String arr[] = new String[10];
            while (rs.next()) {
                String request_id = rs.getString("request_id");
                String dataMemName = rs.getString("dataMemName");
                String org_name = rs.getString("org_name");
                String attr_1 = rs.getString("attr_1");
                String requested_date = getFormatedDate(rs.getString("requested_date"), "dd MM YYYY");
                String request_priority = rs.getString("request_priority").trim();
                if (request_priority.equals("0")) {
                    request_priority = "Low";
                } else if (request_priority.equals("1")) {
                    request_priority = "Medium";
                } else if (request_priority.equals("2")) {
                    request_priority = "High";
                }

                String status = rs.getString("status").trim();
                String data_owner_approved = rs.getString("data_owner_approved");
                String admin_approved = rs.getString("admin_approved");
                System.out.println("data_owner_approved " + data_owner_approved);
                System.out.println("admin_approved " + admin_approved);

                if (data_owner_approved!=null && data_owner_approved.trim().equals("1")) {
                    status = "Waiting for admin";
                } else if (status.equals("0")) {
                    status = "Rejected";
                } else if (status.equals("1")) {
                    status = "Approved";
                } else if (status.equals("2")) {
                    status = "Pending";
                }

                String is_inter_company_file_request = rs.getString("is_inter_company_file_request");

                arr[0] = request_id;
                arr[1] = dataMemName;
                arr[2] = org_name;
                arr[3] = attr_1;
                arr[4] = requested_date;
                arr[5] = request_priority;
                arr[6] = status;
                arr[7] = is_inter_company_file_request;

                model.addRow(arr);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        request_table = new javax.swing.JTable();
        approve_button = new javax.swing.JButton();
        reject_button = new javax.swing.JButton();
        refresh_label = new javax.swing.JLabel();
        bg1 = new javax.swing.JLabel();

        bg.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("HOME");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 24, 156, -1));

        jButton1.setText("LOGOUT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(566, 20, -1, -1));

        jButton2.setText("View Transfer History");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 87, -1, -1));

        jButton3.setText("View All Files");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 87, -1, -1));

        jButton4.setText("View Requested File Status");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 87, -1, -1));

        jButton5.setText("Create file& Upload");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(431, 87, -1, -1));

        jButton6.setText("Encryption History");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(566, 87, -1, -1));

        request_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "ORGANIZATION", "FILE", "DATE", "PRIORITY", "STATUS", "inter_org"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        request_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                request_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(request_table);
        if (request_table.getColumnModel().getColumnCount() > 0) {
            request_table.getColumnModel().getColumn(0).setMinWidth(50);
            request_table.getColumnModel().getColumn(0).setPreferredWidth(50);
            request_table.getColumnModel().getColumn(0).setMaxWidth(50);
            request_table.getColumnModel().getColumn(4).setResizable(false);
            request_table.getColumnModel().getColumn(6).setResizable(false);
            request_table.getColumnModel().getColumn(7).setMinWidth(0);
            request_table.getColumnModel().getColumn(7).setPreferredWidth(0);
            request_table.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 660, 180));

        approve_button.setText("APPROVE");
        approve_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approve_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(approve_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, -1, -1));

        reject_button.setText("REJECT");
        reject_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reject_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(reject_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, -1, -1));

        refresh_label.setText(" ");
        refresh_label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refresh_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refresh_labelMouseClicked(evt);
            }
        });
        getContentPane().add(refresh_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 11, 45, 41));

        bg1.setText("jLabel2");
        getContentPane().add(bg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -6, 730, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        ViewAllFiles viewAllFiles = new ViewAllFiles();
        viewAllFiles.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        ChooseFile chooseFile = new ChooseFile();
        chooseFile.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        EncryptionHistory encryptionHistory = new EncryptionHistory();
        encryptionHistory.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        DataMemberTransferHistory dataMemberTransferHistory = new DataMemberTransferHistory();
        dataMemberTransferHistory.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        ViewRequestedFileStatus viewRequestedFileStatus = new ViewRequestedFileStatus();
        viewRequestedFileStatus.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        MainLogin mainlogin = new MainLogin();
        mainlogin.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void approve_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approve_buttonActionPerformed
        // TODO add your handling code here:

        String request_id = request_table.getValueAt(request_table.getSelectedRow(), 0).toString();
        String status = request_table.getValueAt(request_table.getSelectedRow(), 6).toString();
        String is_inter_company_file_request = request_table.getValueAt(request_table.getSelectedRow(), 7).toString();
        System.out.println("is_inter_company_file_request  " + is_inter_company_file_request);
        if (is_inter_company_file_request.equals("0")) {
            // iside company request
            if (status.toLowerCase().equals("approved") || status.toLowerCase().equals("rejected")) {
                JOptionPane.showMessageDialog(rootPane, "Already approved");
            } else {
                Dbcon dbcon = new Dbcon();
                int updated = dbcon.update("update tbl_file_request set approve_reject_date='" + System.currentTimeMillis() + "' , status='1' where request_id='" + request_id + "'");
                if (updated > 0) {
                    request_table.setValueAt("Approved", request_table.getSelectedRow(), 6);
                    approve_button.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Could not approve now, please try again later");
                }
            }
        } else {
            // outside company request
            Dbcon dbcon = new Dbcon();
            int updated = dbcon.update("update tbl_file_request set approve_reject_date='" + System.currentTimeMillis() + "' , data_owner_approved=true where request_id='" + request_id + "'");
            if (updated > 0) {
                request_table.setValueAt("Approved", request_table.getSelectedRow(), 6);
                approve_button.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Could not approve now, please try again later");
            }
        }


    }//GEN-LAST:event_approve_buttonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void reject_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reject_buttonActionPerformed
        // TODO add your handling code here:
        String request_id = request_table.getValueAt(request_table.getSelectedRow(), 0).toString();
        String status = request_table.getValueAt(request_table.getSelectedRow(), 6).toString();
        String is_inter_company_file_request = request_table.getValueAt(request_table.getSelectedRow(), 7).toString();

        if (is_inter_company_file_request.equals("0")) {
            // iside company request
            if (status.toLowerCase().equals("approved") || status.toLowerCase().equals("rejected")) {
                JOptionPane.showMessageDialog(rootPane, "Already rejected");
            } else {
                Dbcon dbcon = new Dbcon();
                int updated = dbcon.update("update tbl_file_request set approve_reject_date='" + System.currentTimeMillis() + "' , status='0' where request_id='" + request_id + "'");
                if (updated > 0) {
                    request_table.setValueAt("Rejected", request_table.getSelectedRow(), 6);
                    reject_button.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Could not reject now, please try again later");
                }
            }
        } else {
            // outside company request
            Dbcon dbcon = new Dbcon();
            int updated = dbcon.update("update tbl_file_request set approve_reject_date='" + System.currentTimeMillis() + "' , status='0' , remark='Data owner rejeted' where request_id='" + request_id + "'");
            if (updated > 0) {
                request_table.setValueAt("Rejected", request_table.getSelectedRow(), 6);
                reject_button.setEnabled(false);
                approve_button.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Could not reject now, please try again later");
            }
        }
    }//GEN-LAST:event_reject_buttonActionPerformed

private void request_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_request_tableMouseClicked

    String request_id = request_table.getValueAt(request_table.getSelectedRow(), 0).toString();
    String status = request_table.getValueAt(request_table.getSelectedRow(), 6).toString();
    String is_inter_company_file_request = request_table.getValueAt(request_table.getSelectedRow(), 7).toString();

    if (status.toLowerCase().equals("approved") || status.toLowerCase().equals("rejected")) {
        approve_button.setEnabled(false);
        reject_button.setEnabled(false);
    } else {
        approve_button.setEnabled(true);
        reject_button.setEnabled(true);
    }


    // TODO add your handling code here:
}//GEN-LAST:event_request_tableMouseClicked

private void refresh_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refresh_labelMouseClicked

    loadFileRequests();
    JOptionPane.showMessageDialog(rootPane, "Refresh completed");
    // TODO add your handling code here:
}//GEN-LAST:event_refresh_labelMouseClicked

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
            java.util.logging.Logger.getLogger(DataMemberHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataMemberHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataMemberHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataMemberHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new DataMemberHome().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approve_button;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bg1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel refresh_label;
    private javax.swing.JButton reject_button;
    private javax.swing.JTable request_table;
    // End of variables declaration//GEN-END:variables
}
