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
    private DataSource data_source;
    private ObjectMapper mapper = new ObjectMapper();
    
    

    public String SendResponse(Request request) throws Exception {
        ConnectionDB con = data_source.takeCon();
        Connection connection = con.connection;
        String request_name = request.getName_request();
        System.out.println(request_name);
        String response_string = "";
        System.out.println("++++++++++++++++++++++++++"+request_name+"++++++++++++++++++");
        if (request_name.equals("insert_personne")) {
            Map data_loading = (Map) request.getData();
            int i = connection.createStatement().executeUpdate("INSERT INTO public.personne(id, \"name\", age) VALUES("+(Integer) data_loading.get("id_personne")+", "+(String) data_loading.get("name_personne")+", "+(Integer) data_loading.get("age_personne")+");");
            
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", "Opération réussite, nombre ajouter = "+i);
            response_string = mapper.writeValueAsString(response);
        }else if (request_name.equals("update_personne")) {
            Map data_loading = (Map) request.getData();
            int i = connection.createStatement().executeUpdate("UPDATE public.personne SET \"name\"="+(String) data_loading.get("name_personne")+", age="+(Integer) data_loading.get("age_personne")+" WHERE id="+(Integer) data_loading.get("id_personne")+";");
            

            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", "Opération réussite, nombre modifier = "+i);
            response_string = mapper.writeValueAsString(response);
        }else if (request_name.equals("delete_personne")) {
            Map data_loading = (Map) request.getData();
            int i = connection.createStatement().executeUpdate("DELETE FROM public.personne WHERE id="+(Integer) data_loading.get("id_personne")+";");
            

            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", "Opération réussite, nombre supprimer = "+i);
            response_string = mapper.writeValueAsString(response);
        }else if (request_name.equals("select_personne")) {
            Map data_loading = (Map) request.getData();
//            ResultSet rs1 = connection.createStatement().executeQuery("SELECT id, \"name\", age FROM public.personne WHERE id="+(Integer) data_loading.get("id_personne")+";");
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
            response.put("name_request", request_name);
            response.put("data", personnes);
            response_string = mapper.writeValueAsString(response);
        }

        //End Coumba's part
        data_source.returnCon(con);
        return response_string;
    }

    public ServerToClient(DataSource ds) {
        try {
            data_source = ds;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
