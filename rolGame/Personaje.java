package gameJava.rolGame;


public class Personaje {

    // Atributos BASICOS de cada personaje...
    private int str, agi, _int, speed, life;

    // Atributos secundarios BASICOS de cada personaje...
    private int armor, lifeMax, lifeMin;

    // Stats BASICOS
    private final int level = 1;
    private final int exp = 0;
    private final int expUp = 150;


    public int[] Warrior() {

        str = 17;
        agi = 12;
        _int = 5;
        speed = 9;
        life = 15;

        armor = 35;
        lifeMax = 250;
        lifeMin = 250;

        return new int[]{str, agi, _int, speed, life, armor,
                lifeMax, lifeMin, level, exp, expUp};
    }

    public int[] Mage() {

        str = 7;
        agi = 9;
        _int = 17;
        speed = 11;
        life = 9;

        armor = 20;
        lifeMax = 100;
        lifeMin = 100;

        return new int[] {str, agi, _int, speed, life, armor,
                lifeMax, lifeMin, level, exp, expUp};
    }

    public int[] Archer() {

        str = 11;
        agi = 17;
        _int = 7;
        speed = 11;
        life = 13;

        armor = 27;
        lifeMax = 150;
        lifeMin = 150;

        return new int[] {str, agi, _int, speed, life, armor,
                lifeMax, lifeMin, level, exp, expUp};
    }
}