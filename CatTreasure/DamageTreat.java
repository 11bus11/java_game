package CatTreasure;

public class DamageTreat extends Treat {
    int damage;
    
    public DamageTreat(String treatName, boolean status, int damage) {
        super(treatName, status);
        this.damage = damage;
    }
}
