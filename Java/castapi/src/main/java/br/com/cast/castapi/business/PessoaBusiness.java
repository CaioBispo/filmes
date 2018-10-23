package br.com.cast.castapi.business;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.xml.ws.ServiceMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.castapi.DAO.PessoaDAO;
import br.com.cast.castapi.DTO.EnderecoDTO;
import br.com.cast.castapi.DTO.PessoaDTO;
import br.com.cast.castapi.entidade.Endereco;
import br.com.cast.castapi.entidade.Pessoa;

@Service
public class PessoaBusiness {

	@Autowired
	private PessoaDAO pDao;
	
	public PessoaBusiness() {
		pDao = new PessoaDAO();
	}
	
	public PessoaDTO convertToDTO(Pessoa pessoa) {
		PessoaDTO pDto = new PessoaDTO();
		EnderecoDTO eDto = new EnderecoDTO();
		
		eDto.setCep(pessoa.getEndereco().getCep());
		eDto.setBairro(pessoa.getEndereco().getBairro());
		eDto.setCidade(pessoa.getEndereco().getCidade());
		eDto.setComplemento(pessoa.getEndereco().getComplemento());
		eDto.setLogradouro(pessoa.getEndereco().getLogradouro());
		eDto.setNumero(pessoa.getEndereco().getNumero());
		eDto.setUf(pessoa.getEndereco().getUf());

		pDto.setCpf(pessoa.getCpf());
		pDto.setEmail(pessoa.getEmail());
		pDto.setNome(pessoa.getNome());
		pDto.setEndereco(eDto);

		return pDto;
	}
	
	public Pessoa convertToEntity(PessoaDTO pessoaDTO) {
		Pessoa p = new Pessoa();
		Endereco e = new Endereco();
		
		e.setCep(pessoaDTO.getEndereco().getCep());
		e.setBairro(pessoaDTO.getEndereco().getBairro());
		e.setCidade(pessoaDTO.getEndereco().getCidade());
		e.setComplemento(pessoaDTO.getEndereco().getComplemento());
		e.setLogradouro(pessoaDTO.getEndereco().getLogradouro());
		e.setNumero(pessoaDTO.getEndereco().getNumero());
		e.setUf(pessoaDTO.getEndereco().getUf());

		p.setCpf(pessoaDTO.getCpf());
		p.setEmail(pessoaDTO.getEmail());
		p.setNome(pessoaDTO.getNome());
		p.setEndereco(e);

		return p;
	}
		
	
	public List<PessoaDTO> buscaTodos() {
		List<Pessoa> pessoas = new ArrayList<>();
		List<PessoaDTO> pessoasDTO = new ArrayList<>();
		
		pessoas = pDao.buscarTodos();
		
		for (Pessoa p : pessoas) {
			PessoaDTO pDTO = new PessoaDTO();
			pDTO = convertToDTO(p);
			pessoasDTO.add(pDTO);
		}
		return pessoasDTO;
	}
	
	public PessoaDTO buscaPorId(String cpf) {
		
		PessoaDTO dto = new PessoaDTO();
		
		dto = convertToDTO(pDao.buscarPorId(cpf));
		
		return dto;
	}
	
	@Transactional
	public void addPessoas(PessoaDTO dto) {
		Pessoa p = new Pessoa();
		p = convertToEntity(dto);
		pDao.addPessoas(p);
	}
	
	@Transactional
	public void excluir(String cpf) {
		Pessoa p = new Pessoa();		
		p = pDao.buscarPorId(cpf);
		pDao.excluir(p);
	}
	
	@Transactional
	public void alteraPessoa(PessoaDTO dto, String cpf) {
		
		Pessoa pessoa = pDao.buscarPorId(cpf);
		
		pessoa.setNome(dto.getNome());
		pessoa.setEmail(dto.getEmail());
		
		Endereco endereco = pessoa.getEndereco();
		endereco.setBairro(dto.getEndereco().getBairro());
		endereco.setCidade(dto.getEndereco().getCidade());
		endereco.setComplemento(dto.getEndereco().getComplemento());
		endereco.setLogradouro(dto.getEndereco().getLogradouro());
		endereco.setNumero(dto.getEndereco().getNumero());
		endereco.setUf(dto.getEndereco().getUf());
		
		pDao.alteraPessoa(pessoa);
	}
	
}
