package Inputs;

import Main.GamePanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyChecker extends KeyAdapter {
    GamePanel gamePanel;
    public KeyChecker(GamePanel gamePanel){
        this.gamePanel = gamePanel;

    }
    @Override
    public void keyPressed(KeyEvent e){
        gamePanel.keyPressed(e);
    }
    @Override
    public void keyReleased(KeyEvent e){
        gamePanel.keyReleased(e);
    }
}
