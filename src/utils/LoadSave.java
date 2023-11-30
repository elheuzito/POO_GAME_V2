package utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoadSave implements Constants{



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
