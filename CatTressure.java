public class CatTressure {
    //private int pos;//
    public CatTressure() {
    }
    CatTressure game = new CatTressure();

    public class DungeonRoom extends CatTressure {
        String roomDesc;
        int posX;
        int posY;
        //constructor//
        public DungeonRoom(int roomX) {
            roomX = posX;

            System.out.println("Constructor Called");
        }
        public static void CreateRoom() {
            DungeonRoom room1 = new DungeonRoom(1);
            room1.posY = 2;
            room1.roomDesc = "gr";
        }
        public static void main() {
            //CreateRoom();//
            DungeonRoom room1 = new DungeonRoom(1);
            room1.posY = 2;
            room1.roomDesc = "gr";
            System.out.println("hrhr");
            System.out.println(room1.roomDesc);
        }
    }
    public static void main() {
        //CreateRoom();//
        DungeonRoom room1 = game.new DungeonRoom(1);
        room1.posY = 2;
        room1.roomDesc = "gr";
        System.out.println("hrhr");
        System.out.println(room1.roomDesc);
    }
    
}


