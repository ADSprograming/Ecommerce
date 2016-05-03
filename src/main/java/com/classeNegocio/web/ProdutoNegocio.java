package com.classeNegocio.web;

import com.classeBasica.web.Produto;
import com.classeDado.web.FactoryDAO;
import com.classeDado.web.ProdutoDAO;
import com.interfaceNegocio.web.INegocioProduto;




public class ProdutoNegocio implements INegocioProduto{


	public void cadastrar(Produto pr) throws Exception {
		if (pr == null) {
            throw new Exception("N�o � poss�vel cadastrar um objeto nulo");
        }
        if (pr.getNome() == null) {
            throw new Exception("Informe nome");
        }
        if (pr.getNome().trim().equals("") == true) {
            throw new Exception("Informe nome");
        }
        if (pr.getDescricao() == null) {
            throw new Exception("Informe descri��o");
        }
        if (pr.getDescricao().trim().equals("") == true) {
            throw new Exception("Informe descri��o");
        }
        if (pr.getMarca() == null) {
            throw new Exception("Informe marca");
        }
        if (pr.getMarca().trim().equals("") == true) {
            throw new Exception("Informe marca");
        }
        if (pr.getPreco() <= 0) {
            throw new Exception("Informe pre�o acima de zero");
        }
        ProdutoDAO pd = FactoryDAO.getProdutoDAO();
        pd.inserir(pr);			
	}

	

}
