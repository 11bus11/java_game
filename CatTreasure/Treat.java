package CatTreasure;

public class Treat {
    String treatName;
    boolean status;

    public Treat(String treatName, boolean status) {
        this.treatName = treatName;
        this.status = status;
    }

    public boolean getStatus() {
        return this.status;
    }
}
