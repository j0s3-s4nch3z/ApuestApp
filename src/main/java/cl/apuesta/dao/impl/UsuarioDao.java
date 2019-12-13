/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.apuesta.dao.impl;

import cl.apuesta.dao.EntityDao;
import cl.apuesta.entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import org.eclipse.persistence.internal.jpa.EJBQueryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDao implements EntityDao<Usuario> {

    EntityManager entityManager;
    EntityManagerFactory entityManagerFactory;

    public UsuarioDao() {
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
    public List<Usuario> findAll(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario find(int id) {
        Usuario usuario = this.entityManager.getReference(Usuario.class, id);
        return usuario;
    }

    @Override
    public Usuario find(Usuario usuario) {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
        Root<Usuario> c = criteriaQuery.from(Usuario.class);
        criteriaQuery.select(c);
        criteriaQuery.where(criteriaBuilder.equal(c.get("nick"), usuario.getNick()),
                criteriaBuilder.equal(c.get("clave"), usuario.getClave()));
        List<Usuario> usuarios = this.entityManager.createQuery(criteriaQuery).getResultList();
        return usuarios.get(0);
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
