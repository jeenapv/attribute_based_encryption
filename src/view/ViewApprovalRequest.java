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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jithinpv
 */
public class ViewApprovalRequest extends javax.swing.JFrame {

    /**
     * Creates new form ViewApprovalRequest
     */
    public ViewApprovalRequest() {
         Nimbus.loadLoogAndFeel();
        initComponents();
        this.setLocationRelativeTo(null);
        loadApprovalRequests();
        approve_button.setEnabled(false);
        reject_button.setEnabled(false);
         Configuration.setIconOnLabel("createOrg.jpg", bg);
    }

    private void clearTable() throws Exception {
        DefaultTableModel dm = (DefaultTableModel) request_table.getModel();
        int rowCount = dm.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
    }

    private void loadApprovalRequests() {
        try {
            clearTable();
            approve_button.setEnabled(false);
            reject_button.setEnabled(false);

            Dbcon dbcon = new Dbcon();
            DefaultTableModel model = (DefaultTableModel) request_table.getModel();
            String str = "SELECT filereq.request_id,filereq.data_owner_approved,filereq.admin_approved,filereq.requested_date, filereq.request_priority, filereq.requested_data_member ,filereq.status,filereq.is_inter_company_file_request,  "
                    + " datam.name AS dataMemName, org.name AS org_name, encrptlog.attr_1 ,encrptlog.attr_2,encrptlog.attr_3,encrptlog.attr_4, "
                    + " datam2.name AS dataOwnerName, org2.name AS dataOwnweOrg"
                    + " FROM  "
                    + " tbl_file_request AS filereq ,  "
                    + " tbl_data_member AS datam , "
                    + " tbl_organisation AS org, "
                    + " tbl_data_member AS datam2 , "
                    + " tbl_organisation AS org2, "
                    + " tbl_file_encryption_logs AS encrptlog WHERE  "
                    + " filereq.requested_data_member = datam.data_member_id AND "
                    + " org.organisation_id = datam.organization_id AND "
                    + " encrptlog.encryption_id = filereq.encryption_id AND "
                    + " datam2.data_member_id = filereq.file_owner_data_member AND"
                    + " org2.organisation_id = datam2.organization_id AND"
                    + " filereq.data_owner_approved = TRUE AND "
                    + " filereq.status = 2";

            System.out.println(str);
            ResultSet rs = dbcon.select(str);

            String arr[] = new String[15];
            while (rs.next()) {

                String req_dataMemName = rs.getString("dataMemName");
                String req_org_name = rs.getString("org_name");
                String request_id = rs.getString("request_id");

                String dataOwnerName = rs.getString("dataOwnerName");
                String dataOwnweOrg = rs.getString("dataOwnweOrg");

                String attr1 = rs.getString("attr_1");
                String attr2 = rs.getString("attr_2");
                String attr3 = rs.getString("attr_3");
                String attr4 = rs.getString("attr_4");

                String requested_date = getFormatedDate(rs.getString("requested_date"), "dd MM YYYY");

//                String attr_1 = rs.getString("attr_1");
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

                if (data_owner_approved != null && data_owner_approved.trim().equals("1")) {
                    status = "Waiting for admin";
                } else if (status.equals("0")) {
                    status = "Rejected";
                } else if (status.equals("1")) {
                    status = "Approved";
                } else if (status.equals("2")) {
                    status = "Pending";
                }

                String is_inter_company_file_request = rs.getString("is_inter_company_file_request");

                arr[0] = req_dataMemName;
                arr[1] = req_org_name;
                arr[2] = dataOwnerName;
                arr[3] = dataOwnweOrg;
                arr[4] = requested_date;
                arr[5] = status;
                arr[6] = attr1;
                arr[7] = request_id;
                arr[8] = attr1;
                arr[9] = (Long.parseLong(attr2) / 1024) + " Kb";
                arr[10] = attr3;
                arr[11] = request_priority;

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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        request_table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        file_name_text = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        file_size_text = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        file_type_text = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        priority_text = new javax.swing.JTextField();
        approve_button = new javax.swing.JButton();
        reject_button = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Requests");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 26, 97, -1));

        request_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SENDER", "ORGANIZATION", "RECEIVER", "ORGANIZATION", "DATE", "STATUS", "req_id", "fileName", "file size", "file type", "extenstion", "priority"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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
            request_table.getColumnModel().getColumn(0).setResizable(false);
            request_table.getColumnModel().getColumn(1).setResizable(false);
            request_table.getColumnModel().getColumn(2).setResizable(false);
            request_table.getColumnModel().getColumn(5).setResizable(false);
            request_table.getColumnModel().getColumn(6).setMinWidth(0);
            request_table.getColumnModel().getColumn(6).setPreferredWidth(0);
            request_table.getColumnModel().getColumn(6).setMaxWidth(0);
            request_table.getColumnModel().getColumn(7).setMinWidth(0);
            request_table.getColumnModel().getColumn(7).setPreferredWidth(0);
            request_table.getColumnModel().getColumn(7).setMaxWidth(0);
            request_table.getColumnModel().getColumn(8).setMinWidth(0);
            request_table.getColumnModel().getColumn(8).setPreferredWidth(0);
            request_table.getColumnModel().getColumn(8).setMaxWidth(0);
            request_table.getColumnModel().getColumn(9).setMinWidth(0);
            request_table.getColumnModel().getColumn(9).setPreferredWidth(0);
            request_table.getColumnModel().getColumn(9).setMaxWidth(0);
            request_table.getColumnModel().getColumn(10).setMinWidth(0);
            request_table.getColumnModel().getColumn(10).setPreferredWidth(0);
            request_table.getColumnModel().getColumn(10).setMaxWidth(0);
            request_table.getColumnModel().getColumn(11).setMinWidth(0);
            request_table.getColumnModel().getColumn(11).setPreferredWidth(0);
            request_table.getColumnModel().getColumn(11).setMaxWidth(0);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 58, 681, 188));

        jLabel2.setText("File Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 284, 136, -1));
        getContentPane().add(file_name_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 281, 161, -1));

        jLabel3.setText("File Size");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 322, 136, -1));
        getContentPane().add(file_size_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 319, 161, -1));

        jLabel4.setText("File Type");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 360, 136, -1));
        getContentPane().add(file_type_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 357, 161, -1));

        jLabel5.setText("Priority");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 398, 136, -1));
        getContentPane().add(priority_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 395, 161, -1));

        approve_button.setText("APPROVE");
        approve_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approve_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(approve_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 449, -1, -1));

        reject_button.setText("REJECT");
        reject_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reject_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(reject_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 449, -1, -1));

        jButton3.setText("HOME");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 449, -1, -1));

        bg.setText("jLabel6");
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -6, 700, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        AdminHome adminHome = new AdminHome();
        adminHome.setVisible(true);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void reject_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reject_buttonActionPerformed

        String request_id = request_table.getValueAt(request_table.getSelectedRow(), 7).toString();

        {
            Dbcon dbcon = new Dbcon();
            int updated = dbcon.update("update tbl_file_request set approve_reject_date='" + System.currentTimeMillis() + "' , admin_approved=false, status=2, remark='Admin rejected'  where request_id='" + request_id + "'");
            if (updated > 0) {
                approve_button.setEnabled(false);
                reject_button.setEnabled(false);
                JOptionPane.showMessageDialog(rootPane, "Sucessfully rejected");
                file_name_text.setText(null);
                file_size_text.setText(null);
                file_type_text.setText(null);
                priority_text.setText(null);
                loadApprovalRequests();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Could not approve now, please try again later");
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_reject_buttonActionPerformed

    private void approve_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approve_buttonActionPerformed

        String request_id = request_table.getValueAt(request_table.getSelectedRow(), 7).toString();

        {
            Dbcon dbcon = new Dbcon();
            int updated = dbcon.update("update tbl_file_request set approve_reject_date='" + System.currentTimeMillis() + "' , admin_approved=true, status=1  where request_id='" + request_id + "'");
            if (updated > 0) {
                approve_button.setEnabled(false);
                reject_button.setEnabled(false);
                JOptionPane.showMessageDialog(rootPane, "Sucessfully approved");
                file_name_text.setText(null);
                file_size_text.setText(null);
                file_type_text.setText(null);
                priority_text.setText(null);
                loadApprovalRequests();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Could not approve now, please try again later");
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_approve_buttonActionPerformed

private void request_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_request_tableMouseClicked

    String request_id = request_table.getValueAt(request_table.getSelectedRow(), 6).toString();
    approve_button.setEnabled(true);
    reject_button.setEnabled(true);
    file_name_text.setText(request_table.getValueAt(request_table.getSelectedRow(), 8).toString());
    file_size_text.setText(request_table.getValueAt(request_table.getSelectedRow(), 9).toString());
    file_type_text.setText(request_table.getValueAt(request_table.getSelectedRow(), 10).toString());
    priority_text.setText(request_table.getValueAt(request_table.getSelectedRow(), 11).toString());
    file_name_text.setEditable(false);
    file_size_text.setEditable(false);
    file_type_text.setEditable(false);
    priority_text.setEditable(false);
    // TODO add your handling code here:
}//GEN-LAST:event_request_tableMouseClicked

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
            java.util.logging.Logger.getLogger(ViewApprovalRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewApprovalRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewApprovalRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewApprovalRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ViewApprovalRequest().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approve_button;
    private javax.swing.JLabel bg;
    private javax.swing.JTextField file_name_text;
    private javax.swing.JTextField file_size_text;
    private javax.swing.JTextField file_type_text;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField priority_text;
    private javax.swing.JButton reject_button;
    private javax.swing.JTable request_table;
    // End of variables declaration//GEN-END:variables
}
