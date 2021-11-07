package edu.si.ing1.pds.vsc.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

public class ClientRequestManager implements Runnable {

    private final static Logger logger = Logger.getLogger(ClientRequestManager.class);

    private InputStream inputStream = null;
    private OutputStream outputStream = null;
    private final static String name = "client-thread-manager";
    private Thread self;

    public ClientRequestManager(final Socket socket) throws IOException {

        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();
        self = new Thread(this, name);
        self.start();

    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        byte[] inputData;
        try {
            inputData = new byte[inputStream.available()];
            inputStream.read(inputData);
            logger.debug("data length is " + inputData.length + "and data content=" + new String(inputData));

            final ObjectMapper mapper = new ObjectMapper();
            final Map<String, String> result = new HashMap<>();
            result.put("Result", "OK");
            outputStream.write(mapper.writeValueAsBytes(result));

        } catch (IOException e) {
            logger.error("Erreur .....run.....");
        }
    }
}
