package ClasseDados;

import javax.persistence.EntityManager;

import ClasseDadosGeral.GenericoDAO;
import ClassesBasicas.Venda;

public class VendaDAO extends GenericoDAO<Venda>{

	public VendaDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
}
