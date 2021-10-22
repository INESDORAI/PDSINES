package edu.ing1.pds.vsc.client;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {

    private final static Logger logger = LoggerFactory.getLogger(Client.class.getName());

    public static void main(String[] args) throws Exception {
        // ConnectionServer con=new ConnectionServer();
        try {
            ClientToServer connection = new ClientToServer();
            logger.info("Serveur connecté");
            logger.info("Pour executer une requette choisez :");
            logger.info("1 pour Ajouter");
            logger.info("2 pour Modifier");
            logger.info("3 pour Supprimer");
            logger.info("4 pour Afficher");
            Scanner sc = new Scanner(System.in);
            int choix = sc.nextInt();
            CrudPersonne crudPersonne = new CrudPersonne();
            switch (choix) {
                case 1:
                    logger.info("Votre choix est ajouter");
                    logger.info("Id : ");
                    int idAdd = sc.nextInt();
                    logger.info("Nom : ");
                    String namePersonneAdd = sc.next();
                    logger.info("Age : ");
                    int agePersonneAdd = sc.nextInt();
                    String msgAdd = crudPersonne.insertPersonne(connection, idAdd, namePersonneAdd, agePersonneAdd);
                    logger.info(msgAdd);
                    logger.info("Opération effectuée avec succès.");
                    break;
                case 2:
                    logger.info("Votre choix est modifier");
                    logger.info("Id : ");
                    int idUpd = sc.nextInt();
                    logger.info("Nom : ");
                    String namePersonneUpd = sc.next();
                    logger.info("Age : ");
                    int agePersonneUpd = sc.nextInt();
                    String msgUpd = crudPersonne.updatePersonne(connection, idUpd, namePersonneUpd, agePersonneUpd);
                    logger.info(msgUpd);
                    logger.info("Opération effectuée avec succès.");
                    break;
                case 3:
                    logger.info("Votre choix est supprimer");
                    logger.info("Id : ");
                    int idDel = sc.nextInt();
                    String msgDel = crudPersonne.deletePersonne(connection, idDel);
                    logger.info(msgDel);
                    logger.info("Opération effectuée avec succès.");
                    break;
                case 4:
                    logger.info("Votre choix est afficher");
                    ArrayList<Map> personnes = crudPersonne.selectPersonne(connection);
                    logger.info("id_personne  |  name_personne  |  age_personne");
                    for (Map personne : personnes) {
                        logger.info(personne.get("id_personne")+"        |  "+personne.get("name_personne")+"  |  "+personne.get("age_personne"));
                    }
                    break;
                default:
                    logger.info("Choix incorrect");
                    break;
            }

            logger.info("Fin de requette.");
        } catch (Exception e) {

            logger.info("erro from the side of the client");
        }

    }

    private static void Switch(String operation_name_i) {
        // TODO Auto-generated method stub

    }

}
