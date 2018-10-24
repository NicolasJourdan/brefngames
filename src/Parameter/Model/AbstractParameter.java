package Parameter.Model;

/**
 * @author BrefNGames
 */
public abstract class AbstractParameter implements Configurable {

    /**
     * The current value
     */
    public Object value;

    /**
     * Default constructor
     */
    public AbstractParameter() {
    }

    @Override
    public Object getValue() {
        return this.value;
    }

    @Override
    public void setValue(Object value) {
        this.value = value;
    }
}