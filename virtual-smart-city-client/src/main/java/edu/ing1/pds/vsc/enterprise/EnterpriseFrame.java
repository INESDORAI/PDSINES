package edu.ing1.pds.vsc.enterprise;

import edu.ing1.pds.vsc.enterprise.ConsulterEnterprise;
import edu.ing1.pds.vsc.enterprise.CrudEnterprise;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Karim
 */
public class EnterpriseFrame extends javax.swing.JInternalFrame {

    private String[] titreEnterprise;
    private DefaultTableModel defaultTableModel;
    private int selectedRow;

    private List<Enterprise> enterpriseList;
    private Enterprise enterpriseSelected;
    private CrudEnterprise crudEnterprise;

    private ReadEnterprise readEnterprise;
    private ConsulterEnterprise consulterEnterprise;
    private SupprimerEnterprise supprimerEnterprise;

    /**
     * Creates new form EnterpriseFrame
     */
    public EnterpriseFrame() {
        initFrame();
        initTableEnterprise();
        initComponents();
    }

    private void initFrame() {
        crudEnterprise = new CrudEnterprise();

    }

    private void initTableEnterprise() {
        if (defaultTableModel == null) {
            defaultTableModel = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int col) {
                    if (col == 0 || col == 1 || col == 2 || col == 3 || col == 4) {
                        return false;
                    } else {
                        return true;
                    }
                }
            ;
            };
            titreEnterprise = "Code,Libillé,Adresse,Code postal,Pays".split(",");
            defaultTableModel.setColumnIdentifiers(titreEnterprise);
        }
        selectedRow = -1;
        if (!(enterpriseSelected == null)) {
            enterpriseSelected = new Enterprise();
        }
        initTableModelEnterprise();
    }

    public void initTableModelEnterprise() {
        try {
            enterpriseList = crudEnterprise.findAll();
        } catch (Exception ex) {
            Logger.getLogger(EnterpriseFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (enterpriseList != null && !enterpriseList.isEmpty()) {
            for (Enterprise enterprise : enterpriseList) {
                Vector<Object> ligne = new Vector<Object>();
                ligne.add(enterprise.getCode());
                ligne.add(enterprise.getLib());
                ligne.add(enterprise.getAdresse());
                ligne.add(enterprise.getCodePostal());
                ligne.add(enterprise.getPays());

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
        buttonActualisier = new javax.swing.JButton();
        buttonConsulter = new javax.swing.JButton();
        buttonModifier = new javax.swing.JButton();
        buttonNouveau = new javax.swing.JButton();
        buttonSupprimer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setClosable(true);
        setVisible(true);

        buttonFermer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonFermer.setText("Fermer");
        buttonFermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFermerActionPerformed(evt);
            }
        });

        buttonActualisier.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonActualisier.setText("Actualisier");
        buttonActualisier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActualisierActionPerformed(evt);
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
                .addComponent(buttonActualisier, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(buttonActualisier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBouton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(panelBouton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonFermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFermerActionPerformed
        // TODO add your handling code here:
        closeEnterpriseFrame();
    }//GEN-LAST:event_buttonFermerActionPerformed

    private void buttonActualisierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActualisierActionPerformed
        // TODO add your handling code here:
        refrechEnterprise();
    }//GEN-LAST:event_buttonActualisierActionPerformed

    private void buttonConsulterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConsulterActionPerformed
        // TODO add your handling code here:
        afficherEnterprise();
    }//GEN-LAST:event_buttonConsulterActionPerformed

    private void buttonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModifierActionPerformed
        // TODO add your handling code here:
        modifierEnterprise();
    }//GEN-LAST:event_buttonModifierActionPerformed

    private void buttonNouveauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNouveauActionPerformed
        // TODO add your handling code here:
        addEnterprise();
    }//GEN-LAST:event_buttonNouveauActionPerformed

    private void buttonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSupprimerActionPerformed
        // TODO add your handling code here:
        deleteEnterprise();
    }//GEN-LAST:event_buttonSupprimerActionPerformed

    private void tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMousePressed
        // TODO add your handling code here:
        if (!(enterpriseSelected == null)) {
            enterpriseSelected = new Enterprise();
        }
        selectedRow = table.getSelectedRow();
        enterpriseSelected = enterpriseList.get(selectedRow);
        buttonModifier.setEnabled(true);
        buttonConsulter.setEnabled(true);
        buttonSupprimer.setEnabled(true);
    }//GEN-LAST:event_tableMousePressed

    private void closeEnterpriseFrame() {
        this.dispose();
    }

    public void refrechEnterprise() {
        if (enterpriseList != null) {
            enterpriseList.clear();
        }
        removeAllTableEnterprise();
        initTableModelEnterprise();
    }

    private void afficherEnterprise() {
        if (selectedRow != -1) {
            try {
                buttonModifier.setEnabled(false);
                buttonConsulter.setEnabled(false);
                buttonSupprimer.setEnabled(false);
                consulterEnterprise = new ConsulterEnterprise(null, true, enterpriseSelected);
                closeConsulterEnterprise();
                initSelectRow();
            } catch (Exception e) {
                e.printStackTrace();
                new JOptionPane().showMessageDialog(null, "Message d'erreur :" + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void modifierEnterprise() {
        if (selectedRow != -1) {
            try {
                buttonModifier.setEnabled(false);
                buttonConsulter.setEnabled(false);
                buttonSupprimer.setEnabled(false);
                readEnterprise = new ReadEnterprise(null, true, this, enterpriseSelected, "upd", crudEnterprise);
                closeAjouterEnterprise();
                initSelectRow();
            } catch (Exception e) {
                e.printStackTrace();
                new JOptionPane().showMessageDialog(null, "Message d'erreur :" + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } else {
        }
    }

    private void addEnterprise() {
        readEnterprise = new ReadEnterprise(new JFrame(), true, this, null, "add", crudEnterprise);
        closeAjouterEnterprise();
    }

    private void deleteEnterprise() {
        if (selectedRow != -1) {
            try {
                buttonModifier.setEnabled(false);
                buttonSupprimer.setEnabled(false);
                buttonConsulter.setEnabled(false);
                supprimerEnterprise = new SupprimerEnterprise(null, true, this, enterpriseSelected, crudEnterprise);
                closeSupprimerEnterprise();

                initSelectRow();
            } catch (HeadlessException e) {
                e.printStackTrace();
                new JOptionPane().showMessageDialog(null, "Message d'erreur :" + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void closeAjouterEnterprise() {
        readEnterprise.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                readEnterprise.dispose();
            }
        });
    }

    private void closeConsulterEnterprise() {
        consulterEnterprise.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                consulterEnterprise.dispose();
            }
        });
    }

    private void closeSupprimerEnterprise() {
        supprimerEnterprise.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                supprimerEnterprise.dispose();
            }
        });
    }

    private void removeAllTableEnterprise() {
        for (int i = defaultTableModel.getRowCount() - 1; i >= 0; --i) {
            defaultTableModel.removeRow(i);
        }
    }

    private void initSelectRow() {
        selectedRow = -1;
        enterpriseSelected = null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonActualisier;
    private javax.swing.JButton buttonConsulter;
    private javax.swing.JButton buttonFermer;
    private javax.swing.JButton buttonModifier;
    private javax.swing.JButton buttonNouveau;
    private javax.swing.JButton buttonSupprimer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelBouton;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}