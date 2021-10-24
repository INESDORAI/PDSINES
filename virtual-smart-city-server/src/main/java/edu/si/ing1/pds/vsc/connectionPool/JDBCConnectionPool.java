package edu.si.ing1.pds.vsc.connectionPool;

import java.sql.SQLException;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCConnectionPool {

    private final static Logger logger = LoggerFactory.getLogger(JDBCConnectionPool.class.getName());

    //les attributs
    private ArrayList<ConnectionDB> collection = new ArrayList<ConnectionDB>();

    private static int maxConnection;

    private static int usedConnection = 0;

    //les accesseurs
    public static int getMaxConnection() {
        return maxConnection;
    }

    public static void setMaxConnection(int maxCon) {
        maxConnection = maxCon;
    }

    public static int getUsedConnection() {
        return usedConnection;
    }

    public static void setUsedConnection(int usedCon) {
        usedConnection = usedCon;
    }

    //le constructeur
    public JDBCConnectionPool() {
    }

    //les methodes
    public synchronized void feed(Collection<ConnectionDB> con) {
        collection.addAll(con);
    }

    public synchronized ConnectionDB connectionEntity() {

        if (usedConnection < maxConnection && collection.size() > 0) {
            ConnectionDB con = collection.get(collection.size() - 1);
            usedConnection++;
            collection.remove(con);
            return con;
        } else {
            return null;
        }
    }

    public synchronized void returnCon(ConnectionDB con) {
        collection.add(con);
        usedConnection--;
    }

    public synchronized void Close() {
        for (ConnectionDB c : collection) {
            try {
                c.connection.close();
            } catch (SQLException e) {
                logger.error("Erreur.....");
                e.printStackTrace();
            }
        }
    }
}
