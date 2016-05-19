package com.controller.web;



import java.util.List;










import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.classeBasica.web.Produto;
import com.classeDado.web.FactoryDAO;
import com.classeDado.web.ProdutoDAO;
import com.classeNegocio.web.ProdutoNegocio;

 
@ManagedBean
@ViewScoped
public class ProdutoBean  {
    
    private List<Produto> produtos;
   
	@ManagedProperty("#{produtoService}")
    private ProdutoNegocio service;
     
    @SuppressWarnings("restriction")
	@PostConstruct
    public void init() {
        produtos = service.todos();
    }
 
    public List<Produto> getProdutos() {
        return produtos;
    }
 
    public void setService(ProdutoNegocio service) {
        this.service = service;
    }
    
  
	
	
	
}
