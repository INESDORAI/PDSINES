package edu.si.ing1.pds.vsc.connectionPool;

import java.io.*;
import java.sql.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionDB {

    private final static Logger logger = LoggerFactory.getLogger(ConnectionDB.class.getName());

    private static final String dataSmartCityEnVar = "SMART_CITY_SERVER";
    private Config config = null;
    public Connection connection;
    //the builder

    public ConnectionDB() {
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            config = mapper.readValue(new File(System.getenv(dataSmartCityEnVar)), Config.class);
            mapper = new ObjectMapper();
            Class.forName(config.getDriver());
            this.connection = DriverManager.getConnection(config.getURL(),config.getUsername(), config.getPassword());
        } catch (Exception e) {
            logger.error("Erreur.....");
            e.printStackTrace();
        }
    }
}
