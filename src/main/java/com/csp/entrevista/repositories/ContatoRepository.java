package com.csp.entrevista.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csp.entrevista.entities.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer>{

	List<Contato> findByName(String primeiroNome);
	Contato findByEmail(String email);
}
