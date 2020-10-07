package com.devsuperior.dsrecursocliente.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsrecursocliente.entities.Client;
import com.devsuperior.dsrecursocliente.services.ClientService;


@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	// Declarando dependência do Controlador para o Service	
	@Autowired
	private ClientService service;

	// Criando o 1º End Point
	@GetMapping // Para configurar que o método abaixo seja um web service
	public ResponseEntity<List<Client>> findAll() {	
		List<Client> list = service.findAll();
		
		
		return ResponseEntity.ok().body(list);
		

}
	
}
