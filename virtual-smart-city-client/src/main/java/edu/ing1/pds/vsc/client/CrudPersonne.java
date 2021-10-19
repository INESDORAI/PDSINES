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
    
    public ArrayList<Map> selectPersonne(ClientToServer connection, int id_personne) {
        ArrayList<Map> personnes = new ArrayList<Map>();
        try {
            Request request = new Request();
            request.setName_request("select_personne");
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("id_personne", id_personne);
            request.setData(param);
            Request response = connection.SendRequest(request);
            personnes = (ArrayList<Map>) response.getData();
        } catch (Exception e) {
            logger.info("Server is maybe occupied");
        }
        return personnes;
    }
    
    public String insertPersonne(ClientToServer connection, int idPersonne, String namePersonne, int agePersonne) {
      String msg = "";
        try {
            Request request = new Request();
            request.setName_request("insert_personne");
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("id_personne", idPersonne);
            param.put("name_personne", namePersonne);
            param.put("age_personne", agePersonne);
            request.setData(param);
            Request response = connection.SendRequest(request);
            msg = (String) response.getData();
        } catch (Exception e) {
            logger.info("Server is maybe occupied");
        }
        return msg;
    }
    
    public String updatePersonne(ClientToServer connection, int idPersonne, String namePersonne, int agePersonne) {
      String msg = "";
        try {
            Request request = new Request();
            request.setName_request("update_personne");
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("id_personne", idPersonne);
            param.put("name_personne", namePersonne);
            param.put("age_personne", agePersonne);
            request.setData(param);
            Request response = connection.SendRequest(request);
            msg = (String) response.getData();
        } catch (Exception e) {
            logger.info("Server is maybe occupied");
        }
        return msg;
    }
    
    public String deletePersonne(ClientToServer connection, int idPersonne) {
      String msg = "";
        try {
            Request request = new Request();
            request.setName_request("delete_personne");
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("id_personne", idPersonne);
            request.setData(param);
            Request response = connection.SendRequest(request);
            msg = (String) response.getData();
        } catch (Exception e) {
            logger.info("Server is maybe occupied");
        }
        return msg;
    }
}
