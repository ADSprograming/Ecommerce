package com.classeNegocio.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.classeBasica.web.Produto;
import com.classeDado.web.FactoryDAO;
import com.classeDado.web.ProdutoDAO;
import com.interfaceNegocio.web.INegocioProduto;



@ManagedBean(name = "produtoService")
@ApplicationScoped
public class ProdutoNegocio implements INegocioProduto{

	ProdutoDAO pd = FactoryDAO.getProdutoDAO();
	public void cadastrar(Produto pr) throws Exception {
		if (pr == null) {
            throw new Exception("Não é possível cadastrar um objeto nulo");
        }
        if (pr.getNome() == null) {
            throw new Exception("Informe nome");
        }
        if (pr.getNome().trim().equals("") == true) {
            throw new Exception("Informe nome");
        }
        if (pr.getDescricao() == null) {
            throw new Exception("Informe descrição");
        }
        if (pr.getDescricao().trim().equals("") == true) {
            throw new Exception("Informe descrição");
        }
        if (pr.getMarca() == null) {
            throw new Exception("Informe marca");
        }
        if (pr.getMarca().trim().equals("") == true) {
            throw new Exception("Informe marca");
        }
        if (pr.getPreco() <= 0) {
            throw new Exception("Informe preço acima de zero");
        }
        
        pd.inserir(pr);			
	}

	public List<Produto> todos(){
		List<Produto> produtos = new ArrayList<Produto>();
		produtos = pd.consultarProduto();
		return produtos;
		
	}

}
