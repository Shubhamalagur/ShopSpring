package com.oliver.shopSpring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_USER",uniqueConstraints = @UniqueConstraint(columnNames = "email", name = "UN_EMAIL"))
public class UserEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome",nullable = false)
	private String nome;
	
	@Column(name = "email",nullable = false)
	private String email;
	
	private String telefone;
	 
	@Size(max = 12) 
	@Column(name = "senha",nullable = false)
	private String senha;
	
	//mapeamento opcional	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<OrderEntity> pedidos = new ArrayList<>(); 

	

	public UserEntity(String nome, String email, String telefone,  String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
	}
	
	

	public UserEntity() {
		super();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}



	public List<OrderEntity> getPedidos() {
		return pedidos;
	}
	
	

}
