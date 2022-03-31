package Data;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class data {
    public ResultSet ConnectAndQuerySql(String sDBURL, String sUsername, String sPassword, String sQuery) throws SQLException {

        ResultSet resultSet = null;

        try{

            java.sql.Connection con = DriverManager.getConnection(sDBURL, sUsername, sPassword);
            Statement statement = con.createStatement();
            resultSet = statement.executeQuery(sQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;

    }
}

