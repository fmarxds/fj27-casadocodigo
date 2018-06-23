package br.com.casadocodigo.loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.User;

@Repository
public class UserDao implements UserDetailsService {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		String jpql = "SELECT u FROM User u WHERE u.login = :login";
		
		List<User> users = manager.createQuery(jpql, User.class).setParameter("login", userName).getResultList();
		if (users.isEmpty()) {
			throw new UsernameNotFoundException("Usuário ["+userName+"] não encontrado");
		}
		return users.get(0);
	}

}
