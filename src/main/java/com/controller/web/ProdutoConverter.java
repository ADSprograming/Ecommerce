package com.controller.web;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.classeBasica.web.Produto;
import com.controller.web.ProdutoBean;

@FacesConverter("produtoConverte")
public class ProdutoConverter implements Converter {

	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if(value != null && value.trim().length() > 0) {
			try {
				ProdutoBean service = (ProdutoBean) fc.getExternalContext().getApplicationMap().get("produtoBean");
				return service.getProdutos().get(Integer.parseInt(value));
			} catch(NumberFormatException e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de conversão", "Não é um produto válido."));
			}
		}
		else {
			return null;
		}
	}

	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if(object != null) {
			return String.valueOf(((Produto) object).getIdProduto());
		}
		else {
			return null;
		}
	}   
}
