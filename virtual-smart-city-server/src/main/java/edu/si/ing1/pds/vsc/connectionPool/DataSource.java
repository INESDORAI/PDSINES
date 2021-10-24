package edu.si.ing1.pds.vsc.connectionPool;

import java.util.ArrayList;

public class DataSource {
    //attributs
    static JDBCConnectionPool conPool = new JDBCConnectionPool();

    public int getMaxConnection() {
        return conPool.getMaxConnection();
    }

    public int getUsedConnection() {
        return conPool.getUsedConnection();
    }

    public void setMaxConnection(int maxCon) {
        conPool.setMaxConnection(maxCon);

    }

    public void setUsedConnection(int usedCon) {
        conPool.setUsedConnection(usedCon);
    }

    //constructor
    public DataSource(int maxCon, int conInterv) {
        setUsedConnection(0);
        setMaxConnection(maxCon);
        ArrayList<ConnectionDB> cons = new ArrayList<ConnectionDB>();
        for (int i = 0; i < maxCon; i++) {
            ConnectionDB c = new ConnectionDB();
            cons.add(c);
        }
        conPool.feed(cons);
    }

    //methods
    public static ConnectionDB takeCon() {
        return conPool.connectionEntity();
    }

    public static void returnCon(ConnectionDB con) {
        conPool.returnCon(con);
    }

    public static void closure() {
        conPool.Close();
    }

}
