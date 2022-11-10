package Controller;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UserMangementController {
    public static boolean activate(String id,Controller.OracleDB oracleDB) throws SQLException{
        String query="SELECT Nickname FROM USER_ACCOUNT WHERE LoginID=\'"+id+"\'";
        ResultSet rset = oracleDB.executeQuery(query);
        if (!rset.next()) {
            JOptionPane.showMessageDialog(null, "No records are found!");
            return false;
        }

            query="UPDATE USER_ACCOUNT SET AccountStatus='1' WHERE id=\'"+id+"\'";
            oracleDB.executeQuery(query);
            JOptionPane.showMessageDialog(null, "The useraccount has been activated");
            return true;
    }
    public static boolean deactivate(String id,Controller.OracleDB oracleDB) throws SQLException{
        String query="SELECT Nickname FROM USER_ACCOUNT WHERE LoginID=\'"+id+"\'";
        ResultSet rset = oracleDB.executeQuery(query);
        if (!rset.next()) {
            JOptionPane.showMessageDialog(null, "No records are found!");
            return false;
        }
        query="UPDATE USER_ACCOUNT SET AccountStatus='0' WHERE id=\'"+id+"\'";
        oracleDB.executeQuery(query);
        JOptionPane.showMessageDialog(null, "The useraccount has been deactivated");
        return true;
    }
}
