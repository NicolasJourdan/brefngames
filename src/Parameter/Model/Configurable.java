package Parameter.Model;

import java.util.*;

/**
 * 
 */
public interface Configurable {

    /**
     * Get the current value
     */
    public Object getValue();

    /**
     * Set the current value
     */
    public void setValue(Object value);
}
