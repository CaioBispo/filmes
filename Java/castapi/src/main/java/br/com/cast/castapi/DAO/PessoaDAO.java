package br.com.cast.castapi.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.castapi.entidade.Pessoa;

@Repository
public class PessoaDAO {

	@PersistenceContext
	private EntityManager em;
	
	public List<Pessoa> buscarTodos() {
		StringBuilder jpql = new StringBuilder();
		jpql.append("select p ")
			.append("from ").append(Pessoa.class.getName()).append(" p ");

		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
	}
	
	
	public Pessoa buscarPorId(String cpf) {
		return em.find(Pessoa.class, cpf);
	}
	
	public void addPessoas(Pessoa pessoa) {
		em.persist(pessoa);
	}
	
	public void excluir(Pessoa pessoa) {
		em.remove(pessoa);
	}
	
	public void alteraPessoa(Pessoa pessoa) {
		em.merge(pessoa);
	}
	
	
}
