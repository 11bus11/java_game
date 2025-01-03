package CatTreasure;

public class Key {
    String keyName;
    boolean status;
    DungeonRoom keyPos;

    public Key(String keyName, boolean status, DungeonRoom keyPos) {
        this.keyName = keyName;
        this.status = status;
        this.keyPos = keyPos;
    }
}
