package Controller;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import oracle.jdbc.driver.OracleConnection;
import java.io.*;
import java.sql.*;

public class OracleDB {

    private OracleConnection conn;
    private ResultSet rset;
    private Statement stmt;
    public OracleDB(){
        JSch jSch = new JSch();
        try {
            Session session = jSch.getSession("20084595d", "csdoor.comp.polyu.edu.hk", 22);
            session.setPassword("Xunini19730611");
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            int assigned_port = session.setPortForwardingL(61523,"studora.comp.polyu.edu.hk",1521);

            // Connection
            try {
                String username = "\"20084595d\"";
                String pwd = "vkzabmqa";
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                String url = "jdbc:oracle:thin:@localhost:61523/dbms";
                conn = (OracleConnection) DriverManager.getConnection(url, username, pwd);

            } catch (Exception e) {
                System.out.println("Error");
            }

        } catch (JSchException e) {
            System.out.println("Cannot connect the ssh" + e.getMessage());
        }
    }

    public ResultSet executeQuery(String query) throws SQLException {
         stmt = conn.createStatement();
         rset = stmt.executeQuery(query);
         return rset;
    }
    public int executeUpdate(String query) throws SQLException {
        stmt = conn.createStatement();
        return stmt.executeUpdate(query);
    }
    public void closeConnection() throws SQLException {
        if (rset!=null) rset.close();
        if (stmt!=null) stmt.close();
        if (conn!=null) conn.close();
    }


}



