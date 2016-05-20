package com.controller.web;

import javax.faces.bean.ManagedBean;






import com.classeBasica.web.Cliente;

import com.fachada.web.FachadaLogin;

@ManagedBean
public class Controller {
	
	private boolean session;
    private Cliente usuarioLogado;
    private Cliente cliente = new Cliente();
   
	public boolean isSession() {
		return session;
	}
	public void setSession(boolean session) {
		this.session = session;
	}
	public Cliente getUsuarioLogado() {
		return usuarioLogado;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	//METODOS
	public String efetuarLogin(){
		FachadaLogin fl = new FachadaLogin();
		
		fl.iniciarFachada();
		boolean valida = fl.validar(cliente.getLogin(),cliente.getSenha());
		usuarioLogado = fl.consultarNome(cliente.getLogin());
		
		if(valida == true){
			session = true;
			return "index.xhtml?faces-redirect=true";
		}
		else{
			return "login.xhtml?faces-redirect=true";
		}
	}
	public String cancelar(){
		 return "index.xhtml?faces-redirect=true";
	}
	

	
}
