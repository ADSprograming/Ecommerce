package com.controller.web;


import java.io.File;
import java.io.IOException;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.bancos.Bradesco;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoletoHTML;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classeBasica.web.Cliente;
import com.classeBasica.web.Endereco;
import com.classeDado.web.EnderecoDAO;
import com.classeDado.web.FactoryDAO;


@SuppressWarnings("serial")
public class BoletoTest extends HttpServlet{
	 LoginSingleton l = LoginSingleton.getInstance();
	 Cliente c = new Cliente();
	 EnderecoDAO ed = FactoryDAO.getEnderecoDAO();
	 Endereco e = new Endereco();
	  public  void main()  {
		  c = l.getCliente();
		  e =   c.getEndereco();
		  Datas datas = Datas.novasDatas().comDocumento(1, 6, 2016)
	                .comProcessamento(1, 6, 2016).comVencimento(2, 6, 2016);

	        @SuppressWarnings("deprecation")
			Emissor emissor = Emissor.novoEmissor()
	            .comCedente("Banco Brasil")
	            .comAgencia(2345)
	            .comDigitoAgencia('6')
	            .comContaCorrente(12345)
	            .comNumeroConvenio(1234567)
	            .comDigitoContaCorrente('1')
	            .comCarteira(22)
	            .comNossoNumero(9050987);

	        @SuppressWarnings("deprecation")
			Sacado sacado = Sacado.novoSacado()
	            .comNome(c.getNome())
	            .comCpf(c.getCpf())
	            .comEndereco(e.getComplemento())
	            .comBairro(e.getBairro())
	            .comCep("01234-111")
	            .comCidade(e.getCidade())
	            .comUf(e.getEstado());

	        Banco banco = new Bradesco();

	        @SuppressWarnings("deprecation")
			Boleto boleto = Boleto.novoBoleto()
	            .comBanco(banco)
	            .comDatas(datas)
	            .comDescricoes("Obrigado por compra na nossa loja")
	            .comEmissor(emissor)
	            .comSacado(sacado)
	            .comValorBoleto(l.getSubTotal())
	            .comNumeroDoDocumento("1234")
	            .comInstrucoes("Pague antes do vencimento")
	            .comLocaisDePagamento("Caixa Loterica", "Banco")
	            .comNumeroDoDocumento("4343");

	        
	        
	        GeradorDeBoletoHTML gerador = new GeradorDeBoletoHTML(boleto);
	        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
	       
	        try {
				gerador.geraPDF(response.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       

	       
	    }
}
