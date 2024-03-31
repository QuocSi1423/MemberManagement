package DAL.IDAL;

public interface IObjectDAL {
    public <T> boolean insertObject(T object);
    public <T> boolean updateObject(T object);
    public boolean removeObject(Long objectID);
    public <T> T getAnObjectByID(Long objectID);
}