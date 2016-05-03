package ClasseDados;

import javax.persistence.EntityManager;

import ClasseDadosGeral.GenericoDAO;
import ClassesBasicas.Compra;

public class CompraDAO extends GenericoDAO<Compra>{

	public CompraDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
