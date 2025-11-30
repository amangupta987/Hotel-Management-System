package net.HM.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.HM.entity.ClientEntity;
import net.HM.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepo;
	
	public List<ClientEntity> getAll(){
		return clientRepo.findAll();
	}
	
	public ClientEntity saveClient(ClientEntity client) {
		return clientRepo.save(client);
	}
	
	public Optional<ClientEntity> findById(Long id){
		return clientRepo.findById(id);
	}
	
	public ClientEntity updateById(Long id , ClientEntity client) {
		ClientEntity existingclient = clientRepo.findById(id).orElse(null) ;
		
		existingclient.setName(client.getName());
		existingclient.setEmail(client.getEmail());
		existingclient.setPassword(client.getPassword());
		
		return clientRepo.save(existingclient);
	}
	
	public void deleteById(Long id) {
		clientRepo.deleteById(id);
	}
}
