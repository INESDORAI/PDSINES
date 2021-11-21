package edu.ing1.pds.vsc.capteur;

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
public class CrudCapteur {

    private final static Logger logger = LoggerFactory.getLogger(CrudCapteur.class.getName());

    public CrudCapteur() {
    }

    public List<Capteur> findByIdEnterprise(int idEnterprise) throws Exception {
        ClientToServer connection = new ClientToServer();
        ArrayList<Map> capteurMap = new ArrayList<Map>();
        Request request = new Request();
        request.setNameRequest("select_capteur_by_id_enterprise");
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("id_enterprise", idEnterprise);
        request.setData(param);
        Request response = connection.sendRequest(request);
        capteurMap = (ArrayList<Map>) response.getData();
        List<Capteur> capteurList = new ArrayList<>();
        for (Map map : capteurMap) {
            Capteur capteur = new Capteur();
            capteur.setId((Integer) map.get("id"));
            capteur.setCode((String) map.get("code"));
            capteur.setDateCapteur((String) map.get("date_capteur"));
            capteur.setTypeCapteur((String) map.get("type_capteur"));
            capteur.setValeurCapteur((Double) map.get("valeur_capteur"));
            capteur.setNumero((String) map.get("numero"));
            capteur.setEtage((String) map.get("etage"));
            capteur.setBatiment((String) map.get("batiment"));
            capteur.setIdLocal((Integer) map.get("id_local"));
            capteur.setIdEnterprise((Integer) map.get("id_enterprise"));
            capteurList.add(capteur);
        }
        return capteurList;
    }
    
    public List<Capteur> findByIdEnterpriseIdLocal(int idEnterprise, int idLocal) throws Exception {
        ClientToServer connection = new ClientToServer();
        ArrayList<Map> capteurMap = new ArrayList<Map>();
        Request request = new Request();
        request.setNameRequest("select_capteur_by_id_enterprise_id_local");
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("id_enterprise", idEnterprise);
        param.put("id_local", idLocal);
        request.setData(param);
        Request response = connection.sendRequest(request);
        capteurMap = (ArrayList<Map>) response.getData();
        List<Capteur> capteurList = new ArrayList<>();
        for (Map map : capteurMap) {
            Capteur capteur = new Capteur();
            capteur.setId((Integer) map.get("id"));
            capteur.setCode((String) map.get("code"));
            capteur.setDateCapteur((String) map.get("date_capteur"));
            capteur.setTypeCapteur((String) map.get("type_capteur"));
            capteur.setValeurCapteur((Double) map.get("valeur_capteur"));
            capteur.setNumero((String) map.get("numero"));
            capteur.setEtage((String) map.get("etage"));
            capteur.setBatiment((String) map.get("batiment"));
            capteur.setIdLocal((Integer) map.get("id_local"));
            capteur.setIdEnterprise((Integer) map.get("id_enterprise"));
            capteurList.add(capteur);
        }
        return capteurList;
    }
    
    public List<Capteur> findByIdEnterpriseIdLocalMoisAnnee(int idEnterprise, int idLocal, int mois, int annee) throws Exception {
        ClientToServer connection = new ClientToServer();
        ArrayList<Map> capteurMap = new ArrayList<Map>();
        Request request = new Request();
        request.setNameRequest("select_capteur_by_id_enterprise_id_local_mois_annee");
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("id_enterprise", idEnterprise);
        param.put("id_local", idLocal);
        param.put("mois", mois);
        param.put("annee", annee);
        request.setData(param);
        Request response = connection.sendRequest(request);
        capteurMap = (ArrayList<Map>) response.getData();
        List<Capteur> capteurList = new ArrayList<>();
        for (Map map : capteurMap) {
            Capteur capteur = new Capteur();
            capteur.setId((Integer) map.get("id"));
            capteur.setCode((String) map.get("code"));
            capteur.setDateCapteur((String) map.get("date_capteur"));
            capteur.setTypeCapteur((String) map.get("type_capteur"));
            capteur.setValeurCapteur((Double) map.get("valeur_capteur"));
            capteur.setNumero((String) map.get("numero"));
            capteur.setEtage((String) map.get("etage"));
            capteur.setBatiment((String) map.get("batiment"));
            capteur.setIdLocal((Integer) map.get("id_local"));
            capteur.setIdEnterprise((Integer) map.get("id_enterprise"));
            capteurList.add(capteur);
        }
        return capteurList;
    }
    
