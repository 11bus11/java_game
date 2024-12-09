package CatTressure;

//import java.util.ArrayList;

public class DungeonRoom {
    String roomId; 
    String roomDesc;

    //constructor//
    public DungeonRoom(String roomId, String roomDesc) {
        this.roomId = roomId;
        //System.out.println("Constructor Called - Room");
    }



    public String getRoom() {
        return this.roomId;
    }
        

}
