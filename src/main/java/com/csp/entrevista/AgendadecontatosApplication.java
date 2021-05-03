package com.csp.entrevista;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.csp.entrevista.entities.Contato;
import com.csp.entrevista.repositories.ContatoRepository;

@SpringBootApplication
public class AgendadecontatosApplication implements CommandLineRunner{

	@Autowired
	private ContatoRepository contatoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AgendadecontatosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Contato contato1 = new Contato(1, "Jean Pierre", "Sissé", "tavares1988@live.com");
		Contato contato2 = new Contato(2, "Samir Pierre", "Sissé", "samir@live.com");
		Contato contato3 = new Contato(3, "Fatima Pierre", "Sissé", "fatima@live.com");
		
		contato1.getTelefones().addAll(Arrays.asList("6198264-2104", "6198164-2104"));
		contato2.getTelefones().addAll(Arrays.asList("6198268-3504"));
		contato3.getTelefones().addAll(Arrays.asList("6198251-8009"));
		
		contatoRepository.saveAll(Arrays.asList(contato1, contato2, contato3));
	}

}
