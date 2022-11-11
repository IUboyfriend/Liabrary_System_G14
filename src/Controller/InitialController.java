//package Controller;
//
//import View.Oracle_Login;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class InitialController {
//
//    public static void createTable(OracleDB conn) throws SQLException {
//
////        //ADMIN_ACCOUNT
////        conn.executeUpdate("create table ADMIN_ACCOUNT " +
////                "(" +
////                "    LoginID  VARCHAR2(10),"+
////                "    Password VARCHAR2(20),"+
////                "    constraint ADMIN_ACCOUNT_pk" +
////                "        primary key (LoginID)" +
////                ")");
////
////        //BOOK
////        conn.executeUpdate("create table BOOK" +
////                "(" +
////                "    BookID    VARCHAR2(10) not null," +
////                "    BookName  VARCHAR2(20) not null," +
////                "    Author    VARCHAR2(20)," +
////                "    Category  VARCHAR2(10)," +
////                "    Publisher VARCHAR2(20)," +
////                "    Status    NUMBER," +
////                "    constraint BOOK_pk" +
////                "        primary key (BookID)" +
////                ")");
////
////        //BOOK_DESIRED
////        conn.executeUpdate("create table BOOK_DESIRED" +
////                "(" +
////                "    LoginID   VARCHAR2(10) not null," +
////                "    BookName  VARCHAR2(20) not null," +
////                "    Author    VARCHAR2(20)," +
////                "    Category  VARCHAR2(10)," +
////                "    Publisher VARCHAR2(20)," +
////                "    constraint BOOK_DESIRED_pk" +
////                "        primary key (LoginID)" +
////                ")");
////
////        //BORROW_AND_RETURN_RECORD
////        conn.executeUpdate("create table BORROW_AND_RETURN_RECORD" +
////                "(" +
////                "    BookID             VARCHAR2(10) not null," +
////                "    LoginID            VARCHAR2(10) not null," +
////                "    BorrowTime         TIMESTAMP(6) not null," +
////                "    ReturnTime         TIMESTAMP(6)," +
////                "    ExpectedReturnTime TIMESTAMP(6) not null," +
////                "    constraint PK1 " +
////                "        primary key (BookID, LoginID, BorrowTime)" +
////                ")");
////
////        //OPERATION_RECORD
////        conn.executeUpdate("create table OPERATION_RECORD" +
////                "(" +
////                "    BookID         VARCHAR2(10) not null," +
////                "    LoginID_ADMIN VARCHAR2(10) not null," +
////                "    OperationTime  TIMESTAMP not null," +
////                "    OperationType  VARCHAR2(10) not null," +
////                "    constraint OPERATION_RECORD_pk " +
////                "        primary key (LoginID_ADMIN, BookID, OperationTime)" +
////                ")");
////        conn.executeUpdate("create unique index OPERATION_RECORD_OperationTime_BookID_LoginIDADMIN_uindex" +
////                "    on OPERATION_RECORD (OperationTime, BookID, LoginID_ADMIN)"
////        );
//
//        //REACTIVATION_RECORD
//        conn.executeUpdate("create table REACTIVATION_RECORD" +
//                "(" +
//                "    LoginID_ADMIN   VARCHAR2(10) not null," +
//                "    LoginID_USER    VARCHAR2(10) not null," +
//                "    OperationType  VARCHAR2(10) not null," +
//                "    ReactivationTime TIMESTAMP(6) not null," +
//                "    constraint REACTIVATION_RECORD_pk" +
//                "        primary key (LoginID_ADMIN, LoginID_USER, ReactivationTime)" +
//                ")");
//        conn.executeUpdate("create unique index REACTIVATION_Index" +
//                "    on REACTIVATION_RECORD (ReactivationTime, LoginID_USER, LoginID_ADMIN)"
//        );
//
////        //RESERVED_RECORD
////        conn.executeUpdate("create table RESERVED_RECORD" +
////                "(" +
////                "    LoginID         VARCHAR2(10) not null," +
////                "    BookID          VARCHAR2(10) not null," +
////                "    ReservedTime    TIMESTAMP(6) not null," +
////                "    ExpectedGetTime TIMESTAMP(6) not null," +
////                "    constraint Reserved_PK1" +
////                "        primary key (BookID, LoginID, ReservedTime)" +
////                ")");
////
////        //USER_ACCOUNT
////        conn.executeUpdate("create table USER_ACCOUNT" +
////                "(" +
////                "    LoginID       VARCHAR2(10) not null," +
////                "    Password      VARCHAR2(15) not null," +
////                "    Nickname      VARCHAR2(10)," +
////                "    AccountStatus NUMBER       not null," +
////                "    NumOfBorrows  NUMBER       not null," +
////                "    VIPScore      NUMBER       not null," +
////                "    Email         VARCHAR2(20)," +
////                "    constraint USER_ACCOUNT_pk" +
////                "        primary key (LoginID)" +
////                ")");
//    }
//
//    public static void initialInsert(OracleDB conn) throws SQLException {
//
//        conn.executeUpdate("INSERT INTO USER_ACCOUNT VALUES ('Testing1','Testing123','Jay',1,0,0,'571532474@qq.com')");
//    }
//
//    public static void main(String args[]) throws SQLException {
//        OracleDB oracleDB = new OracleDB("20076896d", "ufmgkkni");
//        String query="DROP TABLE REACTIVATION_RECORD";
//        ResultSet rset = oracleDB.executeQuery(query);
//        createTable(oracleDB);
//        //initialInsert(oracleDB);
//
//        oracleDB.closeConnection();
//    }
//}
