package net.HM.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.HM.entity.ClientEntity;
import net.HM.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientServ;

	@GetMapping
	public List<ClientEntity> getAll(){
		return clientServ.getAll();
	}
	
	@PostMapping
	public ResponseEntity<ClientEntity> createClient(@RequestBody ClientEntity client){
		ClientEntity save = clientServ.saveClient(client);
		
		return new ResponseEntity<ClientEntity>(save, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClientEntity> findById(@PathVariable Long id)  {
		Optional<ClientEntity> client = clientServ.findById(id);
		
		if(client.isPresent()) {
			return new ResponseEntity<ClientEntity>(client.get(),HttpStatus.OK);
		}else {
			return new ResponseEntity<ClientEntity>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity<ClientEntity> updateById(@PathVariable Long id , @RequestBody ClientEntity client){
		ClientEntity updateClient = clientServ.updateById(id, client);
		
		if(updateClient != null) {
			return ResponseEntity.ok(updateClient);
		}else {
			return ResponseEntity.notFound().build();
		}
	
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ClientEntity>deleteById(@PathVariable Long id){
		clientServ.deleteById(id);
		
		return new ResponseEntity<ClientEntity>(HttpStatus.NO_CONTENT);
	}




}







