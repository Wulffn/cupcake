/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.IDBConnector;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author mwn
 */
public class DBConnector implements IDBConnector {

    private Connection connection = null;

    //Constants
    private static final String IP = "";
    private static final String PORT = "";
    public static final String DATABASE = "";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";

    public DBConnector() throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
        this.connection = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
    }

    public Connection getConnection() {
        return this.connection;
    }
}
