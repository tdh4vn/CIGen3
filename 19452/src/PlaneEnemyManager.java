import java.util.Vector;

/**
 * Created by tdh4vn on 08/03/2016.
 */
public class PlaneEnemyManager {
    private Vector<PlaneEnemy> vectorPlaneEnemy;
    private static PlaneEnemyManager ourInstance = new PlaneEnemyManager();

    public static PlaneEnemyManager getInstance() {
        return ourInstance;
    }

    private PlaneEnemyManager() {
        vectorPlaneEnemy = new Vector<PlaneEnemy>();
    }

    public Vector<PlaneEnemy> getVectorPlaneEnemy() {
        return vectorPlaneEnemy;
    }
}
