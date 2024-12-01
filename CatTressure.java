public class CatTressure {
   public CatTressure() {
   }
    
   CatTressure.DungeonRoom room = new DungeonRoom();

    public class DungeonRoom {
        public int roomDesc;
        public int posX;
        public int posY;
        //constructor//
        public DungeonRoom(int desc, int x, int y) {
            roomDesc = desc;
            posX = x;
            posY = y;
            
        }
        public void CreateRoom() {
            //create dungeon?//
            DungeonRoom room1 = new DungeonRoom(100, 3, 1);  
        }

    }
    public class Player {
        private int pos;
    }
    public static void main(String[] args) {
        
        System.out.println("hrhr");
        System.out.println(room1.roomDesc)
    }
    
}


