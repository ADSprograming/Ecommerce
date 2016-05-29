package com.controller.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.classeBasica.web.Produto;

@ManagedBean(name="fileUploadController")
public class FileUploadController {
	private String destination="C:/";

	public void handleFileUploadAdicionar(FileUploadEvent event) {  
		FacesMessage message = new FacesMessage("Sucesso", event.getFile().getFileName() + " O arquivo foi carrgado com sucesso!");  
		FacesContext.getCurrentInstance().addMessage(null, message);
		// Do what you want with the file        
		try {
			copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}  
	public void handleFileUploadAlterar(FileUploadEvent event) {  
		FacesMessage msg = new FacesMessage("Sucesso", event.getFile().getFileName() + " O arquivo foi alterado com sucesso!");  
		FacesContext.getCurrentInstance().addMessage(null, msg);
		// Do what you want with the file        
		try {
			copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void copyFile(String fileName, InputStream in) {
		try {


			// write the inputStream to a FileOutputStream
			OutputStream out = new FileOutputStream(new File(destination + fileName));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			in.close();
			out.flush();
			out.close();

			System.out.println("Novo arquivo criado!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}