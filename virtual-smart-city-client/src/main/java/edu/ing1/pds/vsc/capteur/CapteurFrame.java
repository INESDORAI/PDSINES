package edu.ing1.pds.vsc.capteur;

import edu.ing1.pds.vsc.enterprise.Enterprise;
import edu.ing1.pds.vsc.local.CrudLocal;
import edu.ing1.pds.vsc.local.Local;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ines
 */
public class CapteurFrame extends javax.swing.JInternalFrame {

    private Enterprise enterprise;
    private String[] titreCapteur;
    private DefaultTableModel defaultTableModel;
    private int selectedRow;

    public List<Capteur> capteurList;
    private Capteur capteurSelected;
    private CrudCapteur crudCapteur;

    private ReadCapteur readCapteur;
    private ConsulterCapteur consulterCapteur;
    private SupprimerCapteur supprimerCapteur;

    private DefaultComboBoxModel comboBoxModelMois;
    private DefaultComboBoxModel comboBoxModelAnnee;
    private DefaultComboBoxModel comboBoxModelLocal;

    private List<Local> localList;
    private Integer mois;
    private Integer annee;
    private Integer idLocal;

    /**
     * Creates new form CapteurFrame
     */
    public CapteurFrame(Enterprise enterprise) {
        this.enterprise = enterprise;
        initComboBoxLocal();
        initComboBoxAnnee();
        initComboBoxAMois();
        initFrame();
        initTableCapteur();
        initComponents();
    }

    private void initFrame() {
        crudCapteur = new CrudCapteur();

    }

