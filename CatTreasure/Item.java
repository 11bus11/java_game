package CatTreasure;

public class Item {
    String itemName;
    boolean status;

    public Item(String itemName, boolean status) {
        this.itemName = itemName;
        this.status = status;
    }

    public boolean getStatus() {
        return this.status;
    }
}