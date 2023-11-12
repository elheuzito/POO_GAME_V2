package Entidade;



import java.awt.*;

public class Wall {
    int x, y, height, width;
    int startX;
    Rectangle hitbox;

    public Wall(int x, int y, int height, int width){
        startX = x;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        hitbox = new Rectangle(x,y,width,height+2);
    }
     //Está responsavel pela parte visual do bloco Wall.
    public void draw(Graphics2D gtd){
        gtd.setColor(Color.lightGray);
        gtd.drawRect(x,y,width,height);
        gtd.setColor(Color.WHITE);
        gtd.fillRect(x,y,width,height);
    }
    public int set(int cameraX){
        x = startX + cameraX;
        hitbox.x = x;

        return x;
    }
}
