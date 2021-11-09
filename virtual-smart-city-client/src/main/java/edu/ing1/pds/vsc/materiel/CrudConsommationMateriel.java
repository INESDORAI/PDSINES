package edu.ing1.pds.vsc.materiel;

import edu.ing1.pds.vsc.client.ClientToServer;
import edu.ing1.pds.vsc.client.Request;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author compt
 */
public class CrudConsommationMateriel {

    private final static Logger logger = LoggerFactory.getLogger(CrudConsommationMateriel.class.getName());

    public CrudConsommationMateriel() {
    }

    public List<ConsommationMateriel> findAll() throws Exception {
        ClientToServer connection = new ClientToServer();
        ArrayList<Map> consommationMaterielMap = new ArrayList<Map>();
        Request request = new Request();
        request.setNameRequest("select_consomation_materiel");
        HashMap<String, Object> param = new HashMap<String, Object>();
        request.setData(param);
        Request response = connection.sendRequest(request);
        consommationMaterielMap = (ArrayList<Map>) response.getData();
        List<ConsommationMateriel> consomationMaterielList = new ArrayList<>();
        for (Map map : consommationMaterielMap) {
            ConsommationMateriel ConsommationMateriel = new ConsommationMateriel();
            ConsommationMateriel.setId((Integer) map.get("id"));
            ConsommationMateriel.setDatePrelevement((String) map.get("date_prelevement"));
            ConsommationMateriel.setValeur((Double) map.get("valeur"));
            ConsommationMateriel.setIdMateriel((Integer) map.get("id_materiel"));
            consomationMaterielList.add(ConsommationMateriel);
        }
        return consomationMaterielList;
    }
    public List<ConsommationMateriel> findByIdMateriel(int idMateriel) throws Exception {
        ClientToServer connection = new ClientToServer();
        ArrayList<Map> consommationMaterielMap = new ArrayList<Map>();
        Request request = new Request();
        request.setNameRequest("select_consommation_materiel_by_id_materiel");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id_materiel", idMateriel);
        request.setData(param);
        Request response = connection.sendRequest(request);
        consommationMaterielMap = (ArrayList<Map>) response.getData();
        List<ConsommationMateriel> consomationMaterielList = new ArrayList<>();
        for (Map map : consommationMaterielMap) {
            ConsommationMateriel ConsommationMateriel = new ConsommationMateriel();
            ConsommationMateriel.setId((Integer) map.get("id"));
            ConsommationMateriel.setDatePrelevement((String) map.get("date_prelevement"));
            ConsommationMateriel.setValeur((Double) map.get("valeur"));
            ConsommationMateriel.setIdMateriel((Integer) map.get("id_materiel"));
            consomationMaterielList.add(ConsommationMateriel);
        }
        return consomationMaterielList;
    }

    public ConsommationMateriel findById(int id) throws Exception {
        ClientToServer connection = new ClientToServer();
        Request request = new Request();
        request.setNameRequest("select_consommation_materiel_id");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", id);
        request.setData(param);
        Request response = connection.sendRequest(request);
        Map map = (Map) response.getData();
        ConsommationMateriel ConsommationMateriel = new ConsommationMateriel();
        ConsommationMateriel.setId((Integer) map.get("id"));
        ConsommationMateriel.setDatePrelevement((String) map.get("date_prelevement"));
        ConsommationMateriel.setValeur((Double) map.get("valeur"));
        ConsommationMateriel.setIdMateriel((Integer) map.get("id_materiel"));
        return ConsommationMateriel;
    }

    public String insertConsommationMateriel(ConsommationMateriel consommationMateriel) throws Exception {
        ClientToServer connection = new ClientToServer();
        String msg = "";
        Request request = new Request();
        request.setNameRequest("insert_consommation_materiel");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("date_prelevement", consommationMateriel.getDatePrelevement());
        param.put("valeur", consommationMateriel.getValeur());
        param.put("id_materiel", consommationMateriel.getIdMateriel());
        request.setData(param);
        Request response = connection.sendRequest(request);
        msg = (String) response.getData();
        return msg;
    }

    public String updateConsommationMateriel(ConsommationMateriel consommationMateriel) throws Exception {
        ClientToServer connection = new ClientToServer();
        String msg = "";
        Request request = new Request();
        request.setNameRequest("update_consommation_materiel");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", consommationMateriel.getId());
        param.put("date", consommationMateriel.getDatePrelevement());
        param.put("valeur", consommationMateriel.getValeur());
        param.put("id_materiel", consommationMateriel.getIdMateriel());
        request.setData(param);
        Request response = connection.sendRequest(request);
        msg = (String) response.getData();
        return msg;
    }

    public String deleteConsommationMateriel(int id) throws Exception {
        ClientToServer connection = new ClientToServer();
        String msg = "";
        Request request = new Request();
        request.setNameRequest("delete_consommation_materiel");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", id);
        request.setData(param);
        Request response = connection.sendRequest(request);
        msg = (String) response.getData();
        return msg;
    }
}
