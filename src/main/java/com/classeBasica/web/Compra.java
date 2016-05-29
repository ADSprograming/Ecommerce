package com.classeBasica.web;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Compra extends Venda{
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int idCompra;
	private String precoTotal;
	private int desconto;
	@ManyToMany
	@JoinTable(name = "compra_produto", joinColumns = { @JoinColumn(name = "idCompra") }, inverseJoinColumns = { @JoinColumn(name = "idProduto") })
	private Set<Produto> produtos;
	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "compra", optional = true)
	private Boleto boleto;
	public Boleto getBoleto() {
		return boleto;
	}
	public void setBoleto(Boleto boleto) {
		this.boleto = boleto;
	}

	public int getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
	public String getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(String precoTotal) {
		this.precoTotal = precoTotal;
	}
	public int getDesconto() {
		return desconto;
	}
	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}
	public Set<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
