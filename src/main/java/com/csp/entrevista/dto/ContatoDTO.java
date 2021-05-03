package com.csp.entrevista.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ContatoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String name;
	private String lastName;
	private String email;
//	private Set<String> telefones = new HashSet<>();
	private String telefone1;
	private String telefone2;
	private String telefone3;
	private Set<String> telefones = new HashSet<>(); 
	
	public ContatoDTO() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setUltimoNome(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}
}
