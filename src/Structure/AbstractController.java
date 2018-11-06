package Structure;

public abstract class AbstractController {

    private AbstractModel model;

    private AbstractView view;

    public AbstractController(AbstractModel model, AbstractView view) {
        this.model = model;
        this.view = view;
    }
}
