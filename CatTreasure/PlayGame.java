package CatTreasure;
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
        DungeonRoom room1 = new DungeonRoom(1, "The room is empty with a big bag of treats on the floor.", null, null, door1);
        DungeonRoom room2 = new DungeonRoom(2, "In the middle of the room is a monster; a vacuum cleaner.", null, null, door2);
        DungeonRoom room3 = new DungeonRoom(3, "The room is empty except for some toys.", door1, door3, door4);
        DungeonRoom room4 = new DungeonRoom(4, "This room contains something that moves, but you dont know what it is.", door2, door3, door4);
        DungeonRoom room5 = new DungeonRoom(5, "There is a key in the room, and some nice beds.", door4, null, null);
        DungeonRoom room6 = new DungeonRoom(6, "This is the room you started in. Your favourite blanket is here.", door5, null, null);
        ArrayList <DungeonRoom> arrayRooms = new ArrayList<DungeonRoom>();
        arrayRooms.add(room1);
        arrayRooms.add(room2);
        arrayRooms.add(room3);
        arrayRooms.add(room4);
        arrayRooms.add(room5);
        arrayRooms.add(room6);

        //Create player
        Player player = new Player(room6, true);

        //Creating directions
        Direction west = new Direction("west", "w", false);
        Direction east = new Direction("east","e", false);
        Direction north = new Direction("north", "n", false);
        Direction south = new Direction("south", "s", false);
        ArrayList <Direction> arrayDirs = new ArrayList<Direction>();
        arrayDirs.add(west);
        arrayDirs.add(east);
        arrayDirs.add(north);
        arrayDirs.add(south);
        
        int place = 0;
        //game-loop (runs while player is alive)
        while (player.status == true) {
            DungeonRoom holderRoom;
            holderRoom = player.pos;
            //Printing out room description
            System.out.println(holderRoom.roomDesc);
            place = 0;
            //check what directions the doors are in and how many there are
            east.status = false;
            west.status = false;
            south.status = false;
            north.status = false;
            //testing all doors connected to the players current position
            if (holderRoom.getConn1() != null) {
                north.status = true;
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
                }

            place = 0;
            String choices = "";
            Direction holderDir;
            //Creating information about the doors for the player
            for (int counter3 = 0; counter3 <= 3; counter3++) {
                holderDir = arrayDirs.get(place);
                if (holderDir.status) {
                    choices = choices.concat(" " + holderDir.dirName + " " + "(" +  holderDir.dirString + ")");
                }
                place++;
            }
            place = 0;
            //getting the players choice
            Scanner scannerDir = new Scanner(System.in);
            System.out.println("There are doors to the" + choices + ". Where do you want to go?");
            String dir = scannerDir.nextLine();
            //move player to the correct room
            holderDir = arrayDirs.get(place);
            switch(dir) {
            case "e" :
                if (east.status == true) {
                    player.pos = arrayRooms.get(holderRoom.roomId);
                    }
            case "w" :
                if (west.status == true) {
                    player.pos = arrayRooms.get(holderRoom.roomId - 2);
                    }
                break;
            case "s" :
                if (south.status == true) {
                    player.pos = arrayRooms.get(player.pos.roomId + 1);
                    }
                break;
            case "n" :
                if (north.status == true) {
                    player.pos = arrayRooms.get(holderRoom.roomId - 3);
                    }
                    break;
            default : 
            }
            System.out.println("You entered a new room. ");
                    
            place++;
            dir = "";
        }  
    }
}





