package com.devsuperior.dsrecursocliente.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsrecursocliente.dto.ClientDTO;
import com.devsuperior.dsrecursocliente.services.ClientService;
//import com.devsuperior.dsrecursocliente.services.exceptions.EntityNotFoundException;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	// Declarando dependência do Controlador para o Service
	@Autowired
	private ClientService service;

	// Criando o 1º End Point
	@GetMapping // Para configurar que o método abaixo seja um web service
	public ResponseEntity<List<ClientDTO>> findAll() {
		List<ClientDTO> list = service.findAll();

		return ResponseEntity.ok().body(list);

	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
		
		ClientDTO dto = service.findById(id);			
		return ResponseEntity.ok().body(dto);
			
		}
		

}
