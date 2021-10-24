/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ing1.pds.vsc.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author compt
 */
public class CrudPersonne {

    private final static Logger logger = LoggerFactory.getLogger(CrudPersonne.class.getName());

    public CrudPersonne() {
    }

    public ArrayList<Map> selectPersonne(ClientToServer connection) throws Exception {
        ArrayList<Map> personnes = new ArrayList<Map>();
        Request request = new Request();
        request.setNameRequest("select_personne");
        HashMap<String, Object> param = new HashMap<String, Object>();
        request.setData(param);
        Request response = connection.SendRequest(request);
        personnes = (ArrayList<Map>) response.getData();

        return personnes;
    }
    
    public ArrayList<Map> selectPersonneById(ClientToServer connection, int id_personne) throws Exception {
        ArrayList<Map> personnes = new ArrayList<Map>();
        Request request = new Request();
        request.setNameRequest("select_personne_id");
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("id_personne", id_personne);
        request.setData(param);
        Request response = connection.SendRequest(request);
        personnes = (ArrayList<Map>) response.getData();

        return personnes;
    }

    public String insertPersonne(ClientToServer connection, int idPersonne, String namePersonne, int agePersonne) throws Exception {
        String msg = "";
        Request request = new Request();
        request.setNameRequest("insert_personne");
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("id_personne", idPersonne);
        param.put("name_personne", namePersonne);
        param.put("age_personne", agePersonne);
        request.setData(param);
        Request response = connection.SendRequest(request);
        msg = (String) response.getData();
        return msg;
    }

    public String updatePersonne(ClientToServer connection, int idPersonne, String namePersonne, int agePersonne) throws Exception {
        String msg = "";
        Request request = new Request();
        request.setNameRequest("update_personne");
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("id_personne", idPersonne);
        param.put("name_personne", namePersonne);
        param.put("age_personne", agePersonne);
        request.setData(param);
        Request response = connection.SendRequest(request);
        msg = (String) response.getData();

        return msg;
    }

    public String deletePersonne(ClientToServer connection, int idPersonne) throws Exception {
        String msg = "";
        Request request = new Request();
        request.setNameRequest("delete_personne");
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("id_personne", idPersonne);
        request.setData(param);
        Request response = connection.SendRequest(request);
        msg = (String) response.getData();

        return msg;
    }
}
