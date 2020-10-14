package com.devsuperior.dsrecursocliente.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public ResponseEntity<Page<ClientDTO>> findAll(
			
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy				
			) {
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);		
		
		Page<ClientDTO> list = service.findAllPaged(pageRequest);

		return ResponseEntity.ok().body(list);

	}

	// Criando End Point para buscar Cliente por id - GET
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {

		ClientDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);

	}

	// Criando End Point para inserir uma nova Cliente - POST
	@PostMapping
	public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO dto) {
		dto = service.insert(dto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);

	}
	
	// Criando End Point para atualizar Cliente - PUT
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> update(@PathVariable Long id, @RequestBody ClientDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	// Criando End Point para deletar Cliente 
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
