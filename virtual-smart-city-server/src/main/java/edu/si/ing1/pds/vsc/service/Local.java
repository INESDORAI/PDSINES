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
public class Local {

    private final static Logger logger = Logger.getLogger(Local.class);

    public Local() {
    }

    public String add(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "INSERT INTO public.local(lib, batiment, etage, numero, id_enterprise, nbre_place, nbre_place_occupe) VALUES('" + (String) dataLoading.get("lib") + "', '" + (String) dataLoading.get("batiment") + "', '" + (String) dataLoading.get("etage") + "', '" + (String) dataLoading.get("numero") + "', " + (Integer) dataLoading.get("id_enterprise") + ", " + (Integer) dataLoading.get("nbre_place") + ", " + (Integer) dataLoading.get("nbre_place_occupe") + ");";
        logger.info("req---" + req);
        int i = connection.createStatement().executeUpdate(req);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", "Opération réussite, nombre ajouter = " + i);
        return mapper.writeValueAsString(response);
    }

    public String edit(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "UPDATE public.local SET lib ='" + (String) dataLoading.get("lib") + "', batiment='" + (String) dataLoading.get("batiment") + "', etage='" + (String) dataLoading.get("etage") + "', numero='" + (String) dataLoading.get("numero") + "', nbre_place=" + (Integer) dataLoading.get("nbre_place") + ", nbre_place_occupe=" + (Integer) dataLoading.get("nbre_place_occupe") + " WHERE id=" + (Integer) dataLoading.get("id") + ";";
        logger.info("req---" + req);
        int i = connection.createStatement().executeUpdate(req);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", "Opération réussite, nombre modifier = " + i);
        return mapper.writeValueAsString(response);
    }

    public String delete(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        int i = connection.createStatement().executeUpdate("DELETE FROM public.local WHERE id=" + (Integer) dataLoading.get("id") + ";");

        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", "Opération réussite, nombre supprimer = " + i);
        return mapper.writeValueAsString(response);
    }

    public String findAll(Connection connection, String requestName) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "SELECT id, lib, batiment, etage, numero, id_enterprise, nbre_place, nbre_place_occupe, (SELECT COUNT (a1.id) FROM public.capteur a1 INNER JOIN public.local b1 ON b1.id = a1.id_local WHERE b1.id =l.id ) AS nbre_capteur, (SELECT COUNT (a2.id) FROM public.materiel a2 INNER JOIN public.local b2 ON b2.id = a2.id_local WHERE b2.id =l.id ) AS nbre_materiel, (SELECT COUNT (a3.id) FROM public.mobilier a3 INNER JOIN public.local b3 ON b3.id = a3.id_local WHERE b3.id =l.id ) AS nbre_mobilier FROM public.local AS l;";
        logger.info("req---" + req);
        ResultSet rs = connection.createStatement().executeQuery(req);
        List<Map> enterprises = new ArrayList<Map>();
        while (rs.next()) {
            Map<String, Object> hm = new HashMap<String, Object>();
            hm.put("id", rs.getInt("id"));
            hm.put("lib", rs.getString("lib"));
            hm.put("batiment", rs.getString("batiment"));
            hm.put("etage", rs.getString("etage"));
            hm.put("numero", rs.getString("numero"));
            hm.put("id_enterprise", rs.getInt("id_enterprise"));
            hm.put("nbre_place", rs.getInt("nbre_place"));
            hm.put("nbre_place_occupe", rs.getInt("nbre_place_occupe"));
            hm.put("nbre_capteur", rs.getInt("nbre_capteur"));
            hm.put("nbre_materiel", rs.getInt("nbre_materiel"));
            hm.put("nbre_mobilier", rs.getInt("nbre_mobilier"));
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
        String req = "SELECT id, lib, batiment, etage, numero, id_enterprise, nbre_place, nbre_place_occupe, (SELECT COUNT (a1.id) FROM public.capteur a1 INNER JOIN public.local b1 ON b1.id = a1.id_local WHERE b1.id =l.id ) AS nbre_capteur, (SELECT COUNT (a2.id) FROM public.materiel a2 INNER JOIN public.local b2 ON b2.id = a2.id_local WHERE b2.id =l.id ) AS nbre_materiel, (SELECT COUNT (a3.id) FROM public.mobilier a3 INNER JOIN public.local b3 ON b3.id = a3.id_local WHERE b3.id =l.id ) AS nbre_mobilier FROM public.local AS l WHERE id_enterprise =" + (Integer) dataLoading.get("id_enterprise") + ";";
        logger.info("req---" + req);
        ResultSet rs = connection.createStatement().executeQuery(req);
        List<Map> enterprises = new ArrayList<Map>();
        while (rs.next()) {
            Map<String, Object> hm = new HashMap<String, Object>();
            hm.put("id", rs.getInt("id"));
            hm.put("lib", rs.getString("lib"));
            hm.put("batiment", rs.getString("batiment"));
            hm.put("etage", rs.getString("etage"));
            hm.put("numero", rs.getString("numero"));
            hm.put("id_enterprise", rs.getInt("id_enterprise"));
            hm.put("nbre_place", rs.getInt("nbre_place"));
            hm.put("nbre_place_occupe", rs.getInt("nbre_place_occupe"));
            hm.put("nbre_capteur", rs.getInt("nbre_capteur"));
            hm.put("nbre_materiel", rs.getInt("nbre_materiel"));
            hm.put("nbre_mobilier", rs.getInt("nbre_mobilier"));
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
        ResultSet rs = connection.createStatement().executeQuery("SELECT id, lib, batiment, etage, numero, id_enterprise, nbre_place, nbre_place_occupe FROM public.local WHERE id=" + (Integer) dataLoading.get("id") + ";");

        Map<String, Object> hm = new HashMap<String, Object>();
        hm.put("id", rs.getInt("id"));
        hm.put("lib", rs.getString("lib"));
        hm.put("batiment", rs.getString("batiment"));
        hm.put("etage", rs.getString("etage"));
        hm.put("numero", rs.getString("numero"));
        hm.put("id_enterprise", rs.getInt("id_enterprise"));
        hm.put("nbre_place", rs.getInt("nbre_place"));
        hm.put("nbre_place_occupe", rs.getInt("nbre_place_occupe"));
        rs.close();
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", hm);
        return mapper.writeValueAsString(response);
    }
}
