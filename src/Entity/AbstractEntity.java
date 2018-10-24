package Entity;

import java.util.*;

/**
 * @author BrefNGames
 */
public abstract class AbstractEntity implements Entityable {


    private int id;

    /**
     * Default constructor
     */
    public AbstractEntity() {
    }

    @Override
    public void save() {
    }

    @Override
    public void delete() {
    }

    @Override
    public int getId() {
        return this.id;
    }
}
