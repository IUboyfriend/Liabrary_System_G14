package Controller;

import View.Initial;
import View.Oracle_Login;

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
    public static int bookAvailable(String bookName, String publisher, String author, String category,Controller.OracleDB oracleDB) throws SQLException {
        String query = "SELECT * FROM BOOK WHERE BOOKNAME = '" + bookName + "' AND PUBLISHER = '" + publisher + "' AND AUTHOR = '"
                + author + "' AND CATEGORY = '" + category + "' AND STATUS = '0'" ;
        ResultSet rset = oracleDB.executeQuery(query);
        int count = 0;
        while(rset.next())
            count++;
        return count;
    }
    public static String BfindBookId(String loginID, String time, Controller.OracleDB oracleDB) throws SQLException {
        //TO_TIMESTAMP(date_string,'YYYY-MM-DD HH24:MI:SS')
        String query = "SELECT BOOKID FROM BORROW_AND_RETURN_RECORD WHERE LOGINID = '" + loginID + "' AND BORROWTIME = TO_TIMESTAMP('" + time +"','YYYY-MM-DD HH24:MI:SS')";
        ResultSet rset = oracleDB.executeQuery(query);
        rset.next();
        return rset.getString("BOOKID");
    }

    public static String RfindBookId(String loginID, String time, Controller.OracleDB oracleDB) throws SQLException {
        String query = "SELECT BOOKID FROM RESERVED_RECORD WHERE LOGINID = '" + loginID + "' AND RESERVEDTIME = TO_TIMESTAMP('" + time +"','YYYY-MM-DD HH24:MI:SS')";
        ResultSet rset = oracleDB.executeQuery(query);
        rset.next();
        return rset.getString("BOOKID");
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

            query = "INSERT INTO BOOK (BookID,BookName,Author,Category,Publisher,Status) VALUES(\'" + id + "\',\'"+name+"\',\'"+aut+"\',\'"+cat+"\',\'"+pub+"\',\'"+0+"\')";
            rset = oracleDB.executeQuery(query);
        String type="add";
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        query="INSERT INTO OPERATION_RECORD VALUES(\'" + id + "\',\'"+ Initial.ID +"\',TIMESTAMP \'"+ts+"\',\'"+type+"\')";
        rset = oracleDB.executeQuery(query);

    }

    public static ResultSet findBookInfoById(String BookId) throws SQLException {
        OracleDB oracleDB = Oracle_Login.oracleDB;
        String query="SELECT * FROM BOOK WHERE BookID=\'"+ BookId +"\'";
        ResultSet rset = oracleDB.executeQuery(query);
        return rset;

    }
}
