package Rooms;

public class Board {

    private Room[][] map;

    public Board(Room[][] map){
        this.map = map;
    }

    public void print(){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
    }
}
