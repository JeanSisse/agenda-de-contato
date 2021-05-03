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
	
//	@RequestMapping(method=RequestMethod.GET)
//	public ResponseEntity<List<Contato>> findAll() {
//		
//		List<Contato> list = contatoService.findAll();
//		return ResponseEntity.ok(list);
//	}
	
	
//	@RequestMapping(value="/{id}", method=RequestMethod.GET)
//	public ResponseEntity<Contato> findById(@PathVariable Integer id) {
//		
//		Contato obj = contatoService.findById(id);
//		return ResponseEntity.ok(obj);
//	}
	
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
	
	/**
	 * Aplicação utilizado para testar o API: Postman
	 * 
	 * 
	 * ** PESQUISAR CONTATOS com o métod GET **
	 * 
	 * Listar todos os contatos (ex.: http://localhost:8080/contatos)
	 * Filtra pelo nome (ex.: http://localhost:8080/contatos?name=Nome da pessoa)
	 * Filtra pelo email (ex.: http://localhost:8080/contatos/email@dominio.com
	 * 
	 * 
	 * ** INSERIR CONTATO com o métod POST no formato JSON**
	 * 
	 * Ex.: acessar: http://localhost:8080/contatos/
	 * Selecionar opção body
	 * Setar opção "row" e na mesma aba escolher o formato "JSON" para o corpo da requisição a ser enviada
	 * 
	 * Formato JSON:
	 * {
     *	"name": "Nome do contato",
     *	"lastName": "Sobrenome",
     *	"email": "nome@dominio.com",
     *	"telefone1": "número de telefone" (obrigatorio),
     *	"telefone2": "número de telefone" (opcional),
     *	"telefone3": "número de telefone" (opcional, máximo de 3 telefones neste formato)
	 * }
	 *  OU
	 *  
	 * {
     *	"name": "Nome do contato",
     *	"lastName": "Sobrenome",
     *	"email": "nome@dominio.com",
     *	"telefones": [
     *		"número de telefone",
     *		"número de telefone",
     *		... (quantos telefones quiser neste formato)
     *	 ]
	 * }
	 * 
	 * ** ATUALIZAR CONTATO com o método PUT no formato JSON** 
	 * Ex.: Encotrar o contato desejado (ver ** PESQUISAR CONTATOS com o métod GET **),
	 * alterar o método de requisição para PUT, Selecionar opção body, 
	 * Setar opção "row" e na mesma aba escolher o formato "JSON" para o corpo da requisição a ser enviada
	 * Adicionar o id do contato a ser atualizado no link da requisição (Ex.: http://localhost:8080/contatos/id)
	 * 
	 * Formato JSON:
	 * {
     *	"name": "Nome do contato",
     *	"lastName": "Sobrenome",
     *	"email": "nome@dominio.com",
     *	"telefone1": "número de telefone" (obrigatorio),
     *	"telefone2": "número de telefone" (opcional),
     *	"telefone3": "número de telefone" (opcional, máximo de 3 telefones neste formato)
	 * }
	 *  OU
	 *  
	 * {
     *	"name": "Nome do contato",
     *	"lastName": "Sobrenome",
     *	"email": "nome@dominio.com",
     *	"telefones": [
     *		"número de telefone",
     *		"número de telefone",
     *		... (quantos telefones quiser neste formato)
     *	 ]
	 * }
	 * 
	 * 
	 * ** REMOVER CONTATO com método DELETE**
	 * 
	 * Ex.: Filtrar o contato a ser deletado, alterar o método para DELETE e informar o id do contato desejado
	 * (http://localhost:8080/contatos/idDoContatoParaDeletar)
	 * 
	 * */
}
