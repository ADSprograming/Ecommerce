package ClassesBasicas;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Endereco {
	@Id
	private int id;	
	private int cep,numero;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "endereco", optional = true)
	Cliente cliente;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	String logradouro,bairro,cidade;
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
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
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
}
