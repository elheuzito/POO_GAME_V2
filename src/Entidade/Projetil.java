package Entidade;

import Main.GamePanel;

import java.awt.*;

public class Projetil {
    Player player;
    boolean visible = true;
    float xspeed, yspeed;
    int x, y, width, height;
    GamePanel gamePanel;


    public Projetil(float xspeed, float yspeed, int x, int y, int width, int height) {
        this.xspeed = xspeed;
        this.yspeed = yspeed;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void projetilSet() {
        xspeed = xspeed + 0.1f;
        x += xspeed;

    }

    public void drawProjetil(Graphics2D gtd) {
        gtd.setColor(Color.DARK_GRAY);
        gtd.drawOval(x, y, width, height);
        gtd.fillOval(x, y, width, height);

    }
}
