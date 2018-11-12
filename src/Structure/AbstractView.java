package Structure;

import javax.swing.*;
import java.util.Observer;

public abstract class AbstractView extends JPanel {

    protected ProxyObservable observable;

    public AbstractView() {
        this.observable = new ProxyObservable();
    }

    public void addObserver(Observer observer) {
        this.observable.addObserver(observer);
    }
}
