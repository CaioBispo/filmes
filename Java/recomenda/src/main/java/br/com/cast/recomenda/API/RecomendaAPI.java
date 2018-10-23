package br.com.cast.recomenda.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.recomenda.DTO.FilmeDTO;
import br.com.cast.recomenda.DTO.FilmeSmallDTO;
import br.com.cast.recomenda.Service.RecomendaService;

@RestController
@RequestMapping(path="/recomenda")
public class RecomendaAPI {

	@Autowired
	private RecomendaService recomenda;
	
	
	@RequestMapping(path="/{title}", method=RequestMethod.PUT)
	public List<FilmeSmallDTO> buscarPorTitulo(@PathVariable("title") String titulo) {	
		List<FilmeSmallDTO> dtos = recomenda.buscarTituloSmallAPI(titulo);
		return dtos;
	}
}
