package com.classeNegocio.web;

import com.classeBasica.web.Proprietario;
import com.classeDado.web.FactoryDAO;
import com.classeDado.web.ProprietarioDAO;
import com.interfaceNegocio.web.INegocioProprietario;



public class ProprietarioNegocio implements INegocioProprietario{
	ProprietarioDAO dp = FactoryDAO.getProprietarioDAO();
	public void cadastrar(Proprietario pr) throws Exception {
		if (pr == null) {
			throw new Exception("Não é possível cadastrar um objeto nulo");
		}
		if (pr.getNome() == null) {
			throw new Exception("Informe nome");
		}
		if (pr.getNome().trim().equals("") == true) {
			throw new Exception("Informe nome");
		}
		if (pr.getCnpj() == null) {
			throw new Exception("Informe cpf");
		}
		if (pr.getCnpj().trim().equals("") == true) {
			throw new Exception("Informe cpf");
		}
		if (pr.getEmail() == null) {
			throw new Exception("Informe email");
		}
		if (pr.getEmail().trim().equals("") == true) {
			throw new Exception("Informe Email");
		}
		if (pr.getEmail() == null) {
			throw new Exception("Informe email");
		}
		if (pr.getEmail().trim().equals("") == true) {
			throw new Exception("Informe Email");
		}
		if (pr.getLogin() == null) {
			throw new Exception("Informe login");
		}
		if (pr.getLogin().trim().equals("") == true) {
			throw new Exception("Informe login");
		}
		if (pr.getSenha() == null) {
			throw new Exception("Informe senha");
		}
		if (pr.getSenha().trim().equals("") == true) {
			throw new Exception("Informe senha");
		}
		if (pr.getRazaoSocial() == null) {
			throw new Exception("Informe senha");
		}
		if (pr.getRazaoSocial().trim().equals("") == true) {
			throw new Exception("Informe senha");
		}

		dp.inserir(pr);			
	}

	public boolean validarLoginAdmin (String login,String senha) {
		Proprietario p = null;

		p = dp.consultarPorNomeAdmin(login);

		if (p != null && p.getLogin().equals(login) && p.getSenha().equals(senha)){
			return true;
		}else{
			return false;
		}
	}



}
