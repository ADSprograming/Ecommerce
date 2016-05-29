package com.classeNegocio.web;

import java.util.ArrayList;
import java.util.List;

import com.classeBasica.web.Carrinho;

import com.classeDado.web.CarrinhoDAO;
import com.classeDado.web.FactoryDAO;

public class CarrinhoNegocio {
	CarrinhoDAO cd = FactoryDAO.getCarrinhoDAO();
	public List<Carrinho> todos(){
		List<Carrinho> carrinho = new ArrayList<Carrinho>();
		carrinho = cd.consultarCarrinho();
		return carrinho;

	}
}
