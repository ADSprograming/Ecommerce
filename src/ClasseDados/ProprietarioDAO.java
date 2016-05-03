package ClasseDados;

import javax.persistence.EntityManager;

import ClasseDadosGeral.GenericoDAO;
import ClassesBasicas.Proprietario;

public class ProprietarioDAO extends GenericoDAO<Proprietario>{

	public ProprietarioDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
