package Parameter.Model;

import Structure.AbstractModel;

public abstract class AbstractParameter extends AbstractModel implements Configurable {

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
