package Controller;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookManagementController {
    public static ResultSet getall(String id,Controller.OracleDB oracleDB) throws SQLException {
        String query="SELECT BookName FROM BOOK WHERE BookID=\'"+id+"\'";
        ResultSet rset = oracleDB.executeQuery(query);
        return rset;
    }
    public static void delete(String id,Controller.OracleDB oracleDB) throws SQLException {
        String query="DELETE FROM BOOK WHERE id=\'"+id+"\'";
        ResultSet rset = oracleDB.executeQuery(query);

    }
    public static void update(String id,Controller.OracleDB oracleDB,String pub,String aut,String name,String cat) throws SQLException {
        String query="UPDATE BOOK SET BookName=\'"+name+"\',"+"Author=\'"+aut+"\',"+"Category=\'"+cat+"\',"+"Publisher=\'"+pub+"\' WHERE id=\'"+id+"\'";
        ResultSet rset = oracleDB.executeQuery(query);

    }
    public static void add(String id,Controller.OracleDB oracleDB,String pub,String aut,String name,String cat) throws SQLException{
        String query="SELECT BookName FROM BOOK WHERE BookID=\'"+id+"\'";
        ResultSet rset = oracleDB.executeQuery(query);
        if(rset.next()){
            JOptionPane.showMessageDialog(null, "The book has already exsits!");
        }
        else {
            query = "INSERT INTO BOOK (BookID,BookName,Author,Category,Publisher,Status) VALUES(\'" + id + "\',\'"+name+"\',\'"+aut+"\',\'"+cat+"\',\'"+pub+"\');";
            rset = oracleDB.executeQuery(query);
        }
    }
}
