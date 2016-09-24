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
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jithinpv
 */
public class ViewAllFiles extends javax.swing.JFrame {

    /**
     * Creates new form ViewAllFiles
     */
    public ViewAllFiles() {
         Nimbus.loadLoogAndFeel();
        initComponents();
        this.setLocationRelativeTo(null);
        loadAllFileSend();
        clearAll();
        Configuration.setIconOnLabel("chooseFile.jpg", bg);
    }

    private void loadAllFileSend() {
        Dbcon dbcon = new Dbcon();
        DefaultTableModel dt = (DefaultTableModel) all_files_table.getModel();
        String query = "SELECT datam.name , "
                + "enc.encryption_id, "
                + "enc.encrypted_file_path, "
                + "enc.attr_1, enc.attr_2, enc.attr_3, enc.attr_4, "
                + "enc.created_at, "
                + "org.name AS org_name "
                + "FROM tbl_file_encryption_logs AS enc , "
                + "tbl_data_member AS datam , "
                + "tbl_organisation AS org "
                + "WHERE enc.data_member_id=datam.data_member_id "
                + "AND datam.organization_id = org.organisation_id";
        ResultSet rs = dbcon.select(query);

        try {
            String arr[] = new String[10];
            DefaultTableModel model = (DefaultTableModel) all_files_table.getModel();
            while (rs.next()) {
                String encryption_id = rs.getString("encryption_id");
                String dataMemberName = rs.getString("name");
                String org_name = rs.getString("org_name");
                String fileName = rs.getString("attr_1");
                String dateOfEncryption = getFormatedDate(rs.getString("created_at"), "dd MM YYYY");
                String size = (Long.parseLong(rs.getString("attr_2")) / 1024) + " Kb";
                String file_extension = rs.getString("attr_3");

                arr[0] = encryption_id;
                arr[1] = dataMemberName;
                arr[2] = org_name;
                arr[3] = fileName;
                arr[4] = dateOfEncryption;
                arr[5] = size;
                arr[6] = file_extension;
                model.addRow(arr);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        all_files_table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        file_name_text = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        file_size_text = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        file_type_text = new javax.swing.JTextField();
        request_button = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        request_priority = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        request_status_label = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        all_files_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DATA MEMBER", "ORGANIZATION", "FILE", "DATE", "size", "type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        all_files_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                all_files_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(all_files_table);
        if (all_files_table.getColumnModel().getColumnCount() > 0) {
            all_files_table.getColumnModel().getColumn(0).setMinWidth(50);
            all_files_table.getColumnModel().getColumn(0).setPreferredWidth(50);
            all_files_table.getColumnModel().getColumn(0).setMaxWidth(50);
            all_files_table.getColumnModel().getColumn(5).setMinWidth(0);
            all_files_table.getColumnModel().getColumn(5).setPreferredWidth(0);
            all_files_table.getColumnModel().getColumn(5).setMaxWidth(0);
            all_files_table.getColumnModel().getColumn(6).setMinWidth(0);
            all_files_table.getColumnModel().getColumn(6).setPreferredWidth(0);
            all_files_table.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 64, 528, 226));

        jLabel1.setText("ALL FILES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 32, -1, -1));

        jLabel2.setText("File Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 311, 111, -1));

        file_name_text.setEditable(false);
        getContentPane().add(file_name_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 308, 170, -1));

        jLabel3.setText("File Size");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 342, 111, -1));

        file_size_text.setEditable(false);
        getContentPane().add(file_size_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 339, 170, -1));

