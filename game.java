package gameJava;

class Game {

    public static void main(String[] args) {
        DBWork database = new DBWork();

        boolean hola = database.createAppDatabase();
        System.out.println(hola);

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

        System.out.println("Hello World");
    }
}