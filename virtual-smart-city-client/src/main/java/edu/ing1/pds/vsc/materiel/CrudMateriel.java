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
public class CrudMateriel {

    private final static Logger logger = LoggerFactory.getLogger(CrudMateriel.class.getName());

    public CrudMateriel() {
    }

    public List<Materiel> findByIdEnterprise(int idEnterprise) throws Exception {
        ClientToServer connection = new ClientToServer();

        List<Materiel> materielList = new ArrayList<>();
        Request request = new Request();
        request.setNameRequest("select_materiel_by_id_enterprise");
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("id_enterprise", idEnterprise);
        request.setData(param);
        Request response = connection.sendRequest(request);
        if (response != null && response.getData() != null) {
            ArrayList<Map> materielMap = new ArrayList<Map>();
            materielMap = (ArrayList<Map>) response.getData();
            for (Map map : materielMap) {
                Materiel materiel = new Materiel();
                materiel.setId((Integer) map.get("id"));
                materiel.setCode((String) map.get("code"));
                materiel.setTypeMateriel((String) map.get("type_materiel"));
                materiel.setLib((String) map.get("lib"));
                materiel.setUniteConsommation((String) map.get("unite_consommation"));
                materiel.setMoyenneConsommation((Double) map.get("moy_consom"));
                materiel.setSommeConsommation((Double) map.get("sum_consom"));
                materiel.setNumero((String) map.get("numero"));
                materiel.setEtage((String) map.get("etage"));
                materiel.setBatiment((String) map.get("batiment"));
                materiel.setIdLocal((Integer) map.get("id_local"));
                materiel.setIdEnterprise((Integer) map.get("id_enterprise"));
                materielList.add(materiel);
            }
        }
        return materielList;
    }

    public List<Materiel> findAll() throws Exception {
        ClientToServer connection = new ClientToServer();
        ArrayList<Map> materielMap = new ArrayList<Map>();
        Request request = new Request();
        request.setNameRequest("select_materiel");
        HashMap<String, Object> param = new HashMap<String, Object>();
        request.setData(param);
        Request response = connection.sendRequest(request);
        materielMap = (ArrayList<Map>) response.getData();
        List<Materiel> materielList = new ArrayList<>();
        for (Map map : materielMap) {
            Materiel materiel = new Materiel();
            materiel.setId((Integer) map.get("id"));
            materiel.setCode((String) map.get("code"));
            materiel.setTypeMateriel((String) map.get("type_materiel"));
            materiel.setLib((String) map.get("lib"));
            materiel.setUniteConsommation((String) map.get("unite_consommation"));
            materiel.setNumero((String) map.get("numero"));
            materiel.setEtage((String) map.get("etage"));
            materiel.setBatiment((String) map.get("batiment"));
            materiel.setIdLocal((Integer) map.get("id_local"));
            materiel.setIdEnterprise((Integer) map.get("id_enterprise"));
            materielList.add(materiel);
        }
        return materielList;
    }

    public Materiel selectMaterielById(int id) throws Exception {
        ClientToServer connection = new ClientToServer();
        Request request = new Request();
        request.setNameRequest("select_materiel_id");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", id);
        request.setData(param);
        Request response = connection.sendRequest(request);
        Map map = (Map) response.getData();
        Materiel materiel = new Materiel();
        materiel.setId((Integer) map.get("id"));
        materiel.setCode((String) map.get("code"));
        materiel.setTypeMateriel((String) map.get("type_materiel"));
        materiel.setLib((String) map.get("lib"));
        materiel.setUniteConsommation((String) map.get("unite_consommation"));
        materiel.setIdLocal((Integer) map.get("id_local"));
        return materiel;
    }

    public String insertMateriel(Materiel materiel) throws Exception {
        ClientToServer connection = new ClientToServer();
        String msg = "";
        Request request = new Request();
        request.setNameRequest("insert_materiel");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("code", materiel.getCode());
        param.put("type_materiel", materiel.getTypeMateriel());
        param.put("lib", materiel.getLib());
        param.put("unite_consommation", materiel.getUniteConsommation());
        param.put("id_local", materiel.getIdLocal());
        request.setData(param);
        Request response = connection.sendRequest(request);
        msg = (String) response.getData();
        return msg;
    }

    public String updateMateriel(Materiel materiel) throws Exception {
        ClientToServer connection = new ClientToServer();
        String msg = "";
        Request request = new Request();
        request.setNameRequest("update_materiel");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", materiel.getId());
        param.put("code", materiel.getCode());
        param.put("type_materiel", materiel.getTypeMateriel());
        param.put("lib", materiel.getLib());
        param.put("unite_consommation", materiel.getUniteConsommation());
        param.put("id_local", materiel.getIdLocal());
        request.setData(param);
        Request response = connection.sendRequest(request);
        msg = (String) response.getData();
        return msg;
    }

    public String deleteMateriel(int id) throws Exception {
        ClientToServer connection = new ClientToServer();
        String msg = "";
        Request request = new Request();
        request.setNameRequest("delete_materiel");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", id);
        request.setData(param);
        Request response = connection.sendRequest(request);
        msg = (String) response.getData();
        return msg;
    }
}
