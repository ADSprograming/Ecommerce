package com.controller.web;

import javax.faces.bean.ManagedBean;

import com.classeBasica.web.Proprietario;
import com.classeDado.web.FactoryDAO;
import com.classeDado.web.ProprietarioDAO;

@ManagedBean
public class Controller {
	public void  setProprietario(){
		ProprietarioDAO pd = FactoryDAO.getProprietarioDAO();
		Proprietario p = new Proprietario();
		p.setNome("eu");
		p.setIdProprietario(1);
		p.setEmail("sostes@gmail");
		p.setLogin("miojo");
		p.setSenha("moijo");
		p.setCnpj("165454");
		p.setRazaoSocial("casado");
		pd.inserir(p);
		
	}
}
