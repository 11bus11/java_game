//01:02:00 2024-11-12

class catTressure {

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

        DungeonRoom room2 = new DungeonRoom();
        room2.roomDesc = "thefgsgrd";
        room2.posY = 2;
        room2.posX = 1;

        DungeonRoom room3 = new DungeonRoom();
        room3.roomDesc = "thed";
        room3.posY = 2;
        room3.posX = 1;

        DungeonRoom room4 = new DungeonRoom();
        room4.roomDesc = "thed";
        room4.posY = 2;
        room4.posX = 1;

        DungeonRoom room5 = new DungeonRoom();
        room5.roomDesc = "thed";
        room5.posY = 2;
        room5.posX = 1;

        DungeonRoom room6 = new DungeonRoom();
        room6.roomDesc = "thed";
        room6.posY = 2;
        room6.posX = 1;
        System.out.println("beep beep running " + room2.roomDesc);
        
        
    }
    public String getRoom(){
        return room1;
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


