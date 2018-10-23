package br.com.cast.apiClima.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.apiClima.DTO.WeatherDTO;
import br.com.cast.apiClima.DTO.WeatherDataDTO;
import br.com.cast.apiClima.DTO.WeatherDescriptionDTO;
import br.com.cast.apiClima.entidade.Weather;
import br.com.cast.apiClima.repository.WeatherRepository;

@Service
public class PrevisaoService {

	@Autowired
	private RestAPI rest;

	@Autowired
	private WeatherRepository repository;

	@Transactional
	public void getListaTempo(String cidade) {

		WeatherDTO previsoes = rest.fecthTempo(cidade);
		// List<ResultWeatherDTO> listaResult = new ArrayList<>();

		Map<String, WeatherDataDTO> mapa = new HashMap<>();

		for (WeatherDataDTO conteudo : previsoes.getListaTempo()) {
			String chave = conteudo.getData().substring(0, 10);
			if (!mapa.containsKey(chave)) {
				mapa.put(chave, conteudo);
			}
		}

		Integer tamanhoMapa = mapa.size();

		List<WeatherDataDTO> listaResult = Arrays.asList(mapa.values().toArray(new WeatherDataDTO[tamanhoMapa]));
		previsoes.setListaTempo(listaResult);

		for (WeatherDataDTO data : previsoes.getListaTempo()) {
			Weather result = new Weather();
			result.setPressao(data.getPrincipal().getPressao());
			result.setTempMax(data.getPrincipal().getTempMax());
			result.setTempMin(data.getPrincipal().getTempMin());
			result.setUmidade(data.getPrincipal().getUmidade());
			result.setVento(data.getVento().getVelVento());

			for (WeatherDescriptionDTO descricao : data.getDescricao()) {
				result.setMain(descricao.getMain());
				result.setIcon(descricao.getIcon());
			}
			result.setData(data.getData());
			result.setCidade(cidade);
			repository.add(result);
		}
	}

	@Transactional
	public List<Weather> verificaClima(String cidade) {

		String data = "16-10-2018";

		List<Weather> lista = repository.buscaTodos(cidade, data);

		if (lista.size() < 5) {

			repository.remove(cidade);
			lista.clear();
			getListaTempo(cidade);
			lista = repository.buscaTodos(cidade, data);
		}
		return lista;
	}

}