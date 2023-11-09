package Entidade;

import Entidade.Wall;
import java.util.ArrayList;

public class WallGenerator {
    public static ArrayList<Wall> generateWalls() {
        ArrayList<Wall> walls = new ArrayList<>();

        for (int i = 32; i < 1600; i += 32) {
            walls.add(new Wall(i, 900 - 64, 32, 32));
        }
        for(int j = 32; j < 900; j+= 32){
            walls.add(new Wall(10,j,32,32));
        }
        walls.add(new Wall(400,802,32,32));
        walls.add(new Wall(500,720,32,32));
        walls.add(new Wall(600,640,32,320));


        return walls;
    }
}