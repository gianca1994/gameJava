package gameJava.rolGame;

class Game {

    public static void main(String[] args) {
        DBWork database = new DBWork();
        Users users = new Users();

        /* Personaje personaje = new Personaje("gianca", "123456", "Mage",
                18, 18, 25, 20, 15,
                100, 100, 100, 1, 0, 150);
        */

        boolean verifyCreateDb = database.createAppDatabase();
        System.out.println("Database connection: " + verifyCreateDb + "\n");

        users.loginUser();


    }

        /*
        database.createNewTable();

        database.insert("gianca", "123456", "Mage",
                18, 18, 25, 20, 15,
                100, 100, 100, 1, 0, 150);

        database.insert("juampi", "951357", "Archer",
                18, 25, 18, 25, 20,
                150, 150, 150, 1, 0, 150);

        database.insert("lauti", "987654321", "Warrior",
                25, 18, 18, 15, 25,
                250, 250, 250, 1, 0, 150);

        // Testeo de cargar variables en la clase PERSONAJE y mostrarlos...
        String name;
        String _class;
        int level;

        name = personaje.getName();
        _class = personaje.get_class();
        level = personaje.getLevel();

        System.out.println(name + " " + _class + " " + level);

*/
}