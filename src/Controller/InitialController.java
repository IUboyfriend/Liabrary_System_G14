package Controller;

import View.Oracle_Login;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InitialController {

    public static void createTable(OracleDB conn) throws SQLException {

        if(isExists("ADMIN_ACCOUNT")) conn.executeUpdate("drop table ADMIN_ACCOUNT");
        if(isExists("BOOK")) conn.executeUpdate("drop table BOOK");
        if(isExists("BOOK_DESIRED")) conn.executeUpdate("drop table BOOK_DESIRED");
        if(isExists("BORROW_AND_RETURN_RECORD")) conn.executeUpdate("drop table BORROW_AND_RETURN_RECORD");
        if(isExists("OPERATION_RECORD")) conn.executeUpdate("drop table OPERATION_RECORD");
        if(isExists("REACTIVATION_RECORD")) conn.executeUpdate("drop table REACTIVATION_RECORD");
        if(isExists("RESERVED_RECORD")) conn.executeUpdate("drop table RESERVED_RECORD");
        if(isExists("USER_ACCOUNT")) conn.executeUpdate("drop table USER_ACCOUNT");

        //ADMIN_ACCOUNT
        conn.executeUpdate("create table ADMIN_ACCOUNT " +
                "(" +
                "    LoginID  VARCHAR2(30),"+
                "    Password VARCHAR2(30),"+
                "    constraint ADMIN_ACCOUNT_pk" +
                "        primary key (LoginID)" +
                ")");

        //BOOK
        conn.executeUpdate("create table BOOK" +
                "(" +
                "    BookID    VARCHAR2(30) not null," +
                "    BookName  VARCHAR2(50) not null," +
                "    Author    VARCHAR2(50)," +
                "    Category  VARCHAR2(50)," +
                "    Publisher VARCHAR2(50)," +
                "    Status    NUMBER," +
                "    constraint BOOK_pk" +
                "        primary key (BookID)" +
                ")");

        //BOOK_DESIRED
        conn.executeUpdate("create table BOOK_DESIRED" +
                "(" +
                "    LoginID   VARCHAR2(30) not null," +
                "    BookName  VARCHAR2(50) not null," +
                "    Author    VARCHAR2(50)," +
                "    Category  VARCHAR2(50)," +
                "    Publisher VARCHAR2(50)," +
                "    constraint BOOK_DESIRED_pk" +
                "        primary key (LoginID, BookName, Publisher)" +
                ")");

        //BORROW_AND_RETURN_RECORD
        conn.executeUpdate("create table BORROW_AND_RETURN_RECORD" +
                "(" +
                "    BookID             VARCHAR2(30) not null," +
                "    LoginID            VARCHAR2(30) not null," +
                "    BorrowTime         TIMESTAMP(0) not null," +
                "    ReturnTime         TIMESTAMP(0)," +
                "    ExpectedReturnTime TIMESTAMP(0) not null," +
                "    constraint PK1 " +
                "        primary key (BookID, LoginID, BorrowTime)" +
                ")");

        //OPERATION_RECORD
        conn.executeUpdate("create table OPERATION_RECORD" +
                "(" +
                "    BookID         VARCHAR2(30) not null," +
                "    LoginID_ADMIN VARCHAR2(30) not null," +
                "    OperationTime  TIMESTAMP(0) not null," +
                "    OperationType  VARCHAR2(30) not null," +
                "    constraint OPERATION_RECORD_pk " +
                "        primary key (LoginID_ADMIN, BookID, OperationTime)" +
                ")");
        conn.executeUpdate("create unique index OPERATION_RECORD_OperationTime_BookID_LoginIDADMIN_uindex" +
                "    on OPERATION_RECORD (OperationTime, BookID, LoginID_ADMIN)"
        );

        //REACTIVATION_RECORD
        conn.executeUpdate("create table REACTIVATION_RECORD" +
                "(" +
                "    LoginID_ADMIN   VARCHAR2(30) not null," +
                "    LoginID_USER    VARCHAR2(30) not null," +
                "    OperationType  VARCHAR2(30) not null," +
                "    ReactivationTime TIMESTAMP(0) not null," +
                "    constraint REACTIVATION_RECORD_pk" +
                "        primary key (LoginID_ADMIN, LoginID_USER, ReactivationTime)" +
                ")");
        conn.executeUpdate("create unique index REACTIVATION_Index" +
                "    on REACTIVATION_RECORD (ReactivationTime, LoginID_USER, LoginID_ADMIN)"
        );

        //RESERVED_RECORD
        conn.executeUpdate("create table RESERVED_RECORD" +
                "(" +
                "    LoginID         VARCHAR2(30) not null," +
                "    BookID          VARCHAR2(30) not null," +
                "    ReservedTime    TIMESTAMP(0) not null," +
                "    ExpectedGetTime TIMESTAMP(0) not null," +
                "    constraint Reserved_PK1" +
                "        primary key (BookID, LoginID, ReservedTime)" +
                ")");

        //USER_ACCOUNT
        conn.executeUpdate("create table USER_ACCOUNT" +
                "(" +
                "    LoginID       VARCHAR2(30) not null," +
                "    Password      VARCHAR2(30) not null," +
                "    Nickname      VARCHAR2(30)," +
                "    AccountStatus NUMBER       not null," +
                "    NumOfBorrows  NUMBER       not null," +
                "    Email         VARCHAR2(30)," +
                "    constraint USER_ACCOUNT_pk" +
                "        primary key (LoginID)" +
                ")");
    }

    public static void initialInsert(OracleDB conn) throws SQLException {

        conn.executeUpdate("INSERT INTO USER_ACCOUNT VALUES ('1','1','Jay',0,0,'571532474@qq.com')");
        conn.executeUpdate("INSERT INTO USER_ACCOUNT VALUES ('2','2','wh1223',0,0,'973459859@qq.com')");
        conn.executeUpdate("INSERT INTO USER_ACCOUNT VALUES ('Testing1','2','Testing1',0,2,'1@qq.com')");
        conn.executeUpdate("INSERT INTO USER_ACCOUNT VALUES ('Testing2','2','Testing2',0,2,'2@qq.com')");
        conn.executeUpdate("INSERT INTO USER_ACCOUNT VALUES ('Testing3','2','Testing3',0,3,'3@qq.com')");
        conn.executeUpdate("INSERT INTO USER_ACCOUNT VALUES ('5','5','HAO Jiadong',0,0,'20084595d@connect.polyu.hk')");
        conn.executeUpdate("INSERT INTO USER_ACCOUNT VALUES ('4','4','WANG Hao',0,0,'20076279d@connect.polyu.hk')");


        conn.executeUpdate("INSERT INTO ADMIN_ACCOUNT VALUES ('3','3')");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('001','1984','George Orwell','anti-utopia','Thacker and Warburg',0)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('002','For Whom the Bell Tolls','Ernest Miller Hemingway','Love','The Brick Church Chapel',0)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('003','To the Lighthouse','Virginia Woolf','Modernist','Hogarth Press',0)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('004','An American Tragedy','Theodore Dreiser','novel','Horace Liveright',0)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('005','The Heart Is a Lonely Hunter','Carson McCullers','novel','Houghton Mifflin',0)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('006','The Heart Is a Lonely Hunter','Carson McCullers','novel','Houghton Mifflin',0)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('007','The Heart Is a Lonely Hunter','Carson McCullers','novel','Sylvia Beach',0)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('008','The Heart Is a Lonely Hunter','Carson McCullers','novel','Sylvia Beach',0)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('009','1984','George Orwell','anti-utopia','Thacker and Warburg',0)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('010','1984','George Orwell','anti-utopia','Thacker and Warburg',0)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('011','The Great Gatsby','Fitzgerald','tragedy','Charles Scribner Sons',0)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('012','The Great Gatsby','Fitzgerald','tragedy','Charles Scribner Sons',0)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('013','The Great Gatsby','Fitzgerald','tragedy','Charles Scribner Sons',0)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('014','The Great Gatsby','Fitzgerald','tragedy','Charles Scribner Sons',0)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('015','Ulysses','James Joyce','novel','Sylvia Beach',0)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('016','Lolita','Vladimir Nabokov','legendary drama','Olympia Press',0)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('017','Lolita','Vladimir Nabokov','legendary drama','Olympia Press',0)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('018','Lolita','Vladimir Nabokov','legendary drama','Olympia Press',0)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('019','Lolita','Vladimir Nabokov','legendary drama','Shanghai Translation Press',0)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('020','Lolita','Vladimir Nabokov','legendary drama','Shanghai Translation Press',0)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('021','Brave New World','Aldous Huxley','Science Fiction','Chatto & Windus',0)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('022','The Sun Also Rises','Ernest Hemingway','novel','Charles Scribner Sons',0)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('023','The Sun Also Rises','Ernest Hemingway','novel','Charles Scribner Sons',0)");

        conn.executeUpdate("INSERT INTO BOOK VALUES ('024','The Sun Also Rises','Ernest Hemingway','novel','Jonathan Kapp',1)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('025','AI 2041','Lee, Kai-Fu','Computing & Information Technology','Crown Publishing Group',1)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('026','AI 2041','Lee, Kai-Fu','Computing & Information Technology','Crown Publishing Group',1)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('027','AI 2041','Lee, Kai-Fu','Computing & Information Technology','Crown Publishing Group',1)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('028','Lolita','Vladimir Nabokov','legendary drama','Shanghai Translation Press',1)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('029','Lolita','Vladimir Nabokov','legendary drama','Shanghai Translation Press',1)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('030','Lolita','Vladimir Nabokov','legendary drama','Shanghai Translation Press',1)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('031','The Three-Body Problem','Liu Cixin','Science fiction','Chongqing Press',1)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('032','The Three-Body Problem','Liu Cixin','Science fiction','Chongqing Press',1)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('033','The Three-Body Problem','Liu Cixin','Science fiction','Chongqing Press',1)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('034','Village Teacher','Liu Cixin','Science fiction','Xin Hua Press',1)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('035','Village Teacher','Liu Cixin','Science fiction','Xin Hua Press',1)");
        conn.executeUpdate("INSERT INTO BOOK VALUES ('036','Village Teacher','Liu Cixin','Science fiction','Xin Hua Press',1)");

//reserve records
        conn.executeUpdate("INSERT INTO RESERVED_RECORD VALUES ('Testing1','024', TO_TIMESTAMP('2022-11-15 19:58:03','YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-1-18 19:58:03','YYYY-MM-DD HH24:MI:SS'))");
        conn.executeUpdate("INSERT INTO RESERVED_RECORD VALUES ('Testing1','025', TO_TIMESTAMP('2022-11-16 19:58:03','YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-1-19 19:58:03','YYYY-MM-DD HH24:MI:SS'))");
        conn.executeUpdate("INSERT INTO RESERVED_RECORD VALUES ('Testing2','026', TO_TIMESTAMP('2022-11-17 19:58:03','YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-1-20 19:58:03','YYYY-MM-DD HH24:MI:SS'))");


//desired records
        conn.executeUpdate("INSERT INTO BOOK_DESIRED VALUES ('Testing1','AI 2041', 'Lee, Kai-Fu','Computing & Information Technology','Crown Publishing Group')");
        conn.executeUpdate("INSERT INTO BOOK_DESIRED VALUES ('Testing2','AI 2041', 'Lee, Kai-Fu','Computing & Information Technology','Crown Publishing Group')");
        conn.executeUpdate("INSERT INTO BOOK_DESIRED VALUES ('Testing3','AI 2041', 'Lee, Kai-Fu','Computing & Information Technology','Crown Publishing Group')");
        conn.executeUpdate("INSERT INTO BOOK_DESIRED VALUES ('Testing1','Village Teacher', 'Liu Cixin','Science fiction','Xin Hua Press')");
        conn.executeUpdate("INSERT INTO BOOK_DESIRED VALUES ('Testing2','Village Teacher', 'Liu Cixin','Science fiction','Xin Hua Press')");
        conn.executeUpdate("INSERT INTO BOOK_DESIRED VALUES ('Testing3','Village Teacher', 'Liu Cixin','Science fiction','Xin Hua Press')");

//borrow and return records
        conn.executeUpdate("INSERT INTO BORROW_AND_RETURN_RECORD VALUES ('030','Testing1', TO_TIMESTAMP('2022-11-15 19:58:03','YYYY-MM-DD HH24:MI:SS'),null, TO_TIMESTAMP('2022-12-15 19:58:03','YYYY-MM-DD HH24:MI:SS'))");
        conn.executeUpdate("INSERT INTO BORROW_AND_RETURN_RECORD VALUES ('031','Testing2', TO_TIMESTAMP('2022-11-16 19:58:03','YYYY-MM-DD HH24:MI:SS'),null, TO_TIMESTAMP('2022-12-16 19:58:03','YYYY-MM-DD HH24:MI:SS'))");
        conn.executeUpdate("INSERT INTO BORROW_AND_RETURN_RECORD VALUES ('032','Testing2', TO_TIMESTAMP('2022-11-17 19:58:03','YYYY-MM-DD HH24:MI:SS'),null, TO_TIMESTAMP('2022-12-17 19:58:03','YYYY-MM-DD HH24:MI:SS'))");
        conn.executeUpdate("INSERT INTO BORROW_AND_RETURN_RECORD VALUES ('033','Testing3', TO_TIMESTAMP('2022-11-18 19:58:03','YYYY-MM-DD HH24:MI:SS'),null, TO_TIMESTAMP('2022-12-18 19:58:03','YYYY-MM-DD HH24:MI:SS'))");


    }

    public static boolean isExists(String tablename) {
        Connection conn = Oracle_Login.oracleDB.conn;
        boolean judge = false;
        try {
            DatabaseMetaData meta = conn.getMetaData();
            ResultSet set = meta.getTables(null, null, tablename, null);
            judge = set.next()? true :false;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return judge;
    }

}
