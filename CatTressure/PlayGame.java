package CatTressure;
//01:02:00 2024-11-12

import java.util.ArrayList;

public class PlayGame {
    public void createRoom() {
        DungeonRoom room1 = new DungeonRoom("1");
        room1.roomDesc = "hfjdjd";

        
    }

    public static void main(String[] args) {
        SetupGame.initialize();
        //PlayGame.createRoom();

        //Create rooms
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

        ArrayList <DungeonRoom> arrayRooms = new ArrayList<DungeonRoom>();
        arrayRooms.add(room1);
        arrayRooms.add(room2);
        arrayRooms.add(room3);
        arrayRooms.add(room4);
        arrayRooms.add(room5);
        arrayRooms.add(room6);
        
        
        //create doors
        DungeonDoor door1 = new DungeonDoor("1");
        door1.conn1 = room1;
        door1.conn2 = room2;

        //FOR-LOOP going thru the array and checking if connroom is there


        System.out.println("running " + arrayRooms.get(0).roomId);

    }
}


