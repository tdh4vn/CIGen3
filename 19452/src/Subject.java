import java.util.Objects;
import java.util.Vector;

/**
 * Created by tdh4vn on 08/03/2016.
 */
public interface Subject {
    void addObserver(Observer ob);
    void removeObserver(Observer ob);
    void notifiObserver();
}
