package com.fachada.web;

import com.classeBasica.web.Cliente;
import com.classeBasica.web.Proprietario;
import com.classeDado.web.ClienteDAO;
import com.classeDado.web.FactoryDAO;
import com.classeDado.web.ProprietarioDAO;
import com.classeNegocio.web.ClienteNegocio;
import com.classeNegocio.web.ProprietarioNegocio;

public class FachadaLogin {

	protected ClienteDAO cd;
	protected Cliente cliente;
	protected ClienteNegocio cn;

	protected Proprietario proprietario;
	protected ProprietarioDAO pd;
	protected ProprietarioNegocio pn;

	public void FachadaCliente(){
		cd =  FactoryDAO.getClienteDAO();
		cliente = new Cliente();
		cn = new ClienteNegocio();
	}

	public void FachadaProprietario(){
		pd =  FactoryDAO.getProprietarioDAO();
		proprietario = new Proprietario();
		pn = new ProprietarioNegocio();
	}


	public boolean validar(String login, String senha){
		return cn.validarLogin(login,senha);
	}

	public boolean validarLoginAdmin(String login, String senha){
		return pn.validarLoginAdmin(login,senha);
	}	

	public Cliente consultarNome(String nome){
		return cd.consultarPorLogin(nome);
	}

	public Proprietario consultarNomeAdmin(String nome){
		return pd.consultarPorNomeAdmin(nome);
	}
}
