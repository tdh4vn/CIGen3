/**
 * Created by hungtran on 2/26/16.
 */
public class Program {

    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        Thread thread = new Thread(gameWindow);
        thread.start();

    }
}
