package br.com.cast.recomenda.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchSmallDTO {

	@JsonProperty("Search")
	private List<FilmeSmallDTO> Search;

	
	public List<FilmeSmallDTO> getSearch() {
		return Search;
	}

	public void setSearch(List<FilmeSmallDTO> search) {
		this.Search = search;
	}
}
