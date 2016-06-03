package com.fachada.web;

import com.classeBasica.web.Produto;
import com.classeDado.web.FactoryDAO;
import com.classeDado.web.ProdutoDAO;
import com.classeNegocio.web.ProdutoNegocio;

public class FachadaProduto {
	
	protected Produto produto = new Produto();
	protected ProdutoNegocio pn;
	protected ProdutoDAO pd;
	public void iniciarFachada(){
		produto = new Produto();
		pn = new ProdutoNegocio();
		pd = FactoryDAO.getProdutoDAO();
	}
	
	public void setProduto(Produto produto){
		try {
			pn.cadastrar(produto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Produto buscarPorChave(int id){
		return pd.buscarPorChave(id);
	}
	
	public void cadastrar(Produto produto){
		pd.inserir(produto);
	}
	
	public void alterar(Produto produto){
		pd.alterar(produto);
	}
	
	public void remover(int id){
		pd.remover(pd.buscarPorChave(id));
	}
}
