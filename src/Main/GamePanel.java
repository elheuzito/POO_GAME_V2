package Main;

import Entidade.Player;
import Entidade.Projetil;
import Entidade.Wall;
import Inputs.MouseInputs;

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
    // TIME
    Timer gameTimer;
    Projetil projetil,projetil1;
    // Onde as Classes são instanciadas, criando objetos.
    public GamePanel(ArrayList<Wall> walls) throws IOException {
        // ADICIONANDOS OS INPUTS
        mouseInputs = new MouseInputs(this);
        this.walls = walls;
        projetil = new Projetil(0,0,10,500,30,30);
        projetil1 = new Projetil(0,0,10,800,30,30);
//        addMouseListener(mouseInputs);
//        addMouseMotionListener(mouseInputs);
        player = new Player(200,300,60,58,this,0,0);
        // RESPONSAVEL PELO LOOP DO JOGO.
        gameTimer = new Timer();
        gameTimer.schedule(new TimerTask() {


            @Override
            public void run() {
                // LOGICA DAS ANIMAÇÕES A FAZER
                // LOGICA DE MOVIMENTO E COLISÃO DO PERSONAGEM
                projetil.projetilSet();
                projetil1.projetilSet();
                player.set();
                repaint();
            }
        },0,17);
    }


    // RESPONSAVEL PELA RENDERIZAÇÃO EM TELA NO PAINEL
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D gtd = (Graphics2D) g;
        player.draw(gtd);
        projetil.drawProjetil(gtd);
        projetil1.drawProjetil(gtd);
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
}