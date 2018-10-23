package br.com.cast.recomenda.Client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.cast.recomenda.DTO.SearchSmallDTO;

@Component
public class RecomendaClient {

	private final RestTemplate rest;
	
	private static final String FILME_URL = "http://www.omdbapi.com/?s={title}&apikey=89547e8d&";

	public RecomendaClient(RestTemplateBuilder builder) {
		this.rest = builder.build();
	}
	
	public SearchSmallDTO getFilmeNaNuvem(String title) {
		return this.rest.getForObject(FILME_URL, SearchSmallDTO.class, title);
	}
}

