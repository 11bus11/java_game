package CatTreasure;

public class Direction {
    String dirName;
    String dirString;
    boolean status;

    //constructor
    public Direction(String dirName, String dirString, boolean status) {
        this.dirName = dirName;
        this.dirString = dirString;
        this.status = status;
    }

    public String getDirName() {
        return this.dirName;
    }

    public boolean getStatus() {
        return this.status;
    }

    public String getDirString() {
        return this.dirString;
    }

}
