package gameJava.rolGame.dbWork;

import gameJava.rolGame.admin.FunctionsNpc;

import java.sql.*;

public class DbNpcs {

    DbConnect dbConnect = new DbConnect();
    FunctionsNpc function = new FunctionsNpc();

    public void createNewTableNPCsDB() {

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

        try (Connection conn = DriverManager.getConnection(dbConnect.AppDatabase());
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean insertNpcDB(String name, int dmgMax, int dmgMin, int armor,
                               int lifeMax, int lifeMin, int level, int exp, int gold) {

        String sql = "INSERT INTO npcs(name, dmgMax, dmgMin, armor, lifeMax, lifeMin" +
                ", level, exp, gold) values(?,?,?,?,?,?,?,?,?)";

        createNewTableNPCsDB();

        try (Connection conn = this.dbConnect.connect();
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

    public boolean seeStatsNpcDB(int id, boolean delete) {

        String sql = "SELECT id, name, dmgMax, dmgMin, armor, lifeMax, lifeMin, level, exp," +
                " gold FROM npcs";

        String dbName;
        int dbDmgMax, dbDmgMin, dbArmor, dbLifeMax, dbLifeMin, dbLevel, dbExp, dbGold;

        try (Connection conn = this.dbConnect.connect();
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

                    if (delete) {
                        function.seeInfoNPC(dbName, dbDmgMax, dbDmgMin, dbArmor, dbLifeMax,
                                dbLifeMin, dbLevel, dbExp, dbGold);

                        return true;
                    } else {
                        function.seeStatsNpc(dbName, dbDmgMax, dbDmgMin, dbArmor, dbLifeMax,
                                dbLifeMin, dbLevel, dbExp, dbGold);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean editStatsNpcDB(int id, String name, int dmgMax, int dmgMin, int armor, int lifeMax,
                                  int lifeMin, int level, int exp, int gold) {

        String sql = "UPDATE npcs SET name = ?, dmgMax = ?, dmgMin = ?, armor = ?, lifeMax = ?," +
                " lifeMin = ?, level = ?, exp = ?, gold = ? WHERE id = ?";

        try (Connection conn = this.dbConnect.connect();
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

    public void deleteNpcDB(int id) {
        String sql = "DELETE FROM npcs WHERE id = ?";

        try (Connection conn = this.dbConnect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
