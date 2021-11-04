package edu.ing1.pds.vsc.client;

import edu.ing1.pds.vsc.fenetre.FenetrePricipale;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {

    private final static Logger logger = LoggerFactory.getLogger(Client.class.getName());

    public static void main(String[] args) throws Exception {
//        TestPersonne testPresonne = new TestPersonne();
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
        logger.info("Starting Election ---->" + formater.format(new Date()));
        UIManager.getDefaults().setDefaultLocale(new Locale("fr", "FR", ""));
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("defautBase", SystemColor.inactiveCaption);
            UIManager.put("defautBlueGrey", SystemColor.inactiveCaption);
            UIManager.put("defautControl", SystemColor.control);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERREUR Théme!!", JOptionPane.ERROR_MESSAGE);
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Locale.setDefault(new Locale("fr", "FR", ""));
                new FenetrePricipale().setVisible(true);
            }
        });
    }

}
