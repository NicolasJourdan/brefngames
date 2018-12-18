package Structure;

import java.util.Observable;
import java.util.Observer;

public abstract class AbstractController extends Observable implements Observer {

    protected AbstractModel model;

    protected AbstractView view;

    public AbstractController(AbstractModel model, AbstractView view) {
        this.model = model;
        this.model.addObserver(this);
        this.view = view;
        this.view.addObserver(this);
    }
}
