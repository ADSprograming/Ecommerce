package com.controller.web;
import javax.faces.bean.ManagedBean;

import com.classeBasica.web.Cliente;
import com.classeDado.web.ClienteDAO;
import com.classeDado.web.FactoryDAO;
import com.classeNegocio.web.ClienteNegocio;

public class ClienteBean {
	String nome,senha,re_senha,email,cpf,login;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String setCliente(){
		Cliente c = new Cliente();
		ClienteNegocio cn = new ClienteNegocio();
		try {
			if(senha == re_senha) {
				c.setLogin(login);
				c.setEmail(email);
				c.setNome(nome);
				c.setCpf(cpf);
				c.setSenha(senha);
				cn.cadastrar(c);
			}
		}catch(Exception x){
			
		}
		return "index.xhtml?redirect=true";
	}	
}
