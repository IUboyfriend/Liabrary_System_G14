package Controller;

import View.Initial;
import View.Oracle_Login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class BookController {

    public static ResultSet searchAll(String searchVal,String searchType) throws SQLException {
        OracleDB oracleDB = Oracle_Login.oracleDB;
        String query;
        if (searchType.equals("All"))
        {
            query = "SELECT BOOKNAME,AUTHOR,PUBLISHER,CATEGORY,COUNT(*) FROM BOOK " + " WHERE BOOKNAME LIKE '%" + searchVal + "%'" +
                "OR AUTHOR LIKE '%" + searchVal + "%'" +
                "OR CATEGORY LIKE '%" + searchVal + "%'"+
                "OR PUBLISHER LIKE '%" + searchVal + "%'" +
                "GROUP BY BOOKNAME,AUTHOR,PUBLISHER,CATEGORY";
        }
        else
        {
            String searchField = searchType.equals("Name")? "BOOKNAME":searchType;
            query = "SELECT BOOKNAME,AUTHOR,PUBLISHER,CATEGORY, COUNT(*) FROM BOOK  WHERE " + searchField.toUpperCase() + " LIKE '%" + searchVal + "%'"
            + "GROUP BY BOOKNAME,AUTHOR,PUBLISHER,CATEGORY";
        }
        ResultSet rset = oracleDB.executeQuery(query);
        return rset;
    }

    public static ResultSet searchTable(String tablename) throws SQLException {
        OracleDB oracleDB = Oracle_Login.oracleDB;
        String query = "SELECT * FROM "+ tablename;
        ResultSet rset = oracleDB.executeQuery(query);
        return rset;
    }

    public static ResultSet searchReturnTable() throws SQLException {
        OracleDB oracleDB = Oracle_Login.oracleDB;
        String query = "SELECT * FROM BORROW_AND_RETURN_RECORD WHERE RETURNTIME IS NULL";
        ResultSet rset = oracleDB.executeQuery(query);
        return rset;
    }
    public static String borrowBook(String bookName, String publisher, String author, String category) throws SQLException {
        OracleDB oracleDB = Oracle_Login.oracleDB;
        String query = "SELECT * FROM BOOK WHERE BOOKNAME = '" + bookName + "' AND PUBLISHER = '" + publisher + "' AND AUTHOR = '"
                + author + "' AND CATEGORY = '" + category + "' AND STATUS = '0'" ;
        ResultSet rset = oracleDB.executeQuery(query);
        if(!rset.next()){
            return "This book has no available copies!";
        }else{
            query = "SELECT NUMOFBORROWS FROM USER_ACCOUNT WHERE LOGINID = '" + Initial.ID + "'";
            ResultSet rsetUSER = oracleDB.executeQuery(query);
            rsetUSER.next();
            int currentBorrows = rsetUSER.getInt("NUMOFBORROWS");
            if(currentBorrows>=3){
                return "You cannot keep more than three books at the same time!";
            }else{
                currentBorrows++;
                query="UPDATE USER_ACCOUNT SET NUMOFBORROWS = '"+ currentBorrows + "' WHERE LOGINID = '"+ Initial.ID +"'";
                oracleDB.executeUpdate(query);
            }



            String bookID = rset.getString("BOOKID");
            query="UPDATE BOOK SET STATUS = '1' WHERE BOOKID = \'"+bookID+"\'";
            oracleDB.executeUpdate(query);
            Date date = new Date();
            Timestamp ts = new Timestamp(date.getTime());
            Timestamp tsLater = new Timestamp(date.getTime()+(long) 1000*3600*24*30);
            query = "INSERT INTO BORROW_AND_RETURN_RECORD (BOOKID,LOGINID,BORROWTIME,EXPECTEDRETURNTIME) VALUES('" + bookID + "','" + Initial.ID + "'," +
                    "TIMESTAMP \'" + ts + "\'," + "TIMESTAMP \'" + tsLater + "\')";
            oracleDB.executeUpdate(query);
           return "Successfully borrow a book! Please return it in one month!";
        }

    }
}
