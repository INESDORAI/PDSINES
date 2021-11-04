package edu.si.ing1.pds.vsc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.sql.Connection;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import edu.si.ing1.pds.vsc.connectionPool.ConnectionDB;
import edu.si.ing1.pds.vsc.connectionPool.DataSource;
import edu.si.ing1.pds.vsc.connectionPool.Request;
import java.sql.SQLException;

public class ServerToClient {

    private final static Logger logger = LoggerFactory.getLogger(ServerToClient.class.getName());
    private DataSource dataSource;
    private Personne personne = new Personne();
    private Enterprise enterprise = new Enterprise();
    private Capteur capteur = new Capteur();
    private Local local = new Local();
    private Mobilier mobilier = new Mobilier();
    private Materiel materiel = new Materiel();

    public String sendResponse(Request request) {
        ConnectionDB con = dataSource.takeCon();
        Connection connection = con.connection;
        String requestName = request.getNameRequest();
        Map data = (Map) request.getData();
        String responseString = "";
        System.out.println("requestName---" + requestName);
        try {
            switch (requestName) {
                case "insert_personne":
                    responseString = personne.add(connection, requestName, data);
                    break;
                case "update_personne":
                    responseString = personne.edit(connection, requestName, data);
                    break;
                case "delete_personne":
                    responseString = personne.delete(connection, requestName, data);
                    break;
                case "select_personne_id":
                    responseString = personne.findById(connection, requestName, data);
                    break;
                case "select_personne":
                    responseString = personne.findAll(connection, requestName);
                    break;
                case "insert_enterprise":
                    responseString = enterprise.add(connection, requestName, data);
                    break;
                case "update_enterprise":
                    responseString = enterprise.edit(connection, requestName, data);
                    break;
                case "delete_enterprise":
                    responseString = enterprise.delete(connection, requestName, data);
                    break;
                case "select_enterprise_id":
                    responseString = enterprise.findById(connection, requestName, data);
                    break;
                case "select_enterprise":
                    responseString = enterprise.findAll(connection, requestName);
                    break;
                case "insert_local":
                    responseString = local.add(connection, requestName, data);
                    break;
                case "update_local":
                    responseString = local.edit(connection, requestName, data);
                    break;
                case "delete_local":
                    responseString = local.delete(connection, requestName, data);
                    break;
                case "select_local_id":
                    responseString = local.findById(connection, requestName, data);
                    break;
                case "select_local":
                    responseString = local.findAll(connection, requestName);
                    break;
                case "select_local_by_id_enterprise":
                    responseString = local.findByIdEnterprise(connection, requestName, data);
                    break;
                case "insert_capteur":
                    responseString = capteur.add(connection, requestName, data);
                    break;
                case "update_capteur":
                    responseString = capteur.edit(connection, requestName, data);
                    break;
                case "delete_capteur":
                    responseString = capteur.delete(connection, requestName, data);
                    break;
                case "select_capteur_id":
                    responseString = capteur.findById(connection, requestName, data);
                    break;
                case "select_capteur":
                    responseString = capteur.findAll(connection, requestName);
                    break;
                case "select_capteur_by_id_enterprise":
                    responseString = capteur.findByIdEnterprise(connection, requestName, data);
                    break;
                case "insert_mobilier":
                    responseString = mobilier.add(connection, requestName, data);
                    break;
                case "update_mobilier":
                    responseString = mobilier.edit(connection, requestName, data);
                    break;
                case "delete_mobilier":
                    responseString = mobilier.delete(connection, requestName, data);
                    break;
                case "select_mobilier_id":
                    responseString = mobilier.findById(connection, requestName, data);
                    break;
                case "select_mobilier":
                    responseString = mobilier.findAll(connection, requestName);
                    break;
                case "select_mobilier_by_id_enterprise":
                    responseString = mobilier.findByIdEnterprise(connection, requestName, data);
                    break;
                case "insert_materiel":
                    responseString = materiel.add(connection, requestName, data);
                    break;
                case "update_materiel":
                    responseString = materiel.edit(connection, requestName, data);
                    break;
                case "delete_materiel":
                    responseString = materiel.delete(connection, requestName, data);
                    break;
                case "select_materiel_id":
                    responseString = materiel.findById(connection, requestName, data);
                    break;
                case "select_materiel":
                    responseString = materiel.findAll(connection, requestName);
                    break;
                case "select_materiel_by_id_enterprise":
                    responseString = materiel.findByIdEnterprise(connection, requestName, data);
                    break;
                default:
                    break;
            }

            //End Coumba's part
            dataSource.returnCon(con);
            System.out.println("response---" + responseString);
            return responseString;
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ServerToClient(DataSource ds) {
        try {
            dataSource = ds;
        } catch (Exception e) {
            logger.error("Erreur .....ServerToClient.....");
        }
    }
}