/**
 * Created by tdh4vn on 08/03/2016.
 */
public class PlaneManager {
    private static PlaneManager _sharePointer;
    private Plane planeMoveByKey;
    private Plane planeMoveByMouse;
    private PlaneManager(){
        planeMoveByKey = new Plane(200,200,3,4);
        planeMoveByMouse = new Plane(300,300,4,2);
    }
    public static PlaneManager getInstance(){
        if(_sharePointer == null){//nil
            _sharePointer = new PlaneManager();
        }
        return _sharePointer;
    }

    public Plane getPlaneMoveByKey() {
        return planeMoveByKey;
    }

    public Plane getPlaneMoveByMouse() {
        return planeMoveByMouse;
    }
}
