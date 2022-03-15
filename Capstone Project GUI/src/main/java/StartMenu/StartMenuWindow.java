/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package StartMenu;

import EditorWindowPackage.EditorWindow;
import javax.swing.*;

/**
 *
 * @author Vic Malone
 */
public class StartMenuWindow extends javax.swing.JFrame {

    /**
     * Creates new form StartMenuGUI
     */
    public StartMenuWindow() {
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

        openProjectChooser = new javax.swing.JFileChooser();
        welcomeLabel = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        newProjectButton = new javax.swing.JButton();
        openProjectButton = new javax.swing.JButton();
        settingsButton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        openProjectChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openProjectChooserActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CHOICE (Working title)");
        setBackground(new java.awt.Color(61, 70, 77));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMinimumSize(new java.awt.Dimension(770, 540));
        setResizable(false);
        setSize(new java.awt.Dimension(770, 540));

        welcomeLabel.setFont(new java.awt.Font("DFPOP1-W9", 1, 48)); // NOI18N
        welcomeLabel.setText("<html> <u>Welcome to CHOICE!</u>  ");

        buttonPanel.setPreferredSize(new java.awt.Dimension(650, 435));
        buttonPanel.setLayout(new java.awt.GridLayout(2, 2, 15, 15));

        newProjectButton.setFont(new java.awt.Font("DFPOP1-W9", 0, 60)); // NOI18N
        newProjectButton.setMnemonic('n');
        newProjectButton.setText("<html> New <br> Project");
        newProjectButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        newProjectButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        newProjectButton.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        newProjectButton.setFocusPainted(false);
        newProjectButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        newProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProjectButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(newProjectButton);

        openProjectButton.setFont(new java.awt.Font("DFPOP1-W9", 0, 60)); // NOI18N
        openProjectButton.setText("<html> Open <br> Project...");
        openProjectButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        openProjectButton.setFocusPainted(false);
        openProjectButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        openProjectButton.setMargin(new java.awt.Insets(2, 14, 2, 2));
        openProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openProjectButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(openProjectButton);

        settingsButton.setFont(new java.awt.Font("DFPOP1-W9", 0, 60)); // NOI18N
        settingsButton.setText("Settings");
        settingsButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        settingsButton.setFocusPainted(false);
        settingsButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        settingsButton.setMargin(new java.awt.Insets(2, 14, 2, 2));
        settingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(settingsButton);

        jButton4.setFont(new java.awt.Font("DFPOP1-W9", 0, 60)); // NOI18N
        jButton4.setText("4th Button");
        jButton4.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        jButton4.setFocusPainted(false);
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.setMargin(new java.awt.Insets(2, 14, 2, 2));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        buttonPanel.add(jButton4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.out.println("4th button pressed.");
        JOptionPane.showMessageDialog(buttonPanel, "You pressed the 4th button! I haven't decided what this one's going to do yet.");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void settingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsButtonActionPerformed
        System.out.println("Settings button pressed.");
        JOptionPane.showMessageDialog(buttonPanel, "You pressed the Settings button!");
    }//GEN-LAST:event_settingsButtonActionPerformed

    private void openProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openProjectButtonActionPerformed
        try {
            openProjectChooser.showOpenDialog(this);
        } catch (java.awt.HeadlessException e1) {
            e1.printStackTrace();
        }
    }//GEN-LAST:event_openProjectButtonActionPerformed

    private void newProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProjectButtonActionPerformed
        System.out.println("New Project button pressed.");
        // JOptionPane.showMessageDialog(buttonPanel, "You pressed the New Project button!");

        new EditorWindow().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_newProjectButtonActionPerformed

    private void openProjectChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openProjectChooserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_openProjectChooserActionPerformed

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
            java.util.logging.Logger.getLogger(StartMenuWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartMenuWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartMenuWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartMenuWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartMenuWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JPanel buttonPanel;
    javax.swing.JButton jButton4;
    javax.swing.JButton newProjectButton;
    javax.swing.JButton openProjectButton;
    javax.swing.JFileChooser openProjectChooser;
    javax.swing.JButton settingsButton;
    javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
