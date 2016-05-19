package  com.classeDado.web;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import com.classeBasica.web.Produto;



public class ProdutoDAO extends GenericoDAO<Produto>{

	public ProdutoDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
