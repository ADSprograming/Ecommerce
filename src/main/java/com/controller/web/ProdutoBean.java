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
	Produto produto = new Produto();
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
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

		ProdutoNegocio pn = new ProdutoNegocio();
		try {
			pn.cadastrar(produto);
		}catch(Exception x){

		}
		return "painel.xhtml?redirect=true";
	}	

	public String setProdutoAlterar(){

		ProdutoNegocio pn = new ProdutoNegocio();
		try {
			pn.alterar(produto);

		}catch(Exception x){

		}
		return "painel.xhtml?redirect=true";
	}

	public String setProdutoRemover(){

		ProdutoNegocio pn = new ProdutoNegocio();
		try {	
			pn.remover(produto);
		} catch (Exception x) {

		}		
		return "painel.xhtml?faces-redirect=true";
	}

/*
	public void buscarproduto() {
		try {
			ProdutoNegocio pn = new ProdutoNegocio();
			pn.ResultadoProduto(produto);
		} catch (Exception x) {

		}
	}*/



}
