package gameJava.rolGame;

import java.util.Scanner;

public class MenuAdmin {

    Messages msg = new Messages();
    Scanner scan = new Scanner(System.in);
    DBWork db = new DBWork();


    private String nameNpc;
    private int idNpc, dmgMax, dmgMin, armor, lifeMax, lifeMin, level, exp, gold;

    public void setMenu() {
        MenuAdmin menuAdm = new MenuAdmin();
        msg.print_msg(msg.menuAdmin);
        int option = Integer.parseInt(scan.nextLine());

        switch (option) {
            case 1:
                addNewNpc();
                break;

            case 2:
                msg.print_msg("Select the ID of the npc to see: ");
                idNpc = Integer.parseInt(scan.nextLine());
                db.seeStatsNpcDB(idNpc);

            case 3:
                msg.print_msg("Select the ID of the npc to edit:");
                idNpc = Integer.parseInt(scan.nextLine());
                nameNpc = setNameNpc();
                int[] newStats = menuAdm.editNpc(nameNpc);

                boolean hola = db.editStatsNpcDB(idNpc, nameNpc, newStats[0], newStats[1], newStats[2], newStats[3],
                        newStats[4], newStats[5], newStats[6], newStats[7]);
                System.out.println(hola);

            default:
                setMenu();
                throw new IllegalStateException(msg.errNumeric + option);

        }
    }

    public void seeStatsNpc(String dbNameNpc, int dbDmgMax, int dbDmgMin, int dbArmor, int dbLifeMax, int dbLifeMin,
                            int dbLevel, int dbExp, int dbGold) {

        System.out.println("Npc stats: " + dbNameNpc + "");
        System.out.println(msg.dmgMaxNpc + dbDmgMax + ", " + msg.dmgMinNpc + dbDmgMin + ", " +
                msg.armorNpc + dbArmor + ", " + msg.lifeMaxNpc + dbLifeMax + ", " +
                msg.lifeMinNpc + dbLifeMin + ", " + msg.levelNpc + dbLevel + ", " +
                msg.expNpc + dbExp + ", " + msg.goldNpc + dbGold + "\n\n");

        setMenu();
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

        System.out.println("Are you sure you want to edit the npc?");

        System.out.println(msg.nameNpc + dbNpcName + ", " + msg.dmgMaxNpc + dmgMax + ", " +
                msg.dmgMinNpc + dmgMin + ", " + msg.armorNpc + armor + ", " + msg.lifeMaxNpc +
                lifeMax + ", " + msg.lifeMinNpc + lifeMin + ", " + msg.levelNpc + level + ", " +
                msg.expNpc + exp + ", " + msg.goldNpc + gold);

        if (verifyCreateNewNpc() == 1) {
            System.out.println("NPC EDITADO!!");
            return new int[]{dmgMax, dmgMin, armor,
                    lifeMax, lifeMin, level, exp, gold};
        } else {
            System.out.println("FALLO AL REGISTRAR NPC!!");
        }
        setMenu();
        return new int[]{};
    }

    public void addNewNpc() {

        nameNpc = setNameNpc();
        dmgMax = setDmgMaxNpc();
        dmgMin = setDmgMinNpc();
        armor = setArmorNpc();
        lifeMax = setLifeMaxNpc();
        lifeMin = setLifeMinNpc();
        level = setLevelNpc();
        exp = setExpNpc();
        gold = setGoldNpc();

        System.out.println("Are you sure you want to register the npc?");
        System.out.println(msg.nameNpc + nameNpc + ", " + msg.dmgMaxNpc + dmgMax + ", " +
                msg.dmgMinNpc + dmgMin + ", " + msg.armorNpc + armor + ", " + msg.lifeMaxNpc +
                lifeMax + ", " + msg.lifeMinNpc + lifeMin + ", " + msg.levelNpc + level + ", " +
                msg.expNpc + exp + ", " + msg.goldNpc + gold);

        if (verifyCreateNewNpc() == 1) {
            boolean checkNpcAdd = db.insertNpc(nameNpc, dmgMax, dmgMin, armor,
                    lifeMax, lifeMin, level, exp, gold);
            if (checkNpcAdd) {
                System.out.println("NPC REGISTRADO!!");
            } else {
                System.out.println("FALLO AL REGISTRAR NPC!!");
            }
        }
        setMenu();
    }

    private int verifyCreateNewNpc() {
        System.out.println("1- Yes / 2- No");
        return Integer.parseInt(scan.nextLine());
    }

    private String setNameNpc() {

        System.out.println(msg.nameNpc);
        nameNpc = scan.nextLine();
        return nameNpc;
    }

    private int setDmgMaxNpc() {

        System.out.println(msg.dmgMaxNpc);
        dmgMax = Integer.parseInt(scan.nextLine());
        return dmgMax;
    }

    private int setDmgMinNpc() {

        System.out.println(msg.dmgMinNpc);
        dmgMin = Integer.parseInt(scan.nextLine());
        return dmgMin;
    }

    private int setArmorNpc() {

        System.out.println(msg.armorNpc);
        armor = Integer.parseInt(scan.nextLine());
        return armor;
    }

    private int setLifeMaxNpc() {

        System.out.println(msg.lifeMaxNpc);
        lifeMax = Integer.parseInt(scan.nextLine());
        return lifeMax;
    }

    private int setLifeMinNpc() {

        System.out.println(msg.lifeMinNpc);
        lifeMin = Integer.parseInt(scan.nextLine());
        return lifeMin;
    }

    private int setLevelNpc() {

        System.out.println(msg.levelNpc);
        level = Integer.parseInt(scan.nextLine());
        return level;
    }

    private int setExpNpc() {

        System.out.println(msg.expNpc);
        exp = Integer.parseInt(scan.nextLine());
        return exp;
    }

    private int setGoldNpc() {

        System.out.println(msg.goldNpc);
        gold = Integer.parseInt(scan.nextLine());
        return gold;
    }
}
