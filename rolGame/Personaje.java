package gameJava.rolGame;

public class Personaje {
    private final String name;
    private String password;
    private String _class;

    private int str, agi, _int, speed, life;
    private int armor, lifeMax, lifeMin, level, exp, expUp;


    public Personaje(String userName, String userPass, String userClass, int userStr, int userAgi,
                     int userInt, int userSpeed, int userLife, int userArmor, int userLifeMax,
                     int userLifeMin, int userLevel, int userExp, int userExpUp) {

        // Atributos base de cada personaje...
        name = userName;
        password = userPass;
        _class = userClass;

        // Atributos principales de cada personaje...
        str = userStr;
        agi = userAgi;
        _int = userInt;
        speed = userSpeed;
        life = userLife;

        // Atributos secundarios de cada personaje...
        armor = userArmor;
        lifeMax = userLifeMax;
        lifeMin = userLifeMin;
        level = userLevel;
        exp = userExp;
        expUp = userExpUp;
    }


    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String get_class() {
        return _class;
    }

    public int getStr() {
        return str;
    }

    public int getAgi() {
        return agi;
    }

    public int get_int() {
        return _int;
    }

    public int getSpeed() {
        return speed;
    }

    public int getLife() {
        return life;
    }

    public int getArmor() {
        return armor;
    }

    public int getLifeMax() {
        return lifeMax;
    }

    public int getLifeMin() {
        return lifeMin;
    }

    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    public int getExpUp() {
        return expUp;
    }
}