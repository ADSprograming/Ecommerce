package com.classeNegocio.web;

import com.classeBasica.web.Compra;
import com.classeDado.web.CompraDAO;
import com.classeDado.web.FactoryDAO;
import com.interfaceNegocio.web.INegocioCompra;



public class CompraNegocio implements INegocioCompra{

	public void cadastrar(Compra co) throws Exception {
		if (co == null) {
			throw new Exception("Não é possível cadastrar um objeto nulo");
		}
		if (co.getPrecoTotal() == null) {
			throw new Exception("Informe produtos");
		}
		if (co.getCliente()== null ) {
			throw new Exception("Informe dados do cliente");
		}
		if(co.getProdutos() == null){
			throw new Exception("Informe produtos");
		}
		CompraDAO pd = FactoryDAO.getCompraDAO();
		pd.inserir(co);
	}



}
