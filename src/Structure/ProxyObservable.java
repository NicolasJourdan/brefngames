package Structure;

import java.util.Observable;

public class ProxyObservable extends Observable {

    @Override
    public void notifyObservers(Object arg) {
        super.setChanged();
        super.notifyObservers(arg);
    }

    @Override
    public void notifyObservers() {
        super.setChanged();
        super.notifyObservers();
    }
}
