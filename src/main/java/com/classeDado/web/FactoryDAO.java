package  com.classeDado.web;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class FactoryDAO {
	private static EntityManager manager;
	private static final EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("ecommerce");
		if (manager == null || !manager.isOpen()) {
			manager = factory.createEntityManager();
		}
	}

	public static BoletoDAO getBoletoDAO(){
		BoletoDAO dao = new BoletoDAO(manager);
		return dao;
	}
	public static CartaoDAO getCartaoDAO(){
		CartaoDAO dao = new CartaoDAO(manager);
		return dao;
	}
	public static ClienteDAO getClienteDAO(){
		ClienteDAO dao = new ClienteDAO(manager);
		return dao;
	}
	public static CompraDAO getCompraDAO(){
		CompraDAO dao = new CompraDAO(manager);
		return dao;
	}
	public static EnderecoDAO getEnderecoDAO(){
		EnderecoDAO dao = new EnderecoDAO(manager);
		return dao;
	}

	public static ProdutoDAO getProdutoDAO(){
		ProdutoDAO dao = new ProdutoDAO(manager);
		return dao;
	}
	public static ProprietarioDAO getProprietarioDAO(){
		ProprietarioDAO dao = new ProprietarioDAO(manager);
		return dao;
	}
	public static VendaDAO getVendaDAO(){
		VendaDAO dao = new VendaDAO(manager);
		return dao;
	}
	public static CarrinhoDAO getCarrinhoDAO(){
		CarrinhoDAO dao = new CarrinhoDAO(manager);
		return dao;
	}
}
