package br.com.jawebsites.vendasMongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.jawebsites.vendasMongo.domain.Cliente;
import br.com.jawebsites.vendasMongo.dto.ClienteDto;
import br.com.jawebsites.vendasMongo.service.ClienteService;

@RestController
@RequestMapping(value="/Clientes")
public class ClienteResurce {
	
	@Autowired
	private ClienteService servico;
	
 	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ClienteDto>> findAll() {		
		List<Cliente> list = servico.findAll();
		List<ClienteDto> listDto = list.stream().map(x -> new ClienteDto(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto); 
	}
 	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<ClienteDto> findById(@PathVariable String id) {		
		Cliente cliente = servico.findById(id);
		return ResponseEntity.ok().body( new ClienteDto(cliente)); 
	}
 	@RequestMapping(method=RequestMethod.POST)
 	public ResponseEntity<Void> insert(@RequestBody ClienteDto clienteDto){
 		Cliente cliente = servico.fromDto(clienteDto);
 		cliente = servico.insert(cliente);
 		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).build();		
 	}
}
