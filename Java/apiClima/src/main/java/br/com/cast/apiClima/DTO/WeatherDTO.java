package br.com.cast.apiClima.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherDTO {

	@JsonProperty("list")
	List<WeatherDataDTO> listaTempo;

	public List<WeatherDataDTO> getListaTempo() {
		return listaTempo;
	}

	public void setListaTempo(List<WeatherDataDTO> listaTempo) {
		this.listaTempo = listaTempo;
	}
	
}
