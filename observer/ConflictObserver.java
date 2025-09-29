package observer;
import util.Logger;
public class ConflictObserver implements Observer {
    @Override
    public void update(String message) {
        Logger.getInstance().info(message);
    }
}
