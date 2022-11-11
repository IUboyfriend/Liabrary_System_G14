package Controller;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import oracle.jdbc.driver.OracleConnection;

import javax.swing.*;
import java.io.*;
import java.sql.*;

public class OracleDB {

    private OracleConnection conn;
    private ResultSet rset;
    private Statement stmt;
    private Session session;
    public OracleDB(String account, String password){
        JSch jSch = new JSch();
        try {
            session = jSch.getSession("20084595d", "csdoor.comp.polyu.edu.hk", 22);
            session.setPassword("Xunini19730611");
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            int assigned_port = session.setPortForwardingL(61522,"studora.comp.polyu.edu.hk",1521);

            // Connection
            try {
                String username = "\"" + account + "\"";
                String pwd = password;
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                String url = "jdbc:oracle:thin:@localhost:61522/dbms";
                conn = (OracleConnection) DriverManager.getConnection(url, username, pwd);

            } catch (Exception e) {
                session.disconnect();
                JOptionPane.showMessageDialog(null,"Incorrect Oracle account and password, please try again. \nNote that you should not include the double quote in the account!");
                System.out.println("Error1:" +e.getMessage());
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
        session.disconnect();

    }


}



