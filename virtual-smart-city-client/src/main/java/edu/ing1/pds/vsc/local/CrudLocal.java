package edu.ing1.pds.vsc.local;

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
public class CrudLocal {

    private final static Logger logger = LoggerFactory.getLogger(CrudLocal.class.getName());

    public CrudLocal() {
    }

    public List<Local> findAll() throws Exception {
        ClientToServer connection = new ClientToServer();
        ArrayList<Map> localMap = new ArrayList<Map>();
        Request request = new Request();
        request.setNameRequest("select_local");
        HashMap<String, Object> param = new HashMap<String, Object>();
        request.setData(param);
        Request response = connection.sendRequest(request);
        localMap = (ArrayList<Map>) response.getData();
        List<Local> localList = new ArrayList<>();
        for (Map map : localMap) {
            Local local = new Local();
            local.setId((Integer) map.get("id"));
            local.setLib((String) map.get("lib"));
            local.setBatiment((String) map.get("batiment"));
            local.setEtage((String) map.get("etage"));
            local.setNumero((String) map.get("numero"));
            local.setIdEnterprise((Integer) map.get("id_enterprise"));
            local.setNbrePlace((Integer) map.get("nbre_place"));
            local.setNbrePlaceOccupe((Integer) map.get("nbre_place_occupe"));
            local.setNbreCapteur((Integer) map.get("nbre_capteur"));
            local.setNbreMateriel((Integer) map.get("nbre_materiel"));
            local.setNbreMobilier((Integer) map.get("nbre_mobilier"));
            localList.add(local);
        }
        return localList;
    }
    
    public List<Local> findByIdEnterprise(int idEnterprise) throws Exception {
        ClientToServer connection = new ClientToServer();
        ArrayList<Map> localMap = new ArrayList<Map>();
        Request request = new Request();
        request.setNameRequest("select_local_by_id_enterprise");
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("id_enterprise", idEnterprise);
        request.setData(param);
        Request response = connection.sendRequest(request);
        localMap = (ArrayList<Map>) response.getData();
        List<Local> localList = new ArrayList<>();
        for (Map map : localMap) {
            Local local = new Local();
            local.setId((Integer) map.get("id"));
            local.setLib((String) map.get("lib"));
            local.setBatiment((String) map.get("batiment"));
            local.setEtage((String) map.get("etage"));
            local.setNumero((String) map.get("numero"));
            local.setIdEnterprise((Integer) map.get("id_enterprise"));
            local.setNbrePlace((Integer) map.get("nbre_place"));
            local.setNbrePlaceOccupe((Integer) map.get("nbre_place_occupe"));
            local.setNbreCapteur((Integer) map.get("nbre_capteur"));
            local.setNbreMateriel((Integer) map.get("nbre_materiel"));
            local.setNbreMobilier((Integer) map.get("nbre_mobilier"));
            localList.add(local);
        }
        return localList;
    }

    public Local selectLocalById(int id) throws Exception {
        ClientToServer connection = new ClientToServer();
        Request request = new Request();
        request.setNameRequest("select_local_id");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", id);
        request.setData(param);
        Request response = connection.sendRequest(request);
        Map map = (Map) response.getData();
        Local local = new Local();
        local.setId((Integer) map.get("id"));
        local.setLib((String) map.get("lib"));
        local.setBatiment((String) map.get("batiment"));
        local.setEtage((String) map.get("etage"));
        local.setNumero((String) map.get("numero"));
        local.setIdEnterprise((Integer) map.get("id_enterprise"));
        local.setNbrePlace((Integer) map.get("nbre_place"));
        local.setNbrePlaceOccupe((Integer) map.get("nbre_place_occupe"));
        return local;
    }

    public String insertLocal(Local local) throws Exception {
        ClientToServer connection = new ClientToServer();
        String msg = "";
        Request request = new Request();
        request.setNameRequest("insert_local");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("lib", local.getLib());
        param.put("batiment", local.getBatiment());
        param.put("etage", local.getEtage());
        param.put("numero", local.getNumero());
        param.put("id_enterprise", local.getIdEnterprise());
        param.put("nbre_place", local.getNbrePlace());
        param.put("nbre_place_occupe", local.getNbrePlaceOccupe());
        for (Map.Entry<String, Object> entry : param.entrySet()) {
            System.out.println(entry.getKey()+" -- "+entry.getValue());            
        }
        request.setData(param);
        Request response = connection.sendRequest(request);
        msg = (String) response.getData();
        return msg;
    }

    public String updateLocal(Local local) throws Exception {
        ClientToServer connection = new ClientToServer();
        String msg = "";
        Request request = new Request();
        request.setNameRequest("update_local");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", local.getId());
        param.put("lib", local.getLib());
        param.put("batiment", local.getBatiment());
        param.put("etage", local.getEtage());
        param.put("numero", local.getNumero());
        param.put("id_enterprise", local.getIdEnterprise());
        param.put("nbre_place", local.getNbrePlace());
        param.put("nbre_place_occupe", local.getNbrePlaceOccupe());
        request.setData(param);
        Request response = connection.sendRequest(request);
        msg = (String) response.getData();
        return msg;
    }

    public String deleteLocal(int id) throws Exception {
        ClientToServer connection = new ClientToServer();
        String msg = "";
        Request request = new Request();
        request.setNameRequest("delete_local");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", id);
        request.setData(param);
        Request response = connection.sendRequest(request);
        msg = (String) response.getData();
        return msg;
    }
}
