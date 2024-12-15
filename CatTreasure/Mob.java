package CatTreasure;

public class Mob {
    int mobId;
    boolean status;
    int health;
    int damage;

    public Mob(int mobId, boolean status, int health, int damage) {
        this.mobId = mobId;
        this.status = status;
        this.health = health;
        this.damage = damage;
    }

    public int getMobId() {
        return this.mobId;
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
