package br.com.cast.apiClima.DTO;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultWeatherDTO {

	
	private String main;
	private String icon;
	@JsonProperty("temp_min")
	private String tempMin;
	@JsonProperty("temp_max")
	private String tempMax;
	@JsonProperty("pressure")
	private String pressao;
	@JsonProperty("humidity")
	private String umidade;
	@JsonProperty("wind")
	private String vento;
	@JsonProperty("dt_txt")
	private String data;

	
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
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
	
	public String getVento() {
		return vento;
	}
	public void setVento(String vento) {
		this.vento = vento;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = conveterData(data);
	}

	private String conveterData(String data){
		
		String dataEmUmFormato = data;
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date ndata;
		try {
			ndata = formato.parse(dataEmUmFormato);
			formato.applyPattern("dd-MM-yyyy");
			String dataFormatada = formato.format(ndata);
			return dataFormatada;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
