package edu.ing1.pds.vsc.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import org.apache.log4j.Logger;

public class ClientConfig {

    private final static Logger logger = Logger.getLogger(Client.class);

    private static final String episenClientConfigEnVar = "SMART_CITY";
    private final String episenClientConfigFileLocation;
    private ClientCoreConfig config;

    public ClientCoreConfig getConfig() {
        return config;
    }

    public ClientConfig() throws IOException {
        this.episenClientConfigFileLocation = System.getenv(episenClientConfigEnVar);
        logger.debug("Config file = " + episenClientConfigFileLocation);
        final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        config = mapper.readValue(new File(episenClientConfigFileLocation), ClientCoreConfig.class);
        logger.debug("Config = " + config.toString());
    }
}
