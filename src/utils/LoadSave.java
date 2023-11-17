package utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoadSave {
    public static final String PLAYER_IDLE = "ChikBoy_idle.png";
    public static final String PLAYER_RUN = "ChikBoy_run.png";

    public static final String PLAYER_RUN_LEFT = "ChikBoy_run_left.png";

    public static final String CANVAS1 = "1.png";
    public static final String CANVAS2 = "2.png";
    public static final String CANVAS3 = "3.png";
    public static final String CANVAS4 = "4.png";

    public static final String CANVAS_GLOBAL = "proto3.png";

    public static final String vida = "HeartFull.png";




    public static final String LEVEL_ATLAS = "";
    public static BufferedImage GetSpriteAtlas(String FileName){
        File file = new File("C:\\Users\\PICHAU\\IdeaProjects\\plataformerv2\\src\\extra\\"+FileName);
        BufferedImage img;

        try {
            img = ImageIO.read(file);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return img;
    }
    public LoadSave() {

    }
}
