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
        if (request_name.equals("all_rented_workspaces")) {
            Map data_loading = (Map) request.getData();
            ResultSet rs1 = connection.createStatement().executeQuery("SELECT * FROM workspace where id_gs=" + (Integer) data_loading.get("id_gs") + " Order by id_workspace");
            List<Map> workSpaces = new ArrayList<Map>();
            while (rs1.next()) {
                Map<String, Object> hm = new HashMap<String, Object>();
                hm.put("id_workspace", rs1.getInt("id_workspace"));
                hm.put("type_workspace", rs1.getString("type_workspace"));
                hm.put("floor_number", rs1.getInt("floor_number"));
                hm.put("is_available", rs1.getBoolean("is_available"));
                hm.put("id_building", rs1.getInt("id_building"));
                hm.put("id_gs", rs1.getInt("id_gs"));
                workSpaces.add(hm);
            }
            rs1.close();
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", workSpaces);
            response_string = mapper.writeValueAsString(response);
        } else if (request_name.equals("list_workspaces")) {
            Map data_loading = (Map) request.getData();
            ResultSet rs1 = connection.createStatement().executeQuery("SELECT * FROM workspace where id_building=" + (Integer) data_loading.get("id_building") + " and floor_number=" + (Integer) data_loading.get("floor_number") + " Order by id_workspace");
            List<Map> workSpaces = new ArrayList<Map>();
            while (rs1.next()) {
                Map<String, Object> hm = new HashMap<String, Object>();
                hm.put("id_workspace", rs1.getInt("id_workspace"));
                hm.put("type_workspace", rs1.getString("type_workspace"));
                hm.put("floor_number", rs1.getInt("floor_number"));
                hm.put("is_available", rs1.getBoolean("is_available"));
                hm.put("id_building", rs1.getInt("id_building"));
                hm.put("id_gs", rs1.getInt("id_gs"));
                workSpaces.add(hm);
            }
            rs1.close();
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", workSpaces);
            response_string = mapper.writeValueAsString(response);
        } else if (request_name.equals("all_buildings")) {
            Map data_loading = (Map) request.getData();
            ResultSet rs1 = connection.createStatement().executeQuery("SELECT * FROM building Order by id_building");
            List<Map> workSpaces = new ArrayList<Map>();
            while (rs1.next()) {
                Map<String, Object> hm = new HashMap<String, Object>();
                hm.put("id_building", rs1.getInt("id_building"));
                workSpaces.add(hm);
            }
            rs1.close();
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", workSpaces);
            response_string = mapper.writeValueAsString(response);
        } else if (request_name.equals("list_positions")) {
            Map data_loading = (Map) request.getData();
            ResultSet rs1 = connection.createStatement().executeQuery("SELECT * FROM positions where id_workspace=" + (Integer) data_loading.get("id_workspace") + " Order by id_position");
            List<Map> positions = new ArrayList<Map>();
            while (rs1.next()) {
                Map<String, Object> hm = new HashMap<String, Object>();
                hm.put("id_position", rs1.getInt("id_position"));
                hm.put("longitude", rs1.getInt("longitude"));
                hm.put("latitude", rs1.getInt("latitude"));
                hm.put("id_workspace", rs1.getInt("id_workspace"));
                hm.put("position_type", rs1.getString("position_type"));
                hm.put("is_available", rs1.getBoolean("is_available"));
                positions.add(hm);
            }
            rs1.close();
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", positions);
            response_string = mapper.writeValueAsString(response);
        } else if (request_name.equals("all_generalServices")) {
            Map data_loading = (Map) request.getData();
            ResultSet rs1 = connection.createStatement().executeQuery("SELECT * FROM generalservices Order by id_generalservices");
            List<Map> workSpaces = new ArrayList<Map>();
            while (rs1.next()) {
                Map<String, Object> hm = new HashMap<String, Object>();
                hm.put("id_generalservices", rs1.getInt("id_generalservices"));
                hm.put("company_name", rs1.getString("company_name"));
                workSpaces.add(hm);
            }
            rs1.close();
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", workSpaces);
            response_string = mapper.writeValueAsString(response);
        } //Hajar's part
        else if (request_name.equals("list_sensors")) {
            Map data_loading = (Map) request.getData();
            ResultSet rs1 = connection.createStatement().executeQuery("SELECT * FROM sensor where id_position in (select id_position from positions where id_workspace=" + (Integer) data_loading.get("id_workspace") + ") Order by id_sensor");
            List<Map> workSpaces = new ArrayList<Map>();
            while (rs1.next()) {
                Map<String, Object> hm = new HashMap<String, Object>();
                hm.put("id_sensor", rs1.getInt("id_sensor"));
                hm.put("type_sensor", rs1.getString("type_sensor"));
                hm.put("is_available", rs1.getBoolean("is_available"));
                hm.put("is_working", rs1.getBoolean("is_working"));
                hm.put("id_gs", rs1.getInt("id_gs"));
                hm.put("id_position", rs1.getInt("id_position"));
                workSpaces.add(hm);
            }
            rs1.close();
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", workSpaces);
            response_string = mapper.writeValueAsString(response);
        } else if (request_name.equals("list_equipments")) {
            Map data_loading = (Map) request.getData();
            ResultSet rs1 = null;
            if ((Integer) data_loading.get("id_workspace") == 0) {
                rs1 = connection.createStatement().executeQuery("SELECT * FROM equipment where is_available=" + (Boolean) data_loading.get("is_available") + " Order by id_equipment");
            } else {
                rs1 = connection.createStatement().executeQuery("SELECT * FROM equipment where id_position in( select id_position from positions where id_workspace=" + (Integer) data_loading.get("id_workspace") + ") Order by id_equipment");
            }
            List<Map> equipments = new ArrayList<Map>();
            while (rs1.next()) {
                Map<String, Object> hm = new HashMap<String, Object>();
                hm.put("id_equipment", rs1.getInt("id_equipment"));
                hm.put("type_equipment", rs1.getString("type_equipment"));
                hm.put("is_available", rs1.getBoolean("is_available"));
                hm.put("is_working", rs1.getBoolean("is_working"));
                hm.put("id_gs", rs1.getInt("id_gs"));
                hm.put("id_position", rs1.getInt("id_position"));
                equipments.add(hm);
            }
            rs1.close();
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", equipments);
            response_string = mapper.writeValueAsString(response);

        } else if (request_name.equals("available_positions")) {
            Map data_loading = (Map) request.getData();
            ResultSet rs1 = null;
            String sql = "";
            if ((Integer) data_loading.get("id_workspace") != 0) {
                sql = "SELECT * FROM positions where id_workspace=" + (Integer) data_loading.get("id_workspace") + " Order by id_position";
                rs1 = connection.createStatement().executeQuery(sql);

            } else {
                sql = "SELECT * FROM positions where is_available=" + (Boolean) data_loading.get("is_available") + " and id_workspace  in (SELECT id_workspace from workspace where id_gs=" + (Integer) data_loading.get("id_gs") + ") Order by id_position";

                rs1 = connection.createStatement().executeQuery(sql);

            }
            logger.info(sql);
            logger.info(rs1.getFetchSize() + "");
            List<Map> positions = new ArrayList<Map>();
            while (rs1.next()) {
                Map<String, Object> hm = new HashMap<String, Object>();
                hm.put("id_position", rs1.getInt("id_position"));
                hm.put("longitude", rs1.getInt("longitude"));
                hm.put("latitude", rs1.getInt("latitude"));
                hm.put("id_workspace", rs1.getInt("id_workspace"));
                hm.put("position_type", rs1.getString("position_type"));
                hm.put("is_available", rs1.getBoolean("is_available"));
                positions.add(hm);
            }
            rs1.close();
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", positions);
            response_string = mapper.writeValueAsString(response);
        } else if (request_name.equals("map_equipment")) {
            Map data_loading = (Map) request.getData();
            int op1, op2;
            connection.setAutoCommit(false);
            op1 = connection.createStatement().executeUpdate("WITH equipment_pick AS ( SELECT id_equipment FROM  equipment WHERE  type_equipment='" + (String) data_loading.get("type_equipment") + "' LIMIT  1) UPDATE equipment e SET is_available = false, id_gs=" + (Integer) data_loading.get("id_gs") + ", id_position=" + (Integer) data_loading.get("id_position") + "FROM equipment_pick WHERE  e.id_equipment = equipment_pick.id_equipment");
            op2 = connection.createStatement().executeUpdate("update positions set is_available=false where id_position=" + (Integer) data_loading.get("id_position"));
            List<Map> update = new ArrayList<Map>();
            Map<String, Object> hm = new HashMap<String, Object>();
            logger.info(op1 + " " + op2);
            if (op1 > 0 && op2 > 0) {

                connection.commit();
                connection.setAutoCommit(true);
                hm.put("update_done", true);
            } else {
                connection.rollback();
                connection.setAutoCommit(true);
                hm.put("update_done", false);

            }

            update.add(hm);
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", update);
            response_string = mapper.writeValueAsString(response);
        } else if (request_name.equals("map_sensor")) {
            Map data_loading = (Map) request.getData();

            int op2 = 0, op1 = 0;
            connection.setAutoCommit(false);

            op1 = connection.createStatement().executeUpdate("WITH sensor_pick AS ( SELECT id_sensor FROM  sensor WHERE  type_sensor='" + (String) data_loading.get("type_sensor") + "' LIMIT  1) UPDATE sensor s SET is_available = false, id_gs=" + (Integer) data_loading.get("id_gs") + ", id_position=" + (Integer) data_loading.get("id_position") + "FROM sensor_pick WHERE  s.id_sensor = sensor_pick.id_sensor");
            op2 = connection.createStatement().executeUpdate("update positions set is_available=false where id_position=" + (Integer) data_loading.get("id_position"));
            List<Map> update = new ArrayList<Map>();
            logger.info(op1 + " " + op2);
            Map<String, Object> hm = new HashMap<String, Object>();
            if (op1 > 0 && op2 > 0) {
                logger.info(op1 + " " + op2);
                connection.commit();
                connection.setAutoCommit(true);
                hm.put("update_done", true);
            } else {
                connection.rollback();
                connection.setAutoCommit(true);
                hm.put("update_done", false);

            }
            update.add(hm);
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", update);
            response_string = mapper.writeValueAsString(response);
        } else if (request_name.equals("move_sensor")) {
            Map data_loading = (Map) request.getData();

            int op2 = 0, op1 = 0, op3 = 0;
            connection.setAutoCommit(false);

            op1 = connection.createStatement().executeUpdate("update sensor set id_position=" + (Integer) data_loading.get("new_position") + " where id_sensor=" + (Integer) data_loading.get("id_sensor"));
            op2 = connection.createStatement().executeUpdate("update positions set is_available=false where id_position=" + (Integer) data_loading.get("new_position"));
            op3 = connection.createStatement().executeUpdate("update positions set is_available=true where id_position=" + (Integer) data_loading.get("old_position"));
            List<Map> update = new ArrayList<Map>();
            logger.info(op1 + " " + op2 + " " + op3);
            Map<String, Object> hm = new HashMap<String, Object>();
            if (op1 > 0 && op2 > 0 && op3 > 0) {
                connection.commit();
                connection.setAutoCommit(true);
                hm.put("update_done", true);
            } else {
                connection.rollback();
                connection.setAutoCommit(true);
                hm.put("update_done", false);

            }
            update.add(hm);
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", update);
            response_string = mapper.writeValueAsString(response);
        } else if (request_name.equals("move_equipment")) {
            Map data_loading = (Map) request.getData();

            int op2 = 0, op1 = 0, op3 = 0;
            connection.setAutoCommit(false);

            op1 = connection.createStatement().executeUpdate("update equipment set id_position=" + (Integer) data_loading.get("new_position") + " where id_equipment=" + (Integer) data_loading.get("id_equipment"));
            op2 = connection.createStatement().executeUpdate("update positions set is_available=false where id_position=" + (Integer) data_loading.get("new_position"));
            op3 = connection.createStatement().executeUpdate("update positions set is_available=true where id_position=" + (Integer) data_loading.get("old_position"));
            List<Map> update = new ArrayList<Map>();
            logger.info(op1 + " " + op2 + " " + op3);
            Map<String, Object> hm = new HashMap<String, Object>();
            if (op1 > 0 && op2 > 0 && op3 > 0) {
                connection.commit();
                connection.setAutoCommit(true);
                hm.put("update_done", true);
            } else {
                connection.rollback();
                connection.setAutoCommit(true);
                hm.put("update_done", false);

            }
            update.add(hm);
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", update);
            response_string = mapper.writeValueAsString(response);
        } else if (request_name.equals("the_position")) {
            Map data_loading = (Map) request.getData();
            ResultSet rs1 = connection.createStatement().executeQuery("SELECT * FROM positions where id_position=" + (Integer) data_loading.get("id_position") + " Order by id_position");
            List<Map> positions = new ArrayList<Map>();
            while (rs1.next()) {
                Map<String, Object> hm = new HashMap<String, Object>();
                hm.put("id_position", rs1.getInt("id_position"));
                hm.put("longitude", rs1.getInt("longitude"));
                hm.put("latitude", rs1.getInt("latitude"));
                hm.put("id_workspace", rs1.getInt("id_workspace"));
                hm.put("position_type", rs1.getString("position_type"));
                hm.put("is_available", rs1.getBoolean("is_available"));
                positions.add(hm);
            }
            rs1.close();
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", positions);
            response_string = mapper.writeValueAsString(response);
        } else if (request_name.equals("the_workspace")) {
            Map data_loading = (Map) request.getData();
            ResultSet rs1 = connection.createStatement().executeQuery("SELECT * FROM workspace where id_workspace=" + (Integer) data_loading.get("id_workspace") + " Order by id_workspace");
            List<Map> workSpaces = new ArrayList<Map>();
            while (rs1.next()) {
                Map<String, Object> hm = new HashMap<String, Object>();
                hm.put("id_workspace", rs1.getInt("id_workspace"));
                hm.put("type_workspace", rs1.getString("type_workspace"));
                hm.put("floor_number", rs1.getInt("floor_number"));
                hm.put("is_available", rs1.getBoolean("is_available"));
                hm.put("id_building", rs1.getInt("id_building"));
                hm.put("id_gs", rs1.getInt("id_gs"));
                workSpaces.add(hm);
            }
            rs1.close();
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", workSpaces);
            response_string = mapper.writeValueAsString(response);
        } else if (request_name.equals("Info_position")) {
            Map data_loading = (Map) request.getData();
            ResultSet rs1 = connection.createStatement().executeQuery("SELECT * FROM positions where id_position=" + (Integer) data_loading.get("id_position"));
            List<Map> position = new ArrayList<Map>();
            while (rs1.next()) {
                Map<String, Object> hm = new HashMap<String, Object>();
                hm.put("id_position", rs1.getInt("id_position"));
                hm.put("longitude", rs1.getInt("longitude"));
                hm.put("latitude", rs1.getInt("latitude"));
                hm.put("id_workspace", rs1.getInt("id_workspace"));
                hm.put("position_type", rs1.getString("position_type"));
                hm.put("is_available", rs1.getBoolean("is_available"));
                position.add(hm);
            }
            rs1.close();
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", position);
            response_string = mapper.writeValueAsString(response);
        } else if (request_name.equals("workspace_and_positions")) {
            Map data_loading = (Map) request.getData();
            ResultSet rs1 = connection.createStatement().executeQuery("select * from workspace w ,positions p where  w.id_gs=" + (Integer) data_loading.get("id_gs") + " and w.id_workspace=p.id_workspace and p.id_position=" + (Integer) data_loading.get("id_position"));
            List<Map> workspace = new ArrayList<Map>();
            while (rs1.next()) {
                Map<String, Object> hm = new HashMap<String, Object>();
                hm.put("id_workspace", rs1.getInt(1));
                hm.put("type_workspace", rs1.getString(2));
                hm.put("floor_number", rs1.getInt(5));
                hm.put("is_available_ws", rs1.getBoolean(6));
                hm.put("id_building", rs1.getInt("id_building"));
                hm.put("id_gs", rs1.getInt(7));
                //---------------------------------------------------
                hm.put("id_position", rs1.getInt("id_position"));
                hm.put("longitude", rs1.getInt(9));
                hm.put("latitude", rs1.getInt(10));
                hm.put("id_ws", rs1.getInt(11));
                hm.put("type_position", rs1.getString(12));
                hm.put("is_available_pos", rs1.getBoolean(13));
                workspace.add(hm);
            }
            rs1.close();
            logger.info((Integer) data_loading.get("id_position") + "");
            logger.info(workspace.toString());
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", workspace);
            response_string = mapper.writeValueAsString(response);
        } else if (request_name.equals("my_equipment")) {
            Map data_loading = (Map) request.getData();
            ResultSet rs1 = connection.createStatement().executeQuery("SELECT * FROM equipment where id_position=" + (Integer) data_loading.get("id_position") + " Order by id_equipment");
            List<Map> equipments = new ArrayList<Map>();
            while (rs1.next()) {
                Map<String, Object> hm = new HashMap<String, Object>();
                hm.put("id_equipment", rs1.getInt("id_equipment"));
                hm.put("type_equipment", rs1.getString("type_equipment"));
                hm.put("is_available", rs1.getBoolean("is_available"));
                hm.put("is_working", rs1.getBoolean("is_working"));
                hm.put("id_gs", rs1.getInt("id_gs"));
                hm.put("id_position", rs1.getInt("id_position"));
                equipments.add(hm);
            }
            rs1.close();
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", equipments);
            response_string = mapper.writeValueAsString(response);
        } else if (request_name.equals("my_sensor")) {
            Map data_loading = (Map) request.getData();
            ResultSet rs1 = connection.createStatement().executeQuery("SELECT * FROM sensor where id_position=" + (Integer) data_loading.get("id_position"));
            List<Map> sensors = new ArrayList<Map>();
            while (rs1.next()) {
                Map<String, Object> hm = new HashMap<String, Object>();
                hm.put("id_sensor", rs1.getInt("id_sensor"));
                hm.put("type_sensor", rs1.getString("type_sensor"));
                hm.put("is_available", rs1.getBoolean("is_available"));
                hm.put("is_working", rs1.getBoolean("is_working"));
                hm.put("id_gs", rs1.getInt("id_gs"));
                hm.put("id_position", rs1.getInt("id_position"));
                sensors.add(hm);
            }
            rs1.close();
            logger.info(sensors.toString());
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", sensors);
            response_string = mapper.writeValueAsString(response);
        } else if (request_name.equals("request_workspace")) {
            Map data_loading = (Map) request.getData();
            String floor_type = (String) data_loading.get("type_floor");
            ResultSet rs1 = null;
            if (floor_type.equals("sans importance")) {
                rs1 = connection.createStatement().executeQuery("SELECT * FROM workspace where is_available=true and type_workspace='"
                        + (String) data_loading.get("type_workspace") + "'");
            } else if (floor_type.equals("haut")) {
                rs1 = connection.createStatement().executeQuery("SELECT * FROM workspace where is_available=true and type_workspace='"
                        + (String) data_loading.get("type_workspace") + "' and floor_number > 2");
            } else if (floor_type.equals("bas")) {
                rs1 = connection.createStatement().executeQuery("SELECT * FROM workspace where is_available=true and type_workspace='"
                        + (String) data_loading.get("type_workspace") + "' and floor_number < 3");
            }
            List<Map> workSpaces = new ArrayList<Map>();
            while (rs1.next()) {
                Map<String, Object> hm = new HashMap<String, Object>();
                hm.put("id_workspace", rs1.getInt("id_workspace"));
                hm.put("type_workspace", rs1.getString("type_workspace"));
                hm.put("floor_number", rs1.getInt("floor_number"));
                hm.put("is_available", rs1.getBoolean("is_available"));
                hm.put("id_building", rs1.getInt("id_building"));
                hm.put("id_gs", rs1.getInt("id_gs"));
                workSpaces.add(hm);
            }
            rs1.close();
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", workSpaces);
            response_string = mapper.writeValueAsString(response);
        } else if (request_name.equals("set_workspace_unavailable")) {
            Map data_loading = (Map) request.getData();
            System.out.println("ws " + (Integer) data_loading.get("id_workspace"));
            System.out.println("gs " + (Integer) data_loading.get("id_gs"));
            int op1 = connection.createStatement().executeUpdate("UPDATE workspace SET is_available = false,id_gs=+" + (Integer) data_loading.get("id_gs") + " where id_workspace=" + (Integer) data_loading.get("id_workspace"));
            Map<String, Object> response = new HashMap<String, Object>();
            List<Map> update = new ArrayList<Map>();
            Map<String, Object> hm = new HashMap<String, Object>();
            System.out.println("op1 " + op1);
            hm.put("updated", op1);
            update.add(hm);
            response.put("name_request", request_name);
            response.put("data", update);
            response_string = mapper.writeValueAsString(response);
        } // Mohand Part about access cards management
        // Looking for all access cards
        else if (request_name.equals("list_of_access_cards")) {
            Map data_loading = (Map) request.getData();
            ResultSet rs2 = connection.createStatement().executeQuery("SELECT * FROM accesscard");
            List<Map> accesscard = new ArrayList<Map>();
            while (rs2.next()) {
                Map<String, Object> hm = new HashMap<String, Object>();
                hm.put("id_accessCard", rs2.getInt("id_accessCard"));
                hm.put("type_card", rs2.getInt("type_card"));
                hm.put("status_card", rs2.getInt("status_card"));
                hm.put("id_matricule", rs2.getString("id_matricule"));
                hm.put("id_empowerment", rs2.getString("id_empowerment"));
                hm.put("id_accessLevel", rs2.getBoolean("id_accessLevel"));
                accesscard.add(hm);
            }
            rs2.close();
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", accesscard);
            response_string = mapper.writeValueAsString(response);
        } // Looking for a specific access card
        else if (request_name.equals("list_of_access_cards")) {
            Map data_loading = (Map) request.getData();
            ResultSet rs2 = connection.createStatement().executeQuery("SELECT * FROM accesscard where id_accessCard= " + (Integer) data_loading.get("id_accessCard"));
            List<Map> accesscard = new ArrayList<Map>();
            while (rs2.next()) {
                Map<String, Object> hm = new HashMap<String, Object>();
                hm.put("id_accessCard", rs2.getInt("id_accessCard"));
                hm.put("type_card", rs2.getString("type_card"));
                hm.put("status_card", rs2.getString("status_card"));
                hm.put("id_matricule", rs2.getInt("id_matricule"));
                hm.put("id_empowerment", rs2.getInt("id_empowerment"));
                hm.put("id_accessLevel", rs2.getInt("id_accessLevel"));
                accesscard.add(hm);
            }
            rs2.close();
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", accesscard);
            response_string = mapper.writeValueAsString(response);

        } // Create a badge
        else if (request_name.equals("list_of_access_cards")) {
            Map data_loading = (Map) request.getData();
            int nb = connection.createStatement().executeUpdate("insert into AccessCard (id_accesscard, type_card, status_card, id_matricule, id_generalservices, id_empowerment, id_token, id_accesslevel) values ("
                    + (Integer) data_loading.get("id_accessCard") + ","
                    + (String) data_loading.get("type_card") + ","
                    + (String) data_loading.get("status_card") + ","
                    + (Integer) data_loading.get("id_matricule") + ","
                    + (Integer) data_loading.get("id_generalservices") + ","
                    + (Integer) data_loading.get("id_empowerment") + ","
                    + (Integer) data_loading.get("id_token") + ","
                    + (Integer) data_loading.get("id_accesslevel"));
            List<Map> accesscard = new ArrayList<Map>();

            Map<String, Object> hm = new HashMap<String, Object>();
            if (nb > 0) {
                hm.put("id_deleted", true);
            } else {
                hm.put("id_deleted", false);
            }
            accesscard.add(hm);

            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", accesscard);
            response_string = mapper.writeValueAsString(response);
        } // Delete Badge
        else if (request_name.equals("list_of_access_cards")) {
            Map data_loading = (Map) request.getData();
            int nb = connection.createStatement().executeUpdate("DELETE FROM accesscard where id_accessCard" + (Integer) data_loading.get("id_accessCard"));
            List<Map> accesscard = new ArrayList<Map>();

            Map<String, Object> hm = new HashMap<String, Object>();
            if (nb > 0) {
                hm.put("id_deleted", true);
            } else {
                hm.put("id_deleted", false);
            }
            accesscard.add(hm);

            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", accesscard);
            response_string = mapper.writeValueAsString(response);
        } // Update badge
        else if (request_name.equals("list_of_access_cards")) {
            Map data_loading = (Map) request.getData();
            int nb = connection.createStatement().executeUpdate("UPDATE accessCard "
                    + " SET id_accessLevel =" + (Integer) data_loading.get("id_accessLevel")
                    + "where id_matricule " + (Integer) data_loading.get("id_matricule"));
            List<Map> accesscard = new ArrayList<Map>();

            Map<String, Object> hm = new HashMap<String, Object>();
            if (nb > 0) {
                hm.put("id_deleted", true);
            } else {
                hm.put("id_deleted", false);
            }
            accesscard.add(hm);

            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", accesscard);
            response_string = mapper.writeValueAsString(response);
        } // Badge status
        else if (request_name.equals("list_of_access_cards")) {
            Map data_loading = (Map) request.getData();
            String status_card = (String) data_loading.get("status_card");
            ResultSet rs2 = null;
            if (status_card.equals("KO")) {
                rs2 = connection.createStatement().executeQuery("SELECT * FROM accesscard where id_accessCard=" + (Integer) data_loading.get("id_accessCard") + "and where status_card =" + "KO ");
            }
            if (status_card.equals("OK")) {
                rs2 = connection.createStatement().executeQuery("SELECT * FROM accesscard where id_accessCard=" + (Integer) data_loading.get("id_accessCard") + "and where status_card =" + "OK ");
            }
            if (status_card.equals("Warning")) {
                rs2 = connection.createStatement().executeQuery("SELECT * FROM accesscard where id_accessCard=" + (Integer) data_loading.get("id_accessCard") + "and where status_card =" + "Warning");
            }
            List<Map> workSpaces = new ArrayList<Map>();
            while (rs2.next()) {
                Map<String, Object> hm = new HashMap<String, Object>();
                hm.put("id_accessCard", rs2.getInt("id_accessCard"));
                hm.put("type_card", rs2.getInt("type_card"));
                hm.put("status_card", rs2.getInt("status_card"));
                hm.put("id_matricule", rs2.getString("id_matricule"));
                hm.put("id_empowerment", rs2.getString("id_empowerment"));
                hm.put("id_accessLevel", rs2.getBoolean("id_accessLevel"));
                workSpaces.add(hm);
            }
            rs2.close();
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", workSpaces);
            response_string = mapper.writeValueAsString(response);
        } // End Mohand's part
        //Coumba's part
        else if (request_name.equals("own_equipment")) {
            Map data_loading = (Map) request.getData();
            ResultSet rs1 = connection.createStatement().executeQuery("SELECT * FROM Equipment WHERE id_gs = " + (Integer) data_loading.get("id_gs") + " ORDER BY id_equipment");
            List<Map> equipments = new ArrayList<Map>();
            while (rs1.next()) {
                Map<String, Object> hm = new HashMap<String, Object>();
                hm.put("id_equipment", rs1.getInt("id_equipment"));
                hm.put("type_equipment", rs1.getString("type_equipment"));
                hm.put("is_available", rs1.getBoolean("is_available"));
                hm.put("is_working", rs1.getBoolean("is_working"));
                hm.put("id_gs", rs1.getInt("id_gs"));
                hm.put("id_position", rs1.getInt("id_position"));
                equipments.add(hm);
            }
            rs1.close();
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", equipments);
            response_string = mapper.writeValueAsString(response);
        } else if (request_name.equals("own_windows")) {
            Map data_loading = (Map) request.getData();
            ResultSet rs1 = connection.createStatement().executeQuery("SELECT * FROM Equipment WHERE id_gs = " + (Integer) data_loading.get("id_gs") + " AND type_equipment = 'fenetre electro-chromatique' ORDER BY id_equipment ");
            List<Map> windows = new ArrayList<Map>();
            while (rs1.next()) {
                Map<String, Object> hm = new HashMap<String, Object>();
                hm.put("id_equipment", rs1.getInt("id_equipment"));
                hm.put("type_equipment", rs1.getString("type_equipment"));
                hm.put("is_available", rs1.getBoolean("is_available"));
                hm.put("is_working", rs1.getBoolean("is_working"));
                hm.put("id_gs", rs1.getInt("id_gs"));
                hm.put("id_position", rs1.getInt("id_position"));
                windows.add(hm);
            }
            rs1.close();
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", windows);
            response_string = mapper.writeValueAsString(response);
        } else if (request_name.equals("default_status")) {
            Map data_loading = (Map) request.getData();
            ResultSet rs1 = connection.createStatement().executeQuery("SELECT * FROM Windows WHERE id_equipment = " + (Integer) data_loading.get("id_equipment") + " LIMIT 1 ");
            List<Map> windowStatus = new ArrayList<Map>();
            while (rs1.next()) {
                Map<String, Object> hm = new HashMap<String, Object>();
                hm.put("id_windows", rs1.getInt("id_windows"));
                hm.put("status", rs1.getString("status"));
                hm.put("temperature", rs1.getInt("temperature"));
                hm.put("light", rs1.getString("light"));
                hm.put("blind", rs1.getString("blind"));
                hm.put("opacity", rs1.getString("opacity"));
                hm.put("id_equipment", rs1.getInt("id_equipment"));
                windowStatus.add(hm);
            }
            rs1.close();
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", windowStatus);
            response_string = mapper.writeValueAsString(response);
        } else if (request_name.equals("get_window")) {
            Map data_loading = (Map) request.getData();
            ResultSet rs1 = connection.createStatement().executeQuery("SELECT * FROM Windows WHERE id_equipment = " + (Integer) data_loading.get("id_equipment") + " ");
            List<Map> window = new ArrayList<Map>();
            while (rs1.next()) {
                Map<String, Object> hm = new HashMap<String, Object>();
                hm.put("id_windows", rs1.getInt("id_windows"));
                hm.put("status", rs1.getString("status"));
                hm.put("temperature", rs1.getInt("temperature"));
                hm.put("light", rs1.getString("light"));
                hm.put("blind", rs1.getString("blind"));
                hm.put("opacity", rs1.getString("opacity"));
                hm.put("id_equipment", rs1.getInt("id_equipment"));
                window.add(hm);
            }
            rs1.close();
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", window);
            response_string = mapper.writeValueAsString(response);
        } else if (request_name.equals("get_temperature")) {
            Map data_loading = (Map) request.getData();
            ResultSet rs1 = connection.createStatement().executeQuery("SELECT * FROM Temperature WHERE id_windows = " + (Integer) data_loading.get("id_windows") + " ");
            List<Map> temperature = new ArrayList<Map>();
            while (rs1.next()) {
                Map<String, Object> hm = new HashMap<String, Object>();
                hm.put("id_temperature", rs1.getInt("id_temperature"));
                hm.put("degree", rs1.getInt("degree"));
                hm.put("id_windows", rs1.getInt("id_windows"));
                temperature.add(hm);
            }
            rs1.close();
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", temperature);
            response_string = mapper.writeValueAsString(response);
        } //				if ( rs1.getInt("degree") < 18 ) {
        //					op = connection.createStatement().executeUpdate(" UPDATE Windows SET status = 'Ferme' were id_windows = "+(Integer)data_loading.get("id_windows")+" ");
        //					}
        //					
        //				else if (rs1.getInt("degree")>=18 || rs1.getInt("degree")<22 ) {
        //					op = connection.createStatement().executeUpdate(" UPDATE Windows SET status = 'Ouvert A Moitie' were id_windows = "+(Integer)data_loading.get("id_windows")+" ");
        //					}
        //					
        //				else if (rs1.getInt("degree")>=22) {
        //					op = connection.createStatement().executeUpdate(" UPDATE Windows SET status = 'Ouvert' were id_windows = "+(Integer)data_loading.get("id_windows")+" ");
        //					}
        //				switch(op) {
        //				case 1:
        //				{
        //					connection.commit();
        //					connection.setAutoCommit(true);
        //					update = true;
        //					 break;
        //				}
        //				
        //				default:
        //				{
        //					connection.rollback();
        //					connection.setAutoCommit(true);
        //					update = false;
        //
        //				}
        //					
        //				}
        //
        //hm.put("id_windows",rs1.getInt("id_windows"));
        else if (request_name.equals("get_light")) {
            Map data_loading = (Map) request.getData();
            ResultSet rs1 = connection.createStatement().executeQuery("SELECT * FROM Lighting WHERE id_windows = " + (Integer) data_loading.get("id_windows") + " ");
            List<Map> light = new ArrayList<Map>();
            while (rs1.next()) {
                Map<String, Object> hm = new HashMap<String, Object>();
                hm.put("id_light", rs1.getInt("id_light"));
                hm.put("level", rs1.getString("level"));
                hm.put("id_windows", rs1.getInt("id_windows"));
                light.add(hm);
            }
            rs1.close();
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", light);
            response_string = mapper.writeValueAsString(response);
        } //				if (rs1.getString("level").equals("Aucun")) {
        //					op = connection.createStatement().executeUpdate(" UPDATE Windows SET blind = 'Niveau 0', opacity = 'Aucun' where id_windows = "+(Integer)data_loading.get("id_windows")+" ");
        //				}
        //				else if (rs1.getString("level").equals("Faible")) {
        //					op = connection.createStatement().executeUpdate(" UPDATE Windows SET blind = 'Niveau 1', opacity = 'Faible' where id_windows = "+(Integer)data_loading.get("id_windows")+" ");
        //					}
        //				else if (rs1.getString("level").equals("Moyen")) {
        //					op = connection.createStatement().executeUpdate(" UPDATE Windows SET blind = 'Niveau 2', opacity = 'Moyen' where id_windows = "+(Integer)data_loading.get("id_windows")+" ");
        //					}
        //				else if (rs1.getString("level").equals("Fort")) {
        //					op = connection.createStatement().executeUpdate(" UPDATE Windows SET blind = 'Niveau 3', opacity = 'Fort' where id_windows = "+(Integer)data_loading.get("id_windows")+" ");
        //					}
        //				else if(rs1.getString("level").equals("Autre")) {
        //					op = connection.createStatement().executeUpdate(" UPDATE Windows SET blind = 'Niveau 4', opacity = 'Fort' where id_windows = "+(Integer)data_loading.get("id_windows")+" ");
        //					}
        //				
        //				switch(op) {
        //				case 1:
        //				{
        //					connection.commit();
        //					connection.setAutoCommit(true);
        //					update = true;
        //					 break;
        //				}
        //				
        //				default:
        //				{
        //					connection.rollback();
        //					connection.setAutoCommit(true);
        //					update = false;
        //
        //				}
        //					
        //				}
        //				
        //				  case "Faible":
        //					  update = WindowsTable.windowsUpdateForLightLevelFaible(connection, id_win);
        //					  break;
        //				  case "Moyen":
        //					  update = WindowsTable.windowsUpdateForLightLevelMoyen(connection, id_win);
        //					  break;
        //				  case "Fort":
        //					  update = WindowsTable.windowsUpdateForLightLevelFort(connection, id_win);
        //					  break;
        //				  default:
        //					  update = WindowsTable.windowsUpdateForLightLevelAutre(connection, id_win);
        //hm.put("id_windows",rs1.getInt("id_windows"));
        else if (request_name.equals("light_aucun")) {
            Map data_loading = (Map) request.getData();

            int op = 0;
            connection.setAutoCommit(false);

            op = connection.createStatement().executeUpdate(" UPDATE Windows SET blind = 'Niveau 0', opacity = 'Aucun' where id_windows = " + (Integer) data_loading.get("id_windows") + " ");
            List<Map> update = new ArrayList<Map>();
            logger.info(op + " " + op);
            Map<String, Object> hm = new HashMap<String, Object>();
            if (op > 0) {
                connection.commit();
                connection.setAutoCommit(true);
                hm.put("update_done", true);
            } else {
                connection.rollback();
                connection.setAutoCommit(true);
                hm.put("not_done", false);

            }
            update.add(hm);
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", update);
            response_string = mapper.writeValueAsString(response);
        } else if (request_name.equals("light_faible")) {
            Map data_loading = (Map) request.getData();

            int op = 0;
            connection.setAutoCommit(false);

            op = connection.createStatement().executeUpdate(" UPDATE Windows SET blind = 'Niveau 1', opacity = 'Faible' where id_windows = " + (Integer) data_loading.get("id_windows") + " ");
            List<Map> update = new ArrayList<Map>();
            logger.info(op + " " + op);
            Map<String, Object> hm = new HashMap<String, Object>();
            if (op > 0) {
                connection.commit();
                connection.setAutoCommit(true);
                hm.put("update_done", true);
            } else {
                connection.rollback();
                connection.setAutoCommit(true);
                hm.put("not_done", false);

            }
            update.add(hm);
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", update);
            response_string = mapper.writeValueAsString(response);
        } else if (request_name.equals("light_moyen")) {
            Map data_loading = (Map) request.getData();

            int op = 0;
            connection.setAutoCommit(false);

            op = connection.createStatement().executeUpdate(" UPDATE Windows SET blind = 'Niveau 2', opacity = 'Moyen' where id_windows = " + (Integer) data_loading.get("id_windows") + " ");
            List<Map> update = new ArrayList<Map>();
            logger.info(op + " " + op);
            Map<String, Object> hm = new HashMap<String, Object>();
            if (op > 0) {
                connection.commit();
                connection.setAutoCommit(true);
                hm.put("update_done", true);
            } else {
                connection.rollback();
                connection.setAutoCommit(true);
                hm.put("not_done", false);

            }
            update.add(hm);
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", update);
            response_string = mapper.writeValueAsString(response);
        } else if (request_name.equals("light_fort")) {
            Map data_loading = (Map) request.getData();

            int op = 0;
            connection.setAutoCommit(false);

            op = connection.createStatement().executeUpdate(" UPDATE Windows SET blind = 'Niveau 3', opacity = 'Fort' where id_windows = " + (Integer) data_loading.get("id_windows") + " ");
            List<Map> update = new ArrayList<Map>();
            logger.info(op + " " + op);
            Map<String, Object> hm = new HashMap<String, Object>();
            if (op > 0) {
                connection.commit();
                connection.setAutoCommit(true);
                hm.put("update_done", true);
            } else {
                connection.rollback();
                connection.setAutoCommit(true);
                hm.put("not_done", false);

            }
            update.add(hm);
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", update);
            response_string = mapper.writeValueAsString(response);
        } else if (request_name.equals("light_autre")) {
            Map data_loading = (Map) request.getData();

            int op = 0;
            connection.setAutoCommit(false);

            op = connection.createStatement().executeUpdate(" UPDATE Windows SET blind = 'Niveau 4', opacity = 'Fort' where id_windows = " + (Integer) data_loading.get("id_windows") + " ");
            List<Map> update = new ArrayList<Map>();
            logger.info(op + " " + op);
            Map<String, Object> hm = new HashMap<String, Object>();
            if (op > 0) {
                connection.commit();
                connection.setAutoCommit(true);
                hm.put("update_done", true);
            } else {
                connection.rollback();
                connection.setAutoCommit(true);
                hm.put("not_done", false);

            }
            update.add(hm);
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", update);
            response_string = mapper.writeValueAsString(response);
        } else if (request_name.equals("less_than_18")) {
            Map data_loading = (Map) request.getData();

            int op = 0;
            connection.setAutoCommit(false);

            op = connection.createStatement().executeUpdate(" UPDATE Windows SET status = 'Ferme' were id_windows = " + (Integer) data_loading.get("id_windows") + " ");
            List<Map> update = new ArrayList<Map>();
            logger.info(op + " " + op);
            Map<String, Object> hm = new HashMap<String, Object>();
            if (op > 0) {
                connection.commit();
                connection.setAutoCommit(true);
                hm.put("update_done", true);
            } else {
                connection.rollback();
                connection.setAutoCommit(true);
                hm.put("not_done", false);

            }
            update.add(hm);
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", update);
            response_string = mapper.writeValueAsString(response);
        } else if (request_name.equals("between_18_22")) {
            Map data_loading = (Map) request.getData();

            int op = 0;
            connection.setAutoCommit(false);

            op = connection.createStatement().executeUpdate(" UPDATE Windows SET status = 'Ouvert A Moitie' were id_windows = " + (Integer) data_loading.get("id_windows") + " ");
            List<Map> update = new ArrayList<Map>();
            logger.info(op + " " + op);
            Map<String, Object> hm = new HashMap<String, Object>();
            if (op > 0) {
                connection.commit();
                connection.setAutoCommit(true);
                hm.put("update_done", true);
            } else {
                connection.rollback();
                connection.setAutoCommit(true);
                hm.put("not_done", false);

            }
            update.add(hm);
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", update);
            response_string = mapper.writeValueAsString(response);
        } else if (request_name.equals("more_than_22")) {
            Map data_loading = (Map) request.getData();

            int op = 0;
            connection.setAutoCommit(false);

            op = connection.createStatement().executeUpdate(" UPDATE Windows SET status = 'Ouvert' were id_windows = " + (Integer) data_loading.get("id_windows") + " ");
            List<Map> update = new ArrayList<Map>();
            logger.info(op + " " + op);
            Map<String, Object> hm = new HashMap<String, Object>();
            if (op > 0) {
                connection.commit();
                connection.setAutoCommit(true);
                hm.put("update_done", true);
            } else {
                connection.rollback();
                connection.setAutoCommit(true);
                hm.put("not_done", false);

            }
            update.add(hm);
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", update);
            response_string = mapper.writeValueAsString(response);
        } else if (request_name.equals("updated_status")) {
            Map data_loading = (Map) request.getData();
            ResultSet rs1 = connection.createStatement().executeQuery("SELECT * FROM Windows WHERE id_windows = " + (Integer) data_loading.get("id_windows") + " ");
            List<Map> windowStatus = new ArrayList<Map>();
            while (rs1.next()) {
                Map<String, Object> hm = new HashMap<String, Object>();
                hm.put("id_windows", rs1.getInt("id_windows"));
                hm.put("status", rs1.getString("status"));
                hm.put("temperature", rs1.getInt("temperature"));
                hm.put("light", rs1.getString("light"));
                hm.put("blind", rs1.getString("blind"));
                hm.put("opacity", rs1.getString("opacity"));
                hm.put("id_equipment", rs1.getInt("id_equipment"));
                windowStatus.add(hm);
            }
            rs1.close();
            Map<String, Object> response = new HashMap<String, Object>();
            response.put("name_request", request_name);
            response.put("data", windowStatus);
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
