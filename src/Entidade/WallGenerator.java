package Entidade;

import Entidade.Wall;
import java.util.ArrayList;

public class WallGenerator {
    public static ArrayList<Wall> generateWalls() {
        ArrayList<Wall> walls = new ArrayList<>();
        // Criando blocos e adicionando-os em um ArrayList.



        walls.add(new Wall(350,753,200,531));
        walls.add(new Wall(-10,32,900,32));

        walls.add(new Wall(400,802,32,32));
        walls.add(new Wall(500,720,32,32));
        walls.add(new Wall(600,640,32,320));
        walls.add(new Wall(1600,600,600,1000));


        return walls;
    }
}