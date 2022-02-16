package com.esprit.travel.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.utils.UUIDs;
import com.esprit.com.repositories.ReclamationRepository;
import com.esprit.travel.model.Reclamation;


@RestController
@RequestMapping("/reclamation")
public class ReclamationController {

	  @Autowired
	  ReclamationRepository recRepository;
	  
	  @GetMapping("/getAllReclamations")
	  public ResponseEntity<List<Reclamation>> getAllReclamations(@RequestParam(required = false) String subject) {
		  try {
			    List<Reclamation> reclamations = new ArrayList<Reclamation>();
			    if (subject == null)
			    	recRepository.findAll().forEach(reclamations::add);
			    else
			    	recRepository.findBySubject(subject).forEach(reclamations::add);
			    if (reclamations.isEmpty()) {
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    }
			    return new ResponseEntity<>(reclamations, HttpStatus.OK);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
		
	    
	  }
	  @GetMapping("/getReclamationById/{id}")
	  public ResponseEntity<Reclamation> getReclamationById(@PathVariable("id") UUID id) {
		  Optional<Reclamation> tutorialData = recRepository.findById(id);
		  if (tutorialData.isPresent()) {
		    return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	    
	  }
	  @PostMapping("/createReclamation")
	  public ResponseEntity<Reclamation> createReclamation(@RequestBody Reclamation recl) {
		  try {
			    Reclamation _tutorial = recRepository.save(new Reclamation(recl.getId(), recl.getSubject(), recl.getDescription()));
			    return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	    
	  }
	  @PutMapping("/updateReclamation/{id}")
	  public ResponseEntity<Reclamation> updateReclamation(@PathVariable("id") UUID id, @RequestBody Reclamation tutorial) {
		    Optional<Reclamation> reclData = recRepository.findById(id);
		    if (reclData.isPresent()) {
		      Reclamation _rec = reclData.get();
		      _rec.setDescription(tutorial.getSubject());
		      _rec.setDescription(tutorial.getDescription());
		      _rec.setSubject(tutorial.getSubject());
		      return new ResponseEntity<>(recRepository.save(_rec), HttpStatus.OK);
		    } else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
			
		  }


	  @DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteReclamation(@PathVariable("id") UUID id) {
		  try {
			  recRepository.deleteById(id);
			    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  } catch (Exception e) {
			    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	    
	  }
	  @DeleteMapping("/deleteAll")
	  public ResponseEntity<HttpStatus> deleteAllReclamations() {
		  try {
			  recRepository.deleteAll();
			    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  } catch (Exception e) {
			    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }
	  
	  @GetMapping("/reclamations/{id}")
	  public ResponseEntity<Reclamation> getReclamationlById(@PathVariable("id") UUID id) {
	    Optional<Reclamation> tutorialData = recRepository.findById(id);
	    if (tutorialData.isPresent()) {
	      return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

}