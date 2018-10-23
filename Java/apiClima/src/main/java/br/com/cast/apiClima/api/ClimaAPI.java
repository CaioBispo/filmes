package br.com.cast.apiClima.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.apiClima.Service.PrevisaoService;
import br.com.cast.apiClima.entidade.Weather;

@RestController
@RequestMapping(path="/clima")
public class ClimaAPI {

	@Autowired
	private PrevisaoService prev;
	
	@RequestMapping(path="/{cidade}", method=RequestMethod.GET)
	public List<Weather> novaCidade(@PathVariable("cidade") String cidade) {
		//prev.verificaClima(cidade);
		return prev.verificaClima(cidade);
	}
	
}