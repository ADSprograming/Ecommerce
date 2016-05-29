package com.controller.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.classeBasica.web.Carrinho;
import com.classeBasica.web.Produto;
import com.classeDado.web.CarrinhoDAO;
import com.classeDado.web.FactoryDAO;
import com.classeDado.web.ProdutoDAO;
import com.classeNegocio.web.CarrinhoNegocio;

@ManagedBean
@ViewScoped
public class CarrinhoBean {
	Carrinho carrinho = new Carrinho();
	ProdutoDAO pd = FactoryDAO.getProdutoDAO();
	CarrinhoDAO cd = FactoryDAO.getCarrinhoDAO();
	CarrinhoNegocio cn = new CarrinhoNegocio();
	Produto produto = new Produto();
	private List<Carrinho> carrinhos;
	private double total;
	@SuppressWarnings("restriction")
	@PostConstruct
	public void init() {
		carrinhos = cn.todos();
		for (Carrinho car: carrinhos){
			total += (car.getPreco() * car.getQtd());
		}
	}

	public String popularCarrinho(int id){
		//int id = Integer.parseInt((String)event.getComponent().getId()); 
		produto = pd.buscarPorChave(id);
		carrinho.setDescricao(produto.getDescricao());
		carrinho.setMarca(produto.getMarca());
		carrinho.setNome(produto.getNome());
		carrinho.setPreco(produto.getPreco());
		carrinho.setQtd(1);
		carrinho.setIpro(produto.getIdProduto());
		cd.inserir(carrinho);

		return "carrinho.xhtml?faces-redirect=true";
	}
	public List<Carrinho> getCarrinhos() {
		return carrinhos;
	}

	public String removerProduto(int id){
		cd.remover(cd.buscarPorChave(id));
		return "carrinho.xhtml?face-redirect=true";
	}


	public double getTotal() {
		return total;
	}

}
