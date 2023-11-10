package utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoadSave {
    public static final String PLAYER_IDLE = "ChikBoy_idle.png";
    public static final String PLAYER_RUN = "ChikBoy_run.png";

    public static final String PLAYER_RUN_LEFT = "ChikBoy_run_left.png";




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
