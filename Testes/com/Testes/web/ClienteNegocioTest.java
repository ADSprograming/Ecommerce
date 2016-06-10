package com.Testes.web;

import static org.junit.Assert.*;

import org.junit.Test;

import com.classeNegocio.web.ClienteNegocio;

public class ClienteNegocioTest {

	@Test
	public void test() {
		ClienteNegocio cn = new ClienteNegocio();
		boolean result = cn.validarLogin("miojo", "miojo");
		assertEquals(true,result);
	}

}
