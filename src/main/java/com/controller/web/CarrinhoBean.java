package com.controller.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classeBasica.web.Carrinho;
import com.classeBasica.web.Cliente;
import com.classeBasica.web.Produto;
import com.classeDado.web.CarrinhoDAO;
import com.classeDado.web.FactoryDAO;
import com.classeDado.web.ProdutoDAO;
import com.classeNegocio.web.CarrinhoNegocio;
import com.fachada.web.FachadaCarrinho;

@ManagedBean
@SessionScoped
@ViewScoped
public class CarrinhoBean {
	  FachadaCarrinho fc = new FachadaCarrinho(); 
	 
	    HttpServletRequest request;
	    private List<Carrinho> carrinhos;
	    private double total,frete,subTotal;
	
	    LoginSingleton l = LoginSingleton.getInstance();

		@SuppressWarnings("restriction")
		@PostConstruct
	    public void init() {
	    	fc.iniciarFachada();
	        carrinhos = fc.buscarTodos();
	        for (Carrinho car: carrinhos){
				total += (car.getPreco() * car.getQtd());
				frete += 8;
				subTotal = frete + total;
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
		
		public double getSubTotal() {
			return subTotal;
		}
		
		public double getFrete() {
			return frete;
		}
		
		public void gerar(){
			fc.gerarBoleto();
		}
		
		public String removerTudo(){  
			
			if(l.isLog() == true){
				l.setTotal(total);
				l.setFrete(frete);
				l.setSubTotal(subTotal);
				fc.removerTudo();
				return "finalizar.xhtml?faces-redirect=true";
			}else{
				return "login.xhtml?faces-redirect=true";
			}
		}
		
		
}
