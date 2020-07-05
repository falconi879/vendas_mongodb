package br.com.jawebsites.vendasMongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jawebsites.vendasMongo.domain.Cliente;
import br.com.jawebsites.vendasMongo.repository.ClienteRepository;
import br.com.jawebsites.vendasMongo.service.exceptions.ObjectNotFoundException;
@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}
	
	public Cliente findById(String id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
}
