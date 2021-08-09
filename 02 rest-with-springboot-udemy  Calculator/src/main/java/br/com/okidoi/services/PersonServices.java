package br.com.okidoi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.okidoi.model.Person;

@Service  //para que o SpringBoot cuida da injeção de dependencia dessa classe quando ela for usada em outra, não sendo necessário dar new em uma instancia desta classe
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();  //usado como id no banco de dados

	
	
	public Person create(Person person) {
		
		return person;
	}
	
	public Person update(Person person) {
		
		return person;
	}	
	
	public void delete(String id) {
		
	}	
		
	
	public Person findById(String id) {
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Marcio");
		person.setLastName("Okidoi");
		person.setAddress("Avenida Paulista 2073, São Paulo - SP - Brasil");
		person.setGender("Male");
		return person;
	}

	public List<Person> findAll() {

		List<Person> list = new ArrayList<Person>();
		
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Marcio");
		person.setLastName("Okidoi");
		person.setAddress("Avenida Paulista 2073, São Paulo - SP - Brasil");
		person.setGender("Male");
		
		list.add(person);
		
		Person person2 = new Person();
		person2.setId(counter.incrementAndGet());
		person2.setFirstName("Rafael");
		person2.setLastName("Barrros");
		person2.setAddress("Rua São Pedro, São Paulo - SP - Brasil");
		person2.setGender("Male");
		list.add(person2);
		
		Person person3 = new Person();
		person3.setId(counter.incrementAndGet());
		person3.setFirstName("Joana");
		person3.setLastName("Silva Santos");
		person3.setAddress("Rua Sargento Leito 32, Rio de Janeiro - RJ - Brasil");
		person3.setGender("Female");
		
		list.add(person3);
		
		return list;
		
	}
	
	
}
