//01:02:00 2024-11-12

class DungeonRoom {
    String roomId; 
    String roomDesc;
    int posX;
    int posY;
    //constructor//
    public DungeonRoom(String roomId) {
        this.roomId = roomId;
        System.out.println("Constructor Called - Room");
    }
    public static void createRoom() {
        DungeonRoom room1 = new DungeonRoom("1");
        room1.roomDesc = "thed";
        room1.posY = 2;
        room1.posX = 1;

        DungeonRoom room2 = new DungeonRoom("2");
        room2.roomDesc = "thefgsgrd";
        room2.posY = 2;
        room2.posX = 1;

        DungeonRoom room3 = new DungeonRoom("3");
        room3.roomDesc = "thed";
        room3.posY = 2;
        room3.posX = 1;

        DungeonRoom room4 = new DungeonRoom("4");
        room4.roomDesc = "thed";
        room4.posY = 2;
        room4.posX = 1;

        DungeonRoom room5 = new DungeonRoom("5");
        room5.roomDesc = "thed";
        room5.posY = 2;
        room5.posX = 1;

        DungeonRoom room6 = new DungeonRoom("6");
        room6.roomDesc = "thed";
        room6.posY = 2;
        room6.posX = 1;
        System.out.println("beep beep running " + room2.roomId);   
    }
    public String getRoomId(){
        return this.roomId;
    }
}

class DungeonDoor{
    String doorId;
    String roomId1;
    String roomId2;
    boolean locked;
    //DungeonRoom connRoom1;
    //DungeonRoom connRoom2;
    //Constructor
    public DungeonDoor(String doorId) {
        this.doorId = doorId;
        System.out.println("Constructor Called - Door");
    }
    //Kopplas till ett eller 2 rum
    public static void createDoor() {
        DungeonDoor door1 = new DungeonDoor("1");
        door1.roomId1 = "1";
    }
}

class SetupGame {
    public static void initialize() {
        DungeonRoom.createRoom();
        DungeonDoor.createDoor();
    }
}

public class PlayGame {
    public static void main(String[] args) {
        SetupGame.initialize();
        System.out.println("running");
    }
}


