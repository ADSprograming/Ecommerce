package com.controller.web;

import javax.faces.bean.ManagedBean;





import com.classeBasica.web.Cliente;
import com.classeBasica.web.Endereco;
import com.classeDado.web.EnderecoDAO;
import com.classeDado.web.FactoryDAO;
import com.classeDado.web.ClienteDAO;

import com.classeNegocio.web.ClienteNegocio;

@ManagedBean
public class Controller {
	
	private boolean session;
    private Cliente usuarioLogado;
    private int endereco;
    Cliente cliente =new Cliente();
   
	public int getEndereco() {
		return endereco;
	}
	public void setEndereco(int endereco) {
		this.endereco = endereco;
	}
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	//METODOS
	public String efetuarLogin(){
		
		ClienteDAO cd =  FactoryDAO.getClienteDAO();
		ClienteNegocio cn = new ClienteNegocio();
		boolean valida = cn.validarLogin(cliente.getLogin(),cliente.getSenha());
		usuarioLogado = cd.consultarPorNome(cliente.getLogin());
		
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
