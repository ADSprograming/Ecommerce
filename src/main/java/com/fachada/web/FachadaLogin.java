package com.fachada.web;

import com.classeBasica.web.Cliente;
import com.classeDado.web.ClienteDAO;
import com.classeDado.web.FactoryDAO;
import com.classeNegocio.web.ClienteNegocio;

public class FachadaLogin {
	
	protected ClienteDAO cd;
	protected Cliente cliente;
	protected ClienteNegocio cn;
	
	public void iniciarFachada(){
		 cd =  FactoryDAO.getClienteDAO();
		 cliente = new Cliente();
		 cn = new ClienteNegocio();
	}
	
	public boolean validar(String login, String senha){
		return cn.validarLogin(login,senha);
	}
	
	public Cliente consultarNome(String nome){
		return cd.consultarPorNome(nome);
	}
}
