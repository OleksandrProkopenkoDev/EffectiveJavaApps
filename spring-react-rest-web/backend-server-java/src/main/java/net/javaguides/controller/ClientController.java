package net.javaguides.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.model.Client;
import net.javaguides.repository.ClientRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping("/clients")
	public List<Client> getAllClients(){
		return clientRepository.findAll();
	}
	
	@PostMapping("/clients")
	public Client createClient(@RequestBody Client client) {
		return clientRepository.save(client);
	}
	
}
