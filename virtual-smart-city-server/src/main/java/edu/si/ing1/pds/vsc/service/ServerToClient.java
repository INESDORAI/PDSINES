package edu.si.ing1.pds.vsc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.sql.Connection;
import java.util.Map;
import edu.si.ing1.pds.vsc.connectionPool.ConnectionDB;
import edu.si.ing1.pds.vsc.connectionPool.DataSource;
import edu.si.ing1.pds.vsc.connectionPool.Request;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class ServerToClient {

    private final static Logger logger = Logger.getLogger(ServerToClient.class);

    private DataSource dataSource;
    private Personne personne = new Personne();
    private Enterprise enterprise = new Enterprise();
    private Capteur capteur = new Capteur();
    private Local local = new Local();
    private Mobilier mobilier = new Mobilier();
    private Materiel materiel = new Materiel();
    private ConsommationMateriel consommationMateriel = new ConsommationMateriel();

    public String sendResponse(Request request) {
        ConnectionDB con = dataSource.takeCon();
        Connection connection = con.connection;
        String requestName = request.getNameRequest();
        Map data = (Map) request.getData();
        String responseString = "";
        logger.info("requestName---" + requestName);
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
                case "count_local_all_enterprise":
                    responseString = local.countAll(connection, requestName, data);
                    break;
                case "count_local_by_id_enterprise":
                    responseString = local.countByIdEnterprise(connection, requestName, data);
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
                case "select_capteur_by_id_enterprise_id_local":
                    responseString = capteur.findByIdEnterpriseIdLocal(connection, requestName, data);
                    break;
                case "select_capteur_by_id_enterprise_id_local_mois_annee":
                    responseString = capteur.findByIdEnterpriseIdLocalMoisAnnee(connection, requestName, data);
                    break;
                case "select_capteur_by_id_enterprise_mois_annee":
                    responseString = capteur.findByIdEnterpriseMoisAnnee(connection, requestName, data);
                    break;
                case "select_capteur_by_id_enterprise_id_local_annee":
                    responseString = capteur.findByIdEnterpriseIdLocalAnnee(connection, requestName, data);
                    break;
                case "select_capteur_by_id_enterprise_annee":
                    responseString = capteur.findByIdEnterpriseAnnee(connection, requestName, data);
                    break;
                case "select_capteur_by_id_enterprise_interval_annee":
                    responseString = capteur.findByIdEnterpriseIntervalAnnee(connection, requestName, data);
                    break;
                case "select_capteur_by_id_enterprise_id_local_date":
                    responseString = capteur.findByIdEnterpriseIdLocalDate(connection, requestName, data);
                    break;
                case "select_capteur_by_id_enterprise_date":
                    responseString = capteur.findByIdEnterpriseDate(connection, requestName, data);
                    break;
                case "count_capteur_all_enterprise":
                    responseString = capteur.countAll(connection, requestName, data);
                    break;
                case "count_capteur_by_id_enterprise":
                    responseString = capteur.countByIdEnterprise(connection, requestName, data);
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
                case "count_mobilier_all_enterprise":
                    responseString = mobilier.countAll(connection, requestName, data);
                    break;
                case "count_mobilier_by_id_enterprise":
                    responseString = mobilier.countByIdEnterprise(connection, requestName, data);
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
                case "count_materiel_all_enterprise":
                    responseString = materiel.countAll(connection, requestName, data);
                    break;
                case "count_materiel_by_id_enterprise":
                    responseString = materiel.countByIdEnterprise(connection, requestName, data);
                    break;
                case "insert_consommation_materiel":
                    responseString = consommationMateriel.add(connection, requestName, data);
                    break;
                case "update_consommation_materiel":
                    responseString = consommationMateriel.edit(connection, requestName, data);
                    break;
                case "delete_consommation_materiel":
                    responseString = consommationMateriel.delete(connection, requestName, data);
                    break;
                case "select_consommation_materiel_id":
                    responseString = consommationMateriel.findById(connection, requestName, data);
                    break;
                case "select_consommation_materiel":
                    responseString = consommationMateriel.findAll(connection, requestName);
                    break;
                case "select_consommation_materiel_by_id_materiel":
                    responseString = consommationMateriel.findByIdMateriel(connection, requestName, data);
                    break;
                default:
                    break;
            }

            //End Coumba's part
            dataSource.returnCon(con);
            logger.info("response---" + responseString);
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
