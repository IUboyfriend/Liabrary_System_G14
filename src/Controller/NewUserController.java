package Controller;

import View.Oracle_Login;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewUserController {
    public static String newUser(String userID,String nickName,String password,String Email) throws SQLException {


        String query = "SELECT * FROM USER_ACCOUNT WHERE LOGINID = '" + userID +"'";
        if(Oracle_Login.oracleDB.executeQuery(query).next()){
            return "The user ID has already exists! Please try another one!";
        }
        query = "INSERT INTO USER_ACCOUNT (LOGINID,PASSWORD,NICKNAME,ACCOUNTSTATUS,NUMOFBORROWS,EMAIL) VALUES('" + userID + "','" + password + "','" +
                nickName + "','" + "0','" + "0','"  + Email +"')";
        System.out.println(Oracle_Login.oracleDB.executeUpdate(query));
        return "Successfully create user: " + userID;
    }

}
