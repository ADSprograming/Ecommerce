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


	public Produto buscarProduto() {

		try {
			fp.iniciarFachada();
			produto = fp.buscarPorChave(produto.getIdProduto());
		} catch (Exception x) {

		}
		return produto;

	}

	public void alterar(){
		try {
			fp.alterar(produto);
		} catch (Exception x) {

		}
	}


	public void remover() {

		try {
			fp.iniciarFachada();
			fp.remover(produto.getIdProduto());
		} catch (Exception x) {

		}

	}



}
