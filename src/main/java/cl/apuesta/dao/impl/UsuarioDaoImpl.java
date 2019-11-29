/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.apuesta.dao.impl;

import cl.apuesta.dao.UsuarioDao;
import cl.apuesta.entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDaoImpl implements UsuarioDao { 

    EntityManager entityManager;
    EntityManagerFactory entityManagerFactory;

    public UsuarioDaoImpl() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("pu");
	this.entityManager = entityManagerFactory.createEntityManager();
        this.entityManager = this.entityManagerFactory.createEntityManager();

    }

    @Override
    public List<Usuario> findAll() {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
        TypedQuery<Usuario> query = this.entityManager.createQuery(criteriaQuery);
        List<Usuario> usuarios = query.getResultList();
        return usuarios;
    }

    @Override
    public Usuario find(int id) {
        Usuario usuario = this.entityManager.getReference(Usuario.class, id);
        return usuario;
    }

    @Override
    public Usuario find(String nick, String passowrd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int add(Usuario usuario) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(usuario);
        this.entityManager.flush();
        this.entityManager.getTransaction().commit();
        return usuario.getId();
    }

    @Override
    public int update(Usuario usuario) {
        Usuario usr = this.entityManager.find(Usuario.class, usuario.getId());
        this.entityManager.getTransaction().begin();
        usr.setNick(usuario.getNick());
        usr.setClave(usuario.getClave());
        usr.setSaldo(usuario.getSaldo());
        usr.setTipo(usuario.getTipo());
        this.entityManager.persist(usr);
        this.entityManager.getTransaction().commit();
        return usr.getId();
    }

    @Override
    public int delete(int id) {
        Usuario usuario = this.entityManager.getReference(Usuario.class, id);
        this.entityManager.remove(usuario);
        return usuario.getId();
    }
    
}
