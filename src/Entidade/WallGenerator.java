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
        // NOVA PAREDE
        walls.add(new Wall(642,358,48,110));

        walls.add(new Wall(406,489,32,32));

        walls.add(new Wall(1253,673,500,440));
        walls.add(new Wall(1253,0,200,440));
        walls.add(new Wall(1220-7,473,400,40));
        walls.add(new Wall(1650+11,200,400,32));
        walls.add(new Wall(1650+43,490,32,64));
        walls.add(new Wall(1850+43,200,890,32));
        walls.add(new Wall(1650+43,300,32,64));
        walls.add(new Wall(2050+43,0,700,32));
        walls.add(new Wall(2150,800,150,500));
        


        return walls;
    }
}