package ClasseDados;

import javax.persistence.EntityManager;

import ClasseDadosGeral.GenericoDAO;
import ClassesBasicas.Cliente;

public class ClienteDAO extends GenericoDAO<Cliente>{

	public ClienteDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
