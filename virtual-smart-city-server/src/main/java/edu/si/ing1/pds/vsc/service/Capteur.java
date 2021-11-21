package edu.si.ing1.pds.vsc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 *
 * @author Ines
 */
public class Capteur {

    private final static Logger logger = Logger.getLogger(Capteur.class);

    public Capteur() {
    }

    public String add(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "INSERT INTO public.capteur(date_capteur, type_capteur, valeur_capteur, code, id_local) VALUES('" + (String) dataLoading.get("date_capteur") + "', '" + (String) dataLoading.get("type_capteur") + "', '" + (Double) dataLoading.get("valeur_capteur") + "', '" + (String) dataLoading.get("code") + "', " + (Integer) dataLoading.get("id_local") + ");";
        logger.info("req---" + req);
        int i = connection.createStatement().executeUpdate(req);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", "Opération réussite, nombre ajouter = " + i);
        return mapper.writeValueAsString(response);
    }

    public String edit(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "UPDATE public.capteur SET date_capteur ='" + (String) dataLoading.get("date_capteur") + "', code ='" + (String) dataLoading.get("code") + "', valeur_capteur=" + (Double) dataLoading.get("valeur_capteur") + ", type_capteur='" + (String) dataLoading.get("type_capteur") + "', id_local=" + (Integer) dataLoading.get("id_local") + " WHERE id=" + (Integer) dataLoading.get("id") + ";";
        logger.info("req---" + req);
        int i = connection.createStatement().executeUpdate(req);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", "Opération réussite, nombre modifier = " + i);
        return mapper.writeValueAsString(response);
    }

    public String delete(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        int i = connection.createStatement().executeUpdate("DELETE FROM public.capteur WHERE id=" + (Integer) dataLoading.get("id") + ";");

        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", "Opération réussite, nombre supprimer = " + i);
        return mapper.writeValueAsString(response);
    }

