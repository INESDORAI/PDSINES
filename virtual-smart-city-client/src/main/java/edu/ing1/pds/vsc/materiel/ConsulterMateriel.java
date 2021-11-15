/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ing1.pds.vsc.materiel;

import java.awt.Frame;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aggoun.abdelkrim
 */
public class ConsulterMateriel extends javax.swing.JDialog {

    private Materiel materiel;
    private CrudConsommationMateriel crudConsommationMateriel;
    public List<ConsommationMateriel> consommationMaterielList;
    private ConsommationMateriel consommationMaterielSelected;
    private String[] titreConsommationMateriel;
    private DefaultTableModel defaultTableModel;
    private int selectedRow;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Creates new form AjouterUser
     *
     * @param parent
     * @param modal
     * @param materiel
     */
    public ConsulterMateriel(Frame parent, boolean modal, Materiel materiel) {
        super(parent, modal);
        this.materiel = materiel;
        initFrame();
        initTableConsommationMateriel();
        initComponents();
        initConsulter();
        initDialog();
    }

    private void initDialog() {
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
    }

    private void initConsulter() {
        initMateriel();
        dateChooserDateDebut.setDate(new Date());
    }

    private void initFrame() {
        crudConsommationMateriel = new CrudConsommationMateriel();
    }

    private void initTableConsommationMateriel() {
        if (defaultTableModel == null) {
            defaultTableModel = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int col) {
                    if (col == 0 || col == 1 || col == 2 || col == 3 || col == 4 || col == 5) {
                        return false;
                    } else {
                        return true;
                    }
                }
            ;
            };
            titreConsommationMateriel = "Date,Valeur".split(",");
            defaultTableModel.setColumnIdentifiers(titreConsommationMateriel);
        }
        selectedRow = -1;
        if (!(consommationMaterielSelected == null)) {
            consommationMaterielSelected = new ConsommationMateriel();
        }
        initTableModelConsommationMateriel();
    }

    public void initTableModelConsommationMateriel() {
        try {
            consommationMaterielList = crudConsommationMateriel.findByIdMateriel(materiel.getId());
        } catch (Exception ex) {
        }
        if (consommationMaterielList != null && !consommationMaterielList.isEmpty()) {
            for (ConsommationMateriel consommationMateriel : consommationMaterielList) {
                Vector<Object> ligne = new Vector<Object>();
                ligne.add(consommationMateriel.getDatePrelevement());
                ligne.add(consommationMateriel.getValeur());

                defaultTableModel.addRow(ligne);
            }
        }
    }

    private void removeAllTableLocal() {
        for (int i = defaultTableModel.getRowCount() - 1; i >= 0; --i) {
            defaultTableModel.removeRow(i);
        }
    }

    private void initConsommationMateriel() {
        consommationMaterielSelected = new ConsommationMateriel();
        consommationMaterielSelected.setIdMateriel(materiel.getId());
        if (jTextFieldValuer.getText() == null || (jTextFieldValuer.getText() != null && jTextFieldValuer.getText().isEmpty())) {
            consommationMaterielSelected.setValeur(0.0);
        } else {
            consommationMaterielSelected.setValeur(Double.valueOf(jTextFieldValuer.getText()));
        }

        consommationMaterielSelected.setDatePrelevement(dateFormat.format(dateChooserDateDebut.getDate()));
    }

    private void addConsommationMateriel() {
        initConsommationMateriel();
        if (consommationMaterielSelected.getValeur() != null && !consommationMaterielSelected.getDatePrelevement().isEmpty())
        try {
            crudConsommationMateriel.insertConsommationMateriel(consommationMaterielSelected);
            if (consommationMaterielList != null) {
                consommationMaterielList.clear();
            }
            removeAllTableLocal();
            initTableModelConsommationMateriel();
            Double moy = 0.0;
            Double sum = 0.0;
            for (ConsommationMateriel consommationMateriel : consommationMaterielList) {
                sum = sum + consommationMateriel.getValeur();
            }
            moy = sum / consommationMaterielList.size();
            jTextFieldValuer.setText(null);
            jTextFieldConsommationTotal.setText(sum + "");
            jTextFieldConsommationMoyenne.setText(moy + "");
            consommationMaterielSelected = null;
        } catch (Exception ex) {
            Logger.getLogger(ConsulterMateriel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void deleteConsommationMateriel() {
        try {
            if (consommationMaterielSelected != null && consommationMaterielSelected.getId() != null) {
                crudConsommationMateriel.deleteConsommationMateriel(consommationMaterielSelected.getId());

                if (consommationMaterielList != null) {
                    consommationMaterielList.clear();
                }
                removeAllTableLocal();
                initTableModelConsommationMateriel();
                Double moy = 0.0;
                Double sum = 0.0;
                for (ConsommationMateriel consommationMateriel : consommationMaterielList) {
                    sum = sum + consommationMateriel.getValeur();
                }
                moy = sum / consommationMaterielList.size();
                jTextFieldValuer.setText(null);
                jTextFieldConsommationTotal.setText(sum + "");
                jTextFieldConsommationMoyenne.setText(moy + "");
                consommationMaterielSelected = null;
            }
        } catch (Exception ex) {
            Logger.getLogger(ConsulterMateriel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initMateriel() {
        jTextFieldCode.setText(materiel.getCode());
        jTextFieldType.setText(materiel.getTypeMateriel());
        jTextFieldLib.setText(materiel.getLib());
        jTextFieldUnite.setText(materiel.getUniteConsommation());
        jTextFieldLocal.setText(materiel.getNumero());
        jTextFieldBatiment.setText(materiel.getBatiment());
        jTextFieldEtage.setText(materiel.getEtage());
        jTextFieldConsommationMoyenne.setText(materiel.getMoyenneConsommation() + "");
        jTextFieldConsommationTotal.setText(materiel.getSommeConsommation() + "");
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
        buttonFermer = new javax.swing.JButton();
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
        jLabelConsommationTotal = new javax.swing.JLabel();
        jTextFieldConsommationTotal = new javax.swing.JTextField();
        jLabelConsommationMoyenne = new javax.swing.JLabel();
        jTextFieldConsommationMoyenne = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabelDate = new javax.swing.JLabel();
        dateChooserDateDebut = new com.toedter.calendar.JDateChooser();
        jLabelValeur = new javax.swing.JLabel();
        jTextFieldValuer = new javax.swing.JTextField();
        jButtonAddConsommation = new javax.swing.JButton();
        jButtonSupprimer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulter materiel");
        setResizable(false);

        buttonFermer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonFermer.setForeground(new java.awt.Color(255, 0, 0));
        buttonFermer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/fermeBouton.png"))); // NOI18N
        buttonFermer.setText("Fermer");
        buttonFermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFermerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonLayout = new javax.swing.GroupLayout(panelButton);
        panelButton.setLayout(panelButtonLayout);
        panelButtonLayout.setHorizontalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonLayout.createSequentialGroup()
                .addContainerGap(708, Short.MAX_VALUE)
                .addComponent(buttonFermer)
                .addGap(18, 18, 18))
        );
        panelButtonLayout.setVerticalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonFermer)
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

        jTextFieldUnite.setEnabled(false);

        jLabelUnite.setText("Unité");

        jLabelConsommationTotal.setText("Consommation total");

        jTextFieldConsommationTotal.setEnabled(false);

        jLabelConsommationMoyenne.setText("Consommation moyenne");

        jTextFieldConsommationMoyenne.setEnabled(false);

        javax.swing.GroupLayout jPanelEnterpriseLayout = new javax.swing.GroupLayout(jPanelEnterprise);
        jPanelEnterprise.setLayout(jPanelEnterpriseLayout);
        jPanelEnterpriseLayout.setHorizontalGroup(
            jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                        .addComponent(jLabelConsommationMoyenne)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldConsommationMoyenne, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                        .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCode)
                            .addComponent(jLabelLocal))
                        .addGap(62, 62, 62)
                        .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                                .addComponent(jTextFieldLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelEtage))
                            .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                                .addComponent(jTextFieldCode)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelType)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEnterpriseLayout.createSequentialGroup()
                        .addComponent(jTextFieldType, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                        .addComponent(jLabelLib)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldLib, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEnterpriseLayout.createSequentialGroup()
                        .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                                .addComponent(jTextFieldEtage, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelBatiment))
                            .addGroup(jPanelEnterpriseLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabelConsommationTotal)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldConsommationTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelUnite)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldBatiment, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(jTextFieldUnite))))
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
                    .addComponent(jLabelUnite)
                    .addComponent(jTextFieldConsommationTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelConsommationTotal)
                    .addComponent(jTextFieldConsommationMoyenne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelConsommationMoyenne))
                .addContainerGap())
        );

        table.setModel(defaultTableModel);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jLabelDate.setText("Date");

        dateChooserDateDebut.setDateFormatString("dd/MM/yyyy");

        jLabelValeur.setText("Valeur");

        jButtonAddConsommation.setText("Ajouter");
        jButtonAddConsommation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddConsommationActionPerformed(evt);
            }
        });

        jButtonSupprimer.setText("Supprimer");
        jButtonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSupprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateChooserDateDebut, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelValeur)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldValuer, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAddConsommation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSupprimer)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldValuer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonAddConsommation)
                        .addComponent(jLabelValeur)
                        .addComponent(jButtonSupprimer))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelDate)
                        .addComponent(dateChooserDateDebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelEnterprise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanelEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonFermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFermerActionPerformed
        // TODO add your handling code here:
        fermerButton();
    }//GEN-LAST:event_buttonFermerActionPerformed

    private void tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMousePressed
        // TODO add your handling code here:
        if (!(consommationMaterielSelected == null)) {
            consommationMaterielSelected = new ConsommationMateriel();
        }
        selectedRow = table.getSelectedRow();
        consommationMaterielSelected = consommationMaterielList.get(selectedRow);
    }//GEN-LAST:event_tableMousePressed

    private void jButtonAddConsommationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddConsommationActionPerformed
        // TODO add your handling code here:
        addConsommationMateriel();
    }//GEN-LAST:event_jButtonAddConsommationActionPerformed

    private void jButtonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupprimerActionPerformed
        // TODO add your handling code here:
        deleteConsommationMateriel();
    }//GEN-LAST:event_jButtonSupprimerActionPerformed

    private void fermerButton() {
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonFermer;
    private com.toedter.calendar.JDateChooser dateChooserDateDebut;
    private javax.swing.JButton jButtonAddConsommation;
    private javax.swing.JButton jButtonSupprimer;
    private javax.swing.JLabel jLabelBatiment;
    private javax.swing.JLabel jLabelCode;
    private javax.swing.JLabel jLabelConsommationMoyenne;
    private javax.swing.JLabel jLabelConsommationTotal;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelEtage;
    private javax.swing.JLabel jLabelLib;
    private javax.swing.JLabel jLabelLocal;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JLabel jLabelUnite;
    private javax.swing.JLabel jLabelValeur;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelEnterprise;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldBatiment;
    private javax.swing.JTextField jTextFieldCode;
    private javax.swing.JTextField jTextFieldConsommationMoyenne;
    private javax.swing.JTextField jTextFieldConsommationTotal;
    private javax.swing.JTextField jTextFieldEtage;
    private javax.swing.JTextField jTextFieldLib;
    private javax.swing.JTextField jTextFieldLocal;
    private javax.swing.JTextField jTextFieldType;
    private javax.swing.JTextField jTextFieldUnite;
    private javax.swing.JTextField jTextFieldValuer;
    private javax.swing.JPanel panelButton;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
