package CatTressure;

//import java.util.ArrayList;

public class DungeonRoom {
    String roomId; 
    String roomDesc;
    int posX;
    int posY;
    //constructor//
    public DungeonRoom(String roomId) {
        this.roomId = roomId;
        System.out.println("Constructor Called - Room");
    }
    

    public String getRoom() {
        return this.roomId;
    }
        

}
