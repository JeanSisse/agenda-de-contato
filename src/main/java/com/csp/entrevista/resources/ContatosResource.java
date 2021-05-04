package com.csp.entrevista.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.csp.entrevista.dto.ContatoDTO;
import com.csp.entrevista.entities.Contato;
import com.csp.entrevista.services.ContatoService;

@RestController
@RequestMapping(value="/contatos")
public class ContatosResource {

	@Autowired
	private ContatoService contatoService;
	
	@GetMapping
	public ResponseEntity<List<Contato>> findByName(@RequestParam(required=false) String name) {
		if (name == null || name.isEmpty()) {
			List<Contato> list = contatoService.findAll();
			return ResponseEntity.ok(list);
		} else {
			List<Contato> obj = contatoService.findByName(name);
			return ResponseEntity.ok(obj);
		}
	}
	
	@RequestMapping(value="/{email}", method = RequestMethod.GET)
	public ResponseEntity<Contato> findByEmail(@PathVariable(value="email") String email) {
		
		Contato obj = contatoService.findByEmail(email);
		return ResponseEntity.ok(obj);
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody ContatoDTO objDTO){
		Contato obj = contatoService.fromDTO(objDTO);
		obj = contatoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody ContatoDTO objDTO){
		Contato obj = contatoService.fromDTO(objDTO);
		obj.setId(id);
		obj = contatoService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletById(@PathVariable Integer id) {
		contatoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
