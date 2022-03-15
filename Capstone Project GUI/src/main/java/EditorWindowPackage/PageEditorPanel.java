/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package EditorWindowPackage;

import InnerWorkings.NodeRectangle;
import InnerWorkings.PageEditorData;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Victor Malone (vm19171)
 */
public class PageEditorPanel extends javax.swing.JPanel implements Serializable {

    /**
     * Creates new form NewJPanel
     */
    public PageEditorPanel() {
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

        pageEditorData = new InnerWorkings.PageEditorData();
        nodeTitlePanel = new javax.swing.JPanel();
        pageEditorLabel = new java.awt.Label();
        titleField = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        paragraphPanel = new javax.swing.JPanel();
        paragraphTextLabel = new javax.swing.JLabel();
        paragraphScrollPane = new javax.swing.JScrollPane();
        paragraphField = new javax.swing.JTextArea();
        nodeIDPanel = new javax.swing.JPanel();
        IDLabel = new java.awt.Label();
        IDField = new javax.swing.JTextField();
        imagePanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        choicesPanel = new javax.swing.JPanel();
        choicesTitlePanel = new javax.swing.JPanel();
        choiceLabel = new java.awt.Label();
        addRemoveButtonsPanel = new javax.swing.JPanel();
        removeChoiceButton = new javax.swing.JButton();
        addChoiceButton = new javax.swing.JButton();
        REMOVELATERfillerPanel = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        OKPanel = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        OKButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 153, 153));
        setLayout(new java.awt.GridBagLayout());

        nodeTitlePanel.setForeground(new java.awt.Color(0, 0, 0));
        nodeTitlePanel.setFont(new java.awt.Font("DFPOP1-W9", 0, 12)); // NOI18N

        pageEditorLabel.setAlignment(java.awt.Label.CENTER);
        pageEditorLabel.setFont(new java.awt.Font("DFPOP1-W9", 0, 36)); // NOI18N
        pageEditorLabel.setText("Page Editor");

        titleField.setFont(new java.awt.Font("DFPOP1-W9", 0, 18)); // NOI18N
        titleField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        titleField.setText("Page Title");
        titleField.setPreferredSize(new java.awt.Dimension(97, 26));

        javax.swing.GroupLayout nodeTitlePanelLayout = new javax.swing.GroupLayout(nodeTitlePanel);
        nodeTitlePanel.setLayout(nodeTitlePanelLayout);
        nodeTitlePanelLayout.setHorizontalGroup(
            nodeTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nodeTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(pageEditorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(nodeTitlePanelLayout.createSequentialGroup()
                    .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(222, 222, 222)
                    .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        nodeTitlePanelLayout.setVerticalGroup(
            nodeTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nodeTitlePanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(nodeTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(pageEditorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(nodeTitlePanel, gridBagConstraints);

        paragraphPanel.setForeground(new java.awt.Color(0, 0, 0));

        paragraphTextLabel.setFont(new java.awt.Font("DFPOP1-W9", 0, 18)); // NOI18N
        paragraphTextLabel.setText("Paragraph Text:");

        paragraphField.setColumns(20);
        paragraphField.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        paragraphField.setLineWrap(true);
        paragraphField.setRows(5);
        paragraphField.setText("Write your story here...");
        paragraphField.setWrapStyleWord(true);
        paragraphScrollPane.setViewportView(paragraphField);

        javax.swing.GroupLayout paragraphPanelLayout = new javax.swing.GroupLayout(paragraphPanel);
        paragraphPanel.setLayout(paragraphPanelLayout);
        paragraphPanelLayout.setHorizontalGroup(
            paragraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paragraphPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(paragraphTextLabel)
                .addContainerGap(401, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paragraphPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(paragraphScrollPane)
                .addGap(14, 14, 14))
        );
        paragraphPanelLayout.setVerticalGroup(
            paragraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paragraphPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(paragraphTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(paragraphScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.7;
        gridBagConstraints.weighty = 0.7;
        add(paragraphPanel, gridBagConstraints);

        nodeIDPanel.setFont(new java.awt.Font("DFPOP1-W9", 0, 18)); // NOI18N

        IDLabel.setFont(new java.awt.Font("DFPOP1-W9", 0, 18)); // NOI18N
        IDLabel.setForeground(new java.awt.Color(187, 187, 187));
        IDLabel.setText("Page ID:");

        IDField.setText("AutoGeneratedIDGoesHere");
        IDField.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent component)
            {

                JTextField field = (JTextField)component;
                String input = field.getText();
                // allow alphanumeric and underscore chars only
                Pattern regex = Pattern.compile("^[a-zA-Z0-9_]+$");
                Matcher matcher = regex.matcher(input);

                if (matcher.matches())
                { 
                    /*
                    component.setComponent(input); */
                    return true;
                } 
                else
                {
                    // remove all unacceptable characters
                    // String resultingInput = input.replaceAll("[^a-zA-Z0-9_]", "");
                    // component.setText(resultingInput);
                    return false;   // just return true here too?
                }
            }

            @Override
            public boolean shouldYieldFocus(JComponent component)
            {
                boolean isValid = verify(component);

                if (isValid)
                {
                    component.setToolTipText(null);
                }
                else
                {
                    component.setToolTipText("IDs may only contain alphanumeric characters(A-Z, a-z, 0-9) and underscores(_).");
                }

                return isValid;
            }

        });
        IDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout nodeIDPanelLayout = new javax.swing.GroupLayout(nodeIDPanel);
        nodeIDPanel.setLayout(nodeIDPanelLayout);
        nodeIDPanelLayout.setHorizontalGroup(
            nodeIDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nodeIDPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(IDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IDField, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        nodeIDPanelLayout.setVerticalGroup(
            nodeIDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nodeIDPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(nodeIDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(IDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(nodeIDPanel, gridBagConstraints);

        jButton1.setText("Import Image...");

        jLabel1.setText("No Image Selected");

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagePanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(286, Short.MAX_VALUE))
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(imagePanel, gridBagConstraints);

        choicesPanel.setLayout(new javax.swing.BoxLayout(choicesPanel, javax.swing.BoxLayout.Y_AXIS));

        choiceLabel.setFont(new java.awt.Font("DFPOP1-W9", 0, 18)); // NOI18N
        choiceLabel.setForeground(new java.awt.Color(187, 187, 187));
        choiceLabel.setText("Choices:");

        javax.swing.GroupLayout choicesTitlePanelLayout = new javax.swing.GroupLayout(choicesTitlePanel);
        choicesTitlePanel.setLayout(choicesTitlePanelLayout);
        choicesTitlePanelLayout.setHorizontalGroup(
            choicesTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choicesTitlePanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(choiceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(460, Short.MAX_VALUE))
        );
        choicesTitlePanelLayout.setVerticalGroup(
            choicesTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choicesTitlePanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(choiceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        choicesPanel.add(choicesTitlePanel);

        addRemoveButtonsPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        removeChoiceButton.setText("-");
        removeChoiceButton.setToolTipText("Remove lowest choice");
        removeChoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeChoiceButtonActionPerformed(evt);
            }
        });
        addRemoveButtonsPanel.add(removeChoiceButton);

        addChoiceButton.setText("+");
        addChoiceButton.setToolTipText("Add new choice");
        addChoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addChoiceButtonActionPerformed(evt);
            }
        });
        addRemoveButtonsPanel.add(addChoiceButton);

        choicesPanel.add(addRemoveButtonsPanel);

        javax.swing.GroupLayout REMOVELATERfillerPanelLayout = new javax.swing.GroupLayout(REMOVELATERfillerPanel);
        REMOVELATERfillerPanel.setLayout(REMOVELATERfillerPanelLayout);
        REMOVELATERfillerPanelLayout.setHorizontalGroup(
            REMOVELATERfillerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, REMOVELATERfillerPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        REMOVELATERfillerPanelLayout.setVerticalGroup(
            REMOVELATERfillerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, REMOVELATERfillerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        choicesPanel.add(REMOVELATERfillerPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(choicesPanel, gridBagConstraints);

        OKPanel.setBackground(new java.awt.Color(204, 204, 204));

        cancelButton.setText("Cancel");

        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout OKPanelLayout = new javax.swing.GroupLayout(OKPanel);
        OKPanel.setLayout(OKPanelLayout);
        OKPanelLayout.setHorizontalGroup(
            OKPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OKPanelLayout.createSequentialGroup()
                .addContainerGap(412, Short.MAX_VALUE)
                .addComponent(cancelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OKButton)
                .addContainerGap())
        );
        OKPanelLayout.setVerticalGroup(
            OKPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OKPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(OKPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cancelButton)
                    .addComponent(OKButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(OKPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void IDFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDFieldActionPerformed

    private void addChoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addChoiceButtonActionPerformed
        // TODO add your handling code here:
       LinkPanel p = new LinkPanel();
       pageEditorData.linkPanels.add(p);        
       choicesPanel.add(p);
       
       this.revalidate();
       this.repaint();
    }//GEN-LAST:event_addChoiceButtonActionPerformed

    private void removeChoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeChoiceButtonActionPerformed
        LinkPanel p = pageEditorData.removeLinkPanel();
        if (p != null)
        {
            choicesPanel.remove(p);
        }
        
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_removeChoiceButtonActionPerformed

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        pageEditorData.save();
    }//GEN-LAST:event_OKButtonActionPerformed

    public JTextField getIDField() {
        return IDField;
    }

    public void setIDField(JTextField IDField) {
        this.IDField = IDField;
    }

    public PageEditorData getPageEditorData() {
        return pageEditorData;
    }

    public void setPageEditorData(PageEditorData pageEditorData) {
        this.pageEditorData = pageEditorData;
    }

    public JTextArea getParagraphField() {
        return paragraphField;
    }

    public void setParagraphField(JTextArea paragraphField) {
        this.paragraphField = paragraphField;
    }

    public JTextField getTitleField() {
        return titleField;
    }

    public void setTitleField(JTextField titleField) {
        this.titleField = titleField;
    }

    
    // used to populate the choices portion of the panel
    public void addLinksToPanel(NodeRectangle n)
    {
        // for each link in n
        // add a panel
        // assign ID value to combo box
        // set text to link text
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDField;
    private java.awt.Label IDLabel;
    private javax.swing.JButton OKButton;
    private javax.swing.JPanel OKPanel;
    private javax.swing.JPanel REMOVELATERfillerPanel;
    private javax.swing.JButton addChoiceButton;
    private javax.swing.JPanel addRemoveButtonsPanel;
    private javax.swing.JButton cancelButton;
    private java.awt.Label choiceLabel;
    private javax.swing.JPanel choicesPanel;
    private javax.swing.JPanel choicesTitlePanel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel nodeIDPanel;
    private javax.swing.JPanel nodeTitlePanel;
    private InnerWorkings.PageEditorData pageEditorData;
    private java.awt.Label pageEditorLabel;
    private javax.swing.JTextArea paragraphField;
    private javax.swing.JPanel paragraphPanel;
    private javax.swing.JScrollPane paragraphScrollPane;
    private javax.swing.JLabel paragraphTextLabel;
    private javax.swing.JButton removeChoiceButton;
    private javax.swing.JTextField titleField;
    // End of variables declaration//GEN-END:variables
}
