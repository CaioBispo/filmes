package br.com.cast.castapi.DTO;

public class EnderecoDTO {

	
	private String cep;
	private String logradouro;
	private Integer numero;
	private String complemento;
	private String bairro;
	private String cidade;
	
	
	
	
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	private String uf;

	@Override
	public String toString() {
		return "\nEndereco ["
				+ "cep=" + cep + ","
				+ "\nLogradouro=" + logradouro + ", "
				+ "\nNumero=" + numero + ", "
				+ "\nComplemento=" + complemento + ", "
				+ "\nBairro=" + bairro + ", "
				+ "\nCidade=" + cidade + ", "
				+ "\nUf=" + uf + "]";
	}
	
	
	
}



