package Controller;

import View.Oracle_Login;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookController {

    public static ResultSet searchAll(String searchVal,String searchType) throws SQLException {
        OracleDB oracleDB = Oracle_Login.oracleDB;
//        String query = "SELECT * FROM BOOK WHERE BOOKNAME LIKE '%" + searchText + "%'" +
//                "OR AUTHOR LIKE '%" + searchText + "%'" +
//                "OR CATEGORY LIKE '%" + searchText + "%'"+
//                "OR PUBLISHER LIKE '%" + searchText + "%'" ;
        String query = "SELECT * FROM BOOK ";
        if (searchType.equals("All"))
        {
            query += " WHERE BOOKNAME LIKE '%" + searchVal + "%'" +
                "OR AUTHOR LIKE '%" + searchVal + "%'" +
                "OR CATEGORY LIKE '%" + searchVal + "%'"+
                "OR PUBLISHER LIKE '%" + searchVal + "%'" ;
        }
        else
        {
            String searchField = searchType.equals("Name")? "BOOKNAME":searchType;
            query += " WHERE " + searchField.toUpperCase() + " LIKE '%" + searchVal + "%'";
        }
        ResultSet rset = oracleDB.executeQuery(query);
        return rset;
    }






}
