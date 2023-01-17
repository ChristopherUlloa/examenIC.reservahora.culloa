package com.petsmile.service;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.petsmile.model.Usuario;

@Stateless
public class SesionServiceImpl implements SesionService {

	private final static Logger LOG = Logger.getLogger(SesionServiceImpl.class.getName());
	
	@Override
	public Usuario validarUsuario(String user, String password) {
		
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("clinica");
        EntityManager em = factory.createEntityManager();
        
		Usuario usuario = null;
		try {
		Query q = em.createNamedQuery("Usuario.findByIdAndPassword",Usuario.class);
		q.setParameter(1, user);
		q.setParameter(2, password);
		usuario = (Usuario) q.getSingleResult();
		} catch (NoResultException e) {
			LOG.info("Registro no encontrado");
		}
		return usuario; 
	}

}
