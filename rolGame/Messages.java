package rolGame;

public class Messages {

    public static void print(String msg) {
        System.out.println(msg);
    }

    //////////// CONSTANTES PARA LA BASE DE DATOS ////////////
    public static final String DB_CONNECTION = "Database connection: ";
    public static final String APP_NAME = "DataBase";
    public static final String DB_PATCH = "src/rolGame/";
    public static final String DB_TYPE = "jdbc:sqlite:";
    public static final String DB_EXTENSION = ".db";
    ///////// FIN DE CONSTANTES PARA LA BASE DE DATOS /////////


    //////////// CONSTANTES PARA EL MANEJO DE ERRORES ////////////
    public static final String ERR_NUMERIC = "Unexpected value: ";
    ///////// FIN DE CONSTANTES PARA EL MANEJO DE ERRORES ////////


    /////////// CONSTANTES PARA MENSAJES DE BIENVENIDAS ///////////
    public static final String WELCOME = """
            **********************************************************************
            **** Welcome to Game Of Java, we hope you enjoy your stay at GOJ! ****
            **********************************************************************
            """;
    //////// FIN DE CONSTANTES PARA MENSAJES DE BIENVENIDAS ////////


    ///////// CONSTANTES PARA EL LOGIN DE UN USER /////////
    public static final String LOGIN = "To continue, log in...";
    public static final String SET_USER = "Enter Username:";
    public static final String SET_PASS = "Enter Password:";
    public static final String ERROR_LOGIN = "¡¡Error trying to login!!";
    public static final String USER_REGISTERED = "¡¡Registered user!!";
    public static final String ERROR_USER_REGISTERED = "¡¡Error trying to register!!";

    /////////// FIN DE CONSTANTES PARA EL LOGIN ///////////


    ///////// CONSTANTES PARA EL REGISTRO DE UN NUEVO USER /////////
    public static final String REGISTER = "To continue, Register...";
    public static final String SET_NEW_USER = "Enter new Username:";
    public static final String SET_NEW_PASS = "Enter new Password:";
    public static final String SET_NEW_CLASS = "Select a class: 1-Warrior, 2-Mage, 3-Archer:";
    ///////// FIN DE CONSTANTES PARA EL REGISTRO DE UN USER /////////


    ///////// CONSTANTES PARA LOS MENU /////////
    public static final String LOGIN_REGISTER = """
            Login or register to continue.
            Type 1-For login o 2-For register""";

    public static final String MENU_USER = """
            Welcome select an option to continue ...
            1- Pve Npc
            2- Pvp Users""";

    public static final String MENU_ADMIN = """
            Select an option to continue:
            1- Work NPCs
            2- Work Users
            3- Exit""";

    public static final String MENU_NPC_ADMIN = """
            Select an option to continue:
            1- Add new NPC
            2- See Npc
            3- Edit NPC
            4- Delete Npc
            5- Exit""";

    public static final String MENU_USER_ADMIN = """
            Select an option to continue:
            1- See User
            2- Exit""";
    ///////// FIN DE CONSTANTES DE MENU /////////


    ///////// CONSTANTES PARA AGREGAR UN NUEVO NPC /////////
    public static final String NAME_NPC = "Name: ";
    public static final String DMG_MAX_NPC = "DmgMax: ";
    public static final String DMG_MIN_NPC = "DmgMin: ";
    public static final String ARMOR_NPC = "Armor: ";
    public static final String LIFE_MAX_NPC = "LifeMax: ";
    public static final String LIFE_MIN_NPC = "LifeMin: ";
    public static final String LEVE_NPC = "Level: ";
    public static final String EXP_NPC = "Exp: ";
    public static final String GOLD_NPC = "Gold: ";
    /////////  FIN DE CONSTANTES PARA AGREGAR NPC /////////


    //////////// CONSTANTES PARA LOS USUARIOS ////////////
    public static final String NAME_USER = "Name: ";
    public static final String PASS_USER = "Password: ";
    public static final String CLASS_USER = "Class: ";
    public static final String STR_USER = "Str: ";
    public static final String AGI_USER = "Agi: ";
    public static final String INT_USER = "Int: ";
    public static final String SPEED_USER = "Speed: ";
    public static final String LIFE_USER = "Life: ";
    public static final String ARMOR_USER = "Armor: ";
    public static final String LIFE_MAX_USER = "lifeMax: ";
    public static final String LIFE_MIN_USER = "lifeMin: ";
    public static final String LEVEL_USER = "Level: ";
    public static final String EXP_USER = "Exp: ";
    public static final String EXP_UP_USER = "ExpUp: ";
    public static final String ADM_USER = "Admin: ";
    /////////  FIN DE CONSTANTES PARA LOS USUARIOS /////////


    /////////////// CONSTANTES PARA EL ADMIN ///////////////
    public static final String SEE_NPC_ID = "Select the ID of the npc to see: ";
    public static final String NPC_STATS = "Npc stats: ";

    public static final String CONFIRM_ADD_NPC = "Are you sure you want to add the npc?";
    public static final String NPC_ADDED = "¡¡Npc added!!";
    public static final String NPC_FAIL_ADDED = "¡¡Error adding the npc!!";

    public static final String EDIT_NPC_ID = "Select the ID of the npc to edit:";
    public static final String CONFIRM_EDIT_NPC = "Are you sure you want to edit the npc?";
    public static final String NPC_EDITED = "¡¡Npc Edited!!";
    public static final String NPC_FAIL_EDITED = "¡¡Error editing the npc!!";

    public static final String DELETE_NPC_IP = "Select the ID of the npc to delete:";
    public static final String CONFIRM_DELETE_NPC = "Are you sure you want to delete the npc?";
    public static final String NPC_DELETED = "¡¡Npc Deleted!!";
    public static final String NPC_FAIL_DELETED = "¡¡Error deleting the npc!!";

    /////////// FIN DE CONSTANTES PARA NPC Y COMIENZO DE CONSTANTES PARA USUARIO ///////////

    public static final String SEE_USER_ID = "Select the ID of the user to see: ";
    /////////// FIN DE CONSTANTES PARA EL ADMIN ///////////

}
