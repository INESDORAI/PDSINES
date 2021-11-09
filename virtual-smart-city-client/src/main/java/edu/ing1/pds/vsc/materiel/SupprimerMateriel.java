/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ing1.pds.vsc.materiel;

import java.awt.Color;
import java.awt.Frame;

/**
 *
 * @author aggoun.abdelkrim
 */
public class SupprimerMateriel extends javax.swing.JDialog {

    private final MaterielFrame materielFrame;
    private CrudMateriel crudMateriel;
    private Materiel materiel;

    /**
     * Creates new form AjouterUser
     *
     * @param parent
     * @param modal
     * @param materielFrame
     * @param materiel
     */
    public SupprimerMateriel(Frame parent, boolean modal, MaterielFrame materielFrame, Materiel materiel, CrudMateriel crudMateriel) {
        super(parent, modal);
        this.crudMateriel = crudMateriel;
        this.materielFrame = materielFrame;
        this.materiel = materiel;
        initComponents();
        initConsulter(materiel);
        initDialog();
    }

    private void initDialog() {
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
    }

    private void initConsulter(Materiel materiel) {
        initMateriel(materiel);
    }

    private void initMateriel(Materiel materiel) {
        jTextFieldCode.setText(materiel.getCode());
        jTextFieldType.setText(materiel.getTypeMateriel());
        jTextFieldLib.setText(materiel.getLib());
        jTextFieldUnite.setText(materiel.getUniteConsommation());
        jTextFieldLocal.setText(materiel.getNumero());
        jTextFieldBatiment.setText(materiel.getBatiment());
        jTextFieldEtage.setText(materiel.getEtage());
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
        buttonFerme = new javax.swing.JButton();
        buttonSupprimer = new javax.swing.JButton();
        labelErreur = new javax.swing.JLabel();
        jPanelEnterprise = new javax.swing.JPanel();
        jLabelCode = new javax.swing.JLabel();
        jTextFieldCode = new javax.swing.JTextField();
        jLabelType = new javax.swing.JLabel();
        jTextFieldType = new javax.swing.JTextField();
        jLabelLib = new javax.swing.JLabel();
        jTextFieldLib = new javax.swing.JTextField();
        jTextFieldLocal = new javax.swing.JTextField();
        jLabelLocal = new javax.swing.JLabel();
        jTextFieldEtage = new javax.swing.JTextField();
        jLabelEtage = new javax.swing.JLabel();
        jTextFieldBatiment = new javax.swing.JTextField();
        jLabelBatiment = new javax.swing.JLabel();
        jTextFieldUnite = new javax.swing.JTextField();
        jLabelUnite = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Supprimer wilaya");
        setResizable(false);

        buttonFerme.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonFerme.setForeground(new java.awt.Color(255, 0, 0));
        buttonFerme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/fermeBouton.png"))); // NOI18N
        buttonFerme.setText("Fermer");
        buttonFerme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFermeActionPerformed(evt);
            }
        });

        buttonSupprimer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonSupprimer.setForeground(new java.awt.Color(255, 0, 0));
        buttonSupprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/supprimerBouton.png"))); // NOI18N
        buttonSupprimer.setText("Supprimer");
        buttonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSupprimerActionPerformed(evt);
            }
        });

        labelErreur.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelButtonLayout = new javax.swing.GroupLayout(panelButton);
        panelButton.setLayout(panelButtonLayout);
        panelButtonLayout.setHorizontalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelErreur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonSupprimer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonFerme)
                .addGap(18, 18, 18))
        );
        panelButtonLayout.setVerticalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelErreur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelButtonLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonFerme)
                            .addComponent(buttonSupprimer))))
                .addContainerGap())
        );

        jLabelCode.setText("Code");

        jTextFieldCode.setEnabled(false);

        jLabelType.setText("Type ");

        jTextFieldType.setEnabled(false);

        jLabelLib.setText("Libillé");

        jTextFieldLib.setEnabled(false);

        jTextFieldLocal.setEnabled(false);

        jLabelLocal.setText("Local");

        jTextFieldEtage.setEnabled(false);

        jLabelEtage.setText("Etage");

        jTextFieldBatiment.setEnabled(false);

        jLabelBatiment.setText("Batiment");

        jLabelUnite.setText("Unité");

        javax.swing.GroupLayout jPanelEnterpriseLayout = new javax.swing.GroupLayout(jPanelEnterprise);
        jPanelEnterprise.setLayout(jPanelEnterpriseLayout);
        jPanelEnterpriseLayout.setHorizontalGroup(
            jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEnterpriseLayout.createSequentialGroup()
                        .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCode)
                            .addComponent(jLabelLocal))
                        .addGap(60, 60, 60))
                    .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                        .addComponent(jLabelUnite)
                        .addGap(51, 51, 51)))
                .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                        .addComponent(jTextFieldUnite)
                        .addGap(50, 50, 50))
                    .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                        .addComponent(jTextFieldLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelEtage))
                    .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                        .addComponent(jTextFieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelType)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEnterpriseLayout.createSequentialGroup()
                        .addComponent(jTextFieldType, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelLib)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldLib, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEnterpriseLayout.createSequentialGroup()
                        .addComponent(jTextFieldEtage, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelBatiment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldBatiment, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                            .addComponent(jTextFieldType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelLib)
                            .addComponent(jTextFieldLib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEnterpriseLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelType)
                            .addComponent(jTextFieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLocal)
                    .addComponent(jLabelEtage)
                    .addComponent(jTextFieldEtage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBatiment)
                    .addComponent(jTextFieldBatiment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldUnite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUnite))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelEnterprise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void buttonFermeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFermeActionPerformed
        // TODO add your handling code here:
        fermerButton();
    }//GEN-LAST:event_buttonFermeActionPerformed

    private void buttonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSupprimerActionPerformed
        // TODO add your handling code here:
        deleteButton();
    }//GEN-LAST:event_buttonSupprimerActionPerformed

    private void fermerButton() {
        this.dispose();
    }

    private void deleteButton() {
        try {
            crudMateriel.deleteMateriel(materiel.getId());
            materielFrame.refrechMateriel();
            this.dispose();
        } catch (Exception  ex) {
            ex.printStackTrace();
            labelErreur.setText("Impossible de supprimer");
            labelErreur.setForeground(new Color(255, 51, 0));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonFerme;
    private javax.swing.JButton buttonSupprimer;
    private javax.swing.JLabel jLabelBatiment;
    private javax.swing.JLabel jLabelCode;
    private javax.swing.JLabel jLabelEtage;
    private javax.swing.JLabel jLabelLib;
    private javax.swing.JLabel jLabelLocal;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JLabel jLabelUnite;
    private javax.swing.JPanel jPanelEnterprise;
    private javax.swing.JTextField jTextFieldBatiment;
    private javax.swing.JTextField jTextFieldCode;
    private javax.swing.JTextField jTextFieldEtage;
    private javax.swing.JTextField jTextFieldLib;
    private javax.swing.JTextField jTextFieldLocal;
    private javax.swing.JTextField jTextFieldType;
    private javax.swing.JTextField jTextFieldUnite;
    private javax.swing.JLabel labelErreur;
    private javax.swing.JPanel panelButton;
    // End of variables declaration//GEN-END:variables
}
