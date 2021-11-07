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
public class Enterprise {

    private final static Logger logger = Logger.getLogger(Enterprise.class);

    public Enterprise() {
    }

    public String add(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "INSERT INTO public.enterprise(code, lib, adresse, code_postal, pays) VALUES('" + (String) dataLoading.get("code") + "', '" + (String) dataLoading.get("lib") + "', '" + (String) dataLoading.get("adresse") + "', '" + (String) dataLoading.get("code_postal") + "', '" + (String) dataLoading.get("pays") + "');";
        logger.info("req---" + req);
        int i = connection.createStatement().executeUpdate(req);
        logger.info("reponse insert----" + i);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", "Opération réussite, nombre ajouter = " + i);
        return mapper.writeValueAsString(response);
    }

    public String edit(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "UPDATE public.enterprise SET code ='" + (String) dataLoading.get("code") + "', lib='" + (String) dataLoading.get("lib") + "', adresse='" + (String) dataLoading.get("adresse") + "', code_postal='" + (String) dataLoading.get("code_postal") + "', pays='" + (String) dataLoading.get("pays") + "' WHERE id=" + (Integer) dataLoading.get("id") + ";";
        logger.info("req---" + req);
        int i = connection.createStatement().executeUpdate(req);
        logger.info("reponse insert----" + i);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", "Opération réussite, nombre modifier = " + i);
        return mapper.writeValueAsString(response);
    }

    public String delete(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        int i = connection.createStatement().executeUpdate("DELETE FROM public.enterprise WHERE id=" + (Integer) dataLoading.get("id") + ";");

        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", "Opération réussite, nombre supprimer = " + i);
        return mapper.writeValueAsString(response);
    }

    public String findAll(Connection connection, String requestName) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        ResultSet rs = connection.createStatement().executeQuery("SELECT id, code, lib, adresse, code_postal, pays, (SELECT COUNT (b1.id) FROM public.local b1 INNER JOIN public.enterprise e1 ON e1.id = b1.id_enterprise WHERE e1.id =e.id ) AS nbre_local , (SELECT COUNT (a1.id) FROM public.capteur a1 INNER JOIN public.local b1 ON b1.id = a1.id_local INNER JOIN public.enterprise e1 ON e1.id = b1.id_enterprise WHERE e1.id =e.id ) AS nbre_capteur, (SELECT COUNT (a1.id) FROM public.mobilier a1 INNER JOIN public.local b1 ON b1.id = a1.id_local INNER JOIN public.enterprise e1 ON e1.id = b1.id_enterprise WHERE e1.id =e.id ) AS nbre_mobilier, (SELECT COUNT (a1.id) FROM public.materiel a1 INNER JOIN public.local b1 ON b1.id = a1.id_local INNER JOIN public.enterprise e1 ON e1.id = b1.id_enterprise WHERE e1.id =e.id ) AS nbre_materiel FROM public.enterprise e;");
        List<Map> enterprises = new ArrayList<Map>();
        while (rs.next()) {
            Map<String, Object> hm = new HashMap<String, Object>();
            hm.put("id", rs.getInt("id"));
            hm.put("code", rs.getString("code"));
            hm.put("lib", rs.getString("lib"));
            hm.put("adresse", rs.getString("adresse"));
            hm.put("code_postal", rs.getString("code_postal"));
            hm.put("nbre_local", rs.getString("nbre_local"));
            hm.put("nbre_capteur", rs.getString("nbre_capteur"));
            hm.put("nbre_materiel", rs.getString("nbre_materiel"));
            hm.put("nbre_mobilier", rs.getString("nbre_mobilier"));
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
        ResultSet rs = connection.createStatement().executeQuery("SELECT id, code, lib, adresse, code_postal, pays, (SELECT COUNT (b1.id) FROM public.local b1 INNER JOIN public.enterprise e1 ON e1.id = b1.id_enterprise WHERE e1.id =e.id ) AS nbre_local , (SELECT COUNT (a1.id) FROM public.capteur a1 INNER JOIN public.local b1 ON b1.id = a1.id_local INNER JOIN public.enterprise e1 ON e1.id = b1.id_enterprise WHERE e1.id =e.id ) AS nbre_capteur, (SELECT COUNT (a1.id) FROM public.mobilier a1 INNER JOIN public.local b1 ON b1.id = a1.id_local INNER JOIN public.enterprise e1 ON e1.id = b1.id_enterprise WHERE e1.id =e.id ) AS nbre_mobilier, (SELECT COUNT (a1.id) FROM public.materiel a1 INNER JOIN public.local b1 ON b1.id = a1.id_local INNER JOIN public.enterprise e1 ON e1.id = b1.id_enterprise WHERE e1.id =e.id ) AS nbre_materiel FROM public.enterprise e WHERE id=" + (Integer) dataLoading.get("id")+";");
        
        Map<String, Object> hm = new HashMap<String, Object>();
        hm.put("id", rs.getInt("id"));
        hm.put("lib", rs.getString("lib"));
        hm.put("adresse", rs.getString("adresse"));
        hm.put("code_postal", rs.getString("code_postal"));
        hm.put("pays", rs.getString("pays"));
        hm.put("nbre_local", rs.getString("nbre_local"));
        hm.put("nbre_capteur", rs.getString("nbre_capteur"));
        hm.put("nbre_materiel", rs.getString("nbre_materiel"));
        hm.put("nbre_mobilier", rs.getString("nbre_mobilier"));
        rs.close();
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", hm);
        return mapper.writeValueAsString(response);
    }
}
