package CatTreasure;

public class DungeonRoom {
    int roomId; 
    String roomDesc;
    DungeonDoor conn1;
    DungeonDoor conn2;
    DungeonDoor conn3;
    Mob mob;
    Treat treat;

    //constructor
    public DungeonRoom(int roomId, String roomDesc, DungeonDoor conn1, DungeonDoor conn2, DungeonDoor conn3, Mob mob, Treat treat) {
        this.roomId = roomId;
        this.roomDesc = roomDesc;
        this.conn1 = conn1;
        this.conn2 = conn2;
        this.conn3 = conn3;
        this.mob = mob;
        this.treat = treat;
    }

    public int getRoom() {
        return this.roomId;
    }

    public DungeonDoor getConn1() {
        return this.conn1;
    }

    public DungeonDoor getConn2() {
        return this.conn2;
    }

    public DungeonDoor getConn3() {
        return this.conn3;
    }

    public Mob getMob() {
        return this.mob;
    }

    public Mob getTreat() {
        return this.mob;
    }
}
