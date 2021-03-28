package gameJava.rolGame;

public class Messages {

    public void print_msg(String msg) {
        System.out.println(msg);
    }


    //////////// CONSTANTES PARA LA BASE DE DATOS ////////////
    final String dbConnection = "Database connection: ";
    ///////// FIN DE CONSTANTES PARA LA BASE DE DATOS /////////


    //////////// CONSTANTES PARA EL MANEJO DE ERRORES ////////////
    final String errNumeric = "Unexpected value: ";
    ///////// FIN DE CONSTANTES PARA EL MANEJO DE ERRORES ////////


    /////////// CONSTANTES PARA MENSAJES DE BIENVENIDAS ///////////
    final String welcome = """
            **********************************************************************
            **** Welcome to Game Of Java, we hope you enjoy your stay at GOJ! ****
            **********************************************************************
            """;
    //////// FIN DE CONSTANTES PARA MENSAJES DE BIENVENIDAS ////////


    ///////// CONSTANTES PARA EL LOGIN DE UN USER /////////
    final String login = "To continue, log in...";
    final String setUser = "Enter Username:";
    final String setPass = "Enter Password:";
    /////////// FIN DE CONSTANTES PARA EL LOGIN ///////////


    ///////// CONSTANTES PARA EL REGISTRO DE UN NUEVO USER /////////
    final String register = "To continue, Register...";
    final String setNewUser = "Enter new Username:";
    final String setNewPass = "Enter new Password:";
    final String setNewClass = "Select a class: 1-Warrior, 2-Mage, 3-Archer:";
    ///////// FIN DE CONSTANTES PARA EL REGISTRO DE UN USER /////////


    ///////// CONSTANTES PARA LOS MENU /////////
    final String loginOrRegister = """
            Login or register to continue.
            Type 1-For login o 2-For register""";

    final String menuUser = """
            Welcome select an option to continue ...
            1- Pve Npc
            2- Pvp Users""";

    final String menuAdmin = """
            Select an option to continue:
            1- add new NPCs
            2- see Npc
            3- edit NPCs""";
    ///////// FIN DE CONSTANTES DE MENU /////////


    ///////// CONSTANTES PARA AGREGAR UN NUEVO NPC /////////
    final String nameNpc = "Name: ";
    final String dmgMaxNpc = "DmgMax: ";
    final String dmgMinNpc = "DmgMin: ";
    final String armorNpc = "Armor: ";
    final String lifeMaxNpc = "LifeMax: ";
    final String lifeMinNpc = "LifeMin: ";
    final String levelNpc = "Level: ";
    final String expNpc = "Exp: ";
    final String goldNpc = "Gold: ";
    /////////  FIN DE CONSTANTES PARA AGREGAR NPC /////////

}
