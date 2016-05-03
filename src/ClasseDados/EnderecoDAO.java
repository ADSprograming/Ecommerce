package ClasseDados;

import javax.persistence.EntityManager;

import ClasseDadosGeral.GenericoDAO;
import ClassesBasicas.Endereco;

public class EnderecoDAO extends GenericoDAO<Endereco>{

	public EnderecoDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
