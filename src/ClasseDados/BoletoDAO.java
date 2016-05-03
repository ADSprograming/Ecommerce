package ClasseDados;

import javax.persistence.EntityManager;

import ClasseDadosGeral.GenericoDAO;
import ClassesBasicas.Boleto;

public class BoletoDAO extends GenericoDAO<Boleto>{

	public BoletoDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
