package CatTreasure;

public class Player {
    DungeonRoom pos;
    Boolean status;

    public Player(DungeonRoom pos, Boolean status) {
        this.pos = pos;
        this.status = status;
    }

    public int getPos() {
        return this.pos.roomId;
    }
}
