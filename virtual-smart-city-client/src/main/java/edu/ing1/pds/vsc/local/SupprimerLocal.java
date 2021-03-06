/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ing1.pds.vsc.local;

import java.awt.Color;
import java.awt.Frame;

/**
 *
 * @author aggoun.abdelkrim
 */
public class SupprimerLocal extends javax.swing.JDialog {

    private final LocalFrame localFrame;
    private CrudLocal crudLocal;
    private Local local;

    /**
     * Creates new form Ajouter
     *
     * @param parent
     * @param modal
     * @param localFrame
     * @param local
     */
    public SupprimerLocal(Frame parent, boolean modal, LocalFrame localFrame, Local local, CrudLocal crudLocal) {
        super(parent, modal);
        this.crudLocal = crudLocal;
        this.localFrame = localFrame;
        this.local = local;
        initComponents();
        initConsulter(local);
        initDialog();
    }

    private void initDialog() {
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
    }

    private void initConsulter(Local local) {
        initLocal(local);
    }

    private void initLocal(Local local) {
        jTextFieldNumero.setText(local.getNumero());
        jTextFieldLib.setText(local.getLib());
        jTextFieldBatiment.setText(local.getBatiment());
        jTextFieldEtage.setText(local.getEtage());
        jTextFieldPlace.setText(local.getNbrePlace()+"");
        jTextFieldPlaceOccupe.setText(local.getNbrePlaceOccupe()+"");
        jTextFieldTauxOccupe.setText(local.getTauxOccupation()+"");
        jTextFieldCapteur.setText(local.getNbreCapteur()+"");
        jTextFieldMateriel.setText(local.getNbreMateriel()+"");
        jTextFieldMobilier.setText(local.getNbreMobilier()+"");
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
        jLabelNumero = new javax.swing.JLabel();
        jTextFieldNumero = new javax.swing.JTextField();
        jLabelLib = new javax.swing.JLabel();
        jTextFieldLib = new javax.swing.JTextField();
        jLabelBatiment = new javax.swing.JLabel();
        jTextFieldBatiment = new javax.swing.JTextField();
        jTextFieldEtage = new javax.swing.JTextField();
        jLabelEtage = new javax.swing.JLabel();
        jTextFieldCapteur = new javax.swing.JTextField();
        jTextFieldPlace = new javax.swing.JTextField();
        jTextFieldPlaceOccupe = new javax.swing.JTextField();
        jTextFieldMateriel = new javax.swing.JTextField();
        jTextFieldMobilier = new javax.swing.JTextField();
        jTextFieldTauxOccupe = new javax.swing.JTextField();
        jLabelTauxOccupe = new javax.swing.JLabel();
        jLabelMobilier = new javax.swing.JLabel();
        jLabelMateriel = new javax.swing.JLabel();
        jLabelPlaceOccupe = new javax.swing.JLabel();
        jLabelPlace = new javax.swing.JLabel();
        jLabelCapteur = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Supprimer local");
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
                .addComponent(labelErreur, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
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

        jLabelNumero.setText("Num??ro");

        jTextFieldNumero.setEnabled(false);

        jLabelLib.setText("Libill??");

        jTextFieldLib.setEnabled(false);

        jLabelBatiment.setText("Batiment");

        jTextFieldBatiment.setEnabled(false);

        jTextFieldEtage.setEnabled(false);

        jLabelEtage.setText("Etage");

        jLabelTauxOccupe.setText("Taux occupation");

        jLabelMobilier.setText("Mobilier");

        jLabelMateriel.setText("Materiel");

        jLabelPlaceOccupe.setText("Place occup??e");

        jLabelPlace.setText("Place");

        jLabelCapteur.setText("Capteur");

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
                            .addComponent(jLabelNumero))
                        .addGap(27, 27, 27)
                        .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                                .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelBatiment)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldBatiment, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                .addComponent(jLabelEtage)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldEtage, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldLib)))
                    .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                        .addComponent(jLabelPlace)
                        .addGap(40, 40, 40)
                        .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                                .addComponent(jTextFieldCapteur, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelMateriel)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldMateriel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                                .addComponent(jTextFieldPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelPlaceOccupe)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldPlaceOccupe, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTauxOccupe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldTauxOccupe, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEnterpriseLayout.createSequentialGroup()
                        .addComponent(jLabelCapteur)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelMobilier)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldMobilier, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelEnterpriseLayout.setVerticalGroup(
            jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumero)
                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBatiment)
                    .addComponent(jTextFieldBatiment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEtage)
                    .addComponent(jTextFieldEtage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLib)
                    .addComponent(jTextFieldLib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPlace)
                    .addComponent(jTextFieldPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPlaceOccupe)
                    .addComponent(jTextFieldPlaceOccupe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTauxOccupe)
                    .addComponent(jTextFieldTauxOccupe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelCapteur)
                        .addComponent(jTextFieldCapteur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldMateriel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelMobilier)
                        .addComponent(jTextFieldMobilier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelMateriel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            crudLocal.deleteLocal(local.getId());
            localFrame.refrechLocal();
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
    private javax.swing.JLabel jLabelCapteur;
    private javax.swing.JLabel jLabelEtage;
    private javax.swing.JLabel jLabelLib;
    private javax.swing.JLabel jLabelMateriel;
    private javax.swing.JLabel jLabelMobilier;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelPlace;
    private javax.swing.JLabel jLabelPlaceOccupe;
    private javax.swing.JLabel jLabelTauxOccupe;
    private javax.swing.JPanel jPanelEnterprise;
    private javax.swing.JTextField jTextFieldBatiment;
    private javax.swing.JTextField jTextFieldCapteur;
    private javax.swing.JTextField jTextFieldEtage;
    private javax.swing.JTextField jTextFieldLib;
    private javax.swing.JTextField jTextFieldMateriel;
    private javax.swing.JTextField jTextFieldMobilier;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldPlace;
    private javax.swing.JTextField jTextFieldPlaceOccupe;
    private javax.swing.JTextField jTextFieldTauxOccupe;
    private javax.swing.JLabel labelErreur;
    private javax.swing.JPanel panelButton;
    // End of variables declaration//GEN-END:variables
}
