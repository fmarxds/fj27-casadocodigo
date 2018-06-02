package br.com.casadocodigo.loja.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.models.Product;

@Repository
public class ProductDao {
	
	@PersistenceContext
	private EntityManager manager;

	@Transactional
	public void save(Product product) {
		manager.persist(product);
	}

}
