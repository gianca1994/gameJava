package rolGame.admin;

import static rolGame.Messages.*;
import rolGame.dbWork.DbNpcs;

import java.util.Scanner;

public class FunctionsNpc {
    Scanner scan = new Scanner(System.in);
    MenuAdmin menuAdm = new MenuAdmin();

    private String nameNpc;
    private int idNpc, dmgMax, dmgMin, armor, lifeMax, lifeMin, level, exp, gold;

    public void addNewNpc() {

        DbNpcs dbNpcs = new DbNpcs();

        nameNpc = setNameNpc();
        dmgMax = setDmgMaxNpc();
        dmgMin = setDmgMinNpc();
        armor = setArmorNpc();
        lifeMax = setLifeMaxNpc();
        lifeMin = setLifeMinNpc();
        level = setLevelNpc();
        exp = setExpNpc();
        gold = setGoldNpc();

        print(CONFIRM_ADD_NPC);
        print(nameNpc + nameNpc + ", " + DMG_MAX_NPC + dmgMax + ", " +
                DMG_MIN_NPC + dmgMin + ", " + ARMOR_NPC + armor + ", " + LIFE_MAX_NPC +
                lifeMax + ", " + LIFE_MIN_NPC + lifeMin + ", " + LEVE_NPC + level + ", " +
                EXP_NPC + exp + ", " + GOLD_NPC + gold);

        if (verifyWorkNpc() == 1) {
            boolean checkNpcAdd = dbNpcs.insertNpcDB(nameNpc, dmgMax, dmgMin, armor,
                    lifeMax, lifeMin, level, exp, gold);
            if (checkNpcAdd) {
                print(NPC_ADDED);
            } else {
                print(NPC_FAIL_ADDED);
            }
        }
        menuAdm.setMenu();
    }

    public void seeStatsNpc(String dbNameNpc, int dbDmgMax, int dbDmgMin, int dbArmor,
                            int dbLifeMax, int dbLifeMin, int dbLevel, int dbExp, int dbGold) {

        print(NPC_STATS + dbNameNpc + "");
        print(DMG_MAX_NPC + dbDmgMax + ", " + DMG_MIN_NPC + dbDmgMin + ", " +
                ARMOR_NPC + dbArmor + ", " + LIFE_MAX_NPC + dbLifeMax + ", " +
                LIFE_MIN_NPC + dbLifeMin + ", " + LEVE_NPC + dbLevel + ", " +
                EXP_NPC + dbExp + ", " + GOLD_NPC + dbGold + "\n\n");

        menuAdm.setMenu();
    }

    public int[] editNpc(String dbNpcName) {

        dmgMax = setDmgMaxNpc();
        dmgMin = setDmgMinNpc();
        armor = setArmorNpc();
        lifeMax = setLifeMaxNpc();
        lifeMin = setLifeMinNpc();
        level = setLevelNpc();
        exp = setExpNpc();
        gold = setGoldNpc();

        print(CONFIRM_EDIT_NPC);

        seeInfoNPC(dbNpcName, dmgMax, dmgMin, armor, lifeMax, lifeMin, level, exp, gold);

        if (verifyWorkNpc() == 1) {
            print(NPC_EDITED);
            return new int[]{dmgMax, dmgMin, armor,
                    lifeMax, lifeMin, level, exp, gold};
        } else {
            print(NPC_FAIL_EDITED);
        }
        menuAdm.setMenu();
        return new int[]{};
    }

    public void deleteNpc() {

        DbNpcs dbNpcs = new DbNpcs();

        idNpc = setDeleteIdNpc();
        boolean checkNpcDeleted = dbNpcs.seeStatsNpcDB(idNpc, true);

        print(CONFIRM_DELETE_NPC);

        if (checkNpcDeleted) {
            if (verifyWorkNpc() == 1) {
                dbNpcs.deleteNpcDB(idNpc);
                print(NPC_DELETED);
            }
        } else {
            print(NPC_FAIL_DELETED);
        }
        menuAdm.setMenu();
    }

    public int verifyWorkNpc() {
        print("1- Yes / 2- No");
        return Integer.parseInt(scan.nextLine());
    }

    public int setSeeIdNpc() {

        print(SEE_NPC_ID);
        idNpc = Integer.parseInt(scan.nextLine());
        return idNpc;
    }

    public int setEditIdNpc() {

        print(EDIT_NPC_ID);
        idNpc = Integer.parseInt(scan.nextLine());
        return idNpc;
    }

    public int setDeleteIdNpc() {

        print(DELETE_NPC_IP);
        idNpc = Integer.parseInt(scan.nextLine());
        return idNpc;
    }

    public String setNameNpc() {

        print(nameNpc);
        nameNpc = scan.nextLine();
        return nameNpc;
    }

    public int setDmgMaxNpc() {

        print(DMG_MAX_NPC);
        dmgMax = Integer.parseInt(scan.nextLine());
        return dmgMax;
    }

    public int setDmgMinNpc() {

        print(DMG_MIN_NPC);
        dmgMin = Integer.parseInt(scan.nextLine());
        return dmgMin;
    }

    public int setArmorNpc() {

        print(ARMOR_NPC);
        armor = Integer.parseInt(scan.nextLine());
        return armor;
    }

    public int setLifeMaxNpc() {

        print(LIFE_MAX_NPC);
        lifeMax = Integer.parseInt(scan.nextLine());
        return lifeMax;
    }

    public int setLifeMinNpc() {

        print(LIFE_MIN_NPC);
        lifeMin = Integer.parseInt(scan.nextLine());
        return lifeMin;
    }

    public int setLevelNpc() {

        print(LEVE_NPC);
        level = Integer.parseInt(scan.nextLine());
        return level;
    }

    public int setExpNpc() {

        print(EXP_NPC);
        exp = Integer.parseInt(scan.nextLine());
        return exp;
    }

    public int setGoldNpc() {

        print(GOLD_NPC);
        gold = Integer.parseInt(scan.nextLine());
        return gold;
    }

    public void seeInfoNPC(String name, int dmgMax, int dmgMin, int armor,
                           int lifeMax, int lifeMin, int level, int exp, int gold) {

        print(nameNpc + name + ", " + DMG_MAX_NPC + dmgMax + ", " +
                DMG_MIN_NPC + dmgMin + ", " + ARMOR_NPC + armor + ", " + LIFE_MAX_NPC +
                lifeMax + ", " + LIFE_MIN_NPC + lifeMin + ", " + LEVE_NPC + level + ", " +
                EXP_NPC + exp + ", " + GOLD_NPC + gold);
    }
}
