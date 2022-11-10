package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

public class logController {
    public static ResultSet rgetall(String id, Controller.OracleDB oracleDB) throws SQLException {
        String query="SELECT * FROM REACTIVATION_RECORD WHERE  LoginID_ADMIN=\'"+id+"\'";
        ResultSet rset = oracleDB.executeQuery(query);
        return rset;
    }
    public static ResultSet ogetall(String id, Controller.OracleDB oracleDB) throws SQLException {
        String query="SELECT * FROM OPERATION_RECORD WHERE  LoginID_ADMIN=\'"+id+"\'";
        ResultSet rset = oracleDB.executeQuery(query);
        return rset;
    }
}
