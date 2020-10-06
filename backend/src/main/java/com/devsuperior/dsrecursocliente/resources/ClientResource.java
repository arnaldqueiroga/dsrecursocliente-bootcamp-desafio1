package com.devsuperior.dsrecursocliente.resources;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsrecursocliente.entities.Client;



@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	// Criando o 1º End Point
	@GetMapping // Para configurar que o método abaixo seja um web service
	public ResponseEntity<List<Client>> findAll() {		
		List<Client> list = new ArrayList<>(); 
		Instant birthDate = Instant.parse("1994-07-20T10:30:00Z");
		list.add(new Client(1L, "Maria Silva", "12345678901", 6500.0, 3, birthDate ));
		
		return ResponseEntity.ok().body(list);
		

}
	
}
