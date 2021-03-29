package gameJava.rolGame;

public class Messages {

    public void print(String msg) {
        System.out.println(msg);
    }


    //////////// CONSTANTES PARA LA BASE DE DATOS ////////////
    public final String dbConnection = "Database connection: ";
    public final String appName = "DataBase";
    public final String dbPatch = "gameJava/rolGame/";
    public final String dbType = "jdbc:sqlite:";
    public final String dbExtension = ".db";
    ///////// FIN DE CONSTANTES PARA LA BASE DE DATOS /////////


    //////////// CONSTANTES PARA EL MANEJO DE ERRORES ////////////
    public final String errNumeric = "Unexpected value: ";
    ///////// FIN DE CONSTANTES PARA EL MANEJO DE ERRORES ////////


    /////////// CONSTANTES PARA MENSAJES DE BIENVENIDAS ///////////
    public final String welcome = """
            **********************************************************************
            **** Welcome to Game Of Java, we hope you enjoy your stay at GOJ! ****
            **********************************************************************
            """;
    //////// FIN DE CONSTANTES PARA MENSAJES DE BIENVENIDAS ////////


    ///////// CONSTANTES PARA EL LOGIN DE UN USER /////////
    public final String login = "To continue, log in...";
    public final String setUser = "Enter Username:";
    public final String setPass = "Enter Password:";
    public final String errorLogin = "¡¡Error trying to login!!";
    public final String userRegistered = "¡¡Registered user!!";
    public final String errorUserRegistered = "¡¡Error trying to register!!";

    /////////// FIN DE CONSTANTES PARA EL LOGIN ///////////


    ///////// CONSTANTES PARA EL REGISTRO DE UN NUEVO USER /////////
    public final String register = "To continue, Register...";
    public final String setNewUser = "Enter new Username:";
    public final String setNewPass = "Enter new Password:";
    public final String setNewClass = "Select a class: 1-Warrior, 2-Mage, 3-Archer:";
    ///////// FIN DE CONSTANTES PARA EL REGISTRO DE UN USER /////////


    ///////// CONSTANTES PARA LOS MENU /////////
    public final String loginOrRegister = """
            Login or register to continue.
            Type 1-For login o 2-For register""";

    public final String menuUser = """
            Welcome select an option to continue ...
            1- Pve Npc
            2- Pvp Users""";

    public final String menuAdmin = """
            Select an option to continue:
            1- add new NPCs
            2- see Npc
            3- edit NPCs""";
    ///////// FIN DE CONSTANTES DE MENU /////////


    ///////// CONSTANTES PARA AGREGAR UN NUEVO NPC /////////
    public final String nameNpc = "Name: ";
    public final String dmgMaxNpc = "DmgMax: ";
    public final String dmgMinNpc = "DmgMin: ";
    public final String armorNpc = "Armor: ";
    public final String lifeMaxNpc = "LifeMax: ";
    public final String lifeMinNpc = "LifeMin: ";
    public final String levelNpc = "Level: ";
    public final String expNpc = "Exp: ";
    public final String goldNpc = "Gold: ";
    /////////  FIN DE CONSTANTES PARA AGREGAR NPC /////////


    /////////////// CONSTANTES PARA EL ADMIN ///////////////
    public final String seeNpcID = "Select the ID of the npc to see: ";
    public final String editNpcID = "Select the ID of the npc to edit:";
    public final String npcStats = "Npc stats: ";
    public final String confirmAddNpc = "Are you sure you want to add the npc?";
    public final String confirmEditNpc = "Are you sure you want to edit the npc?";
    public final String npcEdited = "¡¡Npc Edited!!";
    public final String npcFailEdited = "¡¡Error editing the npc!!";
    public final String npcAdded = "¡¡Npc added!!";
    public final String npcFailAdded = "¡¡Error adding the npc!!";
    /////////// FIN DE CONSTANTES PARA EL ADMIN ///////////

}
