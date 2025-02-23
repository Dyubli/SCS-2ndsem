
import admin.adminDashboard;
import config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import user.userDashboard;

public class login extends javax.swing.JFrame {

    /**
     * Creates new form SCS
     */
    public login() {
        initComponents();
    }
    
    static String status;
    static String type;
    
    
     public static boolean loginAcc(String username, String password){
        dbConnector connector = new dbConnector();       
        try{
            String query = "SELECT * FROM tbl_user  WHERE u_user = '" + username + "' AND u_pass = '" + password + "'";
            ResultSet resultSet = connector.getData(query);   
      if(resultSet.next()){
       status = resultSet.getString("u_status");
       type = resultSet.getString("u_type");
      return true;
      }else{
            return false;
      } 
            
        }catch (SQLException ex) {
            return false;
        }

    }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        donthaveaccount = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        user = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        donthaveaccount1 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/2-removebg-preview.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, -10, 430, 540));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 500));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("____________________________________________________________________________________");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 710, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel3.setText("SIGN IN");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 260, 70));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Enter Password");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 220, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Enter Username");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 220, 60));

        donthaveaccount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        donthaveaccount.setText("click here to Register");
        donthaveaccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                donthaveaccountMouseClicked(evt);
            }
        });
        jPanel1.add(donthaveaccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 410, 140, 20));

        loginButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        loginButton.setText("SUBMIT");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        jPanel1.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 360, 150, 40));
        jPanel1.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 400, 40));
        jPanel1.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 400, 40));

        donthaveaccount1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        donthaveaccount1.setText("Don't have an account yet?   ");
        jPanel1.add(donthaveaccount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 410, 190, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 910, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
         if (loginAcc(user.getText(), pass.getText())) { 
            if (!status.equals("Active")) {
                JOptionPane.showMessageDialog(null, "Account is not active!");
            } else {
                JOptionPane.showMessageDialog(null, "Login Success!");
                if (type.equals("Admin")) {
                    adminDashboard ad = new adminDashboard();
                    ad.setVisible(true);
                } else if (type.equals("User")) {
                    userDashboard us = new userDashboard();
                    us.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Account not found!");
                }
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Login Failed!");
        }
    
        

        
    }//GEN-LAST:event_loginButtonActionPerformed

    private void donthaveaccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_donthaveaccountMouseClicked
     register re = new register();
     re.setVisible(true);
     this.dispose();
    }//GEN-LAST:event_donthaveaccountMouseClicked

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel donthaveaccount;
    private javax.swing.JLabel donthaveaccount1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
