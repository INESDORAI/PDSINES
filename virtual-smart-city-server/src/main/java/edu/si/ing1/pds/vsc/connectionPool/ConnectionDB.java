package edu.si.ing1.pds.vsc.connectionPool;

import java.io.*;
import java.sql.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class ConnectionDB {

    private static final String data_smart_city_enVar = "SMART_CITY_SERVER";
    private Config config = null;
    public Connection connection;
    //the builder

    public ConnectionDB() {
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            config = mapper.readValue(new File(System.getenv(data_smart_city_enVar)), Config.class);
            mapper = new ObjectMapper();
            Class.forName(config.getDriver());
            this.connection = DriverManager.getConnection(config.getURL(),config.getUsername(), config.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
