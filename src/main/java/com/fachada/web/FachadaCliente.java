package com.fachada.web;

import com.classeBasica.web.Cliente;
import com.classeBasica.web.Endereco;
import com.classeDado.web.EnderecoDAO;
import com.classeDado.web.FactoryDAO;
import com.classeNegocio.web.ClienteNegocio;

public class FachadaCliente {
	Cliente cliente;
	ClienteNegocio clienteNegocio;
	EnderecoDAO enderecoDAO;
	public void iniciarFachada(){
		 cliente = new Cliente();
		 clienteNegocio = new ClienteNegocio();
	     enderecoDAO = FactoryDAO.getEnderecoDAO();
	}
	
	public void setEndereco(Endereco endereco){
		enderecoDAO.inserir(endereco);
	}
	
	public void setCliente(Cliente cliente){
		try {
			
			clienteNegocio.cadastrar(cliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
