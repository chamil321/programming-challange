/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import controller.controller;

/**
 *
 * @author HP
 */
public class logIn2 extends javax.swing.JFrame {

    /**
     * Creates new form logIn2
     */
    public logIn2() {
        
        initComponents();
        this.setLocationRelativeTo(null);
       // player1.setBackground( new Color(0,0,0,0));
       // player2.setBackground(new Color(0,0,0,0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jMenu1 = new javax.swing.JMenu();
        close = new javax.swing.JLabel();
        player2 = new javax.swing.JTextField();
        player1 = new javax.swing.JTextField();
        minimize = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tac/tic/teo/loginfinal.png"))); // NOI18N

        jTextField2.setText("jTextField2");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 6, 18, 18));

        player2.setBackground(new java.awt.Color(50, 41, 41));
        player2.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        player2.setForeground(new java.awt.Color(217, 122, 21));
        player2.setBorder(null);
        getContentPane().add(player2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 125, 270, 20));

        player1.setBackground(new java.awt.Color(50, 41, 41));
        player1.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        player1.setForeground(new java.awt.Color(217, 122, 21));
        player1.setBorder(null);
        player1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player1ActionPerformed(evt);
            }
        });
        getContentPane().add(player1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 85, 270, 20));

        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });
        getContentPane().add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 8, 18, 18));

        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 165, 40, 20));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loginfinal.png"))); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${background}"), background, org.jdesktop.beansbinding.BeanProperty.create("background"), "");
        bindingGroup.addBinding(binding);

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 200));

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        dispose();
    }//GEN-LAST:event_closeMouseClicked

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        List<String> allPlayers = null;
       
        
        String play1 = player1.getText();
        String play2 = player2.getText();
        
        try {
            allPlayers = controller.getAllPlayers();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(logIn2.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(allPlayers.toString());
        
        if(!allPlayers.contains(play1)){
            try {
                System.out.println("nethaaaaaa");
                controller.addNameDataBase(play1);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(logIn2.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                controller.setScoreFirstTime(play1);
            } catch (    ClassNotFoundException | SQLException ex) {
                Logger.getLogger(BoardMultiPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else
            System.out.println("player Exists");
        
        if(!allPlayers.contains(play2)){
            try {
                controller.addNameDataBase(play2);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(logIn2.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                controller.setScoreFirstTime(play2);
            } catch (    ClassNotFoundException | SQLException ex) {
                Logger.getLogger(BoardMultiPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else 
            System.out.println("player exists");
        
        
        this.dispose();
        
         BoardMultiPlayer bmp = new BoardMultiPlayer(play1,play2);
         bmp.setVisible(true);
        
        
             
    }//GEN-LAST:event_jButton1ActionPerformed

    private void player1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(logIn2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(logIn2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(logIn2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(logIn2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new logIn2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel close;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel minimize;
    private javax.swing.JTextField player1;
    private javax.swing.JTextField player2;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
