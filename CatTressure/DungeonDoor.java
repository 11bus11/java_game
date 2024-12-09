package CatTressure;

public class DungeonDoor {
    String doorId;
    String roomId1;
    String roomId2;
    boolean locked;
    DungeonRoom conn1;
    DungeonRoom conn2;
    //Constructor
    public DungeonDoor(String doorId) {
        this.doorId = doorId;
        System.out.println("Constructor Called - Door");
    }
    //Kopplas till ett eller 2 rum
    /*public static void createDoor() {
        DungeonDoor door1 = new DungeonDoor("1");
        door1.roomId1 = "1";
    }*/
}
