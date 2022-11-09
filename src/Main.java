import Controller.OracleDB;

import java.sql.*;

public class Main {
    public static void main(String args[]) throws SQLException {
        OracleDB oracleDB = new OracleDB();
        ResultSet rset = oracleDB.executeQuery("SELECT EMPNO, ENAME, JOB FROM EMP");
        while (rset.next()) {
            System.out.println(rset.getString(1)
                    + " " + rset.getString(2)
                    + " " + rset.getString(3));
        }

        //oracleDB.executeUpdate("INSERT INTO USER_ACCOUNT VALUES ('Testing2','Testing123','Jay',1,0,0,'571532474@qq.com')");
        oracleDB.closeConnection();

    }
}



