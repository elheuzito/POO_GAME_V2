package Main;

import Entidade.Player;
import Entidade.Wall;
import Inputs.KeyboardInputs;
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
    public GamePanel(ArrayList<Wall> walls) throws IOException {
        // ADICIONANDOS OS INPUTS
        mouseInputs = new MouseInputs(this);
        this.walls = walls;
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
        player = new Player(200,300,60,60,this,0,0);
        gameTimer = new Timer();
        gameTimer.schedule(new TimerTask() {


            @Override
            public void run() {
                player.set();
                repaint();
            }
        },0,17);
    }



    public void paint(Graphics g){
        super.paint(g);
        Graphics2D gtd = (Graphics2D) g;
        player.draw(gtd);
        for(Wall wall:walls) wall.draw(gtd);
    }

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
}