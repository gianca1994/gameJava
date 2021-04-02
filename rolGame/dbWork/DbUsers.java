package rolGame.dbWork;

import rolGame.admin.FunctionsUsers;
import rolGame.admin.MenuAdmin;
import rolGame.models.Personaje;
import rolGame.users.MenuUser;

import java.sql.*;

public class DbUsers {

    DbConnect dbConnect = new DbConnect();
    MenuAdmin AdmMenu = new MenuAdmin();
    MenuUser UserMenu = new MenuUser();

    public void createNewTableUser() {

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

        try (Connection conn = DriverManager.getConnection(dbConnect.AppDatabase());
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean insertUser(String name, String password, int _class) {

        String sql = "INSERT INTO users(name, password, clase, strength, agillity, intelligence" +
                ", speed, life, armor, lifeMax, lifeMin, level, exp, expUp, adm) values(?,?,?,?,?,?,?,?," +
                "?,?,?,?,?,?,?)";

        Personaje statsPj = new Personaje();

        int[] statsWar = statsPj.Warrior();
        int[] statsMage = statsPj.Mage();
        int[] statsArch = statsPj.Archer();

        createNewTableUser();

        try (Connection conn = this.dbConnect.connect();
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

    public boolean loginDB(String userName, String userPass) {

        String sql = "SELECT name, password, adm FROM users";


        try (Connection conn = this.dbConnect.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String dbUsers = rs.getString("name");
                if (dbUsers.equals(userName)) {

                    String dbPass = rs.getString("password");
                    if (dbPass.equals(userPass)) {

                        boolean dbAdmin = rs.getBoolean("adm");

                        if (dbAdmin) {
                            AdmMenu.setMenu();
                        } else {
                            UserMenu.setMenu();
                        }
                        return true;
                    }
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean seeStatsUserDB(int id, boolean delete) {

        String sql = "SELECT id, name, password, clase, strength, agillity, intelligence, " +
                "speed, life, armor, lifeMax, lifeMin, level, exp, expUp, adm FROM users";

        FunctionsUsers functionsUsers = new FunctionsUsers();

        String name, password, clase;
        int strength, agillity, intelligence, speed, life, armor, lifeMax, lifeMin, level,
                exp, expUp, adm;

        try (Connection conn = this.dbConnect.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int dbIdNpc = rs.getInt("id");
                if (dbIdNpc == id) {

                    name = rs.getString("name");
                    password = rs.getString("password");
                    clase = rs.getString("clase");
                    strength = rs.getInt("strength");
                    agillity = rs.getInt("agillity");
                    intelligence = rs.getInt("intelligence");
                    speed = rs.getInt("speed");
                    life = rs.getInt("life");
                    armor = rs.getInt("armor");
                    lifeMax = rs.getInt("lifeMax");
                    lifeMin = rs.getInt("lifeMin");
                    level = rs.getInt("level");
                    exp = rs.getInt("exp");
                    expUp = rs.getInt("expUp");
                    adm = rs.getInt("adm");


                    if (delete) {
                        //function.seeInfoNPC(dbName, dbDmgMax, dbDmgMin, dbArmor, dbLifeMax,
                        //        dbLifeMin, dbLevel, dbExp, dbGold);

                        return true;
                    } else {
                        functionsUsers.seeStatsUser(name, password, clase, strength, agillity,
                                intelligence, speed, life, armor, lifeMax, lifeMin,
                                level, exp, expUp, adm);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
