/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import admin.addUser;
import config.Session;
import config.db_connector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Administrator
 */
public class USERS extends javax.swing.JFrame {

    /**
     * Creates new form USERS
     */
    public USERS() {
        initComponents();
         displayData();
    }
   public void displayData() {
    db_connector dbc = new db_connector(); 
    ResultSet rs = null;

    try {
        rs = dbc.getData("SELECT * FROM users");  
        usersTable.setModel(DbUtils.resultSetToTableModel(rs));  
    } catch (SQLException ex) {
        System.out.println("Errors: " + ex.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();  
            dbc.close(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        username = new javax.swing.JLabel();
        userid = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Users");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 39));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 0, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton1.setText("Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 110, 30));

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 110, 30));

        username.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        username.setText("User");
        jPanel2.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        userid.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        userid.setText("ID:");
        jPanel2.add(userid, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, -1, -1));

        jButton5.setBackground(new java.awt.Color(204, 204, 204));
        jButton5.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 110, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Current ID:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 170, 450));

        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(usersTable);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 400, 390));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 620, 430));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    int rowIndex = usersTable.getSelectedRow();
        if(rowIndex < 0){
            JOptionPane.showMessageDialog(null,"Please Select an Item!");
        }else{
            try{

                db_connector dbc = new db_connector();
                TableModel tbl = usersTable.getModel();
                ResultSet rst = dbc.getData("SELECT * FROM users WHERE u_id = '"+tbl.getValueAt(rowIndex, 0)+"'");
                if(rst.next()){
                    addUser cuf = new addUser();
                    cuf.uid.setText(""+rst.getInt("u_id"));
                    cuf.un.setText(""+rst.getString("username"));
                    cuf.firstname.setText(""+rst.getString("firstname"));
                    cuf.lastname.setText(""+rst.getString("lastname"));
                    cuf.password.setText(""+rst.getString("password"));
                    cuf.usertype1.setSelectedItem(""+rst.getString("usertype"));
                    cuf.status.setSelectedItem(""+rst.getString("status"));
                    cuf.images.setIcon(cuf.ResizeImage(rst.getString("images"), null, cuf.images));
                    cuf.oldpath = rst.getString("images");
                    cuf.path = rst.getString("images");
                    cuf.destination = rst.getString("images");
                    cuf.add.setEnabled(false);
                    cuf.update.setEnabled(true);
                    cuf.password.setEnabled(false);

                    if(rst.getString("images").isEmpty()){
                        cuf.select.setEnabled(true);
                        cuf.remove.setEnabled(false);
                    }else{
                        cuf.select.setEnabled(false);
                        cuf.remove.setEnabled(true);
                    }
                    cuf.setVisible(true);
                    this.dispose();

                }
            }catch(SQLException ex){
                System.out.println(""+ex);
            }
        }
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      addUser au = new addUser();
      au.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
         Session sess = Session.getInstance();
          userid.setText(""+sess.getId());
          username.setText(""+sess.getUsername());
    }//GEN-LAST:event_formWindowActivated

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        AdminDashboard s = new AdminDashboard();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(USERS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(USERS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(USERS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(USERS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new USERS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel userid;
    private javax.swing.JLabel username;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
}
