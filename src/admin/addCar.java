/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import authentication.LOGIN;
import config.db_connector;
import config.passwordHasher;
import static javax.management.remote.JMXConnectorFactory.connect;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Administrator
 */
public class addCar extends javax.swing.JFrame {

    /**
     * Creates new form REGISTER
     */
    public addCar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        carname = new javax.swing.JTextField();
        number = new javax.swing.JTextField();
        cat = new javax.swing.JComboBox<>();
        update = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        cid = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 0, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 550));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel7.setText("Category:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel8.setText("Status:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        add.setBackground(new java.awt.Color(102, 0, 255));
        add.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 83, 30));

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel13.setText("Car ID:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel14.setText("Car Plate Number:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));
        jPanel1.add(carname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 333, 40));
        jPanel1.add(number, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 333, 40));

        cat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2 wheels", "4 wheels", "6 wheels", "10 wheels" }));
        jPanel1.add(cat, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 333, 40));

        update.setBackground(new java.awt.Color(102, 0, 255));
        update.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        update.setText("Update");
        update.setEnabled(false);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 83, 30));

        jButton3.setBackground(new java.awt.Color(102, 0, 255));
        jButton3.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, 83, 30));

        jButton4.setBackground(new java.awt.Color(102, 0, 255));
        jButton4.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jButton4.setText("Refresh");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 83, 30));

        jButton5.setBackground(new java.awt.Color(102, 0, 255));
        jButton5.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 490, 83, 30));

        jButton6.setBackground(new java.awt.Color(102, 0, 255));
        jButton6.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jButton6.setText("Cancel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 490, 83, 30));

        cid.setEnabled(false);
        jPanel1.add(cid, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 330, 40));

        jLabel17.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel17.setText("Car Name:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Pending" }));
        jPanel1.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 330, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 390, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
    String Carname = carname.getText().trim();
    String Number = number.getText().trim();
    String Cat = cat.getSelectedItem().toString().trim();
    String Status = status.getSelectedItem().toString();

db_connector connect = new db_connector();

// Validation
if (Carname.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Please enter the Car Name!", "Error", JOptionPane.WARNING_MESSAGE);
} else if (Number.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Please enter the Car Number!", "Error", JOptionPane.WARNING_MESSAGE);
} else if (Cat.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Please select a Category!", "Error", JOptionPane.WARNING_MESSAGE);
} else if (Status.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Please select a Status!", "Error", JOptionPane.WARNING_MESSAGE);
} else {
    try {
        // FIX: Check for existing car number, not category
        if (connect.fieldExists("car", "c_number", Number)) {
            JOptionPane.showMessageDialog(null, "Car number already exists!", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            String sql = "INSERT INTO car (c_name, c_number, category, status) VALUES (?, ?, ?, ?)";
            int rowsInserted = connect.insertData(sql, Carname, Number, Cat, Status);

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Car Registered Successfully!");

                new LOGIN().setVisible(true);

                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(carname);
                if (frame != null) {
                    frame.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Car registration failed!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    }//GEN-LAST:event_addActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
   if (carname.getText().isEmpty() || number.getText().isEmpty() || 
    cat.getSelectedItem() == null || status.getSelectedItem() == null || 
    cid.getText().isEmpty()) {

    JOptionPane.showMessageDialog(null, "All Fields Are Required!");

} else {
    db_connector cdb = new db_connector();
    try {
        int carId;
        try {
            carId = Integer.parseInt(cid.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Car ID!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check if car number already exists in another record
        boolean carNumberExists = cdb.duplicateCheckExcludingCurrent("car", "c_number", number.getText(), "id", String.valueOf(carId));

        if (carNumberExists) {
            JOptionPane.showMessageDialog(null, "Car number already exists for another record!", "Validation Error", JOptionPane.WARNING_MESSAGE);
        } else {
            int rowsUpdated = cdb.updateData(
                "UPDATE car SET c_name = ?, c_number = ?, category = ?, status = ? WHERE c_id = ?",
                carname.getText(),
                number.getText(),
                cat.getSelectedItem().toString(),
                status.getSelectedItem().toString(),
                carId
            );

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Car updated successfully!");
                this.dispose();
                new LOGIN().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Update failed! Car ID not found.", "Update Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        cdb.closeConnection();
    }
}

    }//GEN-LAST:event_updateActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        USERS s = new USERS();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(addCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addCar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton add;
    public javax.swing.JTextField carname;
    public javax.swing.JComboBox<String> cat;
    public javax.swing.JTextField cid;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField number;
    public javax.swing.JComboBox<String> status;
    public javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
