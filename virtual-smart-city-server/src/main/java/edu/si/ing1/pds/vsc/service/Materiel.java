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

/**
 *
 * @author Ines
 */
public class Materiel {

    public Materiel() {
    }

    public String add(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "INSERT INTO public.materiel(type_materiel, lib, code, consommation, unite_consommation, id_local) VALUES('" + (String) dataLoading.get("type_materiel") + "', '" + (String) dataLoading.get("lib") + "', '" + (String) dataLoading.get("code") + "', " + (Double) dataLoading.get("consommation") + ", '" + (String) dataLoading.get("unite_consommation") + "', " + (Integer) dataLoading.get("id_local") + ");";
        System.out.println("req---" + req);
        int i = connection.createStatement().executeUpdate(req);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", "Opération réussite, nombre ajouter = " + i);
        return mapper.writeValueAsString(response);
    }

    public String edit(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "UPDATE public.materiel SET code ='" + (String) dataLoading.get("code") + "', lib='" + (String) dataLoading.get("lib") + "', type_materiel='" + (String) dataLoading.get("type_materiel") + "', consommation=" + (Double) dataLoading.get("consommation") + ", unite_consommation='" + (String) dataLoading.get("unite_consommation") + "', id_local=" + (Integer) dataLoading.get("id_local") + " WHERE id=" + (Integer) dataLoading.get("id") + ";";
        System.out.println("req---" + req);
        int i = connection.createStatement().executeUpdate(req);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", "Opération réussite, nombre modifier = " + i);
        return mapper.writeValueAsString(response);
    }

    public String delete(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        int i = connection.createStatement().executeUpdate("DELETE FROM public.materiel WHERE id=" + (Integer) dataLoading.get("id") + ";");

        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", "Opération réussite, nombre supprimer = " + i);
        return mapper.writeValueAsString(response);
    }

    public String findAll(Connection connection, String requestName) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "SELECT c.id AS id, c.code AS code, type_materiel, c.lib, consommation, unite_consommation, id_local, l.numero AS numero, l.etage As etage, l.batiment AS batiment, e.id AS id_enterprise FROM public.materiel AS c INNER JOIN public.local AS l ON c.id_local = l.id INNER JOIN public.enterprise AS e ON l.id_enterprise = e.id ;";
        ResultSet rs = connection.createStatement().executeQuery(req);
        List<Map> enterprises = new ArrayList<Map>();
        while (rs.next()) {
            Map<String, Object> hm = new HashMap<String, Object>();
            hm.put("id", rs.getInt("id"));
            hm.put("code", rs.getString("code"));
            hm.put("type_materiel", rs.getString("type_materiel"));
            hm.put("lib", rs.getString("lib"));
            hm.put("batiment", rs.getString("batiment"));
            hm.put("etage", rs.getString("etage"));
            hm.put("numero", rs.getString("numero"));
            hm.put("consommation", rs.getDouble("consommation"));
            hm.put("unite_consommation", rs.getString("unite_consommation"));
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
        String req = "SELECT c.id AS id, c.code AS code, type_materiel, c.lib, consommation, unite_consommation, id_local, l.numero AS numero, l.etage As etage, l.batiment AS batiment, e.id AS id_enterprise FROM public.materiel AS c INNER JOIN public.local AS l ON c.id_local = l.id INNER JOIN public.enterprise AS e ON l.id_enterprise = e.id WHERE  e.id=" + (Integer) dataLoading.get("id_enterprise") + ";";
        System.out.println("req---" + req);
        ResultSet rs = connection.createStatement().executeQuery(req);
        List<Map> enterprises = new ArrayList<Map>();
        while (rs.next()) {
            Map<String, Object> hm = new HashMap<String, Object>();
            hm.put("id", rs.getInt("id"));
            hm.put("code", rs.getString("code"));
            hm.put("type_materiel", rs.getString("type_materiel"));
            hm.put("lib", rs.getString("lib"));
            hm.put("batiment", rs.getString("batiment"));
            hm.put("etage", rs.getString("etage"));
            hm.put("numero", rs.getString("numero"));
            hm.put("consommation", rs.getDouble("consommation"));
            hm.put("unite_consommation", rs.getString("unite_consommation"));
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
        ResultSet rs = connection.createStatement().executeQuery("SELECT id, type_materiel, lib, code, consommation, unite_consommation, id_local FROM public.materiel WHERE id=" + (Integer) dataLoading.get("id") + ";");

        Map<String, Object> hm = new HashMap<String, Object>();
        hm.put("id", rs.getInt("id"));
        hm.put("code", rs.getString("code"));
        hm.put("type_materiel", rs.getString("type_materiel"));
        hm.put("lib", rs.getString("lib"));
        hm.put("consommation", rs.getDouble("consommation"));
        hm.put("unite_consommation", rs.getString("unite_consommation"));
        hm.put("id_local", rs.getInt("id_local"));
        rs.close();
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", hm);
        return mapper.writeValueAsString(response);
    }
}
