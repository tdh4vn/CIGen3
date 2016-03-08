import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Tdh4vnPC on 3/1/2016.
 */
public class PlaneEnemy extends GameObject implements Observer{
    private int speed;
    private int count = 0;
    public int getSpeed() {
        return speed;
    }
    private Vector<Bullet> vecBul = new Vector<Bullet>();


    public void setSpeed(int speed) {
        this.speed = speed;
    }

    private PlaneEnemy(){

    }

    public void shot(){
        Bullet bullet = new Bullet(positionX+30,positionY+59,-5);
        vecBul.add(bullet);
    }

    public PlaneEnemy(int positionX,int positionY,int speed) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
        try {
            this.sprite = ImageIO.read(new File("Resources/PLANE1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void move(){
        this.positionX += this.speed;
        if(this.positionX <= 0)
        {
            this.speed =- this.speed;
        }
        if(this.positionX >= 400) {
            this.speed =- this.speed;
        }
    }

    public void update(){//60 lan 1 giay
        count++;
        if(count >= 120){
            this.shot();
            count=0;
        }
        for(Bullet bul : vecBul){
            bul.update();
        }
        move();
    }

    public void draw(Graphics g){
        for (Bullet bul : vecBul){
            bul.draw(g);
        }
        g.drawImage(sprite,positionX,positionY,null);
    }

    @Override
    public void update(String msg) {
        if(msg.equals("Bo Vua An Duoc Qua")){
            System.out.println("Thang Player Vua An Duoc Qua Roi");
        }
    }
}
