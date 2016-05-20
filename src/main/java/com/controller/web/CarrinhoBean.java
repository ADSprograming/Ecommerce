package com.controller.web;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.classeBasica.web.Carrinho;

import com.fachada.web.FachadaCarrinho;

@ManagedBean
@ViewScoped
public class CarrinhoBean {
	  
	    FachadaCarrinho fc = new FachadaCarrinho(); 
	    private List<Carrinho> carrinhos;
	    private double total;
	    
	    @SuppressWarnings("restriction")
		@PostConstruct
	    public void init() {
	    	fc.iniciarFachada();
	        carrinhos = fc.buscarTodos();
	        for (Carrinho car: carrinhos){
				total += (car.getPreco() * car.getQtd());
			}
	    }
		
		public String popularCarrinho(int id){
			fc.setCarrinho(id);
			return "carrinho.xhtml?faces-redirect=true";
		}
		public List<Carrinho> getCarrinhos() {
			return carrinhos;
		}
		
		public String removerProduto(int id){
			fc.remover(id);
			return "carrinho.xhtml?face-redirect=true";
		}
		

		public double getTotal() {
			return total;
		}
		
}
