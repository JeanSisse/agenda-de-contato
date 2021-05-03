package com.csp.entrevista.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csp.entrevista.dto.ContatoDTO;
import com.csp.entrevista.entities.Contato;
import com.csp.entrevista.repositories.ContatoRepository;
import com.csp.entrevista.services.exceptions.NullPointerExceptionFound;
import com.csp.entrevista.services.exceptions.ObjectNotFoundException;

@Service
public class ContatoService {

	@Autowired
	ContatoRepository contatoRepository;
	
	public List<Contato> findAll() {
		return contatoRepository.findAll();
	}
	
	public Contato findById(Integer id) {
		Optional<Contato> obj = contatoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Contato.class.getName()));
	}
	
	public List<Contato> findByName(String name) {
		List<Contato> obj = contatoRepository.findByName(name);

		if(obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Email: " + name + ", Tipo: " + Contato.class.getName());
		}
		return obj;
	}
	
	public Contato findByEmail(String email) {
		Contato obj = contatoRepository.findByEmail(email);
		if(obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Email: " + email + ", Tipo: " + Contato.class.getName());
		}
		return obj;
	}
	
	public Contato insert(Contato obj) {
		obj.setId(null);
		return contatoRepository.save(obj);
	}
	
	public Contato update(Contato obj) {
		Contato newObj = findById(obj.getId());
		updateData(newObj, obj);
		return contatoRepository.save(newObj);
	}
	
	public void deleteById(Integer id) {
		contatoRepository.deleteById(id);
	}
	
	public Contato fromDTO(ContatoDTO objDTO) {

		Contato contato = new Contato(null, objDTO.getName(), objDTO.getLastName(), objDTO.getEmail());
//		contato.getTelefones().add(objDTO.getTelefone1());
		
		if(objDTO.getTelefone1() != null || objDTO.getTelefones() != null) {
			if(objDTO.getTelefone1() != null)
				contato.getTelefones().add(objDTO.getTelefone1());
			else
				contato.setTelefones(objDTO.getTelefones());
		} else {
			throw new NullPointerExceptionFound(
					"Preencher pelo menos um telefone para contato!");
		}
		
		if(objDTO.getTelefone2() != null) {
			contato.getTelefones().add(objDTO.getTelefone2());
		}
		if(objDTO.getTelefone3() != null) {
			contato.getTelefones().add(objDTO.getTelefone3());
		}
		
		return contato;
	}
	
	private void updateData(Contato newObj, Contato obj) {
		if(obj.getTelefones().isEmpty()
				 || obj.getEmail().isEmpty()
				 || obj.getName().isEmpty()
				 || obj.getLastName().isEmpty()) {
			throw new ObjectNotFoundException(
					"Não deixe campo vázio (nome, sobrenome, email e telefone)!");
		} else {
			newObj.setName(obj.getName());
			newObj.setLastName(obj.getLastName());
			newObj.setEmail(obj.getEmail());
			newObj.setTelefones(obj.getTelefones());
		}
	}
	
//	private Contato validateFields(Contato obj) {
//		if(obj.getTelefones().isEmpty()
//				 || obj.getEmail().isEmpty()
//				 || obj.getName().isEmpty()
//				 || obj.getLastName().isEmpty()) {
//			throw new ObjectNotFoundException(
//					"Preencha todos os campos (nome, sobrenome, email e telefone)!");
//		}
//		return obj;
//	}
}