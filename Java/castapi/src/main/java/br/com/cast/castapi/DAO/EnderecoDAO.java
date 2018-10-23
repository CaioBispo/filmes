package br.com.cast.castapi.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.castapi.entidade.Endereco;

@Repository
public class EnderecoDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Endereco buscarPorId(Integer id) {
		return em.find(Endereco.class, id);
	}
	
	public List<Endereco> buscarTodos() {
		StringBuilder jpql = new StringBuilder();
		jpql.append("select e ")
			.append("from ").append(Endereco.class.getName()).append(" e ")
			.append("INNER JOIN fecth p.endereco e");
			
		
		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
	}
	
	public void inserir(Endereco endereco) {
		
		try {
			em.getTransaction().begin();
			em.persist(endereco);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	
	public void excluir(Endereco endereco) {
		
		try {
			em.getTransaction().begin();
			em.remove(endereco);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	
}
