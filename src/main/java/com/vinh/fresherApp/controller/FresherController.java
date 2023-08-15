package com.vinh.fresherApp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vinh.fresherApp.entity.Fresher;
import com.vinh.fresherApp.repository.FresherRepository;

import jakarta.websocket.server.PathParam;

@RestController
public class FresherController {

	private FresherRepository repository;

	public FresherController(FresherRepository repository) {
		this.repository = repository;
	}

	@GetMapping("api/freshers")
	public List<Fresher> getAllFresher() {
		return repository.findAll();
	}

	@GetMapping("api/freshers/find/name")
	public List<Fresher> getFresherByName(@PathParam(value = "name") String name) {
		return repository.findFresherByName(name);
	}

	@GetMapping("api/freshers/find/email")
	public List<Fresher> getFresherByEmail(@PathParam(value = "email") String email) {
		return repository.findFresherByEmail(email);
	}

	@GetMapping("api/freshers/find/language")
	public List<Fresher> getFresherByLanguage(@PathParam(value = "language") String language) {
		return repository.findFresherByProgramingLanguage(language);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("api/freshers")
	public ResponseEntity<String> createFresher(@RequestBody Fresher fresher) {
		repository.save(fresher);
		return new ResponseEntity<>("Add fresher successfully.", HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("api/freshers/{id}")
	public  ResponseEntity<Fresher> updateFresher(@PathVariable int id,@RequestBody Fresher fresher) {
		Fresher fresher1 = repository.save(fresher);
		
		return new ResponseEntity<>(fresher1,HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("api/freshers/{id}")
	public void deleteFresherByID(@PathVariable int id) {
		repository.deleteById(id);
	}

}
