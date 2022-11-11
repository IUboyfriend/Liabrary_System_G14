package Controller;

import View.Oracle_Login;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookController {

    public static ResultSet searchAll(String searchText) throws SQLException {
        OracleDB oracleDB = Oracle_Login.oracleDB;
        String query = "SELECT * FROM BOOK WHERE BOOKNAME LIKE '%" + searchText + "%'" +
                "OR AUTHOR LIKE '%" + searchText + "%'" +
                "OR CATEGORY LIKE '%" + searchText + "%'"+
                "OR PUBLISHER LIKE '%" + searchText + "%'";
        ResultSet rset = oracleDB.executeQuery(query);
        return rset;
    }
    public static ResultSet searchOneField(String searchText, String searchField) throws SQLException {
        OracleDB oracleDB = Oracle_Login.oracleDB;
        searchField = searchField.equals("Name")? "BOOKNAME":searchField;

        String query = "SELECT * FROM BOOK WHERE " + searchField.toUpperCase() + " LIKE '%" + searchText + "%'";
        ResultSet rset = oracleDB.executeQuery(query);
        return rset;
    }



}
