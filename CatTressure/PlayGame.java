package CatTressure;
//01:02:00 2024-11-12


import java.util.ArrayList;

public class PlayGame {
    public void createRoom() {
        DungeonRoom room1 = new DungeonRoom("1");
        room1.roomDesc = "hfjdjd";

        
    }

    public static void main(String[] args) {
        //SetupGame.initialize();
        //PlayGame.createRoom();


        //Create rooms
        DungeonRoom room1 = new DungeonRoom("1", "thens");
        DungeonRoom room2 = new DungeonRoom("2", "thens");
        DungeonRoom room3 = new DungeonRoom("3", "thens");
        DungeonRoom room4 = new DungeonRoom("4", "thens");
        DungeonRoom room5 = new DungeonRoom("5", "thens");
        DungeonRoom room6 = new DungeonRoom("6", "thens");

        ArrayList <DungeonRoom> arrayRooms = new ArrayList<DungeonRoom>();
        arrayRooms.add(room1);
        arrayRooms.add(room2);
        arrayRooms.add(room3);
        arrayRooms.add(room4);
        arrayRooms.add(room5);
        arrayRooms.add(room6);
        
        
        //create doors
        DungeonDoor door1 = new DungeonDoor("1", false, room1, room2);
        Player player = new Player(room6, true);


        //FOR-LOOP going thru the array and checking if connroom is there


        //Controlls - variables
        String west = "w";
        String east = "e";
        String north = "n";
        String south = "s";
        System.out.println("running " + arrayRooms.get(0).roomId);

    }
}


