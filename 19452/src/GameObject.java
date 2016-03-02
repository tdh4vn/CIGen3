import java.awt.image.BufferedImage;

/**
 * Created by Tdh4vnPC on 3/1/2016.
 */
public abstract class GameObject {
    protected int positionX;
    public int positionY;
    public BufferedImage sprite;

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }
}