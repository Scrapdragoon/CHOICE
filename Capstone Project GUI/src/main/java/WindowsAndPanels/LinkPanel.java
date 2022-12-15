/*
 * Copyright 2022 Victor Malone.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package WindowsAndPanels;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 * Panel used to create and manage links between nodes. The '+' and '-' buttons in the page editor adds and deletes these as needed.
 * 
 * @author Victor Malone
 */
public class LinkPanel extends javax.swing.JPanel {

    /**
     * Creates new form choiceEntryPanel
     */
    public LinkPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        choiceChooserBox = new javax.swing.JComboBox<>();
        choiceTextField = new javax.swing.JTextField();
        linkLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(500, 34));

        choiceChooserBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[There are no available pages to link to.]" }));
        choiceChooserBox.setToolTipText("What page should this one link to?");
        choiceChooserBox.setMaximumSize(new java.awt.Dimension(243, 22));
        choiceChooserBox.setPrototypeDisplayValue("eeeeeeeeeeeeeeeeeeeeeeee");

        choiceTextField.setText("Enter text here...");
        choiceTextField.setMinimumSize(new java.awt.Dimension(30, 22));

        linkLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        linkLabel.setText("Link to page with ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(linkLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(choiceChooserBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(choiceTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(choiceChooserBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choiceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(linkLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
 
    
   // Getters and Setters
    public void setComboBoxModel(ComboBoxModel m)
    {
        this.choiceChooserBox.setModel(m);
    }
    
    public void setSelectedID(String s)
    {
        this.choiceChooserBox.setSelectedItem(s);
    }
    
    public void setHyperlinkText(String s)
    {
        this.choiceTextField.setText(s);
    }

      public JComboBox<String> getChoiceChooserBox() {
        return choiceChooserBox;
    }

    public void setChoiceChooserBox(JComboBox<String> choiceChooserBox) {
        this.choiceChooserBox = choiceChooserBox;
    }

    public JTextField getChoiceTextField() {
        return choiceTextField;
    }

    public void setChoiceTextField(JTextField choiceTextField) {
        this.choiceTextField = choiceTextField;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> choiceChooserBox;
    private javax.swing.JTextField choiceTextField;
    private javax.swing.JLabel linkLabel;
    // End of variables declaration//GEN-END:variables
}
