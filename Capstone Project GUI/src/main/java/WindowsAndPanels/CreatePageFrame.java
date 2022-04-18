/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package WindowsAndPanels;

import InnerWorkings.ApplicationHandler;

/**
 *
 * @author Victor Malone (vm19171)
 */
public class CreatePageFrame extends javax.swing.JFrame {

    /**
     * Creates new form CreateNodeFrame
     */
    public CreatePageFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        enterTitleLabel = new javax.swing.JLabel();
        titleField = new javax.swing.JTextField();
        createPageButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New Page");
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        mainPanel.setLayout(new java.awt.GridBagLayout());

        enterTitleLabel.setFont(new java.awt.Font("DFPOP1-W9", 1, 30)); // NOI18N
        enterTitleLabel.setLabelFor(titleField);
        enterTitleLabel.setText("Enter a title for your new page!");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(19, 1, 19, 1);
        mainPanel.add(enterTitleLabel, gridBagConstraints);

        titleField.setFont(new java.awt.Font("DFPOP1-W9", 0, 18)); // NOI18N
        titleField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        titleField.setText("New Page");
        titleField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        titleField.setMinimumSize(new java.awt.Dimension(200, 22));
        titleField.setPreferredSize(new java.awt.Dimension(120, 28));
        titleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(0, 25, 0, 25);
        mainPanel.add(titleField, gridBagConstraints);

        createPageButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        createPageButton.setText("Create");
        createPageButton.setMaximumSize(new java.awt.Dimension(50, 22));
        createPageButton.setMinimumSize(new java.awt.Dimension(50, 22));
        createPageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPageButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(14, 185, 14, 185);
        mainPanel.add(createPageButton, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void titleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleFieldActionPerformed
        // TODO add your handling code here:
        createPageButtonActionPerformed(evt);
        
    }//GEN-LAST:event_titleFieldActionPerformed

    private void createPageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPageButtonActionPerformed
        
        // if the title field is empty, just go with default settings
        if(this.titleField.getText().equals(""))
        {
            controller.createNewPage("New Page");
        }
        else
        {
            controller.createNewPage(this.titleField.getText());
        }
        
        controller.enableFrame(false);
        this.dispose();
    }//GEN-LAST:event_createPageButtonActionPerformed

    public void setApplicationHandler(ApplicationHandler a)
    {
        controller = a;
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
        }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreatePageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreatePageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreatePageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreatePageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreatePageFrame().setVisible(true);
            }
        });
    }

    private ApplicationHandler controller;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createPageButton;
    private javax.swing.JLabel enterTitleLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField titleField;
    // End of variables declaration//GEN-END:variables
}
