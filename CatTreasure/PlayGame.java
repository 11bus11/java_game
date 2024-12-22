package CatTreasure;
//01:02:00 2024-11-12


import java.util.ArrayList;
import java.util.Scanner;

public class PlayGame {
    public static void main(String[] args) {
        //create mobs
        Vaccum vaccum = new Vaccum("boss", "The scary vaccum", true, 20, 1, false, 3);
        Leaves leaf1 = new Leaves("minion", "Bob the leaf", true, 5, 1);
        Leaves leaf2 = new Leaves("minion", "Bill the leaf", true, 5, 1);
        
        //create items
        HealthTreat healthTreat = new HealthTreat("good treats", false, 5);
        DamageTreat damageTreat = new DamageTreat("bad treats", false, 2);

        //Inventory array
        ArrayList <Treat> arrayInv = new ArrayList<Treat>();
        arrayInv.add(damageTreat);

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
        DungeonRoom room1 = new DungeonRoom(1, "The room is empty with a big bag of treats on the floor.", null, null, door1, null, healthTreat);
        DungeonRoom room2 = new DungeonRoom(2, "In the middle of the room is a monster; a vacuum cleaner.", null, null, door2, null, null);
        DungeonRoom room3 = new DungeonRoom(3, "The room is empty except for some toys.", door1, door3, door4, null, null);
        DungeonRoom room4 = new DungeonRoom(4, "This room contains something that moves, but you dont know what it is.", door2, door3, door4, leaf1, null);
        DungeonRoom room5 = new DungeonRoom(5, "There is a key in the room, and some nice beds.", door4, null, null, leaf2, null);
        DungeonRoom room6 = new DungeonRoom(6, "This is the room you started in. Your favourite blanket is here.", door5, null, null, null, null);
        ArrayList <DungeonRoom> arrayRooms = new ArrayList<DungeonRoom>();
        arrayRooms.add(room1);
        arrayRooms.add(room2);
        arrayRooms.add(room3);
        arrayRooms.add(room4);
        arrayRooms.add(room5);
        arrayRooms.add(room6);

        //Create player
        Player player = new Player(room4, true, 20);

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

        DungeonRoom holderRoom;
        int place = 0;
        //game-loop (runs while player is alive)
        while (player.status == true) {
            holderRoom = player.pos;
            //Printing out room description
            System.out.println(holderRoom.roomDesc);
            place = 0;

            Mob holderMob;
            holderMob = holderRoom.mob;
            //checking if the room contains a mob
            if (holderMob != null) {
                //tell player about the mob
                if (holderMob.type == "boss") {
                    System.out.println("There is a scary thing here. It is " + holderMob.mobName + ".");
                } else {
                    System.out.println("There is a very scary thing here. It is " + holderMob.mobName + ".");
                }
                    
                //fight the mob
                int[] temp = doBattle(player, holderMob);
                player.health = temp[0];
                holderMob.health = temp[1];
                player.status = updateStatus(player.health);
                if (player.status) {
                    System.out.println("you won");
                    } else {
                        System.out.println("you lost");
                    }
                
            }

            if (player.status) {
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
    //Show health statuses to player
    public static String showHealth(Player no1, Mob no2) {
        int no1CurrHealth = no1.getHealth();
        int no2CurrHealth = no2.getHealth();
        String tellHealth;
        tellHealth = ("Your health: " + no1CurrHealth + " ----- " + no2.getMobName() + "s health: " + no2CurrHealth);
        return tellHealth;
    }

    // ME: do narritive, do battle (create methods)
    public static int[] doBattle(Player no1, Mob no2) {
        //ME: while loop for attacking each other
        boolean statusNo1 = true;
        boolean statusNo2 = true;
        while (statusNo1 && statusNo2) {
            //ME: actual battle
            statusNo1 = updateStatus(no1.health);
            statusNo2 = updateStatus(no2.health);
            System.out.println(showHealth(no1, no2));
        }
        int[] listHealth = {no1.health, no2.health};

        //ME: return the result of the fight (if player is alive or not)
        return listHealth;
    }

    public static boolean updateStatus(int health) {
        boolean status;
        if (health <=0) {
            status = false;
            } else {
                status = true;
            }
        return status;
    }
}





