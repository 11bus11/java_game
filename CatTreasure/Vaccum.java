package CatTreasure;

public class Vaccum extends Mob {
    int superCharge;
    int superDamage;

    //constructor
    public Vaccum(boolean boss, String mobName, boolean status, int health, int damage, int superCharge, int superDamage) {
        super(boss, mobName, status, health, damage);
        this.superCharge = superCharge;
        this.superDamage = superDamage;
    }

    public int getSuperCharge() {
        return this.superCharge;
    }

    public int getSuperDamage() {
        return this.superDamage;
    }
}
