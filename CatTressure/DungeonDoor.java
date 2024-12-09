package CatTressure;

public class DungeonDoor {
    String doorId;
    Boolean locked;
    DungeonRoom conn1;
    DungeonRoom conn2;
    //Constructor
    public DungeonDoor(String doorId, Boolean locked, DungeonRoom conn1, DungeonRoom conn2) {
        this.doorId = doorId;
        this.locked = locked;
        this.conn1 = conn1;
        this.conn2 = conn2;
        //System.out.println("Constructor Called - Door");
    }
}
