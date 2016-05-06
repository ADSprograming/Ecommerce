package com.controller.web;

import javax.faces.bean.ManagedBean;





import com.classeBasica.web.Cliente;
import com.classeBasica.web.Endereco;
import com.classeBasica.web.Proprietario;
import com.classeDado.web.EnderecoDAO;
import com.classeDado.web.FactoryDAO;
import com.classeDado.web.ProprietarioDAO;
import com.classeDado.web.ClienteDAO;

import com.classeNegocio.web.ClienteNegocio;

@ManagedBean
public class Controller {
	
	private boolean session;
    private Cliente usuarioLogado;
    private int endereco;
    public int getEndereco() {
		return endereco;
	}
	public void setEndereco(int endereco) {
		this.endereco = endereco;
	}
	Cliente cliente =new Cliente();
	

	
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
	public void setCliente(){
		
		Endereco e = new Endereco();
		ClienteDAO d = FactoryDAO.getClienteDAO();
		EnderecoDAO ed = FactoryDAO.getEnderecoDAO();
		e = ed.buscarPorChave(endereco);
		cliente.setEndereco(e);
		d.inserir(cliente);
	}

	
}
