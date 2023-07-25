package com.vinh.fresherApp;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
public class CenterController {

	private CenterRepository repository;
	private FresherRepository fresherRepository;
	public CenterController(CenterRepository repository,FresherRepository fresherRepository) {
		this.repository = repository;
		this.fresherRepository = fresherRepository;
	}

	@GetMapping("/centers")
	public List<CompanyCenter> getAllCenter() {
		return repository.findAll();
	}

	@PostMapping("/centers")
	public void createNewCenter(@RequestBody CompanyCenter center) {
		repository.save(center);
	}

	@PostMapping("/centers/update")
	public void updateCenter(@RequestBody CompanyCenter center) {
		repository.save(center);
	}

	@DeleteMapping("/centers")
	public void deleteCenter(@PathParam(value = "id") int id) {
		repository.deleteById(id);
	}
	
	@PostMapping("/centers/{id}/freshers")
	public void addFresherToCenter(@PathVariable int id, @RequestBody Fresher fresher) {
		Optional<CompanyCenter> center = repository.findById(id);
		
		fresher.setCenter(center.get());
		 
		fresherRepository.save(fresher);
	}
	
}
