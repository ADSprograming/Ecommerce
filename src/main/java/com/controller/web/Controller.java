package com.controller.web;

import javax.faces.bean.ManagedBean;





import com.classeBasica.web.Cliente;
import com.classeBasica.web.Proprietario;
import com.classeDado.web.FactoryDAO;
import com.classeDado.web.ProprietarioDAO;
import com.classeDado.web.ClienteDAO;

import com.classeNegocio.web.ClienteNegocio;
import com.classeNegocio.web.ProprietarioNegocio;

@ManagedBean
public class Controller {

	private boolean session;
	private Cliente usuarioLogado;
	private Cliente cliente =new Cliente();
	private Proprietario usuarioAdminLogado;
	private Proprietario proprietario =new Proprietario();

	public boolean isSession() {
		return session;
	}
	public void setSession(boolean session) {
		this.session = session;
	}
	public Proprietario getUsuarioAdminLogado() {
		return usuarioAdminLogado;
	}
	public void setUsuarioAdminLogado(Proprietario usuarioAdminLogado) {
		this.usuarioAdminLogado = usuarioAdminLogado;
	}
	public Proprietario getProprietario() {
		return proprietario;
	}
	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
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

	public String efetuarLoginAdmin(){

		ProprietarioDAO pd =  FactoryDAO.getProprietarioDAO();
		ProprietarioNegocio pn = new ProprietarioNegocio();
		boolean validaAdmin = pn.validarLoginAdmin(proprietario.getLogin(),proprietario.getSenha());
		usuarioAdminLogado = pd.consultarPorNomeAdmin(proprietario.getLogin());

		if(validaAdmin == true){
			session = true;
			return "painel.xhtml?faces-redirect=true";
		}
		else{
			return "admin.xhtml?faces-redirect=true";
		}
	}

	public String cancelaradm(){
		return "painel.xhtml?faces-redirect=true";
	}

}
