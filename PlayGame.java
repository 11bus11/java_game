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
        //desc = roomDesc;
        //x = posX;
        //y = posY;

        System.out.println("Constructor Called");
    
    }
    public static void createRoom() {
        //final String room1 = "room1";
        DungeonRoom room1 = new DungeonRoom();
        room1.roomDesc = "thed";
        room1.posY = 2;
        room1.posX = 1;
        System.out.println("beep beep running " + room1.roomDesc);
    }
}

public class PlayGame {
    public static void main(String[] args) {
        DungeonRoom.createRoom();
        System.out.println("running");
    }
}


