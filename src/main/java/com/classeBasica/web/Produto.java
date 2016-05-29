package com.classeBasica.web;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Produto {


	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int idProduto;
	private double preco;
	private String nome,descricao,marca,imagem;
	@ManyToMany(mappedBy="produtos")
	private Set<Compra> compras;

	public Produto(int idProduto, String nome, String marca, String imagem){
		this.idProduto = idProduto;
		this.nome = nome;
		this.marca = marca;
		this.imagem = imagem;
	}

	public Produto() {}

	public String toString() {
		return nome;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public Set<Compra> getCompras() {
		return compras;
	}
	public void setCompras(Set<Compra> compras) {
		this.compras = compras;
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

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}



}
