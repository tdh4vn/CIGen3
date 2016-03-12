import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by tdh4vn on 12/03/2016.
 */
public class Animation {
    BufferedImage bigImage;
    Vector<Image> vecFrame;
    int countTime;
    int index;
    int delta;
    public Animation(String dirImage, int width, int height, int delta){
        this.delta = delta;
        countTime = 0;
        vecFrame = new Vector<>();
        index = 0;
        try {
            bigImage = ImageIO.read(new File(dirImage));
            System.out.println((int)(bigImage.getHeight() / height));
            for(int i = 0; i < (int)(bigImage.getHeight() / height); i++){
                for(int j = 0; j < (int)bigImage.getWidth() / width; j++){
                    System.out.println(i + " " + j);
                    Image img = bigImage.getSubimage(j * width, i * height, width, height);
                    vecFrame.add(img);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void draw(Graphics g, int x, int y){
        g.drawImage(vecFrame.get(index),x,y,null);
        countTime += 17;
        if(countTime >= delta) {
            countTime = 0;
            index++;
            if (index >= vecFrame.size()) {
                index = 0;
            }
        }
    }
}
