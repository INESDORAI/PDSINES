package edu.ing1.pds.vsc.mobilier;

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
public class CrudMobilier {

    private final static Logger logger = LoggerFactory.getLogger(CrudMobilier.class.getName());

    public CrudMobilier() {
    }

    public List<Mobilier> findByIdEnterprise(int idEnterprise) throws Exception {
        ClientToServer connection = new ClientToServer();
        ArrayList<Map> mobilierMap = new ArrayList<Map>();
        Request request = new Request();
        request.setNameRequest("select_mobilier_by_id_enterprise");
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("id_enterprise", idEnterprise);
        request.setData(param);
        Request response = connection.sendRequest(request);
        mobilierMap = (ArrayList<Map>) response.getData();
        List<Mobilier> mobilierList = new ArrayList<>();
        for (Map map : mobilierMap) {
            Mobilier mobilier = new Mobilier();
            mobilier.setId((Integer) map.get("id"));
            mobilier.setCode((String) map.get("code"));
            mobilier.setTypeMobilier((String) map.get("type_mobilier"));
            mobilier.setLib((String) map.get("lib"));
            mobilier.setNumero((String) map.get("numero"));
            mobilier.setEtage((String) map.get("etage"));
            mobilier.setBatiment((String) map.get("batiment"));
            mobilier.setIdLocal((Integer) map.get("id_local"));
            mobilier.setIdEnterprise((Integer) map.get("id_enterprise"));
            mobilierList.add(mobilier);
        }
        return mobilierList;
    }
    
    public List<Mobilier> findAll() throws Exception {
        ClientToServer connection = new ClientToServer();
        ArrayList<Map> mobilierMap = new ArrayList<Map>();
        Request request = new Request();
        request.setNameRequest("select_mobilier");
        HashMap<String, Object> param = new HashMap<String, Object>();
        request.setData(param);
        Request response = connection.sendRequest(request);
        mobilierMap = (ArrayList<Map>) response.getData();
        List<Mobilier> mobilierList = new ArrayList<>();
        for (Map map : mobilierMap) {
            Mobilier mobilier = new Mobilier();
            mobilier.setId((Integer) map.get("id"));
            mobilier.setCode((String) map.get("code"));
            mobilier.setTypeMobilier((String) map.get("type_mobilier"));
            mobilier.setLib((String) map.get("lib"));
            mobilier.setNumero((String) map.get("numero"));
            mobilier.setEtage((String) map.get("etage"));
            mobilier.setBatiment((String) map.get("batiment"));
            mobilier.setIdLocal((Integer) map.get("id_local"));
            mobilier.setIdEnterprise((Integer) map.get("id_enterprise"));
            mobilierList.add(mobilier);
        }
        return mobilierList;
    }

    public Mobilier selectMobilierById(int id) throws Exception {
        ClientToServer connection = new ClientToServer();
        Request request = new Request();
        request.setNameRequest("select_mobilier_id");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", id);
        request.setData(param);
        Request response = connection.sendRequest(request);
        Map map = (Map) response.getData();
        Mobilier mobilier = new Mobilier();
        mobilier.setId((Integer) map.get("id"));
            mobilier.setCode((String) map.get("code"));
            mobilier.setTypeMobilier((String) map.get("type_mobilier"));
            mobilier.setLib((String) map.get("lib"));
            mobilier.setIdLocal((Integer) map.get("id_local"));
        return mobilier;
    }

    public String insertMobilier(Mobilier mobilier) throws Exception {
        ClientToServer connection = new ClientToServer();
        String msg = "";
        Request request = new Request();
        request.setNameRequest("insert_mobilier");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("code", mobilier.getCode());
        param.put("type_mobilier", mobilier.getTypeMobilier());
        param.put("lib", mobilier.getLib());
        param.put("id_local", mobilier.getIdLocal());
        request.setData(param);
        Request response = connection.sendRequest(request);
        msg = (String) response.getData();
        return msg;
    }

    public String updateMobilier(Mobilier mobilier) throws Exception {
        ClientToServer connection = new ClientToServer();
        String msg = "";
        Request request = new Request();
        request.setNameRequest("update_mobilier");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", mobilier.getId());
        param.put("code", mobilier.getCode());
        param.put("type_mobilier", mobilier.getTypeMobilier());
        param.put("lib", mobilier.getLib());
        param.put("id_local", mobilier.getIdLocal());
        request.setData(param);
        Request response = connection.sendRequest(request);
        msg = (String) response.getData();
        return msg;
    }

    public String deleteMobilier(int id) throws Exception {
        ClientToServer connection = new ClientToServer();
        String msg = "";
        Request request = new Request();
        request.setNameRequest("delete_mobilier");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", id);
        request.setData(param);
        Request response = connection.sendRequest(request);
        msg = (String) response.getData();
        return msg;
    }
}
