# Cat Tressure
*By: Erik Vodopivec Forsman*

## The classes
I chose to make classes for the player, the rooms, the doors and the directions. The reason for making the directions into a class was that I could give them both a status and a name. The alternitive was to make 8 variables. The rest of my classes were chosen based on the fact that they exist in the instruction example (combined with practicality). 

### Player
`DungeonRoom pos;
    Boolean status;`
Pos shows the players current position and status shows if the player is alive or not.

### Rooms
`int roomId; 
    String roomDesc;
    DungeonDoor conn1;
    DungeonDoor conn2;
    DungeonDoor conn3;`
The rooms consist of an id, a description and 3 connected doors. The id is for identification and the description contains information about the room which is then shown to the user. The connected doors are for making movement between rooms possible. Conn1 is a door to the north, conn2 is either west or east and conn3 is south. 

### Doors
`int doorId;
    Boolean locked;`
Just as with the rooms, the door id is for identification. The locked boolean is a preparation for further game logic. It shows if a door is locked or not.

### Directions
`String dirName;
    String dirString;
    boolean status;`
DirName shows which directin it is and status shows if it is one of the available options (if there is a room to that direction).

## The logic
The logic of the game is contained in a while loop which runs as long as the player's status is "true". This is so that the game will end when the player dies (status is set to "false").

The program then checks how many doors are connected to the room in which the player is and which directions they face. When that is done the user gets the choices available and makes a decition on where to go. Based on the input from the user, the player's position is changed to the correct room. Then the logic starts over. 

*This project was created as part of the "Programmutveckling med Java" course (D0019N) at Luleå University of Technology*
