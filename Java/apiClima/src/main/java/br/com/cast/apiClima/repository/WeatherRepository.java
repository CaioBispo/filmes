package br.com.cast.apiClima.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.apiClima.entidade.Weather;

@Repository
public class WeatherRepository {

	@PersistenceContext
	private EntityManager em;

	public void add(Weather weather) {
		em.persist(weather);
	}

	public List<Weather> buscaTodos(String cidade, String data) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT w ").append("FROM ").append(Weather.class.getName()).append(" w ")
				.append("WHERE CIDADE = (:cidade) and DATA >= (:data)");

		Query query = em.createQuery(jpql.toString());
			  query.setParameter("cidade", cidade);
			  query.setParameter("data", data);
		
		return query.getResultList();
	}


	public void remove(String cidade) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("DELETE ").append("FROM ").append(Weather.class.getName())
				.append(" WHERE CIDADE = (:cidade)");

		Query query = em.createQuery(jpql.toString());
		query.setParameter("cidade", cidade);
		
		query.executeUpdate();
		
	}
}
