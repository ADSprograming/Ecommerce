package com.controller.web;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



import com.classeBasica.web.Cliente;
import com.classeBasica.web.Endereco;
import com.classeDado.web.EnderecoDAO;
import com.classeDado.web.FactoryDAO;
import com.classeNegocio.web.ClienteNegocio;
import com.fachada.web.FachadaCliente;
@ManagedBean
public class ClienteBean {
	private String senha,re_senha;
	JSONObject jsonObject;
	JSONParser parser = new JSONParser();	
	private Endereco endereco = new Endereco();  
	private Cliente cliente = new Cliente();
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getRe_senha() {
		return re_senha;
	}
	public void setRe_senha(String re_senha) {
		this.re_senha = re_senha;
	}
	
	public void encontra() {
		 CepWebService cepWebService = new CepWebService(Integer.toString(endereco.getCep()));
		 
	        if (cepWebService.getResultado() == 1) {
	            endereco.setLogradouro(cepWebService.getLogradouro());
	            endereco.setEstado(cepWebService.getEstado());
	            endereco.setCidade(cepWebService.getCidade());
	            endereco.setBairro(cepWebService.getBairro());
	          
	        } else {
	 
	            FacesContext.getCurrentInstance().addMessage(
	                    null,
	                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
	                            "Servidor n�o est� respondendo",
	                            "Servidor n�o est� respondendo"));
	        }
	}
	
	public String setCliente(){
		
		FachadaCliente fc = new FachadaCliente();
		fc.iniciarFachada();
		fc.setEndereco(endereco);
		try {
			if(cliente.getSenha().equals(re_senha)) {
				cliente.setEndereco(endereco);
				fc.setCliente(cliente);
			}
		}catch(Exception x){
			
		}
		return "index.xhtml?redirect=true";
	}
}
