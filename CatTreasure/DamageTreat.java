package CatTreasure;

public class DamageTreat extends Treat {
    int damage;
    
    //constructor
    public DamageTreat(String treatName, String treatString, boolean status, int damage) {
        super(treatName, treatString, status);
        this.damage = damage;
    }
}
