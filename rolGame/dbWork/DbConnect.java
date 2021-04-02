package rolGame.dbWork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static rolGame.Messages.*;

public class DbConnect {

    public String AppDatabasePath() {
        return DB_PATCH + APP_NAME + DB_EXTENSION;
    }

    public String AppDatabase() {
        return DB_TYPE + AppDatabasePath();
    }

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(AppDatabase());
        } catch (SQLException e) {
            print(e.getMessage());
        }
        return conn;
    }
}
