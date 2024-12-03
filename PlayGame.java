class catTressure {
    //private int pos;//
    public catTressure() {
    }
    catTressure game = new catTressure();
    
}

class DungeonRoom {
    String roomDesc;
    int posX;
    int posY;
    //constructor//
    public DungeonRoom() {
        System.out.println("Constructor Called - Room");
    }
    public static void createRoom() {
        DungeonRoom room1 = new DungeonRoom();
        room1.roomDesc = "thed";
        room1.posY = 2;
        room1.posX = 1;
        System.out.println("beep beep running " + room1.roomDesc);
    }
}

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


