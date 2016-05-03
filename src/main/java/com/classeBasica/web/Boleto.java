package com.classeBasica.web;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Boleto {
	@Id
	private int idBoleto;
	private String dataDoDocumento,DataDeVencimento;
	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	@OneToOne
	private Compra compra;
	public int getId() {
		return idBoleto;
	}
	public void setId(int idBoleto) {
		this.idBoleto = idBoleto;
	}
	public String getDataDoDocumento() {
		return dataDoDocumento;
	}
	public void setDataDoDocumento(String dataDoDocumento) {
		this.dataDoDocumento = dataDoDocumento;
	}
	public String getDataDeVencimento() {
		return DataDeVencimento;
	}
	public void setDataDeVencimento(String dataDeVencimento) {
		DataDeVencimento = dataDeVencimento;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
}
