package br.com.casadocodigo.loja.daos;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.models.BookType;
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

	public Product find(Integer id) {
		return manager.createQuery("SELECT DISTINCT p FROM Product p JOIN FETCH p.prices WHERE p.id = :id", Product.class)
				.setParameter("id", id)
				.getSingleResult();
	}

	public BigDecimal sumPricesPerType(BookType bookType) {
		TypedQuery<BigDecimal> query = manager.createQuery(
				"select sum(price.value) from Product p join p.prices price where price.bookType = :bookType",
				BigDecimal.class);
		query.setParameter("bookType", bookType);
		return query.getSingleResult();
	}

}
