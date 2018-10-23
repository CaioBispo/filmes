package br.com.cast.apiClima.DTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherDataDTO {

	@JsonProperty("main")
	private WeatherMainDTO principal;
	@JsonProperty("weather")
	private List<WeatherDescriptionDTO> descricao;
	@JsonProperty("wind")
	private WeatherWindDTO vento;
	@JsonProperty("dt_txt")
	private String data;

	public List<WeatherDescriptionDTO> getDescricao() {
		return descricao;
	}

	public void setDescricao(List<WeatherDescriptionDTO> descricao) {
		this.descricao = descricao;
	}

	public WeatherMainDTO getPrincipal() {
		return principal;
	}

	public void setPrincipal(WeatherMainDTO principal) {
		this.principal = principal;

	}

	public WeatherWindDTO getVento() {
		return vento;
	}

	public void setVento(WeatherWindDTO vento) {
		this.vento = vento;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {

		this.data = conveterData(data);
	}

	private String conveterData(String iso8601) {

		DateTimeFormatter isoFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime date = LocalDateTime.parse(iso8601, isoFormatter);
		
		DateTimeFormatter brazilFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return brazilFormatter.format(date);
	}

}
