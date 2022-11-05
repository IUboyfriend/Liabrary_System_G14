import java.io.*;
import java.sql.*;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import oracle.jdbc.driver.*;

public class databaseTest {
    public static void main(String args[]) throws SQLException, IOException {
        JSch jSch = new JSch();
        try {
            Session session = jSch.getSession("20084595d", "csdoor.comp.polyu.edu.hk", 22);
            session.setPassword("Xunini19730611");
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            int assigned_port = session.setPortForwardingL(61522,"studora.comp.polyu.edu.hk",1521);

            // Connection
            try {
                String username = "\"20084595d\"";
                String pwd = "vkzabmqa";
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

                String url="jdbc:oracle:thin:@studora.comp.polyu.edu.hk:1521:dbms";
                url = "jdbc:oracle:thin:@localhost:61522/dbms";
                OracleConnection conn =
                        (OracleConnection) DriverManager.getConnection(
                                url, username, pwd);
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT EMPNO, ENAME, JOB FROM EMP");
                while (rset.next()) {
                    System.out.println(rset.getInt(1)
                            + " " + rset.getString(2)
                            + " " + rset.getString(3));
                }
                System.out.println();
                conn.close();
            } catch (Exception e) {
                System.out.println("Error");
            }


            System.out.println("server ssh version： " + session.getServerVersion());
            System.out.println("client ssh version： " + session.getClientVersion());
            System.out.println("123123");
        } catch (JSchException e) {
            System.out.println("Cannot connect the ssh" + e.getMessage());
        }


    }
}

