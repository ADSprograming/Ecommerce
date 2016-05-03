package ClasseDadosGeral;


	import java.io.Serializable;
	import java.lang.reflect.ParameterizedType;
	import java.util.Collection;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityTransaction;
	import javax.persistence.PersistenceException;


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
