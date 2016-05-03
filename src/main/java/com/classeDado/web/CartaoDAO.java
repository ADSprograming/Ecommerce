package  com.classeDado.web;

import javax.persistence.EntityManager;

import com.classeBasica.web.Cartao;



public class CartaoDAO extends GenericoDAO<Cartao> {

	public CartaoDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
