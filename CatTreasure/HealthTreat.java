package CatTreasure;

public class HealthTreat extends Treat {
    int healing;
    
    public HealthTreat(String treatName, String treatString, boolean status, int healing) {
        super(treatName, treatString, status);
        this.healing = healing;
    }
}


