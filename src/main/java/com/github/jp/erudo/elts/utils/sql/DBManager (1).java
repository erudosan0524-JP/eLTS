package com.github.jp.erudo.elts.utils.sql;

import com.github.jp.erudo.elts.utils.MessageManager;
import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBManager extends HttpServlet {

    private final String host,database,username,password;
    private final int port;
    private Connection connection;


    public DBManager(String host, String database, String username, String password, int port) {
        this.host = host;
        this.database = database;
        this.username = username;
        this.password = password;
        this.port = port;

        setup();
    }


    public void setup() {
        try {
            synchronized (this) {
                if(getConnection() != null && !getConnection().isClosed()) {
                    return;
                }

                Class.forName("com.mysql.jdbc.Driver");
                setConnection(DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database
                , this.username, this.password));

                MessageManager.log("SQLに接続しました。");
            }
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
