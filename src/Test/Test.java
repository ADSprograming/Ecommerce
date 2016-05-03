package Test;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ClasseDados.ClienteDAO;
import ClasseDados.CompraDAO;
import ClasseDados.EnderecoDAO;
import ClasseDados.ProdutoDAO;
import ClasseDados.ProprietarioDAO;
import ClasseDados.VendaDAO;
import ClasseDadosGeral.FactoryDAO;
import ClassesBasicas.Cliente;
import ClassesBasicas.Compra;
import ClassesBasicas.Endereco;
import ClassesBasicas.Produto;
import ClassesBasicas.Proprietario;
import ClassesBasicas.Venda;

public class Test {

	public static void main(String[] args) {
		
		EnderecoDAO  enderecodao = FactoryDAO.getEnderecoDAO();
		Endereco endereco = new Endereco();
		endereco.setBairro("Piedade");
		endereco.setCep(54420140);
		endereco.setCidade("Jaboatão");
		endereco.setLogradouro("Guanamib");
		endereco.setId(1);
		endereco.setNumero(819);
		ClienteDAO clientedao = FactoryDAO.getClienteDAO();
		Cliente cliente = new Cliente();
		cliente.setCpf("00990065");
		cliente.setEmail("sostenesfreitas@");
		cliente.setEndereco(endereco);
		cliente.setIdCliente(1);
		cliente.setLogin("sostenesf");
		cliente.setNome("sostenes");
		cliente.setSenha("123123");
		ProdutoDAO produtodao = FactoryDAO.getProdutoDAO();
		Produto produto = new Produto();
		produto.setDescricao("Smart Tv 4K 49'");
		produto.setId(1);
		produto.setMarca("LG");
		produto.setNome("Tv");
		produto.setPreco(3500);
		Produto produto1 = new Produto();
		produto1.setDescricao("4K Ready");
		produto1.setId(2);
		produto1.setMarca("Asus");
		produto1.setNome("Gtx 980 TI");
		produto1.setPreco(4500);
		Produto produto2 = new Produto();
		produto2.setDescricao("Smart Phone'");
		produto2.setId(3);
		produto2.setMarca("Samsung");
		produto2.setNome("Galaxy S6");
		produto2.setPreco(2500);
		Set<Produto> produtos = new HashSet<Produto>();
		produtos.add(produto);
		produtos.add(produto1);
		produtos.add(produto2);
		CompraDAO compradao = FactoryDAO.getCompraDAO();
		Compra compra = new Compra();
		compra.setCliente(cliente);
		compra.setIdCompra(1);
		String total = Double.toString(produto.getPreco() + produto1.getPreco() + produto2.getPreco()); 
		compra.setPrecoTotal(total);
		compra.setProdutos(produtos);
		Set<Compra> compras = new HashSet<Compra>();
		compras.add(compra);
		cliente.setCompras(compras);
		ProprietarioDAO pdao = FactoryDAO.getProprietarioDAO();
		Proprietario p = new Proprietario();
		p.setCnpj("45877954");
		p.setEmail("dono@");
		p.setIdProprietario(1);
		p.setLogin("dono");
		p.setNome("joao");
		p.setRazaoSocial("as");
		p.setSenha("154");
		
		//Crud completo
		
		//Inserir
		/**produtodao.inserir(produto);
		produtodao.inserir(produto1);
		produtodao.inserir(produto2);
		enderecodao.inserir(endereco);
		pdao.inserir(p);
		clientedao.inserir(cliente);
		compradao.inserir(compra);**/
		
		//Consultar 
		
		/**endereco = enderecodao.buscarPorChave(1);
		cliente = clientedao.buscarPorChave(2);
		p = pdao.buscarPorChave(1);
		produto = produtodao.buscarPorChave(1);
		compra = compradao.buscarPorChave(1);
		System.out.println("Nome Cidade: " + endereco.getCidade());
		System.out.println("Nome do Cliente: " + cliente.getNome());
		System.out.println("Nome do Proprietario: " + p.getNome());
		System.out.println("Nome do Produto: " + produto.getNome());
		System.out.println("Total da Compra: " + compra.getPrecoTotal());**/
		
		//Alterar
		//endereco = enderecodao.buscarPorChave(1);
		//endereco.setCidade("Recife");
		//enderecodao.alterar(endereco);
		
		//Remover
		
		//enderecodao.remover(endereco);
	}

	}


