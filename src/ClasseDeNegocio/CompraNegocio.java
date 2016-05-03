package ClasseDeNegocio;

import ClasseDados.CompraDAO;
import ClasseDadosGeral.FactoryDAO;
import ClassesBasicas.Compra;
import InterfaceNegocio.INegocioCompra;

public class CompraNegocio implements INegocioCompra{

	@Override
	public void cadastrar(Compra co) throws Exception {
		if (co == null) {
            throw new Exception("Não é possível cadastrar um objeto nulo");
        }
        if (co.getPrecoTotal() == null) {
            throw new Exception("Informe produtos");
        }
        if (co.getCliente()== null ) {
            throw new Exception("Informe dados do cliente");
        }
        if(co.getProdutos() == null){
        	throw new Exception("Informe produtos");
        }
        CompraDAO pd = FactoryDAO.getCompraDAO();
        pd.inserir(co);
	}

}
