package br.com.okidoi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.okidoi.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	//Já projvê o save o delete e finds

}
