package edu.ing1.pds.vsc.enterprise;

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
public class CrudEnterprise {

    private final static Logger logger = LoggerFactory.getLogger(CrudEnterprise.class.getName());

    public CrudEnterprise() {
    }

    public List<Enterprise> findAll() throws Exception {
        ClientToServer connection = new ClientToServer();
        ArrayList<Map> enterpriseMap = new ArrayList<Map>();
        Request request = new Request();
        request.setNameRequest("select_enterprise");
        HashMap<String, Object> param = new HashMap<String, Object>();
        request.setData(param);
        Request response = connection.sendRequest(request);
        System.out.println("---" + response.getData());
        enterpriseMap = (ArrayList<Map>) response.getData();
        List<Enterprise> enterpriseList = new ArrayList<>();
        for (Map map : enterpriseMap) {
            Enterprise enterprise = new Enterprise();
            enterprise.setId((Integer) map.get("id"));
            enterprise.setCode((String) map.get("code"));
            enterprise.setLib((String) map.get("lib"));
            enterprise.setAdresse((String) map.get("adresse"));
            enterprise.setCodePostal((String) map.get("code_postal"));
            enterprise.setPays((String) map.get("pays"));
            enterprise.setNbreLocal((Integer) map.get("nbre_local"));
            enterprise.setNbreCapteur((Integer) map.get("nbre_capteur"));
            enterprise.setNbreMobilier((Integer) map.get("nbre_mobilier"));
            enterprise.setNbreMateriel((Integer) map.get("nbre_materiel"));
            enterpriseList.add(enterprise);
        }
        return enterpriseList;
    }

    public Enterprise selectEnterpriseById(int id) throws Exception {
        ClientToServer connection = new ClientToServer();
        Request request = new Request();
        request.setNameRequest("select_enterprise_id");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", id);
        request.setData(param);
        Request response = connection.sendRequest(request);
        Map attrib = (Map) response.getData();
        Enterprise enterprise = new Enterprise();
        enterprise.setId((Integer) attrib.get("id"));
        enterprise.setCode((String) attrib.get("code"));
        enterprise.setLib((String) attrib.get("lib"));
        enterprise.setAdresse((String) attrib.get("adresse"));
        enterprise.setCodePostal((String) attrib.get("code_postal"));
        enterprise.setPays((String) attrib.get("pays"));
        enterprise.setNbreLocal((Integer) attrib.get("nbre_local"));
        enterprise.setNbreCapteur((Integer) attrib.get("nbre_capteur"));
        enterprise.setNbreMobilier((Integer) attrib.get("nbre_mobilier"));
        enterprise.setNbreMateriel((Integer) attrib.get("nbre_materiel"));
        return enterprise;
    }

    public String insertEnterprise(Enterprise enterprise) throws Exception {
        ClientToServer connection = new ClientToServer();
        String msg = "";
        Request request = new Request();
        request.setNameRequest("insert_enterprise");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", enterprise.getId());
        param.put("code", enterprise.getCode());
        param.put("lib", enterprise.getLib());
        param.put("adresse", enterprise.getAdresse());
        param.put("code_postal", enterprise.getCodePostal());
        param.put("pays", enterprise.getPays());
        request.setData(param);
        Request response = connection.sendRequest(request);
        msg = (String) response.getData();
        return msg;
    }

    public String updateEnterprise(Enterprise enterprise) throws Exception {
        ClientToServer connection = new ClientToServer();
        String msg = "";
        Request request = new Request();
        request.setNameRequest("update_enterprise");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", enterprise.getId());
        param.put("code", enterprise.getCode());
        param.put("lib", enterprise.getLib());
        param.put("adresse", enterprise.getAdresse());
        param.put("code_postal", enterprise.getCodePostal());
        param.put("pays", enterprise.getPays());
        request.setData(param);
        Request response = connection.sendRequest(request);
        msg = (String) response.getData();
        return msg;
    }

    public String deleteEnterprise(int id) throws Exception {
        ClientToServer connection = new ClientToServer();
        String msg = "";
        Request request = new Request();
        request.setNameRequest("delete_enterprise");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", id);
        request.setData(param);
        Request response = connection.sendRequest(request);
        msg = (String) response.getData();
        return msg;
    }

    public Integer nbreTotalCapteur() throws Exception {
        ClientToServer connection = new ClientToServer();
        Request request = new Request();
        request.setNameRequest("count_capteur_all_enterprise");
        Map<String, Object> param = new HashMap<String, Object>();
        request.setData(param);
        Request response = connection.sendRequest(request);
        Map attrib = (Map) response.getData();
        return (Integer) attrib.get("nbre");
    }

    public Integer nbreTotalLocal() throws Exception {
        ClientToServer connection = new ClientToServer();
        Request request = new Request();
        request.setNameRequest("count_local_all_enterprise");
        Map<String, Object> param = new HashMap<String, Object>();
        request.setData(param);
        Request response = connection.sendRequest(request);
        Map attrib = (Map) response.getData();
        return (Integer) attrib.get("nbre");
    }

    public Integer nbreTotalMateriel() throws Exception {
        ClientToServer connection = new ClientToServer();
        Request request = new Request();
        request.setNameRequest("count_materiel_all_enterprise");
        Map<String, Object> param = new HashMap<String, Object>();
        request.setData(param);
        Request response = connection.sendRequest(request);
        Map attrib = (Map) response.getData();
        return (Integer) attrib.get("nbre");
    }

    public Integer nbreTotalMobilier() throws Exception {
        ClientToServer connection = new ClientToServer();
        Request request = new Request();
        request.setNameRequest("count_mobilier_all_enterprise");
        Map<String, Object> param = new HashMap<String, Object>();
        request.setData(param);
        Request response = connection.sendRequest(request);
        Map attrib = (Map) response.getData();
        return (Integer) attrib.get("nbre");
    }
}