    public String findAll(Connection connection, String requestName) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "SELECT c.id AS id, date_capteur, c.code AS code, type_capteur, valeur_capteur, id_local, l.numero AS numero, l.etage As etage, l.batiment AS batiment, e.id AS id_enterprise FROM public.capteur AS c INNER JOIN public.local AS l ON c.id_local = l.id INNER JOIN public.enterprise AS e ON l.id_enterprise = e.id ORDER BY date_capteur ASC;";
        ResultSet rs = connection.createStatement().executeQuery(req);
        List<Map> enterprises = new ArrayList<Map>();
        while (rs.next()) {
            Map<String, Object> hm = new HashMap<String, Object>();
            hm.put("id", rs.getInt("id"));
            hm.put("date_capteur", rs.getString("date_capteur"));
            hm.put("code", rs.getString("code"));
            hm.put("type_capteur", rs.getString("type_capteur"));
            hm.put("valeur_capteur", rs.getDouble("valeur_capteur"));
            hm.put("batiment", rs.getString("batiment"));
            hm.put("etage", rs.getString("etage"));
            hm.put("numero", rs.getString("numero"));
            hm.put("id_local", rs.getInt("id_local"));
            hm.put("id_enterprise", rs.getInt("id_enterprise"));
            enterprises.add(hm);
        }
        rs.close();
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", enterprises);
        return mapper.writeValueAsString(response);
    }

    public String findByIdEnterprise(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "SELECT c.id AS id, date_capteur, c.code AS code, type_capteur, valeur_capteur, id_local, l.numero AS numero, l.etage As etage, l.batiment AS batiment, e.id AS id_enterprise FROM public.capteur AS c INNER JOIN public.local AS l ON c.id_local = l.id INNER JOIN public.enterprise AS e ON l.id_enterprise = e.id WHERE  e.id=" + (Integer) dataLoading.get("id_enterprise") + " ORDER BY date_capteur ASC;";
        logger.info("req---" + req);
        ResultSet rs = connection.createStatement().executeQuery(req);
        List<Map> enterprises = new ArrayList<Map>();
        while (rs.next()) {
            Map<String, Object> hm = new HashMap<String, Object>();
            hm.put("id", rs.getInt("id"));
            hm.put("date_capteur", rs.getString("date_capteur"));
            hm.put("code", rs.getString("code"));
            hm.put("type_capteur", rs.getString("type_capteur"));
            hm.put("valeur_capteur", rs.getDouble("valeur_capteur"));
            hm.put("batiment", rs.getString("batiment"));
            hm.put("etage", rs.getString("etage"));
            hm.put("numero", rs.getString("numero"));
            hm.put("id_local", rs.getInt("id_local"));
            hm.put("id_enterprise", rs.getInt("id_enterprise"));
            enterprises.add(hm);
        }
        rs.close();
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", enterprises);
        return mapper.writeValueAsString(response);
    }

    public String findByIdEnterpriseIdLocal(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "SELECT c.id AS id, date_capteur, c.code AS code, type_capteur, valeur_capteur, id_local, l.numero AS numero, l.etage As etage, l.batiment AS batiment, e.id AS id_enterprise FROM public.capteur AS c INNER JOIN public.local AS l ON c.id_local = l.id INNER JOIN public.enterprise AS e ON l.id_enterprise = e.id WHERE l.id= " + (Integer) dataLoading.get("id_local") + " AND e.id=" + (Integer) dataLoading.get("id_enterprise") + " ORDER BY date_capteur ASC;";
        logger.info("req---" + req);
        ResultSet rs = connection.createStatement().executeQuery(req);
        List<Map> enterprises = new ArrayList<Map>();
        while (rs.next()) {
            Map<String, Object> hm = new HashMap<String, Object>();
            hm.put("id", rs.getInt("id"));
            hm.put("date_capteur", rs.getString("date_capteur"));
            hm.put("code", rs.getString("code"));
            hm.put("type_capteur", rs.getString("type_capteur"));
            hm.put("valeur_capteur", rs.getDouble("valeur_capteur"));
            hm.put("batiment", rs.getString("batiment"));
            hm.put("etage", rs.getString("etage"));
            hm.put("numero", rs.getString("numero"));
            hm.put("id_local", rs.getInt("id_local"));
            hm.put("id_enterprise", rs.getInt("id_enterprise"));
            enterprises.add(hm);
        }
        rs.close();
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", enterprises);
        return mapper.writeValueAsString(response);
    }

    public String findByIdEnterpriseIdLocalMoisAnnee(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "SELECT c.id AS id, date_capteur, c.code AS code, type_capteur, valeur_capteur, id_local, l.numero AS numero, l.etage As etage, l.batiment AS batiment, e.id AS id_enterprise FROM public.capteur AS c INNER JOIN public.local AS l ON c.id_local = l.id INNER JOIN public.enterprise AS e ON l.id_enterprise = e.id WHERE date_part('month'::text, date_capteur) =" + (Integer) dataLoading.get("mois") + " AND date_part('year'::text, date_capteur) =" + (Integer) dataLoading.get("annee") + " AND l.id= " + (Integer) dataLoading.get("id_local") + " AND e.id=" + (Integer) dataLoading.get("id_enterprise") + " ORDER BY date_capteur ASC;";
        logger.info("req---" + req);
        ResultSet rs = connection.createStatement().executeQuery(req);
        List<Map> enterprises = new ArrayList<Map>();
        while (rs.next()) {
            Map<String, Object> hm = new HashMap<String, Object>();
            hm.put("id", rs.getInt("id"));
            hm.put("date_capteur", rs.getString("date_capteur"));
            hm.put("code", rs.getString("code"));
            hm.put("type_capteur", rs.getString("type_capteur"));
            hm.put("valeur_capteur", rs.getDouble("valeur_capteur"));
            hm.put("batiment", rs.getString("batiment"));
            hm.put("etage", rs.getString("etage"));
            hm.put("numero", rs.getString("numero"));
            hm.put("id_local", rs.getInt("id_local"));
            hm.put("id_enterprise", rs.getInt("id_enterprise"));
            enterprises.add(hm);
        }
        rs.close();
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", enterprises);
        return mapper.writeValueAsString(response);
    }

    public String findByIdEnterpriseMoisAnnee(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "SELECT c.id AS id, date_capteur, c.code AS code, type_capteur, valeur_capteur, id_local, l.numero AS numero, l.etage As etage, l.batiment AS batiment, e.id AS id_enterprise FROM public.capteur AS c INNER JOIN public.local AS l ON c.id_local = l.id INNER JOIN public.enterprise AS e ON l.id_enterprise = e.id WHERE date_part('month'::text, date_capteur) =" + (Integer) dataLoading.get("mois") + " AND date_part('year'::text, date_capteur) =" + (Integer) dataLoading.get("annee") + " AND e.id=" + (Integer) dataLoading.get("id_enterprise") + " ORDER BY date_capteur ASC;";
        logger.info("req---" + req);
        ResultSet rs = connection.createStatement().executeQuery(req);
        List<Map> enterprises = new ArrayList<Map>();
        while (rs.next()) {
            Map<String, Object> hm = new HashMap<String, Object>();
            hm.put("id", rs.getInt("id"));
            hm.put("date_capteur", rs.getString("date_capteur"));
            hm.put("code", rs.getString("code"));
            hm.put("type_capteur", rs.getString("type_capteur"));
            hm.put("valeur_capteur", rs.getDouble("valeur_capteur"));
            hm.put("batiment", rs.getString("batiment"));
            hm.put("etage", rs.getString("etage"));
            hm.put("numero", rs.getString("numero"));
            hm.put("id_local", rs.getInt("id_local"));
            hm.put("id_enterprise", rs.getInt("id_enterprise"));
            enterprises.add(hm);
        }
        rs.close();
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", enterprises);
        return mapper.writeValueAsString(response);
    }

    public String findByIdEnterpriseIdLocalAnnee(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "SELECT c.id AS id, date_capteur, c.code AS code, type_capteur, valeur_capteur, id_local, l.numero AS numero, l.etage As etage, l.batiment AS batiment, e.id AS id_enterprise FROM public.capteur AS c INNER JOIN public.local AS l ON c.id_local = l.id INNER JOIN public.enterprise AS e ON l.id_enterprise = e.id WHERE date_part('year'::text, date_capteur) =" + (Integer) dataLoading.get("annee") + " AND l.id= " + (Integer) dataLoading.get("id_local") + " AND e.id=" + (Integer) dataLoading.get("id_enterprise") + " ORDER BY date_capteur ASC;";
        logger.info("req---" + req);
        ResultSet rs = connection.createStatement().executeQuery(req);
        List<Map> enterprises = new ArrayList<Map>();
        while (rs.next()) {
            Map<String, Object> hm = new HashMap<String, Object>();
            hm.put("id", rs.getInt("id"));
            hm.put("date_capteur", rs.getString("date_capteur"));
            hm.put("code", rs.getString("code"));
            hm.put("type_capteur", rs.getString("type_capteur"));
            hm.put("valeur_capteur", rs.getDouble("valeur_capteur"));
            hm.put("batiment", rs.getString("batiment"));
            hm.put("etage", rs.getString("etage"));
            hm.put("numero", rs.getString("numero"));
            hm.put("id_local", rs.getInt("id_local"));
            hm.put("id_enterprise", rs.getInt("id_enterprise"));
            enterprises.add(hm);
        }
        rs.close();
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", enterprises);
        return mapper.writeValueAsString(response);
    }

    public String findByIdEnterpriseAnnee(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "SELECT c.id AS id, date_capteur, c.code AS code, type_capteur, valeur_capteur, id_local, l.numero AS numero, l.etage As etage, l.batiment AS batiment, e.id AS id_enterprise FROM public.capteur AS c INNER JOIN public.local AS l ON c.id_local = l.id INNER JOIN public.enterprise AS e ON l.id_enterprise = e.id WHERE date_part('year'::text, date_capteur) =" + (Integer) dataLoading.get("annee") + " AND e.id=" + (Integer) dataLoading.get("id_enterprise") + " ORDER BY date_capteur ASC;";
        logger.info("req---" + req);
        ResultSet rs = connection.createStatement().executeQuery(req);
        List<Map> enterprises = new ArrayList<Map>();
        while (rs.next()) {
            Map<String, Object> hm = new HashMap<String, Object>();
            hm.put("id", rs.getInt("id"));
            hm.put("date_capteur", rs.getString("date_capteur"));
            hm.put("code", rs.getString("code"));
            hm.put("type_capteur", rs.getString("type_capteur"));
            hm.put("valeur_capteur", rs.getDouble("valeur_capteur"));
            hm.put("batiment", rs.getString("batiment"));
            hm.put("etage", rs.getString("etage"));
            hm.put("numero", rs.getString("numero"));
            hm.put("id_local", rs.getInt("id_local"));
            hm.put("id_enterprise", rs.getInt("id_enterprise"));
            enterprises.add(hm);
        }
        rs.close();
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", enterprises);
        return mapper.writeValueAsString(response);
    }

    public String findByIdEnterpriseIntervalAnnee(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "SELECT l.id_enterprise AS id_enterprise, date_part('year'::text, c.date_capteur) AS annee, COUNT(c.id) AS nbre FROM public.capteur AS c INNER JOIN public.local AS l ON l.id = c.id_local WHERE date_part('year'::text, date_capteur) >= " + (Integer) dataLoading.get("annee_min") + " AND date_part('year'::text, date_capteur) <= " + (Integer) dataLoading.get("annee_max") + " AND l.id_enterprise = " + (Integer) dataLoading.get("id_enterprise") + " GROUP BY 1 ,2 ORDER BY 2 ASC;";
        logger.info("req---" + req);
        ResultSet rs = connection.createStatement().executeQuery(req);
        List<Map> enterprises = new ArrayList<Map>();
        while (rs.next()) {
            Map<String, Object> hm = new HashMap<String, Object>();
            hm.put("id_enterprise", rs.getInt("id_enterprise"));
            hm.put("annee", rs.getInt("annee"));
            hm.put("nbre", rs.getDouble("nbre"));
            enterprises.add(hm);
        }
        rs.close();
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", enterprises);
        return mapper.writeValueAsString(response);
    }

    public String findByIdEnterpriseIdLocalDate(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "SELECT c.id AS id, date_capteur, c.code AS code, type_capteur, valeur_capteur, id_local, l.numero AS numero, l.etage As etage, l.batiment AS batiment, e.id AS id_enterprise FROM public.capteur AS c INNER JOIN public.local AS l ON c.id_local = l.id INNER JOIN public.enterprise AS e ON l.id_enterprise = e.id WHERE date_capteur BETWEEN '" + (String) dataLoading.get("date_debut") + "' AND '" + (String) dataLoading.get("date_fin") + "' AND l.id= " + (Integer) dataLoading.get("id_local") + " AND e.id=" + (Integer) dataLoading.get("id_enterprise") + " ORDER BY date_capteur ASC;";
        logger.info("req---" + req);
        ResultSet rs = connection.createStatement().executeQuery(req);
        List<Map> enterprises = new ArrayList<Map>();
        while (rs.next()) {
            Map<String, Object> hm = new HashMap<String, Object>();
            hm.put("id", rs.getInt("id"));
            hm.put("date_capteur", rs.getString("date_capteur"));
            hm.put("code", rs.getString("code"));
            hm.put("type_capteur", rs.getString("type_capteur"));
            hm.put("valeur_capteur", rs.getDouble("valeur_capteur"));
            hm.put("batiment", rs.getString("batiment"));
            hm.put("etage", rs.getString("etage"));
            hm.put("numero", rs.getString("numero"));
            hm.put("id_local", rs.getInt("id_local"));
            hm.put("id_enterprise", rs.getInt("id_enterprise"));
            enterprises.add(hm);
        }
        rs.close();
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", enterprises);
        return mapper.writeValueAsString(response);
    }

    public String findByIdEnterpriseDate(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "SELECT c.id AS id, date_capteur, c.code AS code, type_capteur, valeur_capteur, id_local, l.numero AS numero, l.etage As etage, l.batiment AS batiment, e.id AS id_enterprise FROM public.capteur AS c INNER JOIN public.local AS l ON c.id_local = l.id INNER JOIN public.enterprise AS e ON l.id_enterprise = e.id WHERE date_capteur BETWEEN '" + (String) dataLoading.get("date_debut") + "' AND '" + (String) dataLoading.get("date_fin") + "' AND e.id=" + (Integer) dataLoading.get("id_enterprise") + " ORDER BY date_capteur ASC;";
        logger.info("req---" + req);
        ResultSet rs = connection.createStatement().executeQuery(req);
        List<Map> enterprises = new ArrayList<Map>();
        while (rs.next()) {
            Map<String, Object> hm = new HashMap<String, Object>();
            hm.put("id", rs.getInt("id"));
            hm.put("date_capteur", rs.getString("date_capteur"));
            hm.put("code", rs.getString("code"));
            hm.put("type_capteur", rs.getString("type_capteur"));
            hm.put("valeur_capteur", rs.getDouble("valeur_capteur"));
            hm.put("batiment", rs.getString("batiment"));
            hm.put("etage", rs.getString("etage"));
            hm.put("numero", rs.getString("numero"));
            hm.put("id_local", rs.getInt("id_local"));
            hm.put("id_enterprise", rs.getInt("id_enterprise"));
            enterprises.add(hm);
        }
        rs.close();
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", enterprises);
        return mapper.writeValueAsString(response);
    }

    public String findById(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "SELECT id, date_capteur, type_capteur, valeur_capteur, id_local, code FROM public.capteur WHERE id=" + (Integer) dataLoading.get("id") + ";";
        logger.info("req---" + req);
        ResultSet rs = connection.createStatement().executeQuery(req);

        Map<String, Object> hm = new HashMap<String, Object>();
        hm.put("id", rs.getInt("id"));
        hm.put("date_capteur", rs.getString("date_capteur"));
        hm.put("code", rs.getString("code"));
        hm.put("type_capteur", rs.getString("type_capteur"));
        hm.put("valeur_capteur", rs.getDouble("valeur_capteur"));
        hm.put("id_local", rs.getInt("id_local"));
        rs.close();
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", hm);
        return mapper.writeValueAsString(response);
    }

    public String countAll(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "SELECT COUNT(id) AS nbre FROM public.capteur;";
        logger.info("req---" + req);
        ResultSet rs = connection.createStatement().executeQuery(req);
        rs.next();
        Map<String, Object> hm = new HashMap<String, Object>();

        hm.put("nbre", rs.getInt(1));
        rs.close();
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", hm);
        return mapper.writeValueAsString(response);
    }

    public String countByIdEnterprise(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "SELECT COUNT(id) AS nbre FROM public.capteur WHERE id=" + (Integer) dataLoading.get("id") + ";";
        logger.info("req---" + req);
        ResultSet rs = connection.createStatement().executeQuery(req);
        rs.next();
        Map<String, Object> hm = new HashMap<String, Object>();

        hm.put("nbre", rs.getInt(1));
        rs.close();
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", hm);
        return mapper.writeValueAsString(response);
    }
}
