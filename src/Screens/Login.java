package Screens;
import Methods.InputChecker;
import Methods.ReadTxtFile;
import p_case.*;
import Methods.TXTReader;
import Methods.WriteInTxtFile;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Robin
 */
public class Login extends javax.swing.JFrame{

    /**
     * Creates new form Login
     */
    public Login() {
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

        jTextUser = new javax.swing.JTextField();
        jTextPasswort = new javax.swing.JTextField();
        jLabelUser = new javax.swing.JLabel();
        jLabelPasswort = new javax.swing.JLabel();
        jButtonFAQ = new javax.swing.JButton();
        jTextLogo = new javax.swing.JTextField();
        jButtonRegister = new javax.swing.JButton();
        jButtonRegister1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelUser.setText("Benutzername");

        jLabelPasswort.setText("Passwort");

        jButtonFAQ.setText("?");
        jButtonFAQ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonFAQMouseClicked(evt);
            }
        });

        jTextLogo.setEditable(false);
        jTextLogo.setBackground(new java.awt.Color(102, 255, 255));
        jTextLogo.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextLogo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextLogo.setText("P-CASE");

        jButtonRegister.setText("Registrieren");
        jButtonRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRegisterMouseClicked(evt);
            }
        });

        jButtonRegister1.setText("Login");
        jButtonRegister1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRegister1MouseClicked(evt);
            }
        });
        jButtonRegister1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegister1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelUser, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelPasswort, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextPasswort, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextUser, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(103, 103, 103))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(9, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButtonRegister)
                .addGap(4, 4, 4)
                .addComponent(jButtonFAQ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonRegister1)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextPasswort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPasswort))
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFAQ)
                    .addComponent(jButtonRegister)
                    .addComponent(jButtonRegister1))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFAQMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonFAQMouseClicked
       TXTReader reader = new TXTReader();
        JOptionPane.showMessageDialog(null, reader.getFAQs());
    }//GEN-LAST:event_jButtonFAQMouseClicked

    private void jButtonRegister1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRegister1MouseClicked
        
        //schauen ob username und passwort zusammenpasst
        InputChecker inputcheckerLogin = new InputChecker();
        try {
            
            if(inputcheckerLogin.usernamePasswordCheckerSame(jTextUser.getText(), jTextPasswort.getText())){
            //neue datei erstellen
                //to do !!!!auf user zuweisen!!!
                WriteInTxtFile wtxtf = new WriteInTxtFile();
                wtxtf.schreibenUserList();
                new ListScreen().setVisible(true);
                dispose();
            }else{
                JOptionPane.showMessageDialog(null,"Benutzername oder Passwort ist falsch!");
            }
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }//GEN-LAST:event_jButtonRegister1MouseClicked

    private void jButtonRegister1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegister1ActionPerformed

        
        
        
        
    }//GEN-LAST:event_jButtonRegister1ActionPerformed

    private void jButtonRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRegisterMouseClicked
        Register registerScreen = new Register();
        registerScreen.setVisible(true);     
    }//GEN-LAST:event_jButtonRegisterMouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFAQ;
    private javax.swing.JButton jButtonRegister;
    private javax.swing.JButton jButtonRegister1;
    private javax.swing.JLabel jLabelPasswort;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JTextField jTextLogo;
    private javax.swing.JTextField jTextPasswort;
    private javax.swing.JTextField jTextUser;
    // End of variables declaration//GEN-END:variables
}
