/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package authentication;

import config.db_connector;
import config.passwordHasher;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Administrator
 */
public class fogortpassword extends javax.swing.JFrame {

    /** Creates new form fogortpassword */
    public fogortpassword() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        username = new javax.swing.JTextField();
        sec = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        sac = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 0, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 60));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel13.setText("Fogort Password");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        jButton3.setBackground(new java.awt.Color(102, 0, 255));
        jButton3.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 200, 50));

        username.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 390, 40));

        sec.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(sec, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 390, 40));

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel17.setText("Security Answer:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, -1, -1));

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel15.setText("User Name:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        jLabel16.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel16.setText("Security Answer:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, -1, -1));

        sac.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        sac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is your favorite color?", "How old are you?", "What is your favorite animal?", "Who is your Mother?" }));
        jPanel1.add(sac, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 390, 40));

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel14.setText("New Password:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, -1, -1));
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 390, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 690, 440));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
           String usernameInput = username.getText().trim();
    String selectedQuestion = sac.getSelectedItem().toString();
    String answerInput = sec.getText().trim().toLowerCase();
    String newPassword = password.getText().trim();

db_connector connect = new db_connector();

if (usernameInput.isEmpty() || selectedQuestion.isEmpty() || answerInput.isEmpty() || newPassword.isEmpty()) {
    JOptionPane.showMessageDialog(null, "All fields must be filled!", "Error", JOptionPane.WARNING_MESSAGE);
} else if (newPassword.length() < 8) {
    JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long!", "Error", JOptionPane.WARNING_MESSAGE);
} else {
    try {
        // Query user info
        String sql = "SELECT password, sec_question, sec_answer FROM users WHERE username = ?";
        ResultSet rs = connect.getData(sql, usernameInput);

        if (rs.next()) {
            String oldHashedPassword = rs.getString("password");
            String dbQuestion = rs.getString("sec_question");
            String dbAnswer = rs.getString("sec_answer").toLowerCase();

            if (!selectedQuestion.equals(dbQuestion)) {
                JOptionPane.showMessageDialog(null, "Security question does not match our records!", "Error", JOptionPane.WARNING_MESSAGE);
            } else if (!answerInput.equals(dbAnswer)) {
                JOptionPane.showMessageDialog(null, "Security answer is incorrect!", "Error", JOptionPane.WARNING_MESSAGE);
            } else if (passwordHasher.checkPassword(newPassword, oldHashedPassword)) {
                JOptionPane.showMessageDialog(null, "New password must be different from the old password!", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                String newHashedPassword = passwordHasher.hashPassword(newPassword);
                String updateSql = "UPDATE users SET password = ? WHERE username = ?";
                int updatedRows = connect.updateData(updateSql, newHashedPassword, usernameInput);

                if (updatedRows > 0) {
                    JOptionPane.showMessageDialog(null, "Password updated successfully!");
                    new LOGIN().setVisible(true);
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(username);
                    if (frame != null) frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to update password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "User not found!", "Error", JOptionPane.WARNING_MESSAGE);
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(fogortpassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fogortpassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fogortpassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fogortpassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fogortpassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField password;
    private javax.swing.JComboBox<String> sac;
    private javax.swing.JTextField sec;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

}
