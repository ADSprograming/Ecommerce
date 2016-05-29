package com.classeNegocio.web;

import com.classeBasica.web.Cliente;
import com.classeDado.web.ClienteDAO;
import com.classeDado.web.FactoryDAO;

import com.interfaceNegocio.web.INegocioCliente;




public class ClienteNegocio implements INegocioCliente{
	ClienteDAO df = FactoryDAO.getClienteDAO();


	public void cadastrar(Cliente cl) throws Exception {
		if (cl == null) {
			throw new Exception("Não é possível cadastrar um objeto nulo");
		}
		if (cl.getNome() == null) {
			throw new Exception("Informe nome");
		}
		if (cl.getNome().trim().equals("") == true) {
			throw new Exception("Informe nome");
		}
		if (cl.getCpf() == null) {
			throw new Exception("Informe cpf");
		}
		if (cl.getCpf().trim().equals("") == true) {
			throw new Exception("Informe cpf");
		}
		if (cl.getEmail() == null) {
			throw new Exception("Informe email");
		}
		if (cl.getEmail().trim().equals("") == true) {
			throw new Exception("Informe Email");
		}
		if (cl.getEmail() == null) {
			throw new Exception("Informe email");
		}
		if (cl.getEmail().trim().equals("") == true) {
			throw new Exception("Informe Email");
		}
		if (cl.getLogin() == null) {
			throw new Exception("Informe login");
		}
		if (cl.getLogin().trim().equals("") == true) {
			throw new Exception("Informe login");
		}
		if (cl.getSenha() == null) {
			throw new Exception("Informe senha");
		}
		if (cl.getSenha().trim().equals("") == true) {
			throw new Exception("Informe senha");
		}

		df.inserir(cl);		
	}

	public boolean validarLogin (String login,String senha) {
		Cliente c = null;

		c = df.consultarPorNome(login);

		if (c != null && c.getLogin().equals(login) && c.getSenha().equals(senha)){
			return true;
		}else{
			return false;
		}
	}

}
