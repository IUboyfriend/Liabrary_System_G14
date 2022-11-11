package Controller;
import View.Initial;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class UserMangementController {
    public static void activate(String id,Controller.OracleDB oracleDB) throws SQLException{
        String query="SELECT * FROM USER_ACCOUNT WHERE LOGINID=\'"+id+"\'";
        ResultSet rset = oracleDB.executeQuery(query);
        if (!rset.next()) {
            JOptionPane.showMessageDialog(null, "No records are found!");
            //return false;
        }else {
            int state=rset.getInt(4);
            if(state==1){
                JOptionPane.showMessageDialog(null, "The useraccount is already activated!");
            }
            else {
                query = "UPDATE USER_ACCOUNT SET AccountStatus='1' WHERE LOGINID=\'" + id + "\'";
                oracleDB.executeQuery(query);
                Date date = new Date();
                Timestamp ts = new Timestamp(date.getTime());
                query = "INSERT INTO REACTIVATION_RECORD VALUES(\'" + Initial.ID + "\',\'" + id + "\',\'activate\'," + "TIMESTAMP \'" + ts + "\')";
                rset = oracleDB.executeQuery(query);
                JOptionPane.showMessageDialog(null, "The useraccount has been activated");
            }
        }
            //return true;
    }
    public static void deactivate(String id,Controller.OracleDB oracleDB) throws SQLException{
        String query="SELECT * FROM USER_ACCOUNT WHERE LOGINID=\'"+id+"\'";
        ResultSet rset = oracleDB.executeQuery(query);
        if (!rset.next()) {
            JOptionPane.showMessageDialog(null, "No records are found!");
            //return false;
        }
        else {
            int state=rset.getInt(4);
      if(state==0){
          JOptionPane.showMessageDialog(null, "The useraccount is already deactivated!");
            }
      else {
          query = "UPDATE USER_ACCOUNT SET AccountStatus='0' WHERE LOGINID=\'" + id + "\'";
          oracleDB.executeQuery(query);
          Date date = new Date();
          Timestamp ts = new Timestamp(date.getTime());
          query = "INSERT INTO REACTIVATION_RECORD VALUES(\'" + Initial.ID + "\',\'" + id + "\',\'deactivate\'," + "TIMESTAMP \'" + ts + "\')";
          rset = oracleDB.executeQuery(query);
          JOptionPane.showMessageDialog(null, "The useraccount has been deactivated");
          //return true;
      }
        }
    }
}
