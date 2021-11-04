package edu.ing1.pds.vsc.personne;

import edu.ing1.pds.vsc.client.ClientToServer;
import edu.ing1.pds.vsc.client.Request;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Ines
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
        Request response = connection.sendRequest(request);
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
        Request response = connection.sendRequest(request);
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
        Request response = connection.sendRequest(request);
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
        Request response = connection.sendRequest(request);
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
        Request response = connection.sendRequest(request);
        msg = (String) response.getData();

        return msg;
    }
}
