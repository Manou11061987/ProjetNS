package com.esprit.travel.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.esprit.com.repositories.ReclamationRepository;
import com.esprit.travel.model.Reclamation;
@Service
public class ReclamationService {

	  @Autowired
	  ReclamationRepository recRepository;

	  List<Reclamation> findBydescription(String description){
		return null;
		  
	  }
//	  
//	  public Reclamation updateReclamation(@PathVariable("id") UUID id, @RequestBody Reclamation tutorial) {
//	    Optional<Reclamation> reclData = recRepository.findById(id);
//	    if (reclData.isPresent()) {
//	      Reclamation _rec = reclData.get();
//	      _rec.setDescription(tutorial.getDescription());
//	      _rec.setDatePushing(tutorial.getDatePushing());
//	      _rec.setSubject(tutorial.getSubject());
//	      return (recRepository.save(_rec));
//	    }
//		return tutorial; 
//	  }
}
