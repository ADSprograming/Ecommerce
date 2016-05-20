package com.fachada.web;

import com.classeBasica.web.Produto;
import com.classeDado.web.FactoryDAO;
import com.classeDado.web.ProdutoDAO;
import com.classeNegocio.web.ProdutoNegocio;

public class FachadaProduto {
	
	protected Produto produto;
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
	
	public void remover(int id){
		pd.remover(pd.buscarPorChave(id));
	}
}
