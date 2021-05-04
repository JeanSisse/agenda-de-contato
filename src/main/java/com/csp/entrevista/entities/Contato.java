package com.csp.entrevista.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contato implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(nullable = false, name="nome")
	private String name;
	
	@Column(nullable = false, name="sobrenome")
	private String lastName;
	
	@Column(nullable = false, name="email", unique=true)
	private String email;
	
	@ElementCollection
	@CollectionTable(name="telefones")
	private Set<String> telefones = new HashSet<>();
	
	public Contato() {}
	
	public Contato(Integer id, String name, String lastName, String email) {
		Id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String primeiroNome) {
		this.name = primeiroNome;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String ultimoNome) {
		this.lastName = ultimoNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}
}
