package gameJava.rolGame.admin;

import gameJava.rolGame.Messages;
import gameJava.rolGame.dbWork.DbNpcs;

import java.util.Scanner;

public class FunctionsNpc extends Messages {
    Messages msg = new Messages();
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

        msg.print(msg.confirmAddNpc);
        msg.print(msg.nameNpc + nameNpc + ", " + msg.dmgMaxNpc + dmgMax + ", " +
                msg.dmgMinNpc + dmgMin + ", " + msg.armorNpc + armor + ", " + msg.lifeMaxNpc +
                lifeMax + ", " + msg.lifeMinNpc + lifeMin + ", " + msg.levelNpc + level + ", " +
                msg.expNpc + exp + ", " + msg.goldNpc + gold);

        if (verifyWorkNpc() == 1) {
            boolean checkNpcAdd = dbNpcs.insertNpcDB(nameNpc, dmgMax, dmgMin, armor,
                    lifeMax, lifeMin, level, exp, gold);
            if (checkNpcAdd) {
                msg.print(msg.npcAdded);
            } else {
                msg.print(msg.npcFailAdded);
            }
        }
        menuAdm.setMenu();
    }

    public void seeStatsNpc(String dbNameNpc, int dbDmgMax, int dbDmgMin, int dbArmor,
                            int dbLifeMax, int dbLifeMin, int dbLevel, int dbExp, int dbGold) {

        msg.print(msg.npcStats + dbNameNpc + "");
        msg.print(msg.dmgMaxNpc + dbDmgMax + ", " + msg.dmgMinNpc + dbDmgMin + ", " +
                msg.armorNpc + dbArmor + ", " + msg.lifeMaxNpc + dbLifeMax + ", " +
                msg.lifeMinNpc + dbLifeMin + ", " + msg.levelNpc + dbLevel + ", " +
                msg.expNpc + dbExp + ", " + msg.goldNpc + dbGold + "\n\n");

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

        msg.print(msg.confirmEditNpc);

        seeInfoNPC(dbNpcName, dmgMax, dmgMin, armor, lifeMax, lifeMin, level, exp, gold);

        if (verifyWorkNpc() == 1) {
            msg.print(msg.npcEdited);
            return new int[]{dmgMax, dmgMin, armor,
                    lifeMax, lifeMin, level, exp, gold};
        } else {
            msg.print(msg.npcFailEdited);
        }
        menuAdm.setMenu();
        return new int[]{};
    }

    public void deleteNpc() {

        DbNpcs dbNpcs = new DbNpcs();

        idNpc = setDeleteIdNpc();
        boolean checkNpcDeleted = dbNpcs.seeStatsNpcDB(idNpc, true);

        msg.print(msg.confirmDeleteNpc);

        if (checkNpcDeleted) {
            if (verifyWorkNpc() == 1) {
                dbNpcs.deleteNpcDB(idNpc);
                msg.print(msg.npcDeleted);
            }
        } else {
            msg.print(msg.npcFailDeleted);
        }
        menuAdm.setMenu();
    }

    public int verifyWorkNpc() {
        msg.print("1- Yes / 2- No");
        return Integer.parseInt(scan.nextLine());
    }

    public int setSeeIdNpc() {

        msg.print(msg.seeNpcID);
        idNpc = Integer.parseInt(scan.nextLine());
        return idNpc;
    }

    public int setEditIdNpc() {

        msg.print(msg.editNpcID);
        idNpc = Integer.parseInt(scan.nextLine());
        return idNpc;
    }

    public int setDeleteIdNpc() {

        msg.print(msg.deleteNpcID);
        idNpc = Integer.parseInt(scan.nextLine());
        return idNpc;
    }

    public String setNameNpc() {

        msg.print(msg.nameNpc);
        nameNpc = scan.nextLine();
        return nameNpc;
    }

    public int setDmgMaxNpc() {

        msg.print(msg.dmgMaxNpc);
        dmgMax = Integer.parseInt(scan.nextLine());
        return dmgMax;
    }

    public int setDmgMinNpc() {

        msg.print(msg.dmgMinNpc);
        dmgMin = Integer.parseInt(scan.nextLine());
        return dmgMin;
    }

    public int setArmorNpc() {

        msg.print(msg.armorNpc);
        armor = Integer.parseInt(scan.nextLine());
        return armor;
    }

    public int setLifeMaxNpc() {

        msg.print(msg.lifeMaxNpc);
        lifeMax = Integer.parseInt(scan.nextLine());
        return lifeMax;
    }

    public int setLifeMinNpc() {

        msg.print(msg.lifeMinNpc);
        lifeMin = Integer.parseInt(scan.nextLine());
        return lifeMin;
    }

    public int setLevelNpc() {

        msg.print(msg.levelNpc);
        level = Integer.parseInt(scan.nextLine());
        return level;
    }

    public int setExpNpc() {

        msg.print(msg.expNpc);
        exp = Integer.parseInt(scan.nextLine());
        return exp;
    }

    public int setGoldNpc() {

        msg.print(msg.goldNpc);
        gold = Integer.parseInt(scan.nextLine());
        return gold;
    }

    public void seeInfoNPC(String name, int dmgMax, int dmgMin, int armor,
                           int lifeMax, int lifeMin, int level, int exp, int gold) {

        msg.print(msg.nameNpc + name + ", " + msg.dmgMaxNpc + dmgMax + ", " +
                msg.dmgMinNpc + dmgMin + ", " + msg.armorNpc + armor + ", " + msg.lifeMaxNpc +
                lifeMax + ", " + msg.lifeMinNpc + lifeMin + ", " + msg.levelNpc + level + ", " +
                msg.expNpc + exp + ", " + msg.goldNpc + gold);
    }
}
