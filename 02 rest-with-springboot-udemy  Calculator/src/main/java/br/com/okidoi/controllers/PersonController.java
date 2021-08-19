package br.com.okidoi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.okidoi.data.vo.PersonVO;
import br.com.okidoi.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonServices services;

	@GetMapping(value = "/{id}")
	public PersonVO findById(@PathVariable(value = "id") Long id) throws Exception {
		return services.findById(id);
	}

	@PostMapping
	public PersonVO create(@RequestBody PersonVO person) throws Exception {

		return services.create(person);
	}

	@PutMapping
	public PersonVO update(@RequestBody PersonVO person) throws Exception {

		return services.update(person);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {

		services.delete(id); // Não tem return
		return ResponseEntity.ok().build();
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PersonVO> findAll() throws Exception {

		return services.findAll();

	}

}
