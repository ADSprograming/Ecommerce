package com.Testes.web;

import static org.junit.Assert.*;

import org.junit.Test;

import com.classeBasica.web.Cliente;

public class ClienteBasicaTest {
	Cliente c = new Cliente();
	@Test
	public void testEmail() {
		c.setEmail("marc@mar.com");
		assertEquals("marc@mar.com", c.getEmail());
	}
	@Test
	public void testNome() {
		c.setNome("marc");
		assertEquals("marc", c.getNome());
	}
	@Test
	public void testCPF() {
		c.setCpf("99988877765");
		assertEquals("99988877765", c.getCpf());
	}
	@Test
	public void testId() {
		c.setIdCliente(1);
		assertEquals(1, c.getIdCliente());
	}
	@Test
	public void testLogin() {
		c.setLogin("marc");
		assertEquals("marc", c.getLogin());
	}
	@Test
	public void testSenha() {
		c.setSenha("marc");
		assertEquals("marc", c.getSenha());
	}
}
