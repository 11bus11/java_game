package CatTreasure;
//01:02:00 2024-11-12


import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class PlayGame {
    public static void main(String[] args) {
        //create mobs
        Vaccum vaccum = new Vaccum(true, "Bruce the scary vaccum", true, 20, 1, 0, 3);
        Leaves leaf1 = new Leaves(false, "Bob the leaf", true, 5, 1);
        Leaves leaf2 = new Leaves(false, "Bill the leaf", true, 5, 1);
        
        //create items
        HealthTreat healthTreat = new HealthTreat("good treats", "g", false, 5);
        DamageTreat damageTreat = new DamageTreat("bad treats", "b", true, 5);

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
        DungeonRoom room5 = new DungeonRoom(5, "There is a key in the room.", door4, null, null, leaf2, null);
        DungeonRoom room6 = new DungeonRoom(6, "This is the room you start in. Your favourite blanket is here.", door5, null, null, null, null);
        ArrayList <DungeonRoom> arrayRooms = new ArrayList<DungeonRoom>();
        arrayRooms.add(room1);
        arrayRooms.add(room2);
        arrayRooms.add(room3);
        arrayRooms.add(room4);
        arrayRooms.add(room5);
        arrayRooms.add(room6);
        
        //create key
        Key key = new Key("boss-key", false, room5);

        //Create player
        Player player = new Player(room6, true, 20, 1);

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
        boolean defeatedLeaf = true;

        //reminder to read instructions
        System.out.println("Make sure you read the instructions in the README.");
        System.out.println("_______________");

        //game-loop (runs while player is alive)
        while (player.status == true) {
            holderRoom = player.pos;
            place = 0;
            Treat holderTreat;
            holderTreat = holderRoom.treat;
            Mob holderMob;
            holderMob = holderRoom.mob;

            //Printing out room description
            System.out.println(holderRoom.roomDesc);

            //checking if the room contains a treat
            //and asking if player wants to pick it up
            if (holderTreat != null) {
                Scanner scannerPickup = new Scanner(System.in);
                System.out.println("There are " + holderTreat.treatName + " in this room. Do you want to pick them up? Yes (y) or no (n)?");
                String pickup = scannerPickup.nextLine();
                switch(pickup) {
                    case "y" :
                        holderTreat.status = true;
                        holderRoom.treat = null;
                        holderRoom.roomDesc = "This room used to have treats in it.";
                        System.out.println("You picked up the treat. It is now in your inventory and can be used during fights.");
                        break;
                    case "n" :
                        System.out.println("The treat will still be here if you change your mind.");
                        break;
                }
            }

            //checking if the room contains a mob and fight logic
            if (holderMob != null) {
                String stringInventory = showInventory(healthTreat, damageTreat);
                System.out.println("There is a scary thing here. It is " + holderMob.mobName + ".");
                System.out.println(showHealth(player, holderMob));
                System.out.println("Your inventory:" + stringInventory);
                //give player the option to retreat
                if (chooseMove()) {
                    //option to use inventory stuff
                    if (healthTreat.status || damageTreat.status) {
                        Scanner scannerInv = new Scanner(System.in);
                        System.out.println("Do you want to use an item before the fight? You can use" + stringInventory + ". Or dont use any (n).");
                        String inv = scannerInv.nextLine();
                        switch(inv) {
                            case "g" :
                                if (healthTreat.status) {
                                    healthTreat.status = false;
                                    player.health = player.health + healthTreat.healing;
                                    System.out.println("You used " + healthTreat.treatName + ".");
                                    System.out.println(showHealth(player, holderMob));
                                }
                                break;
                            case "b" :
                                if (damageTreat.status) {
                                    damageTreat.status = false;
                                    holderMob.health = holderMob.health + damageTreat.damage;
                                    System.out.println("You used " + damageTreat.treatName + ".");
                                    System.out.println(showHealth(player, holderMob));
                                }
                                break;
                            default:
                                System.out.println("You did not use any treats.");
                        }
                    }
                    //tell player about the mob and run battle
                    if (holderMob.boss) {
                        int[] temp = doBossBattle(player, vaccum);
                        player.health = temp[0];
                        holderMob.health = temp[1];
                    } else {
                        int[] temp = doMinionBattle(player, holderMob);
                        player.health = temp[0];
                        holderMob.health = temp[1];
                        holderRoom.roomDesc = "There is a defeated leaf in this room. ";
                        defeatedLeaf = true;
                    }
                    player.status = updateStatus(player.health);
                    if (player.status) {
                        System.out.println("You won!");
                        if (holderMob.boss) {
                            System.out.println("Congrats. You defeated the " + vaccum.mobName + ".");
                            player.status = false;
                        }
                        
                        holderRoom.mob = null;
                    } else {
                        System.out.println("You lost :(");
                    }
                }
            }

            if (player.status) {
                //checking if room has a key and if player vants to pick it up
                if (key.keyPos == holderRoom) {
                    Scanner scannerKey = new Scanner(System.in);
                    System.out.println("You can pick up the key. Do you want to? Yes (y) or no (n)?");
                    String keyItem = scannerKey.nextLine();
                    switch(keyItem) {
                        case "y" :
                            key.status = true;
                            holderRoom.roomDesc = "There is no longer a key in this room. Just some nice beds.";

                            System.out.println("You picked up the key. This can be used to open locked doors.");
                            key.keyPos = null;
                            break;
                        case "n" :
                            System.out.println("The key will still be here if you change your mind.");
                            break;
                    }
                }

                //check what directions the doors are in and how many there are
                east.status = false;
                west.status = false;
                south.status = false;
                north.status = false;
                //testing all doors connected to the players current position
                String lockedDir = "";
                DungeonDoor lockedDoor = null;
                if (holderRoom.getConn1() != null) {
                    north.status = true;
                    if (checkLock(holderRoom.getConn1())) {
                        lockedDir = "n";
                        lockedDoor = holderRoom.getConn1();
                    }
                }
                if (holderRoom.getConn2() != null) {
                    //checking which side the door is on
                    if (player.pos.roomId % 2 == 0) {
                        west.status = true;
                        if (checkLock(holderRoom.getConn2())) {
                            lockedDir = "w";
                            lockedDoor = holderRoom.getConn2();
                        }          
                    } else {
                        east.status = true;
                        if (checkLock(holderRoom.getConn2())) {
                            lockedDir = "e";
                            lockedDoor = holderRoom.getConn2();
                        }
                    }
                }
                if (holderRoom.getConn3() != null) {
                    south.status = true;
                    if (checkLock(holderRoom.getConn3())) {
                        lockedDir = "s";
                        lockedDoor = holderRoom.getConn3();

                    }
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
                //getting the players direction choice
                Scanner scannerDir = new Scanner(System.in);
                System.out.println("There are doors to the" + choices + ". Where do you want to go?");
                String dir = scannerDir.nextLine();

                //move player to the correct room and logic for using key
                boolean pick = false;
                holderDir = arrayDirs.get(place);
                switch(dir) {
                case "e" :
                    if (east.status == true) {
                        if (lockedDir == "e") {
                            if (key.status) {
                                Scanner scannerUseKey = new Scanner(System.in);
                                System.out.println("The door is locked. Do you want to use the key to open the door? Yes (y) or no (n)?");
                                String useKey = scannerUseKey.nextLine();
                                switch(useKey) {
                                    case "y" :
                                        System.out.println("You unlocked the door.");
                                        player.pos = arrayRooms.get(holderRoom.roomId);
                                        lockedDoor.locked = false;
                                        pick = true; 
                                        break;
                                    case "n" :
                                        System.out.println("You did not unlock the door. The door is still locked.");
                                        break;
                                }
                            } else {
                                System.out.println("The door is locked and you dont have the key. Find it to open the door.");
                            }
                        } else {
                            player.pos = arrayRooms.get(player.pos.roomId);
                            pick = true; 
                        }
                    }
                case "w" :
                    if (west.status == true) {
                        if (lockedDir == "w") {
                            if (key.status) {
                                Scanner scannerUseKey = new Scanner(System.in);
                                System.out.println("The door is locked. Do you want to use the key to open the door? Yes (y) or no (n)?");
                                String useKey = scannerUseKey.nextLine();
                                switch(useKey) {
                                    case "y" :
                                        System.out.println("You unlocked the door.");
                                        player.pos = arrayRooms.get(holderRoom.roomId - 2);
                                        lockedDoor.locked = false;
                                        pick = true; 
                                        break;
                                    case "n" :
                                        System.out.println("You did not unlock the door. The door is still locked.");
                                        break;
                                }
                            } else {
                                System.out.println("The door is locked and you dont have the key. Find it to open the door.");
                            }
                        } else {
                            player.pos = arrayRooms.get(holderRoom.roomId - 2);
                            pick = true; 
                        } 
                    }
                    break;
                case "s" :
                    if (south.status == true) {
                        if (lockedDir == "s") {
                            if (key.status) {
                                Scanner scannerUseKey = new Scanner(System.in);
                                System.out.println("The door is locked. Do you want to use the key to open the door? Yes (y) or no (n)?");
                                String useKey = scannerUseKey.nextLine();
                                switch(useKey) {
                                    case "y" :
                                        System.out.println("You unlocked the door.");
                                        player.pos = arrayRooms.get(holderRoom.roomId + 1);
                                        lockedDoor.locked = false;
                                        pick = true; 
                                        break;
                                    case "n" :
                                        System.out.println("You did not unlock the door. The door is still locked.");
                                        break;
                                }
                            } else {
                                System.out.println("The door is locked and you dont have the key. Find it to open the door.");
                            }
                        } else {
                            player.pos = arrayRooms.get(player.pos.roomId + 1);
                            pick = true; 
                        } 
                    }
                    break;
                case "n" :
                    if (north.status == true) {
                        if (lockedDir == "n") {
                            if (key.status) {
                                Scanner scannerUseKey = new Scanner(System.in);
                                System.out.println("The door is locked. Do you want to use the key to open the door? Yes (y) or no (n)?");
                                String useKey = scannerUseKey.nextLine();
                                switch(useKey) {
                                    case "y" :
                                        System.out.println("You unlocked the door.");
                                        player.pos = arrayRooms.get(holderRoom.roomId - 3);
                                        lockedDoor.locked = false;
                                        pick = true; 
                                        break;
                                    case "n" :
                                        System.out.println("You did not unlock the door. The door is still locked.");
                                        break;
                                }
                            } else {
                                System.out.println("The door is locked and you dont have the key. Find it to open the door.");
                            }
                        } else {
                            player.pos = arrayRooms.get(holderRoom.roomId - 3);
                            pick = true; 
                        } 
                    }
                    break;
                default :
                    System.out.println("No direction chosen.");
                }
                if (pick) {
                    System.out.println("You entered a new room. ");
                } else {
                    System.out.println("You couldnt enter the room.");
                }
                        
                place++;
                dir = "";
            }
            
        }  
        
    }
    //Show health to player
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
        int[] listHealth = {no1.health, no2.health};
        return listHealth;
    }

    // boss battle
    public static int[] doBossBattle(Player no1, Vaccum no2) {
        double missAttack = 0.0;
        boolean statusNo1 = true;
        boolean statusNo2 = true;
        int charge = no2.superCharge;
        
        while (statusNo1 && statusNo2) {
            missAttack = Math.random();
            //Mob attack
            if (charge >= 5) {
                System.out.println(no2.mobName + " attacks you with a super attack and does " + no2.superDamage + " in damage.");
                no1.health = damageHealth(no2.superDamage, no1.health);
                charge = 0;
            } else {
                charge++; 
                if (missAttack <= 0.2) {
                    System.out.println(no2.mobName + " attacks you but miss.");
                } else {
                    System.out.println(no2.mobName + " attacks you and does " + no2.damage + " in damage.");
                    no1.health = damageHealth(no2.damage, no1.health);
                }
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
        int[] listHealth = {no1.health, no2.health};
        return listHealth;
    }

    //check and update if player or mob is alive after fight
    public static boolean updateStatus(int health) {
        boolean status;
        if (health <=0) {
            status = false;
            } else {
                status = true;
            }
        return status;
    }

    //change health
    public static int damageHealth(int damage, int health) {
        health = health - damage; 
        return health;
    }

    //choose to fight or retreat
    public static boolean chooseMove() {
        Scanner scannerMove = new Scanner(System.in);
        System.out.println("Do you want to attack (a) or retreat (r)");
        String move = scannerMove.nextLine();
        boolean attack = true;
        if (move.equals("a")) {
            attack = true;
            System.out.println("You fight.");
        } else {
            attack = false;
            System.out.println("You retreated.");
        }
        move = "";
        return attack;
    }

    //create the string for thowing inventory to user
    public static String showInventory(Treat treat1, Treat treat2) {
        Treat[] treats = {treat1, treat2};
        String inventory = "";
        for (int counter = 0; counter <= 1; counter++)
        if (treats[counter].status) {
            inventory = inventory.concat(" " + treats[counter].treatName + " (" + treats[counter].treatString + ")");
        }
        return inventory;
    }

    //checking if the chosen door is locked or not
    public static boolean checkLock(DungeonDoor lockedDoor) {
        boolean locked = false;
        if (lockedDoor != null) {
            if (lockedDoor.locked) {
            locked = true;
            }
        }
        return locked;
    }
}





