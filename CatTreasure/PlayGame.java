package CatTreasure;
//01:02:00 2024-11-12


import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class PlayGame {
    public static void main(String[] args) {
        //create mobs
        Vaccum vaccum = new Vaccum("boss", "The scary vaccum", true, 20, 1, false, 0, 3);
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
        DungeonRoom room2 = new DungeonRoom(2, "In the middle of the room is a monster; a vacuum cleaner.", null, null, door2, vaccum, null);
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
        Player player = new Player(room4, true, 20, 1);

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
            int retreat = 0;
            //checking if the room contains a mob
            if (holderMob != null) {
                //tell player about the mob
                if (holderMob.type == "boss") {
                    System.out.println("There is a scary thing here. It is " + holderMob.mobName + ".");
                    int[] temp = doBossBattle(player, vaccum);
                    player.health = temp[0];
                    holderMob.health = temp[1];
                    retreat = temp[2];
                } else {
                    System.out.println("There is a very scary thing here. It is " + holderMob.mobName + ".");
                    int[] temp = doMinionBattle(player, holderMob);
                    player.health = temp[0];
                    holderMob.health = temp[1];
                    
                }
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

    public static int[] doMinionBattle(Player no1, Mob no2) {
        double missAttack = 0.0;
        boolean statusNo1 = true;
        boolean statusNo2 = true;

        System.out.println(showHealth(no1, no2));
        if (chooseMove()) {
            while (statusNo1 && statusNo2) {
                missAttack = Math.random();

                //Mob attacks
                if (missAttack <= 0.2) {
                    System.out.println(no2.mobName + " attacks you but miss.");
                } else {
                    System.out.println(no2.mobName + " attacks you and does " + no2.damage + " in damage.");
                    no1.health = damageHealth(no2.damage, no1.health);
                }
                statusNo1 = updateStatus(no1.health);
                System.out.println(showHealth(no1, no2));

                missAttack = Math.random();
                //Player attack
                if (missAttack <= 0.1) {
                    System.out.println("You attack " + no2.mobName + " but miss.");
                } else {
                    System.out.println("You attack " + no2.mobName + " and do " + no1.damage + " in damage.");
                    no2.health = damageHealth(no1.damage, no2.health);
                }
                statusNo2 = updateStatus(no2.health);
                System.out.println(showHealth(no1, no2));
            }
        }
        

        int[] listHealth = {no1.health, no2.health};
        return listHealth;
    }

    // ME: do narritive, do battle (create methods)
    public static int[] doBossBattle(Player no1, Vaccum no2) {
        //ME: while loop for attacking each other
        double missAttack = 0.0;
        boolean statusNo1 = true;
        boolean statusNo2 = true;
        int retreat = 0;

        while (statusNo1 && statusNo2) {
            System.out.println("loop time");
            missAttack = Math.random();

            //Mob attacks
            System.out.println(showHealth(no1, no2));
            if (checkSuperCharge(no2) == true) {
                if (missAttack <= 0.2) {
                    System.out.println(no2.mobName + " uses an extra strong attack but miss.");
                } else {
                    System.out.println(no2.mobName + " uses an extra strong attack and does " + no2.superDamage + " in damage.");
                    no1.health = damageHealth(no2.superDamage, no1.health);
                }
            } else {
                System.out.println(no2.mobName + " attacks you and does " + no2.damage + " in damage.");
                no1.health = damageHealth(no2.damage, no1.health);
            }
            statusNo1 = updateStatus(no1.health);

            if (statusNo1 == true) {
                System.out.println(showHealth(no1, no2));
                //Player attack
                if (chooseMove() == true) {
                    missAttack = Math.random();
                    if (missAttack <= 0.1) {
                        System.out.println("You attack " + no2.mobName + " but miss.");
                    } else {
                        System.out.println("You attack " + no2.mobName + " and do " + no1.damage + " in damage.");
                        no2.health = no2.health - no1.damage;
                    }
                    statusNo2 = updateStatus(no2.health);
                } else {
                    statusNo1 = false;
                }
            }
        }
        int[] listHealth = {no1.health, no2.health, retreat};
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

    //check if super attack is charged
    public static boolean checkSuperCharge(Vaccum boss) {
        if (boss.superCharge >= 5) {
            boss.superAttack = true;
            boss.superCharge = 0;
        } else {
            boss.superCharge = boss.superCharge + 1;
        }
        return boss.superAttack;
    }

    //change health
    public static int damageHealth(int damage, int health) {
        health = health - damage; 
        return health;
    }

    public static boolean chooseMove() {
        Scanner scannerMove = new Scanner(System.in);
        System.out.println("Do you want to attack (a) or retreat (r)");
        String move = scannerMove.nextLine();
        boolean attack = true;

        if (move == "a") {
            attack = true;
        } if (move == "r") {
            attack = false;
        }

        return attack;
    }
}





