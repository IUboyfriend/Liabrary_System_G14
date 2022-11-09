package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookController {

    public static ResultSet searchAll(String searchText,Controller.OracleDB oracleDB) throws SQLException {

        String query = "SELECT * FROM BOOK WHERE \"BookName\" LIKE '%" + searchText + "%'" +
                "OR \"Author\" LIKE '%" + searchText + "%'" +
                "OR \"Category\" LIKE '%" + searchText + "%'"+
                "OR \"Publisher\" LIKE '%" + searchText + "%'";
        ResultSet rset = oracleDB.executeQuery(query);
        return rset;
    }
    public static ResultSet searchOneField(String searchText, String searchField, Controller.OracleDB oracleDB) throws SQLException {
        searchField = searchField.equals("Name")? "BookName":searchField;

        String query = "SELECT * FROM BOOK WHERE \"" + searchField + "\" LIKE '%" + searchText + "%'";
        ResultSet rset = oracleDB.executeQuery(query);
        return rset;
    }



}
