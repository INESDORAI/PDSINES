/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ing1.pds.vsc.capteur;

import java.awt.Color;
import java.awt.Frame;

/**
 *
 * @author aggoun.abdelkrim
 */
public class SupprimerCapteur extends javax.swing.JDialog {

    private final CapteurFrame capteurFrame;
    private CrudCapteur crudCapteur;
    private Capteur capteur;

    /**
     * Creates new form AjouterUser
     *
     * @param parent
     * @param modal
     * @param capteurFrame
     * @param capteur
     */
    public SupprimerCapteur(Frame parent, boolean modal, CapteurFrame capteurFrame, Capteur capteur, CrudCapteur crudCapteur) {
        super(parent, modal);
        this.crudCapteur = crudCapteur;
        this.capteurFrame = capteurFrame;
        this.capteur = capteur;
        initComponents();
        initConsulter(capteur);
        initDialog();
    }

    private void initDialog() {
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
    }

    private void initConsulter(Capteur capteur) {
        initCapteur(capteur);
    }

    private void initCapteur(Capteur capteur) {
        jTextFieldCode.setText(capteur.getCode());
        jTextFieldDate.setText(capteur.getDateCapteur());
        jTextFieldType.setText(capteur.getTypeCapteur());
        jTextFieldvaleur.setText(capteur.getValeurCapteur()+"");
        jTextFieldLocal.setText(capteur.getNumero());
        jTextFieldBatiment.setText(capteur.getBatiment());
        jTextFieldEtage.setText(capteur.getEtage());
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
        jLabelvaleur = new javax.swing.JLabel();
        jTextFieldvaleur = new javax.swing.JTextField();
        jTextFieldLocal = new javax.swing.JTextField();
        jLabelLocal = new javax.swing.JLabel();
        jTextFieldEtage = new javax.swing.JTextField();
        jLabelEtage = new javax.swing.JLabel();
        jTextFieldBatiment = new javax.swing.JTextField();
        jLabelBatiment = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jTextFieldDate = new javax.swing.JTextField();

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

        jLabelvaleur.setText("Valeur");

        jTextFieldvaleur.setEnabled(false);

        jTextFieldLocal.setEnabled(false);

        jLabelLocal.setText("Local");

        jTextFieldEtage.setEnabled(false);

        jLabelEtage.setText("Etage");

        jTextFieldBatiment.setEnabled(false);

        jLabelBatiment.setText("Batiment");

        jLabelDate.setText("Date");

        jTextFieldDate.setEnabled(false);

        javax.swing.GroupLayout jPanelEnterpriseLayout = new javax.swing.GroupLayout(jPanelEnterprise);
        jPanelEnterprise.setLayout(jPanelEnterpriseLayout);
        jPanelEnterpriseLayout.setHorizontalGroup(
            jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                        .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCode)
                            .addComponent(jLabelLocal))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                                .addComponent(jTextFieldLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jLabelEtage))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelEnterpriseLayout.createSequentialGroup()
                                .addComponent(jTextFieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelDate))))
                    .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                        .addComponent(jLabelType)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldType, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabelvaleur)))
                .addGap(18, 18, 18)
                .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                        .addComponent(jTextFieldEtage, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelBatiment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldBatiment, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                        .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldDate, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldvaleur, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                            .addComponent(jTextFieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEnterpriseLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDate)
                            .addComponent(jTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelvaleur)
                        .addComponent(jTextFieldvaleur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelType, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLocal)
                    .addComponent(jLabelEtage)
                    .addComponent(jTextFieldEtage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBatiment)
                    .addComponent(jTextFieldBatiment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jPanelEnterprise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
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
            crudCapteur.deleteCapteur(capteur.getId());
            capteurFrame.refrechCapteur();
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
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelEtage;
    private javax.swing.JLabel jLabelLocal;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JLabel jLabelvaleur;
    private javax.swing.JPanel jPanelEnterprise;
    private javax.swing.JTextField jTextFieldBatiment;
    private javax.swing.JTextField jTextFieldCode;
    private javax.swing.JTextField jTextFieldDate;
    private javax.swing.JTextField jTextFieldEtage;
    private javax.swing.JTextField jTextFieldLocal;
    private javax.swing.JTextField jTextFieldType;
    private javax.swing.JTextField jTextFieldvaleur;
    private javax.swing.JLabel labelErreur;
    private javax.swing.JPanel panelButton;
    // End of variables declaration//GEN-END:variables
}
