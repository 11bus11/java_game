package CatTressure;

public class DungeonDoor {
    int doorId;
    Boolean locked;

    //Constructor
    public DungeonDoor(int doorId, Boolean locked) {
        this.doorId = doorId;
        this.locked = locked;
        //System.out.println("Constructor Called - Door");
    }

    public int getDoor() {
        return this.doorId;
    }
}
