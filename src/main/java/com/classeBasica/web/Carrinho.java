package com.classeBasica.web;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Carrinho {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int idCarrinho;
	private double preco;
	private String nome,descricao,marca;
	private int qtd;
	private int ipro;
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public int getIdCarrinho() {
		return idCarrinho;
	}
	public void setIdCarrinho(int idCarrinho) {
		this.idCarrinho = idCarrinho;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getIpro() {
		return ipro;
	}
	public void setIpro(int ipro) {
		this.ipro = ipro;
	}


}
