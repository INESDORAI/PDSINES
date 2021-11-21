package edu.ing1.pds.vsc.capteur;

import edu.ing1.pds.vsc.enterprise.Enterprise;
import edu.ing1.pds.vsc.local.CrudLocal;
import edu.ing1.pds.vsc.local.Local;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
    private String[] titreCapteurAnnee;
    private DefaultTableModel defaultTableModelAnnee;
    private int selectedRow;

    public List<Capteur> capteurList;
    public List<CapteurAnnee> capteurAnneeList;
    private Capteur capteurSelected;
    private CrudCapteur crudCapteur;

    private ReadCapteur readCapteur;
    private ConsulterCapteur consulterCapteur;
    private SupprimerCapteur supprimerCapteur;

    private DefaultComboBoxModel comboBoxModelMois;
    private DefaultComboBoxModel comboBoxModelAnnee;
    private DefaultComboBoxModel comboBoxModelAnneeMin;
    private DefaultComboBoxModel comboBoxModelAnneeMax;
    private DefaultComboBoxModel comboBoxModelLocal;

    private List<Local> localList;
    private Integer mois;
    private Integer annee;
    private Integer anneeMax;
    private Integer anneeMin;
    private Integer idLocal;

    private boolean isAll;
    private boolean isDernierMois;
    private boolean isMoisAnnee;
    private boolean isIntervalAnnee;

    /**
     * Creates new form CapteurFrame
     */
    public CapteurFrame(Enterprise enterprise) {
        this.enterprise = enterprise;
        initComboBoxAnnee();
        initComboBoxAnneeMin();
        initComboBoxAnneeMax();
        initComboBoxAMois();
        initComboBoxLocal();
        initFrame();
        initTableCapteur();
        initComponents();
        initRadioButton();
        rechercher();
    }

    private void initFrame() {
        crudCapteur = new CrudCapteur();
    }

    private void initRadioButton() {
        buttonGroup.add(jRadioButtonIntervalAnnee);
        buttonGroup.add(jRadioButtonMoisDernier);
        buttonGroup.add(jRadioButtonMoisAnnee);
        buttonGroup.add(jRadioButtonTous);

        jRadioButtonTous.setSelected(true);
        jRadioButtonMoisAnnee.setSelected(false);
        jRadioButtonMoisDernier.setSelected(false);
        jRadioButtonIntervalAnnee.setSelected(false);

        jComboBoxAnneeMin.setEnabled(false);
        jComboBoxAnneeMax.setEnabled(false);
        jComboBoxMois.setEnabled(false);
        jComboBoxAnnee.setEnabled(false);

        isAll = true;
        isMoisAnnee = false;
        isDernierMois = false;
        isIntervalAnnee = false;

        table.setModel(defaultTableModel);
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
    }

    private void initTableCapteurAnnee() {
        if (defaultTableModelAnnee == null) {
            defaultTableModelAnnee = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int col) {
                    if (col == 0 || col == 1) {
                        return false;
                    } else {
                        return true;
                    }
                }
            ;
            };
            titreCapteurAnnee = "Année,Nombre capteur".split(",");
            defaultTableModelAnnee.setColumnIdentifiers(titreCapteurAnnee);
        }
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

    public void rechercher() {
        try {
            if (isAll) {
                if (idLocal == null) {
                    capteurList = crudCapteur.findByIdEnterprise(enterprise.getId());
                } else {
                    capteurList = crudCapteur.findByIdEnterpriseIdLocal(enterprise.getId(), idLocal);
                }
            } else if (isMoisAnnee) {
                if (idLocal == null && (mois == null && annee == null)) {
                    capteurList = crudCapteur.findByIdEnterprise(enterprise.getId());
                } else if (idLocal == null && (mois == null && annee != null)) {
                    capteurList = crudCapteur.findByIdEnterpriseAnnee(enterprise.getId(), annee);
                } else if (idLocal != null && (mois == null && annee == null)) {
                    capteurList = crudCapteur.findByIdEnterpriseIdLocal(enterprise.getId(), idLocal);
                } else if (idLocal == null && (mois != null && annee != null)) {
                    capteurList = crudCapteur.findByIdEnterpriseMoisAnnee(enterprise.getId(), mois, annee);
                } else if (idLocal != null && (mois != null && annee != null)) {
                    capteurList = crudCapteur.findByIdEnterpriseIdLocalMoisAnnee(enterprise.getId(), idLocal, mois, annee);
                } else if (idLocal != null && (mois == null && annee != null)) {
                    capteurList = crudCapteur.findByIdEnterpriseIdLocalAnnee(enterprise.getId(), idLocal, annee);
                }
            } else if (isDernierMois) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Calendar c = Calendar.getInstance();
                c.setTime(new Date());
                c.add(Calendar.MONTH, -1);
                String dateDebutString = dateFormat.format(c.getTime());
                String dateFinString = dateFormat.format(new Date());
                if (idLocal != null) {
                    capteurList = crudCapteur.findByIdEnterpriseIdLocalDate(enterprise.getId(), idLocal, dateDebutString, dateFinString);
                } else if (idLocal == null) {
                    capteurList = crudCapteur.findByIdEnterpriseDate(enterprise.getId(), dateDebutString, dateFinString);
                }
            } else if (isIntervalAnnee) {
                capteurAnneeList = crudCapteur.findByIdEnterpriseIntervalAnnee(enterprise.getId(), anneeMin, anneeMax);
            }
        } catch (Exception ex) {
            Logger.getLogger(CapteurFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (isMoisAnnee || isDernierMois || isAll) {
            removeAllTableCapteur();
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
            table.setModel(defaultTableModel);
            jTextFieldCapteur.setText("" + capteurList.size());
        } else if (isIntervalAnnee) {
            removeAllTableCapteurAnnee();
            int nbre = 0;
            if (capteurAnneeList != null && !capteurAnneeList.isEmpty()) {
                for (CapteurAnnee capteurAnnee : capteurAnneeList) {
                    Vector<Object> ligne = new Vector<Object>();
                    ligne.add(capteurAnnee.getAnnee());
                    ligne.add(capteurAnnee.getNbre());
                    System.out.println(capteurAnnee);
                    defaultTableModelAnnee.addRow(ligne);
                    nbre = nbre + capteurAnnee.getNbre();
                }
            }
            table.setModel(defaultTableModelAnnee);
            jTextFieldCapteur.setText("" + nbre);
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

        buttonGroup = new javax.swing.ButtonGroup();
        panelBouton = new javax.swing.JPanel();
        buttonFermer = new javax.swing.JButton();
        buttonActualiser = new javax.swing.JButton();
        buttonConsulter = new javax.swing.JButton();
        buttonModifier = new javax.swing.JButton();
        buttonNouveau = new javax.swing.JButton();
        buttonSupprimer = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        panelRechercher = new javax.swing.JPanel();
        jLabelMsg = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jRadioButtonIntervalAnnee = new javax.swing.JRadioButton();
        jLabelAnneeMin = new javax.swing.JLabel();
        jComboBoxAnneeMin = new javax.swing.JComboBox<>();
        jLabelAnneeMax = new javax.swing.JLabel();
        jComboBoxAnneeMax = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jRadioButtonMoisDernier = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jRadioButtonMoisAnnee = new javax.swing.JRadioButton();
        jLabelAnnee = new javax.swing.JLabel();
        jComboBoxAnnee = new javax.swing.JComboBox<>();
        jComboBoxMois = new javax.swing.JComboBox<>();
        jLabelMois = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonRechercher = new javax.swing.JButton();
        jLabelLocal = new javax.swing.JLabel();
        jComboBoxLocal = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jRadioButtonTous = new javax.swing.JRadioButton();
        panelNbreTotal = new javax.swing.JPanel();
        jTextFieldCapteur = new javax.swing.JTextField();
        jLabelNbreCapteur = new javax.swing.JLabel();

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        jScrollPane.setViewportView(table);

        jLabelMsg.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelMsg.setForeground(new java.awt.Color(255, 51, 51));

        jRadioButtonIntervalAnnee.setText("Interval année");
        jRadioButtonIntervalAnnee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonIntervalAnneeActionPerformed(evt);
            }
        });

        jLabelAnneeMin.setLabelFor(jComboBoxAnneeMin);
        jLabelAnneeMin.setText("Année min");

        jComboBoxAnneeMin.setModel(comboBoxModelAnneeMin);
        jComboBoxAnneeMin.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxAnneeMinItemStateChanged(evt);
            }
        });

        jLabelAnneeMax.setLabelFor(jComboBoxAnneeMax);
        jLabelAnneeMax.setText("Année max");

        jComboBoxAnneeMax.setModel(comboBoxModelAnneeMax);
        jComboBoxAnneeMax.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxAnneeMaxItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonIntervalAnnee)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAnneeMin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxAnneeMin, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAnneeMax, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxAnneeMax, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonIntervalAnnee)
                    .addComponent(jLabelAnneeMax)
                    .addComponent(jComboBoxAnneeMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAnneeMin)
                    .addComponent(jComboBoxAnneeMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jRadioButtonMoisDernier.setText("30 jours dernier");
        jRadioButtonMoisDernier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMoisDernierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonMoisDernier)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonMoisDernier)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jRadioButtonMoisAnnee.setText("Mois/année");
        jRadioButtonMoisAnnee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMoisAnneeActionPerformed(evt);
            }
        });

        jLabelAnnee.setLabelFor(jComboBoxAnnee);
        jLabelAnnee.setText("Année");

        jComboBoxAnnee.setModel(comboBoxModelAnnee);
        jComboBoxAnnee.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxAnneeItemStateChanged(evt);
            }
        });

        jComboBoxMois.setModel(comboBoxModelMois);
        jComboBoxMois.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxMoisItemStateChanged(evt);
            }
        });

        jLabelMois.setLabelFor(jComboBoxMois);
        jLabelMois.setText("Mois");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonMoisAnnee)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelMois, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxMois, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonMoisAnnee)
                    .addComponent(jLabelAnnee)
                    .addComponent(jComboBoxAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMois)
                    .addComponent(jComboBoxMois, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonRechercher.setText("Rechercher");
        jButtonRechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRechercherActionPerformed(evt);
            }
        });

        jLabelLocal.setLabelFor(jComboBoxLocal);
        jLabelLocal.setText("Local");

        jComboBoxLocal.setModel(comboBoxModelLocal);
        jComboBoxLocal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxLocalItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonRechercher)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLocal)
                    .addComponent(jComboBoxLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRechercher))
                .addContainerGap())
        );

        jRadioButtonTous.setText("Tous");
        jRadioButtonTous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTousActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonTous)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonTous)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRechercherLayout = new javax.swing.GroupLayout(panelRechercher);
        panelRechercher.setLayout(panelRechercherLayout);
        panelRechercherLayout.setHorizontalGroup(
            panelRechercherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRechercherLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRechercherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRechercherLayout.createSequentialGroup()
                        .addComponent(jLabelMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRechercherLayout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRechercherLayout.setVerticalGroup(
            panelRechercherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRechercherLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRechercherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRechercherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTextFieldCapteur.setEnabled(false);

        jLabelNbreCapteur.setText("Total capteurs");

        javax.swing.GroupLayout panelNbreTotalLayout = new javax.swing.GroupLayout(panelNbreTotal);
        panelNbreTotal.setLayout(panelNbreTotalLayout);
        panelNbreTotalLayout.setHorizontalGroup(
            panelNbreTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNbreTotalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelNbreCapteur)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldCapteur, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelNbreTotalLayout.setVerticalGroup(
            panelNbreTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNbreTotalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelNbreTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNbreCapteur, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCapteur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBouton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelNbreTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane)
            .addComponent(panelRechercher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRechercher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelNbreTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        initRadioButton();
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
        boolean rechercher = true;
        jLabelMsg.setText("");
        if (isMoisAnnee) {
            if (mois != null && annee == null) {
                jLabelMsg.setText("Annee est vide");
                rechercher = false;
            }
        }
        if (isIntervalAnnee) {
            if (anneeMin == null && anneeMax != null) {
                jLabelMsg.setText("Année min est vide");
                rechercher = false;
            } else if (anneeMin != null && anneeMax == null) {
                jLabelMsg.setText("Année max est vide");
                rechercher = false;
            } else if (anneeMin == null && anneeMax == null) {
                jLabelMsg.setText("Année min et max sont vide");
                rechercher = false;
            } else if (anneeMin != null && anneeMax != null && anneeMin > anneeMax) {
                jLabelMsg.setText("Année min est superieur à l'année max");
                rechercher = false;
            }
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

    private void jComboBoxAnneeMinItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxAnneeMinItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == 1) {
            String anneeString = evt.getItem().toString();
            if (anneeString != null && !anneeString.isEmpty()) {
                anneeMin = Integer.valueOf(anneeString);
            }
        } else {
            anneeMin = null;
        }
    }//GEN-LAST:event_jComboBoxAnneeMinItemStateChanged

    private void jComboBoxAnneeMaxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxAnneeMaxItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == 1) {
            String anneeString = evt.getItem().toString();
            if (anneeString != null && !anneeString.isEmpty()) {
                anneeMax = Integer.valueOf(anneeString);
            }
        } else {
            anneeMax = null;
        }
    }//GEN-LAST:event_jComboBoxAnneeMaxItemStateChanged

    private void jRadioButtonMoisDernierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMoisDernierActionPerformed
        // TODO add your handling code here:
        initTableCapteur();
        table.setModel(defaultTableModel);
        actionRadioButon();
    }//GEN-LAST:event_jRadioButtonMoisDernierActionPerformed

    private void jRadioButtonIntervalAnneeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonIntervalAnneeActionPerformed
        // TODO add your handling code here:
        initTableCapteurAnnee();
        table.setModel(defaultTableModelAnnee);
        actionRadioButon();
    }//GEN-LAST:event_jRadioButtonIntervalAnneeActionPerformed

    private void jRadioButtonMoisAnneeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMoisAnneeActionPerformed
        // TODO add your handling code here:
        initTableCapteur();
        table.setModel(defaultTableModel);
        actionRadioButon();
    }//GEN-LAST:event_jRadioButtonMoisAnneeActionPerformed

    private void jRadioButtonTousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTousActionPerformed
        // TODO add your handling code here:
        initTableCapteur();
        table.setModel(defaultTableModel);
        actionRadioButon();
    }//GEN-LAST:event_jRadioButtonTousActionPerformed

    private void actionRadioButon() {
        jComboBoxAnneeMin.setSelectedItem("");
        jComboBoxAnneeMax.setSelectedItem("");
        jComboBoxAnnee.setSelectedItem("");
        jComboBoxMois.setSelectedItem("");
        jComboBoxLocal.setSelectedItem("");
        jComboBoxAnneeMin.setEnabled(false);
        jComboBoxAnneeMax.setEnabled(false);
        jComboBoxMois.setEnabled(false);
        jComboBoxAnnee.setEnabled(false);
        jComboBoxLocal.setEnabled(false);
        isDernierMois = jRadioButtonMoisDernier.isSelected();
        isMoisAnnee = jRadioButtonMoisAnnee.isSelected();
        isIntervalAnnee = jRadioButtonIntervalAnnee.isSelected();
        isAll = jRadioButtonTous.isSelected();

        removeAllTableCapteur();

        if (capteurList != null) {
            capteurList.clear();
        }
        if (capteurAnneeList != null) {
            capteurAnneeList.clear();
        }
        if (isDernierMois || isAll) {
            jComboBoxLocal.setEnabled(true);

        }
        if (isMoisAnnee) {
            jComboBoxMois.setEnabled(true);
            jComboBoxAnnee.setEnabled(true);
            jComboBoxLocal.setEnabled(true);
        }
        if (isIntervalAnnee) {
            jComboBoxAnneeMin.setEnabled(true);
            jComboBoxAnneeMax.setEnabled(true);
        }

    }

    private void closeCapteurFrame() {
        this.dispose();
    }

    public void refrechCapteur() {
        if (capteurList != null) {
            capteurList.clear();
        }
        if (capteurAnneeList != null) {
            capteurAnneeList.clear();
        }
        
        rechercher();
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

    private void removeAllTableCapteurAnnee() {
        for (int i = defaultTableModelAnnee.getRowCount() - 1; i >= 0; --i) {
            defaultTableModelAnnee.removeRow(i);
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
        for (int i = 2000; i <= anneeCourante; i++) {
            item.add("" + i);
        }
        comboBoxModelAnnee = new DefaultComboBoxModel(item);
    }

    private void initComboBoxAnneeMin() {
        Vector<String> item = new Vector<>();
        item.add("");
        Calendar calendar = Calendar.getInstance();
        int anneeCourante = calendar.get(Calendar.YEAR);
        for (int i = 2000; i <= anneeCourante; i++) {
            item.add("" + i);
        }
        comboBoxModelAnneeMin = new DefaultComboBoxModel(item);
    }

    private void initComboBoxAnneeMax() {
        Vector<String> item = new Vector<>();
        item.add("");
        Calendar calendar = Calendar.getInstance();
        int anneeCourante = calendar.get(Calendar.YEAR);
        for (int i = 2000; i <= anneeCourante; i++) {
            item.add("" + i);
        }
        comboBoxModelAnneeMax = new DefaultComboBoxModel(item);
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
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton buttonModifier;
    private javax.swing.JButton buttonNouveau;
    private javax.swing.JButton buttonSupprimer;
    private javax.swing.JButton jButtonRechercher;
    private javax.swing.JComboBox<String> jComboBoxAnnee;
    private javax.swing.JComboBox<String> jComboBoxAnneeMax;
    private javax.swing.JComboBox<String> jComboBoxAnneeMin;
    private javax.swing.JComboBox<String> jComboBoxLocal;
    private javax.swing.JComboBox<String> jComboBoxMois;
    private javax.swing.JLabel jLabelAnnee;
    private javax.swing.JLabel jLabelAnneeMax;
    private javax.swing.JLabel jLabelAnneeMin;
    private javax.swing.JLabel jLabelLocal;
    private javax.swing.JLabel jLabelMois;
    private javax.swing.JLabel jLabelMsg;
    private javax.swing.JLabel jLabelNbreCapteur;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRadioButtonIntervalAnnee;
    private javax.swing.JRadioButton jRadioButtonMoisAnnee;
    private javax.swing.JRadioButton jRadioButtonMoisDernier;
    private javax.swing.JRadioButton jRadioButtonTous;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTextField jTextFieldCapteur;
    private javax.swing.JPanel panelBouton;
    private javax.swing.JPanel panelNbreTotal;
    private javax.swing.JPanel panelRechercher;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
