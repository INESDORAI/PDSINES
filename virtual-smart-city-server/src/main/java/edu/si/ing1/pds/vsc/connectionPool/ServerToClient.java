package edu.si.ing1.pds.vsc.connectionPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

//import edu.ing1.pds.vsc.client.electroChromaticWindowsManagement.WindowsTable;
public class ServerToClient {

    private final static Logger logger = LoggerFactory.getLogger(ServerToClient.class.getName());
    private DataSource dataSource;
    private ObjectMapper mapper = new ObjectMapper();

    public String SendResponse(Request request) throws Exception {
        ConnectionDB con = dataSource.takeCon();
        Connection connection = con.connection;
        String requestName = request.getNameRequest();
        String responseString = "";
        if (requestName.equals("insert_personne")) {
            Map data_loading = (Map) request.getData();
            String req = "INSERT INTO public.personne(id, \"name\", age) VALUES(" + (Integer) data_loading.get("id_personne") + ", '" + (String) data_loading.get("name_personne") + "', " + (Integer) data_loading.get("age_personne") + ");";
            System.out.println("req---" + req);
            int i = connection.createStatement().executeUpdate(req);
            System.out.println("reponse insert----" + i);
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("nameRequest", requestName);
            response.put("data", "Opération réussite, nombre ajouter = " + i);
            responseString = mapper.writeValueAsString(response);
        } else if (requestName.equals("update_personne")) {
            Map data_loading = (Map) request.getData();
            int i = connection.createStatement().executeUpdate("UPDATE public.personne SET \"name\"='" + (String) data_loading.get("name_personne") + "', age=" + (Integer) data_loading.get("age_personne") + " WHERE id=" + (Integer) data_loading.get("id_personne") + ";");
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("nameRequest", requestName);
            response.put("data", "Opération réussite, nombre modifier = " + i);
            responseString = mapper.writeValueAsString(response);
        } else if (requestName.equals("delete_personne")) {
            Map data_loading = (Map) request.getData();
            int i = connection.createStatement().executeUpdate("DELETE FROM public.personne WHERE id=" + (Integer) data_loading.get("id_personne") + ";");

            Map<String, Object> response = new HashMap<String, Object>();
            response.put("nameRequest", requestName);
            response.put("data", "Opération réussite, nombre supprimer = " + i);
            responseString = mapper.writeValueAsString(response);
        } else if (requestName.equals("select_personne_id")) {
            Map data_loading = (Map) request.getData();
            ResultSet rs1 = connection.createStatement().executeQuery("SELECT id, \"name\", age FROM public.personne WHERE id="+(Integer) data_loading.get("id_personne")+";");
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
            responseString = mapper.writeValueAsString(response);
        }else if (requestName.equals("select_personne")) {
            Map data_loading = (Map) request.getData();
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
            responseString = mapper.writeValueAsString(response);
        }

        //End Coumba's part
        dataSource.returnCon(con);
        return responseString;
    }

    public ServerToClient(DataSource ds) {
        try {
            dataSource = ds;
        } catch (Exception e) {
            logger.error("Erreur.....");
            e.printStackTrace();
        }
    }
}
