/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ing1.pds.vsc.mobilier;

import edu.ing1.pds.vsc.enterprise.Enterprise;
import edu.ing1.pds.vsc.local.CrudLocal;
import edu.ing1.pds.vsc.local.Local;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;

/**
 *
 * @author aggoun.abdelkrim
 */
public class ReadMobilier extends javax.swing.JDialog {
    
    private final String type;
    private String titre;
    private MobilierFrame mobilierFrame;
    private CrudMobilier crudMobilier;
    private CrudLocal crudLocal;
    private Enterprise enterprise;
    private Mobilier mobilier;
    private List<Local> localList;
    private Local localSelected;
    private DefaultComboBoxModel comboBoxModelLocal;
    //
    private boolean activButton;

    /**
     * Creates new form AjouterUser
     *
     * @param parent
     * @param modal
     * @param mobilierFrame
     * @param mobilier
     * @param type
     */
    public ReadMobilier(JFrame parent, boolean modal, MobilierFrame mobilierFrame, Enterprise enterprise, Mobilier mobilier, String type, CrudMobilier crudMobilier) {
        super(parent, modal);
        this.type = type;
        this.crudMobilier = crudMobilier;
        this.enterprise = enterprise;
        this.mobilier = mobilier;
        this.mobilierFrame = mobilierFrame;
        initTitre();
        initComboBox();
        initComponents();
        initDialog();
    }
    
