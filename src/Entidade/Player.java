package Entidade;

import Main.GamePanel;
import Main.Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entidade{
    private GamePanel gamePanel;
    Rectangle hitbox;
    BufferedImage img;


    public boolean keyLeft;
    public boolean keyRight;
    public boolean keyUp;
    public boolean keyDown;
    public Player(int x, int y, int height, int width, GamePanel gamePanel, double xpeed, double yspeed) throws IOException {
        super(x, y, height, width, gamePanel,xpeed,yspeed);
        this.gamePanel = gamePanel;
        hitbox = new Rectangle(x,y,width,height);
        loadSprite();
    }
    public void loadSprite() throws IOException {
        String path = "C:\\Users\\PICHAU\\IdeaProjects\\plataformerv2\\src\\extra\\teste.png";
        File file = new File(path);
        img = ImageIO.read(file);
    }

    public void set() {
        if(keyLeft && keyRight || !keyLeft && !keyRight) xspeed *= 0.7;
        else if (keyLeft && !keyRight) xspeed--;
        else if (keyRight && !keyLeft) xspeed++;

        if(xspeed > 0 && xspeed < 0.75) xspeed = 0;
        if(xspeed < 0 && xspeed > -0.75) xspeed = 0;

        if(xspeed > 8) xspeed = 8;
        if(xspeed < -8) xspeed = -8;

        if(keyUp){
            // Checar se estar no chão
            hitbox.y++;
            for(Wall wall: gamePanel.walls){
                if(wall.hitbox.intersects(hitbox)) yspeed = -8;
            }
            hitbox.y --;
        }
        yspeed += 0.35;
        // Horizontal Colisão
        hitbox.x += xspeed;
        for(Wall wall: gamePanel.walls){
            if(hitbox.intersects(wall.hitbox)){
                hitbox.x -= xspeed;
                while(!wall.hitbox.intersects(hitbox)) hitbox.x += Math.signum(xspeed);
                hitbox.x -= Math.signum(xspeed);
                xspeed = 0;
                x = hitbox.x;
            }
        }
        // Vertical
        hitbox.y += yspeed;
        for(Wall wall: gamePanel.walls){
            if(hitbox.intersects(wall.hitbox)){
                hitbox.y -= yspeed;
                while(!wall.hitbox.intersects(hitbox)) hitbox.y += Math.signum(yspeed);
                hitbox.y -= Math.signum(yspeed);
                yspeed = 0;
                y= hitbox.y;
            }
        }

        x += xspeed;
        y += yspeed;
        hitbox.x = x;
        hitbox.y = y;
    }
    public void draw(Graphics2D gtd){
        gtd.drawImage(img,x,y,32,32,null);
    }
}
