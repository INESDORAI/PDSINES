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
public class Personne {

    public Personne() {
    }

    public String add(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        String req = "INSERT INTO public.personne(id, \"name\", age) VALUES(" + (Integer) dataLoading.get("id_personne") + ", '" + (String) dataLoading.get("name_personne") + "', " + (Integer) dataLoading.get("age_personne") + ");";
        System.out.println("req---" + req);
        int i = connection.createStatement().executeUpdate(req);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", "Opération réussite, nombre ajouter = " + i);
        return mapper.writeValueAsString(response);
    }

    public String edit(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        int i = connection.createStatement().executeUpdate("UPDATE public.personne SET \"name\"='" + (String) dataLoading.get("name_personne") + "', age=" + (Integer) dataLoading.get("age_personne") + " WHERE id=" + (Integer) dataLoading.get("id_personne") + ";");
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", "Opération réussite, nombre modifier = " + i);
        return mapper.writeValueAsString(response);
    }

    public String delete(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        int i = connection.createStatement().executeUpdate("DELETE FROM public.personne WHERE id=" + (Integer) dataLoading.get("id_personne") + ";");

        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", "Opération réussite, nombre supprimer = " + i);
        return mapper.writeValueAsString(response);
    }

    public String findAll(Connection connection, String requestName) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        ResultSet rs1 = connection.createStatement().executeQuery("SELECT id, \"name\", age FROM public.personne;");
        List<Map> personnes = new ArrayList<Map>();
        while (rs1.next()) {
            Map<String, Object> hm = new HashMap<String, Object>();
            hm.put("id_personne", rs1.getInt("id"));
            hm.put("name_personne", rs1.getString("name"));
            hm.put("age_personne", rs1.getInt("age"));
            personnes.add(hm);
        }
        rs1.close();
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", personnes);
        return mapper.writeValueAsString(response);
    }

    public String findById(Connection connection, String requestName, Map<String, Object> dataLoading) throws JsonProcessingException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        ResultSet rs1 = connection.createStatement().executeQuery("SELECT id, \"name\", age FROM public.personne WHERE id=" + (Integer) dataLoading.get("id_personne") + ";");

        Map<String, Object> hm = new HashMap<String, Object>();
        hm.put("id_personne", rs1.getInt("id"));
        hm.put("name_personne", rs1.getString("name"));
        hm.put("age_personne", rs1.getInt("age"));
        rs1.close();
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("nameRequest", requestName);
        response.put("data", hm);
        return mapper.writeValueAsString(response);
    }
}
