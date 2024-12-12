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
        DungeonRoom room5 = new DungeonRoom(5, "thens", door4, null, null);
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
 
                    System.out.println("yes " + player.pos.roomId);
                    place = 0;
                    //check what directions the doors are in and how many there are
                    for (int counter1 = 0; counter1 <= 4; counter1++) {
                        DungeonDoor holderDoor = arrayDoors.get(place);
                        //testing all doors connected to the players current position
                        if (holderRoom.getConn1() == null) {
                            System.out.println("null door");
                        } else
                        if (holderDoor.getDoor() == holderRoom.getConn1().doorId) {
                            north.status = true;
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
                                west.status = true;
                                
                            } else 
                            east.status = true;
                        }
                        if (holderRoom.getConn3() == null) {
                            System.out.println("null door");
                        } else
                        if (holderDoor.getDoor() == holderRoom.getConn3().doorId) {
                            south.status = true;
                            System.out.println("yes door " + holderRoom.getConn3().doorId);
                        }
                        place++;
                    }
                if (player.pos.roomId == 2) {
                    player.status = false;
                }
                 
                
            
            place = 0;
            System.out.println(east.status + " " + west.status + " " + north.status + " " + south.status);
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
            for (int counter4 = 0; counter4 <= 3; counter4++) {
                holderDir = arrayDirs.get(place);
                System.out.println("working for");
                
                
                if ((dir == "e")) { //me - issue with it not going into the if-statement. 
                                    // me - Comparison not working
                //(holderDir.status == true)
                switch(holderDir.dirString) {
                case "e" :
                    // Statements
                    move = player.pos.roomId;
                    System.out.println("moving 2");
                    
                
                case "w" :
                    // Statements
                    move = player.pos.roomId - 2;
                    
                default : 
                    // default Statement
                }
                    /*if ((holderDir.dirString).equals("e")) {
                        move = player.pos.roomId;
                        player.pos = arrayRooms.get(move);
                        System.out.println(move);
                    }
                    if ((holderDir.dirString).equals("w")) {
                        move = player.pos.roomId - 2;
                        
                    }
                    if ((holderDir.dirString).equals("s")) {
                        move = player.pos.roomId + 1;
                    }
                    if ((holderDir.dirString).equals("n")) {
                        move = player.pos.roomId - 3;
                    }
                    if (move < 0) {
                        move = 0;
                    }*/
                    player.pos = arrayRooms.get(move);
                    place++;
                }
            }
            if ((dir.equals("e")) && (east.status == true)) {
                //calculate next room
                //current array index + 1?
            }

            System.out.println("You entered a new room." + dir + player.pos.roomId);
            dir = "";
        }  
    }
}





