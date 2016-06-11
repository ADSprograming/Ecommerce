package com.Testes.web;

import static org.junit.Assert.*;

import org.junit.Test;

import com.classeBasica.web.Proprietario;
import com.classeDado.web.FactoryDAO;
import com.classeDado.web.ProprietarioDAO;
import com.classeNegocio.web.ProprietarioNegocio;

public class ProprietarioTest {

	ProprietarioNegocio pn = new ProprietarioNegocio();
	Proprietario pr = new Proprietario();
	ProprietarioDAO pd = FactoryDAO.getProprietarioDAO();

	@Test
	public void testProprietariLoginTrue() {
		boolean result = pn.validarLoginAdmin("avc", "avc");
		assertEquals(true, result);
	}

	@Test
	public void testProprietariLoginFalse() {
		boolean result = pn.validarLoginAdmin("av", "avc");
		assertEquals(false, result);
	}

	@Test
	public void testProprietariLoginFalse2() {
		boolean result = pn.validarLoginAdmin("av", "avc");
		assertEquals(false, result);
	}

	@Test
	public void testListaProprietario() {
		pr = pd.consultarPorNomeAdmin("avc");
		assertEquals("avc", pr.getLogin());
	}

}
