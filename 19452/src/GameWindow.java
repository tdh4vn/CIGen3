
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by hungtran on 2/26/16.
 */
public class GameWindow extends Frame implements Runnable {
    Graphics seconds;
    Image image;
    BufferedImage background;
    Vector<PlaneEnemy> vectorPlaneEnemy;
    int direction = 0;

    public GameWindow() {
        vectorPlaneEnemy = PlaneEnemyManager.getInstance().getVectorPlaneEnemy();
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
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if(e.getModifiers()==InputEvent.BUTTON1_MASK){
                    PlaneManager.getInstance().getPlaneMoveByMouse().shot();

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                PlaneManager.getInstance().getPlaneMoveByMouse().move(e.getX(),e.getY());
            }
        });
        this.addKeyListener(new KeyListener() {
            //truoc khi bam
            @Override
            public void keyTyped(KeyEvent e) {

            }
            //khi dang giu phim
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_Q){
                    PlaneManager.getInstance().getPlaneMoveByKey().notifiObserver();
                }
                else if(e.getKeyCode() == KeyEvent.VK_A) {
                    PlaneManager.getInstance().getPlaneMoveByKey().setDirection(3);
                } else if(e.getKeyCode() == KeyEvent.VK_D) {
                    PlaneManager.getInstance().getPlaneMoveByKey().setDirection(4);
                } else if(e.getKeyCode() == KeyEvent.VK_W) {
                    PlaneManager.getInstance().getPlaneMoveByKey().setDirection(1);
                } else if(e.getKeyCode() == KeyEvent.VK_S) {
                    PlaneManager.getInstance().getPlaneMoveByKey().setDirection(2);
                } else if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    PlaneManager.getInstance().getPlaneMoveByKey().shot();
                }
            }
            //khi nhac phim len
            @Override
            public void keyReleased(KeyEvent e) {
                PlaneManager.getInstance().getPlaneMoveByKey().setDirection(0);
            }
        });
    }
    private void initPlane(){


       // planeEnemy = new PlaneEnemy(200,200,5);
        vectorPlaneEnemy.add(new PlaneEnemy(200, 200, 1));
        vectorPlaneEnemy.add(new PlaneEnemy(150, 100, 2));
        vectorPlaneEnemy.add(new PlaneEnemy(100, 150, 3));
        vectorPlaneEnemy.add(new PlaneEnemy(250, 120, 4));
        vectorPlaneEnemy.add(new PlaneEnemy(300, 90, 5));
        for(PlaneEnemy planeEnemy:vectorPlaneEnemy){
            PlaneManager.getInstance().getPlaneMoveByKey().addObserver(planeEnemy);
        }
//        planeMoveByKey.setPositionX(300);
//        planeMoveByKey.setPositionY(400);
//        planeMoveByKey.setSpeed(4);
//        //planeImage = ImageIO.read(new File("Resources/PLANE1.png"));
//        try {
//            planeMoveByKey.setSprite(ImageIO.read(new File("Resources/PLANE1.png")));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Plane planeMoveByMouse = new Plane();

    }
    //ham ve
    //ve~ moi. thu o day
    @Override
    public void update(Graphics g){
        if(image == null){
            image = createImage(this.getWidth(), this.getHeight());
            seconds= image.getGraphics();
        }
        seconds.setColor(getBackground());
        seconds.fillRect(0,0,getWidth(),getHeight());
        seconds.setColor(getForeground());
        paint(seconds);
        g.drawImage(image,0,0,null);
    }
    @Override
    public void paint(Graphics g) {

        super.paint(g);

        g.drawImage(background, 0, 0, null);

        PlaneManager.getInstance().getPlaneMoveByKey().draw(g);
        PlaneManager.getInstance().getPlaneMoveByMouse().draw(g);
        for(PlaneEnemy planeEnemy : vectorPlaneEnemy){
            planeEnemy.draw(g);
        }
        //g.drawLine(0,0, 100, 100);
    }
    //Game Loop
    //Vong Lap game
    @Override
    public void run() {

        while(true) {

            PlaneManager.getInstance().getPlaneMoveByKey().update();
            PlaneManager.getInstance().getPlaneMoveByMouse().update();
            for(PlaneEnemy planeEnemy : vectorPlaneEnemy){
                planeEnemy.update();
            }

            repaint();


            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}