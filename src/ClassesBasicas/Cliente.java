package ClassesBasicas;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Pessoa{
private int idCliente;	
private String cpf;

@OneToOne
private Endereco endereco;
@OneToMany(mappedBy = "cliente", targetEntity = Compra.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private Set<Compra> compras;
@OneToMany(mappedBy = "cliente", targetEntity = Compra.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private Set<Boleto> boletos;
public Set<Boleto> getBoletos() {
	return boletos;
}
public void setBoletos(Set<Boleto> boletos) {
	this.boletos = boletos;
}
public String getCpf() {
	return cpf;
}
public void setCpf(String cpf) {
	this.cpf = cpf;
}
public Endereco getEndereco() {
	return endereco;
}
public void setEndereco(Endereco endereco) {
	this.endereco = endereco;
}
public int getIdCliente() {
	return idCliente;
}
public void setIdCliente(int idCliente) {
	this.idCliente = idCliente;
}
public Set<Compra> getCompras() {
	return compras;
}
public void setCompras(Set<Compra> compras) {
	this.compras = compras;
}
}
