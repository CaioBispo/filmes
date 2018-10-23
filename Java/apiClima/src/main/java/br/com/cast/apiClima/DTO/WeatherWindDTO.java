package br.com.cast.apiClima.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherWindDTO {

	@JsonProperty("speed")
	private String velVento;

	public String getVelVento() {
		return velVento;
	}

	public void setVelVento(String velVento) {
		this.velVento = velVento;
	}
	
	
}
