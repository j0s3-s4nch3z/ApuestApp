package cl.apuesta.controller.usuario;

import cl.apuesta.dao.impl.UsuarioDao;
import cl.apuesta.entity.Usuario;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    
    UsuarioDao usuarioDao;

    public UsuarioController(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
    
    @GetMapping("/rest/get/users")
    List<Usuario> findAll() {
        return usuarioDao.findAll();
    }
    
    @PostMapping("/rest/get/users/user")
        List<Usuario> findAll(@RequestBody Usuario usuario) {
        return usuarioDao.findAll(usuario);
    }
    
    @PostMapping("/rest/get/user/{id}")
    Usuario find(int id) {
        return usuarioDao.find(id);
    }
    
    @PostMapping("/rest/get/login/{nick}")
    Usuario find(@RequestBody Usuario usuario, @PathVariable String nick) {
        return usuarioDao.find(usuario);
    }
    
    @PostMapping("/rest/add/user")
    int add(@RequestBody Usuario usuario) {
        usuarioDao.add(usuario);
        return usuario.getId();
    }
    
    @PutMapping("/rest/update/user/{id}")
    int update(@RequestBody Usuario usuario, @PathVariable int id) {
        usuarioDao.update(usuario);
        return usuario.getId();
    }
    
    @DeleteMapping("rest/delete/user/{id}")
    int delete(@PathVariable int id) {
        return usuarioDao.delete(id);
    }
    
}
