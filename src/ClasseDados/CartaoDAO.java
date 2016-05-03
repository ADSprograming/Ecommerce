package ClasseDados;

import javax.persistence.EntityManager;

import ClasseDadosGeral.GenericoDAO;
import ClassesBasicas.Cartao;

public class CartaoDAO extends GenericoDAO<Cartao> {

	public CartaoDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
