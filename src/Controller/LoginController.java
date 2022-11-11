package Controller;

import View.Oracle_Login;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    public static String Login(String ID, String password,String role) throws SQLException {
        if(role.equals("User")){
            String query = "SELECT * FROM USER_ACCOUNT WHERE LOGINID = '" + ID + "' AND PASSWORD = '" + password + "'";
            ResultSet rset = Oracle_Login.oracleDB.executeQuery(query);
            if(!rset.next())
                return "Invalid account or password! Please try again!";
            do{
                System.out.println(rset.getString("NICKNAME"));
            } while (rset.next());
        }else if (role.equals("Admin")){
            String query = "SELECT * FROM ADMIN_ACCOUNT WHERE LOGINID = '" + ID + "' AND PASSWORD = '" + password + "'";
            ResultSet rset = Oracle_Login.oracleDB.executeQuery(query);
            if(!rset.next())
                return "Invalid account or password! Please try again!";
            do{
                System.out.println(rset.getString("LOGINID"));
            } while (rset.next());
        }

        return "";
    }

}