    public List<Capteur> findByIdEnterpriseIdLocalDate(int idEnterprise, int idLocal,  String dateDebut, String dateFin) throws Exception {
        ClientToServer connection = new ClientToServer();
        ArrayList<Map> capteurMap = new ArrayList<Map>();
        Request request = new Request();
        request.setNameRequest("select_capteur_by_id_enterprise_id_local_date");
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("id_enterprise", idEnterprise);
        param.put("id_local", idLocal);
        param.put("date_debut", dateDebut);
        param.put("date_fin", dateFin);
        request.setData(param);
        Request response = connection.sendRequest(request);
        capteurMap = (ArrayList<Map>) response.getData();
        List<Capteur> capteurList = new ArrayList<>();
        for (Map map : capteurMap) {
            Capteur capteur = new Capteur();
            capteur.setId((Integer) map.get("id"));
            capteur.setCode((String) map.get("code"));
            capteur.setDateCapteur((String) map.get("date_capteur"));
            capteur.setTypeCapteur((String) map.get("type_capteur"));
            capteur.setValeurCapteur((Double) map.get("valeur_capteur"));
            capteur.setNumero((String) map.get("numero"));
            capteur.setEtage((String) map.get("etage"));
            capteur.setBatiment((String) map.get("batiment"));
            capteur.setIdLocal((Integer) map.get("id_local"));
            capteur.setIdEnterprise((Integer) map.get("id_enterprise"));
            capteurList.add(capteur);
        }
        return capteurList;
    }
    
    public List<Capteur> findByIdEnterpriseMoisAnnee(int idEnterprise, int mois, int annee) throws Exception {
        ClientToServer connection = new ClientToServer();
        ArrayList<Map> capteurMap = new ArrayList<Map>();
        Request request = new Request();
        request.setNameRequest("select_capteur_by_id_enterprise_mois_annee");
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("id_enterprise", idEnterprise);
        param.put("mois", mois);
        param.put("annee", annee);
        request.setData(param);
        Request response = connection.sendRequest(request);
        capteurMap = (ArrayList<Map>) response.getData();
        List<Capteur> capteurList = new ArrayList<>();
        for (Map map : capteurMap) {
            Capteur capteur = new Capteur();
            capteur.setId((Integer) map.get("id"));
            capteur.setCode((String) map.get("code"));
            capteur.setDateCapteur((String) map.get("date_capteur"));
            capteur.setTypeCapteur((String) map.get("type_capteur"));
            capteur.setValeurCapteur((Double) map.get("valeur_capteur"));
            capteur.setNumero((String) map.get("numero"));
            capteur.setEtage((String) map.get("etage"));
            capteur.setBatiment((String) map.get("batiment"));
            capteur.setIdLocal((Integer) map.get("id_local"));
            capteur.setIdEnterprise((Integer) map.get("id_enterprise"));
            capteurList.add(capteur);
        }
        return capteurList;
    }
    
    public List<Capteur> findByIdEnterpriseDate(int idEnterprise, String dateDebut, String dateFin) throws Exception {
        ClientToServer connection = new ClientToServer();
        ArrayList<Map> capteurMap = new ArrayList<Map>();
        Request request = new Request();
        request.setNameRequest("select_capteur_by_id_enterprise_date");
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("id_enterprise", idEnterprise);
        param.put("date_debut", dateDebut);
        param.put("date_fin", dateFin);
        request.setData(param);
        Request response = connection.sendRequest(request);
        capteurMap = (ArrayList<Map>) response.getData();
        List<Capteur> capteurList = new ArrayList<>();
        for (Map map : capteurMap) {
            Capteur capteur = new Capteur();
            capteur.setId((Integer) map.get("id"));
            capteur.setCode((String) map.get("code"));
            capteur.setDateCapteur((String) map.get("date_capteur"));
            capteur.setTypeCapteur((String) map.get("type_capteur"));
            capteur.setValeurCapteur((Double) map.get("valeur_capteur"));
            capteur.setNumero((String) map.get("numero"));
            capteur.setEtage((String) map.get("etage"));
            capteur.setBatiment((String) map.get("batiment"));
            capteur.setIdLocal((Integer) map.get("id_local"));
            capteur.setIdEnterprise((Integer) map.get("id_enterprise"));
            capteurList.add(capteur);
        }
        return capteurList;
    }
    
