package CatTressure;

public class Direction {
    String dirName;
    String dirString;
    boolean status;
    DungeonRoom dirRoom;


    public Direction(String dirName, String dirString, boolean status, DungeonRoom dirRoom) {
        this.dirName = dirName;
        this.dirString = dirString;
        this.status = status;
        this.dirRoom = dirRoom;
    }

    public String getDirName() {
        return this.dirName;
    }

    public boolean getStatus() {
        return this.status;
    }

    public DungeonRoom getDirRoom() {
        return this.dirRoom;
    }

    public String getDirString() {
        return this.dirString;
    }

}
