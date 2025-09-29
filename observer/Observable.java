package observer;
import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    private List<Observer> observerList = new ArrayList<>();

    public void addObserver(Observer o) {
        observerList.add(o);
    }

    public void notifyObservers(String message) {
        for(Observer o : observerList) {
            o.update(message);
        }
    }
}
