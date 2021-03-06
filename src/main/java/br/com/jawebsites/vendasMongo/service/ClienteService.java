package br.com.jawebsites.vendasMongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jawebsites.vendasMongo.domain.Cliente;
import br.com.jawebsites.vendasMongo.dto.ClienteDto;
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
	public Cliente insert(Cliente cliente) {
		return clienteRepository.insert(cliente);
	}
	
	public void delete(String id) {
		findById(id);
		clienteRepository.deleteById(id);
		
	}
	public Cliente update(Cliente obj) {
		Cliente novoCli = findById(obj.getId());
		  updateData(novoCli, obj);
		return clienteRepository.save(novoCli);
	}
	
	
	
	private void updateData(Cliente novoCli, Cliente obj) {
		
		novoCli.setNome(obj.getNome());
		novoCli.setUsuario(obj.getUsuario());
	}

	public Cliente fromDto(ClienteDto clienteDto) {
		return new Cliente(clienteDto.getId(),clienteDto.getNome(),clienteDto.getUsuario(), null, null);
		
	}
}
