/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package EditorWindow;

import javax.swing.JOptionPane;

/**
 *
 * @author rolep
 */
public class EditorWindowGUI extends javax.swing.JFrame {

    /**
     * Creates new form EditorWindowGUI
     */
    public EditorWindowGUI() {
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

        mainEditorScrollPane = new javax.swing.JScrollPane();
        editorPanel = new javax.swing.JPanel();
        editorMenu = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        fileMenuNew = new javax.swing.JMenuItem();
        fileMenuOpen = new javax.swing.JMenuItem();
        fileMenuProjectSettings = new javax.swing.JMenuItem();
        fileMenuExit = new javax.swing.JMenuItem();
        menuEdit = new javax.swing.JMenu();
        editMenuUndo = new javax.swing.JMenuItem();
        editMenuRedo = new javax.swing.JMenuItem();
        menuView = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainEditorScrollPane.setBackground(new java.awt.Color(204, 204, 255));
        mainEditorScrollPane.setForeground(new java.awt.Color(204, 204, 255));

        editorPanel.setBackground(new java.awt.Color(222, 222, 239));
        editorPanel.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout editorPanelLayout = new javax.swing.GroupLayout(editorPanel);
        editorPanel.setLayout(editorPanelLayout);
        editorPanelLayout.setHorizontalGroup(
            editorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 948, Short.MAX_VALUE)
        );
        editorPanelLayout.setVerticalGroup(
            editorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 747, Short.MAX_VALUE)
        );

        mainEditorScrollPane.setViewportView(editorPanel);

        menuFile.setText("File");

        fileMenuNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, 0));
        fileMenuNew.setText("New...");
        fileMenuNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMenuNewActionPerformed(evt);
            }
        });
        menuFile.add(fileMenuNew);

        fileMenuOpen.setText("Open...");
        fileMenuOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMenuOpenActionPerformed(evt);
            }
        });
        menuFile.add(fileMenuOpen);

        fileMenuProjectSettings.setText("Project Settings");
        fileMenuProjectSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMenuProjectSettingsActionPerformed(evt);
            }
        });
        menuFile.add(fileMenuProjectSettings);

        fileMenuExit.setText("Exit");
        menuFile.add(fileMenuExit);

        editorMenu.add(menuFile);

        menuEdit.setText("Edit");

        editMenuUndo.setText("Undo");
        editMenuUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMenuUndoActionPerformed(evt);
            }
        });
        menuEdit.add(editMenuUndo);

        editMenuRedo.setText("Redo");
        menuEdit.add(editMenuRedo);

        editorMenu.add(menuEdit);

        menuView.setText("View");
        editorMenu.add(menuView);

        setJMenuBar(editorMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(mainEditorScrollPane))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainEditorScrollPane))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fileMenuNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileMenuNewActionPerformed
        System.out.println("File menu: New button pressed.");
        JOptionPane.showMessageDialog(editorPanel, "You pressed the New menu option!");
    }//GEN-LAST:event_fileMenuNewActionPerformed

    private void fileMenuOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileMenuOpenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fileMenuOpenActionPerformed

    private void editMenuUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMenuUndoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editMenuUndoActionPerformed

    private void fileMenuProjectSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileMenuProjectSettingsActionPerformed
        new ProjectSettingsMenu().setVisible(true);
    }//GEN-LAST:event_fileMenuProjectSettingsActionPerformed

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
            java.util.logging.Logger.getLogger(EditorWindowGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditorWindowGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditorWindowGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditorWindowGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditorWindowGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem editMenuRedo;
    private javax.swing.JMenuItem editMenuUndo;
    private javax.swing.JMenuBar editorMenu;
    private javax.swing.JPanel editorPanel;
    private javax.swing.JMenuItem fileMenuExit;
    private javax.swing.JMenuItem fileMenuNew;
    private javax.swing.JMenuItem fileMenuOpen;
    private javax.swing.JMenuItem fileMenuProjectSettings;
    private javax.swing.JScrollPane mainEditorScrollPane;
    private javax.swing.JMenu menuEdit;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuView;
    // End of variables declaration//GEN-END:variables
}
