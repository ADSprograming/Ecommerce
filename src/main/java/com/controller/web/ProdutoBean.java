package com.controller.web;




import java.util.List;


import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.classeBasica.web.Produto;
import com.fachada.web.FachadaProduto;
import com.classeNegocio.web.ProdutoNegocio;


@ManagedBean(name="produtoBean", eager = true)
@ViewScoped
public class ProdutoBean   {
	private int idProduto;
	private String nome,descricao,marca,imagem;
	private double preco;
	Produto produto = new Produto();
	ProdutoNegocio pn = new ProdutoNegocio();
	FachadaProduto fp = new FachadaProduto();
	
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

		try {
			pn.cadastrar(produto);
		}catch(Exception x){

		}
		return "painel.xhtml?redirect=true";
	}	

	public String setProdutoAlterar(){

		try {
			pn.alterar(produto);

		}catch(Exception x){

		}
		return "painel.xhtml?redirect=true";
	}

	public String setProdutoRemover(){

		try {	
			pn.remover(produto);
		} catch (Exception x) {

		}		
		return "painel.xhtml?faces-redirect=true";
	}

	public Produto buscarProduto(int id) {

		try {
			fp.iniciarFachada();
			 produto = fp.buscarPorChave(id);
		} catch (Exception x) {

		}
		return produto;

	}

}
