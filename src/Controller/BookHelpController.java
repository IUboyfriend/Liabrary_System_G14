package Controller;

import View.Initial;
import View.Oracle_Login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class BookHelpController {

    public static String reserveBook(String bookName, String publisher, String author, String category) throws SQLException {
        OracleDB oracleDB = Oracle_Login.oracleDB;

        String query = "SELECT * FROM BOOK WHERE BOOKNAME = '" + bookName + "' AND PUBLISHER = '" + publisher + "' AND AUTHOR = '"
                + author + "' AND CATEGORY = '" + category + "'" ;
        ResultSet rset = oracleDB.executeQuery(query);
        rset.next();
        var status = rset.getInt("STATUS");
        if(status != 0){
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
            Timestamp tsLater = new Timestamp(date.getTime()+(long) 1000*3600*24*3);
            query = "INSERT INTO RESERVED_RECORD (BOOKID,LOGINID,ReservedTime,ExpectedGetTime) VALUES('" + bookID + "','" + Initial.ID + "'," +
                    "TIMESTAMP \'" + ts + "\'," + "TIMESTAMP \'" + tsLater + "\')";
            oracleDB.executeUpdate(query);
            return "Successfully reserve a book! Please borrow it in three day!";
        }

    }

    public static String desireBook(String bookName, String publisher, String author, String category) throws SQLException {
        OracleDB oracleDB = Oracle_Login.oracleDB;

        String query = String.format("SELECT * FROM BOOK_DESIRED WHERE LoginID='%s' and BookName='%s' and Author='%s' and Category='%s' and Publisher='%s'",
                Initial.ID,bookName,author,category,publisher);
        ResultSet rset = oracleDB.executeQuery(query);

        if(rset.next()){
            return "This book has been desired!";
        }else{

            String queryBook = String.format("SELECT * FROM BOOK WHERE BookName='%s' and Author='%s' and Category='%s' and Publisher='%s'",
                    bookName,author,category,publisher);
            ResultSet rsetBook = oracleDB.executeQuery(queryBook);
            rsetBook.next();

            String bookID = rsetBook.getString("BOOKID");

            query = String.format("INSERT INTO BOOK_DESIRED (LoginID,BookName,Author,Category,Publisher) VALUES('%s','%s','%s','%s','%s')",
                    Initial.ID,bookID,author,category,publisher);
            oracleDB.executeUpdate(query);
            return "Successfully desire a book! ";
        }

    }
}
