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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.si.ing1.pds.vsc.connectionPool.DataSource;
import edu.si.ing1.pds.vsc.connectionPool.Request;
import edu.si.ing1.pds.vsc.connectionPool.ServerToClient;

public class SmartCityAppServer extends Thread {

    private final static Logger logger = LoggerFactory.getLogger(SmartCityAppServer.class.getName());

    private static int nbreConnexion;
    public static int maxConnectionInit = 3;
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
        System.out.println("Accepted Client Address - " + client.getInetAddress().getHostName());
        try {
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
            while (ds.getUsedConnection() < maxConnectionInit) {
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String operation = in.readLine();
                ObjectMapper mapper = new ObjectMapper();
                System.out.println(operation);
                Request request = mapper.readValue(operation, Request.class);
                String response = connection.SendResponse(request);
                out = new PrintWriter(client.getOutputStream(), true);
                out.println(response);
                System.out.println("*******\n ");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Erreur .......");
        } finally {
            try {
                in.close();
                out.close();
                client.close();
                System.out.println("......Stopped");
                nbreConnexion--;
                System.out.println("nbreConnexion" +nbreConnexion);
            } catch (IOException ioe) {
                logger.error("Erreur.....");
                ioe.printStackTrace();
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

        System.out.println("VSC Application is running, maximal_connection= " + maxConnectionInit + " & connectionDuration = " + connectionDurationInit + ".");

        //connection pool created
        ds = new DataSource(maxConnectionInit, connectionDurationInit);

        try {
            myServerSocket = new ServerSocket(1099);
            System.out.println("port: " + myServerSocket.getLocalPort());
        } catch (IOException ioe) {
            ioe.printStackTrace();
            logger.error("Could not create server socket on port " + myServerSocket.getLocalPort() + ". Quitting.");
            System.exit(-1);
        }

        while (ServerOn) {

            try {

                Socket clientSocket = myServerSocket.accept();

                SmartCityAppServer cliThread = new SmartCityAppServer(clientSocket, nbreConnexion);
                if (nbreConnexion < maxConnectionInit) {
                    cliThread.start();
                    System.out.println("nbreConnexion : " + (nbreConnexion + 1));
                    System.out.println("Serveur est en ecoute .......");
                } else {
                    cliThread.client.close();
                    System.out.println("nbreConnexion : " + nbreConnexion);
                    System.out.println("Serveur est maximum de connection");
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
                logger.error("Exception found on accept. Ignoring. Stack Trace :" + ioe.getMessage());
            }

        }
        try {
            myServerSocket.close();
            System.out.println("Server Stopped...");
        } catch (Exception ioe) {
            logger.error("Error Found stopping server socket");
            ioe.printStackTrace();
            System.exit(-1);
        }
    }
}
