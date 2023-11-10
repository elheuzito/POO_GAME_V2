package Entidade;

import Main.GamePanel;
import Main.Main;
import utils.LoadSave;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class Player extends Entidade{
    private GamePanel gamePanel;
    Rectangle hitbox;


    BufferedImage[]  animations_idle;
    BufferedImage[]  animations_run;

    BufferedImage[] animations_run_flipped;

    boolean running_right,runnnig_left, idle;


    private int aniTick, aniIndex, aniSpeed = 25;


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
    public void loadSprite() {
        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_IDLE);
        BufferedImage img2 = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_RUN);
        BufferedImage img3 = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_RUN_LEFT);

        animations_idle = new BufferedImage[6];
        for(int i = 0; i < animations_idle.length;i++){
            animations_idle[i] = img.getSubimage(0,i*32,32,32);
        }
        animations_run = new BufferedImage[10];
        for(int i = 0; i < animations_idle.length;i++){
            animations_run[i] = img2.getSubimage(0,i*32,32,32);
        }
        animations_run_flipped = new BufferedImage[10];
        for(int i = 0; i < animations_idle.length;i++){
            animations_run_flipped[i] = img3.getSubimage(0,i*32,32,32);
        }



    }
    private void updateAnimationTick() {
        aniTick++;
        if(aniTick >= aniSpeed){
            aniTick = 0;
            aniIndex++;
            if(aniIndex >= 6){
                aniIndex = 0;
            }
        }
    }

    private void setAnimation() {
        if(xspeed > 0){
            running_right = true;
            runnnig_left = false;
            idle = false;
        } else if (xspeed < 0) {
            runnnig_left = true;
            running_right = false;
            idle = false;
        } else if (xspeed == 0 && yspeed == 0){
            idle = true;
            running_right = false;
            runnnig_left = false;
        }
    }


    public void set() {
        setAnimation();
        updateAnimationTick();
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
        if(running_right){
        gtd.drawImage(animations_run[aniIndex],x,y,60,60,null);
        }
        if(runnnig_left){
            gtd.drawImage(animations_run_flipped[aniIndex],x,y,60,60,null);
        }
        if(idle){
            gtd.drawImage(animations_idle[aniIndex],x,y,60,60,null);
        }
}
}
