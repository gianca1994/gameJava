package gameJava.rolGame;

public class Messages {

    public void print_msg(String msg){
        System.out.println(msg);
    }

    final String welcome ="""
                        **********************************************************************
                        **** Welcome to Game Of Java, we hope you enjoy your stay at GOJ! ****
                        **********************************************************************
                        """;

    final String loginOrRegister= """
                                Login or register to continue.
                                Type 1-For login o 2-For register""";

    final String login= "To continue, log in...";
    final String setUser = "Enter Username:";
    final String setPass = "Enter Password:";

    final String register= "To continue, Register...";
    final String setNewUser = "Enter new Username:";
    final String setNewPass = "Enter new Password:";
    final String setNewClass = "Select a class: 1-Warrior, 2-Mage, 3-Archer:";

    final String dbConnection = "Database connection: ";

    final String errNumeric = "Unexpected value: ";
}
