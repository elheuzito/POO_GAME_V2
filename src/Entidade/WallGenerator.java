package Entidade;

import Entidade.Wall;
import java.util.ArrayList;

public class WallGenerator {
    public static ArrayList<Wall> generateWalls() {
        ArrayList<Wall> walls = new ArrayList<>();

        for (int i = 32; i < 1600; i += 32) {
            walls.add(new Wall(i, 900 - 64, 32, 32));
        }

        walls.add(new Wall(50, 550, 32, 32));
        walls.add(new Wall(50, 500, 32, 32));
        walls.add(new Wall(50, 450, 32, 32));
        walls.add(new Wall(600, 450, 32, 32));
        walls.add(new Wall(600, 550, 32, 32));
        walls.add(new Wall(600, 500, 32, 32));
        walls.add(new Wall(450, 550, 32, 32));

        return walls;
    }
}