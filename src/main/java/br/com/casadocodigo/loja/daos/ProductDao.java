package br.com.casadocodigo.loja.daos;

import java.util.List;

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
	
	public List<Product> list() {
		return manager.createQuery("select distinct p from Product p join fetch p.prices ", Product.class).getResultList();
	}

}
