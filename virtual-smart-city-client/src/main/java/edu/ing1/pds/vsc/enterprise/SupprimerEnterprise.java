/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ing1.pds.vsc.enterprise;

import java.awt.Color;
import java.awt.Frame;

/**
 *
 * @author aggoun.abdelkrim
 */
public class SupprimerEnterprise extends javax.swing.JDialog {
    private final EnterpriseFrame enterpriseFrame;
    private CrudEnterprise crudEnterprise;
    private Enterprise enterprise;

    /**
     * Creates new form AjouterUser
     *
     * @param parent
     * @param modal
     * @param enterpriseFrame
     * @param enterprise
     */
    public SupprimerEnterprise(Frame parent, boolean modal, EnterpriseFrame enterpriseFrame, Enterprise enterprise, CrudEnterprise crudEnterprise) {
        super(parent, modal);
        this.crudEnterprise = crudEnterprise;
        this.enterpriseFrame = enterpriseFrame;
        this.enterprise = enterprise;
        initComponents();
        initConsulter(enterprise);
        initDialog();
    }

    private void initDialog() {
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
    }

    private void initConsulter(Enterprise enterprise) {
        initEnterprise(enterprise);
    }

    private void initEnterprise(Enterprise enterprise) {
        jTextFieldCode.setText(enterprise.getCode());
        jTextFieldLib.setText(enterprise.getLib());
        jTextFieldAdresse.setText(enterprise.getAdresse());
        jTextFieldCodePostal.setText(enterprise.getCodePostal());
        jTextFieldPays.setText(enterprise.getPays());
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
        jLabelLib = new javax.swing.JLabel();
        jTextFieldLib = new javax.swing.JTextField();
        jLabelAdresse = new javax.swing.JLabel();
        jTextFieldAdresse = new javax.swing.JTextField();
        jTextFieldCodePostal = new javax.swing.JTextField();
        jLabelCodePostal = new javax.swing.JLabel();
        jTextFieldPays = new javax.swing.JTextField();
        jLabelPays = new javax.swing.JLabel();

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
                .addComponent(labelErreur, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
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

        jLabelLib.setText("Libillé");

        jTextFieldLib.setEnabled(false);

        jLabelAdresse.setText("Adresse");

        jTextFieldAdresse.setEnabled(false);

        jTextFieldCodePostal.setEnabled(false);

        jLabelCodePostal.setText("Code posal");

        jTextFieldPays.setEnabled(false);

        jLabelPays.setText("Pays");

        javax.swing.GroupLayout jPanelEnterpriseLayout = new javax.swing.GroupLayout(jPanelEnterprise);
        jPanelEnterprise.setLayout(jPanelEnterpriseLayout);
        jPanelEnterpriseLayout.setHorizontalGroup(
            jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                        .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelLib)
                            .addComponent(jLabelCode))
                        .addGap(58, 58, 58)
                        .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldLib)
                            .addComponent(jTextFieldCode)))
                    .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                        .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCodePostal)
                            .addComponent(jLabelAdresse))
                        .addGap(28, 28, 28)
                        .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldAdresse)
                            .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                                .addComponent(jTextFieldCodePostal, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(jLabelPays)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldPays)))))
                .addContainerGap())
        );
        jPanelEnterpriseLayout.setVerticalGroup(
            jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCode)
                    .addComponent(jTextFieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLib)
                    .addComponent(jTextFieldLib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAdresse)
                    .addComponent(jTextFieldAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodePostal)
                    .addComponent(jTextFieldCodePostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPays)
                    .addComponent(jTextFieldPays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            crudEnterprise.deleteEnterprise(enterprise.getId());
            enterpriseFrame.refrechEnterprise();
            enterpriseFrame.fenetrePricipale.initComboBox();
            this.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
            labelErreur.setText("Impossible de supprimer");
            labelErreur.setForeground(new Color(255, 51, 0));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonFerme;
    private javax.swing.JButton buttonSupprimer;
    private javax.swing.JLabel jLabelAdresse;
    private javax.swing.JLabel jLabelCode;
    private javax.swing.JLabel jLabelCodePostal;
    private javax.swing.JLabel jLabelLib;
    private javax.swing.JLabel jLabelPays;
    private javax.swing.JPanel jPanelEnterprise;
    private javax.swing.JTextField jTextFieldAdresse;
    private javax.swing.JTextField jTextFieldCode;
    private javax.swing.JTextField jTextFieldCodePostal;
    private javax.swing.JTextField jTextFieldLib;
    private javax.swing.JTextField jTextFieldPays;
    private javax.swing.JLabel labelErreur;
    private javax.swing.JPanel panelButton;
    // End of variables declaration//GEN-END:variables
}