    private void initTableCapteur() {
        if (defaultTableModel == null) {
            defaultTableModel = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int col) {
                    if (col == 0 || col == 1 || col == 2 || col == 3 || col == 4 || col == 5 || col == 6) {
                        return false;
                    } else {
                        return true;
                    }
                }
            ;
            };
            titreCapteur = "Date,Code,Type,Valeur,Local,Etage,Batiment".split(",");
            defaultTableModel.setColumnIdentifiers(titreCapteur);
        }
        selectedRow = -1;
        if (!(capteurSelected == null)) {
            capteurSelected = new Capteur();
        }
        initTableModelCapteur();
    }

    public void initTableModelCapteur() {
        try {
            capteurList = crudCapteur.findByIdEnterprise(enterprise.getId());
        } catch (Exception ex) {
            Logger.getLogger(CapteurFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (capteurList != null && !capteurList.isEmpty()) {
            for (Capteur capteur : capteurList) {
                Vector<Object> ligne = new Vector<Object>();
                ligne.add(capteur.getDateCapteur());
                ligne.add(capteur.getCode());
                ligne.add(capteur.getTypeCapteur());
                ligne.add(capteur.getValeurCapteur());
                ligne.add(capteur.getNumero());
                ligne.add(capteur.getEtage());
                ligne.add(capteur.getBatiment());

                defaultTableModel.addRow(ligne);
            }
        }
    }

    public void initTableModelCapteurByIdLocalMoisAnnee() {
        try {
            if (idLocal == null && (mois == null && annee == null)) {
                capteurList = crudCapteur.findByIdEnterprise(enterprise.getId());
            }
            if (idLocal != null && (mois == null && annee == null)) {
                capteurList = crudCapteur.findByIdEnterpriseIdLocal(enterprise.getId(), idLocal);
            }
            if (idLocal == null && (mois != null && annee != null)) {
                capteurList = crudCapteur.findByIdEnterpriseMoisAnnee(enterprise.getId(), mois, annee);
            }
            if (idLocal != null && (mois != null && annee != null)) {
                capteurList = crudCapteur.findByIdEnterpriseIdLocalMoisAnnee(enterprise.getId(), idLocal, mois, annee);
            }
        } catch (Exception ex) {
            Logger.getLogger(CapteurFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (capteurList != null && !capteurList.isEmpty()) {
            for (Capteur capteur : capteurList) {
                Vector<Object> ligne = new Vector<Object>();
                ligne.add(capteur.getDateCapteur());
                ligne.add(capteur.getCode());
                ligne.add(capteur.getTypeCapteur());
                ligne.add(capteur.getValeurCapteur());
                ligne.add(capteur.getNumero());
                ligne.add(capteur.getEtage());
                ligne.add(capteur.getBatiment());

                defaultTableModel.addRow(ligne);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBouton = new javax.swing.JPanel();
        buttonFermer = new javax.swing.JButton();
        buttonActualiser = new javax.swing.JButton();
        buttonConsulter = new javax.swing.JButton();
        buttonModifier = new javax.swing.JButton();
        buttonNouveau = new javax.swing.JButton();
        buttonSupprimer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabelMois = new javax.swing.JLabel();
        jComboBoxMois = new javax.swing.JComboBox<>();
        jLabelAnnee = new javax.swing.JLabel();
        jComboBoxAnnee = new javax.swing.JComboBox<>();
        jLabelLocal = new javax.swing.JLabel();
        jComboBoxLocal = new javax.swing.JComboBox<>();
        jButtonRechercher = new javax.swing.JButton();
        jLabelMsg = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Liste des capteurs");
        setVisible(true);

        buttonFermer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonFermer.setText("Fermer");
        buttonFermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFermerActionPerformed(evt);
            }
        });

        buttonActualiser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonActualiser.setText("Actualiser");
        buttonActualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActualiserActionPerformed(evt);
            }
        });

        buttonConsulter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonConsulter.setText("Consulter");
        buttonConsulter.setEnabled(false);
        buttonConsulter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConsulterActionPerformed(evt);
            }
        });

        buttonModifier.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonModifier.setText("Modifier");
        buttonModifier.setEnabled(false);
        buttonModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModifierActionPerformed(evt);
            }
        });

        buttonNouveau.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonNouveau.setText("Nouveau");
        buttonNouveau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNouveauActionPerformed(evt);
            }
        });

        buttonSupprimer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonSupprimer.setText("Supprimer");
        buttonSupprimer.setEnabled(false);
        buttonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSupprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBoutonLayout = new javax.swing.GroupLayout(panelBouton);
        panelBouton.setLayout(panelBoutonLayout);
        panelBoutonLayout.setHorizontalGroup(
            panelBoutonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoutonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonNouveau, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonSupprimer)
                .addGap(18, 18, 18)
                .addComponent(buttonConsulter, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 266, Short.MAX_VALUE)
                .addComponent(buttonActualiser, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonFermer)
                .addContainerGap())
        );
        panelBoutonLayout.setVerticalGroup(
            panelBoutonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoutonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBoutonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonNouveau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonModifier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonFermer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonConsulter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonActualiser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonSupprimer))
                .addContainerGap())
        );

        table.setModel(defaultTableModel);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jLabelMois.setText("Mois");

        jComboBoxMois.setModel(comboBoxModelMois);
        jComboBoxMois.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxMoisItemStateChanged(evt);
            }
        });

        jLabelAnnee.setText("Année");

        jComboBoxAnnee.setModel(comboBoxModelAnnee);
        jComboBoxAnnee.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxAnneeItemStateChanged(evt);
            }
        });

        jLabelLocal.setText("Local");

        jComboBoxLocal.setModel(comboBoxModelLocal);
        jComboBoxLocal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxLocalItemStateChanged(evt);
            }
        });

        jButtonRechercher.setText("Rechercher");
        jButtonRechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRechercherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabelMois, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxMois, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jLabelAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButtonRechercher)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelLocal)
                        .addComponent(jComboBoxLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonRechercher))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelAnnee)
                        .addComponent(jComboBoxAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelMois)
                        .addComponent(jComboBoxMois, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBouton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(panelBouton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonFermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFermerActionPerformed
        // TODO add your handling code here:
        closeCapteurFrame();
    }//GEN-LAST:event_buttonFermerActionPerformed

    private void buttonActualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActualiserActionPerformed
        // TODO add your handling code here:
        mois = null;
        annee = null;
        idLocal = null;
        jComboBoxAnnee.setSelectedItem("");
        jComboBoxMois.setSelectedItem("");
        jComboBoxLocal.setSelectedItem("");
        refrechCapteur();
    }//GEN-LAST:event_buttonActualiserActionPerformed

    private void buttonConsulterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConsulterActionPerformed
        // TODO add your handling code here:
        afficherCapteur();
    }//GEN-LAST:event_buttonConsulterActionPerformed

    private void buttonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModifierActionPerformed
        // TODO add your handling code here:
        modifierCapteur();
    }//GEN-LAST:event_buttonModifierActionPerformed

    private void buttonNouveauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNouveauActionPerformed
        // TODO add your handling code here:
        addCapteur();
    }//GEN-LAST:event_buttonNouveauActionPerformed

    private void buttonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSupprimerActionPerformed
        // TODO add your handling code here:
        deleteCapteur();
    }//GEN-LAST:event_buttonSupprimerActionPerformed

    private void tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMousePressed
        // TODO add your handling code here:
        if (!(capteurSelected == null)) {
            capteurSelected = new Capteur();
        }
        selectedRow = table.getSelectedRow();
        capteurSelected = capteurList.get(selectedRow);
        buttonModifier.setEnabled(true);
        buttonConsulter.setEnabled(true);
        buttonSupprimer.setEnabled(true);
    }//GEN-LAST:event_tableMousePressed

    private void jButtonRechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRechercherActionPerformed
        // TODO add your handling code here:
        System.out.println("mois---" + mois);
        System.out.println("annee---" + annee);
        System.out.println("idLocal---" + idLocal);
        System.out.println("idEnterprise---" + enterprise.getId());
        boolean rechercher = true;
        if (mois == null && annee != null) {
            jLabelMsg.setText("Mois est vide");
            rechercher = false;
        }
        if (mois != null && annee == null) {
            jLabelMsg.setText("Annee est vide");
            rechercher = false;
        }
        if (rechercher) {
            refrechCapteur();
        }
    }//GEN-LAST:event_jButtonRechercherActionPerformed

    private void jComboBoxMoisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxMoisItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == 1) {
            String moisString = evt.getItem().toString();
            if (moisString != null && !moisString.isEmpty()) {
                switch (moisString) {
                    case "Janvier":
                        mois = 1;
                        break;
                    case "Février":
                        mois = 2;
                        break;
                    case "Mars":
                        mois = 3;
                        break;
                    case "Avril":
                        mois = 4;
                        break;
                    case "Mai":
                        mois = 5;
                        break;
                    case "Juin":
                        mois = 6;
                        break;
                    case "Juillet":
                        mois = 7;
                        break;
                    case "Aôut":
                        mois = 8;
                        break;
                    case "Septembre":
                        mois = 9;
                        break;
                    case "Octobre":
                        mois = 10;
                        break;
                    case "Novembre":
                        mois = 11;
                        break;
                    case "Décembre":
                        mois = 12;
                        break;
                    default:
                        mois = null;
                }
            }
        } else {
            mois = null;
        }
    }//GEN-LAST:event_jComboBoxMoisItemStateChanged

    private void jComboBoxAnneeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxAnneeItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == 1) {
            String anneeString = evt.getItem().toString();
            if (anneeString != null && !anneeString.isEmpty()) {
                annee = Integer.valueOf(anneeString);
            }
        } else {
            annee = null;
        }
    }//GEN-LAST:event_jComboBoxAnneeItemStateChanged

    private void jComboBoxLocalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxLocalItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == 1) {
            String numero = evt.getItem().toString();
            if (numero != null && !numero.isEmpty()) {
                for (Local local : localList) {
                    if (numero.equals(local.getNumero())) {
                        idLocal = local.getId();
                        break;
                    }
                }
            }
        } else {
            idLocal = null;
        }
    }//GEN-LAST:event_jComboBoxLocalItemStateChanged

    private void closeCapteurFrame() {
        this.dispose();
    }

    public void refrechCapteur() {
        if (capteurList != null) {
            capteurList.clear();
        }
        removeAllTableCapteur();
        initTableModelCapteurByIdLocalMoisAnnee();
    }

    private void afficherCapteur() {
        if (selectedRow != -1) {
            try {
                buttonModifier.setEnabled(false);
                buttonConsulter.setEnabled(false);
                buttonSupprimer.setEnabled(false);
                consulterCapteur = new ConsulterCapteur(null, true, capteurSelected);
                closeConsulterCapteur();
                initSelectRow();
            } catch (Exception e) {
                e.printStackTrace();
                new JOptionPane().showMessageDialog(null, "Message d'erreur :" + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void modifierCapteur() {
        if (selectedRow != -1) {
            try {
                buttonModifier.setEnabled(false);
                buttonConsulter.setEnabled(false);
                buttonSupprimer.setEnabled(false);
                readCapteur = new ReadCapteur(null, true, this, enterprise, capteurSelected, "upd", crudCapteur);
                closeAjouterCapteur();
                initSelectRow();
            } catch (Exception e) {
                e.printStackTrace();
                new JOptionPane().showMessageDialog(null, "Message d'erreur :" + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } else {
        }
    }

    private void addCapteur() {
        readCapteur = new ReadCapteur(new JFrame(), true, this, enterprise, null, "add", crudCapteur);
        closeAjouterCapteur();
    }

    private void deleteCapteur() {
        if (selectedRow != -1) {
            try {
                buttonModifier.setEnabled(false);
                buttonSupprimer.setEnabled(false);
                buttonConsulter.setEnabled(false);
                supprimerCapteur = new SupprimerCapteur(null, true, this, capteurSelected, crudCapteur);
                closeSupprimerCapteur();

                initSelectRow();
            } catch (HeadlessException e) {
                e.printStackTrace();
                new JOptionPane().showMessageDialog(null, "Message d'erreur :" + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void closeAjouterCapteur() {
        readCapteur.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                readCapteur.dispose();
            }
        });
    }

    private void closeConsulterCapteur() {
        consulterCapteur.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                consulterCapteur.dispose();
            }
        });
    }

    private void closeSupprimerCapteur() {
        supprimerCapteur.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                supprimerCapteur.dispose();
            }
        });
    }

    private void removeAllTableCapteur() {
        for (int i = defaultTableModel.getRowCount() - 1; i >= 0; --i) {
            defaultTableModel.removeRow(i);
        }
    }

    private void initSelectRow() {
        selectedRow = -1;
        capteurSelected = null;
    }

    private void initComboBoxLocal() {
        Vector<String> item = new Vector<>();
        item.add("");
        CrudLocal crudLocal = new CrudLocal();
        try {
            localList = crudLocal.findByIdEnterprise(enterprise.getId());
            for (Local local : localList) {
                item.add(local.getNumero());
            }
            comboBoxModelLocal = new DefaultComboBoxModel(item);
        } catch (Exception ex) {
            Logger.getLogger(ReadCapteur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initComboBoxAnnee() {
        Vector<String> item = new Vector<>();
        item.add("");
        Calendar calendar = Calendar.getInstance();
        int anneeCourante = calendar.get(Calendar.YEAR);
        for (int i = 2020; i <= anneeCourante; i++) {
            item.add("" + i);
        }
        comboBoxModelAnnee = new DefaultComboBoxModel(item);
    }

    private void initComboBoxAMois() {
        Vector<String> item = new Vector<>();
        item.add("");
        item.add("Janvier");
        item.add("Février");
        item.add("Mars");
        item.add("Avril");
        item.add("Mai");
        item.add("Juin");
        item.add("Juillet");
        item.add("Aôut");
        item.add("Septembre");
        item.add("Octobre");
        item.add("Novembre");
        item.add("Décembre");
        comboBoxModelMois = new DefaultComboBoxModel(item);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonActualiser;
    private javax.swing.JButton buttonConsulter;
    private javax.swing.JButton buttonFermer;
    private javax.swing.JButton buttonModifier;
    private javax.swing.JButton buttonNouveau;
    private javax.swing.JButton buttonSupprimer;
    private javax.swing.JButton jButtonRechercher;
    private javax.swing.JComboBox<String> jComboBoxAnnee;
    private javax.swing.JComboBox<String> jComboBoxLocal;
    private javax.swing.JComboBox<String> jComboBoxMois;
    private javax.swing.JLabel jLabelAnnee;
    private javax.swing.JLabel jLabelLocal;
    private javax.swing.JLabel jLabelMois;
    private javax.swing.JLabel jLabelMsg;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelBouton;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
