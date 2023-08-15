package com.vinh.fresherApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
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

import com.vinh.fresherApp.entity.CompanyCenter;
import com.vinh.fresherApp.entity.Fresher;
import com.vinh.fresherApp.repository.CenterRepository;
import com.vinh.fresherApp.repository.FresherRepository;

import jakarta.websocket.server.PathParam;

@RestController
public class CenterController {

	private CenterRepository repository;
	private FresherRepository fresherRepository;
	public CenterController(CenterRepository repository,FresherRepository fresherRepository) {
		this.repository = repository;
		this.fresherRepository = fresherRepository;
	}

	@GetMapping("api/centers")
	public List<CompanyCenter> getAllCenter() {
		return repository.findAll();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("api/centers")
	public ResponseEntity<String> createNewCenter(@RequestBody CompanyCenter center) {
		repository.save(center);
		return new ResponseEntity<>("Add center successfully.", HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("api/centers/{iđ}")
	public ResponseEntity<CompanyCenter> updateCenter(@PathVariable int id, @RequestBody CompanyCenter center) {
		CompanyCenter companyCenter = repository.save(center);
		
		 return new ResponseEntity<>(companyCenter, HttpStatus.OK); 
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("api/centers/{id}")
	public ResponseEntity<String> deleteCenter(@PathVariable int id) {
		repository.deleteById(id);
		
		return new ResponseEntity<>("Center entity deleted successfully.", HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("api/centers/{id}/freshers")
	public ResponseEntity<String> addFresherToCenter(@PathVariable int id, @RequestBody Fresher fresher) {
		Optional<CompanyCenter> center = repository.findById(id);
		
		fresher.setCenter(center.get());
		 
		fresherRepository.save(fresher);
		
		return new ResponseEntity<>("Add fresher successfully.", HttpStatus.OK);
	}
	
}
