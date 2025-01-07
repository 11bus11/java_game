package CatTreasure;

public class Player {
    DungeonRoom pos;
    Boolean status;
    int health;
    int damage;

    //constructor
    public Player(DungeonRoom pos, Boolean status, int health, int damage) {
        this.pos = pos;
        this.status = status;
        this.health = health;
        this.damage = damage;
    }

    public int getPos() {
        return this.pos.roomId;
    }

    public boolean getStatus() {
        return this.status;
    }

    public int getHealth() {
        return this.health;
    }

    public int healingHealth(int healing) {
        this.health = this.health + healing; 
        return this.health;
    }
}
