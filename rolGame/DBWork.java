package gameJava.rolGame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;


public class DBWork {

    private static final String APP_NAME = "DataBase";
    private static final String dbPatch = "/home/gianca/Escritorio/game-java/src/gameJava/gameJava/";

    public String AppDatabasePath() {
        return dbPatch + APP_NAME + ".db";
    }

    public String AppDatabase() {
        return "jdbc:sqlite:" + AppDatabasePath();
    }

    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(AppDatabase());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public boolean createAppDatabase() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(AppDatabase());
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

    public void createNewTable() {

        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                + "	id integer PRIMARY KEY autoincrement,\n"
                + "	name text NOT NULL,\n"
                + "	password text NOT NULL,\n"
                + "	clase text NOT NULL,\n"
                + "	strength integer NOT NULL,\n"
                + "	agillity integer NOT NULL,\n"
                + "	intelligence integer NOT NULL,\n"
                + "	speed integer NOT NULL,\n"
                + "	life integer NOT NULL,\n"
                + "	armor integer NOT NULL,\n"
                + "	lifeMax integer NOT NULL,\n"
                + "	lifeMin integer NOT NULL,\n"
                + "	level integer NOT NULL,\n"
                + "	exp integer NOT NULL,\n"
                + "	expUP integer NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(AppDatabase());
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(String name, String password, String clase, int strength, int agillity
            , int inteligence, int speed, int life, int armor, int lifeMax, int lifeMin
            , int level, int exp, int expUp) {

        String sql = "INSERT INTO users(name, password, clase, strength, agillity, intelligence," +
                " speed, life, armor, lifeMax, lifeMin, level, exp, expUp) " +
                "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        System.out.println("Holaaa");

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            pstmt.setString(3, clase);
            pstmt.setInt(4, strength);
            pstmt.setInt(5, agillity);
            pstmt.setInt(6, inteligence);
            pstmt.setInt(7, speed);
            pstmt.setInt(8, life);
            pstmt.setInt(9, armor);
            pstmt.setInt(10, lifeMax);
            pstmt.setInt(11, lifeMin);
            pstmt.setInt(12, level);
            pstmt.setInt(13, exp);
            pstmt.setInt(14, expUp);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
