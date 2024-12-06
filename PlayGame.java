//01:02:00 2024-11-12




class DungeonDoor {
    DungeonRoom connRoom1;
    DungeonRoom connRoom2;
    //Constructor
    public DungeonDoor() {
        System.out.println("Constructor Called - Door");
    }
    //Kopplas till ett eller 2 rum
    public static void createDoor() {
        DungeonDoor door1 = new DungeonDoor();
        door1.connRoom1 = DungeonRoom.room1; //how to access? Possible?
    }
}

public class PlayGame {
    public static void main(String[] args) {
        DungeonRoom.createRoom();
        System.out.println("running");
    }
}


