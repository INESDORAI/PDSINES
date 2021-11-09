package edu.ing1.pds.vsc.personne;

import edu.ing1.pds.vsc.client.ClientToServer;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Ines
 */
public class TestPersonne {

    private final static Logger logger = LoggerFactory.getLogger(TestPersonne.class.getName());

    public TestPersonne() {
        ClientToServer connection = new ClientToServer();
        try {

            System.out.println("Serveur connecté");
            System.out.println("Pour executer une requette choisez :");
            System.out.println("1 pour Ajouter");
            System.out.println("2 pour Modifier");
            System.out.println("3 pour Supprimer");
            System.out.println("4 pour Afficher");
            Scanner sc = new Scanner(System.in);
            int choix = sc.nextInt();
            CrudPersonne crudPersonne = new CrudPersonne();
            switch (choix) {
                case 1:
                    System.out.println("Votre choix est ajouter");
                    System.out.println("Id : ");
                    int idAdd = sc.nextInt();
                    System.out.println("Nom : ");
                    String namePersonneAdd = sc.next();
                    System.out.println("Age : ");
                    int agePersonneAdd = sc.nextInt();
                    String msgAdd = crudPersonne.insertPersonne(connection, idAdd, namePersonneAdd, agePersonneAdd);
                    System.out.println(msgAdd);
                    System.out.println("Opération effectuée avec succès.");
                    break;
                case 2:
                    System.out.println("Votre choix est modifier");
                    System.out.println("Id : ");
                    int idUpd = sc.nextInt();
                    System.out.println("Nom : ");
                    String namePersonneUpd = sc.next();
                    System.out.println("Age : ");
                    int agePersonneUpd = sc.nextInt();
                    String msgUpd = crudPersonne.updatePersonne(connection, idUpd, namePersonneUpd, agePersonneUpd);
                    System.out.println(msgUpd);
                    System.out.println("Opération effectuée avec succès.");
                    break;
                case 3:
                    System.out.println("Votre choix est supprimer");
                    System.out.println("Id : ");
                    int idDel = sc.nextInt();
                    String msgDel = crudPersonne.deletePersonne(connection, idDel);
                    System.out.println(msgDel);
                    System.out.println("Opération effectuée avec succès.");
                    break;
                case 4:
                    System.out.println("Votre choix est afficher");
                    ArrayList<Map> personnes = crudPersonne.selectPersonne(connection);
                    System.out.println("id_personne  |  name_personne  |  age_personne");
                    for (Map personne : personnes) {
                        System.out.println(personne.get("id_personne") + "        |  " + personne.get("name_personne") + "  |  " + personne.get("age_personne"));
                    }
                    break;
                default:
                    System.out.println("Choix incorrect");
                    break;
            }

            System.out.println("Fin de requette.");
        } catch (Exception e) {
            logger.error("error from the side of the client");
            e.printStackTrace();
        }
    }
}
