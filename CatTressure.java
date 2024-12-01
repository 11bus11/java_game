public class catTressure {
    //private int pos;//
    public catTressure() {
    }
    catTressure game = new catTressure();

    public class DungeonRoom extends catTressure {
        String roomDesc;
        int posX;
        int posY;
        //constructor//
        public DungeonRoom(int roomX) {
            roomX = posX;

            System.out.println("Constructor Called");
        
        }
    }
    public void createRoom() {
        DungeonRoom room1 = game.new DungeonRoom(1);
        room1.posY = 2;
        room1.roomDesc = "gr";
    }

    public static void main(String[] args) {
        
        System.out.println("hrhr");
        
    }
    
}


