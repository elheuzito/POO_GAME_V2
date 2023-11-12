package Entidade;

import Main.GamePanel;
import utils.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background {
    public int x;
    int y;
    int height;
    int width;
    BufferedImage background;
    int cameraX;
    GamePanel gamePanel;
    public Background(int x, int y, int height, int width, GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        background = LoadSave.GetSpriteAtlas(LoadSave.CANVAS_GLOBAL);
    }
    public void draw(Graphics2D gtd){
        gtd.drawImage(background,x + cameraX ,y,width,height,null);


    }
    public void set(){
        cameraX -=  (int)gamePanel.getPlayer().xspeed;

   }
   public void reset(){
        cameraX = 0;
        x = gamePanel.getPlayerx() - 800 ;
   }
}
