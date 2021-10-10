package edu.si.ing1.pds.vsc.server;

import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import edu.si.ing1.pds.vsc.connectionPool.Config;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;

public class ServerConfig {

    private final static Logger logger = LoggerFactory.getLogger(ServerConfig.class.getName());
    private static final String episenServerConfigEnVar = "SMART_CITY";
    private final String episenServerConfigFileLocation;
    private Config config;

    public Config getConfig() {
        return config;
    }

    public ServerConfig() throws IOException {
        this.episenServerConfigFileLocation = System.getenv(episenServerConfigEnVar);
        logger.debug("Config file = {} ", episenServerConfigFileLocation);
        final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        config = mapper.readValue(new File(episenServerConfigFileLocation), Config.class);

    }
}
