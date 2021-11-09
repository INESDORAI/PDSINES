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
public class ConsommationMateriel {

    private final static Logger logger = Logger.getLogger(ConsommationMateriel.class);

    public ConsommationMateriel() {
    }

    public String add(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "INSERT INTO public.consommation_materiel(date_prelevement, valeur, id_materiel) VALUES('" + (String) dataLoading.get("date_prelevement") + "', " + (Double) dataLoading.get("valeur") + ", " + (Integer) dataLoading.get("id_materiel") + ");";
        logger.info("req---" + req);
        int i = connection.createStatement().executeUpdate(req);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", "Opération réussite, nombre ajouter = " + i);
        return mapper.writeValueAsString(response);
    }

    public String edit(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "UPDATE public.consommation_materiel SET date_prelevement ='" + (String) dataLoading.get("date_prelevement") + "', valeur=" + (Double) dataLoading.get("valeur") + " id_local=" + (Integer) dataLoading.get("id_local") + " WHERE id=" + (Integer) dataLoading.get("id") + ";";
        logger.info("req---" + req);
        int i = connection.createStatement().executeUpdate(req);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", "Opération réussite, nombre modifier = " + i);
        return mapper.writeValueAsString(response);
    }

    public String delete(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        int i = connection.createStatement().executeUpdate("DELETE FROM public.consommation_materiel WHERE id=" + (Integer) dataLoading.get("id") + ";");

        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", "Opération réussite, nombre supprimer = " + i);
        return mapper.writeValueAsString(response);
    }

    public String findAll(Connection connection, String requestName) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "SELECT id, date_prelevement, valeur, id_materiel  FROM public.consommation_materiel;";
        ResultSet rs = connection.createStatement().executeQuery(req);
        List<Map> enterprises = new ArrayList<Map>();
        while (rs.next()) {
            Map<String, Object> hm = new HashMap<String, Object>();
            hm.put("id", rs.getInt("id"));
            hm.put("date_prelevement", rs.getString("date_prelevement"));
            hm.put("valeur", rs.getDouble("valeur"));
            hm.put("id_materiel", rs.getInt("id_materiel"));
            enterprises.add(hm);
        }
        rs.close();
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", enterprises);
        return mapper.writeValueAsString(response);
    }
    
    public String findByIdMateriel(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "SELECT id, date_prelevement, valeur, id_materiel  FROM public.consommation_materiel WHERE id_materiel = " + (Integer) dataLoading.get("id_materiel") + ";";
        System.out.println("+++++++"+req);
        ResultSet rs = connection.createStatement().executeQuery(req);
        List<Map> enterprises = new ArrayList<Map>();
        while (rs.next()) {
            Map<String, Object> hm = new HashMap<String, Object>();
            hm.put("id", rs.getInt("id"));
            hm.put("date_prelevement", rs.getString("date_prelevement"));
            hm.put("valeur", rs.getDouble("valeur"));
            hm.put("id_materiel", rs.getInt("id_materiel"));
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
        ResultSet rs = connection.createStatement().executeQuery("SELECT id, date_prelevement, valeur, id_materiel  FROM public.consommation_materiel WHERE id=" + (Integer) dataLoading.get("id") + ";");

        Map<String, Object> hm = new HashMap<String, Object>();
        hm.put("id", rs.getInt("id"));
        hm.put("date_prelevement", rs.getString("date_prelevement"));
        hm.put("valeur", rs.getDouble("valeur"));
        hm.put("id_materiel", rs.getInt("id_materiel"));
        rs.close();
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", hm);
        return mapper.writeValueAsString(response);
    }
}
