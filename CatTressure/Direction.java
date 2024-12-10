package CatTressure;

public class Direction {
    String dirName;
    boolean status;

    public Direction(String dirName, boolean status) {
        this.dirName = dirName;
        this.status = status;
    }
    public String getDirName() {
        return this.dirName;
    }

    public boolean getStatus() {
        return this.status;
    }
}
