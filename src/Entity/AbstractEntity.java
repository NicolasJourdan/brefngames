package Entity;

public abstract class AbstractEntity implements Entityable {

    private int id;

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
