package com.controller.web;

import javax.faces.bean.ManagedBean;


import com.classeBasica.web.Cliente;
import com.classeBasica.web.Proprietario;
import com.classeDado.web.FactoryDAO;
import com.classeDado.web.ProprietarioDAO;
import com.classeDado.web.ClienteDAO;
import com.classeNegocio.web.ClienteNegocio;

@ManagedBean
public class Controller {
	String login;
	String senha;
	private boolean session;
	private Cliente usuarioLogado;
	public boolean isSession() {
		return session;
	}

	public void setSession(boolean session) {
		this.session = session;
	}

	public Cliente getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Cliente usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String efetuarLogin(){
		
		ClienteDAO cd =  FactoryDAO.getClienteDAO();
		ClienteNegocio cn = new ClienteNegocio();
		boolean valida = cn.validarLogin(login,senha);
		usuarioLogado = cd.consultarPorNome(login);
		if(valida == true){
			session = true;
			return "index.xhtml?faces-redirect=true";
		}
		else{
			return "login.xhtml?faces-redirect=true";
		}
	}

	

	
}
