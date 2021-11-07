package edu.si.ing1.pds.vsc.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.si.ing1.pds.vsc.connectionPool.DataSource;
import edu.si.ing1.pds.vsc.connectionPool.Request;
import edu.si.ing1.pds.vsc.service.ServerToClient;
import org.apache.log4j.Logger;

public class SmartCityAppServer extends Thread {

    private final static Logger logger = Logger.getLogger(SmartCityAppServer.class);

    private static int nbreConnexion;
    public static int maxConnectionInit = 20;
    public static int connectionDurationInit = 5000;
    public static DataSource ds = new DataSource(maxConnectionInit, connectionDurationInit);
    //ServerSocket server;
    public ServerToClient connection = new ServerToClient(ds);
    public Socket client;
    public static ServerConfig serverConfig;

    static ServerSocket myServerSocket;
    static boolean ServerOn = true;

    public SmartCityAppServer(Socket clientSocket, int nbreConn) {
        client = clientSocket;
        nbreConnexion = nbreConn;
    }

    @Override
    public void run() {
        nbreConnexion++;
        BufferedReader in = null;
        PrintWriter out = null;
        logger.info("Accepted Client Address - " + client.getInetAddress().getHostName());
        try {
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));

            while (ds.getUsedConnection() < maxConnectionInit) {
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                if (in.ready()) {
                    String operation = in.readLine();
                    ObjectMapper mapper = new ObjectMapper();
                    logger.info(operation);
                    Request request = mapper.readValue(operation, Request.class);
                    String response = connection.sendResponse(request);
                    out = new PrintWriter(client.getOutputStream(), true);
                    out.println(response);
                    logger.info("*******\n ");
                }
            }
        } catch (Exception e) {
            logger.error("Erreur ...run SmartCityAppServer....");
        } finally {
            try {
                in.close();
                out.close();
                client.close();
                logger.info("......Stopped");
                nbreConnexion--;
                logger.info("nbreConnexion: " + nbreConnexion);
            } catch (IOException ioe) {
                logger.error("Erreur...finally SmartCityAppServer...");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        //connection pool configuration

        //   serverConfig = new ServerConfig();
        Options options = new Options();
        Option maxConnection = new Option("mc", "maxConnection", true, "the number of connections that we could possibly create to be used");
        Option connectionDuration = new Option("cd", "connectionDuration", true, "the duration accorded to the user to connect to the database");

        options.addOption(maxConnection);

        options.addOption(connectionDuration);
        maxConnection.setRequired(true);
        connectionDuration.setRequired(true);
        //     operation.setRequired(true);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine commandLine = parser.parse(options, args);

        if (commandLine.hasOption("maxConnection")) {
            maxConnectionInit = Integer.parseInt(commandLine.getOptionValue("maxConnection"));
        }

        if (commandLine.hasOption("connectionDuration")) {
            connectionDurationInit = Integer.parseInt(commandLine.getOptionValue("connectionDuration"));
        }

        logger.info("VSC Application is running, maximal_connection= " + maxConnectionInit + " & connectionDuration = " + connectionDurationInit + ".");

        //connection pool created
        ds = new DataSource(maxConnectionInit, connectionDurationInit);

        try {
            myServerSocket = new ServerSocket(1099);
            logger.info("port: " + myServerSocket.getLocalPort());
        } catch (IOException ioe) {
            logger.error("Could not create server socket on port " + myServerSocket.getLocalPort() + ". Quitting.");
            System.exit(-1);
        }

        while (ServerOn) {

            try {

                Socket clientSocket = myServerSocket.accept();

                SmartCityAppServer cliThread = new SmartCityAppServer(clientSocket, ds.getUsedConnection());
                if (ds.getUsedConnection() < maxConnectionInit) {
                    cliThread.start();
                    logger.info("nbreConnexion : " + (ds.getUsedConnection() + 1));
                    logger.info("Serveur est en ecoute .......");
                } else {
                    cliThread.client.close();
                    logger.info("nbreConnexion : " + ds.getUsedConnection());
                    logger.info("Serveur est maximum de connection");
                }
            } catch (IOException ioe) {
                logger.error("Exception found on accept. Ignoring. Stack Trace :" + ioe.getMessage());
            }

        }
        try {
            myServerSocket.close();
            logger.info("Server Stopped...");
        } catch (Exception ioe) {
            logger.error("Error Found stopping server socket");
            System.exit(-1);
        }
    }
}
