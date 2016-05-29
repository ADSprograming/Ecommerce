package  com.classeDado.web;

import javax.persistence.EntityManager;
import com.classeBasica.web.Produto;



public class ProdutoDAO extends GenericoDAO<Produto>{

	public ProdutoDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
