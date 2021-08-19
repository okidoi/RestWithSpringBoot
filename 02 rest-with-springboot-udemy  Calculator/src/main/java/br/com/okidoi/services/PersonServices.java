package br.com.okidoi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.okidoi.converter.DozerConverter;
import br.com.okidoi.data.vo.PersonVO;
import br.com.okidoi.exception.ResourceNofFoundException;
import br.com.okidoi.model.Person;
import br.com.okidoi.repository.PersonRepository;

@Service  //para que o SpringBoot cuida da injeção de dependencia dessa classe quando ela for usada em outra, não sendo necessário dar new em uma instancia desta classe
public class PersonServices {
	
	@Autowired
	PersonRepository repository;
	
	public PersonVO create(PersonVO person) {
		
		var entity = DozerConverter.parseObject(person, Person.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public PersonVO update(PersonVO person) {
		
		var entity = repository.findById(person.getId()).
				orElseThrow(() -> new ResourceNofFoundException("No records found for this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var vo =  DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
		
	}	
	
	public void delete(Long id) {
		
		Person entity = repository.findById(id).
				orElseThrow(() -> new ResourceNofFoundException("No records found for this ID"));
		repository.delete(entity);	
		
	}	
	public List<PersonVO> findAll() {

		return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
		
	}
	
	public PersonVO findById(Long id) {
		
		var entity = repository.findById(id).
				orElseThrow(() -> new ResourceNofFoundException("No records found for this ID"));
		return DozerConverter.parseObject(entity, PersonVO.class);
		
	}


	
}
