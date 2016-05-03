package ClasseDeNegocio;

import ClasseDados.ClienteDAO;
import ClasseDadosGeral.FactoryDAO;
import ClassesBasicas.Cliente;
import InterfaceNegocio.INegocioCliente;

public class ClienteNegocio implements INegocioCliente{

	@Override
	public void cadastrar(Cliente cl) throws Exception {
		if (cl == null) {
            throw new Exception("Não é possível cadastrar um objeto nulo");
        }
        if (cl.getNome() == null) {
            throw new Exception("Informe nome");
        }
        if (cl.getNome().trim().equals("") == true) {
            throw new Exception("Informe nome");
        }
        if (cl.getCpf() == null) {
            throw new Exception("Informe cpf");
        }
        if (cl.getCpf().trim().equals("") == true) {
            throw new Exception("Informe cpf");
        }
        if (cl.getEmail() == null) {
            throw new Exception("Informe email");
        }
        if (cl.getEmail().trim().equals("") == true) {
            throw new Exception("Informe Email");
        }
        if (cl.getEmail() == null) {
            throw new Exception("Informe email");
        }
        if (cl.getEmail().trim().equals("") == true) {
            throw new Exception("Informe Email");
        }
        if (cl.getLogin() == null) {
            throw new Exception("Informe login");
        }
        if (cl.getLogin().trim().equals("") == true) {
            throw new Exception("Informe login");
        }
        if (cl.getSenha() == null) {
            throw new Exception("Informe senha");
        }
        if (cl.getSenha().trim().equals("") == true) {
            throw new Exception("Informe senha");
        }
        ClienteDAO df = FactoryDAO.getClienteDAO();
        df.inserir(cl);		
	}
	
}
