package Controller;

import View.Initial;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
public class BookManagementController {
    public static ResultSet getall(String id,Controller.OracleDB oracleDB) throws SQLException {
        String query="SELECT * FROM BOOK WHERE BOOKID=\'"+id+"\'";
        ResultSet rset = oracleDB.executeQuery(query);
        return rset;
    }
    public static void delete(String id,Controller.OracleDB oracleDB) throws SQLException {
        String query="DELETE FROM BOOK WHERE BookID=\'"+id+"\'";
        ResultSet rset = oracleDB.executeQuery(query);
        String type="delete";
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        query="INSERT INTO OPERATION_RECORD VALUES(\'" + id + "\',\'"+ Initial.ID +"\',TIMESTAMP \'"+ts+"\',\'"+type+"\')";
        rset = oracleDB.executeQuery(query);
    }
    public static void update(String id,Controller.OracleDB oracleDB,String pub,String aut,String name,String cat) throws SQLException {
        String query="UPDATE BOOK SET BOOKNAME=\'"+name+"\',"+"AUTHOR=\'"+aut+"\',"+"CATEGORY=\'"+cat+"\',"+"PUBLISHER=\'"+pub+"\' WHERE BookID=\'"+id+"\'";
        ResultSet rset = oracleDB.executeQuery(query);
        String type="update";
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        query="INSERT INTO OPERATION_RECORD VALUES(\'" + id + "\',\'"+ Initial.ID +"\',TIMESTAMP \'"+ts+"\',\'"+type+"\')";
        rset = oracleDB.executeQuery(query);

    }
    public static void add(String id,Controller.OracleDB oracleDB,String pub,String aut,String name,String cat) throws SQLException{
        String query="SELECT BookName FROM BOOK WHERE BookID=\'"+id+"\'";
        ResultSet rset = oracleDB.executeQuery(query);

            query = "INSERT INTO BOOK (BookID,BookName,Author,Category,Publisher,Status) VALUES(\'" + id + "\',\'"+name+"\',\'"+aut+"\',\'"+cat+"\',\'"+pub+"\',\'"+1+"\')";
            rset = oracleDB.executeQuery(query);
        String type="add";
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        query="INSERT INTO OPERATION_RECORD VALUES(\'" + id + "\',\'"+ Initial.ID +"\',TIMESTAMP \'"+ts+"\',\'"+type+"\')";
        rset = oracleDB.executeQuery(query);

    }
}
