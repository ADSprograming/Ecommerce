package com.Testes.web;

import static org.junit.Assert.*;

import org.junit.Test;

import com.classeBasica.web.Cliente;
import com.classeBasica.web.Endereco;
import com.classeDado.web.ClienteDAO;
import com.classeDado.web.EnderecoDAO;
import com.classeDado.web.FactoryDAO;
import com.classeNegocio.web.ClienteNegocio;

public class ClienteTest {
	Cliente cl = new Cliente();
	Endereco e = new Endereco();
	ClienteDAO cd = FactoryDAO.getClienteDAO();
	ClienteNegocio cn = new ClienteNegocio();
	EnderecoDAO ed = FactoryDAO.getEnderecoDAO();

	@Test
	public void testCadastroComSucesso() throws Exception {
		e = ed.buscarPorChave(1);
		cl.setCpf("55555555598");
		cl.setEmail("castanha@castanha.com");
		cl.setEndereco(e);
		cl.setLogin("castanha");
		cl.setNome("castanha");
		cl.setSenha("castanha");
		cn.cadastrar(cl);
		cl = cd.consultarPorLogin("castanha");
		assertEquals("castanha", cl.getLogin());
	}

	@Test
	public void testClienteNegocioLoginTrue() {
		boolean result = cn.validarLogin("miojo", "miojo");
		assertEquals(true, result);
	}

	@Test
	public void testClienteNegocioLoginFalse() {
		boolean result = cn.validarLogin("mioj", "miojo");
		assertEquals(false, result);
	}

	@Test
	public void testClienteNegocioLoginFalse2() {
		boolean result = cn.validarLogin("miojo", "mioj");
		assertEquals(false, result);
	}

	@Test
	public void testClienteNegocioLoginTrue2() {
		boolean result = cn.validarLogin("sandman", "sandman");
		assertEquals(true, result);
	}

	@Test
	public void testClienteNegocioLoginFalse3() {
		boolean result = cn.validarLogin("sandma", "sandman");
		assertEquals(false, result);
	}

	@Test
	public void testClienteNegocioLoginFalse4() {
		boolean result = cn.validarLogin("sandman", "sandma");
		assertEquals(false, result);
	}

	@Test
	public void testListaCliente() {
		cl = cd.consultarPorLogin("miojo");
		assertEquals("miojo", cl.getLogin());
	}
}
