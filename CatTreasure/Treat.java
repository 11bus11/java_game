package CatTreasure;

public class Treat {
    String treatName;
    String treatString;
    boolean status;

    //constructor
    public Treat(String treatName, String treatString, boolean status) {
        this.treatName = treatName;
        this.treatString = treatString;
        this.status = status;
    }

    public boolean getStatus() {
        return this.status;
    }
}
