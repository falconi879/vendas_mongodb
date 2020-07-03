package br.com.jawebsites.vendasMongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jawebsites.vendasMongo.domain.Cliente;

@RestController
@RequestMapping(value="/Clientes")
public class ClienteResurce {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> findAll() {
		Cliente andre = new Cliente("1", "Andre Relhas Falconi", "26245694809", "falconi879", "Ativo");
		Cliente izilda = new Cliente("1", "Izilda Sarita Relhas Falconi", "12345694123", "izilda879", "Ativo");
		
		List<Cliente> list = new ArrayList<>();
		list.addAll(Arrays.asList(andre,izilda));
		return ResponseEntity.ok().body(list); 
	}
}
