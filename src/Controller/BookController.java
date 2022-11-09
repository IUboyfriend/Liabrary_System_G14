package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookController {

    public static void searchAll(String searchText) throws SQLException {
        OracleDB oracleDB = new OracleDB();
        ResultSet rset = oracleDB.executeQuery("SELECT * FROM Book");
        while (rset.next()) {
            System.out.println(rset.getInt(1)
                    + " " + rset.getString(2)
                    + " " + rset.getString(3));
        }
    }

}
