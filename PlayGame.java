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
    public DungeonRoom(String desc) {
        desc = roomDesc;
        //x = posX;
        //y = posY;

        System.out.println("Constructor Called");
    
    }
    public static void createRoom() {
        DungeonRoom room1 = new DungeonRoom("rer");
        room1.posY = 2;
        room1.roomDesc = "gr";
        System.out.println("beep beep running " + room1.posY);
    }
}

public class PlayGame {
    public static void main(String[] args) {
        DungeonRoom.createRoom();
        System.out.println("running");
    }
}


