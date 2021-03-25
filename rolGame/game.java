package gameJava.rolGame;


class Game {

    public static void main(String[] args) {
        DBWork database = new DBWork();
        Users users = new Users();


        boolean verifyCreateDb = database.createAppDatabase();
        System.out.println("Database connection: " + verifyCreateDb + "\n");

        // PARA REGISTRAR...
        users.registerUser();

        // PARA LOGUEAR
        users.loginUser();


    }
}