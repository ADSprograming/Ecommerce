package  com.classeDado.web;


import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.classeBasica.web.Carrinho;
import com.classeBasica.web.Cliente;
import com.classeBasica.web.Produto;
import com.classeBasica.web.Proprietario;


public class GenericoDAO <Entidade>{

	private EntityManager entityManager;
	private Class<Entidade> classePersistente;

	@SuppressWarnings("unchecked")
	public GenericoDAO(EntityManager em){
		this.setEntityManager(em);
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();  
		classePersistente = (Class<Entidade>) parameterizedType.getActualTypeArguments()[0];  
	}

	/**
	 * Executa o merge do objeto que se encontra em memória.
	 * 
	 * @param objeto
	 *            a ser realizado o merge
	 * @return objeto que foi executado o merge
	 */
	public Entidade alterar(Entidade objeto) {

		EntityTransaction tx = getEntityManager().getTransaction();
		tx.begin();

		objeto = getEntityManager().merge(objeto);

		tx.commit();

		return objeto;
	}

	/**
	 * Salva o objeto atual na base de dados.
	 * 
	 * @param objeto a ser salvo
	 */
	public void inserir(Entidade objeto) {
		EntityTransaction tx = getEntityManager().getTransaction();		
		try {
			tx.begin();
			getEntityManager().persist(objeto);
			tx.commit();
			System.out.println(classePersistente.getSimpleName() + " salvo com sucesso");
		} catch (PersistenceException e) {
			tx.rollback();
		}
	}

	/**
	 * Salva o objeto atual na base de dados.
	 * 
	 * @param objeto
	 *            a ser salvo
	 */
	public final void inserirColecao(Collection<Entidade> colecao) {
		try {
			EntityTransaction tx = getEntityManager().getTransaction();
			tx.begin();

			for (Entidade entidade : colecao) {
				getEntityManager().persist(entidade);	
			}

			tx.commit();

			System.out.println(classePersistente.getSimpleName() + " salvos com sucesso: " + colecao.size());
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Remove o objeto da base de dados.
	 * 
	 * @param objeto
	 *            a ser removido
	 */
	public final void remover(Entidade objeto) {
		EntityTransaction tx = getEntityManager().getTransaction();
		tx.begin();

		// Este merge foi incluido para permitir a exclusao de objetos no estado Detached
		objeto = getEntityManager().merge(objeto);

		getEntityManager().remove(objeto);

		tx.commit();

		System.out.println(classePersistente.getSimpleName() + " removido com sucesso");		
	}



	/**
	 * Busca o objeto uma vez passado sua chave como parâmetro.
	 * 
	 * @param chave
	 *            identificador
	 * @return Objeto do tipo T
	 */
	public final Entidade buscarPorChave(Serializable chave) {
		Entidade instance = null;
		try {
			instance = (Entidade) getEntityManager().find(getClassePersistente(), chave);
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
		return instance;
	}

	public Cliente consultarPorNome(String login) {
		Cliente cliente = null;
		try{
			cliente = (Cliente) entityManager.createQuery("FROM Cliente WHERE login ='"+login+"'").getSingleResult();
		}catch(Exception e){
			e.printStackTrace();
		}
		return cliente;
	}

	public Proprietario consultarPorNomeAdmin(String login) {
		Proprietario proprietario = null;
		try{
			proprietario = (Proprietario) entityManager.createQuery("FROM Proprietario WHERE login ='"+login+"'").getSingleResult();
		}catch(Exception e){
			e.printStackTrace();
		}
		return proprietario;
	}

	public Produto consultarProduto(int idProduto) {
		Produto produto = null;
		try{
			produto = (Produto) entityManager.createQuery("FROM Cliente WHERE idProduto ='"+idProduto+"'").getSingleResult();
		}catch(Exception e){
			e.printStackTrace();
		}
		return produto;
	}

	@SuppressWarnings("unchecked")
	public  List<Produto> consultarProduto(){
		List<Produto> produtos = null;
		try{
			produtos = (List<Produto>) entityManager.createQuery("FROM Produto ").getResultList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return produtos;
	}   

	@SuppressWarnings("unchecked")
	public  List<Carrinho> consultarCarrinho(){
		List<Carrinho> carrinho = null;
		try{
			carrinho = (List<Carrinho>) entityManager.createQuery("FROM Carrinho ").getResultList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return carrinho;
	} 

	/**
	 * Atualiza o objeto que se encontra em memória.
	 * 
	 * @param object
	 *            objeto a ser atualizado
	 */
	public final void refresh(Entidade object) {
		getEntityManager().refresh(object);
	}

	/**
	 * Utilizado para se injetar o Entity manager no DAO.
	 * 
	 * @param entityManager
	 *            entity manager
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}


	/**
	 * Busca a classe persistente do objeto utilizado na classe.
	 * 
	 * @return classe persistente
	 */
	protected final Class<Entidade> getClassePersistente() {
		return classePersistente;
	}


}
