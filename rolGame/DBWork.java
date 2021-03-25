package gameJava.rolGame;

import java.sql.*;

public class DBWork {

    private static final String APP_NAME = "DataBase";
    private static final String dbPatch = "/home/gianca/Escritorio/game-java/src/gameJava/rolGame/";

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

    public boolean insert(String name, String password, int _class) {

        String sql = "INSERT INTO users(name, password, clase, strength, agillity, intelligence" +
                ", speed, life, armor, lifeMax, lifeMin, level, exp, expUp) values(?,?,?,?,?,?,?,?," +
                "?,?,?,?,?,?)";

        Personaje statsPj = new Personaje();

        int[] statsWar = statsPj.Warrior();
        int[] statsMage = statsPj.Mage();
        int[] statsArch = statsPj.Archer();

        createNewTable();

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, password);


            switch (_class) {
                case 1 -> {
                    pstmt.setString(3, "Warrior");
                    pstmt.setInt(4, statsWar[0]);
                    pstmt.setInt(5, statsWar[1]);
                    pstmt.setInt(6, statsWar[2]);
                    pstmt.setInt(7, statsWar[3]);
                    pstmt.setInt(8, statsWar[4]);
                    pstmt.setInt(9, statsWar[5]);
                    pstmt.setInt(10, statsWar[6]);
                    pstmt.setInt(11, statsWar[7]);
                    pstmt.setInt(12, statsWar[8]);
                    pstmt.setInt(13, statsWar[9]);
                    pstmt.setInt(14, statsWar[10]);
                    pstmt.executeUpdate();
                    return true;
                }
                case 2 -> {
                    pstmt.setString(3, "Mage");
                    pstmt.setInt(4, statsMage[0]);
                    pstmt.setInt(5, statsMage[1]);
                    pstmt.setInt(6, statsMage[2]);
                    pstmt.setInt(7, statsMage[3]);
                    pstmt.setInt(8, statsMage[4]);
                    pstmt.setInt(9, statsMage[5]);
                    pstmt.setInt(10, statsMage[6]);
                    pstmt.setInt(11, statsMage[7]);
                    pstmt.setInt(12, statsMage[8]);
                    pstmt.setInt(13, statsMage[9]);
                    pstmt.setInt(14, statsMage[10]);
                    pstmt.executeUpdate();
                    return true;
                }
                case 3 -> {
                    pstmt.setString(3, "Archer");
                    pstmt.setInt(4, statsArch[0]);
                    pstmt.setInt(5, statsArch[1]);
                    pstmt.setInt(6, statsArch[2]);
                    pstmt.setInt(7, statsArch[3]);
                    pstmt.setInt(8, statsArch[4]);
                    pstmt.setInt(9, statsArch[5]);
                    pstmt.setInt(10, statsArch[6]);
                    pstmt.setInt(11, statsArch[7]);
                    pstmt.setInt(12, statsArch[8]);
                    pstmt.setInt(13, statsArch[9]);
                    pstmt.setInt(14, statsArch[10]);
                    pstmt.executeUpdate();
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean loginDB(String userName, String userPass) {

        String sql = "SELECT name, password FROM users";


        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String dbUsers = (rs.getString("name"));
                if (dbUsers.equals(userName)) {

                    String dbPass = rs.getString("password");

                    if (dbPass.equals(userPass)) {
                        return true;
                    }else{
                        break;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
