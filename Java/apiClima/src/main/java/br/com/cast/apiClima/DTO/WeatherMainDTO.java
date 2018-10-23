package br.com.cast.apiClima.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherMainDTO {
	
	@JsonProperty("temp_min")
	private String tempMin;
	@JsonProperty("temp_max")
	private String tempMax;
	@JsonProperty("pressure")
	private String pressao;
	@JsonProperty("humidity")
	private String umidade;

	
	
	public String getTempMin() {
		return tempMin;
	}
	public void setTempMin(String tempMin) {
		this.tempMin = tempMin;
	}
	public String getTempMax() {
		return tempMax;
	}
	public void setTempMax(String tempMax) {
		this.tempMax = tempMax;
	}
	public String getPressao() {
		return pressao;
	}
	public void setPressao(String pressao) {
		this.pressao = pressao;
	}
	public String getUmidade() {
		return umidade;
	}
	public void setUmidade(String umidade) {
		this.umidade = umidade;
	}
	
	
}
