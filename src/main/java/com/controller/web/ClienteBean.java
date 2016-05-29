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
@ManagedBean
public class ClienteBean {
	private String nome,senha,re_senha,email,cpf,login;
	JSONObject jsonObject;
	JSONParser parser = new JSONParser();	
	private Endereco endereco = new Endereco();  
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
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
							"Servidor não está respondendo",
							"Servidor não está respondendo"));
		}
	}

	public String setCliente(){

		EnderecoDAO edao = FactoryDAO.getEnderecoDAO();
		edao.inserir(endereco);
		Cliente c = new Cliente();
		ClienteNegocio cn = new ClienteNegocio();
		try {
			if(senha.equals(re_senha)) {
				c.setLogin(login);
				c.setEmail(email);
				c.setNome(nome);
				c.setCpf(cpf);
				c.setSenha(senha);
				c.setEndereco(endereco);
				cn.cadastrar(c);
			}
		}catch(Exception x){

		}
		return "index.xhtml?redirect=true";
	}	
}
