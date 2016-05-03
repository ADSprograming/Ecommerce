package ClasseDados;

import javax.persistence.EntityManager;

import ClasseDadosGeral.GenericoDAO;
import ClassesBasicas.Produto;

public class ProdutoDAO extends GenericoDAO<Produto>{

	public ProdutoDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
