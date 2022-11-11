package Controller;
import View.Initial;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class UserMangementController {
    public static boolean activate(String id,Controller.OracleDB oracleDB) throws SQLException{
        String query="SELECT Nickname FROM USER_ACCOUNT WHERE LOGINID=\'"+id+"\'";
        ResultSet rset = oracleDB.executeQuery(query);
        if (!rset.next()) {
            JOptionPane.showMessageDialog(null, "No records are found!");
            return false;
        }

            query="UPDATE USER_ACCOUNT SET AccountStatus='1' WHERE LOGINID=\'"+id+"\'";
            oracleDB.executeQuery(query);
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        query="INSERT INTO REACTIVATION_RECORD VALUES(\'" + Initial.ID + "\',\'"+ id +"\',\'activate\',"+"TIMESTAMP \'"+ts+"\')";
        rset = oracleDB.executeQuery(query);
            JOptionPane.showMessageDialog(null, "The useraccount has been activated");

            return true;
    }
    public static boolean deactivate(String id,Controller.OracleDB oracleDB) throws SQLException{
        String query="SELECT Nickname FROM USER_ACCOUNT WHERE LOGINID=\'"+id+"\'";
        ResultSet rset = oracleDB.executeQuery(query);
        if (!rset.next()) {
            JOptionPane.showMessageDialog(null, "No records are found!");
            return false;
        }
        query="UPDATE USER_ACCOUNT SET AccountStatus='0' WHERE LOGINID=\'"+id+"\'";
        oracleDB.executeQuery(query);
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        query="INSERT INTO REACTIVATION_RECORD VALUES(\'" + Initial.ID + "\',\'"+ id +"\',\'deactivate\',"+"TIMESTAMP \'"+ts+"\')";
        rset = oracleDB.executeQuery(query);
        JOptionPane.showMessageDialog(null, "The useraccount has been deactivated");
        return true;
    }
}
