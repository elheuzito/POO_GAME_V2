package Main;

import Entidade.Player;
import Entidade.Projetil;
import Entidade.Wall;
import Inputs.MouseInputs;
import utils.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    //public ArrayList<Wall> walls = new ArrayList<>();
    public ArrayList<Wall> walls;
    Player player;
    public int cameraX;
    // TIME
    Timer gameTimer;
    Projetil projetil,projetil1;
    // Onde as Classes são instanciadas, criando objetos.
    public GamePanel(ArrayList<Wall> walls) throws IOException {
        // ADICIONANDOS OS INPUTS
        mouseInputs = new MouseInputs(this);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
        this.walls = walls;
        projetil = new Projetil(0,0,10,500,30,30);
        projetil1 = new Projetil(0,0,10,800,30,30);
//        addMouseListener(mouseInputs);
//        addMouseMotionListener(mouseInputs);
        player = new Player(800,300,60,58,this,0,0);
        // RESPONSAVEL PELO LOOP DO JOGO.
        gameTimer = new Timer();
        gameTimer.schedule(new TimerTask() {


            @Override
            public void run() {
                // LOGICA DAS ANIMAÇÕES A FAZER
                // LOGICA DE MOVIMENTO E COLISÃO DO PERSONAGEM
                projetil.projetilSet();
                projetil1.projetilSet();
                for(Wall wall : walls) {wall.set(cameraX);}
                player.set();
                repaint();
            }
        },0,17);
    }
    public void reset(){
        player.x = 800;
        player.y = 300;
        player.xspeed = 0;
        player.yspeed = 0;
        cameraX = 0;
    }

    // RESPONSAVEL PELA RENDERIZAÇÃO EM TELA NO PAINEL
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D gtd = (Graphics2D) g;
        gtd.drawImage(LoadSave.GetSpriteAtlas(LoadSave.CANVAS1),0,0,1600,900,null);
        gtd.drawImage(LoadSave.GetSpriteAtlas(LoadSave.CANVAS2),0,0,1600,900,null);
        gtd.drawImage(LoadSave.GetSpriteAtlas(LoadSave.CANVAS3),0+((int)player.xspeed / 8),0,1600,900,null);
        //gtd.drawImage(LoadSave.GetSpriteAtlas(LoadSave.CANVAS4),0,0,1600,900,null);
        player.draw(gtd);
//        projetil.drawProjetil(gtd);
//        projetil1.drawProjetil(gtd);

        for(Wall wall:walls) wall.draw(gtd);
    }
    // INTERFACES RESPONSAVEIS PELOS INPUTS DO PLAYER.
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar()=='a') player.keyLeft = true;
        if(e.getKeyChar()=='d') player.keyRight = true;
        if(e.getKeyChar()=='w') player.keyUp = true;
        if(e.getKeyChar()=='s') player.keyDown = true;
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar()=='a') player.keyLeft = false;
        if(e.getKeyChar()=='d') player.keyRight = false;
        if(e.getKeyChar()=='w') player.keyUp = false;
        if(e.getKeyChar()=='s') player.keyDown = false;
    }
    public int getPlayerx(){
        return player.getX();
    }

    public Object getPlayery() { return player.getY();
    }

    public Player getPlayer() {
        return player;
    }
}