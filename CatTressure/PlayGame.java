package CatTressure;
//01:02:00 2024-11-12


import java.util.ArrayList;
import java.util.Scanner;

public class PlayGame {
    public static void main(String[] args) {
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

        //create rooms
        DungeonRoom room1 = new DungeonRoom(1, "thens", null, null, door1);
        DungeonRoom room2 = new DungeonRoom(2, "thens", null, null, door2);
        DungeonRoom room3 = new DungeonRoom(3, "thens", door1, door3, door4);
        DungeonRoom room4 = new DungeonRoom(4, "thens", door2, door3, door4);
        DungeonRoom room5 = new DungeonRoom(5, "thens 5", door4, null, null);
        DungeonRoom room6 = new DungeonRoom(6, "thens", door5, null, null);
        ArrayList <DungeonRoom> arrayRooms = new ArrayList<DungeonRoom>();
        arrayRooms.add(room1);
        arrayRooms.add(room2);
        arrayRooms.add(room3);
        arrayRooms.add(room4);
        arrayRooms.add(room5);
        arrayRooms.add(room6);

        
        
        //PlayGame.createRoom();

        //create doors
        

        //Create rooms
        
        
        
        

        Player player = new Player(room3, true);
        System.out.println(player.pos);


        //Creating directions
        Direction west = new Direction("west", "w", false, null);
        Direction east = new Direction("east","e", false, null);
        Direction north = new Direction("north", "n", false, null);
        Direction south = new Direction("south", "s", false, null);
        ArrayList <Direction> arrayDirs = new ArrayList<Direction>();
        arrayDirs.add(west);
        arrayDirs.add(east);
        arrayDirs.add(north);
        arrayDirs.add(south);
        
        

        

        int place = 0;
        //add while loop that runs as long as the player is alive
        while (player.status == true) {
            place = 0;
                DungeonRoom holderRoom = player.pos;
                System.out.println(holderRoom.roomDesc);
                
                    System.out.println("yes " + player.pos.roomId);
                    place = 0;
                    //check what directions the doors are in and how many there are
                    east.status = false;
                    west.status = false;
                    south.status = false;
                    north.status = false;

                        //testing all doors connected to the players current position
                        if (holderRoom.getConn1() != null) {
                            north.status = true;
                            System.out.println("doing north");
                        }
                        if (holderRoom.getConn2() != null) {
                            //checking which side the door is on
                            if (player.pos.roomId % 2 == 0) {
                                west.status = true;
                                
                            } else 
                            east.status = true;
                        }
                        if (holderRoom.getConn3() != null) {
                            south.status = true;
                            System.out.println("doing south");
                        }

                    
                //if (player.pos.roomId == 2) {
                //    player.status = false;
                //}
                 
                
                    System.out.println( north.status + " " + south.status);
                    place = 0;
                    String choices = "";
                    Direction holderDir;
                    for (int counter3 = 0; counter3 <= 3; counter3++) {
                        holderDir = arrayDirs.get(place);
                        if (holderDir.status) {
                            choices = choices.concat(" " + holderDir.dirName + " " + "(" +  holderDir.dirString + ")");
                        }
                        place++;
                    }
            

            System.out.println(choices);
            place = 0;
            //scanner for entering choice
            Scanner scannerDir = new Scanner(System.in);
            System.out.println("There are doors to the" + choices + ". Where do you want to go?");
            String dir = scannerDir.nextLine();
            //move player to the correct room

            int move = 0;
            Direction choiceMade = null;
                holderDir = arrayDirs.get(place);
                switch(dir) {
                case "e" :
                    // Statements
                    move = player.pos.roomId;
                    choiceMade = east;
                    break;
                
                case "w" :
                    // Statements
                    move = player.pos.roomId - 2;
                    choiceMade = west;
                    
                case "s" :
                    move = (holderRoom.roomId + 1);
                    choiceMade = south;
                    if (choiceMade.status == true) {
                        player.pos = arrayRooms.get(holderRoom.roomId + 1);
                        }
                case "n" :
                    move = player.pos.roomId - 3;
                    choiceMade = north;
                default : 
                    // default Statement
                }
                System.out.println(move + " move " + holderRoom.roomId);
                if (move >= 0) {
                     
                    if (choiceMade.status == true) {
                    player.pos = arrayRooms.get(move);
                    }
                }
                    
                    
                place++;
                
            
            
            System.out.println(dir);
            System.out.println("You entered a new room.");
            dir = "";
        }  
    }
}





