/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package EditorWindowPackage;

import javax.swing.JOptionPane;
import InnerWorkings.DragAndDrop;
import InnerWorkings.MyFileFilter;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rolep
 */
public class EditorWindow extends javax.swing.JFrame {

    public DragAndDrop mainEditor;
    
    
    /**
     * Creates new form EditorWindowGUI
     */
    public EditorWindow() {
        
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

        openFileDialog = new javax.swing.JFileChooser(System.getProperty("user.dir"));
        saveFileDialog = new javax.swing.JFileChooser(System.getProperty("user.dir"));
        appHandler = new InnerWorkings.ApplicationHandler();
        exportWindow = new EditorWindowPackage.ExportWindow();
        buttonMenuPanel = new javax.swing.JPanel();
        createNodeButton = new javax.swing.JButton();
        loadTestButton = new javax.swing.JButton();
        saveTestButton = new javax.swing.JButton();
        dragAndDropPanel = new InnerWorkings.DragAndDrop();
        editorMenu = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        saveMenuItem = new javax.swing.JMenuItem();
        newMenuItem = new javax.swing.JMenuItem();
        openMenuItem = new javax.swing.JMenuItem();
        projectSettingsMenuItem = new javax.swing.JMenuItem();
        exportGameMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        menuEdit = new javax.swing.JMenu();
        editMenuUndo = new javax.swing.JMenuItem();
        editMenuRedo = new javax.swing.JMenuItem();
        menuView = new javax.swing.JMenu();
        viewMenuReturnToStart = new javax.swing.JMenuItem();

        openFileDialog.setDialogTitle("Open Project");
        openFileDialog.setFileFilter(new MyFileFilter());
        openFileDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileDialogActionPerformed(evt);
            }
        });

        saveFileDialog.setAcceptAllFileFilterUsed(false);
        saveFileDialog.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        saveFileDialog.setDialogTitle("Save Project");
        saveFileDialog.setFileFilter(new MyFileFilter());
        saveFileDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileDialogActionPerformed(evt);
            }
        });

        appHandler.setView(dragAndDropPanel);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NAME OF PROJECT");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        buttonMenuPanel.setBackground(new java.awt.Color(153, 153, 255));

        createNodeButton.setText("Create Node");
        createNodeButton.setFocusable(false);
        createNodeButton.setRequestFocusEnabled(false);
        createNodeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNodeButtonActionPerformed(evt);
            }
        });

        loadTestButton.setText("Load");
        loadTestButton.setFocusable(false);

        saveTestButton.setText("Save As...");
        saveTestButton.setFocusable(false);
        saveTestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveTestButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonMenuPanelLayout = new javax.swing.GroupLayout(buttonMenuPanel);
        buttonMenuPanel.setLayout(buttonMenuPanelLayout);
        buttonMenuPanelLayout.setHorizontalGroup(
            buttonMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(createNodeButton)
                .addGap(18, 18, 18)
                .addComponent(loadTestButton)
                .addGap(18, 18, 18)
                .addComponent(saveTestButton)
                .addContainerGap(762, Short.MAX_VALUE))
        );
        buttonMenuPanelLayout.setVerticalGroup(
            buttonMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonMenuPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(buttonMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createNodeButton)
                    .addComponent(loadTestButton)
                    .addComponent(saveTestButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dragAndDropPanel.setBackground(new java.awt.Color(204, 204, 255));
        dragAndDropPanel.setController(appHandler);
        dragAndDropPanel.setFont(new java.awt.Font("DFPOP1-W9", 0, 18)); // NOI18N
        dragAndDropPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dragAndDropPanelKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout dragAndDropPanelLayout = new javax.swing.GroupLayout(dragAndDropPanel);
        dragAndDropPanel.setLayout(dragAndDropPanelLayout);
        dragAndDropPanelLayout.setHorizontalGroup(
            dragAndDropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        dragAndDropPanelLayout.setVerticalGroup(
            dragAndDropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 663, Short.MAX_VALUE)
        );

        mainEditor = dragAndDropPanel;

        editorMenu.setName(""); // NOI18N

        menuFile.setText("File");

        saveMenuItem.setText("Save...");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
                saveMenuItemActionPerformed1(evt);
            }
        });
        menuFile.add(saveMenuItem);

        newMenuItem.setText("New...");
        newMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMenuItemActionPerformed(evt);
            }
        });
        menuFile.add(newMenuItem);

        openMenuItem.setText("Open...");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        menuFile.add(openMenuItem);

        projectSettingsMenuItem.setText("Project Settings");
        projectSettingsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectSettingsMenuItemActionPerformed(evt);
            }
        });
        menuFile.add(projectSettingsMenuItem);

        exportGameMenuItem.setText("Export Game...");
        exportGameMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportGameMenuItemActionPerformed(evt);
            }
        });
        menuFile.add(exportGameMenuItem);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        menuFile.add(exitMenuItem);

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

        viewMenuReturnToStart.setText("Return to Start");
        menuView.add(viewMenuReturnToStart);

        editorMenu.add(menuView);

        setJMenuBar(editorMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dragAndDropPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dragAndDropPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void newMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMenuItemActionPerformed
        System.out.println("File menu: New button pressed.");
        // JOptionPane.showMessageDialog(editorPanel, "You pressed the New menu option!");
    }//GEN-LAST:event_newMenuItemActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed

        try {
            int returnValue = openFileDialog.showOpenDialog(this);
            System.out.println(""); // for clarity

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                System.out.println("Load approved!");

                appHandler.loadProject(openFileDialog.getSelectedFile());
                this.setTitle(appHandler.getProjectFile().getProjectTitle());
                dragAndDropPanel.setNodes(appHandler.getNodes());
                dragAndDropPanel.repaint();
            }
            else {
                System.out.println("Load not approved...");
            }

        }
        catch (java.awt.HeadlessException e1) {
            e1.printStackTrace();
        }
        catch (IOException | ClassNotFoundException ex) {
            System.out.println("There was a problem loading the file.");
            Logger.getLogger(EditorWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void editMenuUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMenuUndoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editMenuUndoActionPerformed

    private void projectSettingsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectSettingsMenuItemActionPerformed
        new ProjectSettingsMenu().setVisible(true);
    }//GEN-LAST:event_projectSettingsMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void createNodeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNodeButtonActionPerformed
        System.out.println("Create Node button pressed! This is how the user will be able to add new nodes.");
        //mainEditor.addNode(100, 100);
        appHandler.openCreatePage();        
        
        mainEditor.revalidate();
        mainEditor.repaint();
    }//GEN-LAST:event_createNodeButtonActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        
        // for saving files
        try {
            
            int returnValue = saveFileDialog.showSaveDialog(this);
            
            if (returnValue == JFileChooser.APPROVE_OPTION)
            {                
                // add proper extension if not added manually
                File saveFile = saveFileDialog.getSelectedFile();
                if (!(saveFile.getAbsolutePath().endsWith(appHandler.extension)))
                {
                    saveFile = new File(saveFileDialog.getSelectedFile() + appHandler.extension);   // add extension
                }
                
                // If file exists, ask to overwrite
                {
                if (saveFile.exists())
                        {
                            int overwrite = JOptionPane.showConfirmDialog(this, "Would you like to overwrite the existing file?", "Overwrite file?", JOptionPane.YES_NO_OPTION);
                            
                            if (!(overwrite == JOptionPane.YES_OPTION)) // if not "yes"
                            {
                                return; // cancel.
                            }
                        }
            }
                String projectName = saveFile.getName().substring(0, saveFile.getName().length() - 7);  // remove extension
                appHandler.getProjectFile().setProjectTitle(projectName);    // sets project name
                appHandler.saveProject(saveFile);   // saves file!
                
                this.setTitle(appHandler.getProjectFile().getProjectTitle());
                System.out.println("File saved!");
            }
                else
                {
                    System.out.println("Unable to save.");
                }
            
        } catch (java.awt.HeadlessException e1) {
            e1.printStackTrace();
        }
        catch (IOException ex)
        {
            System.out.println("There was a problem saving the file.");
            Logger.getLogger(EditorWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.repaint();
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void saveTestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveTestButtonActionPerformed
        try {
            saveFileDialog.showSaveDialog(this);
        } catch (java.awt.HeadlessException e1) {
            e1.printStackTrace();
        }
    }//GEN-LAST:event_saveTestButtonActionPerformed

    private void dragAndDropPanelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dragAndDropPanelKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_dragAndDropPanelKeyTyped

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        
        System.out.println("Key Pressed!");
        // appHandler.updateView();
        dragAndDropPanel.showControllerNodeStats();
    }//GEN-LAST:event_formKeyTyped

    private void saveFileDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileDialogActionPerformed

    }//GEN-LAST:event_saveFileDialogActionPerformed

    private void openFileDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileDialogActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_openFileDialogActionPerformed

    private void saveMenuItemActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed1
        saveFileDialog.setVisible(true);
    }//GEN-LAST:event_saveMenuItemActionPerformed1

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setTitle(appHandler.getProjectFile().getProjectTitle());
        appHandler.setFrame(this);
    }//GEN-LAST:event_formWindowOpened

    private void exportGameMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportGameMenuItemActionPerformed
        // TODO - Export game.
        exportWindow.setProject(appHandler.getProjectFile());
        exportWindow.setVisible(true);
        //exp.export(appHandler.getProjectFile());
    }//GEN-LAST:event_exportGameMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(EditorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
          /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditorWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private InnerWorkings.ApplicationHandler appHandler;
    private javax.swing.JPanel buttonMenuPanel;
    private javax.swing.JButton createNodeButton;
    private InnerWorkings.DragAndDrop dragAndDropPanel;
    private javax.swing.JMenuItem editMenuRedo;
    private javax.swing.JMenuItem editMenuUndo;
    private javax.swing.JMenuBar editorMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenuItem exportGameMenuItem;
    private EditorWindowPackage.ExportWindow exportWindow;
    private javax.swing.JButton loadTestButton;
    private javax.swing.JMenu menuEdit;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuView;
    private javax.swing.JMenuItem newMenuItem;
    private javax.swing.JFileChooser openFileDialog;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem projectSettingsMenuItem;
    private javax.swing.JFileChooser saveFileDialog;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JButton saveTestButton;
    private javax.swing.JMenuItem viewMenuReturnToStart;
    // End of variables declaration//GEN-END:variables
}
