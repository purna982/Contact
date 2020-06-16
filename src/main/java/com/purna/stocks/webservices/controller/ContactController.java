package com.purna.stocks.webservices.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.purna.stocks.webservices.exception.ContactNotFoundException;
import com.purna.stocks.webservices.model.Contact;
import com.purna.stocks.webservices.repo.ContactRepository;

@RestController
public class ContactController {

    @Autowired
    private ContactRepository repo;
    
    @GetMapping("/contacts")
    public List < Contact > getContacts() {
        return repo.findAll();
    }
    
    @PostMapping("/addContact")
    public Contact createContact(@Valid @RequestBody Contact contact) {
        return repo.save(contact);
    }
    
    @PutMapping("/contact/{id}")
    public ResponseEntity < Contact > updateContact(
        @PathVariable(value = "id") Integer id,
        @Valid @RequestBody Contact details) throws ContactNotFoundException {
        Contact c = repo.findById(id) 
            .orElseThrow(() -> new ContactNotFoundException("Contact not found :: " + id));
        c.setName(details.getName());
        c.setOrganasation(details.getOrganasation());
        c.setPhoneNumber(c.getPhoneNumber());
        c.setAddress(c.getAddress());
        final Contact updatedContact = repo.save(c);
        return ResponseEntity.ok(updatedContact);
    }

    @DeleteMapping("/contact/{id}")
    public Map < String, Boolean > deleteContact(
        @PathVariable(value = "id") Integer id) throws ContactNotFoundException {
        Contact c = repo.findById(id)
            .orElseThrow(() -> new ContactNotFoundException("Contact not found :: " + id));

        repo.delete(c);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
    @GetMapping("/searchByName/{name}")
    public ResponseEntity <List<Contact>> getContactByName(
    		@PathVariable(value = "name") String name) {
    	return ResponseEntity.ok(repo.findByName(name));
    }
    
    @GetMapping("/searchByOrg/{organasation}")
    public ResponseEntity <List<Contact>> getContactByOrgName(
    		@PathVariable(value = "organasation") String organasation) {
    	return ResponseEntity.ok(repo.findByOrgName(organasation));
    }

	
}
