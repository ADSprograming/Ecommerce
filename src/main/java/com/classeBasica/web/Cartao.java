package com.classeBasica.web;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cartao {
	@Id
	private int idCartao;
	private String operadora;
	public int getId() {
		return idCartao;
	}
	public void setId(int idCartao) {
		this.idCartao = idCartao;
	}
	public String getOperadora() {
		return operadora;
	}
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
}
