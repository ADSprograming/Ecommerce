package ClasseDeNegocio;

import ClasseDados.ProprietarioDAO;
import ClasseDadosGeral.FactoryDAO;
import ClassesBasicas.Proprietario;
import InterfaceNegocio.INegocioProprietario;

public class ProprietarioNegocio implements INegocioProprietario{

	@Override
	public void cadastrar(Proprietario pr) throws Exception {
		if (pr == null) {
            throw new Exception("Não é possível cadastrar um objeto nulo");
        }
        if (pr.getNome() == null) {
            throw new Exception("Informe nome");
        }
        if (pr.getNome().trim().equals("") == true) {
            throw new Exception("Informe nome");
        }
        if (pr.getCnpj() == null) {
            throw new Exception("Informe cpf");
        }
        if (pr.getCnpj().trim().equals("") == true) {
            throw new Exception("Informe cpf");
        }
        if (pr.getEmail() == null) {
            throw new Exception("Informe email");
        }
        if (pr.getEmail().trim().equals("") == true) {
            throw new Exception("Informe Email");
        }
        if (pr.getEmail() == null) {
            throw new Exception("Informe email");
        }
        if (pr.getEmail().trim().equals("") == true) {
            throw new Exception("Informe Email");
        }
        if (pr.getLogin() == null) {
            throw new Exception("Informe login");
        }
        if (pr.getLogin().trim().equals("") == true) {
            throw new Exception("Informe login");
        }
        if (pr.getSenha() == null) {
            throw new Exception("Informe senha");
        }
        if (pr.getSenha().trim().equals("") == true) {
            throw new Exception("Informe senha");
        }
        if (pr.getRazaoSocial() == null) {
            throw new Exception("Informe senha");
        }
        if (pr.getRazaoSocial().trim().equals("") == true) {
            throw new Exception("Informe senha");
        }
        ProprietarioDAO dp = FactoryDAO.getProprietarioDAO();
        dp.inserir(pr);			
	}

}
