package Structure;

import java.util.Observer;

public abstract class AbstractController implements Observer {

    protected AbstractModel model;

    protected AbstractView view;

    public AbstractController(AbstractModel model, AbstractView view) {
        this.model = model;
        this.view = view;
    }
}