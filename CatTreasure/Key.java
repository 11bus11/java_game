package CatTreasure;

public class Key {
    String keyName;
    boolean status;
    boolean used;
    DungeonRoom keyPos;

    public Key(String keyName, boolean status, boolean used, DungeonRoom keyPos) {
        this.keyName = keyName;
        this.status = status;
        this.used = used;
        this.keyPos = keyPos;
    }
}
