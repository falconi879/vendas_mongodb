package br.com.jawebsites.vendasMongo.dto;

import java.io.Serializable;

import br.com.jawebsites.vendasMongo.domain.Cliente;

public class ClienteDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id; 
	private String nome;
	private String usuario;
	
		
	public ClienteDto() {
	}
	public ClienteDto(Cliente cliente) {
		id = cliente.getId();
		nome = cliente.getNome();
		usuario = cliente.getUsuario();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	

}
