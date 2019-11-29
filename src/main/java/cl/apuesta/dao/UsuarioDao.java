package cl.apuesta.dao;

import cl.apuesta.entity.Usuario;
import java.util.List;

public interface UsuarioDao {
    
    public List<Usuario> findAll();
    
    public Usuario find(int id);
    
    public Usuario find(String nick,String passowrd);
    
    public int add(Usuario usuario);
    
    public int update(Usuario usuario);
    
    public int delete(int id);
    
}
