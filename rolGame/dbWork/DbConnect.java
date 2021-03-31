package rolGame.dbWork;

import rolGame.Messages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect extends Messages{

    public String AppDatabasePath() {
        return dbPatch + appName + dbExtension;
    }

    public String AppDatabase() {
        return dbType + AppDatabasePath();
    }

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(AppDatabase());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
