package Main;

import javax.swing.*;

public class Main {
    public static void main (String [] args){
        GameFrame gameFrame = new GameFrame();
        gameFrame.setSize(1600,900);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setResizable(false);
        gameFrame.setVisible(true);
    }
}
