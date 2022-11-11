package Controller;

import View.Initial;
import View.Oracle_Login;

import javax.management.Query;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    public static String Login(String ID, String password,String role) throws SQLException {
        if(role.equals("User")){
            String query = "SELECT * FROM USER_ACCOUNT WHERE LOGINID = '" + ID + "' AND PASSWORD = '" + password + "'";
            ResultSet rset = Oracle_Login.oracleDB.executeQuery(query);
            if(!rset.next())
                return "Invalid account or password! Please try again!";
            if(rset.getInt("ACCOUNTSTATUS") == 1)
                    return "Your account has been deactivated! Ask an administrator for help!";

        }else if (role.equals("Admin")){
            String query = "SELECT * FROM ADMIN_ACCOUNT WHERE LOGINID = '" + ID + "' AND PASSWORD = '" + password + "'";
            ResultSet rset = Oracle_Login.oracleDB.executeQuery(query);
            if(!rset.next())
                return "Invalid account or password! Please try again!";
        }

        return "";
    }


    public static String getNickName() throws SQLException {
        String userID = Initial.ID;
        String query = "SELECT NICKNAME FROM USER_ACCOUNT WHERE LOGINID = '" + userID + "'";
        ResultSet rset = Oracle_Login.oracleDB.executeQuery(query);
        rset.next();
        return rset.getString("NICKNAME");
    }


}
