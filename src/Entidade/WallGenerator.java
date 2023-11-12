package Entidade;

import Entidade.Wall;
import java.util.ArrayList;

public class WallGenerator {
    public static ArrayList<Wall> generateWalls() {
        ArrayList<Wall> walls = new ArrayList<>();
        // Criando blocos e adicionando-os em um ArrayList.



        walls.add(new Wall(352,753,200,528));
        //walls.add(new Wall(-10,32,900,32));

        walls.add(new Wall(166,607,30,59));

        walls.add(new Wall(406,489,32,32));

        walls.add(new Wall(1253,673,500,440));
        walls.add(new Wall(1220,673,50,40));


        return walls;
    }
}