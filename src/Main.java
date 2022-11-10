import Controller.OracleDB;
import View.Initial;
import View.User.UserOperation;

import javax.swing.*;
import java.sql.*;
import java.util.Locale;

public class Main {
    public static void main(String args[]) throws SQLException {
        //Locale.setDefault(new Locale("USA"));
//        OracleDB oracleDB = new OracleDB();
//        String query = "SELECT * FROM BOOK WHERE BOOKID = 123";
//        ResultSet rset = oracleDB.executeQuery(query);
//        while(rset.next()){
//            System.out.println(rset.getString("BOOKNAME"));
//        }
//        oracleDB.closeConnection();
        JFrame frame = new JFrame();
        frame.setContentPane(new Initial(frame).JPMain);



    }
}



