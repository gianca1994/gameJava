package gameJava.rolGame;

import java.sql.*;
import java.util.Arrays;

public class DBWork {

    private static final String APP_NAME = "DataBase";
    private static final String dbPatch = "gameJava/rolGame/";

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
                + "	expUP integer NOT NULL,\n"
                + "	adm boolean NOT NULL\n"
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
                ", speed, life, armor, lifeMax, lifeMin, level, exp, expUp, adm) values(?,?,?,?,?,?,?,?," +
                "?,?,?,?,?,?,?)";

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
                    pstmt.setBoolean(15, false);
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
                    pstmt.setBoolean(15, false);
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
                    pstmt.setBoolean(15, false);
                    pstmt.executeUpdate();
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public int loginDB(String userName, String userPass) {

        String sql = "SELECT name, password, adm FROM users";


        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String dbUsers = rs.getString("name");
                if (dbUsers.equals(userName)) {

                    String dbPass = rs.getString("password");
                    if (dbPass.equals(userPass)) {

                        boolean dbAdmin = rs.getBoolean("adm");
                        if (dbAdmin) {
                            return 666;
                        } else {
                            return 1;
                        }
                    } else {
                        break;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public void createNewTableNPCs() {

        String sql = "CREATE TABLE IF NOT EXISTS npcs (\n"
                + "	id integer PRIMARY KEY autoincrement,\n"
                + "	name text NOT NULL,\n"
                + "	dmgMax integer NOT NULL,\n"
                + "	dmgMin integer NOT NULL,\n"
                + "	armor integer NOT NULL,\n"
                + "	lifeMax integer NOT NULL,\n"
                + "	lifeMin integer NOT NULL,\n"
                + "	level integer NOT NULL,\n"
                + "	exp integer NOT NULL,\n"
                + " gold float NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(AppDatabase());
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean insertNpc(String name, int dmgMax, int dmgMin, int armor,
                             int lifeMax, int lifeMin, int level, int exp, int gold) {

        String sql = "INSERT INTO npcs(name, dmgMax, dmgMin, armor, lifeMax, lifeMin" +
                ", level, exp, gold) values(?,?,?,?,?,?,?,?,?)";

        createNewTableNPCs();

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setInt(2, dmgMax);
            pstmt.setInt(3, dmgMin);
            pstmt.setInt(4, armor);
            pstmt.setInt(5, lifeMax);
            pstmt.setInt(6, lifeMin);
            pstmt.setInt(7, level);
            pstmt.setInt(8, exp);
            pstmt.setInt(9, gold);
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void seeStatsNpcDB(int id) {

        String sql = "SELECT id, name, dmgMax, dmgMin, armor, lifeMax, lifeMin, level, exp," +
                " gold FROM npcs";

        MenuAdmin menuAdm = new MenuAdmin();

        String dbName;
        int dbDmgMax, dbDmgMin, dbArmor, dbLifeMax, dbLifeMin, dbLevel, dbExp, dbGold;

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int dbIdNpc = rs.getInt("id");
                if (dbIdNpc == id) {

                    dbName = rs.getString("name");
                    dbDmgMax = rs.getInt("dmgMax");
                    dbDmgMin = rs.getInt("dmgMin");
                    dbArmor = rs.getInt("armor");
                    dbLifeMax = rs.getInt("lifeMax");
                    dbLifeMin = rs.getInt("lifeMin");
                    dbLevel = rs.getInt("level");
                    dbExp = rs.getInt("exp");
                    dbGold = rs.getInt("gold");

                    menuAdm.seeStatsNpc(dbName, dbDmgMax, dbDmgMin, dbArmor, dbLifeMax,
                            dbLifeMin, dbLevel, dbExp, dbGold);
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean editStatsNpcDB(int id, String name, int dmgMax, int dmgMin, int armor, int lifeMax,
                                  int lifeMin, int level, int exp, int gold) {

        String sql = "UPDATE npcs SET name = ?, dmgMax = ?, dmgMin = ?, armor = ?, lifeMax = ?," +
                " lifeMin = ?, level = ?, exp = ?, gold = ? WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, dmgMax);
            pstmt.setInt(3, dmgMin);
            pstmt.setInt(4, armor);
            pstmt.setInt(5, lifeMax);
            pstmt.setInt(6, lifeMin);
            pstmt.setInt(7, level);
            pstmt.setInt(8, exp);
            pstmt.setInt(9, gold);
            pstmt.setInt(10, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
