package CatTreasure;

public class HealthTreat extends Treat {
    int healing;
    
    //constructor
    public HealthTreat(String treatName, String treatString, boolean status, int healing) {
        super(treatName, treatString, status);
        this.healing = healing;
    }
}


