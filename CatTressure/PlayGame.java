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

        //create doors
        DungeonDoor door1 = new DungeonDoor(1, false);
        DungeonDoor door2 = new DungeonDoor(2, true);
        DungeonDoor door3 = new DungeonDoor(3, false);
        DungeonDoor door4 = new DungeonDoor(4, false);
        DungeonDoor door5 = new DungeonDoor(5, false);
        ArrayList <DungeonDoor> arrayDoors = new ArrayList<DungeonDoor>();
        arrayDoors.add(door1);
        arrayDoors.add(door2);
        arrayDoors.add(door3);
        arrayDoors.add(door4);
        arrayDoors.add(door5);

        //Create rooms
        DungeonRoom room1 = new DungeonRoom(1, "thens", null, null, door1);
        DungeonRoom room2 = new DungeonRoom(2, "thens", null, null, door2);
        DungeonRoom room3 = new DungeonRoom(3, "thens", door1, door3, door4);
        DungeonRoom room4 = new DungeonRoom(4, "thens", door2, door3, door4);
        DungeonRoom room5 = new DungeonRoom(5, "thens", door4, null, null);
        DungeonRoom room6 = new DungeonRoom(6, "thens", door5, null, null);

        ArrayList <DungeonRoom> arrayRooms = new ArrayList<DungeonRoom>();
        arrayRooms.add(room1);
        arrayRooms.add(room2);
        arrayRooms.add(room3);
        arrayRooms.add(room4);
        arrayRooms.add(room5);
        arrayRooms.add(room6);
        
        
        

        Player player = new Player(room6, true);
        System.out.println(player.pos);


        //Controlls - variables
        String west = "w";
        boolean statusWest = false;
        String east = "e";
        boolean statusEast = false;
        String north = "n";
        boolean statusNorth = false;
        String south = "s";
        boolean statusSouth = false;

        //FOR-LOOP going thru the array and checking if connroom is there

        int place = 0;
        for (int counter = 0; counter <= 5; counter++) {
            System.out.println(counter);
            System.out.println(place + " place");
            DungeonRoom holderRoom = arrayRooms.get(place);
            
            if (player.getPos() == holderRoom.getRoom()) { 
                System.out.println("yes " + player.pos.roomId);
                place = 0;
                
                for (int counter1 = 0; counter1 <= 4; counter1++) {
                    DungeonDoor holderDoor = arrayDoors.get(place);
                    //testing all doors connected to the players current position
                    if (holderRoom.getConn1() == null) {
                        System.out.println("null door");
                    } else
                    if (holderDoor.getDoor() == holderRoom.getConn1().doorId) {
                        //check which direction door is pointing
                        statusNorth = true;
                        //north
                        System.out.println("north " + holderRoom.getConn1().doorId);
                    }
                    if (holderRoom.getConn2() == null) {
                        System.out.println("null door");
                    } else
                    if (holderDoor.getDoor() == holderRoom.getConn2().doorId) {
                        System.out.println("yes  door " + holderRoom.getConn2().doorId);
                        //west or east (odd or even)
                        if (player.pos.roomId % 2 == 0) {
                            //even
                            statusWest = true;
                        } else 
                        statusEast = true;
                    }
                    if (holderRoom.getConn3() == null) {
                        System.out.println("null door");
                    } else
                    if (holderDoor.getDoor() == holderRoom.getConn3().doorId) {
                        statusSouth = true;
                        System.out.println("yes door " + holderRoom.getConn3().doorId);
                    }
                    place++;
                }
            } else { // Correct else block
                System.out.println("no");
                place++;
            }
            System.out.println("west: " + statusEast + ", north: " + statusNorth + ", south: " + statusSouth + ", west: " + statusWest);
        }
        
    }
}





