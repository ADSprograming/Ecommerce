package com.fachada.web;


import java.util.ArrayList;
import java.util.List;

import com.classeBasica.web.Carrinho;
import com.classeBasica.web.Produto;
import com.classeDado.web.CarrinhoDAO;
import com.classeDado.web.FactoryDAO;
import com.classeDado.web.ProdutoDAO;
import com.classeNegocio.web.CarrinhoNegocio;

public class FachadaCarrinho {
	Carrinho carrinho;
    ProdutoDAO pd;
    CarrinhoDAO cd;
    CarrinhoNegocio cn;
    Produto produto;
    
    public void iniciarFachada(){
    	carrinho = new Carrinho();
    	pd = FactoryDAO.getProdutoDAO();
    	cd = FactoryDAO.getCarrinhoDAO();
    	cn = new CarrinhoNegocio();
    	produto = new Produto();
    }
    
    public void setCarrinho(int id){
    	produto = pd.buscarPorChave(id);
		carrinho.setDescricao(produto.getDescricao());
		carrinho.setMarca(produto.getMarca());
		carrinho.setNome(produto.getNome());
		carrinho.setPreco(produto.getPreco());
		carrinho.setQtd(1);
		carrinho.setIpro(produto.getIdProduto());
		cd.inserir(carrinho);
    }
    
    public void remover(int id){
    	cd.remover(cd.buscarPorChave(id));
    }
    
    public List<Carrinho> buscarTodos(){
    	return cn.todos();
    	
    }
    
    public void removerTudo(){
    	List<Carrinho> listaProduto = cn.todos();
    	 for(Carrinho car : listaProduto){
    		 cd.remover(car);
    	 }
    	
    }
    
    
}
