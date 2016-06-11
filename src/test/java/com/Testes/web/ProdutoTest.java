package com.Testes.web;

import static org.junit.Assert.*;

import org.junit.Test;

import com.classeBasica.web.Produto;
import com.classeDado.web.FactoryDAO;
import com.classeDado.web.ProdutoDAO;
import com.classeNegocio.web.ProdutoNegocio;

public class ProdutoTest {

	ProdutoNegocio pn = new ProdutoNegocio();
	Produto pr = new Produto();
	ProdutoDAO pd = FactoryDAO.getProdutoDAO();

	@Test
	public void testProdutoTrue() {
		boolean result = pn.validarProduto(1);
		assertEquals(true, result);
	}

	@Test
	public void testProdutoTrue2() {
		boolean result = pn.validarProduto(2);
		assertEquals(true, result);
	}

	@Test
	public void testProdutoTrue3() {
		boolean result = pn.validarProduto(3);
		assertEquals(true, result);
	}

	@Test
	public void testProdutoFalse() {
		boolean result = pn.validarProduto(4);
		assertEquals(false, result);
	}

	@Test
	public void testListaProduto() {
		pr = pd.buscarPorChave(1);
		assertEquals("GTX980Ti", pr.getNome());
	}

	@Test
	public void testListaProduto2() {
		pr = pd.buscarPorChave(2);
		assertEquals("GTX980Ti", pr.getNome());
	}

	@Test
	public void testListaProduto3() {
		pr = pd.buscarPorChave(3);
		assertEquals("GTX980Ti", pr.getNome());
	}

}
