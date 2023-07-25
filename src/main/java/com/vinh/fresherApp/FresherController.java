package com.vinh.fresherApp;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
public class FresherController {

	private FresherRepository repository;

	public FresherController(FresherRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/freshers")
	public List<Fresher> getAllFresher() {
		return repository.findAll();
	}

	@GetMapping("/freshers/find/name")
	public List<Fresher> getFresherByName(@PathParam(value = "name") String name) {
		return repository.findFresherByName(name);
	}

	@GetMapping("/freshers/find/email")
	public List<Fresher> getFresherByEmail(@PathParam(value = "email") String email) {
		return repository.findFresherByEmail(email);
	}

	@GetMapping("/freshers/find/language")
	public List<Fresher> getFresherByLanguage(@PathParam(value = "language") String language) {
		return repository.findFresherByProgramingLanguage(language);
	}

	@PostMapping("/freshers")
	public void createFresher(@RequestBody Fresher fresher) {
		repository.save(fresher);
	}

	@PostMapping("freshers/update")
	public void updateFresher(@RequestBody Fresher fresher) {
		repository.save(fresher);
	}

	@DeleteMapping("/freshers/{id}")
	public void deleteFresherByID(@PathVariable int id) {
		repository.deleteById(id);
	}

}
