package  com.classeDado.web;

import javax.persistence.EntityManager;

import com.classeBasica.web.Cliente;



public class ClienteDAO extends GenericoDAO<Cliente>{
	private EntityManager em;
	public ClienteDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	 public Cliente consultarPorNome(String login){
			Cliente cliente = null;
			 try{
				cliente = (Cliente) em.createQuery("FROM Cliente WHERE login ='"+login+"'").getSingleResult();
			}catch(Exception e){
				 e.printStackTrace();
			}
		   return cliente;
		    }

}
