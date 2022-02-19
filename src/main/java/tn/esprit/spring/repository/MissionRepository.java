package tn.esprit.spring.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Mission;


public interface MissionRepository extends CassandraRepository<Mission, Integer> {

}
