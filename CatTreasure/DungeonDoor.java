package CatTreasure;

public class DungeonDoor {
    int doorId;
    Boolean locked;

    //constructor
    public DungeonDoor(int doorId, Boolean locked) {
        this.doorId = doorId;
        this.locked = locked;
    }

    public int getDoor() {
        return this.doorId;
    }
}
