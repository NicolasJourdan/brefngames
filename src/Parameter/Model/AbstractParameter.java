package Parameter.Model;

public abstract class AbstractParameter implements Configurable {

    /**
     * The current value
     */
    public Object value;

    @Override
    public Object getValue() {
        return this.value;
    }

    @Override
    public void setValue(Object value) {
        this.value = value;
    }
}
