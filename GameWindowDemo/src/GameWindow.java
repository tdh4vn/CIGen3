
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by hungtran on 2/26/16.
 */
public class GameWindow extends Frame implements Runnable {

    BufferedImage background;
    Plane planeMoveByKey;

    int direction = 0;

    public GameWindow() {

        //thiet lap tieu de cho cua so
        this.setTitle("TechKids - code the change");
        //thiet lap kich thuoc cho cua so
        this.setSize(400, 640);
        //thiet lap xem cua so co hien thi hay khong
        this.setVisible(true);
        //khi an vao nut X thi thoat
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        //load Image tu thu muc Resource
        try {
            background = ImageIO.read(new File("Resources/Background.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        initPlane();
        //bat su kien di chuyen chuot
        //this.addMouseListener();
        //doan code de bat su kien bam phim
        this.addKeyListener(new KeyListener() {
            //truoc khi bam
            @Override
            public void keyTyped(KeyEvent e) {

            }
            //khi dang giu phim
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_A) {
                    planeMoveByKey.setDirection(3);
                } else if(e.getKeyCode() == KeyEvent.VK_D) {
                    planeMoveByKey.setDirection(4);
                } else if(e.getKeyCode() == KeyEvent.VK_W) {
                    planeMoveByKey.setDirection(1);
                } else if(e.getKeyCode() == KeyEvent.VK_S) {
                    planeMoveByKey.setDirection(2);
                }
            }
            //khi nhac phim len
            @Override
            public void keyReleased(KeyEvent e) {
                planeMoveByKey.setDirection(0);
            }
        });
    }
    private void initPlane(){
        planeMoveByKey = new Plane();
        planeMoveByKey.setPositionX(300);
        planeMoveByKey.setPositionY(400);
        planeMoveByKey.setSpeed(4);
        //planeImage = ImageIO.read(new File("Resources/PLANE1.png"));
        try {
            planeMoveByKey.setSprite(ImageIO.read(new File("Resources/PLANE1.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //ham ve
    //ve~ moi. thu o day
    @Override
    public void paint(Graphics g) {

        super.paint(g);

        g.drawImage(background, 0, 0, null);

        planeMoveByKey.draw(g);

        //g.drawLine(0,0, 100, 100);
    }
    //Game Loop
    //Vong Lap game
    @Override
    public void run() {

        while(true) {

            planeMoveByKey.update();

            repaint();


            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}