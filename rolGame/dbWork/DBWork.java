package gameJava.rolGame.dbWork;

import java.sql.*;

public class DBWork {

    DbConnect dbConnect = new DbConnect();

    public boolean createAppDatabase() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn;
            try {
                conn = DriverManager.getConnection(dbConnect.AppDatabase());
                if (conn != null) {
                    conn.close();
                    return true;
                }
            } catch (SQLException x) {
                //todo
            }
        } catch (ClassNotFoundException x) {
            //todo
        }
        return false;
    }
}