    private void initComboBox() {
        Vector<String> item = new Vector<>();
        item.add("");
        crudLocal = new CrudLocal();
        try {
            localList = crudLocal.findByIdEnterprise(enterprise.getId());
            for (Local local : localList) {
                item.add(local.getNumero());
            }
            comboBoxModelLocal = new DefaultComboBoxModel(item);
        } catch (Exception ex) {
            Logger.getLogger(ReadMobilier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void initDialog() {
        activButton = true;
        buttonAjouter.setEnabled(activButton);
        
        if (type.equals("add")) {
            mobilier = new Mobilier();
        }
        if (type.equals("upd")) {
            initMobilier(mobilier);
        }
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
    }
    
    private void initTitre() {
        switch (type) {
            case "add":
                titre = "Ajouter une mobilier";
                break;
            case "upd":
                titre = "Modifier une mobilier";
                break;
        }
    }
    
    private void initMobilier(Mobilier mobilier) {
        buttonInit.setVisible(false);
        jTextFieldCode.setText(mobilier.getCode());
        jTextFieldType.setText(mobilier.getTypeMobilier());
        jTextFieldLib.setText(mobilier.getLib());
        jComboBoxlibLocal.setSelectedItem(mobilier.getNumero());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelButton = new javax.swing.JPanel();
        buttonAjouter = new javax.swing.JButton();
        buttonInit = new javax.swing.JButton();
        buttonFermer = new javax.swing.JButton();
        labelErreur = new javax.swing.JLabel();
        jPanelEnterprise = new javax.swing.JPanel();
        jLabelCode = new javax.swing.JLabel();
        jTextFieldCode = new javax.swing.JTextField();
        jLabelType = new javax.swing.JLabel();
        jTextFieldType = new javax.swing.JTextField();
        jLabelLib = new javax.swing.JLabel();
        jTextFieldLib = new javax.swing.JTextField();
        jComboBoxlibLocal = new javax.swing.JComboBox<>();
        jLabelLocal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(titre);
        setResizable(false);

        buttonAjouter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonAjouter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/okBouton.png"))); // NOI18N
        buttonAjouter.setText("Valider");
        buttonAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAjouterActionPerformed(evt);
            }
        });

        buttonInit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonInit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/actualiserBouton.png"))); // NOI18N
        buttonInit.setText("Initialiser");
        buttonInit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInitActionPerformed(evt);
            }
        });

        buttonFermer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonFermer.setForeground(new java.awt.Color(255, 0, 0));
        buttonFermer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/fermeBouton.png"))); // NOI18N
        buttonFermer.setText("Fermer");
        buttonFermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFermerActionPerformed(evt);
            }
        });

        labelErreur.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelErreur.setForeground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout panelButtonLayout = new javax.swing.GroupLayout(panelButton);
        panelButton.setLayout(panelButtonLayout);
        panelButtonLayout.setHorizontalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelButtonLayout.createSequentialGroup()
                        .addGap(0, 390, Short.MAX_VALUE)
                        .addComponent(buttonInit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAjouter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonFermer))
                    .addComponent(labelErreur, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelButtonLayout.setVerticalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelErreur, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonFermer)
                    .addComponent(buttonAjouter)
                    .addComponent(buttonInit))
                .addContainerGap())
        );

        jLabelCode.setText("Code");

        jLabelType.setText("Type ");

        jLabelLib.setText("Libillé");

        jComboBoxlibLocal.setModel(comboBoxModelLocal);
        jComboBoxlibLocal.setMaximumSize(new java.awt.Dimension(250, 40));
        jComboBoxlibLocal.setMinimumSize(new java.awt.Dimension(250, 40));
        jComboBoxlibLocal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxlibLocalItemStateChanged(evt);
            }
        });

        jLabelLocal.setText("Local");

        javax.swing.GroupLayout jPanelEnterpriseLayout = new javax.swing.GroupLayout(jPanelEnterprise);
        jPanelEnterprise.setLayout(jPanelEnterpriseLayout);
        jPanelEnterpriseLayout.setHorizontalGroup(
            jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCode)
                    .addComponent(jLabelLocal))
                .addGap(20, 20, 20)
                .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxlibLocal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldCode, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                .addGap(60, 60, 60)
                .addComponent(jLabelType)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldType, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jLabelLib)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldLib, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelEnterpriseLayout.setVerticalGroup(
            jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCode)
                            .addComponent(jTextFieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelLib)
                            .addComponent(jTextFieldLib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEnterpriseLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelType)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxlibLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLocal))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelEnterprise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanelEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAjouterActionPerformed
        // TODO add your handling code here:
        switch (type) {
            case "add":
                addMobilier();
                break;
            case "upd":
                updateMobilier();
                break;
        }
    }//GEN-LAST:event_buttonAjouterActionPerformed

    private void buttonInitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInitActionPerformed
        // TODO add your handling code here:
        initButton();
    }//GEN-LAST:event_buttonInitActionPerformed

    private void buttonFermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFermerActionPerformed
        // TODO add your handling code here:
        fermerButton();
    }//GEN-LAST:event_buttonFermerActionPerformed

    private void jComboBoxlibLocalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxlibLocalItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == 1) {
            String numero = evt.getItem().toString();
            if (numero != null && !numero.isEmpty()) {
                for (Local local : localList) {
                    if (numero.equals(local.getNumero())) {
                        localSelected = local;
                        break;
                    }
                }
            }
        } else {
            localSelected = null;
        }
    }//GEN-LAST:event_jComboBoxlibLocalItemStateChanged
    
    private void initButton() {
        buttonAjouter.setEnabled(true);
    }
    
    private void addMobilier() {
        try {            
            if (localSelected != null && localSelected.getId() != null) {
                mobilier.setCode(jTextFieldCode.getText());
                mobilier.setTypeMobilier(jTextFieldType.getText());
                mobilier.setLib(jTextFieldLib.getText());                
                mobilier.setIdLocal(localSelected.getId());
                crudMobilier.insertMobilier(mobilier);
                fermerButton();
            } else {
                labelErreur.setText("Erreur : Local obligatoire!!!!");
            }            
        } catch (Exception ex) {
            labelErreur.setText(ex.getMessage());
            Logger.getLogger(ReadMobilier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void updateMobilier() {
        try {
            if (localSelected != null && localSelected.getId() != null) {
                mobilier.setCode(jTextFieldCode.getText());
                mobilier.setTypeMobilier(jTextFieldType.getText());
                mobilier.setLib(jTextFieldLib.getText());               
                mobilier.setIdLocal(localSelected.getId());
                crudMobilier.updateMobilier(mobilier);
                fermerButton();
            } else {
                labelErreur.setText("Erreur : Local obligatoire!!!!");
            }  
        } catch (Exception ex) {
            Logger.getLogger(ReadMobilier.class.getName()).log(Level.SEVERE, null, ex);
        }
        fermerButton();
    }
    
    private void fermerButton() {
        mobilierFrame.refrechMobilier();
        this.dispose();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAjouter;
    private javax.swing.JButton buttonFermer;
    private javax.swing.JButton buttonInit;
    private javax.swing.JComboBox<String> jComboBoxlibLocal;
    private javax.swing.JLabel jLabelCode;
    private javax.swing.JLabel jLabelLib;
    private javax.swing.JLabel jLabelLocal;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JPanel jPanelEnterprise;
    private javax.swing.JTextField jTextFieldCode;
    private javax.swing.JTextField jTextFieldLib;
    private javax.swing.JTextField jTextFieldType;
    private javax.swing.JLabel labelErreur;
    private javax.swing.JPanel panelButton;
    // End of variables declaration//GEN-END:variables
}