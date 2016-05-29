package com.controller.web;




import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.classeBasica.web.Produto;
import com.classeNegocio.web.ProdutoNegocio;



@ManagedBean(name="produtoBean", eager = true)
@ViewScoped
public class ProdutoBean   {
	private int idProduto;
	private String nome,descricao,marca,imagem;
	private double preco;
	JSONObject jsonObject;
	JSONParser parser = new JSONParser();	
	Produto produto;


	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
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
	public void Produtos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	private List<Produto> produtos;

	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@ManagedProperty("#{produtoService}")
	private ProdutoNegocio service;

	@SuppressWarnings("restriction")
	@PostConstruct
	public void init() {
		produtos = service.todos();
	}

	public void setService(ProdutoNegocio service) {
		this.service = service;
	}

	public String setProdutoCadastar(){

		Produto p = new Produto();
		ProdutoNegocio pn = new ProdutoNegocio();
		FileUploadController up = new FileUploadController();
		try {
			p.setNome(nome);
			p.setDescricao(descricao);
			p.setPreco(preco);
			p.setMarca(marca);
			p.setImagem(imagem);
			pn.cadastrar(p);
		}catch(Exception x){

		}
		return "painel.xhtml?redirect=true";
	}	

	public String setProdutoAlterar(){

		Produto p = new Produto();
		ProdutoNegocio pn = new ProdutoNegocio();
		try {
			p.setNome(nome);
			p.setDescricao(descricao);
			p.setPreco(preco);
			p.setMarca(marca);
			p.setImagem(imagem);
			pn.alterar(p);

		}catch(Exception x){

		}
		return "painel.xhtml?redirect=true";
	}

	public String setProdutoRemover(){

		Produto p = new Produto();
		ProdutoNegocio pn = new ProdutoNegocio();
		try {
			p.setIdProduto(idProduto);
			pn.remover(p);
		} catch (Exception x) {

		}		
		return "painel.xhtml?faces-redirect=true";
	}


	public void buscarproduto() {
		try {
			ProdutoNegocio pn = new ProdutoNegocio();
			pn.ResultadoProduto(getIdProduto());
			setIdProduto(produto.getIdProduto());
			setNome(produto.getNome());
			setDescricao(produto.getDescricao());
			setPreco(produto.getPreco());
			setMarca(produto.getMarca());
			setImagem(produto.getImagem());
		} catch (Exception x) {

		}
	}



}
