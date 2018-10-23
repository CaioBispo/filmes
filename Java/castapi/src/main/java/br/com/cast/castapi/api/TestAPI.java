package br.com.cast.castapi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.castapi.DTO.PessoaDTO;
import br.com.cast.castapi.business.PessoaBusiness;

@RestController
@RequestMapping(path="/pessoa")
public class TestAPI {
	
	@Autowired
	private PessoaBusiness pB;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<PessoaDTO> buscarTodos() {
		return pB.buscaTodos();
	}
	
	@RequestMapping(path="/{cpf}", method=RequestMethod.GET)
	public PessoaDTO buscarPorCpf(@PathVariable("cpf") String cpf) {	
		PessoaDTO dto = pB.buscaPorId(cpf);
		return dto;
	}
	
	@RequestMapping(path="/{cpf}/{nome}", method=RequestMethod.GET)
	public String buscarPorCpfENome(
			@PathVariable("cpf") String cpf, 
			@PathVariable("nome") String nome) {
		System.out.println("parametros: " + cpf + ", " + nome);
		return "buscar por id";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void inserir(@RequestBody PessoaDTO dto) {
		pB.addPessoas(dto);
	}
	
	@RequestMapping(path="/{cpf}", method=RequestMethod.DELETE)
	public void excluir(@PathVariable("cpf") String cpf) {
		pB.excluir(cpf);
	}
	
	
	@RequestMapping(path="/{cpf}", method=RequestMethod.PUT)
	public void alterar(@PathVariable("cpf") String cpf, @RequestBody PessoaDTO pessoaDto) {
		PessoaDTO dto = pessoaDto;	
		pB.alteraPessoa(dto, cpf);
	}

}
