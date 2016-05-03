package  com.classeDado.web;

import javax.persistence.EntityManager;

import com.classeBasica.web.Pessoa;



public class PessoaDAO extends GenericoDAO<Pessoa>{

	public PessoaDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
