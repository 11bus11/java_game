public class CatTressure {
   

   }
    //class for playing game
    final class DungeonRoom {
        public int roomDesc;
        public int posX;
        public int posY;
        //constructor
        
        public DungeonRoom(int desc, int x, int y) {
            roomDesc = desc;
            posX = x;
            posY = y;
        }
        public static void main(String[] args) {
            //create dungeon?//
            CatTressure game = new CatTressure();
            CatTressure.DungeonRoom room = game.new DungeonRoom();
            DungeonRoom room1 = new DungeonRoom(100, 3, 1);  
        }

    }
    public class Player {
        private int pos;
    }
    public static void main(String[] args) {
        
        System.out.printf("hrhr");
    }
    
}