        jLabel4.setText("File Type");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 380, 111, -1));

        file_type_text.setEditable(false);
        getContentPane().add(file_type_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 377, 170, -1));

        request_button.setText("REQUEST");
        request_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                request_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(request_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 491, -1, -1));

        jButton2.setText("CLEAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 491, -1, -1));

        jButton3.setText("HOME");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 491, -1, -1));

        jLabel5.setText("Request priority");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 456, 111, -1));

        request_priority.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "low", "medium", "high" }));
        getContentPane().add(request_priority, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 453, 170, -1));

        jLabel6.setText("Request status");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 408, 95, -1));

        request_status_label.setText(" ");
        getContentPane().add(request_status_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 408, 170, -1));

        bg.setText("jLabel7");
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -6, 560, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        DataMemberHome dataMemberHome = new DataMemberHome();
        dataMemberHome.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void all_files_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all_files_tableMouseClicked
        // TODO add your handling code here:
        String id = all_files_table.getValueAt(all_files_table.getSelectedRow(), 0).toString();
        Dbcon dbcon = new Dbcon();
        ResultSet rs = dbcon.select("select * from tbl_file_encryption_logs where encryption_id='" + id + "'");
        try {
            if (rs.next()) {
                String filename = rs.getString(2);
                String file_owner_data_member = rs.getString("data_member_id");
                file_name_text.setText(filename);
                String filesize = (Long.parseLong(rs.getString("attr_2").trim()) / 1024) + " Kb";
                file_size_text.setText(filesize);
                String filetype = rs.getString("attr_3");
                file_type_text.setText(filetype);
                request_button.setEnabled(true);
                String alreadyRequestedQuery = "select * from tbl_file_request where requested_data_member=" + DataMemberLogin.logged_in_user_id
                        + " and file_owner_data_member=" + file_owner_data_member
                        + " and encryption_id=" + id;
                System.out.println(alreadyRequestedQuery);
                ResultSet select = new Dbcon().select(alreadyRequestedQuery);
                if (select.next()) {
                    // already send a request
                    String status = select.getString("status");
                    if (status.equals("1")) {
                        request_status_label.setText("Approved");
                    } else if (status.equals("0")) {
                        request_status_label.setText("Rejected");
                    } else {
                        request_status_label.setText("Pending");
                    }
                } else {
                    // not send request yet
                    request_status_label.setText("Not requested yet");
                }


            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_all_files_tableMouseClicked

    private void request_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_request_buttonActionPerformed
        // TODO add your handling code here:
        String priority = request_priority.getSelectedItem().toString();

        String id = all_files_table.getValueAt(all_files_table.getSelectedRow(), 0).toString();
        String dataMember = all_files_table.getValueAt(all_files_table.getSelectedRow(), 1).toString();
        String organization = all_files_table.getValueAt(all_files_table.getSelectedRow(), 2).toString();
        String file = all_files_table.getValueAt(all_files_table.getSelectedRow(), 3).toString();
        String date = all_files_table.getValueAt(all_files_table.getSelectedRow(), 4).toString();
        Dbcon dbcon = new Dbcon();
        ResultSet rs = dbcon.select("select data_member_id from tbl_file_encryption_logs where encryption_id='" + id + "'");

        try {
            if (rs.next()) {
                int priorityValue = 0;
                if (priority.trim().toLowerCase().equals("low")) {
                    priorityValue = 0;
                } else if (priority.trim().toLowerCase().equals("medium")) {
                    priorityValue = 1;
                } else if (priority.trim().toLowerCase().equals("high")) {
                    priorityValue = 2;
                }

                String member_id = rs.getString(1);

                if (Integer.parseInt(member_id.trim()) == DataMemberLogin.logged_in_user_id) {
                    JOptionPane.showMessageDialog(rootPane, "Dont have to send request to your own file");
                } else {
                    String alreadyRequestedQuery = "select * from tbl_file_request where requested_data_member=" + DataMemberLogin.logged_in_user_id
                            + " and file_owner_data_member=" + member_id
                            + " and encryption_id=" + id;
                    System.out.println(alreadyRequestedQuery);
                    ResultSet select = new Dbcon().select(alreadyRequestedQuery);
                    if (select.next()) {
                        JOptionPane.showMessageDialog(rootPane, "Already requested file permission");
                    } else {
                        int ins = dbcon.insert("insert into tbl_file_request(requested_data_member, "
                                + "file_owner_data_member, "
                                + "encryption_id, "
                                + "requested_date, "
                                + "request_priority,is_inter_company_file_request) "
                                + "values('" + DataMemberLogin.logged_in_user_id + "','" + member_id + "','" + id + "','" + System.currentTimeMillis() + "','" + priorityValue + "'," + checkInterCompanyFileRequest(DataMemberLogin.logged_in_user_id + "", member_id) + ")");
                        if (ins == 1) {
                            JOptionPane.showMessageDialog(rootPane, "Sucessfully requested to the file owner. Waiting for permission");
                            request_status_label.setText("Pending");
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Could not send request now. Please try again later");
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_request_buttonActionPerformed

    private void clearAll() {
        request_priority.setSelectedIndex(0);
        file_name_text.setText("");
        file_size_text.setText("");
        file_type_text.setText("");
        request_status_label.setText("");
        all_files_table.clearSelection();
        request_button.setEnabled(false);
    }
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    clearAll();

    // TODO add your handling code here:
}//GEN-LAST:event_jButton2ActionPerformed

    private int checkInterCompanyFileRequest(String fromUserId, String toUserId) {
        int companySame = 0;
        try {
            String sql = "select organization_id from tbl_data_member where data_member_id=" + fromUserId;
            ResultSet rs1 = new Dbcon().select(sql);
            String organisation1 = "";
            String organisation2 = "";
            if (rs1.next()) {
                organisation1 = rs1.getString(1);
            }
            sql = "select organization_id from tbl_data_member where data_member_id=" + toUserId;
            ResultSet rs2 = new Dbcon().select(sql);
            if (rs2.next()) {
                organisation2 = rs2.getString(1);
            }

            if (!organisation1.equals(organisation2)) {
                companySame = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companySame;
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
            java.util.logging.Logger.getLogger(ViewAllFiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAllFiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAllFiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAllFiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ViewAllFiles().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable all_files_table;
    private javax.swing.JLabel bg;
    private javax.swing.JTextField file_name_text;
    private javax.swing.JTextField file_size_text;
    private javax.swing.JTextField file_type_text;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton request_button;
    private javax.swing.JComboBox request_priority;
    private javax.swing.JLabel request_status_label;
    // End of variables declaration//GEN-END:variables
}
