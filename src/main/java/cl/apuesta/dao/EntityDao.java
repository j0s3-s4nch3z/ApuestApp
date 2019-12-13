package cl.apuesta.dao;

import java.util.List;

public interface EntityDao<T> {
    
    public List<T> findAll();
    
    public List<T> findAll(T object);
    
    public T find(int id);
    
    public T find(T object);
    
    public int add(T t);
    
    public int update(T t);
    
    public int delete(int id);
    
}
