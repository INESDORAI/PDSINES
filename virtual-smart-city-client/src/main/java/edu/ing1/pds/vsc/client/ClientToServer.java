package edu.ing1.pds.vsc.client;

import java.io.*;
import java.net.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

public class ClientToServer {

    private final static Logger logger = Logger.getLogger(ClientToServer.class);

    public Socket client;
    private PrintWriter out;
    private BufferedReader in;
    private ObjectMapper mapper = new ObjectMapper();

    public Request sendRequest(Request req) throws Exception {
        String request = mapper.writeValueAsString(req);
        logger.info("+++request++" + request);
        out = new PrintWriter(client.getOutputStream(), true);
        out.println(request);
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String responseString = responseString = in.readLine();
        logger.info("+++request++" + request);
        logger.info("+++responseString++" + responseString);
        Request response = mapper.readValue(responseString, Request.class);
        this.close();
        return response;
    }

    public ClientToServer() {
        try {
       String serverAdress = "172.31.249.246"; //InetAddress.getLocalHost();
          //  String serverAdress = "127.0.0.1"; //InetAddress.getLocalHost();
            client = new Socket(serverAdress, 1099);
        } catch (Exception e) {
            logger.error("erreur");
            e.printStackTrace();
        }
    }

    public void close() throws IOException {
        out.close();
        in.close();
        client.close();
    }
}
