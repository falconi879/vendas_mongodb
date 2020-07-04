package br.com.jawebsites.vendasMongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.jawebsites.vendasMongo.domain.Cliente;
import br.com.jawebsites.vendasMongo.repository.ClienteRepository;

@Configuration
public class InstanciaVendas implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		clienteRepository.deleteAll();
		
		Cliente cli1 = new Cliente(null, "Izilda", "1234567890", "zizi", "Ativo");
		Cliente cli2 = new Cliente(null, "Monica", "0988765432", "momo", "Ativo");	
		Cliente cli3 = new Cliente(null, "Vicente", "3456789123", "vivi", "Desativo");	
		Cliente cli4 = new Cliente(null, "Izilda", "1234567890", "zizi", "Ativo");	
		
		clienteRepository.saveAll(Arrays.asList(cli1,cli2, cli3,cli4));
	
	}

}
