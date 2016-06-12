package br.com.sistema.horas.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.sistema.horas.modelos.Usuario;

@RequestScoped
public class UsuarioDao {
   
	private EntityManager manager;
	
	@Inject
	public UsuarioDao(EntityManager manager){
		
		this.manager = manager;
	}
	
	public UsuarioDao(){}
	
	public void adiciona(Usuario usuario){
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
		
		
	}
	
	public List<Usuario> lista(){
        String jpql = "select u from Usuario u";
        TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
        return query.getResultList();
    }
	
	public Usuario busca(String login, String senha){
	    String jpql = "select u from Usuario u where u.login = :login and u.senha = :senha";
	    TypedQuery query = (TypedQuery) manager.createQuery(jpql);
	    query.setParameter("login", login);
	    query.setParameter("senha", senha);
	    return (Usuario) query.getSingleResult();
	}
	
	
}
