import java.awt.*;

/**
 * Created by tdh4vn on 12/03/2016.
 */
public class Cat extends GameObject {
    Animation anim;
    int speedX = 3;
    int speedY = 0;
    public Cat(){
        anim = new Animation("Resources/player.png", 95, 130, 50);
        setPositionX(0);
        setPositionY(0);
    }
    void update(){
        setPositionX(getPositionX() + speedX);
        setPositionY(getPositionY() + speedY);
    }
    void draw(Graphics g){
        anim.draw(g, getPositionX() + GameManager.getInstance().getLocationX()
                , getPositionY() + GameManager.getInstance().getLocationY());
        if(getPositionX() > GameManager.getInstance().getWindowWidth() / 2){
            int loX = GameManager.getInstance().getLocationX();
            GameManager.getInstance().setLocationX(loX - speedX);
        }
    }
}
