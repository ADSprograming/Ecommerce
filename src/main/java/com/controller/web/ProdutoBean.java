
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

	private double adicionarPreco;
	private String adicionarNome,adicionarDescricao,adicionarMarca,adicionarImagem;

	private int alterarIdProduto;
	private double alterarPreco;
	private String alterarNome,alterarDescricao,alterarMarca,alterarImagem;

	private int removerIdProduto;


	public double getAdicionarPreco() {
		return adicionarPreco;
	}
	public void setAdicionarPreco(double adicionarPreco) {
		this.adicionarPreco = adicionarPreco;
	}
	public String getAdicionarNome() {
		return adicionarNome;
	}
	public void setAdicionarNome(String adicionarNome) {
		this.adicionarNome = adicionarNome;
	}
	public String getAdicionarDescricao() {
		return adicionarDescricao;
	}
	public void setAdicionarDescricao(String adicionarDescricao) {
		this.adicionarDescricao = adicionarDescricao;
	}
	public String getAdicionarMarca() {
		return adicionarMarca;
	}
	public void setAdicionarMarca(String adicionarMarca) {
		this.adicionarMarca = adicionarMarca;
	}
	public String getAdicionarImagem() {
		return adicionarImagem;
	}
	public void setAdicionarImagem(String adicionarImagem) {
		this.adicionarImagem = adicionarImagem;
	}


	public int getAlterarIdProduto() {
		return alterarIdProduto;
	}
	public void setAlterarIdProduto(int alterarIdProduto) {
		this.alterarIdProduto = alterarIdProduto;
	}
	public double getAlterarPreco() {
		return alterarPreco;
	}
	public void setAlterarPreco(double alterarPreco) {
		this.alterarPreco = alterarPreco;
	}
	public String getAlterarNome() {
		return alterarNome;
	}
	public void setAlterarNome(String alterarNome) {
		this.alterarNome = alterarNome;
	}
	public String getAlterarDescricao() {
		return alterarDescricao;
	}
	public void setAlterarDescricao(String alterarDescricao) {
		this.alterarDescricao = alterarDescricao;
	}
	public String getAlterarMarca() {
		return alterarMarca;
	}
	public void setAlterarMarca(String alterarMarca) {
		this.alterarMarca = alterarMarca;
	}
	public String getAlterarImagem() {
		return alterarImagem;
	}
	public void setAlterarImagem(String alterarImagem) {
		this.alterarImagem = alterarImagem;
	}


	public int getRemoverIdProduto() {
		return removerIdProduto;
	}
	public void setRemoverIdProduto(int removerIdProduto) {
		this.removerIdProduto = removerIdProduto;
	}


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
			setAlterarIdProduto(produto.getIdProduto());
			setAlterarMarca(produto.getMarca());
			setAlterarPreco(produto.getPreco());
			setAlterarDescricao(produto.getDescricao());
			setAlterarImagem(produto.getImagem());
		} catch (Exception x) {

		}
		return produto;

	}

	public void cadastrar(){
		try {
			fp.iniciarFachada();
			produto.setNome(getAdicionarNome());
			produto.setMarca(getAdicionarMarca());
			produto.setPreco(getAdicionarPreco());
			produto.setDescricao(getAdicionarDescricao());
			produto.setImagem(getAdicionarImagem());			
			fp.cadastrar(produto);
		} catch (Exception x) {

		}
	}


	public void alterar(){
		try {
			fp.iniciarFachada();
			produto.setIdProduto(getAlterarIdProduto());
			produto.setMarca(getAlterarMarca());
			produto.setPreco(getAlterarPreco());
			produto.setDescricao(getAlterarDescricao());
			produto.setImagem(getAlterarImagem());
			fp.alterar(produto);
		} catch (Exception x) {

		}
	}


	public void remover() {

		try {
			fp.iniciarFachada();
			produto.setIdProduto(getRemoverIdProduto());
			fp.remover(produto.getIdProduto());
		} catch (Exception x) {

		}

	}



}
/*package com.controller.web;


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

	public void cadastrar(){
		try {
			fp.iniciarFachada();		
			fp.cadastrar(produto);
		} catch (Exception x) {

		}
	}

	public void alterar(){
		try {
			fp.iniciarFachada();	
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
*/