package tn.esprit.spring.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import tn.esprit.spring.entities.Entreprise;

public interface EntrepriseRepository extends CassandraRepository<Entreprise,Integer>  {
	
	
}