    public List<Capteur> findByIdEnterpriseIdLocalAnnee(int idEnterprise, int idLocal, int annee) throws Exception {
        ClientToServer connection = new ClientToServer();
        ArrayList<Map> capteurMap = new ArrayList<Map>();
        Request request = new Request();
        request.setNameRequest("select_capteur_by_id_enterprise_id_local_annee");
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("id_enterprise", idEnterprise);
        param.put("id_local", idLocal);
        param.put("annee", annee);
        request.setData(param);
        Request response = connection.sendRequest(request);
        capteurMap = (ArrayList<Map>) response.getData();
        List<Capteur> capteurList = new ArrayList<>();
        for (Map map : capteurMap) {
            Capteur capteur = new Capteur();
            capteur.setId((Integer) map.get("id"));
            capteur.setCode((String) map.get("code"));
            capteur.setDateCapteur((String) map.get("date_capteur"));
            capteur.setTypeCapteur((String) map.get("type_capteur"));
            capteur.setValeurCapteur((Double) map.get("valeur_capteur"));
            capteur.setNumero((String) map.get("numero"));
            capteur.setEtage((String) map.get("etage"));
            capteur.setBatiment((String) map.get("batiment"));
            capteur.setIdLocal((Integer) map.get("id_local"));
            capteur.setIdEnterprise((Integer) map.get("id_enterprise"));
            capteurList.add(capteur);
        }
        return capteurList;
    }
    
    public List<Capteur> findByIdEnterpriseAnnee(int idEnterprise, int annee) throws Exception {
        ClientToServer connection = new ClientToServer();
        ArrayList<Map> capteurMap = new ArrayList<Map>();
        Request request = new Request();
        request.setNameRequest("select_capteur_by_id_enterprise_annee");
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("id_enterprise", idEnterprise);
        param.put("annee", annee);
        request.setData(param);
        Request response = connection.sendRequest(request);
        capteurMap = (ArrayList<Map>) response.getData();
        List<Capteur> capteurList = new ArrayList<>();
        for (Map map : capteurMap) {
            Capteur capteur = new Capteur();
            capteur.setId((Integer) map.get("id"));
            capteur.setCode((String) map.get("code"));
            capteur.setDateCapteur((String) map.get("date_capteur"));
            capteur.setTypeCapteur((String) map.get("type_capteur"));
            capteur.setValeurCapteur((Double) map.get("valeur_capteur"));
            capteur.setNumero((String) map.get("numero"));
            capteur.setEtage((String) map.get("etage"));
            capteur.setBatiment((String) map.get("batiment"));
            capteur.setIdLocal((Integer) map.get("id_local"));
            capteur.setIdEnterprise((Integer) map.get("id_enterprise"));
            capteurList.add(capteur);
        }
        return capteurList;
    }
    
    public List<CapteurAnnee> findByIdEnterpriseIntervalAnnee(int idEnterprise, int anneeMin, int anneeMax) throws Exception {
        ClientToServer connection = new ClientToServer();
        ArrayList<Map> capteurMap = new ArrayList<Map>();
        Request request = new Request();
        request.setNameRequest("select_capteur_by_id_enterprise_interval_annee");
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("id_enterprise", idEnterprise);
        param.put("annee_min", anneeMin);
        param.put("annee_max", anneeMax);
        request.setData(param);
        Request response = connection.sendRequest(request);
        capteurMap = (ArrayList<Map>) response.getData();
        List<CapteurAnnee> capteurAnneeList = new ArrayList<>();
        for (Map map : capteurMap) {
            CapteurAnnee capteurAnnee = new CapteurAnnee();
            capteurAnnee.setIdEnterprise((Integer) map.get("id_enterprise"));
            capteurAnnee.setAnnee((Integer) map.get("annee"));
            capteurAnnee.setNbre(((Double) map.get("nbre")).intValue());
            capteurAnneeList.add(capteurAnnee);
        }
        return capteurAnneeList;
    }

