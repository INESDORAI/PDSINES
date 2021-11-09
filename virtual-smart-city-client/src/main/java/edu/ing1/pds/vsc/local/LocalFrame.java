package edu.ing1.pds.vsc.local;

import edu.ing1.pds.vsc.enterprise.Enterprise;
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
 * @author Ines
 */
public class LocalFrame extends javax.swing.JInternalFrame {

    private String[] titreLocal;
    private DefaultTableModel defaultTableModel;
    private int selectedRow;

    public List<Local> localList;
    private Local localSelected;
    private Enterprise enterprise;
    private CrudLocal crudLocal;

    private ReadLocal readLocal;
    private ConsulterLocal consulterLocal;
    private SupprimerLocal supprimerLocal;

    /**
     * Creates new form LocalFrame
     */
    public LocalFrame(Enterprise enterprise) {
        this.enterprise = enterprise;
        initFrame();
        initTableLocal();
        initComponents();
    }

    private void initFrame() {
        crudLocal = new CrudLocal();
    }

    private void initTableLocal() {
        if (defaultTableModel == null) {
            defaultTableModel = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int col) {
                    if (col == 0 || col == 1 || col == 2 || col == 3 || col == 4 || col == 5 || col == 6 || col == 7 || col == 8 || col == 9) {
                        return false;
                    } else {
                        return true;
                    }
                }
            ;
            };
            titreLocal = "Numero,Libillé,Batiment,Etage,Place,Place occupée,Taux occupation,Capteur,Matériel,Mobilier".split(",");
            defaultTableModel.setColumnIdentifiers(titreLocal);
        }
        selectedRow = -1;
        if (!(localSelected == null)) {
            localSelected = new Local();
        }
        initTableModelLocal();
    }

    public void initTableModelLocal() {
        try {
            localList = crudLocal.findByIdEnterprise(enterprise.getId());
        } catch (Exception ex) {
            Logger.getLogger(LocalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (localList != null && !localList.isEmpty()) {
            for (Local local : localList) {
                Vector<Object> ligne = new Vector<Object>();
                ligne.add(local.getNumero());
                ligne.add(local.getLib());
                ligne.add(local.getBatiment());
                ligne.add(local.getEtage());
                ligne.add(local.getNbrePlace());
                ligne.add(local.getNbrePlaceOccupe());
                ligne.add(local.getTauxOccupation() + " %");
                ligne.add(local.getNbreCapteur());
                ligne.add(local.getNbreMateriel());
                ligne.add(local.getNbreMobilier());

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

        setClosable(true);
        setTitle("Liste des locaux");
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
        closeLocalFrame();
    }//GEN-LAST:event_buttonFermerActionPerformed

    private void buttonActualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActualiserActionPerformed
        // TODO add your handling code here:
        refrechLocal();
    }//GEN-LAST:event_buttonActualiserActionPerformed

    private void buttonConsulterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConsulterActionPerformed
        // TODO add your handling code here:
        afficherLocal();
    }//GEN-LAST:event_buttonConsulterActionPerformed

    private void buttonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModifierActionPerformed
        // TODO add your handling code here:
        modifierLocal();
    }//GEN-LAST:event_buttonModifierActionPerformed

    private void buttonNouveauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNouveauActionPerformed
        // TODO add your handling code here:
        addLocal();
    }//GEN-LAST:event_buttonNouveauActionPerformed

    private void buttonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSupprimerActionPerformed
        // TODO add your handling code here:
        deleteLocal();
    }//GEN-LAST:event_buttonSupprimerActionPerformed

    private void tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMousePressed
        // TODO add your handling code here:
        if (!(localSelected == null)) {
            localSelected = new Local();
        }
        selectedRow = table.getSelectedRow();
        localSelected = localList.get(selectedRow);
        buttonModifier.setEnabled(true);
        buttonConsulter.setEnabled(true);
        buttonSupprimer.setEnabled(true);
    }//GEN-LAST:event_tableMousePressed

    private void closeLocalFrame() {
        this.dispose();
    }

    public void refrechLocal() {
        if (localList != null) {
            localList.clear();
        }
        removeAllTableLocal();
        initTableModelLocal();
    }

    private void afficherLocal() {
        if (selectedRow != -1) {
            try {
                buttonModifier.setEnabled(false);
                buttonConsulter.setEnabled(false);
                buttonSupprimer.setEnabled(false);
                consulterLocal = new ConsulterLocal(null, true, localSelected);
                closeConsulterLocal();
                initSelectRow();
            } catch (Exception e) {
                e.printStackTrace();
                new JOptionPane().showMessageDialog(null, "Message d'erreur :" + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void modifierLocal() {
        if (selectedRow != -1) {
            try {
                buttonModifier.setEnabled(false);
                buttonConsulter.setEnabled(false);
                buttonSupprimer.setEnabled(false);
                readLocal = new ReadLocal(null, true, this, enterprise, localSelected, "upd", crudLocal);
                closeAjouterLocal();
                initSelectRow();
            } catch (Exception e) {
                e.printStackTrace();
                new JOptionPane().showMessageDialog(null, "Message d'erreur :" + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } else {
        }
    }

    private void addLocal() {
        readLocal = new ReadLocal(new JFrame(), true, this, enterprise, null, "add", crudLocal);
        closeAjouterLocal();
    }

    private void deleteLocal() {
        if (selectedRow != -1) {
            try {
                buttonModifier.setEnabled(false);
                buttonSupprimer.setEnabled(false);
                buttonConsulter.setEnabled(false);
                supprimerLocal = new SupprimerLocal(null, true, this, localSelected, crudLocal);
                closeSupprimerLocal();

                initSelectRow();
            } catch (HeadlessException e) {
                e.printStackTrace();
                new JOptionPane().showMessageDialog(null, "Message d'erreur :" + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void closeAjouterLocal() {
        readLocal.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                readLocal.dispose();
            }
        });
    }

    private void closeConsulterLocal() {
        consulterLocal.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                consulterLocal.dispose();
            }
        });
    }

    private void closeSupprimerLocal() {
        supprimerLocal.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                supprimerLocal.dispose();
            }
        });
    }

    private void removeAllTableLocal() {
        for (int i = defaultTableModel.getRowCount() - 1; i >= 0; --i) {
            defaultTableModel.removeRow(i);
        }
    }

    private void initSelectRow() {
        selectedRow = -1;
        localSelected = null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonActualiser;
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
