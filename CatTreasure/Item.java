package CatTreasure;

public class Item {
    boolean status;

    public Item(String itemName, boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return this.status;
    }
}