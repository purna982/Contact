package com.purna.stocks.webservices.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.purna.stocks.webservices.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{

	@Query("SELECT c FROM Contact c where c.name = :name") 
    List<Contact> findByName(@Param("name") String name);
	
	@Query("SELECT c FROM Contact c where c.organasation = :organasation") 
    List<Contact> findByOrgName(@Param("organasation") String organasation);
}
