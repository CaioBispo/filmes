package br.com.cast.recomenda.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.recomenda.Entidade.Filme;
import br.com.cast.recomenda.Entidade.FilmeSmall;

@Repository
public class RecomendaRepository {

	@PersistenceContext
	private EntityManager em;

	public void addSmall(FilmeSmall filme) {
		em.persist(filme);
	}

	public List<Filme> buscarTodos() {
		StringBuilder jpql = new StringBuilder();
		jpql.append("select f ")
						.append("from ")
						.append(Filme.class.getName())
						.append(" f ");

		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
	}

	public FilmeSmall buscarPorId(String id) {
		return em.find(FilmeSmall.class, id);	
	}

	public List<FilmeSmall> buscaPorTitulo(String titulo) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("select f ")
						.append("from ")
						.append(Filme.class.getName())
						.append(" f ")
						.append("where title = (:titulo)");

		Query query = em.createQuery(jpql.toString());
		query.setParameter("titulo", titulo);

		try {
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}

	}
}
