package com.classeBasica.web;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;


@Entity

public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int idCliente;
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	private String nome,email,login,senha;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

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

	public Set<Compra> getCompras() {
		return compras;
	}
	public void setCompras(Set<Compra> compras) {
		this.compras = compras;
	}

}
