package Controller;

import View.Oracle_Login;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnalysisReportController {

    public static ResultSet generateReport(String selectedItem) throws SQLException {


        OracleDB oracleDB = Oracle_Login.oracleDB;
        String query = "SELECT " + selectedItem + ", SUM(SUM1) AS Total " +
        "FROM (SELECT " + selectedItem + ", COUNT(*) AS SUM1 FROM BORROW_AND_RETURN_RECORD a, BOOK b WHERE a.BOOKID = b.BOOKID GROUP BY " + selectedItem +
        " UNION ALL " +
        "SELECT " + selectedItem + ", COUNT(*) FROM RESERVED_RECORD a, BOOK b WHERE a.BOOKID = b.BOOKID GROUP BY " + selectedItem +
        " UNION ALL " +
        "SELECT " + selectedItem + ", COUNT(*) FROM BOOK_DESIRED GROUP BY " + selectedItem + ")" +
        " GROUP BY " + selectedItem +  " ORDER BY Total DESC";
        ResultSet rset = oracleDB.executeQuery(query);
        return rset;

    }


}
