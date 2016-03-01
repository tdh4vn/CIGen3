import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by hungtran on 3/1/16.
 */
public class Plane {
    private int positionX;
    private int positionY;
    private int hp;
    private int planeType;
    private int dam;
    private int speed;
    private BufferedImage sprite;
    private int direction;

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPlaneType() {
        return planeType;
    }

    public void setPlaneType(int planeType) {
        this.planeType = planeType;
    }

    public int getDam() {
        return dam;
    }

    public void setDam(int dam) {
        this.dam = dam;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;

    }

    private void move(){
        switch (direction){
            case 0:
                //dung im
                break;
            case 1:
                this.positionY -= this.speed;
                break;
            case 2:
                this.positionY += this.speed;
                break;
            case 3:
                this.positionX -= this.speed;
                break;
            case 4:
                this.positionX += this.speed;
                break;
        }
    }
    public void update(){
        this.move();
    }
    public void draw(Graphics g){
        g.drawImage(sprite,positionX,positionY,null);
    }

}
