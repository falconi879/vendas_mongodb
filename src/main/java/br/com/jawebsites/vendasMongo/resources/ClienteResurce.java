package br.com.jawebsites.vendasMongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
