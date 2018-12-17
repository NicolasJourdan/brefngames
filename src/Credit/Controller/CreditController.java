package Credit.Controller;

import Structure.AbstractController;
import Structure.AbstractModel;
import Structure.AbstractView;

import java.util.Observable;

public class CreditController extends AbstractController {
    public CreditController(AbstractModel model, AbstractView view) {
        super(model, view);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.setChanged();
        this.notifyObservers(arg);
    }
}
