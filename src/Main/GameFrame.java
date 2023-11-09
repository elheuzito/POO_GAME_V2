package Main;

import Entidade.Wall;
import Entidade.WallGenerator;
import Inputs.KeyChecker;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameFrame extends JFrame {
    ArrayList<Wall> walls = WallGenerator.generateWalls();

    public GameFrame(){
        GamePanel gamePanel = new GamePanel(walls);
        gamePanel.setLocation(0,0);
        gamePanel.setSize(this.getSize());
        gamePanel.setBackground(Color.GRAY);
        gamePanel.setVisible(true);

        this.add(gamePanel);
        addKeyListener(new KeyChecker(gamePanel));
    }

}
