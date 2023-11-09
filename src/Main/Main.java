package Main;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main (String [] args) throws IOException {
        GameFrame gameFrame = new GameFrame();
        gameFrame.setSize(1600,900);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setResizable(false);
        gameFrame.setVisible(true);
    }
}
