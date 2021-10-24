package edu.ing1.pds.vsc.client;

import java.io.*;
import java.net.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientToServer {

    private final static Logger logger = LoggerFactory.getLogger(ClientToServer.class.getName());

    public Socket client;
    private PrintWriter out;
    private BufferedReader in;
    private ObjectMapper mapper = new ObjectMapper();

    public Request SendRequest(Request req) throws Exception {
        String request = mapper.writeValueAsString(req);
        out = new PrintWriter(client.getOutputStream(), true);
        out.println(request);
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String responseString = in.readLine();
        Request response = mapper.readValue(responseString, Request.class);
        return response;
    }

    public ClientToServer() {
        try {
            String serverAdress = "172.31.249.198"; //InetAddress.getLocalHost();
            client = new Socket(serverAdress, 1099);
        } catch (Exception e) {
            logger.error("erreur");
            e.printStackTrace();
        }
    }
}
