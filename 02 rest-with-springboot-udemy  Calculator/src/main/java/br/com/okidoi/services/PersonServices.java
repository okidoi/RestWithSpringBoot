package br.com.okidoi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.okidoi.exception.ResourceNofFoundException;
import br.com.okidoi.model.Person;
import br.com.okidoi.repository.PersonRepository;

@Service  //para que o SpringBoot cuida da injeção de dependencia dessa classe quando ela for usada em outra, não sendo necessário dar new em uma instancia desta classe
public class PersonServices {
	
	@Autowired
	PersonRepository repository;
	
	public Person create(Person person) {
		return repository.save(person);
	}
	
	public Person update(Person person) {
		
		Person entity = repository.findById(person.getId()).
				orElseThrow(() -> new ResourceNofFoundException("No records found for this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(entity);
		
	}	
	
	public void delete(Long id) {
		
		Person entity = repository.findById(id).
				orElseThrow(() -> new ResourceNofFoundException("No records found for this ID"));
		repository.delete(entity);	
		
	}	
	public List<Person> findAll() {

		return repository.findAll();

		
	}
	
	public Person findById(Long id) {
		
		return repository.findById(id).
				orElseThrow(() -> new ResourceNofFoundException("No records found for this ID"));
		
	}


	
}
