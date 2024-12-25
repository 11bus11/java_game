package CatTreasure;

public class Vaccum extends Mob {
    boolean superAttack;
    int superCharge;
    int superDamage;

    public Vaccum(boolean boss, String mobName, boolean status, int health, int damage, boolean superAttack, int superCharge, int superDamage) {
        super(boss, mobName, status, health, damage);
        this.superAttack = superAttack;
        this.superCharge = superCharge;
        this.superDamage = superDamage;
    }

    public boolean getSuperAttack() {
        return this.superAttack;
    }

    public int getSuperCharge() {
        return this.superCharge;
    }

    public int getSuperDamage() {
        return this.superDamage;
    }
}
