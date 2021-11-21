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
public class Mobilier {

    private final static Logger logger = Logger.getLogger(Mobilier.class);

    public Mobilier() {
    }

    public String add(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "INSERT INTO public.mobilier(type_mobilier, lib, code, id_local) VALUES('" + (String) dataLoading.get("type_mobilier") + "', '" + (String) dataLoading.get("lib") + "', '" + (String) dataLoading.get("code") + "', " + (Integer) dataLoading.get("id_local") + ");";
        logger.info("req---" + req);
        int i = connection.createStatement().executeUpdate(req);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", "Opération réussite, nombre ajouter = " + i);
        return mapper.writeValueAsString(response);
    }

    public String edit(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "UPDATE public.mobilier SET code ='" + (String) dataLoading.get("code") + "', lib='" + (String) dataLoading.get("lib") + "', type_mobilier='" + (String) dataLoading.get("type_mobilier") + "', id_local=" + (Integer) dataLoading.get("id_local") + " WHERE id=" + (Integer) dataLoading.get("id") + ";";
        logger.info("req---" + req);
        int i = connection.createStatement().executeUpdate(req);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", "Opération réussite, nombre modifier = " + i);
        return mapper.writeValueAsString(response);
    }

    public String delete(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        int i = connection.createStatement().executeUpdate("DELETE FROM public.mobilier WHERE id=" + (Integer) dataLoading.get("id") + ";");

        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", "Opération réussite, nombre supprimer = " + i);
        return mapper.writeValueAsString(response);
    }

    public String findAll(Connection connection, String requestName) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "SELECT c.id AS id, c.code AS code, type_mobilier, c.lib, id_local, l.numero AS numero, l.etage As etage, l.batiment AS batiment, e.id AS id_enterprise FROM public.mobilier AS c INNER JOIN public.local AS l ON c.id_local = l.id INNER JOIN public.enterprise AS e ON l.id_enterprise = e.id ;";
        ResultSet rs = connection.createStatement().executeQuery(req);
        List<Map> enterprises = new ArrayList<Map>();
        while (rs.next()) {
            Map<String, Object> hm = new HashMap<String, Object>();
            hm.put("id", rs.getInt("id"));
            hm.put("code", rs.getString("code"));
            hm.put("type_mobilier", rs.getString("type_mobilier"));
            hm.put("lib", rs.getString("lib"));
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
        String req = "SELECT c.id AS id, c.code AS code, type_mobilier, c.lib, id_local, l.numero AS numero, l.etage As etage, l.batiment AS batiment, e.id AS id_enterprise FROM public.mobilier AS c INNER JOIN public.local AS l ON c.id_local = l.id INNER JOIN public.enterprise AS e ON l.id_enterprise = e.id WHERE  e.id=" + (Integer) dataLoading.get("id_enterprise") + ";";
        logger.info("req---" + req);
        ResultSet rs = connection.createStatement().executeQuery(req);
        List<Map> enterprises = new ArrayList<Map>();
        while (rs.next()) {
            Map<String, Object> hm = new HashMap<String, Object>();
            hm.put("id", rs.getInt("id"));
            hm.put("code", rs.getString("code"));
            hm.put("type_mobilier", rs.getString("type_mobilier"));
            hm.put("lib", rs.getString("lib"));
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
        ResultSet rs = connection.createStatement().executeQuery("SELECT id, type_mobilier, lib, id_local, code FROM public.mobilier WHERE id=" + (Integer) dataLoading.get("id") + ";");

        Map<String, Object> hm = new HashMap<String, Object>();
        hm.put("id", rs.getInt("id"));
        hm.put("code", rs.getString("code"));
        hm.put("type_mobilier", rs.getString("type_mobilier"));
        hm.put("lib", rs.getString("lib"));
        hm.put("id_local", rs.getInt("id_local"));
        rs.close();
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", hm);
        return mapper.writeValueAsString(response);
    }
        
    public String countAll(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "SELECT COUNT(id) AS nbre FROM public.mobilier;";
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
        String req = "SELECT COUNT(id) AS nbre FROM public.mobilier WHERE id=" + (Integer) dataLoading.get("id") + ";";
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
