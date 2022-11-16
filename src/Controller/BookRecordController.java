package Controller;

import View.Initial;
import View.Oracle_Login;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRecordController {

    public static ResultSet searchBorrowReturn(String searchVal) throws SQLException {
        OracleDB oracleDB = Oracle_Login.oracleDB;
        /*WHERE这里加个join判断loginid = InitalID的Borrow and return表里的bookid列与book中的bookid列同*/
        String query = "SELECT BOOKID,BOOKNAME,AUTHOR,CATEGORY,PUBLISHER FROM BOOK " + " WHERE BOOKID LIKE '%" +searchVal + "%' OR BOOKNAME LIKE '%" + searchVal + "%'" +
                "OR AUTHOR LIKE '%" + searchVal + "%'" +
                "OR CATEGORY LIKE '%" + searchVal + "%'"+
                "OR PUBLISHER LIKE '%" + searchVal + "%'" +
                "GROUP BY BOOKID,BOOKNAME,AUTHOR,PUBLISHER,CATEGORY";
       /* String sql=" select * from (SELECT a.*, b.Nickname, b.Email,c.STATUS,c.BookName,c.AUTHOR,c.CATEGORY,c.PUBLISHER,";
        sql +=" CASE c.STATUS";
        sql +=" WHEN 0 THEN 'Available'";
        sql +=" WHEN 1 THEN 'Borrowed'";
        sql +=" WHEN 2 THEN 'Reserved'";
        sql +=" ELSE '' END";
        sql +=" As StatusName";
        sql +=" FROM BORROW_AND_RETURN_RECORD a";
        sql +=" left join USER_Account b on a.LOGINID = B.LOGINID";
        sql +=" left join book c on a.BOOKID = C.BOOKID)";
        sql += String.format(" where BookId='%s' ",bookId);*/

        ResultSet rset = oracleDB.executeQuery(query);
        return rset;
    }

}
