/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Db.Dbcon;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Requests");

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

        jLabel2.setText("File Name");

        jLabel3.setText("File Size");

        jLabel4.setText("File Type");

        jLabel5.setText("Priority");

        approve_button.setText("APPROVE");
        approve_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approve_buttonActionPerformed(evt);
            }
        });

        reject_button.setText("REJECT");
        reject_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reject_buttonActionPerformed(evt);
            }
        });

        jButton3.setText("HOME");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(27, 27, 27)
                                            .addComponent(file_type_text, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27)
                                                .addComponent(file_size_text, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27)
                                                .addComponent(file_name_text, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(approve_button)
                                                .addGap(18, 18, 18)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(reject_button)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton3))
                                            .addComponent(priority_text, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 294, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(file_name_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(file_size_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(file_type_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(priority_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(approve_button)
                    .addComponent(reject_button)
                    .addComponent(jButton3))
                .addGap(20, 20, 20))
        );

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
