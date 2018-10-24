package Entity;

public interface Entityable {
    /**
     * Save in database
     */
    public void save();

    /**
     * Delete from database
     */
    public void delete();

    /**
     * @return Entity Id
     */
    public int getId();

}
