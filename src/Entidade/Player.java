package Entidade;

import Main.GamePanel;
import Main.Main;
import utils.LoadSave;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class Player extends Entidade{
    private GamePanel gamePanel;
    Rectangle hitbox;
    public int vida;


    BufferedImage[]  animations_idle;
    BufferedImage[]  animations_run;

    BufferedImage[] animations_run_flipped;
    BufferedImage img4;

    boolean running_right;
    boolean runnnig_left;
    boolean idle;
    public boolean gameover = false;
    private BufferedImage img5;

    @Override
    public String toString() {
        return "Player{" +
                "xspeed= " + (int)xspeed +
                ", yspeed= " + (int)yspeed +
                ", vida= " + vida +'}';
    }

    private int aniTick, aniIndex, aniSpeed = 12;


    public boolean keyLeft;
    public boolean keyRight;
    public boolean keyUp;
    public boolean keyDown;
    public Player(int x, int y, int height, int width, GamePanel gamePanel, double xspeed, double yspeed) throws IOException {
        super(x, y, height, width, gamePanel,xspeed,yspeed);
        this.gamePanel = gamePanel;
        vida = 3;
        hitbox = new Rectangle(x-10,y,width-10,height);
        loadSprite();

    }
    // Carregando os sprites em um Array, e colocando cada frame do sprite em uma posiçaõ do array.
    public void loadSprite() {
        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_IDLE);
        BufferedImage img2 = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_RUN);
        BufferedImage img3 = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_RUN_LEFT);
        img4 = LoadSave.GetSpriteAtlas(LoadSave.vida);
        img5 = LoadSave.GetSpriteAtlas(LoadSave.GAMEOVER);

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
    // Metódo para atualizar o sprite do personagem.
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
    // Lógica para saber em qual direção o personagem está indo
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
    public void impulse(MouseEvent e){
        if(e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2 ){
            if(keyUp){
                yspeed = -8;
                keyUp = false;
            }
        }
    }

    // Método que atualiza a lógica do personagem.
    public void set() {
        if(y > 900){
            gamePanel.reset();
            vida = vida - 1;
            if(vida < 1){
                gameover = true;
            }
        }
        setAnimation();
        updateAnimationTick();
        if(gameover == true){
            xspeed = 0;
            yspeed = 0;
            x = 0;
            y = 0;
        }
        if(keyLeft && keyRight || !keyLeft && !keyRight) xspeed *= 0.8;
        else if (keyLeft && !keyRight) xspeed--;
        else if (keyRight && !keyLeft) xspeed++;

        if(xspeed > 0 && xspeed < 0.75) xspeed = 0;
        if(xspeed < 0 && xspeed > -0.75) xspeed = 0;

        if(xspeed > 8) xspeed = 7;
        if(xspeed < -8) xspeed = -7;

        if(keyUp){
            // Checar se o personagem tocou no chão
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
                gamePanel.cameraX += x - hitbox.x;
                xspeed = 0;
                hitbox.x = x;
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

        gamePanel.cameraX -= (int) xspeed;
//        System.out.println(" teste "+gamePanel.cameraX);
        y += yspeed;
        hitbox.x = x;
        hitbox.y = y;
    }

    // Método que renderiza o personagem a partir da lógica adequada.
    public void draw(Graphics2D gtd){
        if(gameover == true){
            gtd.drawImage(img5, 0,0,1600,900,null);
        } else {
        if(vida == 1) {
            gtd.drawImage(img4, x - 750, 50, 32, 32, null);
        }
        if(vida == 2) {
            gtd.drawImage(img4, x - 750, 50, 32, 32, null);
            gtd.drawImage(img4, x - 750 + 35, 50, 32, 32, null);

        }
        if(vida == 3) {
            gtd.drawImage(img4, x - 750, 50, 32, 32, null);
            gtd.drawImage(img4, x - 750 + 35, 50, 32, 32, null);
            gtd.drawImage(img4, x - 750 + 70,50,32,32,null);

        }
        //TELA GAME OVER
        if(gameover == true){
            gtd.drawImage(img5, 0,0,1600,900,null);
        }

        if(running_right){
        gtd.drawImage(animations_run[aniIndex],x,y,60,60,null);
        }
        if(runnnig_left){
            gtd.drawImage(animations_run_flipped[aniIndex],x,y,60,60,null);
        }
        if(idle){
            gtd.drawImage(animations_idle[aniIndex],x,y,60,60,null);
        }
}}
}
