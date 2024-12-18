package CatTreasure;

public class HealthTreat extends Treat {
    int healing;
    
    public HealthTreat(String treatName, boolean status, int healing) {
        super(treatName, status);
        this.healing = healing;
    }
}


