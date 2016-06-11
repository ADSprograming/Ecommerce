package com.Testes.web;

import static org.junit.Assert.*;

import org.junit.Test;

import com.classeBasica.web.Cliente;
import com.classeDado.web.ClienteDAO;
import com.classeDado.web.FactoryDAO;
import com.classeNegocio.web.ClienteNegocio;

public class ClienteNegocioTest {
	ClienteNegocio cn = new ClienteNegocio();
	@Test
	public void testClienteNegocioLoginTrue() {
		boolean result = cn.validarLogin("miojo", "miojo");
		assertEquals(true,result);
	}
	@Test
	public void testClienteNegocioLoginFalse() {
		boolean result = cn.validarLogin("mioj", "miojo");
		assertEquals(false,result);
	}
	@Test
	public void testClienteNegocioLoginFalse2() {
		boolean result = cn.validarLogin("miojo", "mioj");
		assertEquals(false,result);
	}
	@Test
	public void testClienteNegocioLoginTrue2() {
		boolean result = cn.validarLogin("sandman", "sandman");
		assertEquals(true,result);
	}
	@Test
	public void testClienteNegocioLoginFalse3() {
		boolean result = cn.validarLogin("sandma", "sandman");
		assertEquals(false,result);
	}
	@Test
	public void testClienteNegocioLoginFalse4() {
		boolean result = cn.validarLogin("sandman", "sandma");
		assertEquals(false,result);
	}
	Cliente cl = new Cliente();
	ClienteDAO cd = FactoryDAO.getClienteDAO();
	@Test
	public void testClienteNegocioCadastroTrue() throws Exception {
		cl.setBoletos(null);
		cl.setCompras(null);
		cl.setCpf("5555555555123");
		cl.setEmail("jjj@jjj.com");
		cl.setEndereco(null);
		cl.setLogin("jjj");
		cl.setNome("jjj");
		cl.setSenha("jjj");
		cn.cadastrar(cl);
	}
	@Test
	public void testRemoverCliente() {
		cd.remover(cl);    
	}
}
