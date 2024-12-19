package CatTreasure;

public class Vaccum extends Mob {
    boolean superAttack;
    int superDamage;

    public Vaccum(String type, String mobName, boolean status, int health, int damage, boolean superAttack, int superDamage) {
        super(type, mobName, status, health, damage);
        this.superAttack = superAttack;
        this.superDamage = superDamage;
    }
}
