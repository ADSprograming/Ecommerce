package ClasseDados;

import javax.persistence.EntityManager;

import ClasseDadosGeral.GenericoDAO;
import ClassesBasicas.Pessoa;

public class PessoaDAO extends GenericoDAO<Pessoa>{

	public PessoaDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
