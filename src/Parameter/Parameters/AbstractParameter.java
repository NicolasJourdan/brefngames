package Parameter.Parameters;

import Structure.AbstractModel;

import java.io.Serializable;

public abstract class AbstractParameter extends AbstractModel implements Configurable, Serializable {

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
