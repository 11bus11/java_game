package CatTreasure;

public class Mob {
    String mobName;
    boolean status;
    int health;
    int damage;

    public Mob(String mobName, boolean status, int health, int damage) {
        this.mobName = mobName;
        this.status = status;
        this.health = health;
        this.damage = damage;
    }

    public String getMobName() {
        return this.mobName;
    }

    public boolean getStatus() {
        return this.status;
    }

    public int getHealth() {
        return this.health;
    }

    public int getDamage() {
        return this.damage;
    }
}
