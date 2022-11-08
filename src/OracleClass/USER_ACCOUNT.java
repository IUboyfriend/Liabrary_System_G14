package OracleClass;

import oracle.jdbc.driver.OracleConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class USER_ACCOUNT {
    private OracleConnection connection;
    private static final USER_ACCOUNT instance = new USER_ACCOUNT();

    private USER_ACCOUNT() {
    }

    public static USER_ACCOUNT getInstance() {
        return instance;
    }

    public void setConnection(OracleConnection conn) {
        this.connection = conn;
    }

    public static void closeConnection() {
        if (instance.connection != null)
            try {
                instance.connection.close();
            } catch (SQLException e) {
            }
    }

    public boolean checkUserExisted(String userID,String password) {
        try {
            ResultSet rs = this.connection.createStatement().executeQuery("SELECT * FROM USER_ACCOUNT WHERE 'LoginID' = '" + userID + "' AND 'Password' = '" + password + "'");
            while (rs.next()) {
                System.out.println(rs.getString(1)
                        + " " + rs.getString(2));
            }
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