    public List<Capteur> findAll() throws Exception {
        ClientToServer connection = new ClientToServer();
        ArrayList<Map> capteurMap = new ArrayList<Map>();
        Request request = new Request();
        request.setNameRequest("select_capteur");
        HashMap<String, Object> param = new HashMap<String, Object>();
        request.setData(param);
        Request response = connection.sendRequest(request);
        capteurMap = (ArrayList<Map>) response.getData();
        List<Capteur> capteurList = new ArrayList<>();
        for (Map map : capteurMap) {
            Capteur capteur = new Capteur();
            capteur.setId((Integer) map.get("id"));
            capteur.setCode((String) map.get("code"));
            capteur.setDateCapteur((String) map.get("date_capteur.31.249.246"));
            capteur.setTypeCapteur((String) map.get("type_capteur"));
            capteur.setValeurCapteur((Double) map.get("valeur_capteur"));
            capteur.setNumero((String) map.get("numero"));
            capteur.setEtage((String) map.get("etage"));
            capteur.setBatiment((String) map.get("batiment"));
            capteur.setIdLocal((Integer) map.get("id_local"));
            capteur.setIdEnterprise((Integer) map.get("id_enterprise"));
            capteurList.add(capteur);
        }
        return capteurList;
    }

    public Capteur selectCapteurById(int id) throws Exception {
        ClientToServer connection = new ClientToServer();
        Request request = new Request();
        request.setNameRequest("select_capteur_id");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", id);
        request.setData(param);
        Request response = connection.sendRequest(request);
        Map map = (Map) response.getData();
        Capteur capteur = new Capteur();
        capteur.setId((Integer) map.get("id"));
        capteur.setCode((String) map.get("code"));
        capteur.setDateCapteur((String) map.get("date_capteur"));
        capteur.setTypeCapteur((String) map.get("type_capteur"));
        capteur.setValeurCapteur((Double) map.get("valeur_capteur"));
        capteur.setIdLocal((Integer) map.get("id_local"));
        return capteur;
    }

    public String insertCapteur(Capteur capteur) throws Exception {
        ClientToServer connection = new ClientToServer();
        String msg = "";
        Request request = new Request();
        request.setNameRequest("insert_capteur");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("code", capteur.getCode());
        param.put("date_capteur", capteur.getDateCapteur());
        param.put("type_capteur", capteur.getTypeCapteur());
        param.put("valeur_capteur", capteur.getValeurCapteur());
        param.put("id_local", capteur.getIdLocal());
        request.setData(param);
        Request response = connection.sendRequest(request);
        msg = (String) response.getData();
        return msg;
    }

    public String updateCapteur(Capteur capteur) throws Exception {
        ClientToServer connection = new ClientToServer();
        String msg = "";
        Request request = new Request();
        request.setNameRequest("update_capteur");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", capteur.getId());
        param.put("code", capteur.getCode());
        param.put("date_capteur", capteur.getDateCapteur());
        param.put("type_capteur", capteur.getTypeCapteur());
        param.put("valeur_capteur", capteur.getValeurCapteur());
        param.put("id_local", capteur.getIdLocal());
        request.setData(param);
        Request response = connection.sendRequest(request);
        msg = (String) response.getData();
        return msg;
    }

    public String deleteCapteur(int id) throws Exception {
        ClientToServer connection = new ClientToServer();
        String msg = "";
        Request request = new Request();
        request.setNameRequest("delete_capteur");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", id);
        request.setData(param);
        Request response = connection.sendRequest(request);
        msg = (String) response.getData();
        return msg;
    }
}
