package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookController {

    public static void searchAll(String searchText) throws SQLException {
        Controller.OracleDB oracleDB = new Controller.OracleDB();
        ResultSet rset = oracleDB.executeQuery("SELECT * FROM BOOK");
        while (rset.next()) {
            System.out.println(rset.getInt(1)
                    + " " + rset.getString(2)
                    + " " + rset.getString(3));
        }
        oracleDB.closeConnection();
    }

}
