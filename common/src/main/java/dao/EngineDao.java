package dao;

public interface EngineDao<Entity, Key> {
    void create(Entity entity);
    Entity read(Key key);
    void update(Entity entity);
    void delete(Entity entity);
    void saveOrUpdate(Entity entity);
}