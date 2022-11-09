import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import oracle.jdbc.driver.OracleConnection;
import java.io.*;
import java.sql.*;

public class Main {
    public static void main(String args[]) throws SQLException {
        OracleDB oracleDB = new OracleDB();
        ResultSet rset = oracleDB.executeQuery("SELECT EMPNO, ENAME, JOB FROM EMP");
        while (rset.next()) {
            System.out.println(rset.getInt(1)
                    + " " + rset.getString(2)
                    + " " + rset.getString(3));
        }

        oracleDB.executeUpdate("INSERT INTO USER_ACCOUNT VALUES ('Testing','Testing123','Jay',1,0,0,'571532474@qq.com')");
        oracleDB.closeConnection();

    }
}



