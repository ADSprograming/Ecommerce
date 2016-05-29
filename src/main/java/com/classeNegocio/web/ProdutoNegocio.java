package com.classeNegocio.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.classeBasica.web.Cliente;
import com.classeBasica.web.Produto;
import com.classeDado.web.FactoryDAO;
import com.classeDado.web.ProdutoDAO;
import com.interfaceNegocio.web.INegocioProduto;



@ManagedBean(name = "produtoService")
@ApplicationScoped
public class ProdutoNegocio implements INegocioProduto{

	ProdutoDAO pd = FactoryDAO.getProdutoDAO();
	public void cadastrar(Produto p) throws Exception {
		if (p == null) {
			throw new Exception("Não é possível cadastrar um objeto nulo");
		}
		if (p.getNome() == null) {
			throw new Exception("Informe nome");
		}
		if (p.getNome().trim().equals("") == true) {
			throw new Exception("Informe nome");
		}
		if (p.getDescricao() == null) {
			throw new Exception("Informe descrição");
		}
		if (p.getDescricao().trim().equals("") == true) {
			throw new Exception("Informe descrição");
		}
		if (p.getMarca() == null) {
			throw new Exception("Informe marca");
		}
		if (p.getMarca().trim().equals("") == true) {
			throw new Exception("Informe marca");
		}
		if (p.getPreco() <= 0) {
			throw new Exception("Informe preço acima de zero");
		}

		pd.inserir(p);			
	}

	public void alterar(Produto p) throws Exception {
		if (p == null) {
			throw new Exception("Não é possível cadastrar um objeto nulo");
		}
		if (p.getNome() == null) {
			throw new Exception("Informe nome");
		}
		if (p.getNome().trim().equals("") == true) {
			throw new Exception("Informe nome");
		}
		if (p.getDescricao() == null) {
			throw new Exception("Informe descrição");
		}
		if (p.getDescricao().trim().equals("") == true) {
			throw new Exception("Informe descrição");
		}
		if (p.getMarca() == null) {
			throw new Exception("Informe marca");
		}
		if (p.getMarca().trim().equals("") == true) {
			throw new Exception("Informe marca");
		}
		if (p.getPreco() <= 0) {
			throw new Exception("Informe preço acima de zero");
		}

		pd.alterar(p);			
	}

	public void remover(Produto p) throws Exception {
		if (p == null) {
			throw new Exception("Não é possível remover um objeto nulo");
		}
		pd.remover(p);			
	}

	public List<Produto> todos(){
		List<Produto> produtos = new ArrayList<Produto>();
		produtos = pd.consultarProduto();
		return produtos;

	}

	public boolean validarProduto (int idProduto) {
		Produto p = null;

		p = pd.consultarProduto(idProduto);

		if (p != null && p.getIdProduto()==(idProduto)){
			return true;
		}else{
			return false;
		}
	}

	public void ResultadoProduto(int idProduto){
		pd.consultarProduto(idProduto);
	}	

}
