package Entidade;

import Main.GamePanel;

import java.awt.*;

public abstract class Entidade {


    public int x;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int y;
    protected int height, width;
    public double xspeed;
    public double yspeed;




    protected GamePanel gamePanel;


    public  Entidade(int x, int y, int height, int width, GamePanel gamePanel, double yspeed, double xspeed){
        this.x =x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.xspeed = xspeed;
        this.yspeed = yspeed;
        this.gamePanel = gamePanel;
    }
}
