package com.controller.web;

import com.classeBasica.web.Cliente;

public class LoginSingleton {
    private static LoginSingleton instance;


		public static synchronized LoginSingleton getInstance() {
			if (instance == null)
				instance = new LoginSingleton();

			return instance;
		}
    
	
	boolean log;
	Cliente cliente = new Cliente();
	private double total,frete,subTotal;
	private String imagem;
	public String getImagem() {
		return imagem;
	}


	public void setImagem(String imagem) {
		this.imagem = imagem;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public double getFrete() {
		return frete;
	}


	public void setFrete(double frete) {
		this.frete = frete;
	}


	public double getSubTotal() {
		return subTotal;
	}


	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public boolean isLog() {
		return log;
	}


	public void setLog(boolean log) {
		this.log = log;
	}
	
	
}
